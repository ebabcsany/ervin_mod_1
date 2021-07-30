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

    public static void init(Class<?>... class$) {
        class$.clone();
    }

    public static void setup() {
        init(EntityRendererManager.class);
        init(ParticleManager.class);
    }

    public static void registries() {
        ComposterBlock.init();
    }

    public static void ervin_mod_1() {
        Ervin_mod_1_classes.inventory();
        Ervin_mod_1_classes.world();
    }
}
