package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.DrurbFishEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.ZombieTraderEntity;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit<T extends Entity> extends EntityType<T> {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<EntityType<Liwray>> LIWRAY = ENTITY_TYPES.register("liwray", () -> Builder.create(Liwray::new, EntityClassification.CREATURE).size(0.9f, 1.3f).trackingRange(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "liwray").toString()));
    public static final RegistryObject<EntityType<GwurstEntity>> GWURST;

    static {
        Builder<GwurstEntity> builder = Builder.create(GwurstEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).immuneToFire();
        GWURST = ENTITY_TYPES.register("gwurst", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "gwurst").toString()));
    }

    public static final RegistryObject<EntityType<RoventEntity>> ROVENT_ENTITY;

    static {
        Builder<RoventEntity> builder = Builder.create(RoventEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).immuneToFire();
        ROVENT_ENTITY = ENTITY_TYPES.register("rovent", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "rovent").toString()));
    }

    public static final RegistryObject<EntityType<GubrovEntity>> GUBROV;

    static {
        Builder<GubrovEntity> builder = Builder.create(GubrovEntity::new, EntityClassification.CREATURE).size(0.7f, 0.4f).trackingRange(10).immuneToFire();
        GUBROV = ENTITY_TYPES.register("gubrov", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "gubrov").toString()));
    }

    //    public static final RegistryObject<EntityType<TraderNirtre1Entity>> TRADER_NIRTRE1_ENTITY = register("trader_nirtre1", EntityType.Builder.create(TraderNirtre1Entity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(8).immuneToFire());
    public static final RegistryObject<EntityType<DrurbFishEntity>> DGRURB;

    static {
        Builder<DrurbFishEntity> builder = Builder.create(DrurbFishEntity::new, EntityClassification.CREATURE).size(0.6f, 0.5f).trackingRange(8).immuneToFire();
        DGRURB = ENTITY_TYPES.register("dgrurb", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "dgrurb").toString()));
    }

    public static final RegistryObject<EntityType<ZurEntity>> ZUR;

    static {
        Builder<ZurEntity> builder = Builder.create(ZurEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10).immuneToFire();
        ZUR = ENTITY_TYPES.register("zur", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur").toString()));
    }

    //    public static final RegistryObject<EntityType<ZurNirtreEntity> ZUR_NIRTRE_ENTITY = register("zur_nirtre", EntityType.Builder.create(ZurNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10).immuneToFire());
    public static final RegistryObject<EntityType<FreinEntity>> FREIN;

    static {
        Builder<FreinEntity> builder = Builder.create(FreinEntity::new, EntityClassification.MONSTER).size(1.0f, 3.0f).trackingRange(10);
        FREIN = ENTITY_TYPES.register("frein", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "frein").toString()));
    }

    public static final RegistryObject<EntityType<ViltEntity>> VILT;

    static {
        Builder<ViltEntity> builder = Builder.create(ViltEntity::new, EntityClassification.CREATURE).size(1.0f, 2.0f).trackingRange(10);
        VILT = ENTITY_TYPES.register("vilt", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "vilt").toString()));
    }

    public static final RegistryObject<EntityType<ShertEntity>> SHERT_ENTITY;

    static {
        Builder<ShertEntity> builder = Builder.create(ShertEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).trackingRange(13);
        SHERT_ENTITY = ENTITY_TYPES.register("srach/shert", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach/shert").toString()));
    }

    public static final RegistryObject<EntityType<HhijEntity>> HHIJ;

    static {
        Builder<HhijEntity> builder = Builder.create(HhijEntity::new, EntityClassification.CREATURE).size(0.6f, 0.85f).trackingRange(20).immuneToFire();
        HHIJ = ENTITY_TYPES.register("hhij", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "hhij").toString()));
    }

    public static final RegistryObject<EntityType<SrachEntity>> SRACH_ENTITY;

    static {
        Builder<SrachEntity> builder = Builder.create(SrachEntity::new, EntityClassification.MISC).size(0.9f, 1.4f).trackingRange(8);
        SRACH_ENTITY = ENTITY_TYPES.register("srach", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach").toString()));
    }

    public static final RegistryObject<EntityType<SrechEntity>> SRECH_ENTITY;

    static {
        Builder<SrechEntity> builder = Builder.create(SrechEntity::new, EntityClassification.MISC).size(0.9f, 1.4f).trackingRange(6);
        SRECH_ENTITY = ENTITY_TYPES.register("srech", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srech").toString()));
    }

    public static final RegistryObject<EntityType<WanderingTraderNirtreEntity>> WANDERING_TRADER_NIRTRE_ENTITY;

    static {
        Builder<WanderingTraderNirtreEntity> builder = Builder.create(WanderingTraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F).trackingRange(12).immuneToFire();
        WANDERING_TRADER_NIRTRE_ENTITY = ENTITY_TYPES.register("wandering_trader_nirtre", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "wandering_trader_nirtre").toString()));
    }

    public static final RegistryObject<EntityType<TraderNirtreEntity>> TRADER_NIRTRE_ENTITY;

    static {
        Builder<TraderNirtreEntity> builder = Builder.create(TraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(12).immuneToFire();
        TRADER_NIRTRE_ENTITY = ENTITY_TYPES.register("trader_nirtre", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "trader_nirtre").toString()));
    }

    public static final RegistryObject<EntityType<$TraderEntity>> $_TRADER;

    static {
        Builder<$TraderEntity> builder = Builder.create($TraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10);
        $_TRADER = ENTITY_TYPES.register("usd_trader", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "usd_trader").toString()));
    }

    public static final RegistryObject<EntityType<ZombieTraderEntity>> ZOMBIE_TRADER_ENTITY;

    static {
        Builder<ZombieTraderEntity> builder = Builder.create(ZombieTraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10);
        ZOMBIE_TRADER_ENTITY = ENTITY_TYPES.register("zombie_trader", () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zombie_trader").toString()));
    }
//    public static final RegistryObject<EntityType<ZurEntity>> NIRTRE_ENTITY = register("nirtre", EntityType.Builder.create(ZurEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10));

    public EntityInit(EntityType.IFactory<T> factory, EntityClassification classification, boolean p_i231489_3_, boolean summonable, boolean immuneToFire, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize size, int trackingRange, int updateInterval) {
        super(factory, classification, p_i231489_3_, summonable, immuneToFire, p_i231489_6_, p_i231489_7_, size, trackingRange, updateInterval);
    }

    public EntityInit(EntityType.IFactory<T> factory, EntityClassification classification, boolean p_i231489_3_, boolean summonable, boolean immuneToFire, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize size, int trackingRange, int updateInterval, final java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier, final java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier, final java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier, final java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory) {
        super(factory, classification, p_i231489_3_, summonable, immuneToFire, p_i231489_6_, p_i231489_7_, size, trackingRange, updateInterval, velocityUpdateSupplier, trackingRangeSupplier, updateIntervalSupplier, customClientFactory);
    }

    @Deprecated
    public static <T extends Entity> RegistryObject<EntityType<T>> register(String key, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(key, () -> builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, key).toString()));
    }
}
