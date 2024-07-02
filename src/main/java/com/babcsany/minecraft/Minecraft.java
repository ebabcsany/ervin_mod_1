package com.babcsany.minecraft;

import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.ModEntityRendererManager;
import com.mojang.datafixers.DataFixer;
import net.minecraft.client.GameConfiguration;
import net.minecraft.client.GameSettings;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.resources.SimpleReloadableResourceManager;
import net.minecraft.util.MinecraftVersion;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Minecraft extends net.minecraft.client.Minecraft {
    private final DataFixer dataFixer;
    private final IReloadableResourceManager resourceManager;
    private final GameSettings gameSettings;
//    private final EntityRendererManager renderManager;

    public Minecraft(GameConfiguration gameConfig) {
        super(gameConfig);
        this.dataFixer = null;
        this.resourceManager = new SimpleReloadableResourceManager(ResourcePackType.CLIENT_RESOURCES);
        this.gameSettings = new GameSettings(this, this.gameDir);
//        this.renderManager = new ModEntityRendererManager(this.getTextureManager(), this.getItemRenderer(), this.resourceManager, this.getRenderManager().getFontRenderer(), this.gameSettings);
//        MinecraftVersion.load();
//        this.ingameGUI.getChatGUI().getSentMessages().contains();
    }

    @Override
    public DataFixer getDataFixer() {
        return this.dataFixer;
    }

//    @Override
//    public EntityRendererManager getRenderManager() {
//        return this.renderManager;
//    }

    @Override
    public IResourceManager getResourceManager() {
        return this.resourceManager;
    }

    public GameSettings getGameSettings() {
        return this.gameSettings;
    }
}
