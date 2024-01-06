package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.entity.projectile.TawrolEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class EntityInit {

    public static EntityInit ENTITIES;

    public static final EntityType<TawrolEntity> TAWROL = register("tawrol", EntityType.Builder.<TawrolEntity>create(TawrolEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
    //public static final EntityType<SrachEntity> SRACH_ENTITY = register("srach", EntityType.Builder.create(SrachEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).func_233606_a_(12));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, string(key), builder.build(string(key)));
    }
}
