package com.babcsany.minecraft.ervin_mod_1.data;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.google.gson.JsonElement;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ModItemModelProvider extends ItemModelProvider {
    private final BiConsumer<ResourceLocation, Supplier<JsonElement>> consumer;
    
    public ModItemModelProvider(BiConsumer<ResourceLocation, Supplier<JsonElement>> consumer) {
        super(consumer);
        this.consumer = consumer;
    }

    private void resourceAndTexture(Item item, ModelsUtil util) {
        util.func_240234_a_(ModelsResourceUtil.func_240219_a_(item), ModelTextures.func_240352_b_(item), this.consumer);
    }

    private void resourceAndTexture(Item item, String name, ModelsUtil util) {
        util.func_240234_a_(ModelsResourceUtil.func_240220_a_(item, name), ModelTextures.func_240376_j_(ModelTextures.func_240344_a_(item, name)), this.consumer);
    }

    private void resourceAndTexture(Block block, String name, ModelsUtil util) {
        util.func_240234_a_(ModelsResourceUtil.func_240222_a_(block, name), ModelTextures.func_240376_j_(ModelTextures.func_240347_a_(block, name)), this.consumer);
    }

    private void resourceAndTexture(Item resourceItem, Item textureItem, ModelsUtil util) {
        util.func_240234_a_(ModelsResourceUtil.func_240219_a_(resourceItem), ModelTextures.func_240352_b_(textureItem), this.consumer);
    }

    @Override
    public void func_240074_a_() {
        super.func_240074_a_();

        for(int i = 1; i < 512; ++i) {
            this.resourceAndTexture(BlockInit.FIGHIV.get(), String.format("_%02d", i), StockModelShapes.CUBE_ALL);
            this.resourceAndTexture(BlockItemInit_.FIGHIV.get(), String.format("_%02d", i), StockModelShapes.CUBE_ALL);
        }
    }

    public static void register() {
        Ervin_mod_1.register(ModItemModelProvider.class);
    }
}
