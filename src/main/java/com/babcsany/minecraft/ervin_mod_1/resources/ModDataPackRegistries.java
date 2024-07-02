package com.babcsany.minecraft.ervin_mod_1.resources;

import com.babcsany.minecraft.ervin_mod_1.command.ModCommands;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.command.Commands;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.loot.LootPredicateManager;
import net.minecraft.loot.LootTableManager;
import net.minecraft.resources.*;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.NetworkTagManager;
import net.minecraft.util.Unit;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ModDataPackRegistries extends DataPackRegistries {
    private static final CompletableFuture<Unit> field_240951_a_ = CompletableFuture.completedFuture(Unit.INSTANCE);
    private final IReloadableResourceManager resourceManager = new SimpleReloadableResourceManager(ResourcePackType.SERVER_DATA);
    private final Commands commands;
    private final RecipeManager recipeManager = new RecipeManager();
    private final NetworkTagManager tagManager = new NetworkTagManager();
    private final LootPredicateManager lootPredicateManager = new LootPredicateManager();
    private final LootTableManager lootTableManager = new LootTableManager(this.lootPredicateManager);
    private final AdvancementManager advancementManager = new AdvancementManager(this.lootPredicateManager);
    private final FunctionReloader functionReloader;

    public ModDataPackRegistries(Commands.EnvironmentType envType, int permissionsLevel) {
        super(envType, permissionsLevel);
        this.commands = new ModCommands(envType);
        this.functionReloader = new FunctionReloader(permissionsLevel, this.commands.getDispatcher());
        this.resourceManager.addReloadListener(this.tagManager);
        this.resourceManager.addReloadListener(this.lootPredicateManager);
        this.resourceManager.addReloadListener(this.recipeManager);
        this.resourceManager.addReloadListener(this.lootTableManager);
        this.resourceManager.addReloadListener(this.functionReloader);
        this.resourceManager.addReloadListener(this.advancementManager);
        net.minecraftforge.event.ForgeEventFactory.onResourceReload(this).forEach(resourceManager::addReloadListener);
    }

    public FunctionReloader getFunctionReloader() {
        return this.functionReloader;
    }

    public LootPredicateManager getLootPredicateManager() {
        return this.lootPredicateManager;
    }

    public LootTableManager getLootTableManager() {
        return this.lootTableManager;
    }

    public ITagCollectionSupplier func_244358_d() {
        return this.tagManager.getTagCollectionSupplier();
    }

    public RecipeManager getRecipeManager() {
        return this.recipeManager;
    }

    public Commands getCommandManager() {
        return this.commands;
    }

    public AdvancementManager getAdvancementManager() {
        return this.advancementManager;
    }

    public IResourceManager getResourceManager() {
        return this.resourceManager;
    }

    public static CompletableFuture<DataPackRegistries> func_240961_a_(List<IResourcePack> resourcePackList, Commands.EnvironmentType environmentType, int permissionsLevel, Executor backgroundExecutor, Executor gameExecutor) {
        ModDataPackRegistries dataPackRegistries = new ModDataPackRegistries(environmentType, permissionsLevel);
        CompletableFuture<Unit> completablefuture = dataPackRegistries.resourceManager.reloadResourcesAndThen(backgroundExecutor, gameExecutor, resourcePackList, field_240951_a_);
        return completablefuture.whenComplete((unit, throwable) -> {
            if (throwable != null) {
                dataPackRegistries.close();
            }

        }).thenApply((unit) -> dataPackRegistries);
    }

    public void updateTags() {
        this.tagManager.getTagCollectionSupplier().updateTags();
    }

    public void close() {
        this.resourceManager.close();
    }
}
