package net.minecraft.entity;

import com.babcsany.minecraft.entity.ModBoatEntity;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.*;
import net.minecraft.entity.item.minecart.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.passive.horse.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;

public class EntityType<T extends Entity> extends net.minecraftforge.registries.ForgeRegistryEntry<EntityType<?>> {
   private static final Logger LOGGER = LogManager.getLogger();
   public static final EntityType<AreaEffectCloudEntity> AREA_EFFECT_CLOUD = register("area_effect_cloud", Builder.<AreaEffectCloudEntity>create(AreaEffectCloudEntity::new, EntityClassification.MISC).immuneToFire().size(6.0F, 0.5F).func_233606_a_(10).func_233608_b_(Integer.MAX_VALUE));
   public static final EntityType<ArmorStandEntity> ARMOR_STAND = register("armor_stand", Builder.<ArmorStandEntity>create(ArmorStandEntity::new, EntityClassification.MISC).size(0.5F, 1.975F).func_233606_a_(10));
   public static final EntityType<ArrowEntity> ARROW = register("arrow", Builder.<ArrowEntity>create(ArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(4).func_233608_b_(20));
   public static final EntityType<BatEntity> BAT = register("bat", Builder.<BatEntity>create(BatEntity::new, EntityClassification.AMBIENT).size(0.5F, 0.9F).func_233606_a_(5));
   public static final EntityType<BeeEntity> BEE = register("bee", Builder.<BeeEntity>create(BeeEntity::new, EntityClassification.CREATURE).size(0.7F, 0.6F).func_233606_a_(8));
   public static final EntityType<BlazeEntity> BLAZE = register("blaze", Builder.<BlazeEntity>create(BlazeEntity::new, EntityClassification.MONSTER).immuneToFire().size(0.6F, 1.8F).func_233606_a_(8));
   public static final EntityType<BoatEntity> BOAT = register("boat", Builder.<BoatEntity>create(BoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).func_233606_a_(10));
   public static final EntityType<CatEntity> CAT = register("cat", Builder.<CatEntity>create(CatEntity::new, EntityClassification.CREATURE).size(0.6F, 0.7F).func_233606_a_(8));
   public static final EntityType<CaveSpiderEntity> CAVE_SPIDER = register("cave_spider", Builder.<CaveSpiderEntity>create(CaveSpiderEntity::new, EntityClassification.MONSTER).size(0.7F, 0.5F).func_233606_a_(8));
   public static final EntityType<ChickenEntity> CHICKEN = register("chicken", Builder.<ChickenEntity>create(ChickenEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).func_233606_a_(10));
   public static final EntityType<CodEntity> COD = register("cod", Builder.<CodEntity>create(CodEntity::new, EntityClassification.WATER_AMBIENT).size(0.5F, 0.3F).func_233606_a_(4));
   public static final EntityType<CowEntity> COW = register("cow", Builder.<CowEntity>create(CowEntity::new, EntityClassification.CREATURE).size(0.9F, 1.4F).func_233606_a_(10));
   public static final EntityType<CreeperEntity> CREEPER = register("creeper", Builder.<CreeperEntity>create(CreeperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.7F).func_233606_a_(8));
   public static final EntityType<DolphinEntity> DOLPHIN = register("dolphin", Builder.<DolphinEntity>create(DolphinEntity::new, EntityClassification.WATER_CREATURE).size(0.9F, 0.6F));
   public static final EntityType<DonkeyEntity> DONKEY = register("donkey", Builder.<DonkeyEntity>create(DonkeyEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.5F).func_233606_a_(10));
   public static final EntityType<DragonFireballEntity> DRAGON_FIREBALL = register("dragon_fireball", Builder.<DragonFireballEntity>create(DragonFireballEntity::new, EntityClassification.MISC).size(1.0F, 1.0F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<DrownedEntity> DROWNED = register("drowned", Builder.<DrownedEntity>create(DrownedEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<ElderGuardianEntity> ELDER_GUARDIAN = register("elder_guardian", Builder.<ElderGuardianEntity>create(ElderGuardianEntity::new, EntityClassification.MONSTER).size(1.9975F, 1.9975F).func_233606_a_(10));
   public static final EntityType<EnderCrystalEntity> END_CRYSTAL = register("end_crystal", Builder.<EnderCrystalEntity>create(EnderCrystalEntity::new, EntityClassification.MISC).size(2.0F, 2.0F).func_233606_a_(16).func_233608_b_(Integer.MAX_VALUE));
   public static final EntityType<EnderDragonEntity> ENDER_DRAGON = register("ender_dragon", Builder.<EnderDragonEntity>create(EnderDragonEntity::new, EntityClassification.MONSTER).immuneToFire().size(16.0F, 8.0F).func_233606_a_(10));
   public static final EntityType<EndermanEntity> ENDERMAN = register("enderman", Builder.<EndermanEntity>create(EndermanEntity::new, EntityClassification.MONSTER).size(0.6F, 2.9F).func_233606_a_(8));
   public static final EntityType<EndermiteEntity> ENDERMITE = register("endermite", Builder.<EndermiteEntity>create(EndermiteEntity::new, EntityClassification.MONSTER).size(0.4F, 0.3F).func_233606_a_(8));
   public static final EntityType<EvokerEntity> EVOKER = register("evoker", Builder.<EvokerEntity>create(EvokerEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<EvokerFangsEntity> EVOKER_FANGS = register("evoker_fangs", Builder.<EvokerFangsEntity>create(EvokerFangsEntity::new, EntityClassification.MISC).size(0.5F, 0.8F).func_233606_a_(6).func_233608_b_(2));
   public static final EntityType<ExperienceOrbEntity> EXPERIENCE_ORB = register("experience_orb", Builder.<ExperienceOrbEntity>create(ExperienceOrbEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(6).func_233608_b_(20));
   public static final EntityType<EyeOfEnderEntity> EYE_OF_ENDER = register("eye_of_ender", Builder.<EyeOfEnderEntity>create(EyeOfEnderEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(4));
   public static final EntityType<FallingBlockEntity> FALLING_BLOCK = register("falling_block", Builder.<FallingBlockEntity>create(FallingBlockEntity::new, EntityClassification.MISC).size(0.98F, 0.98F).func_233606_a_(10).func_233608_b_(20));
   public static final EntityType<FireworkRocketEntity> FIREWORK_ROCKET = register("firework_rocket", Builder.<FireworkRocketEntity>create(FireworkRocketEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<FoxEntity> FOX = register("fox", Builder.<FoxEntity>create(FoxEntity::new, EntityClassification.CREATURE).size(0.6F, 0.7F).func_233606_a_(8).func_233607_a_(Blocks.SWEET_BERRY_BUSH));
   public static final EntityType<GhastEntity> GHAST = register("ghast", Builder.<GhastEntity>create(GhastEntity::new, EntityClassification.MONSTER).immuneToFire().size(4.0F, 4.0F).func_233606_a_(10));
   public static final EntityType<GiantEntity> GIANT = register("giant", Builder.<GiantEntity>create(GiantEntity::new, EntityClassification.MONSTER).size(3.6F, 12.0F).func_233606_a_(10));
   public static final EntityType<GuardianEntity> GUARDIAN = register("guardian", Builder.<GuardianEntity>create(GuardianEntity::new, EntityClassification.MONSTER).size(0.85F, 0.85F).func_233606_a_(8));
   public static final EntityType<HoglinEntity> HOGLIN = register("hoglin", Builder.<HoglinEntity>create(HoglinEntity::new, EntityClassification.MONSTER).size(1.3964844F, 1.4F).func_233606_a_(8));
   public static final EntityType<HorseEntity> HORSE = register("horse", Builder.<HorseEntity>create(HorseEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).func_233606_a_(10));
   public static final EntityType<HuskEntity> HUSK = register("husk", Builder.<HuskEntity>create(HuskEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<IllusionerEntity> ILLUSIONER = register("illusioner", Builder.<IllusionerEntity>create(IllusionerEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<IronGolemEntity> IRON_GOLEM = register("iron_golem", Builder.<IronGolemEntity>create(IronGolemEntity::new, EntityClassification.MISC).size(1.4F, 2.7F).func_233606_a_(10));
   public static final EntityType<ItemEntity> ITEM = register("item", Builder.<ItemEntity>create(ItemEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(6).func_233608_b_(20));
   public static final EntityType<ItemFrameEntity> ITEM_FRAME = register("item_frame", Builder.<ItemFrameEntity>create(ItemFrameEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(10).func_233608_b_(Integer.MAX_VALUE));
   public static final EntityType<FireballEntity> FIREBALL = register("fireball", Builder.<FireballEntity>create(FireballEntity::new, EntityClassification.MISC).size(1.0F, 1.0F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<LeashKnotEntity> LEASH_KNOT = register("leash_knot", Builder.<LeashKnotEntity>create(LeashKnotEntity::new, EntityClassification.MISC).disableSerialization().size(0.5F, 0.5F).func_233606_a_(10).func_233608_b_(Integer.MAX_VALUE));
   public static final EntityType<LightningBoltEntity> LIGHTNING_BOLT = register("lightning_bolt", Builder.<LightningBoltEntity>create(LightningBoltEntity::new, EntityClassification.MISC).disableSerialization().size(0.0F, 0.0F).func_233606_a_(16).func_233608_b_(Integer.MAX_VALUE));
   public static final EntityType<LlamaEntity> LLAMA = register("llama", Builder.<LlamaEntity>create(LlamaEntity::new, EntityClassification.CREATURE).size(0.9F, 1.87F).func_233606_a_(10));
   public static final EntityType<LlamaSpitEntity> LLAMA_SPIT = register("llama_spit", Builder.<LlamaSpitEntity>create(LlamaSpitEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<MagmaCubeEntity> MAGMA_CUBE = register("magma_cube", Builder.<MagmaCubeEntity>create(MagmaCubeEntity::new, EntityClassification.MONSTER).immuneToFire().size(2.04F, 2.04F).func_233606_a_(8));
   public static final EntityType<MinecartEntity> MINECART = register("minecart", Builder.<MinecartEntity>create(MinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).func_233606_a_(8));
   public static final EntityType<ChestMinecartEntity> CHEST_MINECART = register("chest_minecart", Builder.<ChestMinecartEntity>create(ChestMinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).func_233606_a_(8));
   public static final EntityType<CommandBlockMinecartEntity> COMMAND_BLOCK_MINECART = register("command_block_minecart", Builder.<CommandBlockMinecartEntity>create(CommandBlockMinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).func_233606_a_(8));
   public static final EntityType<FurnaceMinecartEntity> FURNACE_MINECART = register("furnace_minecart", Builder.<FurnaceMinecartEntity>create(FurnaceMinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).func_233606_a_(8));
   public static final EntityType<HopperMinecartEntity> HOPPER_MINECART = register("hopper_minecart", Builder.<HopperMinecartEntity>create(HopperMinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).func_233606_a_(8));
   public static final EntityType<SpawnerMinecartEntity> SPAWNER_MINECART = register("spawner_minecart", Builder.<SpawnerMinecartEntity>create(SpawnerMinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).func_233606_a_(8));
   public static final EntityType<TNTMinecartEntity> TNT_MINECART = register("tnt_minecart", Builder.<TNTMinecartEntity>create(TNTMinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).func_233606_a_(8));
   public static final EntityType<MuleEntity> MULE = register("mule", Builder.<MuleEntity>create(MuleEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).func_233606_a_(8));
   public static final EntityType<MooshroomEntity> MOOSHROOM = register("mooshroom", Builder.<MooshroomEntity>create(MooshroomEntity::new, EntityClassification.CREATURE).size(0.9F, 1.4F).func_233606_a_(10));
   public static final EntityType<OcelotEntity> OCELOT = register("ocelot", Builder.<OcelotEntity>create(OcelotEntity::new, EntityClassification.CREATURE).size(0.6F, 0.7F).func_233606_a_(10));
   public static final EntityType<PaintingEntity> PAINTING = register("painting", Builder.<PaintingEntity>create(PaintingEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(10).func_233608_b_(Integer.MAX_VALUE));
   public static final EntityType<PandaEntity> PANDA = register("panda", Builder.<PandaEntity>create(PandaEntity::new, EntityClassification.CREATURE).size(1.3F, 1.25F).func_233606_a_(10));
   public static final EntityType<ParrotEntity> PARROT = register("parrot", Builder.<ParrotEntity>create(ParrotEntity::new, EntityClassification.CREATURE).size(0.5F, 0.9F).func_233606_a_(8));
   public static final EntityType<PhantomEntity> PHANTOM = register("phantom", Builder.<PhantomEntity>create(PhantomEntity::new, EntityClassification.MONSTER).size(0.9F, 0.5F).func_233606_a_(8));
   public static final EntityType<PigEntity> PIG = register("pig", Builder.<PigEntity>create(PigEntity::new, EntityClassification.CREATURE).size(0.9F, 0.9F).func_233606_a_(10));
   public static final EntityType<PiglinEntity> PIGLIN = register("piglin", Builder.<PiglinEntity>create(PiglinEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<PillagerEntity> PILLAGER = register("pillager", Builder.<PillagerEntity>create(PillagerEntity::new, EntityClassification.MONSTER).func_225435_d().size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<PolarBearEntity> POLAR_BEAR = register("polar_bear", Builder.<PolarBearEntity>create(PolarBearEntity::new, EntityClassification.CREATURE).size(1.4F, 1.4F).func_233606_a_(10));
   public static final EntityType<TNTEntity> TNT = register("tnt", Builder.<TNTEntity>create(TNTEntity::new, EntityClassification.MISC).immuneToFire().size(0.98F, 0.98F).func_233606_a_(10).func_233608_b_(10));
   public static final EntityType<PufferfishEntity> PUFFERFISH = register("pufferfish", Builder.<PufferfishEntity>create(PufferfishEntity::new, EntityClassification.WATER_AMBIENT).size(0.7F, 0.7F).func_233606_a_(4));
   public static final EntityType<RabbitEntity> RABBIT = register("rabbit", Builder.<RabbitEntity>create(RabbitEntity::new, EntityClassification.CREATURE).size(0.4F, 0.5F).func_233606_a_(8));
   public static final EntityType<RavagerEntity> RAVAGER = register("ravager", Builder.<RavagerEntity>create(RavagerEntity::new, EntityClassification.MONSTER).size(1.95F, 2.2F).func_233606_a_(10));
   public static final EntityType<SalmonEntity> SALMON = register("salmon", Builder.<SalmonEntity>create(SalmonEntity::new, EntityClassification.WATER_AMBIENT).size(0.7F, 0.4F).func_233606_a_(4));
   public static final EntityType<SheepEntity> SHEEP = register("sheep", Builder.<SheepEntity>create(SheepEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F).func_233606_a_(10));
   public static final EntityType<ShulkerEntity> SHULKER = register("shulker", Builder.<ShulkerEntity>create(ShulkerEntity::new, EntityClassification.MONSTER).immuneToFire().func_225435_d().size(1.0F, 1.0F).func_233606_a_(10));
   public static final EntityType<ShulkerBulletEntity> SHULKER_BULLET = register("shulker_bullet", Builder.<ShulkerBulletEntity>create(ShulkerBulletEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).func_233606_a_(8));
   public static final EntityType<SilverfishEntity> SILVERFISH = register("silverfish", Builder.<SilverfishEntity>create(SilverfishEntity::new, EntityClassification.MONSTER).size(0.4F, 0.3F).func_233606_a_(8));
   public static final EntityType<SkeletonEntity> SKELETON = register("skeleton", Builder.<SkeletonEntity>create(SkeletonEntity::new, EntityClassification.MONSTER).size(0.6F, 1.99F).func_233606_a_(8));
   public static final EntityType<SkeletonHorseEntity> SKELETON_HORSE = register("skeleton_horse", Builder.<SkeletonHorseEntity>create(SkeletonHorseEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).func_233606_a_(10));
   public static final EntityType<SlimeEntity> SLIME = register("slime", Builder.<SlimeEntity>create(SlimeEntity::new, EntityClassification.MONSTER).size(2.04F, 2.04F).func_233606_a_(10));
   public static final EntityType<SmallFireballEntity> SMALL_FIREBALL = register("small_fireball", Builder.<SmallFireballEntity>create(SmallFireballEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<SnowGolemEntity> SNOW_GOLEM = register("snow_golem", Builder.<SnowGolemEntity>create(SnowGolemEntity::new, EntityClassification.MISC).size(0.7F, 1.9F).func_233606_a_(8));
   public static final EntityType<SnowballEntity> SNOWBALL = register("snowball", Builder.<SnowballEntity>create(SnowballEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<SpectralArrowEntity> SPECTRAL_ARROW = register("spectral_arrow", Builder.<SpectralArrowEntity>create(SpectralArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(4).func_233608_b_(20));
   public static final EntityType<SpiderEntity> SPIDER = register("spider", Builder.<SpiderEntity>create(SpiderEntity::new, EntityClassification.MONSTER).size(1.4F, 0.9F).func_233606_a_(8));
   public static final EntityType<SquidEntity> SQUID = register("squid", Builder.<SquidEntity>create(SquidEntity::new, EntityClassification.WATER_CREATURE).size(0.8F, 0.8F).func_233606_a_(8));
   public static final EntityType<StrayEntity> STRAY = register("stray", Builder.<StrayEntity>create(StrayEntity::new, EntityClassification.MONSTER).size(0.6F, 1.99F).func_233606_a_(8));
   public static final EntityType<StriderEntity> STRIDER = register("strider", Builder.<StriderEntity>create(StriderEntity::new, EntityClassification.CREATURE).immuneToFire().size(0.9F, 1.7F).func_233606_a_(10));
   public static final EntityType<EggEntity> EGG = register("egg", Builder.<EggEntity>create(EggEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<EnderPearlEntity> ENDER_PEARL = register("ender_pearl", Builder.<EnderPearlEntity>create(EnderPearlEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<ExperienceBottleEntity> EXPERIENCE_BOTTLE = register("experience_bottle", Builder.<ExperienceBottleEntity>create(ExperienceBottleEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<PotionEntity> POTION = register("potion", Builder.<PotionEntity>create(PotionEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<TridentEntity> TRIDENT = register("trident", Builder.<TridentEntity>create(TridentEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(4).func_233608_b_(20));
   public static final EntityType<TraderLlamaEntity> TRADER_LLAMA = register("trader_llama", Builder.<TraderLlamaEntity>create(TraderLlamaEntity::new, EntityClassification.CREATURE).size(0.9F, 1.87F).func_233606_a_(10));
   public static final EntityType<TropicalFishEntity> TROPICAL_FISH = register("tropical_fish", Builder.<TropicalFishEntity>create(TropicalFishEntity::new, EntityClassification.WATER_AMBIENT).size(0.5F, 0.4F).func_233606_a_(4));
   public static final EntityType<TurtleEntity> TURTLE = register("turtle", Builder.<TurtleEntity>create(TurtleEntity::new, EntityClassification.CREATURE).size(1.2F, 0.4F).func_233606_a_(10));
   public static final EntityType<VexEntity> VEX = register("vex", Builder.<VexEntity>create(VexEntity::new, EntityClassification.MONSTER).immuneToFire().size(0.4F, 0.8F).func_233606_a_(8));
   public static final EntityType<VillagerEntity> VILLAGER = register("villager", Builder.<VillagerEntity>create(VillagerEntity::new, EntityClassification.MISC).size(0.6F, 1.95F).func_233606_a_(10));
   public static final EntityType<VindicatorEntity> VINDICATOR = register("vindicator", Builder.<VindicatorEntity>create(VindicatorEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<WanderingTraderEntity> WANDERING_TRADER = register("wandering_trader", Builder.<WanderingTraderEntity>create(WanderingTraderEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F).func_233606_a_(10));
   public static final EntityType<WitchEntity> WITCH = register("witch", Builder.<WitchEntity>create(WitchEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<WitherEntity> WITHER = register("wither", Builder.<WitherEntity>create(WitherEntity::new, EntityClassification.MONSTER).immuneToFire().func_233607_a_(Blocks.WITHER_ROSE).size(0.9F, 3.5F).func_233606_a_(10));
   public static final EntityType<WitherSkeletonEntity> WITHER_SKELETON = register("wither_skeleton", Builder.<WitherSkeletonEntity>create(WitherSkeletonEntity::new, EntityClassification.MONSTER).immuneToFire().func_233607_a_(Blocks.WITHER_ROSE).size(0.7F, 2.4F).func_233606_a_(8));
   public static final EntityType<WitherSkullEntity> WITHER_SKULL = register("wither_skull", Builder.<WitherSkullEntity>create(WitherSkullEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).func_233606_a_(4).func_233608_b_(10));
   public static final EntityType<WolfEntity> WOLF = register("wolf", Builder.<WolfEntity>create(WolfEntity::new, EntityClassification.CREATURE).size(0.6F, 0.85F).func_233606_a_(10));
   public static final EntityType<ZoglinEntity> ZOGLIN = register("zoglin", Builder.<ZoglinEntity>create(ZoglinEntity::new, EntityClassification.MONSTER).immuneToFire().size(1.3964844F, 1.4F).func_233606_a_(8));
   public static final EntityType<ZombieEntity> ZOMBIE = register("zombie", Builder.<ZombieEntity>create(ZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<ZombieHorseEntity> ZOMBIE_HORSE = register("zombie_horse", Builder.<ZombieHorseEntity>create(ZombieHorseEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).func_233606_a_(10));
   public static final EntityType<ZombieVillagerEntity> ZOMBIE_VILLAGER = register("zombie_villager", Builder.<ZombieVillagerEntity>create(ZombieVillagerEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<ZombifiedPiglinEntity> ZOMBIFIED_PIGLIN = register("zombified_piglin", Builder.<ZombifiedPiglinEntity>create(ZombifiedPiglinEntity::new, EntityClassification.MONSTER).immuneToFire().size(0.6F, 1.95F).func_233606_a_(8));
   public static final EntityType<PlayerEntity> PLAYER = register("player", Builder.<PlayerEntity>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.6F, 1.8F).func_233606_a_(32).func_233608_b_(2));
   public static final EntityType<FishingBobberEntity> FISHING_BOBBER = register("fishing_bobber", Builder.<FishingBobberEntity>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(5));
   private final IFactory<T> factory;
   private final EntityClassification classification;
   private final ImmutableSet<Block> field_233593_bg_;
   private final boolean serializable;
   private final boolean summonable;
   private final boolean immuneToFire;
   private final boolean field_225438_be;
   private final int defaultTrackingRange;
   private final int defaultUpdateInterval;
   @Nullable
   private String translationKey;
   @Nullable
   private ITextComponent name;
   @Nullable
   private ResourceLocation lootTable;
   private final EntitySize size;

   private final java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier;
   private final java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier;
   private final java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier;
   private final java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory;
   private final net.minecraftforge.common.util.ReverseTagWrapper<EntityType<?>> reverseTags = new net.minecraftforge.common.util.ReverseTagWrapper<>(this, net.minecraft.tags.EntityTypeTags::getCollection);

   private static <T extends Entity> EntityType<T> register(String key, Builder<T> builder) {
      return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
   }

   public static ResourceLocation getKey(EntityType<?> entityTypeIn) {
      return Registry.ENTITY_TYPE.getKey(entityTypeIn);
   }

   /**
    * Tries to get the entity type assosiated by the key.
    */
   public static Optional<EntityType<?>> byKey(String key) {
      return Registry.ENTITY_TYPE.getValue(ResourceLocation.tryCreate(key));
   }

   public EntityType(IFactory<T> p_i231489_1_, EntityClassification p_i231489_2_, boolean p_i231489_3_, boolean p_i231489_4_, boolean p_i231489_5_, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize p_i231489_8_, int trackingRange, int updateInterval) {
       this(p_i231489_1_, p_i231489_2_, p_i231489_3_, p_i231489_4_, p_i231489_5_, p_i231489_6_, p_i231489_7_, p_i231489_8_, trackingRange, updateInterval, EntityType::defaultVelocitySupplier, EntityType::defaultTrackingRangeSupplier, EntityType::defaultUpdateIntervalSupplier, null);
   }
   public EntityType(IFactory<T> p_i231489_1_, EntityClassification p_i231489_2_, boolean p_i231489_3_, boolean p_i231489_4_, boolean p_i231489_5_, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize p_i231489_8_, int trackingRange, int updateInterval, final java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier, final java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier, final java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier, final java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory) {
      this.factory = p_i231489_1_;
      this.classification = p_i231489_2_;
      this.field_225438_be = p_i231489_6_;
      this.serializable = p_i231489_3_;
      this.summonable = p_i231489_4_;
      this.immuneToFire = p_i231489_5_;
      this.field_233593_bg_ = p_i231489_7_;
      this.size = p_i231489_8_;
      this.defaultTrackingRange = trackingRange;
      this.defaultUpdateInterval = updateInterval;
      this.velocityUpdateSupplier = velocityUpdateSupplier;
      this.trackingRangeSupplier = trackingRangeSupplier;
      this.updateIntervalSupplier = updateIntervalSupplier;
      this.customClientFactory = customClientFactory;
   }

   @Nullable
   public Entity spawn(World worldIn, @Nullable ItemStack stack, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220331_6_, boolean p_220331_7_) {
      return this.spawn(worldIn, stack == null ? null : stack.getTag(), stack != null && stack.hasDisplayName() ? stack.getDisplayName() : null, playerIn, pos, reason, p_220331_6_, p_220331_7_);
   }

   @Nullable
   public T spawn(World worldIn, @Nullable CompoundNBT compound, @Nullable ITextComponent customName, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220342_7_, boolean p_220342_8_) {
      T t = this.create(worldIn, compound, customName, playerIn, pos, reason, p_220342_7_, p_220342_8_);
      if (t instanceof MobEntity && net.minecraftforge.event.ForgeEventFactory.doSpecialSpawn((MobEntity) t, worldIn, pos.getX(), pos.getY(), pos.getZ(), null, reason)) return null;
      worldIn.addEntity(t);
      return t;
   }

   @Nullable
   public T create(World worldIn, @Nullable CompoundNBT compound, @Nullable ITextComponent customName, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220349_7_, boolean p_220349_8_) {
      T t = this.create(worldIn);
      if (t == null) {
         return (T)null;
      } else {
         double d0;
         if (p_220349_7_) {
            t.setPosition((double)pos.getX() + 0.5D, (double)(pos.getY() + 1), (double)pos.getZ() + 0.5D);
            d0 = func_208051_a(worldIn, pos, p_220349_8_, t.getBoundingBox());
         } else {
            d0 = 0.0D;
         }

         t.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
         if (t instanceof MobEntity) {
            MobEntity mobentity = (MobEntity)t;
            mobentity.rotationYawHead = mobentity.rotationYaw;
            mobentity.renderYawOffset = mobentity.rotationYaw;
            mobentity.onInitialSpawn(worldIn, worldIn.getDifficultyForLocation(mobentity.getPosition()), reason, (ILivingEntityData)null, compound);
            mobentity.playAmbientSound();
         }

         if (customName != null && t instanceof LivingEntity) {
            t.setCustomName(customName);
         }

         applyItemNBT(worldIn, playerIn, t, compound);
         return t;
      }
   }

   protected static double func_208051_a(IWorldReader worldReader, BlockPos pos, boolean p_208051_2_, AxisAlignedBB p_208051_3_) {
      AxisAlignedBB axisalignedbb = new AxisAlignedBB(pos);
      if (p_208051_2_) {
         axisalignedbb = axisalignedbb.expand(0.0D, -1.0D, 0.0D);
      }

      Stream<VoxelShape> stream = worldReader.func_234867_d_((Entity)null, axisalignedbb, (entity) -> {
         return true;
      });
      return 1.0D + VoxelShapes.getAllowedOffset(Direction.Axis.Y, p_208051_3_, stream, p_208051_2_ ? -2.0D : -1.0D);
   }

   public static void applyItemNBT(World worldIn, @Nullable PlayerEntity player, @Nullable Entity spawnedEntity, @Nullable CompoundNBT itemNBT) {
      if (itemNBT != null && itemNBT.contains("EntityTag", 10)) {
         MinecraftServer minecraftserver = worldIn.getServer();
         if (minecraftserver != null && spawnedEntity != null) {
            if (worldIn.isRemote || !spawnedEntity.ignoreItemEntityData() || player != null && minecraftserver.getPlayerList().canSendCommands(player.getGameProfile())) {
               CompoundNBT compoundnbt = spawnedEntity.writeWithoutTypeId(new CompoundNBT());
               UUID uuid = spawnedEntity.getUniqueID();
               compoundnbt.merge(itemNBT.getCompound("EntityTag"));
               spawnedEntity.setUniqueId(uuid);
               spawnedEntity.read(compoundnbt);
            }
         }
      }
   }

   public boolean isSerializable() {
      return this.serializable;
   }

   public boolean isSummonable() {
      return this.summonable;
   }

   public boolean isImmuneToFire() {
      return this.immuneToFire;
   }

   public boolean func_225437_d() {
      return this.field_225438_be;
   }

   public EntityClassification getClassification() {
      return this.classification;
   }

   public String getTranslationKey() {
      if (this.translationKey == null) {
         this.translationKey = Util.makeTranslationKey("entity", Registry.ENTITY_TYPE.getKey(this));
      }

      return this.translationKey;
   }

   public ITextComponent getName() {
      if (this.name == null) {
         this.name = new TranslationTextComponent(this.getTranslationKey());
      }

      return this.name;
   }

   public String toString() {
      return this.getTranslationKey();
   }

   public ResourceLocation getLootTable() {
      if (this.lootTable == null) {
         ResourceLocation resourcelocation = Registry.ENTITY_TYPE.getKey(this);
         this.lootTable = new ResourceLocation(resourcelocation.getNamespace(), "entities/" + resourcelocation.getPath());
      }

      return this.lootTable;
   }

   public float getWidth() {
      return this.size.width;
   }

   public float getHeight() {
      return this.size.height;
   }

   @Nullable
   public T create(World worldIn) {
      return this.factory.create(this, worldIn);
   }

   @Nullable
   @OnlyIn(Dist.CLIENT)
   public static Entity create(int id, World worldIn) {
      return create(worldIn, Registry.ENTITY_TYPE.getByValue(id));
   }

   public static Optional<Entity> loadEntityUnchecked(CompoundNBT compound, World worldIn) {
      return Util.acceptOrElse(readEntityType(compound).map((entityType) -> {
         return entityType.create(worldIn);
      }), (entity) -> {
         entity.read(compound);
      }, () -> {
         LOGGER.warn("Skipping Entity with id {}", (Object)compound.getString("id"));
      });
   }

   @Nullable
   @OnlyIn(Dist.CLIENT)
   private static Entity create(World worldIn, @Nullable EntityType<?> type) {
      return type == null ? null : type.create(worldIn);
   }

   public AxisAlignedBB getBoundingBoxWithSizeApplied(double p_220328_1_, double p_220328_3_, double p_220328_5_) {
      float f = this.getWidth() / 2.0F;
      return new AxisAlignedBB(p_220328_1_ - (double)f, p_220328_3_, p_220328_5_ - (double)f, p_220328_1_ + (double)f, p_220328_3_ + (double)this.getHeight(), p_220328_5_ + (double)f);
   }

   public boolean func_233597_a_(BlockState p_233597_1_) {
      if (this.field_233593_bg_.contains(p_233597_1_.getBlock())) {
         return false;
      } else if (this.immuneToFire || !p_233597_1_.isIn(BlockTags.FIRE) && !p_233597_1_.isIn(Blocks.MAGMA_BLOCK) && !CampfireBlock.isLit(p_233597_1_) && !p_233597_1_.isIn(Blocks.LAVA)) {
         return p_233597_1_.isIn(Blocks.WITHER_ROSE) || p_233597_1_.isIn(Blocks.SWEET_BERRY_BUSH) || p_233597_1_.isIn(Blocks.CACTUS);
      } else {
         return true;
      }
   }

   public EntitySize getSize() {
      return this.size;
   }

   public static Optional<EntityType<?>> readEntityType(CompoundNBT compound) {
      return Registry.ENTITY_TYPE.getValue(new ResourceLocation(compound.getString("id")));
   }

   @Nullable
   public static Entity loadEntityAndExecute(CompoundNBT compound, World worldIn, Function<Entity, Entity> p_220335_2_) {
      return loadEntity(compound, worldIn).map(p_220335_2_).map((p_220346_3_) -> {
         if (compound.contains("Passengers", 9)) {
            ListNBT listnbt = compound.getList("Passengers", 10);

            for(int i = 0; i < listnbt.size(); ++i) {
               Entity entity = loadEntityAndExecute(listnbt.getCompound(i), worldIn, p_220335_2_);
               if (entity != null) {
                  entity.startRiding(p_220346_3_, true);
               }
            }
         }

         return p_220346_3_;
      }).orElse((Entity)null);
   }

   private static Optional<Entity> loadEntity(CompoundNBT compound, World worldIn) {
      try {
         return loadEntityUnchecked(compound, worldIn);
      } catch (RuntimeException runtimeexception) {
         LOGGER.warn("Exception loading entity: ", (Throwable)runtimeexception);
         return Optional.empty();
      }
   }

   public int func_233602_m_() {
      return trackingRangeSupplier.applyAsInt(this);
   }
   private int defaultTrackingRangeSupplier() {
      return this.defaultTrackingRange;
   }

   public int getUpdateFrequency() {
      return updateIntervalSupplier.applyAsInt(this);
   }
   private int defaultUpdateIntervalSupplier() {
      return this.defaultUpdateInterval;
   }

   public boolean shouldSendVelocityUpdates() {
      return velocityUpdateSupplier.test(this);
   }
   private boolean defaultVelocitySupplier() {
      return this != PLAYER && this != LLAMA_SPIT && this != WITHER && this != BAT && this != ITEM_FRAME && this != LEASH_KNOT && this != PAINTING && this != END_CRYSTAL && this != EVOKER_FANGS;
   }

   /**
    * Checks if this entity type is contained in the tag
    */
   public boolean isContained(ITag<EntityType<?>> tagIn) {
      return tagIn.contains(this);
   }

   public T customClientSpawn(net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity packet, World world) {
       if (customClientFactory == null) return this.create(world);
       return customClientFactory.apply(packet, world);
   }

   /**
    * Retrieves a list of tags names this is known to be associated with.
    * This should be used in favor of TagCollection.getOwningTags, as this caches the result and automatically updates when the TagCollection changes.
    */
   public java.util.Set<ResourceLocation> getTags() {
       return reverseTags.getTagNames();
   }

   public static class Builder<T extends Entity> {
      private final IFactory<T> factory;
      private final EntityClassification classification;
      private ImmutableSet<Block> field_233603_c_ = ImmutableSet.of();
      private boolean serializable = true;
      private boolean summonable = true;
      private boolean immuneToFire;
      private boolean field_225436_f;
      private int field_233604_h_ = 5;
      private int field_233605_i_ = 3;
      private EntitySize size = EntitySize.flexible(0.6F, 1.8F);

      private java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier = EntityType::defaultVelocitySupplier;
      private java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier = EntityType::defaultTrackingRangeSupplier;
      private java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier = EntityType::defaultUpdateIntervalSupplier;
      private java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory;

      public Builder(IFactory<T> factoryIn, EntityClassification classificationIn) {
         this.factory = factoryIn;
         this.classification = classificationIn;
         this.field_225436_f = classificationIn == EntityClassification.CREATURE || classificationIn == EntityClassification.MISC;
      }

      public static <T extends Entity> Builder<T> create(IFactory<T> factoryIn, EntityClassification classificationIn) {
         return new Builder<>(factoryIn, classificationIn);
      }

      public static <T extends Entity> Builder<T> create(EntityClassification classificationIn) {
         return new Builder<>((type, world) -> {
            return (T)null;
         }, classificationIn);
      }

      public Builder<T> size(float width, float height) {
         this.size = EntitySize.flexible(width, height);
         return this;
      }

      public Builder<T> disableSummoning() {
         this.summonable = false;
         return this;
      }

      public Builder<T> disableSerialization() {
         this.serializable = false;
         return this;
      }

      public Builder<T> immuneToFire() {
         this.immuneToFire = true;
         return this;
      }

      public Builder<T> func_233607_a_(Block... p_233607_1_) {
         this.field_233603_c_ = ImmutableSet.copyOf(p_233607_1_);
         return this;
      }

      public Builder<T> func_225435_d() {
         this.field_225436_f = true;
         return this;
      }

      public Builder<T> func_233606_a_(int p_233606_1_) {
         this.field_233604_h_ = p_233606_1_;
         return this;
      }

      public Builder<T> func_233608_b_(int p_233608_1_) {
         this.field_233605_i_ = p_233608_1_;
         return this;
      }

      public Builder<T> setUpdateInterval(int interval) {
          this.updateIntervalSupplier = t->interval;
          return this;
      }

      public Builder<T> setTrackingRange(int range) {
          this.trackingRangeSupplier = t->range;
          return this;
      }

      public Builder<T> setShouldReceiveVelocityUpdates(boolean value) {
          this.velocityUpdateSupplier = t->value;
          return this;
      }

      /**
       * By default, entities are spawned clientside via {@link EntityType#create(World)}.
       * If you need finer control over the spawning process, use this to get read access to the spawn packet.
       */
      public Builder<T> setCustomClientFactory(java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory) {
          this.customClientFactory = customClientFactory;
          return this;
      }

      public EntityType<T> build(String id) {
         if (this.serializable) {
            Util.attemptDataFix(TypeReferences.ENTITY_TYPE, id);
         }

         return new EntityType<>(this.factory, this.classification, this.serializable, this.summonable, this.immuneToFire, this.field_225436_f, this.field_233603_c_, this.size, this.field_233604_h_, this.field_233605_i_, velocityUpdateSupplier, trackingRangeSupplier, updateIntervalSupplier, customClientFactory);
      }
   }

   public interface IFactory<T extends Entity> {
      T create(EntityType<T> p_create_1_, World p_create_2_);
   }
}
