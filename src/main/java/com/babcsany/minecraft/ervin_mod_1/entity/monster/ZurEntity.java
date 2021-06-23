package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.EatPumpkinGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.ZurTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.Dgrurb;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal.PlaceBlockGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal.TakeBlockGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.ZurTrades;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.world.storage.loot.LootTables1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Schedule;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.boss.dragon.phase.PhaseManager;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.loot.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.village.GossipManager;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ZurEntity extends AbstractZurEntity {
   private static final DataParameter<Boolean> field_234408_bu_ = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Optional<BlockState>> CARRIED_BLOCK = EntityDataManager.createKey(ZurEntity.class, DataSerializers.OPTIONAL_BLOCK_STATE);
   private static final DataParameter<Boolean> BABY = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   //private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(isBurnableFoodItemInit.TIRKS.get());
   private static final DataParameter<Boolean> field_213428_bH = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> field_213428_bG = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> field_213429_bH = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   protected static final DataParameter<Byte> TAMED = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BYTE);
   protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.createKey(ZurEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
   public static final Map<Item, Integer> FOOD_VALUES = ImmutableMap.of(Items.BREAD, 4, Items.POTATO, 1, Items.CARROT, 1, Items.BEETROOT, 1);
   //public static final DataParameter<Integer> PHASE = EntityDataManager.createKey(ZurEntity.class, DataSerializers.VARINT);
   private static final DataParameter<Boolean> field_234409_bv_ = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   public ServerPlayNetHandler connection;
   private byte foodLevel;
   public boolean isRemote;
   private long field_213783_bN;
   private boolean field_233683_bw_;
   private PhaseManager phaseManager;
   private final GossipManager gossip = new GossipManager();
   protected int growingAge;
   @Nullable
   public BlockPos zurTarget;
   public float destPos;
   @Nullable
   protected MerchantOffers offers;
   public final Inventory zurInventory = new Inventory(10000);
   private static final Predicate<ItemEntity> ITEMS = (p_213575_0_) -> {
      Item item = p_213575_0_.getItem().getItem();
      return (item == com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit.JURK.get().asItem() || item == Blocks.CAKE.asItem()) && p_213575_0_.isAlive() && !p_213575_0_.cannotPickup();
   };
   protected static final ImmutableList<SensorType<? extends Sensor<? super ZurEntity>>> field_234405_b_ = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS, SensorType.field_234129_b_, SensorType.HURT_BY, SensorType.INTERACTABLE_DOORS, SensorType.field_234130_l_);
   protected static final ImmutableList<MemoryModuleType<?>> field_234414_c_ = ImmutableList.of(MemoryModuleType.LOOK_TARGET, MemoryModuleType.INTERACTABLE_DOORS, MemoryModuleType.OPENED_DOORS, MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS, MemoryModuleType.NEAREST_ADULT_PIGLINS, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH, MemoryModuleType.ANGRY_AT, MemoryModuleType.UNIVERSAL_ANGER, MemoryModuleType.AVOID_TARGET, MemoryModuleType.ADMIRING_ITEM, MemoryModuleType.ADMIRING_DISABLED, MemoryModuleType.CELEBRATE_LOCATION, MemoryModuleType.DANCING, MemoryModuleType.HUNTED_RECENTLY, MemoryModuleType.NEAREST_VISIBLE_BABY_HOGLIN, MemoryModuleType.NEAREST_VISIBLE_BABY_PIGLIN, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED, MemoryModuleType.RIDE_TARGET, MemoryModuleType.VISIBLE_ADULT_PIGLIN_COUNT, MemoryModuleType.VISIBLE_ADULT_HOGLIN_COUNT, MemoryModuleType.NEAREST_VISIBLE_HUNTABLE_HOGLIN, MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD, MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM, MemoryModuleType.ATE_RECENTLY, MemoryModuleType.NEAREST_REPELLENT);
   private static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.HOME, MemoryModuleType.JOB_SITE, MemoryModuleType.POTENTIAL_JOB_SITE, MemoryModuleType.MEETING_POINT, MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.VISIBLE_VILLAGER_BABIES, MemoryModuleType.NEAREST_PLAYERS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleType.WALK_TARGET, MemoryModuleType.LOOK_TARGET, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.BREED_TARGET, MemoryModuleType.PATH, MemoryModuleType.INTERACTABLE_DOORS, MemoryModuleType.OPENED_DOORS, MemoryModuleType.NEAREST_BED, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.NEAREST_HOSTILE, MemoryModuleType.SECONDARY_JOB_SITE, MemoryModuleType.HIDING_PLACE, MemoryModuleType.HEARD_BELL_TIME, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.LAST_SLEPT, MemoryModuleType.LAST_WOKEN, MemoryModuleType.LAST_WORKED_AT_POI, MemoryModuleType.GOLEM_LAST_SEEN_TIME);
   private NearestAttackableTargetExpiringGoal<AbstractZurEntity> field_213694_bC;
   private int inWaterTime;
   private float crouchAmount;
   private float crouchAmountO;
   private int drownedConversionTime;

   public ZurEntity(EntityType<? extends ZurEntity> type, World worldIn) {
      super(type, worldIn);
      this.setCanPickUpLoot(true);
      this.experienceValue = 5;
      ((GroundPathNavigator)this.getNavigator()).setBreakDoors(true);
      this.setCombatTask();
   }

   public ZurEntity(World worldIn) {
      this(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, worldIn);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
      this.goalSelector.addGoal(3, new UseItemGoal<>(this, new ItemStack(SpecialBlockFoodItemInit.FIRG.get()), SoundEvents.AMBIENT_UNDERWATER_LOOP, (zur) -> this.world.isDaytime() && zur.isInvisible()));
      this.goalSelector.addGoal(3, new UseItemGoal<>(this, new ItemStack(isBurnableFoodItemInit.TIRKS.get()), SoundEvents.AMBIENT_UNDERWATER_LOOP, (zur) -> this.world.isDaytime() && zur.isInvisible()));
      this.goalSelector.addGoal(6, new ZurTradeWithPlayerGoal(this));
      this.goalSelector.addGoal(7, new ZurEntity.SitGoal());
      this.applyEntityAI();
   }

   private void applyEntityAI() {
      EatGrassGoal eatGrassGoal = new EatGrassGoal(this);
      EatPumpkinGoal eatPumpkinGoal = new EatPumpkinGoal(this);
      this.goalSelector.addGoal(6, new ZurEntity.MorningGiftGoal(this));
      this.goalSelector.addGoal(4, new ZurEntity.PounceGoal(this));
      this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
      this.goalSelector.addGoal(7, new PlaceBlockGoal(this));
      this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, 1.0F));
      this.goalSelector.addGoal(4, new AttackGoal(this));
      this.goalSelector.addGoal(1, new TakeBlockGoal(this));
      this.goalSelector.addGoal(2, new ZurAttackGoal(this, 1.0D, true));
      this.goalSelector.addGoal(3, new OpenDoorGoal(this, false));
      this.goalSelector.addGoal(4, new SwimGoal(this));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(TraderNirtreEntity.class));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
      this.targetSelector.addGoal(3, new TargetGoal<>(this, PlayerEntity.class));
      this.goalSelector.addGoal(5, eatGrassGoal);
      this.goalSelector.addGoal(5, eatPumpkinGoal);
      this.goalSelector.addGoal(5, eatPumpkinGoal);
      this.goalSelector.addGoal(5, eatGrassGoal);
      this.breakBlockGoals();
   }

   private void breakBlockGoals() {
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICKS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICK_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICK_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICK_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIRT, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(BlockItemInit.DIRT_SLAB.get(), this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(MinecraftBlocks.DIRT_STAIRS.get(), this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRASS_BLOCK, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRASS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.PODZOL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRASS_PATH, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.FARMLAND, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.BEDROCK, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_ANDESITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_ANDESITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_ANDESITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_GRANITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_GRANITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_GRANITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIORITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIORITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIORITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_DIORITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_DIORITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_DIORITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.IRON_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COAL_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GOLD_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.REDSTONE_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIAMOND_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.EMERALD_ORE, this, 4, 6));
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(CARRIED_BLOCK, Optional.empty());
      //this.getDataManager().register(PHASE, PhaseType.CHARGING_PLAYER.getId());
   }

   public void applyWaveBonus(int p_213660_1_, boolean p_213660_2_) {
   }

   public boolean canBeLeader() {
      return false;
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 40.0D).createMutableAttribute(Attributes.ARMOR, 20.0D).createMutableAttribute(Attributes.MAX_HEALTH, 260).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 5.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 15.0D);
   }

   @Nullable
   public ZurEntity createChild(AgeableEntity ageable) {
      return com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY.create(this.world);
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return !this.isNoDespawnRequired();
   }

   public SoundEvent getRaidLossSound() {
      return SoundEvents.ENTITY_BAT_DEATH;
   }

   /**
    * Fires an arrow
    */
   protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
      return ProjectileHelper.fireArrow(this, arrowStack, distanceFactor);
   }

   public PhaseManager getPhaseManager() {
      return this.phaseManager;
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);

      if (compound.contains("ZurTarget")) {
         this.zurTarget = NBTUtil.readBlockPos(compound.getCompound("ZurTarget"));
      }

      if (compound.contains("Offers", 10)) {
         this.offers = new MerchantOffers(compound.getCompound("Offers"));
      }

      this.zurInventory.read(compound.getList("Inventory", 10));
      this.setGrowingAge(Math.max(0, this.getGrowingAge()));
   }

   public void setGrowingAge(int age) {
      int i = this.growingAge;
      this.growingAge = age;
      if (i < 0 && age >= 0 || i >= 0 && age < 0) {
         this.dataManager.set(BABY, age < 0);
         this.onGrowingAdult();
      }

   }

   protected void onGrowingAdult() {
   }

   public int getGrowingAge() {
      if (this.world.isRemote) {
         return this.dataManager.get(BABY) ? -1 : 1;
      } else {
         return this.growingAge;
      }
   }

   protected void onZurTrade(MerchantOffer offer) {
      if (offer.getDoesRewardExp()) {
         int i = 3 + this.rand.nextInt(4);
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
      }

   }

   public void func_213746_a(ZurEntity zur, long gameTime) {
      if ((gameTime < this.field_213783_bN || gameTime >= this.field_213783_bN + 1200L) && (gameTime < zur.field_213783_bN || gameTime >= zur.field_213783_bN + 1200L)) {
         this.gossip.transferFrom(this.gossip, this.rand, 10);
         this.field_213783_bN = gameTime;
         zur.field_213783_bN = gameTime;
         this.spawnGolems(gameTime, 5);
      }
   }

   public void spawnGolems(long gameTime, int requiredPeers) {
      if (this.canSpawnGolems(gameTime)) {
         AxisAlignedBB axisalignedbb = this.getBoundingBox().grow(10.0D, 10.0D, 10.0D);
         List<ZurEntity> list = this.world.getEntitiesWithinAABB(ZurEntity.class, axisalignedbb);
         List<ZurEntity> list1 = list.stream().filter((zur) -> zur.canSpawnGolems(gameTime)).limit(5L).collect(Collectors.toList());
         if (list1.size() >= requiredPeers) {
            IronGolemEntity irongolementity = this.trySpawnGolem();
            if (irongolementity != null) {
               list.forEach((zur) -> {
                  zur.updateGolemLastSeenMemory(gameTime);
               });
            }
         }
      }
   }

   private void updateGolemLastSeenMemory(long gameTime) {
      this.brain.setMemory(MemoryModuleType.GOLEM_LAST_SEEN_TIME, gameTime);
   }

   private boolean hasSeenGolemRecently(long gameTime) {
      Optional<Long> optional = this.brain.getMemory(MemoryModuleType.GOLEM_LAST_SEEN_TIME);
      if (!optional.isPresent()) {
         return false;
      } else {
         Long olong = optional.get();
         return gameTime - olong <= 600L;
      }
   }

   public boolean canSpawnGolems(long gameTime) {
      if (!this.hasSleptAndWorkedRecently(this.world.getGameTime())) {
         return false;
      } else {
         return !this.hasSeenGolemRecently(gameTime);
      }
   }

   @Nullable
   private IronGolemEntity trySpawnGolem() {
      BlockPos blockpos = this.getPosition();

      for(int i = 0; i < 10; ++i) {
         double d0 = this.world.rand.nextInt(16) - 8;
         double d1 = this.world.rand.nextInt(16) - 8;
         BlockPos blockpos1 = this.func_241433_a_(blockpos, d0, d1);
         if (blockpos1 != null) {
            IronGolemEntity irongolementity = EntityType.IRON_GOLEM.create(this.world, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, blockpos1, SpawnReason.MOB_SUMMONED, false, false);
            if (irongolementity != null) {
               if (irongolementity.canSpawn(this.world, SpawnReason.MOB_SUMMONED) && irongolementity.isNotColliding(this.world)) {
                  this.world.addEntity(irongolementity);
                  return irongolementity;
               }

               irongolementity.remove();
            }
         }
      }

      return null;
   }

   @Nullable
   private BlockPos func_241433_a_(BlockPos p_241433_1_, double p_241433_2_, double p_241433_4_) {
      int i = 6;
      BlockPos blockpos = p_241433_1_.add(p_241433_2_, 6.0D, p_241433_4_);
      BlockState blockstate = this.world.getBlockState(blockpos);

      for(int j = 6; j >= -6; --j) {
         BlockPos blockpos1 = blockpos;
         BlockState blockstate1 = blockstate;
         blockpos = blockpos.down();
         blockstate = this.world.getBlockState(blockpos);
         if ((blockstate1.isAir() || blockstate1.getMaterial().isLiquid()) && blockstate.getMaterial().isOpaque()) {
            return blockpos1;
         }
      }

      return null;
   }

   public boolean func_213490_ee() {
      return this.crouchAmount == 3.0F;
   }

   public static boolean func_213481_a(ZurEntity zur, LivingEntity p_213481_1_) {
      double d0 = p_213481_1_.getPosZ() - zur.getPosZ();
      double d1 = p_213481_1_.getPosX() - zur.getPosX();
      double d2 = d0 / d1;
      int i = 6;

      for(int j = 0; j < 6; ++j) {
         double d3 = d2 == 0.0D ? 0.0D : d0 * (double)((float)j / 6.0F);
         double d4 = d2 == 0.0D ? d1 * (double)((float)j / 6.0F) : d3 / d2;

         for(int k = 1; k < 4; ++k) {
            if (!zur.world.getBlockState(new BlockPos(zur.getPosX() + d4, zur.getPosY() + (double)k, zur.getPosZ() + d3)).getMaterial().isReplaceable()) {
               return false;
            }
         }
      }

      return true;
   }

   @Override
   public boolean func_223340_ej() {
      return super.func_223340_ej();
   }

   public class PounceGoal extends net.minecraft.entity.ai.goal.JumpGoal {
      public PounceGoal(ZurEntity zurEntity) {
         super();
      }

      @Override
      public boolean shouldExecute() {
         return false;
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         LivingEntity livingentity = ZurEntity.this.getAttackTarget();
         if (livingentity != null && livingentity.isAlive()) {
            double d0 = ZurEntity.this.getMotion().y;
            return (!(d0 * d0 < (double)0.05F) || !(Math.abs(ZurEntity.this.rotationPitch) < 15.0F) || !ZurEntity.this.onGround);
         } else {
            return false;
         }
      }

      public boolean isPreemptible() {
         return false;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         ZurEntity.this.setJumping(true);
         LivingEntity livingentity = ZurEntity.this.getAttackTarget();
         ZurEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
         Vector3d vector3d = (new Vector3d(livingentity.getPosX() - ZurEntity.this.getPosX(), livingentity.getPosY() - ZurEntity.this.getPosY(), livingentity.getPosZ() - ZurEntity.this.getPosZ())).normalize();
         ZurEntity.this.setMotion(ZurEntity.this.getMotion().add(vector3d.x * 0.8D, 0.9D, vector3d.z * 0.8D));
         ZurEntity.this.getNavigator().clearPath();
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         ZurEntity.this.crouchAmount = 0.0F;
         ZurEntity.this.crouchAmountO = 0.0F;
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick(ZurEntity zur) {
         LivingEntity livingentity = ZurEntity.this.getAttackTarget();
         Vector3d vector3d = ZurEntity.this.getMotion();
         if (livingentity != null) {
            ZurEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
         }

         if (vector3d.y * vector3d.y < (double)0.03F && ZurEntity.this.rotationPitch != 0.0F) {
            ZurEntity.this.rotationPitch = MathHelper.rotLerp(ZurEntity.this.rotationPitch, 0.0F, 0.2F);
         } else {
            double d0 = Math.sqrt(Entity.horizontalMag(vector3d));
            double d1 = Math.signum(-vector3d.y) * Math.acos(d0 / vector3d.length()) * (double)(180F / (float)Math.PI);
            ZurEntity.this.rotationPitch = (float)d1;
         }

         if (livingentity != null && ZurEntity.this.getDistance(livingentity) <= 2.0F) {
            ZurEntity.this.attackEntityAsMob(livingentity);
         } else if (ZurEntity.this.rotationPitch > 0.0F && ZurEntity.this.onGround) {
            ZurEntity.this.rotationPitch = 60.0F;
            ZurEntity.this.setAttackTarget(null);
         }

      }
   }

   public void startSleeping(BlockPos pos) {
      super.startSleeping(pos);
      this.brain.setMemory(MemoryModuleType.LAST_SLEPT, this.world.getGameTime());
      this.brain.removeMemory(MemoryModuleType.WALK_TARGET);
      this.brain.removeMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
   }

   public void wakeUp() {
      super.wakeUp();
      this.brain.setMemory(MemoryModuleType.LAST_WOKEN, this.world.getGameTime());
   }

   private boolean hasSleptAndWorkedRecently(long gameTime) {
      Optional<Long> optional = this.brain.getMemory(MemoryModuleType.LAST_SLEPT);
      return optional.filter(aLong -> gameTime - aLong < 24000L).isPresent();
   }

   protected Brain<?> createBrain(Dynamic<?> dynamicIn) {
      Brain<ZurEntity> brain = (Brain<ZurEntity>) this.getBrainCodec().func_233748_a_(dynamicIn);
      this.initBrain(brain);
      return brain;
   }

   public void resetBrain(ServerWorld serverWorldIn) {
      Brain<ZurEntity> brain = (Brain<ZurEntity>) this.getBrain();
      brain.stopAllTasks(serverWorldIn, this);
      this.brain = brain.copy();
      this.initBrain((Brain<ZurEntity>) this.getBrain());
   }

   private void initBrain(Brain<ZurEntity> zurBrain) {
      if (this.isChild()) {
         zurBrain.setSchedule(Schedule.VILLAGER_BABY);
         //zurBrain.registerActivity(Activity.PLAY, (ImmutableList<? extends Pair<Integer, ? extends Task<? super ZurEntity>>>) ZurTasks.play(0.5F));
      }
   }

   @Override
   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      ActionResultType actionresulttype = super.func_230254_b_(p_230254_1_, p_230254_2_);
      if (itemstack.getItem() != ModSpawnEggItemInit.ZUR_SPAWN_EGG && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
         if (p_230254_2_ == Hand.MAIN_HAND) {
            p_230254_1_.addStat(Stats.TALKED_TO_VILLAGER);
         }

         if (actionresulttype.isSuccessOrConsume()) {
            return actionresulttype;
         } else if (!this.world.isRemote) {
            return ZurTasks.func_234471_a_(this, p_230254_1_, p_230254_2_);
         } else {
            boolean flag = ZurTasks.func_234489_b_(this, p_230254_1_.getHeldItem(p_230254_2_)) && this.func_234424_eM_() != Action.ADMIRING_ITEM;
            return flag ? ActionResultType.SUCCESS : ActionResultType.PASS;
         }

      } else {
         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      }
   }

   @Override
   protected void populateTradeZurData() {
      ZurTrades.ITrade[] aZurTrades$itrade = ZurTrades.field_221240_b.get(1);
      if (aZurTrades$itrade != null) {
         MerchantOffers merchantoffers = this.getOffers();
         this.addTrades(merchantoffers, aZurTrades$itrade, 10);
         int i = this.rand.nextInt(aZurTrades$itrade.length);
         ZurTrades.ITrade ZurTrades$itrade = aZurTrades$itrade[i];
         MerchantOffer merchantoffer = ZurTrades$itrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            merchantoffers.add(merchantoffer);
         }

      }
   }

   @Nullable
   public LivingEntity getOwner() {
      try {
         UUID uuid = this.getOwnerId();
         return uuid == null ? null : this.world.getPlayerByUuid(uuid);
      } catch (IllegalArgumentException illegalargumentexception) {
         return null;
      }
   }

   public boolean func_213416_eg() {
      return this.dataManager.get(field_213428_bG);
   }

   public void func_213419_u(boolean p_213419_1_) {
      this.dataManager.set(field_213428_bG, p_213419_1_);
   }

   public boolean func_213409_eh() {
      return this.dataManager.get(field_213429_bH);
   }

   public void func_213415_v(boolean p_213415_1_) {
      this.dataManager.set(field_213429_bH, p_213415_1_);
   }

   static class MorningGiftGoal extends Goal {
      private final ZurEntity zur;
      private PlayerEntity owner;
      private BlockPos bedPos;

      public MorningGiftGoal(ZurEntity zurIn) {
         this.zur = zurIn;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return false;
      }

      private boolean func_220805_g() {
         for(ZurEntity zurEntity : this.zur.world.getEntitiesWithinAABB(ZurEntity.class, (new AxisAlignedBB(this.bedPos)).grow(2.0D))) {
            if (zurEntity != this.zur && (zurEntity.func_213416_eg() || zurEntity.func_213409_eh())) {
               return true;
            }
         }

         return false;
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         this.zur.func_213419_u(false);
         float f = this.zur.world.getCelestialAngle(1.0F);
         if (this.owner.getSleepTimer() >= 100 && (double)f > 0.77D && (double)f < 0.8D && (double)this.zur.world.getRandom().nextFloat() < 0.7D) {
            this.func_220804_h();
         }

         int tickCounter = 0;
         this.zur.func_213415_v(false);
         this.zur.getNavigator().clearPath();
      }

      private void func_220804_h() {
         Random random = this.zur.getRNG();
         BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
         blockpos$mutable.setPos(this.zur.getPosition());
         this.zur.attemptTeleport(blockpos$mutable.getX() + random.nextInt(11) - 5, blockpos$mutable.getY() + random.nextInt(5) - 2, blockpos$mutable.getZ() + random.nextInt(11) - 5, false);
         blockpos$mutable.setPos(this.zur.getPosition());
         LootTable loottable = this.zur.world.getServer().getLootTableManager().getLootTableFromLocation(LootTables1.GAMEPLAY_ZUR_MORNING_GIFT);
         LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.zur.world)).withParameter(LootParameters.POSITION, blockpos$mutable).withParameter(LootParameters.THIS_ENTITY, this.zur).withRandom(random);

         for(ItemStack itemstack : loottable.generate(lootcontext$builder.build(LootParameterSets.GIFT))) {
            this.zur.world.addEntity(new ItemEntity(this.zur.world, (double)blockpos$mutable.getX() - (double) MathHelper.sin(this.zur.renderYawOffset * ((float)Math.PI / 180F)), blockpos$mutable.getY(), (double)blockpos$mutable.getZ() + (double)MathHelper.cos(this.zur.renderYawOffset * ((float)Math.PI / 180F)), itemstack));
         }

      }
   }

   public boolean canBreed() {
      return this.foodLevel + this.getFoodValueFromInventory() >= 12 && this.getGrowingAge() == 0;
   }

   public boolean func_233685_eM_() {
      return this.field_233683_bw_;
   }

   @Nullable
   public UUID getOwnerId() {
      return this.dataManager.get(OWNER_UNIQUE_ID).orElse(null);
   }

   class SitGoal extends Goal {
      private int field_220832_b;

      public SitGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      @Override
      public boolean shouldExecute() {
         return false;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         List<ItemEntity> list = ZurEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, ZurEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), ZurEntity.ITEMS);
         if (!list.isEmpty() && ZurEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            ZurEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), 1.2F);
         } else if (!ZurEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            ZurEntity.this.tryToSit();
         }

         this.field_220832_b = 0;
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         ItemStack itemstack = ZurEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (!itemstack.isEmpty()) {
            ZurEntity.this.entityDropItem(itemstack);
            ZurEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
            //int i = ZurEntity.this.isLazy() ? ZurEntity.this.rand.nextInt(50) + 10 : ZurEntity.this.rand.nextInt(150) + 10;
            //this.field_220832_b = ZurEntity.this.ticksExisted + i * 20;
         }
      }
   }

   private void tryToSit() {
      if (!this.isInWater()) {
         this.setMoveForward(0.0F);
         this.getNavigator().clearPath();
      }

   }

   public ZurEntity.Action func_234424_eM_() {
      if (ZurTasks.func_234480_a_(this.getHeldItemOffhand().getItem())) {
         return ZurEntity.Action.ADMIRING_ITEM;
      } else {
         return Action.DEFAULT;
      }
   }

   protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
      ItemStack itemstack = itemEntity.getItem();
      if (this.func_230293_i_(itemstack)) {
         Inventory inventory = this.getZurInventory();
         boolean flag = inventory.func_233541_b_(itemstack);
         if (!flag) {
            return;
         }

         this.triggerItemPickupTrigger(itemEntity);
         this.onItemPickup(itemEntity, itemstack.getCount());
         ItemStack itemstack1 = inventory.addItem(itemstack);
         if (itemstack1.isEmpty()) {
            itemEntity.remove();
         } else {
            itemstack.setCount(itemstack1.getCount());
         }
      }

   }

   private boolean func_223344_ex() {
      return this.foodLevel < 12;
   }

   private void func_213765_en() {
      if (this.func_223344_ex() && this.getFoodValueFromInventory() != 0) {
         for(int i = 0; i < this.getZurInventory().getSizeInventory(); ++i) {
            ItemStack itemstack = this.getZurInventory().getStackInSlot(i);
            if (!itemstack.isEmpty()) {
               Integer integer = FOOD_VALUES.get(itemstack.getItem());
               if (integer != null) {
                  int j = itemstack.getCount();

                  for(int k = j; k > 0; --k) {
                     this.foodLevel = (byte)(this.foodLevel + integer);
                     this.getZurInventory().decrStackSize(i, 1);
                     if (!this.func_223344_ex()) {
                        return;
                     }
                  }
               }
            }
         }

      }
   }

   public boolean canAbondonItems() {
      return this.getFoodValueFromInventory() >= 24;
   }

   public boolean wantsMoreFood() {
      return this.getFoodValueFromInventory() < 12;
   }

   /**
    * @return calculated food value from item stacks in this zur's inventory
    */
   private int getFoodValueFromInventory() {
      Inventory inventory = this.getZurInventory();
      return FOOD_VALUES.entrySet().stream().mapToInt((p_226553_1_) -> inventory.count(p_226553_1_.getKey()) * p_226553_1_.getValue()).sum();
   }

   public boolean isFarmItemInInventory() {
      return this.getZurInventory().hasAny(ImmutableSet.of(Items.WHEAT_SEEDS, Items.POTATO, Items.CARROT, Items.BEETROOT_SEEDS));
   }

   public void func_223346_ep() {
      this.func_213765_en();
      this.decrFoodLevel();
   }

   private void decrFoodLevel() {
      this.foodLevel = (byte)(this.foodLevel - 12);
   }

   private boolean func_234433_eX_() {
      return this.dataManager.get(field_234409_bv_);
   }

   public void setCharging(boolean isCharging) {
      this.dataManager.set(field_234409_bv_, isCharging);
   }

   /*protected void func_234439_n_(ItemStack p_234439_1_) {
      if (p_234439_1_.isZurCurrency(getStack())) {
         this.setItemStackToSlot(EquipmentSlotType.OFFHAND, p_234439_1_);
         this.setIdleTime(1000);
         this.func_233663_d_(EquipmentSlotType.OFFHAND);
      } else {
         this.func_233657_b_(EquipmentSlotType.OFFHAND, p_234439_1_);
      }

   }*/

   protected ItemStack func_234436_k_(ItemStack itemStack) {
      return this.zurInventory.addItem(itemStack);
   }

   protected boolean func_234437_l_(ItemStack itemStack) {
      return this.zurInventory.func_233541_b_(itemStack);
   }

   private void equipmentSlotType(EquipmentSlotType type, ItemStack stack) {
      if (this.world.rand.nextFloat() < 0.1F) {
         this.setItemStackToSlot(type, stack);
      }

   }

   protected boolean func_234440_o_(ItemStack p_234440_1_) {
      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(p_234440_1_);
      ItemStack itemstack = this.getItemStackFromSlot(equipmentslottype);
      return this.shouldExchangeEquipment(p_234440_1_, itemstack);
   }

   protected void func_234438_m_(ItemStack p_234438_1_) {
      this.func_233657_b_(EquipmentSlotType.MAINHAND, p_234438_1_);
   }

   protected void applyAttributeBonuses(float difficulty) {
      this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).applyPersistentModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * (double)0.05F, AttributeModifier.Operation.ADDITION));
      double d0 = this.rand.nextDouble() * 1.5D * (double)difficulty;
      if (d0 > 1.0D) {
         this.getAttribute(Attributes.FOLLOW_RANGE).applyPersistentModifier(new AttributeModifier("Random zur-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
      }

      if (this.rand.nextFloat() < difficulty * 0.05F) {
         this.getAttribute(Attributes.MAX_HEALTH).applyPersistentModifier(new AttributeModifier("Leader zur bonus", this.rand.nextDouble() * 3.0D + 1.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
      }

   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag, ZurEntity zur) {
      if (reason != SpawnReason.SPAWN_EGG) {
         if (worldIn.getRandom().nextFloat() < 0.2F) {
            this.setChild(true);
         } else if (this.Child()) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, this.func_234432_eW_());
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, this.func_234432_eW1_());
         }
      }

      ZurTasks.func_234466_a_(this);
      if (this.isDrowning()) {
         zur.setEquipmentBasedOnDifficulty(difficultyIn);
      }
      zur.setEquipmentBasedOnDifficulty1(difficultyIn);
      this.setEnchantmentBasedOnDifficulty(difficultyIn);
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_GENERIC_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_GENERIC_DEATH;
   }

   protected SoundEvent getStepSound() {
      return SoundEvents.ENTITY_PLAYER_SPLASH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(this.getStepSound(), 0.15F, 1.0F);
   }

   public CreatureAttribute getCreatureAttribute() {
      return CreatureAttribute.ARTHROPOD;
   }

   private boolean func_234431_eV_() {
      return this.getDataManager().get(field_234408_bu_);
   }

   public boolean func_234423_eL_() {
      return !this.world.func_230315_m_().func_241509_i_() && !this.func_234431_eV_() && !this.isAIDisabled();
   }

   public void func_234442_u_(boolean p_234442_1_) {
      this.dataManager.set(field_213428_bH, p_234442_1_);
   }

   /*protected void updateAITasks() {
      //this.world.getProfiler().startSection("zurBrain");
      //this.getBrain().tick((ServerWorld)this.world, this);
      this.world.getProfiler().endSection();
      //ZurTasks.func_234486_b_(this);
      /*if (this.func_234423_eL_()) {
         ++this.timeInOverworld;
      } else {
         this.timeInOverworld = 0;
      }

      if (this.timeInOverworld > 300) {
         this.func_241417_a_(SoundEvents.ENTITY_GENERIC_HURT);
         this.func_234416_a_((ServerWorld)this.world);
      }

   }*/

   protected void func_241417_a_(SoundEvent p_241417_1_) {
      this.playSound(p_241417_1_, this.getSoundVolume(), this.getSoundPitch());
   }

   private void func_234416_a_(ServerWorld p_234416_1_) {
      ZurTasks.func_234496_c_(this);
      this.zurInventory.func_233543_f_().forEach(this::entityDropItem);
      ZurNirtreEntity zombifiedpiglinentity = this.func_233656_b_(EntityInit.ZUR_NIRTRE_ENTITY.get());
      zombifiedpiglinentity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
   }

   /**
    * Gives armor or weapon for entity based on given DifficultyInstance
    */
   protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
      if (this.isRemote) {
         if (this.Child()) {
            this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.SRIUNK_HELMET.get()));
            this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.SRIUNK_CHESTPLATE.get()));
            this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.SRIUNK_LEGGINGS.get()));
            this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.SRIUNK_BOOTS.get()));
         }
         if (this.Child()) {
            this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.DURG_HELMET.get()));
            this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.DURG_CHESTPLATE.get()));
            this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.DURG_LEGGINGS.get()));
            this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.DURG_BOOTS.get()));
         }
         if (this.Child()) {
            this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.NIRK_HELMET.get()));
            this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.NIRK_CHESTPLATE.get()));
            this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.NIRK_LEGGINGS.get()));
            this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.NIRK_BOOTS.get()));
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 50.0F : 10.0F)) {
            int i = this.rand.nextInt(180);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_AXE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 50.0F : 10.0F)) {
            int i = this.rand.nextInt(144);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_SHOVEL.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 50.0F : 10.0F)) {
            int i = this.rand.nextInt(108);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_SWORD.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 50.0F : 10.0F)) {
            int i = this.rand.nextInt(72);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_PICKAXE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 50.0F : 10.0F)) {
            int i = this.rand.nextInt(36);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_HOE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.NORMAL ? 10.0F : 2.0F)) {
            int i = this.rand.nextInt(120);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_AXE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.NORMAL ? 10.0F : 2.0F)) {
            int i = this.rand.nextInt(96);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_SHOVEL.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.NORMAL ? 10.0F : 2.0F)) {
            int i = this.rand.nextInt(72);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_SWORD.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.NORMAL ? 10.0F : 2.0F)) {
            int i = this.rand.nextInt(48);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_PICKAXE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.NORMAL ? 10.0F : 2.0F)) {
            int i = this.rand.nextInt(24);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_HOE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
            int i = this.rand.nextInt(60);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_AXE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
            int i = this.rand.nextInt(48);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_SHOVEL.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
            int i = this.rand.nextInt(36);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_SWORD.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
            int i = this.rand.nextInt(24);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_PICKAXE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
            int i = this.rand.nextInt(12);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_HOE.get()));
            }
         }
         if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.PEACEFUL ? 0.5F : 0.1F)) {
            int i = this.rand.nextInt(6);
            if (i == 0) {
               this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(isBurnableItemInit.DURK.get()));
            } else {
               this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(isBurnableItemInit.LEAT.get()));
            }
         }
      }

   }

   protected void setEquipmentBasedOnDifficulty1(DifficultyInstance difficulty) {
      if (this.Child()) {
         this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(ArmorItemInit.FIRT_HELMET.get()));
         this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(ArmorItemInit.FIRT_CHESTPLATE.get()));
         this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(ArmorItemInit.FIRT_LEGGINGS.get()));
         this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(ArmorItemInit.FIRT_BOOTS.get()));
      }
      if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.PEACEFUL ? 0.5F : 0.1F)) {
         int i = this.rand.nextInt(40);
         if (i == 0) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.END_STONE_STIK.get()));
         } else if (i == 1) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.KALT.get()));
         } else if (i == 2) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.FIRK.get()));
         } else if (i == 3) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.NIRG.get()));
         } else if (i == 4) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.REGDEM.get()));
         } else {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.FRIT.get()));
         }
      }
      if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.PEACEFUL ? 0.5F : 0.1F)) {
         int i = this.rand.nextInt(60);
         if (i == 0) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.KIRT_STIK.get()));
         } else if (i == 1) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.KIRT_STICK.get()));
         } else if (i == 2) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.SCIK.get()));
         } else if (i == 3) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.SCRA.get()));
         } else if (i == 4) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.GURT.get()));
         } else {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.CRAST.get()));
         }
      }

   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      MerchantOffers merchantoffers = this.getOffers();
      if (this.zurTarget != null) {
         compound.put("ZurTarget", NBTUtil.writeBlockPos(this.zurTarget));
      }

      if (this.isChild()) {
         compound.putBoolean("IsBaby", true);
      }

      if (!merchantoffers.isEmpty()) {
         compound.put("Offers", merchantoffers.write());
      }

      compound.put("Inventory", this.zurInventory.write());
      compound.putInt("InWaterTime", this.isInWater() ? this.inWaterTime : -1);
      compound.putInt("DrownedConversionTime", this.isDrowning() ? this.drownedConversionTime : -1);
   }

   public void onKillEntity(LivingEntity entityLivingIn) {
      super.onKillEntity(entityLivingIn);
      if ((this.world.getDifficulty() == Difficulty.NORMAL || this.world.getDifficulty() == Difficulty.HARD) && entityLivingIn instanceof VillagerEntity) {
         if (this.world.getDifficulty() != Difficulty.HARD && this.rand.nextBoolean()) {
            return;
         }

         TraderNirtreEntity traderNirtreEntity = (TraderNirtreEntity) entityLivingIn;
         ZurEntity zurNirtreEntity = com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY.create(this.world);
         zurNirtreEntity.copyLocationAndAnglesFrom(traderNirtreEntity);
         traderNirtreEntity.remove();
         zurNirtreEntity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(zurNirtreEntity.getPosition()), SpawnReason.CONVERSION, new ZurEntity.GroupData(false, true), (CompoundNBT)null);
         //zurNirtreEntity.setOffers(traderNirtreEntity.getOffers().write());
         //zurNirtreEntity.setEXP(traderNirtreEntity.getXp());
         zurNirtreEntity.setChild(traderNirtreEntity.isChild());
         zurNirtreEntity.setNoAI(traderNirtreEntity.isAIDisabled());
         if (traderNirtreEntity.hasCustomName()) {
            zurNirtreEntity.setCustomName(traderNirtreEntity.getCustomName());
            zurNirtreEntity.setCustomNameVisible(traderNirtreEntity.isCustomNameVisible());
         }

         if (traderNirtreEntity.isNoDespawnRequired()) {
            zurNirtreEntity.enablePersistence();
         }

         zurNirtreEntity.setInvulnerable(this.isInvulnerable());
         this.world.addEntity(zurNirtreEntity);
         if (!this.isSilent()) {
            this.world.playEvent(null, 1026, this.getPosition(), 0);
         }
      }
   }

   /*public static boolean func_234351_b_(EntityType<ZurEntity> p_234351_0_, IWorld p_234351_1_, SpawnReason p_234351_2_, BlockPos p_234351_3_, Random p_234351_4_) {
      return p_234351_1_.getDifficulty() != Difficulty.PEACEFUL;
   }*/

   public boolean canEquipItem(ItemStack stack) {
      return stack.getItem() == Items.EGG && this.isChild() && this.isPassenger() ? false : super.canEquipItem(stack);
   }

   public static boolean func_241399_a_(Random p_241399_0_) {
      return p_241399_0_.nextFloat() < net.minecraftforge.common.ForgeConfig.SERVER.zombieBabyChance.get();
   }

   public double getYOffset() {
      return this.isChild() ? 0.0D : -0.45D;
   }

   protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
      super.dropSpecialItems(source, looting, recentlyHitIn);
      Entity entity = source.getTrueSource();
      if (entity instanceof CreeperEntity) {
         CreeperEntity creeperentity = (CreeperEntity)entity;
         if (creeperentity.ableToCauseSkullDrop()) {
            creeperentity.incrementDroppedSkulls();
            ItemStack itemstack = this.getSkullDrop();
            if (!itemstack.isEmpty()) {
               this.entityDropItem(itemstack);
            }
         }
      }

   }

   protected ItemStack getSkullDrop() {
      return new ItemStack(Items.ZOMBIE_HEAD);
   }

   /*public boolean isBreedingItem(ItemStack stack) {
      return TEMPTATION_ITEMS.test(stack);
   }*/

   public static class GroupData implements ILivingEntityData {
      public final boolean isChild;
      public final boolean field_241400_b_;

      public GroupData(boolean p_i231567_1_, boolean p_i231567_2_) {
         this.isChild = p_i231567_1_;
         this.field_241400_b_ = p_i231567_2_;
      }
   }

   protected void sendDebugPackets() {
      super.sendDebugPackets();
      DebugPacketSender.sendLivingEntity(this);
   }

   public void setHeldBlockState(@Nullable BlockState state) {
      this.dataManager.set(CARRIED_BLOCK, Optional.ofNullable(state));
   }

   @Nullable
   public BlockState getHeldBlockState() {
      return this.dataManager.get(CARRIED_BLOCK).orElse(null);
   }

   public enum Action {
      ATTACKING_WITH_MELEE_WEAPON,
      CROSSBOW_HOLD,
      CROSSBOW_CHARGE,
      ADMIRING_ITEM,
      DANCING,
      DEFAULT;
   }

   public void onStruckByLightning(LightningBoltEntity lightningBolt) {
      if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
         LOGGER.info("Zur {} was struck by lightning {}.", this, lightningBolt);
         ZurNirtreEntity zurNirtreEntity = EntityInit.ZUR_NIRTRE_ENTITY.get().create(this.world);
         zurNirtreEntity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
         zurNirtreEntity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(zurNirtreEntity.getPosition()), SpawnReason.CONVERSION, null, null);
         zurNirtreEntity.setNoAI(this.isAIDisabled());
         if (this.hasCustomName()) {
            zurNirtreEntity.setCustomName(this.getCustomName());
            zurNirtreEntity.setCustomNameVisible(this.isCustomNameVisible());
         }

         zurNirtreEntity.enablePersistence();
         this.world.addEntity(zurNirtreEntity);
         this.remove();
      } else {
         super.onStruckByLightning(lightningBolt);
      }

   }
}