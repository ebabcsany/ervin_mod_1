package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk1;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.TawrolEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class EntityInit {

    public static EntityInit ENTITIES;

    public static final EntityType<TawrolEntity> TAWROL = register("tawrol", EntityType.Builder.<TawrolEntity>create(TawrolEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).trackingRange(4).updateInterval(10));
    public static final EntityType<Huihk> HUIHK = register("huihk", EntityType.Builder.<Huihk>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.25F, 0.25F).immuneToFire().trackingRange(4).updateInterval(5));
    public static final EntityType<ModBoatEntity> MOD_BOAT = register("mod_boat", EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).trackingRange(10));

    @Deprecated
    public static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, Ervin_mod_1.identifier(name), builder.build(Ervin_mod_1.identifier(name)));
    }
}
