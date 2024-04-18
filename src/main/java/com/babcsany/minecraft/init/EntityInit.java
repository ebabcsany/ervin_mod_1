package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.entity.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.TawrolEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.HuihkEntity;
import net.minecraft.util.registry.Registry;

public class EntityInit {

    public static EntityInit ENTITIES;

    public static final EntityType<TawrolEntity> TAWROL = register("tawrol", EntityType.Builder.<TawrolEntity>create(TawrolEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).trackingRange(4).updateInterval(10));
    //public static final EntityType<HuihkEntity> HUIHK = register("huihk", EntityType.Builder.<HuihkEntity>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.25F, 0.25F).trackingRange(4).updateInterval(5));
    public static final EntityType<ModBoatEntity> MOD_BOAT = register("mod_boat", EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).trackingRange(10));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static <T extends Entity> EntityType<T> register(String p_200712_0_, EntityType.Builder<T> p_200712_1_) {
        return (EntityType) Registry.register(Registry.ENTITY_TYPE, p_200712_0_, p_200712_1_.build(p_200712_0_));
    }
}
