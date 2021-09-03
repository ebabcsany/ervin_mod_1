package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.fish;

import com.babcsany.minecraft.ervin_mod_1.entity.fish.DrurbFishEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.JumpGoal;
import net.minecraft.fluid.FluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

public class DrurbFishJumpGoal extends JumpGoal {
   private static final int[] JUMP_DISTANCES = new int[]{0, 1, 4, 5, 6, 7};
   private final DrurbFishEntity drurbFish;
   private final int field_220712_c;
   private boolean inWater;

   public DrurbFishJumpGoal(DrurbFishEntity drurbFish, int p_i50329_2_) {
      this.drurbFish = drurbFish;
      this.field_220712_c = p_i50329_2_;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.drurbFish.getRNG().nextInt(this.field_220712_c) != 0) {
         return false;
      } else {
         Direction direction = this.drurbFish.getAdjustedHorizontalFacing();
         int i = direction.getXOffset();
         int j = direction.getZOffset();
         BlockPos blockpos = this.drurbFish.getPosition();

         for(int k : JUMP_DISTANCES) {
            if (!this.canJumpTo(blockpos, i, j, k) || !this.isAirAbove(blockpos, i, j, k)) {
               return false;
            }
         }

         return true;
      }
   }

   private boolean canJumpTo(BlockPos pos, int dx, int dz, int scale) {
      BlockPos blockpos = pos.add(dx * scale, 0, dz * scale);
      return this.drurbFish.world.getFluidState(blockpos).isTagged(FluidTags.WATER) && !this.drurbFish.world.getBlockState(blockpos).getMaterial().blocksMovement();
   }

   private boolean isAirAbove(BlockPos pos, int dx, int dz, int scale) {
      return this.drurbFish.world.getBlockState(pos.add(dx * scale, 1, dz * scale)).isAir() && this.drurbFish.world.getBlockState(pos.add(dx * scale, 2, dz * scale)).isAir();
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      double d0 = this.drurbFish.getMotion().y;
      return (!(d0 * d0 < (double)0.03F) || this.drurbFish.rotationPitch == 0.0F || !(Math.abs(this.drurbFish.rotationPitch) < 10.0F) || !this.drurbFish.isInWater()) && !this.drurbFish.isOnGround();
   }

   public boolean isPreemptible() {
      return false;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      Direction direction = this.drurbFish.getAdjustedHorizontalFacing();
      this.drurbFish.setMotion(this.drurbFish.getMotion().add((double)direction.getXOffset() * 0.6D, 0.7D, (double)direction.getZOffset() * 0.6D));
      this.drurbFish.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.drurbFish.rotationPitch = 0.0F;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      boolean flag = this.inWater;
      if (!flag) {
         FluidState fluidstate = this.drurbFish.world.getFluidState(this.drurbFish.getPosition());
         this.inWater = fluidstate.isTagged(FluidTags.WATER);
      }

      if (this.inWater && !flag) {
         this.drurbFish.playSound(SoundEvents.ENTITY_DOLPHIN_JUMP, 1.0F, 1.0F);
      }

      Vector3d vector3d = this.drurbFish.getMotion();
      if (vector3d.y * vector3d.y < (double)0.03F && this.drurbFish.rotationPitch != 0.0F) {
         this.drurbFish.rotationPitch = MathHelper.rotLerp(this.drurbFish.rotationPitch, 0.0F, 0.2F);
      } else {
         double d0 = Math.sqrt(Entity.horizontalMag(vector3d));
         double d1 = Math.signum(-vector3d.y) * Math.acos(d0 / vector3d.length()) * (double)(180F / (float)Math.PI);
         this.drurbFish.rotationPitch = (float)d1;
      }

   }
}
