package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.trigger.CriteriaTriggers1;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public abstract class AbstractZurEntity /*extends CreatureEntity implements IMob*/ {
   /*private static final DataParameter<Boolean> BABY = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BOOLEAN);
   protected int growingAge;
   protected int forcedAge;
   protected int forcedAgeTimer;
   private int indexInGroup;
   private boolean canBabySpawn = true;
   private float babySpawnProbability = 0.05F;
   private int inLove;
   private UUID playerInLove;


   protected AbstractZurEntity(EntityType<? extends AbstractZurEntity> type, World worldIn) {
      super(type, worldIn);
      this.experienceValue = 5;
   }

   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      if (spawnDataIn == null) {
         spawnDataIn = new AbstractZurEntity.AgeableData();
      }

      AbstractZurEntity.AgeableData ageableentity$ageabledata = (AbstractZurEntity.AgeableData)spawnDataIn;
      if (ageableentity$ageabledata.canBabySpawn() && ageableentity$ageabledata.getIndexInGroup() > 0 && this.rand.nextFloat() <= ageableentity$ageabledata.getBabySpawnProbability()) {
         this.setGrowingAge(-24000);
      }

      ageableentity$ageabledata.incrementIndexInGroup();
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   @Nullable
   public abstract AbstractZurEntity createChild(AbstractZurEntity ageable);

   protected void registerData() {
      super.registerData();
      this.dataManager.register(BABY, false);
   }

   public int getGrowingAge() {
      if (this.world.isRemote) {
         return this.dataManager.get(BABY) ? -1 : 1;
      } else {
         return this.growingAge;
      }
   }

   public void ageUp(int growthSeconds, boolean updateForcedAge) {
      int i = this.getGrowingAge();
      i = i + growthSeconds * 20;
      if (i > 0) {
         i = 0;
      }

      int j = i - i;
      this.setGrowingAge(i);
      if (updateForcedAge) {
         this.forcedAge += j;
         if (this.forcedAgeTimer == 0) {
            this.forcedAgeTimer = 40;
         }
      }

      if (this.getGrowingAge() == 0) {
         this.setGrowingAge(this.forcedAge);
      }

   }

   public void addGrowth(int growth) {
      this.ageUp(growth, false);
   }

   public void setGrowingAge(int age) {
      int i = this.growingAge;
      this.growingAge = age;
      if (i < 0 && age >= 0 || i >= 0 && age < 0) {
         this.dataManager.set(BABY, age < 0);
         this.onGrowingAdult();
      }

   }

   public void notifyDataManagerChange(DataParameter<?> key) {
      if (BABY.equals(key)) {
         this.recalculateSize();
      }

      super.notifyDataManagerChange(key);
   }

   protected void onGrowingAdult() {
   }

   public boolean isChild() {
      return this.getGrowingAge() < 0;
   }

   public void setChild(boolean childZombie) {
      this.setGrowingAge(childZombie ? -24000 : 0);
   }

   public static class AgeableData implements ILivingEntityData {
      private int indexInGroup;
      private boolean canBabySpawn = true;
      private float babySpawnProbability = 0.05F;

      public int getIndexInGroup() {
         return this.indexInGroup;
      }

      public void incrementIndexInGroup() {
         ++this.indexInGroup;
      }

      public boolean canBabySpawn() {
         return this.canBabySpawn;
      }

      public void setCanBabySpawn(boolean canBabySpawn) {
         this.canBabySpawn = canBabySpawn;
      }

      public float getBabySpawnProbability() {
         return this.babySpawnProbability;
      }

      public void setBabySpawnProbability(float babySpawnProbability) {
         this.babySpawnProbability = babySpawnProbability;
      }
   }

   protected void updateAITasks() {
      if (this.getGrowingAge() != 0) {
         this.inLove = 0;
      }

      super.updateAITasks();
   }

   public void livingTick() {
      this.updateArmSwingProgress();
      this.func_213623_ec();
      super.livingTick();
      if (this.getGrowingAge() != 0) {
         this.inLove = 0;
      }

      if (this.inLove > 0) {
         --this.inLove;
         if (this.inLove % 10 == 0) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), d0, d1, d2);
         }
      }

   }

   public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
      return worldIn.getBlockState(pos.down()).isIn(Blocks.GRASS_BLOCK) ? 10.0F : worldIn.getBrightness(pos) - 0.5F;
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("InLove", this.inLove);
      if (this.playerInLove != null) {
         compound.putUniqueId("LoveCause", this.playerInLove);
      }

   }

   public double getYOffset() {
      return 0.14D;
   }

   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.inLove = compound.getInt("InLove");
      this.playerInLove = compound.hasUniqueId("LoveCause") ? compound.getUniqueId("LoveCause") : null;
   }

   public static boolean canAnimalSpawn(EntityType<? extends AbstractZurEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
      return worldIn.getBlockState(pos.down()).isIn(Blocks.GRASS_BLOCK) && worldIn.getLightSubtracted(pos, 0) > 8;
   }

   public int getTalkInterval() {
      return 120;
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return false;
   }

   protected int getExperiencePoints(PlayerEntity player) {
      return 1 + this.world.rand.nextInt(3);
   }

   public boolean isBreedingItem(ItemStack stack) {
      return stack.getItem() == ItemInit.LEAT.get();
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (this.isBreedingItem(itemstack)) {
         int i = this.getGrowingAge();
         if (!this.world.isRemote && i == 0 && this.canBreed()) {
            this.consumeItemFromStack(p_230254_1_, itemstack);
            this.setInLove(p_230254_1_);
            return ActionResultType.SUCCESS;
         }

         if (this.isChild()) {
            this.consumeItemFromStack(p_230254_1_, itemstack);
            this.ageUp((int)((float)(-i / 20) * 0.1F), true);
            return ActionResultType.func_233537_a_(this.world.isRemote);
         }

         if (this.world.isRemote) {
            return ActionResultType.CONSUME;
         }
      }

      return super.func_230254_b_(p_230254_1_, p_230254_2_);
   }

   protected void consumeItemFromStack(PlayerEntity player, ItemStack stack) {
      if (!player.abilities.isCreativeMode) {
         stack.shrink(1);
      }

   }

   public boolean canBreed() {
      return this.inLove <= 0;
   }

   public void setInLove(@Nullable PlayerEntity player) {
      this.inLove = 600;
      if (player != null) {
         this.playerInLove = player.getUniqueID();
      }

      this.world.setEntityState(this, (byte)18);
   }

   public int func_234178_eO_() {
      return this.inLove;
   }

   @Nullable
   public ServerPlayerEntity getLoveCause() {
      if (this.playerInLove == null) {
         return null;
      } else {
         PlayerEntity playerentity = this.world.getPlayerByUuid(this.playerInLove);
         return playerentity instanceof ServerPlayerEntity ? (ServerPlayerEntity)playerentity : null;
      }
   }

   public boolean isInLove() {
      return this.inLove > 0;
   }

   public void resetInLove() {
      this.inLove = 0;
   }

   public boolean canMateWith(AbstractZurEntity otherAnimal) {
      if (otherAnimal == this) {
         return false;
      } else if (otherAnimal.getClass() != this.getClass()) {
         return false;
      } else {
         return this.isInLove() && otherAnimal.isInLove();
      }
   }

   public void func_234177_a_(World p_234177_1_, AbstractZurEntity p_234177_2_) {
      AbstractZurEntity ageableentity = this.createChild(p_234177_2_);
      final com.babcsany.minecraft.ervin_mod_1.entity.event.BabyEntitySpawnEvent event = new com.babcsany.minecraft.ervin_mod_1.entity.event.BabyEntitySpawnEvent(this, p_234177_2_, ageableentity);
      final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
      ageableentity = event.getZurChild();
      if (cancelled) {
         //Reset the "inLove" state for the animals
         this.setGrowingAge(6000);
         p_234177_2_.setGrowingAge(6000);
         this.resetInLove();
         p_234177_2_.resetInLove();
         return;
      }
      if (ageableentity != null) {
         ServerPlayerEntity serverplayerentity = this.getLoveCause();
         if (serverplayerentity == null && p_234177_2_.getLoveCause() != null) {
            serverplayerentity = p_234177_2_.getLoveCause();
         }

         if (serverplayerentity != null) {
            serverplayerentity.addStat(Stats.ANIMALS_BRED);
            CriteriaTriggers1.BRED_ANIMALS.trigger(serverplayerentity, this, p_234177_2_, ageableentity);
         }

         this.setGrowingAge(6000);
         p_234177_2_.setGrowingAge(6000);
         this.resetInLove();
         p_234177_2_.resetInLove();
         ageableentity.setChild(true);
         ageableentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), 0.0F, 0.0F);
         p_234177_1_.addEntity(ageableentity);
         p_234177_1_.setEntityState(this, (byte)18);
         if (p_234177_1_.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
            p_234177_1_.addEntity(new ExperienceOrbEntity(p_234177_1_, this.getPosX(), this.getPosY(), this.getPosZ(), this.getRNG().nextInt(7) + 1));
         }

      }
   }

   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 18) {
         for(int i = 0; i < 7; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), d0, d1, d2);
         }
      } else {
         super.handleStatusUpdate(id);
      }

   }

   public SoundCategory getSoundCategory() {
      return SoundCategory.HOSTILE;
   }

   protected void func_213623_ec() {
      float f = this.getBrightness();
      if (f > 0.5F) {
         this.idleTime += 2;
      }

   }

   protected boolean isDespawnPeaceful() {
      return true;
   }

   protected SoundEvent getSwimSound() {
      return SoundEvents.ENTITY_HOSTILE_SWIM;
   }

   protected SoundEvent getSplashSound() {
      return SoundEvents.ENTITY_HOSTILE_SPLASH;
   }

   public boolean attackEntityFrom(DamageSource source, float amount) {
      return this.isInvulnerableTo(source) ? false : super.attackEntityFrom(source, amount);
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_HOSTILE_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_HOSTILE_DEATH;
   }

   protected SoundEvent getFallSound(int heightIn) {
      return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
   }

   public static boolean isValidLightLevel(IWorld worldIn, BlockPos pos, Random randomIn) {
      if (worldIn.getLightFor(LightType.SKY, pos) > randomIn.nextInt(32)) {
         return false;
      } else {
         int i = worldIn.getWorld().isThundering() ? worldIn.getNeighborAwareLightSubtracted(pos, 10) : worldIn.getLight(pos);
         return i <= randomIn.nextInt(8);
      }
   }

   public static AttributeModifierMap.MutableAttribute func_234295_eP_() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE);
   }

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
   }*/
}

