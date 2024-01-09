package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal.BowAttackGoal;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.potion.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.village.GossipManager;
import net.minecraft.world.*;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

public abstract class AbstractZurEntity extends AgeableEntity {
   public final NonNullList<ItemStack> inventory = NonNullList.withSize(1000000, ItemStack.EMPTY);
   private final BowAttackGoal<AbstractZurEntity> aiArrowAttack = new BowAttackGoal<>(this, 1.0D, 20, 15.0F);
   private static final UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
   public static final AttributeModifier MODIFIER = new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", 0.6D, AttributeModifier.Operation.ADDITION);
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
   protected static final DataParameter<Optional<BlockState>> CARRIED_BLOCK = EntityDataManager.createKey(ZurEntity.class, DataSerializers.OPTIONAL_BLOCK_STATE);
   public static final Map<Item, Integer> FOOD_VALUES = ImmutableMap.of(Items.BREAD, 4, Items.POTATO, 1, Items.CARROT, 1, Items.BEETROOT, 1);
   @Nullable
   public BlockPos zurTarget;
   @Nullable
   private PlayerEntity previousCustomer;
   private AbstractZurEntity zur;
   private boolean swimmingUp;
   private CompoundNBT dataTag;
   private boolean doesRewardEXP = true;
   protected final SwimmerPathNavigator waterNavigator;
   protected final GroundPathNavigator groundNavigator;
   public int potionUseTimer;
   public float wingRotation;
   public int experienceLevel;
   public int experienceTotal;
   public float experience;
   protected int xpSeed;
   private int inWaterTime;
   @Nullable
   protected Raid raid;
   private int sleepTimer;
   public int xpCooldown;
   private byte foodLevel;
   private int xp;
   private final GossipManager gossip = new GossipManager();
   private boolean field_234542_bL_;
   private long lastGossipDecay;
   private int level;
   private int timeUntilReset;
   private boolean leveledUp;
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
   public int currentItem;
   public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;

   public AbstractZurEntity(EntityType<? extends AbstractZurEntity> type, World worldIn) {
      super(type, worldIn);
      this.experienceValue = 5;
      this.setPathPriority(PathNodeType.DANGER_FIRE, 16.0F);
      this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1.0F);
      this.waterNavigator = new SwimmerPathNavigator(this, worldIn);
      this.groundNavigator = new GroundPathNavigator(this, worldIn);
      this.setCanPickUpLoot(true);
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
         double d0 = this.getDistanceSq(blockpos.getX(), blockpos.getY(), blockpos.getZ());
         return d0 < 4.0D;
      }

      return false;
   }

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

         this.tickGossip();
      }
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(CARRIED_BLOCK, Optional.empty());
      this.dataManager.register(CLIMBING, (byte)3);
      this.dataManager.register(SHAKE_HEAD_TICKS, 0);
      this.dataManager.register(IS_DRINKING, Boolean.TRUE);
      this.getDataManager().register(IS_CHILD, false);
   }

   public int getLevel() {
      return this.level;
   }

   private boolean canLevelUp() {
      int i = this.getLevel();
      return canLevelUp(i) && this.xp >= VillagerData.func_221127_c(i);
   }

   public static boolean canLevelUp(int level) {
      return level >= 1 && level < 5;
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(4, new AttackGoal(this));
   }

   public void func_234438_m_(ItemStack p_234438_1_) {
      this.func_233657_b_(EquipmentSlotType.MAINHAND, p_234438_1_);
   }

   protected boolean shouldDrown() {
      return true;
   }

   public boolean isDrowning() {
      return this.getDataManager().get(ROVENT);
   }

   public boolean isNotChild() {
      return !this.isChild();
   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (!this.world.isRemote) {
         this.setBesideClimbableBlock(this.collidedHorizontally);
      }

      if (this.xpCooldown > 0) {
         --this.xpCooldown;
      }
   }

   private void tickGossip() {
      long i = this.world.getGameTime();
      if (this.lastGossipDecay == 0L) {
         this.lastGossipDecay = i;
      } else if (i >= this.lastGossipDecay + 24000L) {
         this.gossip.tick();
         this.lastGossipDecay = i;
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

   public int getPlayerReputation(PlayerEntity player) {
      return this.gossip.getReputation(player.getUniqueID(), (p_223103_0_) -> true);
   }

   public boolean canBeLeader() {
      return true;
   }

   public void setLeader(boolean isLeader) {
      boolean patrolling = true;
   }

   protected boolean canBreakDoors() {
      return true;
   }

   public void setRaid(@Nullable Raid p_213652_1_) {
      this.raid = p_213652_1_;
   }

   public void func_213644_t(boolean p_213644_1_) {
   }

   public abstract void applyWaveBonus(int p_213660_1_, boolean p_213660_2_);

   public void func_213653_b(int p_213653_1_) {
   }

   public void setWave(int p_213651_1_) {
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

   protected void func_234341_c_(EntityType<RoventEntity> zur) {
      RoventEntity zurEntity = this.func_233656_b_(zur);
      if (zurEntity != null) {
         zurEntity.applyAttributeBonuses(zurEntity.world.getDifficultyForLocation(zurEntity.getPosition()).getClampedAdditionalDifficulty());
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
         } else if (this.isNotChild()) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, this.func_234432_eW_());
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, this.func_234432_eW1_());
         }
      }

      this.setEquipmentBasedOnDifficulty(difficultyIn);
      this.setEquipmentBasedOnDifficulty1(difficultyIn);
      this.setEnchantmentBasedOnDifficulty(difficultyIn);
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   private void equipmentSlotType(EquipmentSlotType type, ItemStack stack) {
      if (this.world.rand.nextFloat() < 0.1F) {
         this.setItemStackToSlot(type, stack);
      }

   }

   /**
    * Creates and drops the provided item. Depending on the dropAround, it will drop teh item around the player, instead
    * of dropping the item from where the player is pointing at. Likewise, if traceItem is true, the dropped item entity
    * will have the thrower set as the player.
    */
   @Nullable
   public ItemEntity dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem) {
      if (droppedItem.isEmpty()) {
         return null;
      } else {
         if (this.world.isRemote) {
            this.swingArm(Hand.MAIN_HAND);
         }

         double d0 = this.getPosYEye() - (double)0.3F;
         ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), d0, this.getPosZ(), droppedItem);
         itementity.setPickupDelay(40);
         if (traceItem) {
            itementity.setThrowerId(this.getUniqueID());
         }

         if (dropAround) {
            float f = this.rand.nextFloat() * 0.5F;
            float f1 = this.rand.nextFloat() * ((float)Math.PI * 2F);
            itementity.setMotion((double)(-MathHelper.sin(f1) * f), (double)0.2F, (double)(MathHelper.cos(f1) * f));
         } else {
            float f7 = 0.3F;
            float f8 = MathHelper.sin(this.rotationPitch * ((float)Math.PI / 180F));
            float f2 = MathHelper.cos(this.rotationPitch * ((float)Math.PI / 180F));
            float f3 = MathHelper.sin(this.rotationYaw * ((float)Math.PI / 180F));
            float f4 = MathHelper.cos(this.rotationYaw * ((float)Math.PI / 180F));
            float f5 = this.rand.nextFloat() * ((float)Math.PI * 2F);
            float f6 = 0.02F * this.rand.nextFloat();
            itementity.setMotion((double)(-f3 * f2 * 0.3F) + Math.cos((double)f5) * (double)f6, (double)(-f8 * 0.3F + 0.1F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F), (double)(f4 * f2 * 0.3F) + Math.sin((double)f5) * (double)f6);
         }

         return itementity;
      }
   }

   /**
    * Gives armor or weapon for entity based on given DifficultyInstance
    */
   protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
      if (world.isRemote) {
         if (this.isNotChild()) {
            this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.SRIUNK_HELMET.get()));
            this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.SRIUNK_CHESTPLATE.get()));
            this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.SRIUNK_LEGGINGS.get()));
            this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.SRIUNK_BOOTS.get()));
         }
         if (this.isNotChild()) {
            this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.DURG_HELMET.get()));
            this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.DURG_CHESTPLATE.get()));
            this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.DURG_LEGGINGS.get()));
            this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.DURG_BOOTS.get()));
         }
         if (this.isNotChild()) {
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
      if (this.isNotChild()) {
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

   @OnlyIn(Dist.CLIENT)
   public void setClientSideOffers(@Nullable MerchantOffers offers) {
   }

   public void setXP(int xpIn) {
   }

   public boolean func_213705_dZ() {
      return true;
   }

   /**
    * Notifies the merchant of a possible merchantRecipe being fulfilled or not. Usually, this is just a sound byte
    * being played depending if the suggested itemStack is not null.
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

      compound.putBoolean("rewardExp", this.doesRewardEXP);
      compound.putByte("FoodLevel", this.foodLevel);
      compound.putInt("Xp", this.xp);

      if (this.isChild()) {
         compound.putBoolean("IsBaby", true);
      }

      compound.putShort("SleepTimer", (short)this.sleepTimer);
      compound.putFloat("XpP", this.experience);
      compound.putInt("XpLevel", this.experienceLevel);
      compound.putInt("XpTotal", this.experienceTotal);
      compound.putInt("XpSeed", this.xpSeed);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);

      if (dataTag.contains("rewardExp", 1)) {
         this.doesRewardEXP = dataTag.getBoolean("rewardExp");
      }

      if (compound.contains("FoodLevel", 1)) {
         this.foodLevel = compound.getByte("FoodLevel");
      }

      if (compound.contains("Xp", 3)) {
         this.xp = compound.getInt("Xp");
      }

      this.experience = compound.getFloat("XpP");
      this.experienceLevel = compound.getInt("XpLevel");
      this.experienceTotal = compound.getInt("XpTotal");
      this.xpSeed = compound.getInt("XpSeed");
      if (this.xpSeed == 0) {
         this.xpSeed = this.rand.nextInt();
      }

      if (compound.contains("ZurTarget")) {
         this.zurTarget = NBTUtil.readBlockPos(compound.getCompound("ZurTarget"));
      }

      this.setGrowingAge(Math.max(0, this.getGrowingAge()));
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

   public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
      if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
         return true;
      } else {
         int i = inventorySlot - 300;
         return i >= 0;
      }
   }

   public World getWorld() {
      return this.world;
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
            if (this.potionUseTimer-- <= 1) {
               this.setDrinkingPotion(false);
               ItemStack itemstack = this.getHeldItemMainhand();
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
               if (itemstack.getItem() == isBurnableItemInit.VIRKT.get()) {
                  List<EffectInstance> list = PotionUtils.getEffectsFromStack(itemstack);
                  for(EffectInstance effectinstance : list) {
                     this.addPotionEffect(new EffectInstance(effectinstance));
                  }
               }

               this.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(MODIFIER);
            }
         } else {
            Potion potion = null;
            if (this.rand.nextFloat() < 0.15F && this.areEyesInFluid(FluidTags.WATER) && !this.isPotionActive(Effects.WATER_BREATHING)) {
               potion = Potions.WATER_BREATHING;
            } else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(Effects.FIRE_RESISTANCE)) {
               potion = Potions.FIRE_RESISTANCE;
            } else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
               potion = Potions.HEALING;
            } else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(Effects.STRENGTH) && this.getAttackTarget().getDistanceSq(this) > 2.0D || !this.isPotionActive(Effects.SPEED) && !this.isPotionActive(Effects.JUMP_BOOST)) {
               potion = Potions.SWIFTNESS;
            }

            if (potion != null) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(isBurnableItemInit.VIRKT.get()), potion));
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
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && this.isZurDropItem() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(isBurnableItemInit.LEAT.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
   }

   public boolean isZurDropItem() {
      return !this.zurDropItem;
   }

   public void handleDespawn() {
      if (this.despawnDelay > 0 && --this.despawnDelay == 0) {
         this.remove();
      }

   }

   public boolean getDoesRewardExp() {
      return this.doesRewardEXP;
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

      for(NonNullList<ItemStack> nonNullList : this.allInventories) {
         if (index < nonNullList.size()) {
            list = nonNullList;
            break;
         }

         index -= nonNullList.size();
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

   protected SoundEvent getFallSound(int heightIn) {
      return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
   }

   public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
      return 0.5F - worldIn.getBrightness(pos);
   }

   public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
      BlockPos blockpos = pos.up();
      return reason == SpawnReason.SPAWNER || worldIn.getBlockState(blockpos).canEntitySpawn(worldIn, blockpos, typeIn);
   }

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

   public boolean func_230292_f_(PlayerEntity player) {
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

   public static class AttackGoal extends MeleeAttackGoal {
      public AttackGoal(AbstractZurEntity zur) {
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

   public static class MorningGiftGoal extends Goal {
      private final ZurEntity zurEntity;
      private TameableEntity tameableEntity;
      private PlayerEntity owner;
      private BlockPos bedPos;
      private int tickCounter;

      public MorningGiftGoal(ZurEntity zurIn) {
         this.zurEntity = zurIn;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (this.tameableEntity.func_233685_eM_()) {
            return false;
         } else {
            LivingEntity livingentity = this.zurEntity.getOwner();
            if (livingentity instanceof PlayerEntity) {
               this.owner = (PlayerEntity)livingentity;
               if (!livingentity.isSleeping()) {
                  return false;
               }

               if (this.zurEntity.getDistanceSq(this.owner) > 100.0D) {
                  return false;
               }

               BlockPos blockpos = this.owner.getPosition();
               BlockState blockstate = this.zurEntity.world.getBlockState(blockpos);
               if (blockstate.getBlock().isIn(BlockTags.BEDS)) {
                  this.bedPos = blockstate.func_235903_d_(BedBlock.HORIZONTAL_FACING).map((p_234186_1_) -> blockpos.offset(p_234186_1_.getOpposite())).orElseGet(() -> new BlockPos(blockpos));
                  return !this.func_220805_g();
               }
            }

            return false;
         }
      }

      private boolean func_220805_g() {
         for(ZurEntity zur : this.zurEntity.world.getEntitiesWithinAABB(ZurEntity.class, (new AxisAlignedBB(this.bedPos)).grow(2.0D))) {
            if (zur != this.zurEntity && (zur.func_213416_eg())) {
               return true;
            }
         }

         return false;
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return !this.tameableEntity.func_233685_eM_() && this.owner != null && this.owner.isSleeping() && this.bedPos != null && !this.func_220805_g();
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         if (this.bedPos != null) {
            this.tameableEntity.func_233686_v_(false);
            this.zurEntity.getNavigator().tryMoveToXYZ(this.bedPos.getX(), (double)this.bedPos.getY(), (double)this.bedPos.getZ(), (double)1.1F);
         }

      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         this.zurEntity.func_213419_u(false);
         float f = this.zurEntity.world.getCelestialAngle(1.0F);
         if (this.owner.getSleepTimer() >= 100 && (double)f > 0.77D && (double)f < 0.8D && (double)this.zurEntity.world.getRandom().nextFloat() < 0.7D) {
            this.func_220804_h();
         }

         this.tickCounter = 0;
         this.zurEntity.func_213415_v(false);
         this.zurEntity.getNavigator().clearPath();
      }

      private void func_220804_h() {
         Random random = this.zurEntity.getRNG();
         BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
         blockpos$mutable.setPos(this.zurEntity.getPosition());
         this.zurEntity.attemptTeleport(blockpos$mutable.getX() + random.nextInt(11) - 5, blockpos$mutable.getY() + random.nextInt(5) - 2, blockpos$mutable.getZ() + random.nextInt(11) - 5, false);
         blockpos$mutable.setPos(this.zurEntity.getPosition());
         LootTable loottable = this.zurEntity.world.getServer().getLootTableManager().getLootTableFromLocation(LootTables.GAMEPLAY_CAT_MORNING_GIFT);
         LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.zurEntity.world)).withParameter(LootParameters.POSITION, blockpos$mutable).withParameter(LootParameters.THIS_ENTITY, this.zurEntity).withRandom(random);

         for(ItemStack itemstack : loottable.generate(lootcontext$builder.build(LootParameterSets.GIFT))) {
            this.zurEntity.world.addEntity(new ItemEntity(this.zurEntity.world, (double)blockpos$mutable.getX() - (double)MathHelper.sin(this.zurEntity.renderYawOffset * ((float)Math.PI / 180F)), blockpos$mutable.getY(), (double)blockpos$mutable.getZ() + (double)MathHelper.cos(this.zurEntity.renderYawOffset * ((float)Math.PI / 180F)), itemstack));
         }

      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         if (this.owner != null && this.bedPos != null) {
            this.tameableEntity.func_233686_v_(false);
            this.zurEntity.getNavigator().tryMoveToXYZ(this.bedPos.getX(), (double)this.bedPos.getY(), (double)this.bedPos.getZ(), (double)1.1F);
            if (this.zurEntity.getDistanceSq(this.owner) < 2.5D) {
               ++this.tickCounter;
               if (this.tickCounter > 16) {
                  this.zurEntity.func_213419_u(true);
                  this.zurEntity.func_213415_v(false);
               } else {
                  this.zurEntity.faceEntity(this.owner, 45.0F, 45.0F);
                  this.zurEntity.func_213415_v(true);
               }
            } else {
               this.zurEntity.func_213419_u(false);
            }
         }

      }
   }

   /**
    * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
    * setBesideClimbableBlock.
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

   public boolean entityLivingUpdate(HhijEntity entity)
   {
      return false;
   }

   public enum Action {
      CROSSBOW_HOLD,
      ADMIRING_ITEM,
      DEFAULT;
   }
}
