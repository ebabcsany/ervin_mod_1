package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class AgeableZurEntity1 extends AbstractRaiderEntity {
   private static final DataParameter<Boolean> BABY = EntityDataManager.createKey(AgeableZurEntity1.class, DataSerializers.BOOLEAN);
   protected int growingAge;
   protected int forcedAge;
   protected int forcedAgeTimer;

   protected AgeableZurEntity1(EntityType<? extends AgeableZurEntity1> type, World worldIn) {
      super(type, worldIn);
   }

   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      if (spawnDataIn == null) {
         spawnDataIn = new AgeableZurEntity1.AgeableData();
      }

      AgeableZurEntity1.AgeableData ageableentity$ageabledata = (AgeableZurEntity1.AgeableData)spawnDataIn;
      if (ageableentity$ageabledata.canBabySpawn() && ageableentity$ageabledata.getIndexInGroup() > 0 && this.rand.nextFloat() <= ageableentity$ageabledata.getBabySpawnProbability()) {
         this.setGrowingAge(-24000);
      }

      ageableentity$ageabledata.incrementIndexInGroup();
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   @Nullable
   public abstract AgeableZurEntity1 createChild(AgeableZurEntity1 ageable);

   protected void registerData() {
      super.registerData();
      this.dataManager.register(BABY, false);
   }

   public boolean canBreed() {
      return false;
   }

   /**
    * The age value may be negative or positive or zero. If it's negative, it get's incremented on each tick, if it's
    * positive, it get's decremented each tick. Don't confuse this with EntityLiving.getAge. With a negative value the
    * Entity is considered a child.
    */
   public int getGrowingAge() {
      if (this.world.isRemote) {
         return this.dataManager.get(BABY) ? -1 : 1;
      } else {
         return this.growingAge;
      }
   }

   /**
    * Increases this entity's age, optionally updating {@link #forcedAge}. If the entity is an adult (if the entity's
    * age is greater than or equal to 0) then the entity's age will be set to {@link #forcedAge}.
    */
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

   /**
    * Increases this entity's age. If the entity is an adult (if the entity's age is greater than or equal to 0) then
    * the entity's age will be set to {@link #forcedAge}. This method does not update {@link #forcedAge}.
    */
   public void addGrowth(int growth) {
      this.ageUp(growth, false);
   }

   /**
    * The age value may be negative or positive or zero. If it's negative, it get's incremented on each tick, if it's
    * positive, it get's decremented each tick. With a negative value the Entity is considered a child.
    */
   public void setGrowingAge(int age) {
      int i = this.growingAge;
      this.growingAge = age;
      if (i < 0 && age >= 0 || i >= 0 && age < 0) {
         this.dataManager.set(BABY, age < 0);
         this.onGrowingAdult();
      }

   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("Age", this.getGrowingAge());
      compound.putInt("ForcedAge", this.forcedAge);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.setGrowingAge(compound.getInt("Age"));
      this.forcedAge = compound.getInt("ForcedAge");
   }

   public void notifyDataManagerChange(DataParameter<?> key) {
      if (BABY.equals(key)) {
         this.recalculateSize();
      }

      super.notifyDataManagerChange(key);
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      if (this.world.isRemote) {
         if (this.forcedAgeTimer > 0) {
            if (this.forcedAgeTimer % 4 == 0) {
               this.world.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), 0.0D, 0.0D, 0.0D);
            }

            --this.forcedAgeTimer;
         }
      } else if (this.isAlive()) {
         int i = this.getGrowingAge();
         if (i < 0) {
            ++i;
            this.setGrowingAge(i);
         } else if (i > 0) {
            --i;
            this.setGrowingAge(i);
         }
      }

   }

   /**
    * This is called when Entity's growing age timer reaches 0 (negative values are considered as a child, positive as
    * an adult)
    */
   protected void onGrowingAdult() {
   }

   /**
    * If Animal, checks if the age timer is negative
    */
   public boolean isChild() {
      return this.getGrowingAge() < 0;
   }

   /**
    * Set whether this zombie is a child.
    */
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
}