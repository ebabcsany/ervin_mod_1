package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj;

/*public class PanicTask1 extends Task<ThuvrujEntity> {
   public PanicTask1() {
      super(ImmutableMap.of());
   }

   protected boolean shouldContinueExecuting(ServerWorld worldIn, ThuvrujEntity entityIn, long gameTimeIn) {
      return hasBeenHurt(entityIn) || hostileNearby(entityIn);
   }

   protected void startExecuting(ServerWorld worldIn, ThuvrujEntity entityIn, long gameTimeIn) {
      if (hasBeenHurt(entityIn) || hostileNearby(entityIn)) {
         Brain<?> brain = entityIn.getBrain();
         if (!brain.hasActivity(Activity.PANIC)) {
            brain.removeMemory(MemoryModuleType.PATH);
            brain.removeMemory(MemoryModuleType.WALK_TARGET);
            brain.removeMemory(MemoryModuleType.LOOK_TARGET);
            brain.removeMemory(MemoryModuleType.BREED_TARGET);
            brain.removeMemory(MemoryModuleType.INTERACTION_TARGET);
         }

         brain.switchTo(Activity.PANIC);
      }

   }

   protected void updateTask(ServerWorld worldIn, ThuvrujEntity owner, long gameTime) {
      if (gameTime % 100L == 0L) {
         owner.spawnGolems(gameTime, 3);
      }

   }

   public static boolean hostileNearby(LivingEntity entity) {
      return entity.getBrain().hasMemory(MemoryModuleType.NEAREST_HOSTILE);
   }

   public static boolean hasBeenHurt(LivingEntity entity) {
      return entity.getBrain().hasMemory(MemoryModuleType.HURT_BY);
   }
}

 */
