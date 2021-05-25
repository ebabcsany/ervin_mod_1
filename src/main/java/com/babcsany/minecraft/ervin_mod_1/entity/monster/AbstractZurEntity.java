package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal.BowAttackGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.ZurTrades;
import com.babcsany.minecraft.ervin_mod_1.entity.trigger.CriteriaTriggers1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.potion.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

public abstract class AbstractZurEntity extends AgeableEntity implements INPC, IMerchant {
   public final NonNullList<ItemStack> inventory = NonNullList.withSize(1000000, ItemStack.EMPTY);
   private final BowAttackGoal<AbstractZurEntity> aiArrowAttack = new BowAttackGoal<>(this, 1.0D, 20, 15.0F);
   private static final UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
   public static final AttributeModifier MODIFIER = new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", -1.6D, AttributeModifier.Operation.ADDITION);
   private static final DataParameter<Integer> SHAKE_HEAD_TICKS = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.VARINT);
   private static final DataParameter<Boolean> IS_DRINKING = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BOOLEAN);
   private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
   public static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
   private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Integer> TRADER_TYPE = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.VARINT);
   public static final DataParameter<Boolean> ROVENT = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BYTE);
   private final List<NonNullList<ItemStack>> allInventories = ImmutableList.of(this.inventory);
   private final BreakDoorGoal breakDoor = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
   private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> p_213697_0_ == Difficulty.HARD;
   @Nullable
   private PlayerEntity customer;
   private boolean swimmingUp;
   protected final SwimmerPathNavigator waterNavigator;
   protected final GroundPathNavigator groundNavigator;
   public int potionUseTimer;
   public float wingRotation;
   private int inWaterTime;
   @Nullable
   protected Raid raid;
   private int wave;
   private boolean canJoinRaid;
   private int field_213664_bB;
   private boolean patrolLeader;
   private boolean patrolling;
   private int despawnDelay;
   public boolean zurDropItem;
   public float wingRotDelta = 1.0F;
   private boolean isBreakDoorsTaskSet;
   private int eatingGrassTimer;
   private int drownedConversionTime;
   private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2D, true) {
      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         super.resetTask();
         AbstractZurEntity.this.setAggroed(false);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         super.startExecuting();
         AbstractZurEntity.this.setAggroed(true);
      }
   };
   @Nullable
   protected MerchantOffers offers;
   public int currentItem;
   public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
   private final Inventory zurInventory = new Inventory(1000000);

   public AbstractZurEntity(EntityType<? extends AbstractZurEntity> type, World worldIn) {
      super(type, worldIn);
      this.experienceValue = 5;
      this.setPathPriority(PathNodeType.DANGER_FIRE, 16.0F);
      this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1.0F);
      this.waterNavigator = new SwimmerPathNavigator(this, worldIn);
      this.groundNavigator = new GroundPathNavigator(this, worldIn);
   }

   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      if (spawnDataIn == null) {
         spawnDataIn = new AgeableData();
         ((AgeableData)spawnDataIn).setCanBabySpawn(true);
      }

      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   public boolean isPushedByWater() {
      return !this.isSwimming();
   }

   private boolean func_204715_dF() {
      if (this.swimmingUp) {
         return true;
      } else {
         LivingEntity livingentity = this.getAttackTarget();
         return livingentity != null && livingentity.isInWater();
      }
   }

   public void travel(Vector3d travelVector) {
      if (this.isServerWorld() && this.isInWater() && this.func_204715_dF()) {
         this.moveRelative(0.01F, travelVector);
         this.move(MoverType.SELF, this.getMotion());
         this.setMotion(this.getMotion().scale(0.9D));
      } else {
         super.travel(travelVector);
      }

   }

   public void updateSwimming() {
      if (!this.world.isRemote) {
         if (this.isServerWorld() && this.isInWater() && this.func_204715_dF()) {
            this.navigator = this.waterNavigator;
            this.setSwimming(true);
         } else {
            this.navigator = this.groundNavigator;
            this.setSwimming(false);
         }
      }

   }

   protected boolean isCloseToPathTarget() {
      Path path = this.getNavigator().getPath();
      if (path != null) {
         BlockPos blockpos = path.getTarget();
         if (blockpos != null) {
            double d0 = this.getDistanceSq((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
            if (d0 < 4.0D) {
               return true;
            }
         }
      }

      return false;
   }

   /*public void breakBlockGoals() {
      this.goalSelector.addGoal(5, new AttackDirtGoal(this, 4, 6));
      this.goalSelector.addGoal(5, new AttackGrassBlockGoal(this, 4, 6));
   }*/

   /**
    * sets this entity's combat AI.
    */
   public void setCombatTask() {
      if (this.world != null && !this.world.isRemote) {
         this.goalSelector.removeGoal(this.aiAttackOnCollide);
         this.goalSelector.removeGoal(this.aiArrowAttack);
         ItemStack itemstack = this.getHeldItem(ProjectileHelper.getHandWith(this, isBurnableItemInit.TRITHK.get()));
         if (itemstack.getItem() instanceof net.minecraft.item.BowItem) {
            int i = 20;
            if (this.world.getDifficulty() != Difficulty.HARD) {
               i = 40;
            }

            this.aiArrowAttack.setAttackCooldown(i);
            this.goalSelector.addGoal(4, this.aiArrowAttack);
         } else {
            this.goalSelector.addGoal(4, this.aiAttackOnCollide);
         }

      }
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(CLIMBING, (byte)1);
      this.dataManager.register(SHAKE_HEAD_TICKS, 0);
      this.getDataManager().register(IS_CHILD, false);
      this.getDataManager().register(IS_DRINKING, false);
      this.getDataManager().register(TRADER_TYPE, 0);
      this.getDataManager().register(ROVENT, false);
   }

   protected boolean shouldDrown() {
      return true;
   }

   public boolean isDrowning() {
      return this.getDataManager().get(ROVENT);
   }

   public boolean Child() {
      return !this.isChild();
   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      if (!this.world.isRemote) {
         this.setBesideClimbableBlock(this.collidedHorizontally);
      }
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
                  this.startRovent();
               }
            } else {
               this.inWaterTime = 1000;
            }
         }
      }

      super.tick();
   }

   public boolean canBeLeader() {
      return true;
   }

   public void setLeader(boolean isLeader) {
      this.patrolLeader = isLeader;
      this.patrolling = true;
   }

   protected boolean canBreakDoors() {
      return true;
   }

   public void setRaid(@Nullable Raid p_213652_1_) {
      this.raid = p_213652_1_;
   }

   public void func_213644_t(boolean p_213644_1_) {
      this.canJoinRaid = p_213644_1_;
   }

   public abstract void applyWaveBonus(int p_213660_1_, boolean p_213660_2_);

   public void func_213653_b(int p_213653_1_) {
      this.field_213664_bB = p_213653_1_;
   }

   public void setWave(int p_213651_1_) {
      this.wave = p_213651_1_;
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

   private void startRovent() {
      this.drownedConversionTime = 600;
      this.getDataManager().set(ROVENT, true);
   }

   protected void onRovent() {
      this.func_234341_c_(EntityInit.ROVENT_ENTITY.get());
      if (!this.isSilent()) {
         this.world.playEvent(null, 1040, this.getPosition(), 0);
      }
   }

   protected void func_234341_c_(EntityType<? extends ZurEntity> zur) {
      ZurEntity zurEntity = this.func_233656_b_(zur);
      if (zurEntity != null) {
         zurEntity.applyAttributeBonuses(zurEntity.world.getDifficultyForLocation(zurEntity.getPosition()).getClampedAdditionalDifficulty());
         zurEntity.setBreakDoorsAItask(zurEntity.canBreakDoors() && this.isBreakDoorsTaskSet());
      }
   }

   public boolean isBreakDoorsTaskSet() {
      return this.isBreakDoorsTaskSet;
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

   ItemStack func_234432_eW_() { return this.rand.nextFloat() < 0.5D ? new ItemStack(isBurnableItemInit.SRIUNK_STICK.get()) : new ItemStack(isBurnableSpecialItemInit.DEBUG_SRIUNK_STICK.get()); }

   ItemStack func_234432_eW1_() { return this.rand.nextFloat() < 0.5D ? new ItemStack(isBurnableItemInit.VIRKT.get()) : new ItemStack(isBurnableBlockItemInit.NETHER_PORTAL.get()); }

   /**
    * Set whether this zur is a child.
    */
   public void setChild(boolean childZur) {
      this.getDataManager().set(IS_CHILD, childZur);
      if (this.world != null && !this.world.isRemote) {
         ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
         Objects.requireNonNull(modifiableattributeinstance).removeModifier(BABY_SPEED_BOOST);
         if (childZur) {
            modifiableattributeinstance.applyNonPersistentModifier(BABY_SPEED_BOOST);
         }
      }

   }

   /**
    * If Zur, checks if the age timer is negative
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

   public void notifyDataManagerChange(DataParameter<?> key) {
      if (IS_CHILD.equals(key)) {
         this.recalculateSize();
      }

      super.notifyDataManagerChange(key);
   }

   public int getXp() {
      return 0;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return this.isChild() ? 0.93F : 1.74F;
   }

   public void setCustomer(@Nullable PlayerEntity player) {
      this.customer = player;
   }

   @Nullable
   public PlayerEntity getCustomer() {
      return this.customer;
   }

   public boolean hasCustomer() {
      return this.customer != null;
   }

   public MerchantOffers getOffers() {
      if (this.offers == null) {
         this.offers = new MerchantOffers();
         this.populateTradeData();
      }

      return this.offers;
   }

   @OnlyIn(Dist.CLIENT)
   public void setClientSideOffers(@Nullable MerchantOffers offers) {
   }

   public void setXP(int xpIn) {
   }

   public void onTrade(MerchantOffer offer) {
      offer.increaseUses();
      this.livingSoundTime = -this.getTalkInterval();
      this.onZurTrade(offer);
      if (this.customer instanceof ServerPlayerEntity) {
         CriteriaTriggers1.ZUR_TRADE.test((ServerPlayerEntity)this.customer, this, offer.getSellingStack());
      }

   }

   protected abstract void onZurTrade(MerchantOffer offer);

   public boolean func_213705_dZ() {
      return true;
   }

   /**
    * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
    * being played depending if the suggested itemstack is not null.
    */
   public void verifySellingItem(ItemStack stack) {
      if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
         this.livingSoundTime = -this.getTalkInterval();
         this.playSound(this.getZurYesNoSound(!stack.isEmpty()), this.getSoundVolume(), this.getSoundPitch());
      }

   }

   public SoundEvent getYesSound() {
      return SoundEvents.AMBIENT_CAVE;
   }

   protected SoundEvent getZurYesNoSound(boolean getYesSound) {
      return getYesSound ? SoundEvents.AMBIENT_CAVE : SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS;
   }

   public void playCelebrateSound() {
      this.playSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, this.getSoundVolume(), this.getSoundPitch());
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      MerchantOffers merchantoffers = this.getOffers();
      if (!merchantoffers.isEmpty()) {
         compound.put("Offers", merchantoffers.write());
      }

      compound.put("Inventory", this.zurInventory.write());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("Offers", 10)) {
         this.offers = new MerchantOffers(compound.getCompound("Offers"));
      }

      this.zurInventory.read(compound.getList("Inventory", 10));
   }

   @Nullable
   public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
      this.resetCustomer();
      return super.changeDimension(server, teleporter);
   }

   protected void resetCustomer() {
      this.setCustomer(null);
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void onDeath(DamageSource cause) {
      super.onDeath(cause);
      this.resetCustomer();
   }

   @OnlyIn(Dist.CLIENT)
   protected void spawnParticles(IParticleData particleData) {
      for(int i = 0; i < 5; ++i) {
         double d0 = this.rand.nextGaussian() * 0.02D;
         double d1 = this.rand.nextGaussian() * 0.02D;
         double d2 = this.rand.nextGaussian() * 0.02D;
         this.world.addParticle(particleData, this.getPosXRandom(1.0D), this.getPosYRandom() + 1.0D, this.getPosZRandom(1.0D), d0, d1, d2);
      }

   }

   public boolean canBeLeashedTo(PlayerEntity player) {
      return false;
   }

   public Inventory getZurInventory() {
      return this.zurInventory;
   }

   public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
      if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
         return true;
      } else {
         int i = inventorySlot - 300;
         if (i >= 0 && i < this.zurInventory.getSizeInventory()) {
            this.zurInventory.setInventorySlotContents(i, itemStackIn);
            return true;
         } else {
            return false;
         }
      }
   }

   public World getWorld() {
      return this.world;
   }

   protected abstract boolean populateTradeData();

   /**
    * add limites numbers of trades to the given MerchantOffers
    */
   protected void addTrades(MerchantOffers givenMerchantOffers, ZurTrades.ITrade[] newTrades, int maxNumbers) {
      Set<Integer> set = Sets.newHashSet();
      if (newTrades.length > maxNumbers) {
         while(set.size() < maxNumbers) {
            set.add(this.rand.nextInt(newTrades.length));
         }
      } else {
         for(int i = 0; i < newTrades.length; ++i) {
            set.add(i);
         }
      }

      for(Integer integer : set) {
         ZurTrades.ITrade $tradertrades$itrade = newTrades[integer];
         MerchantOffer merchantoffer = $tradertrades$itrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            givenMerchantOffers.add(merchantoffer);
         }
      }

   }

   public SoundCategory getSoundCategory() {
      return SoundCategory.HOSTILE;
   }

   /**
    * Set whether this witch is aggressive at an entity.
    */
   public void setDrinkingPotion(boolean drinkingPotion) {
      this.getDataManager().set(IS_DRINKING, drinkingPotion);
   }

   public boolean isDrinkingPotion() {
      return this.getDataManager().get(IS_DRINKING);
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zurs and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      boolean flag = this.isInDaylight();
      this.updateArmSwingProgress();
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (this.world.isRemote) {
         this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
      }
      if (!this.world.isRemote) {
         this.handleDespawn();
      }
      if (!this.world.isRemote && this.isAlive()) {
         if (this.isDrinkingPotion()) {
            if (this.potionUseTimer-- <= 0) {
               this.setDrinkingPotion(false);
               ItemStack itemstack = this.getHeldItemMainhand();
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
               if (itemstack.getItem() == Items.POTION) {
                  List<EffectInstance> list = PotionUtils.getEffectsFromStack(itemstack);
                  for(EffectInstance effectinstance : list) {
                     this.addPotionEffect(new EffectInstance(effectinstance));
                  }
               }

               this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(MODIFIER);
            }
         } else {
            Potion potion = null;
            if (this.rand.nextFloat() < 0.15F && this.areEyesInFluid(FluidTags.WATER) && !this.isPotionActive(Effects.WATER_BREATHING)) {
               potion = Potions.WATER_BREATHING;
            } else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(Effects.FIRE_RESISTANCE)) {
               potion = Potions.FIRE_RESISTANCE;
            } else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
               potion = Potions.HEALING;
            } else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(Effects.SPEED) && !this.isPotionActive(Effects.JUMP_BOOST) && !this.isPotionActive(Effects.STRENGTH) && this.getAttackTarget().getDistanceSq(this) > 121.0D) {
               potion = Potions.SWIFTNESS;
            }

            if (potion != null) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potion));
               this.potionUseTimer = this.getHeldItemMainhand().getUseDuration();
               this.setDrinkingPotion(true);
               if (!this.isSilent()) {
                  this.world.playSound(null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
               }

               ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
               modifiableattributeinstance.removeModifier(MODIFIER);
               modifiableattributeinstance.applyNonPersistentModifier(MODIFIER);
            }
         }

         if (this.rand.nextFloat() < 7.5E-4F) {
            this.world.setEntityState(this, (byte)15);
         }
      }
      if (flag) {
         ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
         if (!itemstack.isEmpty()) {
            if (itemstack.isDamageable()) {
               itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
               if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
                  this.sendBreakAnimation(EquipmentSlotType.HEAD);
                  this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
               }
            }
         }
      }
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isZurDropItem() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(isBurnableItemInit.LEAT.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
   }

   public boolean isZurDropItem() {
      return this.zurDropItem;
   }

   public void handleDespawn() {
      if (this.despawnDelay > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
         this.remove();
      }

   }

   protected void func_213623_ec() {
      float f = this.getBrightness();
      if (f > 0.5F) {
         this.idleTime += 2;
      }

   }

   protected SoundEvent getSwimSound() {
      return SoundEvents.ENTITY_HOSTILE_SWIM;
   }

   protected SoundEvent getSplashSound() {
      return SoundEvents.ENTITY_HOSTILE_SPLASH;
   }

   private boolean stackEqualExact(ItemStack stack1, ItemStack stack2) {
      return stack1.getItem() == stack2.getItem() && ItemStack.areItemStackTagsEqual(stack1, stack2);
   }

   private boolean canMergeStacks(ItemStack stack1, ItemStack stack2) {
      return !stack1.isEmpty() && this.stackEqualExact(stack1, stack2) && stack1.isStackable() && stack1.getCount() < stack1.getMaxStackSize() && stack1.getCount() < this.getInventoryStackLimit();
   }

   int getInventoryStackLimit() {
      return 1000000000;
   }

   public int storeItemStack(ItemStack itemStackIn) {
      if (this.canMergeStacks(this.getStackInSlot(this.currentItem), itemStackIn)) {
         return this.currentItem;
      } else if (this.canMergeStacks(this.getStackInSlot(40), itemStackIn)) {
         return 40;
      } else {
         for(int i = 0; i < this.inventory.size(); ++i) {
            if (this.canMergeStacks(this.inventory.get(i), itemStackIn)) {
               return i;
            }
         }

         return -1;
      }
   }

   public ItemStack getStackInSlot(int index) {
      List<ItemStack> list = null;

      for(NonNullList<ItemStack> nonnulllist : this.allInventories) {
         if (index < nonnulllist.size()) {
            list = nonnulllist;
            break;
         }

         index -= nonnulllist.size();
      }

      return list == null ? ItemStack.EMPTY : list.get(index);
   }

   public int getFirstEmptyStack() {
      for(int i = 0; i < this.inventory.size(); ++i) {
         if (this.inventory.get(i).isEmpty()) {
            return i;
         }
      }

      return -1;
   }

   public void placeItemBackInInventory(World worldIn, ItemStack stack) {
      if (!worldIn.isRemote) {
         while(!stack.isEmpty()) {
            int i = this.storeItemStack(stack);
            if (i == -1) {
               i = this.getFirstEmptyStack();
            }
         }

      }
   }

   protected SoundEvent getFallSound(int heightIn) {
      return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
   }

   public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
      return 0.5F - worldIn.getBrightness(pos);
   }

   /**
    * Static predicate for determining if the current light level and environmental conditions allow for a monster to
    * spawn.
    * /
   public static boolean isValidLightLevel(IWorld worldIn, BlockPos pos, Random randomIn) {
      if (worldIn.getLightFor(LightType.SKY, pos) > randomIn.nextInt(32)) {
         return false;
      } else {
         int i = worldIn.getWorld().isThundering() ? worldIn.getNeighborAwareLightSubtracted(pos, 10) : worldIn.getLight(pos);
         return i <= randomIn.nextInt(8);
      }
   }*/

   public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
      BlockPos blockpos = pos.add(1,1,1);
      return reason == SpawnReason.SPAWNER || worldIn.getBlockState(blockpos).canEntitySpawn(worldIn, blockpos, typeIn);
   }

    /**
    * Static predicate for determining whether or not a monster can spawn at the provided location.
    */
    /*public static boolean canMonsterSpawn(EntityType<? extends MonsterEntity> type, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
    return worldIn.getDifficulty() != Difficulty.PEACEFUL && canSpawnOn(type, worldIn, reason, pos, randomIn);
    }*/

   public static AttributeModifierMap.MutableAttribute func_234295_eP_() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE);
   }

   /**
    * Entity won't drop items or experience points if this returns false
    */
   protected boolean canDropLoot() {
      return true;
   }

   protected boolean func_230282_cS_() {
      return true;
   }

   public boolean func_230292_f_(PlayerEntity p_230292_1_) {
      return true;
   }

   public ItemStack findAmmo(ItemStack shootable) {
      if (shootable.getItem() instanceof ShootableItem) {
         Predicate<ItemStack> predicate = ((ShootableItem)shootable.getItem()).getAmmoPredicate();
         ItemStack itemstack = ShootableItem.getHeldAmmo(this, predicate);
         return itemstack.isEmpty() ? new ItemStack(Items.ARROW) : itemstack;
      } else {
         return ItemStack.EMPTY;
      }
   }
   public static class LeapAtTargetGoal extends Goal {
      private final MobEntity leaper;
      private LivingEntity leapTarget;
      private final float leapMotionY;

      public LeapAtTargetGoal(MobEntity leapingEntity, float leapMotionYIn) {
         this.leaper = leapingEntity;
         this.leapMotionY = leapMotionYIn;
         this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (this.leaper.isBeingRidden()) {
            return false;
         } else {
            this.leapTarget = this.leaper.getAttackTarget();
            if (this.leapTarget == null) {
               return false;
            } else {
               double d0 = this.leaper.getDistanceSq(this.leapTarget);
               if (!(d0 < 4.0D) && !(d0 > 16.0D)) {
                  if (!this.leaper.isOnGround()) {
                     return false;
                  } else {
                     return this.leaper.getRNG().nextInt(5) == 0;
                  }
               } else {
                  return false;
               }
            }
         }
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return !this.leaper.isOnGround();
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         Vector3d vector3d = this.leaper.getMotion();
         Vector3d vector3d1 = new Vector3d(this.leapTarget.getPosX() - this.leaper.getPosX(), 0.0D, this.leapTarget.getPosZ() - this.leaper.getPosZ());
         if (vector3d1.lengthSquared() > 1.0E-7D) {
            vector3d1 = vector3d1.normalize().scale(0.4D).add(vector3d.scale(0.2D));
         }

         this.leaper.setMotion(vector3d1.x, this.leapMotionY, vector3d1.z);
      }
   }

   static class AttackGoal extends MeleeAttackGoal {
      public AttackGoal(ZurEntity zur) {
         super(zur, 1.0D, true);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return super.shouldExecute() && !this.attacker.isBeingRidden();
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         float f = this.attacker.getBrightness();
         if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
            this.attacker.setAttackTarget(null);
            return false;
         } else {
            return super.shouldContinueExecuting();
         }
      }

      protected double getAttackReachSqr(LivingEntity attackTarget) {
         return 4.0F + attackTarget.getWidth();
      }
   }

   static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
      public TargetGoal(ZurEntity zur, Class<T> classTarget) {
         super(zur, classTarget, true);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         float f = this.goalOwner.getBrightness();
         return !(f >= 0.5F) && super.shouldExecute();
      }
   }

   /**
    * Returns true if this entity should move as if it were on a ladder (either because it's actually on a ladder, or
    * for AI reasons)
    */
   public boolean isOnLadder() {
      return this.isBesideClimbableBlock();
   }

   public void setMotionMultiplier(BlockState state, Vector3d motionMultiplierIn) {
      if (!state.isIn(Blocks.COBWEB)) {
         super.setMotionMultiplier(state, motionMultiplierIn);
      }

   }

   public CreatureAttribute getCreatureAttribute() {
      return CreatureAttribute.ARTHROPOD;
   }

   public boolean isPotionApplicable(EffectInstance potioneffectIn) {
      if (potioneffectIn.getPotion() == Effects.POISON) {
         net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent event = new net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent(this, potioneffectIn);
         net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
         return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
      }
      return super.isPotionApplicable(potioneffectIn);
   }

   /**
    * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
    * setBesideClimableBlock.
    */
   public boolean isBesideClimbableBlock() {
      return (this.dataManager.get(CLIMBING) & 1) != 0;
   }

   /**
    * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
    * false.
    */
   public void setBesideClimbableBlock(boolean climbing) {
      byte b0 = this.dataManager.get(CLIMBING);
      if (climbing) {
         b0 = (byte)(b0 | 1);
      } else {
         b0 = (byte)(b0 & -2);
      }

      this.dataManager.set(CLIMBING, b0);
   }

   /*class AttackDirtGoal extends net.minecraft.entity.ai.goal.BreakBlockGoal {
      public AttackDirtGoal(CreatureEntity creatureIn, double speed, int yMax) {
         super(Blocks.DIRT, creatureIn, speed, yMax);
      }

      public void playBreakingSound(IWorld worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_STEP, SoundCategory.HOSTILE, 0.5F, 0.9F + AbstractZurEntity.this.rand.nextFloat() * 0.2F);
      }

      public void playBrokenSound(World worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
      }

      public double getTargetDistanceSq() {
         return 1.14D;
      }
   }

   class AttackGrassBlockGoal extends net.minecraft.entity.ai.goal.BreakBlockGoal {
      public AttackGrassBlockGoal(CreatureEntity creatureIn, double speed, int yMax) {
         super(Blocks.GRASS_BLOCK, creatureIn, speed, yMax);
      }

      public void playBreakingSound(IWorld worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_STEP, SoundCategory.HOSTILE, 0.5F, 0.9F + AbstractZurEntity.this.rand.nextFloat() * 0.2F);
      }

      public void playBrokenSound(World worldIn, BlockPos pos) {
         worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
      }

      public double getTargetDistanceSq() {
         return 1.14D;
      }
   }*/
}
