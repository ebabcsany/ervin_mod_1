package com.babcsany.minecraft.ervin_mod_1.entity;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.entity.EntityClassification;

public class ModEntityClassification {
    public static final EntityClassification ZUR = EntityClassification.create("ZUR", "zur", 40, true, true, 64);

    public static void register() {
        Ervin_mod_1.register(ModEntityClassification.class);
    }
}
