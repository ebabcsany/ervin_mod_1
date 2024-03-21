package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.function.Predicate;

public class EatPumpkinGoal extends Goal {
   private static final Predicate<BlockState> IS_PUMPKIN = BlockStateMatcher.forBlock(Blocks.PUMPKIN);
   /** The entity owner of this AITask */
   private final MobEntity pumpkinEaterEntity;
   /** The world the grass eater entity is eating from */
   private final World entityWorld;
   /** Number of ticks since the entity started to eat grass */
   private int eatingPumpkinTimer;

   public EatPumpkinGoal(MobEntity pumpkinEaterEntityIn) {
      this.pumpkinEaterEntity = pumpkinEaterEntityIn;
      this.entityWorld = pumpkinEaterEntityIn.world;
      this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.pumpkinEaterEntity.getRNG().nextInt(this.pumpkinEaterEntity.isChild() ? 50 : 1000) != 0) {
         return false;
      } else {
         BlockPos blockpos = this.pumpkinEaterEntity.getPosition();
         if (IS_PUMPKIN.test(this.entityWorld.getBlockState(blockpos))) {
            return true;
         } else {
            return this.entityWorld.getBlockState(blockpos.down()).matchesBlock(Blocks.PUMPKIN);
         }
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.eatingPumpkinTimer = 40;
      this.entityWorld.setEntityState(this.pumpkinEaterEntity, (byte)10);
      this.pumpkinEaterEntity.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.eatingPumpkinTimer = 0;
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return this.eatingPumpkinTimer > 0;
   }

   /**
    * Number of ticks since the entity started to eat grass
    */
   public int getEatingPumpkinTimer() {
      return this.eatingPumpkinTimer;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      this.eatingPumpkinTimer = Math.max(0, this.eatingPumpkinTimer - 1);
      if (this.eatingPumpkinTimer == 4) {
         BlockPos blockpos = this.pumpkinEaterEntity.getPosition();
         if (IS_PUMPKIN.test(this.entityWorld.getBlockState(blockpos))) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.pumpkinEaterEntity)) {
               this.entityWorld.destroyBlock(blockpos, false);
            }

            this.pumpkinEaterEntity.eatGrassBonus();
         } else {
            BlockPos blockpos1 = blockpos.down();
            if (this.entityWorld.getBlockState(blockpos1).matchesBlock(Blocks.PUMPKIN)) {
               if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.pumpkinEaterEntity)) {
                  this.entityWorld.playEvent(2001, blockpos1, Block.getStateId(Blocks.PUMPKIN.getDefaultState()));
                  this.entityWorld.setBlockState(blockpos1, Blocks.CARVED_PUMPKIN.getDefaultState(), 2);
               }

               this.pumpkinEaterEntity.eatGrassBonus();
            }
         }
      }
   }
}