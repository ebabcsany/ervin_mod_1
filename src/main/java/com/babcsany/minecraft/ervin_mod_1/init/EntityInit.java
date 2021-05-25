package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.item.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.*;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.HuihkEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Ervin_mod_1.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES1;

    public static final RegistryObject<EntityType<Liwray>> LIWRAY = ENTITY_TYPES.register("liwray", () -> EntityType.Builder.create(Liwray::new, EntityClassification.CREATURE).size(0.9f, 1.3f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()));
    //public static final EntityType<Liwray> LIWRAY = register("ervin_mod_1:liwray", EntityType.Builder.create(Liwray::new, EntityClassification.CREATURE).size(0.9f, 1.3f).func_233606_a_(10).immuneToFire());
    //public static final RegistryObject<EntityType<BlackLightningBoltEntity>> BLACK_LIGHTNING_BOLT = ENTITY_TYPES.register("black_lightning_bolt", () -> EntityType.Builder.create(BlackLightningBoltEntity::new, EntityClassification.MISC).size(0.0f, 0.0f).func_233606_a_(16).func_233608_b_(Integer.MAX_VALUE).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()));
    //public static final RegistryObject<EntityType<HuihkEntity>> HUIHK = ENTITY_TYPES.register("huihk", EntityType.Builder.<HuihkEntity>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.3F, 0.3F).func_233606_a_(4).func_233608_b_(5));
    public static final RegistryObject<EntityType<GwurstEntity>> GWURST = ENTITY_TYPES.register("gwurst", () -> EntityType.Builder.create(GwurstEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()));
    //public static final RegistryObject<EntityType<ZurEntity>> ZUR_ENTITY = ENTITY_TYPES.register("zur_entity", () -> createImmuneFireMobEntity(ZurEntity::new, EntityClassification.MONSTER, "zur_entity", 0.6f, 1.80f));
    public static final RegistryObject<EntityType<TraderNirtre1Entity>> TRADER_NIRTREP_ENTITY = ENTITY_TYPES.register("trader_nirtre1_entity", () -> EntityType.Builder.create(TraderNirtre1Entity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(8).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity").toString()));
    public static final RegistryObject<EntityType<Dgrurb>> DGRURB_ENTITY = ENTITY_TYPES.register("dgrurb", () -> EntityType.Builder.<Dgrurb>create(Dgrurb::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(8).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/dgrurb").toString()));
    public static final RegistryObject<EntityType<Dgrurbk>> DGRURBK_ENTITY = ENTITY_TYPES.register("dgrurbk", () -> EntityType.Builder.<Dgrurbk>create(Dgrurbk::new, EntityClassification.MONSTER).size(1.2f, 3.9f).func_233606_a_(16).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/dgrurbk").toString()));
    public static final RegistryObject<EntityType<RoventEntity>> ROVENT_ENTITY = ENTITY_TYPES.register("rovent_entity", () -> EntityType.Builder.create((RoventEntity::new), EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity").toString()));
    public static final RegistryObject<EntityType<ZurNirtreEntity>> ZUR_NIRTRE_ENTITY = ENTITY_TYPES.register("zur_nirtre_entity", () -> EntityType.Builder.create(ZurNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/zur_entity").toString()));
    public static final RegistryObject<EntityType<FreinEntity>> FREIN_ENTITY = ENTITY_TYPES.register("frein_entity", () -> EntityType.Builder.create(FreinEntity::new, EntityClassification.CREATURE).size(1.0f, 3.0f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/frein_entity").toString()));
    public static final RegistryObject<EntityType<ViltEntity>> VILT_ENTITY = ENTITY_TYPES.register("vilt_entity", () -> EntityType.Builder.create(ViltEntity::new, EntityClassification.CREATURE).size(1.0f, 2.0f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/crask").toString()));
    /*public static final RegistryObject<EntityType<ViltEntity1>> VILT_ENTITY1 = ENTITY_TYPES
            .register("vilt_entity1",
                    () -> EntityType.Builder.create(ViltEntity1::new, EntityClassification.CREATURE)
                            .size(1.0f, 2.0f).func_233606_a_(10)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/crask").toString()
                            ));*/
    public static final RegistryObject<EntityType<SrachEntity>> SRACH_ENTITY = ENTITY_TYPES.register("srach_entity", () -> EntityType.Builder.create(SrachEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).func_233606_a_(12).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/srach").toString()));
    public static final RegistryObject<EntityType<ShertEntity>> SHERT_ENTITY = ENTITY_TYPES.register("shert_entity", () -> EntityType.Builder.create(ShertEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).func_233606_a_(13).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/shert").toString()));
    public static final RegistryObject<EntityType<HhijEntity>> HHIJ_ENTITY = ENTITY_TYPES.register("hhij", () -> EntityType.Builder.create(HhijEntity::new, EntityClassification.CREATURE).size(0.6f, 0.85f).func_233606_a_(20).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/shert").toString()));
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT_ENTITY = ENTITY_TYPES
            .register("boat",
                    () -> EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC)
                            .size(1.375F, 0.5625F).func_233606_a_(6)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/boat/firg").toString()
                            ));
    public static final EntityType<ZurEntity> ZUR_ENTITY = register("ervin_mod_1:zur_entity", EntityType.Builder.<ZurEntity>create(/*(type, worldIn) -> new ZurEntity(type, worldIn)*/ZurEntity::new, EntityClassification.CREATURE).size(0.6F, 1.90F).func_233606_a_(8).immuneToFire());
    public static final RegistryObject<EntityType<WanderingTraderNirtreEntity>> WANDERING_TRADER_NIRTRE_ENTITY = ENTITY_TYPES.register("wandering_trader_nirtre_entity", () -> EntityType.Builder.create(WanderingTraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F).func_233606_a_(12).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/wandering_trader_nirtre_entity").toString()));
    public static final RegistryObject<EntityType<TraderNirtreEntity>> TRADER_NIRTRE_ENTITY = ENTITY_TYPES.register("trader_nirtre_entity", () -> EntityType.Builder.create(TraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(12).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/zur_entity").toString()));
    public static final RegistryObject<EntityType<$TraderEntity>> $_TRADER_ENTITY = ENTITY_TYPES.register("$_trader_entity", () -> EntityType.Builder.create($TraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/traders/$_trader").toString()));
    public static final RegistryObject<EntityType<ZombieTraderEntity>> ZOMBIE_TRADER_ENTITY = ENTITY_TYPES.register("zombie_trader_entity", () -> EntityType.Builder.create(ZombieTraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).build(new ResourceLocation("entity/zombie/zombie").toString()));
    public static final RegistryObject<EntityType<GubrovEntity>> GUBROV_ENTITY = ENTITY_TYPES.register("gubrov_entity", () -> EntityType.Builder.create(GubrovEntity::new, EntityClassification.WATER_CREATURE).size(0.6f, 1.95f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/fish/gubrov").toString()));
    //public static final RegistryObject<EntityType<SrechEntity>> SRECH_ENTITY = ENTITY_TYPES1.register("srerch_entity", () -> EntityType.Builder.create(SrechEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/srech").toString()));
    /*public static final RegistryObject<EntityType<TawrolEntity>> TAWROL_ENTITY = ENTITY_TYPES
            .register("tawrol",
                    () -> EntityType.Builder.<TawrolEntity>create(TawrolEntity::new, (EntityClassification.MISC)
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

    public static void registerEntityPlacementLogics() {
        EntitySpawnPlacementRegistry.register(LIWRAY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(GWURST.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(GUBROV_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(HHIJ_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HhijAnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(ROVENT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RoventEntity::canRoventSpawn);
        EntitySpawnPlacementRegistry.register(SHERT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(SRACH_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(ZUR_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractZurEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WANDERING_TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
    }

    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }

    private static <T extends LivingEntity> EntityType<T> createLivingEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height) {
        ResourceLocation location = new ResourceLocation("ervin_mod_1", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).func_233606_a_(10).build(location.toString());
        return entity;
    }

    private static <T extends MobEntity> EntityType<T> createMobEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height) {
        ResourceLocation location = new ResourceLocation("ervin_mod_1", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).func_233606_a_(10).build(location.toString());
        return entity;
    }

    private static <T extends MobEntity> EntityType<T> createImmuneFireMobEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height) {
        ResourceLocation location = new ResourceLocation("ervin_mod_1", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).func_233606_a_(10).immuneToFire().build(location.toString());
        return entity;
    }

    private static <T extends ZurEntity> EntityType<T> createZurEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height) {
        ResourceLocation location = new ResourceLocation("ervin_mod_1", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).func_233606_a_(10).immuneToFire().build(location.toString());
        return entity;
    }

    private static <T extends Entity> EntityType<T> createEntity(EntityType.IFactory<T> factory, BiFunction<FMLPlayMessages.SpawnEntity, World, T> clientFactory, EntityClassification entityClassification, String name, float width, float height) {
        ResourceLocation location = new ResourceLocation("ervin_mod_1", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).setCustomClientFactory(clientFactory).build(location.toString());
        return entity;
    }

    private static <T extends LivingEntity> EntityType<T> createLivingNetherEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height) {
        ResourceLocation location = new ResourceLocation("ervin_mod_1", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).func_225435_d().build(location.toString());
        return entity;
    }

    /*static {
        ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, "ervin_mod_1");
        DGRURB_ENTITY = ENTITY_TYPES.register("dgrurb", () -> createLivingEntity(Dgrurb::new, EntityClassification.MONSTER, "dgrurb", 0.9f, 1.95f));
        LIWRAY = ENTITY_TYPES.register("liwray", () -> createLivingEntity(Liwray::new, EntityClassification.CREATURE, "liwray", 0.9f, 1.3f));
        GUBROV_ENTITY = ENTITY_TYPES.register("gubrov_entity", () -> createLivingEntity(GubrovEntity::new, EntityClassification.WATER_CREATURE, "gubrov_entity", 0.6f, 1.95f));
        GWURST = ENTITY_TYPES.register("gwurst", () -> createLivingEntity(GwurstEntity::new, EntityClassification.CREATURE, "gwurst", 0.4F, 0.7F));
        ZUR_ENTITY = ENTITY_TYPES.register("zur_entity", () -> createImmuneFireMobEntity(ZurEntity::new, EntityClassification.MONSTER, "zur_entity", 0.6f, 1.95f));
        WANDERING_TRADER_NIRTRE_ENTITY = ENTITY_TYPES.register("wandering_trader_nirtre_entity", () -> createImmuneFireMobEntity(WanderingTraderNirtreEntity::new, EntityClassification.CREATURE, "wandering_trader_nirtre_entity", 0.6f, 1.95f));
    }*/
    static {
        ENTITY_TYPES1 = DeferredRegister.create(ForgeRegistries.ENTITIES, "ervin_mod_1");
    }

    //public static final EntityType<ZurEntity> ZUR_ENTITY = register("ervin_mod_1:zur_entity", EntityType.Builder.<ZurEntity>create(/*(type, worldIn) -> new ZurEntity(type, worldIn)*/ZurEntity::new, EntityClassification.CREATURE).size(0.6F, 1.90F).func_233606_a_(8).immuneToFire());

}
