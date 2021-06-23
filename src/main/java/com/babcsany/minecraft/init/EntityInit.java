package com.babcsany.minecraft.init;

import com.babcsany.minecraft.entity.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.DgrurbSkullEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static EntityInit ENTITIES;

    public static final EntityType<ModBoatEntity> MOD_BOAT = register("ervin_mod_1:mod_boat", EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).func_233606_a_(10));
    public static final EntityType<GubrovEntity> GUBROV_ENTITY = register("ervin_mod_1:gubrov_entity", EntityType.Builder.create(GubrovEntity::new, EntityClassification.WATER_CREATURE).size(0.7f, 0.4f).func_233606_a_(10));
    public static final EntityType<ZurEntity> ZUR_ENTITY = register("ervin_mod_1:zur_entity", EntityType.Builder.<ZurEntity>create(ZurEntity::new, EntityClassification.CREATURE).size(0.6F, 1.90F).func_233606_a_(8).immuneToFire());
    public static final EntityType<DgrurbSkullEntity> DGRURB_SKULL = register("ervin_mod_1:dgrurb_skull", EntityType.Builder.<DgrurbSkullEntity>create(DgrurbSkullEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).func_233606_a_(4).func_233608_b_(10));


    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }
}
