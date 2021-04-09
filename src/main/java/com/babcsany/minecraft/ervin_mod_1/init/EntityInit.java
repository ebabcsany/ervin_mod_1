package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.item.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.*;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.TawrolEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Ervin_mod_1.MOD_ID);

    public static final RegistryObject<EntityType<Liwray>> LIWRAY = ENTITY_TYPES
            .register("liwray",
                    () -> EntityType.Builder.create(Liwray::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()
                            ));
    public static final RegistryObject<EntityType<GwurstEntity>> GWURST = ENTITY_TYPES
            .register("gwurst",
                    () -> EntityType.Builder.create(GwurstEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()
                            ));
    public static final RegistryObject<EntityType<ZurEntity>> ZUR_ENTITY = ENTITY_TYPES
            .register("zur_entity",
                    () -> EntityType.Builder.<ZurEntity>create(ZurEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(8).immuneToFire()
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<Dgrurb>> DGRURB_ENTITY = ENTITY_TYPES
            .register("dgrurb",
                    () -> EntityType.Builder.<Dgrurb>create(Dgrurb::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(8).immuneToFire()
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/dgrurb").toString()
                            ));
    public static final RegistryObject<EntityType<RoventEntity>> ROVENT_ENTITY = ENTITY_TYPES
            .register("rovent_entity",
                    () -> EntityType.Builder.create(RoventEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10).immuneToFire()
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<ZurNirtreEntity>> ZUR_NIRTRE_ENTITY = ENTITY_TYPES
            .register("zur_nirtre_entity",
                    () -> EntityType.Builder.create(ZurNirtreEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<FreinEntity>> FREIN_ENTITY = ENTITY_TYPES
            .register("frein_entity",
                    () -> EntityType.Builder.create(FreinEntity::new, EntityClassification.CREATURE)
                            .size(1.0f, 3.0f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/frein_entity").toString()
                            ));
    public static final RegistryObject<EntityType<ViltEntity>> VILT_ENTITY = ENTITY_TYPES
            .register("vilt_entity",
                    () -> EntityType.Builder.create(ViltEntity::new, EntityClassification.CREATURE)
                            .size(1.0f, 2.0f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/crask").toString()
                            ));
    /*public static final RegistryObject<EntityType<ViltEntity1>> VILT_ENTITY1 = ENTITY_TYPES
            .register("vilt_entity1",
                    () -> EntityType.Builder.create(ViltEntity1::new, EntityClassification.CREATURE)
                            .size(1.0f, 2.0f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/crask").toString()
                            ));*/
    public static final RegistryObject<EntityType<SrachEntity>> SRACH_ENTITY = ENTITY_TYPES
            .register("srach_entity",
                    () -> EntityType.Builder.create(SrachEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.4f).func_233606_a_(12)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/srach").toString()
                            ));
    public static final RegistryObject<EntityType<ShertEntity>> SHERT_ENTITY = ENTITY_TYPES
            .register("shert_entity",
                    () -> EntityType.Builder.create(ShertEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.4f).func_233606_a_(13)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/shert").toString()
                            ));
    public static final RegistryObject<EntityType<Wolf1Entity>> HHIJ_ENTITY = ENTITY_TYPES
            .register("wolf1",
                    () -> EntityType.Builder.create(Wolf1Entity::new, EntityClassification.CREATURE)
                            .size(0.6f, 0.85f).func_233606_a_(20).immuneToFire()
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/shert").toString()
                            ));
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT_ENTITY = ENTITY_TYPES
            .register("boat",
                    () -> EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC)
                            .size(1.375F, 0.5625F).func_233606_a_(6)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/boat/firg").toString()
                            ));
    public static final RegistryObject<EntityType<WanderingTraderNirtreEntity>> WANDERING_TRADER_NIRTRE_ENTITY = ENTITY_TYPES
            .register("wandering_trader_nirtre_entity",
                    () -> EntityType.Builder.create(WanderingTraderNirtreEntity::new, EntityClassification.CREATURE)
                            .size(0.6F, 1.95F).func_233606_a_(12)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/wandering_trader_nirtre_entity").toString()
                            ));
    public static final RegistryObject<EntityType<TraderNirtreEntity>> TRADER_NIRTRE_ENTITY = ENTITY_TYPES
            .register("trader_nirtre_entity",
                    () -> EntityType.Builder.create(TraderNirtreEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(12).immuneToFire()
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<$TraderEntity>> $_TRADER_ENTITY = ENTITY_TYPES
            .register("$_trader_entity",
                    () -> EntityType.Builder.create($TraderEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/traders/$_trader").toString()
                            ));
    public static final RegistryObject<EntityType<ZombieTraderEntity>> ZOMBIE_TRADER_ENTITY = ENTITY_TYPES
            .register("zombie_trader_entity",
                    () -> EntityType.Builder.create(ZombieTraderEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation("entity/zombie/zombie").toString()
                            ));
    public static final RegistryObject<EntityType<GubrovEntity>> GUBROV_ENTITY = ENTITY_TYPES
            .register("gubrov_entity",
                    () -> EntityType.Builder.create(GubrovEntity::new, EntityClassification.WATER_CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/fish/gubrov").toString()
                            ));
    public static final RegistryObject<EntityType<SrechEntity>> SRECH_ENTITY = ENTITY_TYPES
            .register("srerch_entity",
                    () -> EntityType.Builder.create(SrechEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.4f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/srech").toString()
                            ));
    /*public static final RegistryObject<EntityType<TawrolEntity>> TAWROL_ENTITY = ENTITY_TYPES
            .register("tawrol",
                    () -> EntityType.Builder<TawrolEntity>.create(TawrolEntity::new, EntityClassification.MISC)
                            .size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "tawrol").toString()
                            ));
    /*public static final RegistryObject<EntityType<ThuvrujEntity>> THUVRUJ_ENTITY = ENTITY_TYPES
            .register("thuvruj_entity",
                    () -> EntityType.Builder.<ThuvrujEntity>create(ThuvrujEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.95f).func_233606_a_(10)
                            .build(new ResourceLocation("entity/zombie/zombie").toString()
                            ));*/
/*
    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITY_TYPES
            .register("example_entity",
                    () -> EntityType.Builder.<ExampleEntity>create(ExampleEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "example_entity").toString()
                            ));
*/
}
