package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.world.server.ServerWorld;

import java.util.Map;
import java.util.Map.Entry;

public abstract class Task<E extends LivingEntity> {
   protected final Map<MemoryModuleType<?>, MemoryModuleStatus> requiredMemoryState;
   private Status status = Status.STOPPED;
   private long stopTime;
   private final int durationMin;
   private final int durationMax;

   public Task(Map<MemoryModuleType<?>, MemoryModuleStatus> requiredMemoryStateIn) {
      this(requiredMemoryStateIn, 60);
   }

   public Task(Map<MemoryModuleType<?>, MemoryModuleStatus> requiredMemoryStateIn, int duration) {
      this(requiredMemoryStateIn, duration, duration);
   }

   public Task(int p_i50356_1_) {
      this(ImmutableMap.of(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleStatus.REGISTERED, MemoryModuleType.PATH, MemoryModuleStatus.VALUE_ABSENT, MemoryModuleType.WALK_TARGET, MemoryModuleStatus.VALUE_PRESENT), p_i50356_1_);
   }

   public Task(Map<MemoryModuleType<?>, MemoryModuleStatus> requiredMemoryStateIn, int durationMinIn, int durationMaxIn) {
      this.durationMin = durationMinIn;
      this.durationMax = durationMaxIn;
      this.requiredMemoryState = requiredMemoryStateIn;
   }

   public Status getStatus() {
      return this.status;
   }

   public final boolean start(ServerWorld worldIn, E owner, long gameTime) {
      if (this.hasRequiredMemories(owner) && this.shouldExecute(worldIn, owner)) {
         this.status = Status.RUNNING;
         int i = this.durationMin + worldIn.getRandom().nextInt(this.durationMax + 1 - this.durationMin);
         this.stopTime = gameTime + (long)i;
         this.startExecuting(worldIn, owner, gameTime);
         return true;
      } else {
         return false;
      }
   }

   protected void startExecuting(ServerWorld worldIn, E entityIn, long gameTimeIn) {
   }

   public final void tick(ServerWorld worldIn, E entityIn, long gameTime) {
      if (!this.isTimedOut(gameTime) && this.shouldContinueExecuting(worldIn, entityIn, gameTime)) {
         this.updateTask(worldIn, entityIn, gameTime);
      } else {
         this.stop(worldIn, entityIn, gameTime);
      }

   }

   protected void updateTask(ServerWorld worldIn, E owner, long gameTime) {
   }

   public final void stop(ServerWorld worldIn, E entityIn, long gameTimeIn) {
      this.status = Status.STOPPED;
      this.resetTask(worldIn, entityIn, gameTimeIn);
   }

   protected void resetTask(ServerWorld worldIn, E entityIn, long gameTimeIn) {
   }

   protected boolean shouldContinueExecuting(ServerWorld worldIn, E entityIn, long gameTimeIn) {
      return false;
   }

   protected boolean isTimedOut(long gameTime) {
      return gameTime > this.stopTime;
   }

   protected boolean shouldExecute(ServerWorld worldIn, E owner) {
      return true;
   }

   public String toString() {
      return this.getClass().getSimpleName();
   }

   private boolean hasRequiredMemories(E owner) {
      for(Entry<MemoryModuleType<?>, MemoryModuleStatus> entry : this.requiredMemoryState.entrySet()) {
         MemoryModuleType<?> memorymoduletype = entry.getKey();
         MemoryModuleStatus memorymodulestatus = entry.getValue();
         if (!owner.getBrain().hasMemory(memorymoduletype, memorymodulestatus)) {
            return false;
         }
      }

      return true;
   }

   public static enum Status {
      STOPPED,
      RUNNING;
   }
}