package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1;

import com.babcsany.minecraft.client.particle.ParticleManager;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.EntityRendererManager;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.Ervin_mod_1_classes;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.AbstractFurnaceTileEntity1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.ComposterBlock;

public class Ervin_mod_1_ {

    public static void Class(Class<?>... Class) {
        Class.clone();
    }

    public static void setup() {
        Class(EntityRendererManager.class);
        Class(ParticleManager.class);
        Class(AbstractFurnaceTileEntity1.class);
    }

    public static void registries() {
        ComposterBlock.init();
    }

    public static void ervin_mod_1() {
        Ervin_mod_1_classes.inventory();
        Ervin_mod_1_classes.world();
    }
}
