package com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij.HhijBegGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij.*;
import com.babcsany.minecraft.ervin_mod_1.entity.event.HhijAnimalTameEvent;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.horse.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

public class HhijEntity extends HhijTameableEntity implements IAngerable {
   public final NonNullList<ItemStack> inventory = NonNullList.withSize(10000, ItemStack.EMPTY);
   private static final DataParameter<Boolean> BEGGING = EntityDataManager.createKey(HhijEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Integer> COLLAR_COLOR = EntityDataManager.createKey(HhijEntity.class, DataSerializers.VARINT);
   private static final DataParameter<Integer> field_234232_bz_ = EntityDataManager.createKey(HhijEntity.class, DataSerializers.VARINT);
   private static final Predicate<ItemEntity> TRUSTED_TARGET_SELECTOR = (p_213489_0_) -> !p_213489_0_.cannotPickup() && p_213489_0_.isAlive();
   public static final Map<Item, Integer> FOOD_VALUES = ImmutableMap.of(FoodItemInit.COOKED_STEEF.get(), 4, FoodItemInit.STEEF.get(), 3, isBurnableFoodItemInit.TIRKS.get(), 20, isBurnableFoodItemInit.VIRK.get(), 50, FoodItemInit.VOLMINT.get(), 1);
   private final List<NonNullList<ItemStack>> allInventories = ImmutableList.of(this.inventory);
   private static final DataParameter<Boolean> field_234409_bv_ = EntityDataManager.createKey(ZurEntity.class, DataSerializers.BOOLEAN);
   private float headRotationCourse;
   private float headRotationCourseOld;
   public int currentItem;
   private byte foodLevel;
   private boolean isWet;
   private boolean isShaking;
   private float timeWolfIsShaking;
   private float prevTimeWolfIsShaking;
   private static final RangedInteger field_234230_bG_ = TickRangeConverter.convertRange(20, 39);
   private final Inventory hhijInventory = new Inventory(10000);
   private UUID field_234231_bH_;
   private int eatTicks;

   public HhijEntity(EntityType<? extends HhijEntity> type, World worldIn) {
      super(type, worldIn);
      this.setTamed(false);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(1, new SwimGoal(this));
      this.goalSelector.addGoal(2, new HhijSitGoal(this));
      this.goalSelector.addGoal(3, new HhijAvoidEntityGoal<>(this, WitherEntity.class, 24.0F, 1.5D, 1.5D));
      this.goalSelector.addGoal(3, new HhijAvoidEntityGoal<>(this, EnderDragonEntity.class, 24.0F, 1.5D, 1.5D));
      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
      this.goalSelector.addGoal(5, new HhijMeleeAttackGoal(this, 1.0D, true));
      this.goalSelector.addGoal(6, new HhijFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
      this.goalSelector.addGoal(7, new HhijBreedGoal(this, 1.0D));
      this.goalSelector.addGoal(8, new HhijWaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(9, new HhijBegGoal(this, 8.0F));
      this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(1, new HhijOwnerHurtByTargetGoal(this));
      this.targetSelector.addGoal(2, new HhijOwnerHurtTargetGoal(this));
      this.targetSelector.addGoal(3, (new HhijHurtByTargetGoal(this)).setCallsForHelp());
      this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::func_233680_b_));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WaterMobEntity.class, false));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, CreatureEntity.class, true));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AgeableEntity.class, true));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AmbientEntity.class, true));
      this.targetSelector.addGoal(1, new ResetAngerGoal<>(this, true));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3F).createMutableAttribute(Attributes.MAX_HEALTH, 20000.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 5000.0D);
   }

   @Nullable
   @Override
   public HhijAgeableEntity createChild(HhijAgeableEntity ageable) {
      return EntityInit.HHIJ_ENTITY.get().create(this.world);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(BEGGING, false);
      this.dataManager.register(COLLAR_COLOR, DyeColor.RED.getId());
      this.dataManager.register(field_234232_bz_, 0);
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putByte("CollarColor", (byte)this.getCollarColor().getId());
      this.writeAngerNBT(compound);
   }

   public Inventory getHhijInventory() {
      return this.hhijInventory;
   }

   protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
      ItemStack itemstack = itemEntity.getItem();
      if (this.func_230293_i_(itemstack)) {
         Inventory inventory = this.getHhijInventory();
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

   private boolean getFoodLevel() {
      return this.foodLevel < 12;
   }

   private void func_213765_en() {
      if (this.getFoodLevel() && this.getFoodValueFromInventory() != 0) {
         for(int i = 0; i < this.getHhijInventory().getSizeInventory(); ++i) {
            ItemStack itemstack = this.getHhijInventory().getStackInSlot(i);
            if (!itemstack.isEmpty()) {
               Integer integer = FOOD_VALUES.get(itemstack.getItem());
               if (integer != null) {
                  int j = itemstack.getCount();

                  for(int k = j; k > 0; --k) {
                     this.foodLevel = (byte)(this.foodLevel + integer);
                     this.getHhijInventory().decrStackSize(i, 1);
                     if (!this.getFoodLevel()) {
                        return;
                     }
                  }
               }
            }
         }

      }
   }

   /**
    * @return calculated food value from item stacks in this zur's inventory
    */
   private int getFoodValueFromInventory() {
      Inventory inventory = this.getHhijInventory();
      return FOOD_VALUES.entrySet().stream().mapToInt((p_226553_1_) -> inventory.count(p_226553_1_.getKey()) * p_226553_1_.getValue()).sum();
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("CollarColor", 99)) {
         this.setCollarColor(DyeColor.byId(compound.getInt("CollarColor")));
      }

      this.hhijInventory.read(compound.getList("Inventory", 10));
      this.readAngerNBT((ServerWorld)this.world, compound);
   }

   protected SoundEvent getAmbientSound() {
      if (this.func_233678_J__()) {
         return SoundEvents.ENTITY_GENERIC_HURT;
      } else if (this.rand.nextInt(3) == 0) {
         return this.isTamed() && this.getHealth() < 10.0F ? SoundEvents.ENTITY_GENERIC_HURT : SoundEvents.ENTITY_GENERIC_HURT;
      } else {
         return SoundEvents.ENTITY_GENERIC_HURT;
      }
   }

   protected void consumeItemFromStack(PlayerEntity player, ItemStack stack) {
      if (this.isBreedingItem(stack)) {
         this.playSound(this.getEatSound(stack), 1.0F, 1.0F);
      }

      super.consumeItemFromStack(player, stack);
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_GENERIC_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_GENERIC_HURT;
   }

   /**
    * Returns the volume for the sounds this mob makes.
    */
   protected float getSoundVolume() {
      return 0.4F;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      if (!this.world.isRemote && this.isAlive() && this.isServerWorld()) {
         ++this.eatTicks;
         ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (this.canEatItem(itemstack)) {
            if (this.eatTicks > 600) {
               ItemStack itemstack1 = itemstack.onItemUseFinish(this.world, this);
               if (!itemstack1.isEmpty()) {
                  this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack1);
               }

               this.eatTicks = 0;
            } else if (this.eatTicks > 560 && this.rand.nextFloat() < 0.1F) {
               this.playSound(this.getEatSound(itemstack), 1.0F, 1.0F);
               this.world.setEntityState(this, (byte)45);
            }
         }
      }

      if (!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround) {
         this.isShaking = true;
         this.timeWolfIsShaking = 0.0F;
         this.prevTimeWolfIsShaking = 0.0F;
         this.world.setEntityState(this, (byte)8);
      }

      if (!this.world.isRemote) {
         this.func_241359_a_((ServerWorld)this.world, true);
      }

      if (!this.world.isRemote && this.isAlive() && this.isServerWorld()) {
         ++this.eatTicks;
         ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (this.canEatItem(itemstack)) {
            if (this.eatTicks > 600) {
               ItemStack itemstack1 = itemstack.onItemUseFinish(this.world, this);
               if (!itemstack1.isEmpty()) {
                  this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack1);
               }

               this.eatTicks = 0;
            } else if (this.eatTicks > 560 && this.rand.nextFloat() < 0.1F) {
               this.playSound(this.getEatSound(itemstack), 1.0F, 1.0F);
               this.world.setEntityState(this, (byte)45);
            }
         }
      }

      if (this.isSleeping() || this.isMovementBlocked()) {
         this.isJumping = false;
         this.moveStrafing = 0.0F;
         this.moveForward = 0.0F;
      }

   }

   private boolean stackEqualExact(ItemStack stack1, ItemStack stack2) {
      return stack1.getItem() == stack2.getItem() && ItemStack.areItemStackTagsEqual(stack1, stack2);
   }

   private boolean canMergeStacks(ItemStack stack1, ItemStack stack2) {
      return !stack1.isEmpty() && this.stackEqualExact(stack1, stack2) && stack1.isStackable() && stack1.getCount() < stack1.getMaxStackSize() && stack1.getCount() < this.getInventoryStackLimit();
   }

   int getInventoryStackLimit() {
      return 1000000;
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

   protected void spawnDrops(DamageSource damageSourceIn) {
      ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
      if (!itemstack.isEmpty()) {
         this.entityDropItem(itemstack);
         this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
      }

      super.spawnDrops(damageSourceIn);
   }

   public boolean canPickUpItem(ItemStack itemstackIn) {
      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstackIn);
      if (!this.getItemStackFromSlot(equipmentslottype).isEmpty()) {
         return false;
      } else {
         return equipmentslottype == EquipmentSlotType.MAINHAND && super.canPickUpItem(itemstackIn);
      }
   }

   public boolean canEquipItem(ItemStack stack) {
      Item item = stack.getItem();
      ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
      return itemstack.isEmpty() || this.eatTicks > 0 && item.isFood() && !itemstack.getItem().isFood();
   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (this.isAlive()) {
         this.headRotationCourseOld = this.headRotationCourse;
         if (this.isBegging()) {
            this.headRotationCourse += (1.0F - this.headRotationCourse) * 0.4F;
         } else {
            this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
         }

         if (this.isInWaterRainOrBubbleColumn()) {
            this.isWet = true;
            this.isShaking = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
         } else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.timeWolfIsShaking == 0.0F) {
               this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;
            if (this.prevTimeWolfIsShaking >= 2.0F) {
               this.isWet = false;
               this.isShaking = false;
               this.prevTimeWolfIsShaking = 0.0F;
               this.timeWolfIsShaking = 0.0F;
            }

            if (this.timeWolfIsShaking > 0.4F) {
               float f = (float)this.getPosY();
               int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);
               Vector3d vector3d = this.getMotion();

               for(int j = 0; j < i; ++j) {
                  float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  this.world.addParticle(ParticleTypes.SPLASH, this.getPosX() + (double)f1, (double)(f + 0.8F), this.getPosZ() + (double)f2, vector3d.x, vector3d.y, vector3d.z);
               }
            }
         }

      }
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void onDeath(DamageSource cause) {
      this.isWet = false;
      this.isShaking = false;
      this.prevTimeWolfIsShaking = 0.0F;
      this.timeWolfIsShaking = 0.0F;
      super.onDeath(cause);
   }

   /**
    * True if the wolf is wet
    */
   @OnlyIn(Dist.CLIENT)
   public boolean isWolfWet() {
      return this.isWet;
   }

   /**
    * Used when calculating the amount of shading to apply while the wolf is wet.
    */
   @OnlyIn(Dist.CLIENT)
   public float getShadingWhileWet(float partialTicks) {
      return 0.75F + MathHelper.lerp(partialTicks, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) / 2.0F * 0.25F;
   }

   @OnlyIn(Dist.CLIENT)
   public float getShakeAngle(float partialTicks, float offset) {
      float f = (MathHelper.lerp(partialTicks, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) + offset) / 1.8F;
      if (f < 0.0F) {
         f = 0.0F;
      } else if (f > 1.0F) {
         f = 1.0F;
      }

      return MathHelper.sin(f * (float)Math.PI) * MathHelper.sin(f * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
   }

   @OnlyIn(Dist.CLIENT)
   public float getInterestedAngle(float partialTicks) {
      return MathHelper.lerp(partialTicks, this.headRotationCourseOld, this.headRotationCourse) * 0.15F * (float)Math.PI;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return sizeIn.height * 0.8F;
   }

   /**
    * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
    * use in wolves.
    */
   public int getVerticalFaceSpeed() {
      return this.func_233684_eK_() ? 20 : super.getVerticalFaceSpeed();
   }

   /**
    * Called when the entity is attacked.
    */
   public boolean attackEntityFrom(DamageSource source, float amount) {
      if (this.isInvulnerableTo(source)) {
         return false;
      } else {
         Entity entity = source.getTrueSource();
         this.func_233687_w_(false);
         if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
            amount = (amount + 1.0F) / 2.0F;
         }

         return super.attackEntityFrom(source, amount);
      }
   }

   public boolean attackEntityAsMob(Entity entityIn) {
      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
      if (flag) {
         this.applyEnchantments(this, entityIn);
      }

      return flag;
   }

   public void setTamed(boolean tamed) {
      super.setTamed(tamed);
      if (tamed) {
         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20000.0D);
         this.setHealth(20.0F);
      } else {
         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8000.0D);
      }

      this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(5000.0D);
   }

   public ActionResultType func_230254_b_(PlayerEntity player, Hand p_230254_2_) {
      ItemStack itemstack = player.getHeldItem(p_230254_2_);
      Item item = itemstack.getItem();
      if (this.world.isRemote) {
         boolean flag = this.isOwner(player) || this.isTamed() || item == ItemInit.HTRAW.get() && !this.isTamed() && !this.func_233678_J__();
         return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
      } else {
         if (this.isTamed()) {
            if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
               if (!player.abilities.isCreativeMode) {
                  itemstack.shrink(1000);
               }

               this.heal((float)item.getFood().getHealing());
               return ActionResultType.SUCCESS;
            }

            if (!(item instanceof DyeItem)) {
               ActionResultType actionresulttype = super.func_230254_b_(player, p_230254_2_);
               if ((!actionresulttype.isSuccessOrConsume() || this.isChild()) && this.isOwner(player)) {
                  this.func_233687_w_(!this.func_233685_eM_());
                  this.isJumping = false;
                  this.navigator.clearPath();
                  this.setAttackTarget(null);
                  return ActionResultType.SUCCESS;
               }

               return actionresulttype;
            }

            DyeColor dyecolor = ((DyeItem)item).getDyeColor();
            if (dyecolor != this.getCollarColor()) {
               this.setCollarColor(dyecolor);
               if (!player.abilities.isCreativeMode) {
                  itemstack.shrink(1000);
               }

               return ActionResultType.SUCCESS;
            }
         } else if (item == ItemInit.HTRAW.get() && !this.func_233678_J__()) {
            if (!player.abilities.isCreativeMode) {
               itemstack.shrink(100);
            }

            if (this.rand.nextInt(3) == 1 && !onAnimalTame(this, player)) {
               this.setTamedBy(player);
               this.navigator.clearPath();
               this.setAttackTarget(null);
               this.func_233687_w_(true);
               this.world.setEntityState(this, (byte)7);
            } else {
               this.world.setEntityState(this, (byte)6);
            }

            return ActionResultType.SUCCESS;
         }

         return super.func_230254_b_(player, p_230254_2_);
      }
   }

   public static boolean onAnimalTame(HhijAnimalEntity animal, PlayerEntity tamer)
   {
      return MinecraftForge.EVENT_BUS.post(new HhijAnimalTameEvent(animal, tamer));
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 8) {
         this.isShaking = true;
         this.timeWolfIsShaking = 100.0F;
         this.prevTimeWolfIsShaking = 100.0F;
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public float getTailRotation() {
      if (this.func_233678_J__()) {
         return 1.5393804F;
      } else {
         return this.isTamed() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 20.0F) * (float)Math.PI : ((float)Math.PI / 5F);
      }
   }

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isBreedingItem(ItemStack stack) {
      Item item = stack.getItem();
      return item.isFood() && item.getFood().isMeat();
   }

   /**
    * Will return how many at most can spawn in a chunk at once.
    */
   public int getMaxSpawnedInChunk() {
      return 4;
   }

   public int getAngerTime() {
      return this.dataManager.get(field_234232_bz_);
   }

   public void setAngerTime(int time) {
      this.dataManager.set(field_234232_bz_, time);
   }

   public void func_230258_H__() {
      this.setAngerTime(field_234230_bG_.func_233018_a_(this.rand));
   }

   @Nullable
   public UUID getAngerTarget() {
      return this.field_234231_bH_;
   }

   public void setAngerTarget(@Nullable UUID target) {
      this.field_234231_bH_ = target;
   }

   public DyeColor getCollarColor() {
      return DyeColor.byId(this.dataManager.get(COLLAR_COLOR));
   }

   public void setCollarColor(DyeColor collarcolor) {
      this.dataManager.set(COLLAR_COLOR, collarcolor.getId());
   }

   public HhijEntity createChild(AgeableEntity ageable) {
      HhijEntity wolfentity = EntityInit.HHIJ_ENTITY.get().create(this.world);
      UUID uuid = this.getOwnerId();
      if (uuid != null) {
         wolfentity.setOwnerId(uuid);
         wolfentity.setTamed(true);
      }

      return wolfentity;
   }

   public void setBegging(boolean beg) {
      this.dataManager.set(BEGGING, beg);
   }

   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   public boolean canMateWith(HhijAnimalEntity otherAnimal) {
      if (otherAnimal == this) {
         return false;
      } else if (!this.isTamed()) {
         return false;
      } else if (!(otherAnimal instanceof HhijEntity)) {
         return false;
      } else {
         HhijEntity wolfentity = (HhijEntity)otherAnimal;
         if (!wolfentity.isTamed()) {
            return false;
         } else if (wolfentity.func_233684_eK_()) {
            return false;
         } else {
            return this.isInLove() && wolfentity.isInLove();
         }
      }
   }

   public boolean isBegging() {
      return this.dataManager.get(BEGGING);
   }

   public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
      if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
         if (target instanceof HhijEntity) {
            HhijEntity wolfentity = (HhijEntity)target;
            return !wolfentity.isTamed() || wolfentity.getOwner() != owner;
         } else if (target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).canAttackPlayer((PlayerEntity)target)) {
            return false;
         } else if (target instanceof AbstractHorseEntity && ((AbstractHorseEntity)target).isTame()) {
            return false;
         } else {
            return !(target instanceof TameableEntity) || !((TameableEntity)target).isTamed();
         }
      } else {
         return false;
      }
   }

   public boolean canBeLeashedTo(PlayerEntity player) {
      return !this.func_233678_J__() && super.canBeLeashedTo(player);
   }

   @OnlyIn(Dist.CLIENT)
   public Vector3d func_241205_ce_() {
      return new Vector3d(0.0D, (double)(0.6F * this.getEyeHeight()), (double)(this.getWidth() * 0.4F));
   }

   private boolean canEatItem(ItemStack itemStackIn) {
      return itemStackIn.getItem().isFood() && this.getAttackTarget() == null && this.onGround && !this.isSleeping();
   }

   private boolean func_213478_eo() {
      return !this.isSleeping();
   }

   class FindItemsGoal extends Goal {
      public FindItemsGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (!HhijEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            return false;
         } else if (HhijEntity.this.getAttackTarget() == null && HhijEntity.this.getRevengeTarget() == null) {
            if (!HhijEntity.this.func_213478_eo()) {
               return false;
            } else if (HhijEntity.this.getRNG().nextInt(10) != 0) {
               return false;
            } else {
               List<ItemEntity> list = HhijEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, HhijEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), HhijEntity.TRUSTED_TARGET_SELECTOR);
               return !list.isEmpty() && HhijEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
            }
         } else {
            return false;
         }
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         List<ItemEntity> list = HhijEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, HhijEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), HhijEntity.TRUSTED_TARGET_SELECTOR);
         ItemStack itemstack = HhijEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (itemstack.isEmpty() && !list.isEmpty()) {
            HhijEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), 1.2F);
         }

      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         List<ItemEntity> list = HhijEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, HhijEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), HhijEntity.TRUSTED_TARGET_SELECTOR);
         if (!list.isEmpty()) {
            HhijEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), 1.2F);
         }

      }
   }
}