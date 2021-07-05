package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1;

import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.EntityRendererManager;
import com.babcsany.minecraft.ervin_mod_1.item.crafting.RecipeSerializerInit;
import com.babcsany.minecraft.init.*;
import com.babcsany.minecraft.init.item.ItemInit;
import net.minecraftforge.fml.DeferredWorkQueue;

public class Ervin_mod_1_ {

    public static void init() {
        BlockInit BLOCKS = BlockInit.BLOCKS;
        BlockItemInit BLOCK_ITEMS = BlockItemInit.BLOCK_ITEMS;
        EntityInit ENTITIES = EntityInit.ENTITIES;
        ItemInit ITEMS = ItemInit.ITEMS;
        FeatureInit FEATURES = FeatureInit.FEATURES;
        //StructureInit<?> STRUCTURES = StructureInit.STRUCTURES;
        FluidInit FLUIDS = FluidInit.FLUIDS;
        RecipeSerializerInit<?> RECIPE_SERIALIZERS = RecipeSerializerInit.RECIPE_SERIALIZERS;
    }

    /*public static void setup() {
        EntityRendererManager ENTITY_RENDERER_MANAGER = EntityRendererManager.ENTITY_RENDERER_MANAGER;
    }*/
}
