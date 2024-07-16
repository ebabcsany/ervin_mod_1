package com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public abstract class HhijAgeableEntity extends HhijCreatureEntity {
   private static final DataParameter<Boolean> BABY = EntityDataManager.createKey(HhijAgeableEntity.class, DataSerializers.BOOLEAN);
   protected int growingAge;
   protected int forcedAge;
   protected int forcedAgeTimer;

   protected HhijAgeableEntity(EntityType<? extends HhijAgeableEntity> type, World world) {
      super(type, world);
   }

   public ILivingEntityData onInitialSpawn(IServerWorld serverWorld, DifficultyInstance instance, SpawnReason reason, @Nullable ILivingEntityData data, @Nullable CompoundNBT nbt) {
      if (data == null) {
         data = new HhijAgeableEntity.AgeableData(true);
      }

      HhijAgeableEntity.AgeableData ageableData = (HhijAgeableEntity.AgeableData)data;
      if (ageableData.canBabySpawn() && ageableData.getIndexInGroup() > 0 && this.rand.nextFloat() <= ageableData.getBabySpawnProbability()) {
         this.setGrowingAge(-24000);
      }

      ageableData.incrementIndexInGroup();
      return super.onInitialSpawn(serverWorld, instance, reason, data, nbt);
   }

   @Nullable
   public abstract HhijAgeableEntity createChild(ServerWorld serverWorld, HhijAgeableEntity ageable);

   protected void registerData() {
      super.registerData();
      this.dataManager.register(BABY, false);
   }

   public boolean canFallInLove() {
      return false;
   }

   /**
    * The age value may be negative or positive or zero. If it's negative, it gets incremented on each tick, if it's
    * positive, it gets decremented each tick. Don't confuse this with EntityLiving.getAge. With a negative value the
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
      int growingAge = this.getGrowingAge();
      int age = growingAge;
      growingAge += growthSeconds * 20;
      if (growingAge > 0) {
         growingAge = 0;
      }

      int i = growingAge - age;
      this.setGrowingAge(growingAge);
      if (updateForcedAge) {
         this.forcedAge += i;
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
   @SuppressWarnings("UnusedDeclaration")
   public void addGrowth(int growth) {
      this.ageUp(growth, false);
   }

   public void setGrowingAge(int growingAge) {
      int age = this.growingAge;
      this.growingAge = growingAge;
      if (age < 0 && growingAge >= 0 || age >= 0 && growingAge < 0) {
         this.dataManager.set(BABY, growingAge < 0);
         this.onGrowingAdult();
      }

   }

   public void writeAdditional(CompoundNBT nbt) {
      super.writeAdditional(nbt);
      nbt.putInt("Age", this.getGrowingAge());
      nbt.putInt("ForcedAge", this.forcedAge);
   }

   public void readAdditional(CompoundNBT nbt) {
      super.readAdditional(nbt);
      this.setGrowingAge(nbt.getInt("Age"));
      this.forcedAge = nbt.getInt("ForcedAge");
   }

   public void notifyDataManagerChange(DataParameter<?> parameter) {
      if (BABY.equals(parameter)) {
         this.recalculateSize();
      }

      super.notifyDataManagerChange(parameter);
   }

   public void livingTick() {
      super.livingTick();
      if (this.world.isRemote) {
         if (this.forcedAgeTimer > 0) {
            if (this.forcedAgeTimer % 4 == 0) {
               this.world.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getPosXRandom(1.0), this.getPosYRandom() + 0.5, this.getPosZRandom(1.0), 0.0, 0.0, 0.0);
            }

            --this.forcedAgeTimer;
         }
      } else if (this.isAlive()) {
         int age = this.getGrowingAge();
         if (age < 0) {
            ++age;
            this.setGrowingAge(age);
         } else if (age > 0) {
            --age;
            this.setGrowingAge(age);
         }
      }

   }

   protected void onGrowingAdult() {
   }

   public boolean isChild() {
      return this.getGrowingAge() < 0;
   }

   public void setChild(boolean canGrowing) {
      this.setGrowingAge(canGrowing ? -24000 : 0);
   }

   public static class AgeableData implements ILivingEntityData {
      private int indexInGroup;
      private final boolean canBabySpawn;
      private final float babySpawnProbability;

      private AgeableData(boolean canBabySpawn, float babySpawnProbability) {
         this.canBabySpawn = canBabySpawn;
         this.babySpawnProbability = babySpawnProbability;
      }

      public AgeableData(boolean canBabySpawn) {
         this(canBabySpawn, 0.05F);
      }

      @SuppressWarnings("UnusedDeclaration")
      public AgeableData(float babySpawnProbability) {
         this(true, babySpawnProbability);
      }

      public int getIndexInGroup() {
         return this.indexInGroup;
      }

      public void incrementIndexInGroup() {
         ++this.indexInGroup;
      }

      public boolean canBabySpawn() {
         return this.canBabySpawn;
      }

      public float getBabySpawnProbability() {
         return this.babySpawnProbability;
      }
   }
}