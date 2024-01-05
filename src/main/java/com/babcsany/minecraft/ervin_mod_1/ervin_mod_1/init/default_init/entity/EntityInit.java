package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.entity;

import com.babcsany.minecraft.init.special.PaintingEntityInit;
import net.minecraft.entity.EntityType;

public class EntityInit {

    public EntityInit(EntityType<?> entities) {
        register(entities);
    }

    public void register(EntityType<?> entities) {
        com.babcsany.minecraft.init.EntityInit.ENTITIES = entities;
        PaintingEntityInit.PAINTING_ENTITIES = entities;
    }
}
