package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.zur;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class ZurBreedGoal extends Goal {
   private static final EntityPredicate field_220689_d = (new EntityPredicate()).setDistance(8.0D).allowInvulnerable().allowFriendlyFire().setLineOfSiteRequired();
   protected final AbstractZurEntity zur;
   private final Class<? extends AbstractZurEntity> mateClass;
   protected final World world;
   protected AbstractZurEntity targetMate;
   private int spawnBabyDelay;
   private final double moveSpeed;

   public ZurBreedGoal(AbstractZurEntity zur, double speedIn) {
      this(zur, speedIn, zur.getClass());
   }

   public ZurBreedGoal(AbstractZurEntity zur, double moveSpeed, Class<? extends AbstractZurEntity> mateClass) {
      this.zur = zur;
      this.world = zur.world;
      this.mateClass = mateClass;
      this.moveSpeed = moveSpeed;
      this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.zur.isInLove()) {
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
      this.zur.getLookController().setLookPositionWithEntity(this.targetMate, 10.0F, (float)this.zur.getVerticalFaceSpeed());
      this.zur.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
      ++this.spawnBabyDelay;
      if (this.spawnBabyDelay >= 60 && this.zur.getDistanceSq(this.targetMate) < 9.0D) {
         this.spawnBaby();
      }

   }

   /**
    * Loops through nearby animals and finds another animal of the same type that can be mated with. Returns the first
    * valid mate found.
    */
   @Nullable
   private AbstractZurEntity getNearbyMate() {
      List<AbstractZurEntity> list = this.world.getTargettableEntitiesWithinAABB(this.mateClass, field_220689_d, this.zur, this.zur.getBoundingBox().grow(8.0D));
      double d0 = Double.MAX_VALUE;
      AbstractZurEntity animalentity = null;

      for(AbstractZurEntity animalentity1 : list) {
         if (this.zur.canMateWith(animalentity1) && this.zur.getDistanceSq(animalentity1) < d0) {
            animalentity = animalentity1;
            d0 = this.zur.getDistanceSq(animalentity1);
         }
      }

      return animalentity;
   }

   /**
    * Spawns a baby animal of the same type.
    */
   protected void spawnBaby() {
      this.zur.func_234177_a_(this.world, this.targetMate);
   }
}