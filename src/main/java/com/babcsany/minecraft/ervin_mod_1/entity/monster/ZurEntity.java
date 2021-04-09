package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.EatPumpkinGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.ZurTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.SrachEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.$TraderTrades;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public class ZurEntity extends MonsterEntity {
   private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(isBurnableItemInit.TIRKS.get());
   private static final DataParameter<Boolean> field_234409_bv_ = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   public float wingRotation;
   private int despawnDelay;
   public float destPos;
   public float wingRotDelta = 1.0F;
   private boolean field_234407_bB_ = false;
   @Nullable
   private PlayerEntity customer;
   private final Inventory inventory = new Inventory(8);
   public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
   private static final Predicate<ItemEntity> ITEMS = (p_213575_0_) -> {
      Item item = p_213575_0_.getItem().getItem();
      return (item == Blocks.BAMBOO.asItem() || item == Blocks.CAKE.asItem()) && p_213575_0_.isAlive() && !p_213575_0_.cannotPickup();
   };
   //protected static final ImmutableList<SensorType<? extends Sensor<? super ZurEntity>>> field_234405_b_ = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS, SensorType.field_234129_b_, SensorType.HURT_BY, SensorType.INTERACTABLE_DOORS, SensorType.field_234130_l_);
   //protected static final ImmutableList<MemoryModuleType<?>> field_234414_c_ = ImmutableList.of(MemoryModuleType.LOOK_TARGET, MemoryModuleType.INTERACTABLE_DOORS, MemoryModuleType.OPENED_DOORS, MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS, MemoryModuleType.NEAREST_ADULT_PIGLINS, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH, MemoryModuleType.ANGRY_AT, MemoryModuleType.UNIVERSAL_ANGER, MemoryModuleType.AVOID_TARGET, MemoryModuleType.ADMIRING_ITEM, MemoryModuleType.ADMIRING_DISABLED, MemoryModuleType.CELEBRATE_LOCATION, MemoryModuleType.DANCING, MemoryModuleType.HUNTED_RECENTLY, MemoryModuleType.NEAREST_VISIBLE_BABY_HOGLIN, MemoryModuleType.NEAREST_VISIBLE_BABY_PIGLIN, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED, MemoryModuleType.RIDE_TARGET, MemoryModuleType.VISIBLE_ADULT_PIGLIN_COUNT, MemoryModuleType.VISIBLE_ADULT_HOGLIN_COUNT, MemoryModuleType.NEAREST_VISIBLE_HUNTABLE_HOGLIN, MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD, MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM, MemoryModuleType.ATE_RECENTLY, MemoryModuleType.NEAREST_REPELLENT);
   public boolean zurJockey;

   private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
   private static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
   private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> ROVENT = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> {
      return p_213697_0_ == Difficulty.HARD;
   };
   private final BreakDoorGoal breakDoor = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
   private boolean isBreakDoorsTaskSet;
   private int inWaterTime;
   private int drownedConversionTime;
   private EatGrassGoal eatGrassGoal;
   private EatPumpkinGoal eatPumpkinGoal;

   public ZurEntity(EntityType<? extends ZurEntity> type, World worldIn) {
      super(type, worldIn);
   }

   public ZurEntity(World worldIn) {
      this(EntityInit.ZUR_ENTITY.get(), worldIn);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(4, new ZurEntity.AttackGrassBlockGoal(this, 1.0D, 3));
      this.goalSelector.addGoal(4, new ZurEntity.AttackPumpkinGoal(this, 1.0D, 3));
      this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
      this.applyEntityAI();
   }

   @Nullable
   public PlayerEntity getCustomer() {
      return this.customer;
   }

   /*@Override
   public MerchantOffers getOffers() {
      return null;
   }

   @Override
   public void setClientSideOffers(@Nullable MerchantOffers offers) {

   }

   @Override
   public void onTrade(MerchantOffer offer) {

   }

   @Override
   public void verifySellingItem(ItemStack stack) {

   }

   @Override
   public World getWorld() {
      return null;
   }

   @Override
   public int getXp() {
      return 0;
   }

   @Override
   public void setXP(int xpIn) {

   }

   @Override
   public boolean func_213705_dZ() {
      return false;
   }

   public void onZurTrade(MerchantOffer offer) {

   }

   @Override
   protected void zurTrade(MerchantOffer offer) {

   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (itemstack.getItem() != ModSpawnEggItemInit.ZUR_ENTITY_SPAWN_EGG.get() && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
         if (p_230254_2_ == Hand.MAIN_HAND) {
            p_230254_1_.addStat(Stats.TALKED_TO_VILLAGER);
         }

         if (this.getOffers().isEmpty()) {
            return ActionResultType.func_233537_a_(this.world.isRemote);
         } else {
            if (!this.world.isRemote) {
               this.setCustomer(p_230254_1_);
               this.openMerchantContainer(p_230254_1_, this.getDisplayName(), 1);
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
         }
      } else {
         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      }
   }

   protected void populateTradeData() {
      $TraderTrades.ITrade[] a$tradertrades$itrade = $TraderTrades.field_221240_b.get(1);
      if (a$tradertrades$itrade != null) {
         MerchantOffers merchantoffers = this.getOffers();
         this.addTrades(merchantoffers, a$tradertrades$itrade, 10);
         int i = this.rand.nextInt(a$tradertrades$itrade.length);
         $TraderTrades.ITrade $tradertrades$itrade = a$tradertrades$itrade[i];
         MerchantOffer merchantoffer = $tradertrades$itrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            merchantoffers.add(merchantoffer);
         }

      }
   }*/

   public void setCustomer(@Nullable PlayerEntity player) {
      this.customer = player;
   }

   protected void applyEntityAI() {
      this.eatGrassGoal = new EatGrassGoal(this);
      this.eatPumpkinGoal = new EatPumpkinGoal(this);
      this.goalSelector.addGoal(2, new ZurAttackGoal(this, 1.0D, true));
      this.goalSelector.addGoal(1, new ZurTradeWithPlayerGoal(this));
      this.goalSelector.addGoal(4, new SwimGoal(this));
      this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 5.1D, Ingredient.fromItems(isBurnableItemInit.LEAT.get()), false));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombifiedPiglinEntity.class));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
      //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TraderNirtreEntity.class, true));
      this.goalSelector.addGoal(5, this.eatGrassGoal);
      this.goalSelector.addGoal(5, this.eatPumpkinGoal);
      this.goalSelector.addGoal(5, eatPumpkinGoal);
      this.goalSelector.addGoal(5, eatGrassGoal);
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 40.0D).createMutableAttribute(Attributes.ARMOR, 20.0D).createMutableAttribute(Attributes.MAX_HEALTH, 160);
   }

   public ZurEntity createChild(AgeableEntity ageable) {
      return EntityInit.ZUR_ENTITY.get().create(this.world);
   }

   protected void registerData() {
      super.registerData();
      this.getDataManager().register(IS_CHILD, false);
      this.getDataManager().register(ROVENT, false);
   }

   protected boolean func_234422_eK_() {
      return !this.field_234407_bB_;
   }

   protected boolean isDespawnPeaceful() {
      return false;
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return !this.isNoDespawnRequired();
   }

   public boolean isDrowning() {
      return this.getDataManager().get(ROVENT);
   }

   public boolean isBreakDoorsTaskSet() {
      return this.isBreakDoorsTaskSet;
   }

   public boolean Child() {
      return !this.isChild();
   }

   /**
    * Sets or removes EntityAIBreakDoor task
    */
   public void setBreakDoorsAItask(boolean enabled) {
      if (this.canBreakDoors()) {
         if (this.isBreakDoorsTaskSet != enabled) {
            this.isBreakDoorsTaskSet = enabled;
            ((GroundPathNavigator)this.getNavigator()).setBreakDoors(enabled);
            if (enabled) {
               this.goalSelector.addGoal(1, this.breakDoor);
            } else {
               this.goalSelector.removeGoal(this.breakDoor);
            }
         }
      } else if (this.isBreakDoorsTaskSet) {
         this.goalSelector.removeGoal(this.breakDoor);
         this.isBreakDoorsTaskSet = false;
      }

   }

   protected void onZurTrade(MerchantOffer offer) {
      if (offer.getDoesRewardExp()) {
         int i = 3 + this.rand.nextInt(4);
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
      }

   }

   /*protected SoundEvent getAmbientSound() {
      return this.hasCustomer() ? SoundEvents.ENTITY_WANDERING_TRADER_TRADE : SoundEvents.ENTITY_WANDERING_TRADER_AMBIENT;
   }

   protected SoundEvent getDrinkSound(ItemStack stack) {
      Item item = stack.getItem();
      return item == Items.MILK_BUCKET ? SoundEvents.ENTITY_WANDERING_TRADER_DRINK_MILK : SoundEvents.ENTITY_WANDERING_TRADER_DRINK_POTION;
   }

   protected SoundEvent getZurYesNoSound(boolean getYesSound) {
      return getYesSound ? SoundEvents.ENTITY_WANDERING_TRADER_YES : SoundEvents.ENTITY_WANDERING_TRADER_NO;
   }

   public SoundEvent getYesSound() {
      return SoundEvents.ENTITY_WANDERING_TRADER_YES;
   }

   public void setDespawnDelay(int delay) {
      this.despawnDelay = delay;
   }

   public int getDespawnDelay() {
      return this.despawnDelay;
   }*/

   class SitGoal extends Goal {
      private int field_220832_b;

      public SitGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (this.field_220832_b <= ZurEntity.this.ticksExisted && !ZurEntity.this.isChild() && !ZurEntity.this.isInWater()) {
            List<ItemEntity> list = ZurEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, ZurEntity.this.getBoundingBox().grow(6.0D, 6.0D, 6.0D), ZurEntity.ITEMS);
            return !list.isEmpty() || !ZurEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
         } else {
            return false;
         }
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
            //int i = ZurEntity.this.isLazy() ? ZurEntity.this.rand.nextInt(50) + 10 : PandaEntity.this.rand.nextInt(150) + 10;
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

   /*public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ActionResultType actionresulttype = super.func_230254_b_(p_230254_1_, p_230254_2_);
      if (actionresulttype.isSuccessOrConsume()) {
         return actionresulttype;
      } else if (!this.world.isRemote) {
         return ZurTasks.func_234471_a_(this, p_230254_1_, p_230254_2_);
      } else {
         boolean flag = ZurTasks.func_234489_b_(this, p_230254_1_.getHeldItem(p_230254_2_)) && this.func_234424_eM_() != Action.ADMIRING_ITEM;
         return flag ? ActionResultType.SUCCESS : ActionResultType.PASS;
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
      this.triggerItemPickupTrigger(itemEntity);
      ZurTasks.func_234470_a_(this, itemEntity);
   }

   private boolean func_234433_eX_() {
      return this.dataManager.get(field_234409_bv_);
   }

   public void setCharging(boolean isCharging) {
      this.dataManager.set(field_234409_bv_, isCharging);
   }

   /*protected Brain.BrainCodec<ZurEntity> getBrainCodec() {
      return Brain.func_233705_a_((Collection<? extends MemoryModuleType<?>>) field_234414_c_, field_234405_b_);
   }

   protected Brain<?> createBrain(Dynamic<?> dynamicIn) {
      return ZurTasks.func_234469_a_(this, this.getBrainCodec().func_233748_a_(dynamicIn));
   }

   protected void func_234439_n_(ItemStack p_234439_1_) {
      if (p_234439_1_.isZurCurrency()) {
         this.setItemStackToSlot(EquipmentSlotType.OFFHAND, p_234439_1_);
         this.func_233663_d_(EquipmentSlotType.OFFHAND);
      } else {
         this.func_233657_b_(EquipmentSlotType.OFFHAND, p_234439_1_);
      }

   }

   protected ItemStack func_234436_k_(ItemStack p_234436_1_) {
      return this.inventory.addItem(p_234436_1_);
   }

   protected boolean func_234437_l_(ItemStack p_234437_1_) {
      return this.inventory.func_233541_b_(p_234437_1_);
   }
*/

   private void func_234419_d_(EquipmentSlotType type, ItemStack stack) {
      if (this.world.rand.nextFloat() < 0.1F) {
         this.setItemStackToSlot(type, stack);
      }

   }

   public void livingTick() {
      super.livingTick();
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isZurJockey() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(isBurnableItemInit.LEAT.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
   }

   protected boolean func_234440_o_(ItemStack p_234440_1_) {
      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(p_234440_1_);
      ItemStack itemstack = this.getItemStackFromSlot(equipmentslottype);
      return this.shouldExchangeEquipment(p_234440_1_, itemstack);
   }

   public boolean isZurJockey() {
      return this.zurJockey;
   }

   protected boolean canBreakDoors() {
      return true;
   }

   /**
    * If Animal, checks if the age timer is negative
    */
   public boolean isChild() {
      return this.getDataManager().get(IS_CHILD);
   }

   /**
    * Get the experience points the entity currently has.
    */
   protected int getExperiencePoints(PlayerEntity player) {
      if (this.isChild()) {
         this.experienceValue = (int)((float)this.experienceValue * 10.0F);
      }

      return super.getExperiencePoints(player);
   }

   protected void func_234438_m_(ItemStack p_234438_1_) {
      this.func_233657_b_(EquipmentSlotType.MAINHAND, p_234438_1_);
   }

   /**
    * Set whether this zur is a child.
    */
   public void setChild(boolean childZur) {
      this.getDataManager().set(IS_CHILD, childZur);
      if (this.world != null && !this.world.isRemote) {
         ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
         modifiableattributeinstance.removeModifier(BABY_SPEED_BOOST);
         if (childZur) {
            modifiableattributeinstance.applyNonPersistentModifier(BABY_SPEED_BOOST);
         }
      }

   }

   public void notifyDataManagerChange(DataParameter<?> key) {
      if (IS_CHILD.equals(key)) {
         this.recalculateSize();
      }

      super.notifyDataManagerChange(key);
   }

   protected boolean shouldDrown() {
      return true;
   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      if (!this.world.isRemote && this.isAlive() && !this.isAIDisabled()) {
         if (this.isDrowning()) {
            --this.drownedConversionTime;
            if (this.drownedConversionTime < 0) {
               this.onRovent();
            }
         } else if (this.shouldDrown()) {
            if (this.areEyesInFluid(FluidTags.WATER)) {
               ++this.inWaterTime;
               if (this.inWaterTime >= 7200) {
                  this.startRovent(600);
               }
            } else {
               this.inWaterTime = -1;
            }
         }
      }

      super.tick();
   }

   private void startRovent(int p_204704_1_) {
      this.drownedConversionTime = p_204704_1_;
      this.getDataManager().set(ROVENT, true);
   }

   protected void onRovent() {
      this.func_234341_c_(EntityInit.ROVENT_ENTITY.get());
      if (!this.isSilent()) {
         this.world.playEvent(null, 1040, this.getPosition(), 0);
      }
   }

   protected void func_234341_c_(EntityType<? extends ZurEntity> p_234341_1_) {
      ZurEntity zurEntity = this.func_233656_b_(p_234341_1_);
      if (zurEntity != null) {
         zurEntity.applyAttributeBonuses(zurEntity.world.getDifficultyForLocation(zurEntity.getPosition()).getClampedAdditionalDifficulty());
         zurEntity.setBreakDoorsAItask(zurEntity.canBreakDoors() && this.isBreakDoorsTaskSet());
      }
   }

   protected void applyAttributeBonuses(float difficulty) {
      this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).applyPersistentModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * (double)0.05F, AttributeModifier.Operation.ADDITION));
      double d0 = this.rand.nextDouble() * 1.5D * (double)difficulty;
      if (d0 > 1.0D) {
         this.getAttribute(Attributes.FOLLOW_RANGE).applyPersistentModifier(new AttributeModifier("Random zur-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
      }

      if (this.rand.nextFloat() < difficulty * 0.05F) {
         this.getAttribute(Attributes.MAX_HEALTH).applyPersistentModifier(new AttributeModifier("Leader zur bonus", this.rand.nextDouble() * 3.0D + 1.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
         this.setBreakDoorsAItask(this.canBreakDoors());
      }

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
      return CreatureAttribute.UNDEAD;
   }

   /**
    * Gives armor or weapon for entity based on given DifficultyInstance
    */
   protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
      super.setEquipmentBasedOnDifficulty(difficulty);
      if (this.Child()) {
         this.func_234419_d_(EquipmentSlotType.HEAD, new ItemStack(isBurnableItemInit.SRIUNK_HELMET.get()));
         this.func_234419_d_(EquipmentSlotType.CHEST, new ItemStack(isBurnableItemInit.SRIUNK_CHESTPLATE.get()));
         this.func_234419_d_(EquipmentSlotType.LEGS, new ItemStack(isBurnableItemInit.SRIUNK_LEGGINGS.get()));
         this.func_234419_d_(EquipmentSlotType.FEET, new ItemStack(isBurnableItemInit.SRIUNK_BOOTS.get()));
      }
      if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 50.0F : 10.0F)) {
         int i = this.rand.nextInt(192);
         if (i == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK_SWORD.get()));
         } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK_SHOVEL.get()));
         }
      }
      if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.NORMAL ? 5.0F : 1.0F)) {
         int i = this.rand.nextInt(48);
         if (i == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.DURG_SWORD.get()));
         } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.DURG_SHOVEL.get()));
         }
      }
      if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 0.5F : 0.1F)) {
         int i = this.rand.nextInt(36);
         if (i == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK_SWORD.get()));
         } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK_SHOVEL.get()));
         }
      }

   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putBoolean("IsZurJockey", this.zurJockey);
      if (this.isChild()) {
         compound.putBoolean("IsBaby", true);
      }

      compound.putBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
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
         ZurEntity zurNirtreEntity = EntityInit.ZUR_ENTITY.get().create(this.world);
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

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return this.isChild() ? 0.93F : 1.74F;
   }

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

   class AttackGrassBlockGoal extends BreakBlockGoal {
      AttackGrassBlockGoal(CreatureEntity creatureIn, double speed, int yMax) {
         super(Blocks.GRASS_BLOCK, creatureIn, speed, yMax);
      }

      public void playBreakingSound(IWorld worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_STEP, SoundCategory.HOSTILE, 0.5F, 0.9F + ZurEntity.this.rand.nextFloat() * 0.2F);
      }

      public void playBrokenSound(World worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
      }

      public double getTargetDistanceSq() {
         return 1.14D;
      }
   }

   class AttackPumpkinGoal extends BreakBlockGoal {
      AttackPumpkinGoal(CreatureEntity creatureIn, double speed, int yMax) {
         super(Blocks.PUMPKIN, creatureIn, speed, yMax);
      }

      public void playBreakingSound(IWorld worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_STEP, SoundCategory.HOSTILE, 0.5F, 0.9F + ZurEntity.this.rand.nextFloat() * 0.2F);
      }

      public void playBrokenSound(World worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
      }

      public double getTargetDistanceSq() {
         return 1.14D;
      }
   }

   public boolean isBreedingItem(ItemStack stack) {
      return TEMPTATION_ITEMS.test(stack);
   }

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

   /*public enum Action {
      ATTACKING_WITH_MELEE_WEAPON,
      CROSSBOW_HOLD,
      CROSSBOW_CHARGE,
      ADMIRING_ITEM,
      DANCING,
      DEFAULT;
   }*/
}