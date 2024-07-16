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
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit<T extends Entity> extends EntityType<T> {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ervin_mod_1.MOD_ID);

    public static final EntityType<Liwray> LIWRAY = register("liwray", EntityType.Builder.create(Liwray::new, EntityClassification.CREATURE).size(0.9f, 1.3f).trackingRange(10));
    public static final EntityType<GwurstEntity> GWURST = register("gwurst", EntityType.Builder.create(GwurstEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).immuneToFire());
    public static final EntityType<RoventEntity> ROVENT_ENTITY = register("rovent", EntityType.Builder.create(RoventEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).immuneToFire());
    public static final EntityType<GubrovEntity> GUBROV = register("gubrov", EntityType.Builder.create(GubrovEntity::new, EntityClassification.CREATURE).size(0.7f, 0.4f).trackingRange(10).immuneToFire());
//    public static final EntityType<TraderNirtre1Entity> TRADER_NIRTRE1_ENTITY = register("trader_nirtre1", EntityType.Builder.create(TraderNirtre1Entity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(8).immuneToFire());
    public static final EntityType<DrurbFishEntity> DGRURB = register("dgrurb", EntityType.Builder.create(DrurbFishEntity::new, EntityClassification.CREATURE).size(0.6f, 0.5f).trackingRange(8).immuneToFire());
    public static final EntityType<ZurEntity> ZUR = register("zur", EntityType.Builder.create(ZurEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10).immuneToFire());
//    public static final EntityType<ZurNirtreEntity> ZUR_NIRTRE_ENTITY = register("zur_nirtre", EntityType.Builder.create(ZurNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10).immuneToFire());
    public static final EntityType<FreinEntity> FREIN = register("frein", EntityType.Builder.create(FreinEntity::new, EntityClassification.MONSTER).size(1.0f, 3.0f).trackingRange(10));
    public static final EntityType<ViltEntity> VILT = register("vilt", EntityType.Builder.create(ViltEntity::new, EntityClassification.CREATURE).size(1.0f, 2.0f).trackingRange(10));
    public static final EntityType<ShertEntity> SHERT_ENTITY = register("srach/shert", EntityType.Builder.create(ShertEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).trackingRange(13));
    public static final EntityType<HhijEntity> HHIJ = register("hhij", EntityType.Builder.create(HhijEntity::new, EntityClassification.CREATURE).size(0.6f, 0.85f).trackingRange(20).immuneToFire());
    public static final EntityType<SrachEntity> SRACH_ENTITY = register("srach", EntityType.Builder.create(SrachEntity::new, EntityClassification.MISC).size(0.9f, 1.4f).trackingRange(8));
    public static final EntityType<SrechEntity> SRECH_ENTITY = register("srech", EntityType.Builder.create(SrechEntity::new, EntityClassification.MISC).size(0.9f, 1.4f).trackingRange(6));
    public static final EntityType<WanderingTraderNirtreEntity> WANDERING_TRADER_NIRTRE_ENTITY = register("wandering_trader_nirtre", EntityType.Builder.create(WanderingTraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F).trackingRange(12).immuneToFire());
    public static final EntityType<TraderNirtreEntity> TRADER_NIRTRE_ENTITY = register("trader_nirtre", EntityType.Builder.create(TraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(12).immuneToFire());
    public static final EntityType<$TraderEntity> $_TRADER = register("usd_trader", EntityType.Builder.create($TraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10));
    public static final EntityType<ZombieTraderEntity> ZOMBIE_TRADER_ENTITY = register("zombie_trader", EntityType.Builder.create(ZombieTraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10));
//    public static final EntityType<ZurEntity> NIRTRE_ENTITY = register("nirtre", EntityType.Builder.create(ZurEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).trackingRange(10));

    public EntityInit(EntityType.IFactory<T> factory, EntityClassification classification, boolean p_i231489_3_, boolean summonable, boolean immuneToFire, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize size, int trackingRange, int updateInterval) {
        super(factory, classification, p_i231489_3_, summonable, immuneToFire, p_i231489_6_, p_i231489_7_, size, trackingRange, updateInterval);
    }

    public EntityInit(EntityType.IFactory<T> factory, EntityClassification classification, boolean p_i231489_3_, boolean summonable, boolean immuneToFire, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize size, int trackingRange, int updateInterval, final java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier, final java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier, final java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier, final java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory) {
        super(factory, classification, p_i231489_3_, summonable, immuneToFire, p_i231489_6_, p_i231489_7_, size, trackingRange, updateInterval, velocityUpdateSupplier, trackingRangeSupplier, updateIntervalSupplier, customClientFactory);
    }

    @Deprecated
    public static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        String identifier = Ervin_mod_1.identifier(key);
        return Registry.register(Registry.ENTITY_TYPE, identifier, builder.build(new ResourceLocation(Ervin_mod_1.MOD_ID, key).toString()));
    }
}
