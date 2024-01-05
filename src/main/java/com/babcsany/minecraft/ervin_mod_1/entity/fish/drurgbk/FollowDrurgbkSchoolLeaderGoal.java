package com.babcsany.minecraft.ervin_mod_1.entity.fish.drurgbk;

import net.minecraft.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class FollowDrurgbkSchoolLeaderGoal extends Goal {
   private final AbstractGroupDrurgbkFishEntity taskOwner;
   private int navigateTimer;
   private int cooldown;

   public FollowDrurgbkSchoolLeaderGoal(AbstractGroupDrurgbkFishEntity taskOwnerIn) {
      this.taskOwner = taskOwnerIn;
      this.cooldown = this.getNewCooldown(taskOwnerIn);
   }

   protected int getNewCooldown(AbstractGroupDrurgbkFishEntity taskOwnerIn) {
      return 200 + taskOwnerIn.getRNG().nextInt(200) % 20;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.taskOwner.isGroupLeader()) {
         return false;
      } else if (this.taskOwner.hasGroupLeader()) {
         return true;
      } else if (this.cooldown > 0) {
         --this.cooldown;
         return false;
      } else {
         this.cooldown = this.getNewCooldown(this.taskOwner);
         Predicate<AbstractGroupDrurgbkFishEntity> predicate = (fish) -> fish.canGroupGrow() || !fish.hasGroupLeader();
         List<AbstractGroupDrurgbkFishEntity> list = this.taskOwner.world.getEntitiesWithinAABB(this.taskOwner.getClass(), this.taskOwner.getBoundingBox().grow(8.0D, 8.0D, 8.0D), predicate);
         AbstractGroupDrurgbkFishEntity abstractgroupfishentity = list.stream().filter(AbstractGroupDrurgbkFishEntity::canGroupGrow).findAny().orElse(this.taskOwner);
         abstractgroupfishentity.func_212810_a(list.stream().filter((fish) -> !fish.hasGroupLeader()));
         return this.taskOwner.hasGroupLeader();
      }
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return this.taskOwner.hasGroupLeader() && this.taskOwner.inRangeOfGroupLeader();
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.navigateTimer = 0;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.taskOwner.leaveGroup();
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      if (--this.navigateTimer <= 0) {
         this.navigateTimer = 10;
         this.taskOwner.moveToGroupLeader();
      }
   }
}
