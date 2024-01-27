package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.DrurgbkEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<EntityType<Liwray>> LIWRAY = ENTITY_TYPES.register("liwray", () -> EntityType.Builder.create(Liwray::new, EntityClassification.CREATURE).size(0.9f, 1.3f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()));
    public static final RegistryObject<EntityType<GwurstEntity>> GWURST = ENTITY_TYPES.register("gwurst", () -> EntityType.Builder.create(GwurstEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).func_233606_a_(10).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()));
    public static final RegistryObject<EntityType<RoventEntity>> ROVENT_ENTITY = ENTITY_TYPES.register("rovent", () -> EntityType.Builder.create(RoventEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).func_233606_a_(10).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/rovent_outer_layer.png").toString()));
    public static final RegistryObject<EntityType<GubrovEntity>> GUBROV = ENTITY_TYPES.register("gubrov", () -> EntityType.Builder.create(GubrovEntity::new, EntityClassification.CREATURE).size(0.7f, 0.4f).func_233606_a_(10).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity_1.png").toString()));
    public static final RegistryObject<EntityType<TraderNirtre1Entity>> TRADER_NIRTRE1_ENTITY = ENTITY_TYPES.register("trader_nirtre1_entity", () -> EntityType.Builder.create(TraderNirtre1Entity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(8).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/zur_entity").toString()));
    public static final RegistryObject<EntityType<DrurgbkEntity>> DRURB_ENTITY = ENTITY_TYPES.register("drurgbk", () -> EntityType.Builder.create(DrurgbkEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(8).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/drurgbk").toString()));
    public static final RegistryObject<EntityType<ZurEntity>> ZUR_ENTITY = ENTITY_TYPES.register("zur", () -> EntityType.Builder.create(ZurEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/zur_entity").toString()));
    public static final RegistryObject<EntityType<ZurNirtreEntity>> ZUR_NIRTRE_ENTITY = ENTITY_TYPES.register("zur_nirtre_entity", () -> EntityType.Builder.create(ZurNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/zur_nirtre").toString()));
    public static final RegistryObject<EntityType<FreinEntity>> FREIN_ENTITY = ENTITY_TYPES.register("frein_entity", () -> EntityType.Builder.create(FreinEntity::new, EntityClassification.CREATURE).size(1.0f, 3.0f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/frein_entity").toString()));
    public static final RegistryObject<EntityType<ViltEntity>> VILT_ENTITY = ENTITY_TYPES.register("vilt_entity", () -> EntityType.Builder.create(ViltEntity::new, EntityClassification.CREATURE).size(1.0f, 2.0f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/crask").toString()));
    public static final RegistryObject<EntityType<ShertEntity>> SHERT_ENTITY = ENTITY_TYPES.register("shert_entity", () -> EntityType.Builder.create(ShertEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).func_233606_a_(13).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/shert").toString()));
    public static final RegistryObject<EntityType<HhijEntity>> HHIJ_ENTITY = ENTITY_TYPES.register("hhij", () -> EntityType.Builder.create(HhijEntity::new, EntityClassification.CREATURE).size(0.6f, 0.85f).func_233606_a_(20).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/hhij").toString()));
    public static final RegistryObject<EntityType<BoatEntity>> MOD_BOAT_ENTITY = ENTITY_TYPES.register("boat", () -> EntityType.Builder.<BoatEntity>create(BoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).func_233606_a_(6).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/boat/firg").toString()));
    public static final RegistryObject<EntityType<SrachEntity>> SRACH_ENTITY = ENTITY_TYPES.register("srach", () -> EntityType.Builder.create(SrachEntity::new, EntityClassification.MISC).size(0.9f, 1.4f).func_233606_a_(6).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/srach/srach").toString()));
    //public static final RegistryObject<EntityType<TawrolEntity>> TAWROL = ENTITY_TYPES.register("tawrol", () -> EntityType.Builder.create(TawrolEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/tawrol").toString()));
    public static final RegistryObject<EntityType<WanderingTraderNirtreEntity>> WANDERING_TRADER_NIRTRE_ENTITY = ENTITY_TYPES.register("wandering_trader_nirtre_entity", () -> EntityType.Builder.create(WanderingTraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F).func_233606_a_(12).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/wandering_trader_nirtre_entity").toString()));
    public static final RegistryObject<EntityType<TraderNirtreEntity>> TRADER_NIRTRE_ENTITY = ENTITY_TYPES.register("trader_nirtre_entity", () -> EntityType.Builder.create(TraderNirtreEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(12).immuneToFire().build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/zur_entity").toString()));
    public static final RegistryObject<EntityType<$TraderEntity>> $_TRADER_ENTITY = ENTITY_TYPES.register("usd_trader_entity", () -> EntityType.Builder.create($TraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).build(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/traders/usd_trader").toString()));
    public static final RegistryObject<EntityType<ZombieTraderEntity>> ZOMBIE_TRADER_ENTITY = ENTITY_TYPES.register("zombie_trader_entity", () -> EntityType.Builder.create(ZombieTraderEntity::new, EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).build(new ResourceLocation("entity/zombie/zombie").toString()));


}
