package com.babcsany.minecraft.ervin_mod_1.entity.ai;

import com.babcsany.minecraft.ervin_mod_1.entity.AgeableEntity1;
import com.babcsany.minecraft.ervin_mod_1.entity.AnimalEntity1;
import com.babcsany.minecraft.ervin_mod_1.entity.CriteriaTriggers1;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class BreedGoal1 extends Goal {
   private static final EntityPredicate field_220689_d = (new EntityPredicate()).setDistance(8.0D).allowInvulnerable().allowFriendlyFire().setLineOfSiteRequired();
   protected final AnimalEntity1 animal1;
   private final Class<? extends AnimalEntity1> mateClass;
   protected final World world;
   protected AnimalEntity1 targetMate;
   private int spawnBabyDelay;
   private final double moveSpeed;

   public BreedGoal1(AnimalEntity1 animal1, double speedIn) {
      this(animal1, speedIn, animal1.getClass());
   }

   public BreedGoal1(AnimalEntity1 p_i47306_1_, double p_i47306_2_, Class<? extends AnimalEntity1> p_i47306_4_) {
      this.animal1 = p_i47306_1_;
      this.world = p_i47306_1_.world;
      this.mateClass = p_i47306_4_;
      this.moveSpeed = p_i47306_2_;
      this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.animal1.isInLove()) {
         return false;
      } else {
         this.targetMate = this.getNearbyMate();
         return this.targetMate != null;
      }
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return this.targetMate.isAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.targetMate = null;
      this.spawnBabyDelay = 0;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      this.animal1.getLookController().setLookPositionWithEntity(this.targetMate, 10.0F, (float)this.animal1.getVerticalFaceSpeed());
      this.animal1.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
      ++this.spawnBabyDelay;
      if (this.spawnBabyDelay >= 60 && this.animal1.getDistanceSq(this.targetMate) < 9.0D) {
         this.spawnBaby();
      }

   }

   /**
    * Loops through nearby animals and finds another animal of the same type that can be mated with. Returns the first
    * valid mate found.
    */
   @Nullable
   private AnimalEntity1 getNearbyMate() {
      List<AnimalEntity1> list = this.world.getTargettableEntitiesWithinAABB(this.mateClass, field_220689_d, this.animal1, this.animal1.getBoundingBox().grow(8.0D));
      double d0 = Double.MAX_VALUE;
      AnimalEntity1 animalentity = null;

      for(AnimalEntity1 animalentity1 : list) {
         if (this.animal1.canMateWith(animalentity1) && this.animal1.getDistanceSq(animalentity1) < d0) {
            animalentity = animalentity1;
            d0 = this.animal1.getDistanceSq(animalentity1);
         }
      }

      return animalentity;
   }

   /**
    * Spawns a baby animal of the same type.
    */
   protected void spawnBaby() {
      AgeableEntity1 ageableentity = this.animal1.createChild(this.targetMate);
      final com.babcsany.minecraft.ervin_mod_1.entity.BabyEntitySpawnEvent1 event = new com.babcsany.minecraft.ervin_mod_1.entity.BabyEntitySpawnEvent1(animal1, targetMate, ageableentity);
      final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
      ageableentity = event.getChild();
      if (cancelled) {
         //Reset the "inLove" state for the animals
         this.animal1.setGrowingAge(6000);
         this.targetMate.setGrowingAge(6000);
         this.animal1.resetInLove();
         this.targetMate.resetInLove();
         return;
      }
      if (ageableentity != null) {
         ServerPlayerEntity serverplayerentity = this.animal1.getLoveCause();
         if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
            serverplayerentity = this.targetMate.getLoveCause();
         }

         if (serverplayerentity != null) {
            serverplayerentity.addStat(Stats.ANIMALS_BRED);
            CriteriaTriggers1.BRED_ANIMALS1.trigger(serverplayerentity, this.animal1, this.targetMate, ageableentity);
         }

         this.animal1.setGrowingAge(6000);
         this.targetMate.setGrowingAge(6000);
         this.animal1.resetInLove();
         this.targetMate.resetInLove();
         ageableentity.setGrowingAge(-24000);
         ageableentity.setLocationAndAngles(this.animal1.getPosX(), this.animal1.getPosY(), this.animal1.getPosZ(), 0.0F, 0.0F);
         this.world.addEntity(ageableentity);
         this.world.setEntityState(this.animal1, (byte)18);
         if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
            this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal1.getPosX(), this.animal1.getPosY(), this.animal1.getPosZ(), this.animal1.getRNG().nextInt(7) + 1));
         }

      }
   }
}