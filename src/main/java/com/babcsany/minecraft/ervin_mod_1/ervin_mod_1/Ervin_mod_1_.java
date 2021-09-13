package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1;

import com.babcsany.minecraft.client.particle.ParticleManager;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.EntityRendererManager;
import com.babcsany.minecraft.ervin_mod_1.entity.player.PlayerInventory;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.Ervin_mod_1_classes;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.block_colors.BlockColors;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.l_l.AbstractFurnaceTileEntity;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.ComposterBlock;
import com.babcsany.minecraft.ervin_mod_1.util.registries.modPainting_Type;
import com.babcsany.minecraft.ervin_mod_1.world.gen.FeatureGen;

public class Ervin_mod_1_ {

    static Ervin_mod_1_classes ervin_mod_1_classes;
    static PlayerInventory playerInventory;

    public static void Class(Class<?>... Class) {
        Class.clone();
    }

    public static void setup() {
        Class(EntityRendererManager.class);
        Class(ParticleManager.class);
    }

    public static void registries() {
        ComposterBlock.init();
        BlockColors.init();
    }

    public static void featureGen() {
        FeatureGen.generateFeature();
        FeatureGen.getSpawns();
    }

    public static void modRegistry() {
        modPainting_Type modPainting_type;
    }

    public static void defaultRegistries() {
        AbstractFurnaceTileEntity.getBurnTimes();
    }

    public static void ervin_mod_1_void() {
        Ervin_mod_1_classes.inventory_classes();
    }

    public static void ervin_mod_1_boolean() {
        //isUsableByPlayer(playerInventory);
    }

    public static boolean isUsableByPlayer(PlayerInventory playerInventory) {
        return playerInventory.isUsableByPlayer();
    }
}
