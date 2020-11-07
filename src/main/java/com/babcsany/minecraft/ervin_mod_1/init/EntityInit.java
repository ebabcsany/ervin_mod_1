package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.ScrakthsPearlEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.ZombieTraderEntity;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Supplier;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Ervin_mod_1.MOD_ID);

    public static final RegistryObject<EntityType<ZurEntity1>> ZUR_ENTITY1 = ENTITY_TYPES
            .register("zur_entity_1",
                    () -> EntityType.Builder.<ZurEntity1>create(ZurEntity1::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity_1").toString()
                            ));
    public static final RegistryObject<EntityType<ZurEntity>> ZUR_ENTITY = ENTITY_TYPES
            .register("zur_entity",
                    () -> EntityType.Builder.<ZurEntity>create(ZurEntity::new, EntityClassification.MONSTER).immuneToFire()
                            .size(0.6f, 1.95f).func_233606_a_(8)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<RoventEntity>> ROVENT_ENTITY = ENTITY_TYPES
            .register("rovent_entity",
                    () -> EntityType.Builder.<RoventEntity>create(RoventEntity::new, EntityClassification.MONSTER).immuneToFire()
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<ZurNirtreEntity>> ZUR_NIRTRE_ENTITY = ENTITY_TYPES
            .register("zur_nirtre_entity",
                    () -> EntityType.Builder.<ZurNirtreEntity>create(ZurNirtreEntity::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<FreinEntity>> FREIN_ENTITY = ENTITY_TYPES
            .register("frein_entity",
                    () -> EntityType.Builder.<FreinEntity>create(FreinEntity::new, EntityClassification.CREATURE)
                            .size(1.0f, 3.0f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "frein_entity").toString()
                            ));
    public static final RegistryObject<EntityType<ViltEntity>> VILT_ENTITY = ENTITY_TYPES
            .register("vilt_entity",
                    () -> EntityType.Builder.<ViltEntity>create(ViltEntity::new, EntityClassification.CREATURE)
                            .size(1.0f, 2.0f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "crask").toString()
                            ));
    public static final RegistryObject<EntityType<SrachEntity>> SRACH_ENTITY = ENTITY_TYPES
            .register("srach_entity",
                    () -> EntityType.Builder.<SrachEntity>create(SrachEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.4f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach/srach").toString()
                            ));
    public static final RegistryObject<EntityType<ShertEntity>> SHERT_ENTITY = ENTITY_TYPES
            .register("shert_entity",
                    () -> EntityType.Builder.<ShertEntity>create(ShertEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.4f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach/shert").toString()
                            ));
    public static final RegistryObject<EntityType<WolfEntity1>> HHIJ_ENTITY = ENTITY_TYPES
            .register("wolf1",
                    () -> EntityType.Builder.<WolfEntity1>create(WolfEntity1::new, EntityClassification.CREATURE)
                            .size(0.6f, 0.85f).func_233606_a_(20)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach/shert").toString()
                            ));
    public static final RegistryObject<EntityType<WanderingTraderNirtreEntity>> WANDERING_TRADER_NIRTRE_ENTITY = ENTITY_TYPES
            .register("wandering_trader_nirtre_entity",
                    () -> EntityType.Builder.<WanderingTraderNirtreEntity>create(WanderingTraderNirtreEntity::new, EntityClassification.CREATURE)
                            .size(0.6F, 1.95F).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "wandering_trader_nirtre_entity").toString()
                            ));
    public static final RegistryObject<EntityType<TraderNirtreEntity>> TRADER_NIRTRE_ENTITY = ENTITY_TYPES
            .register("trader_nirtre_entity",
                    () -> EntityType.Builder.<TraderNirtreEntity>create(TraderNirtreEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<$TraderEntity>> $_TRADER_ENTITY = ENTITY_TYPES
            .register("$_trader_entity",
                    () -> EntityType.Builder.<$TraderEntity>create($TraderEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "steve1").toString()
                            ));
    public static final RegistryObject<EntityType<ZombieTraderEntity>> ZOMBIE_TRADER_ENTITY = ENTITY_TYPES
            .register("zombie_trader_entity",
                    () -> EntityType.Builder.<ZombieTraderEntity>create(ZombieTraderEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation("zombie/zombie").toString()
                            ));

}
