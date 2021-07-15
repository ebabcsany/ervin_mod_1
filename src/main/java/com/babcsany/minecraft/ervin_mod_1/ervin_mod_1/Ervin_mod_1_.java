package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1;

import com.babcsany.minecraft.client.particle.ParticleManager;
import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.EntityRendererManager;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.Ervin_mod_1_classes;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.ComposterBlock;
import com.babcsany.minecraft.ervin_mod_1.item.crafting.RecipeSerializerInit;
import com.babcsany.minecraft.init.*;
import com.babcsany.minecraft.init.item.ItemInit;
import com.babcsany.minecraft.init.villager.VillagerProfessionInit;

public class Ervin_mod_1_ {

    public static void init() {
        Ervin_mod_1.function(BlockInit.class);
        Ervin_mod_1.function(BlockItemInit.class);
        Ervin_mod_1.function(EntityInit.class);
        Ervin_mod_1.function(ItemInit.class);
        Ervin_mod_1.function(FeatureInit.class);
        //Ervin_mod_1.function(StructureInit.class);
        Ervin_mod_1.function(FluidInit.class);
        Ervin_mod_1.function(EffectInit.class);
        Ervin_mod_1.function(ParticleInit.class);
        Ervin_mod_1.function(RecipeSerializerInit.class);
        Ervin_mod_1.function(VillagerProfessionInit.class);
        //Ervin_mod_1.function(DimensionInit.class);
        //Ervin_mod_1.function(DimensionTypeInit.class);
        //Ervin_mod_1.function(World.class);
    }

    public static void setup() {
        Ervin_mod_1.function(EntityRendererManager.class);
        Ervin_mod_1.function(ParticleManager.class);
    }

    public static void registries() {
        ComposterBlock.init();
    }

    public static void ervin_mod_1() {
        Ervin_mod_1_classes.inventory();
    }
}
