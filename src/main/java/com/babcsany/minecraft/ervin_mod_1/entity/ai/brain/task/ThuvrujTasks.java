package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task;

public class ThuvrujTasks {
   /*public static ImmutableList<Pair<Integer, ? extends Task<? super ThuvrujEntity>>> core(float p_220638_1_) {
      return ImmutableList.of(Pair.of(0, new SwimTask(0.8F)), Pair.of(0, new InteractWithDoorTask()), Pair.of(0, new LookTask(45, 90)), Pair.of(0, new PanicTask1()), Pair.of(0, new WakeUpTask()), Pair.of(0, new HideFromRaidOnBellRingTask()), Pair.of(0, new BeginRaidTask()), Pair.of(1, new WalkToTargetTask(200)), Pair.of(3, new TradeTask1(p_220638_1_)), Pair.of(5, new PickupWantedItemTask<>(p_220638_1_, false, 4)), Pair.of(7, new FindPotentialJobTask1(p_220638_1_)), Pair.of(8, new FindJobTask(p_220638_1_)), Pair.of(10, new GatherPOITask(PointOfInterestType.HOME, MemoryModuleType.HOME, false)), Pair.of(10, new GatherPOITask(PointOfInterestType.MEETING, MemoryModuleType.MEETING_POINT, true)), Pair.of(10, new AssignProfessionTask()), Pair.of(10, new ChangeJobTask()));
   }

   public static ImmutableList<Pair<Integer, ? extends Task<? super ThuvrujEntity>>> work(float p_220639_1_) {
      SpawnGolemTask1 spawngolemtask;
      return ImmutableList.of(lookAtPlayerOrVillager(), Pair.of(new WorkTask(MemoryModuleType.JOB_SITE, 4), 2), Pair.of(new WalkTowardsPosTask(MemoryModuleType.JOB_SITE, 1, 10), 5), Pair.of(new WalkTowardsRandomSecondaryPosTask1(MemoryModuleType.SECONDARY_JOB_SITE, p_220639_1_, 1, 6, MemoryModuleType.JOB_SITE), 5), Pair.of(10, new ShowWaresTask1(400, 1600)), Pair.of(10, new FindInteractionAndLookTargetTask(EntityType.PLAYER, 4)), Pair.of(2, new StayNearPointTask1(MemoryModuleType.JOB_SITE, p_220639_1_, 9, 100, 1200)), Pair.of(99, new UpdateActivityTask()));
   }

   public static ImmutableList<Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> play(float walkingSpeed) {
      return ImmutableList.of(Pair.of(0, new net.minecraft.entity.ai.brain.task.WalkToTargetTask(100)), lookAtMany(), Pair.of(5, new net.minecraft.entity.ai.brain.task.WalkToVillagerBabiesTask()), Pair.of(5, new com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj.FirstShuffledTask1<>(ImmutableMap.of(MemoryModuleType.VISIBLE_VILLAGER_BABIES, MemoryModuleStatus.VALUE_ABSENT), ImmutableList.of(Pair.of(net.minecraft.entity.ai.brain.task.InteractWithEntityTask.func_220445_a(EntityInit.THUVRUJ_ENTITY.get(), 8, MemoryModuleType.INTERACTION_TARGET, walkingSpeed, 2), 2), Pair.of(net.minecraft.entity.ai.brain.task.InteractWithEntityTask.func_220445_a(EntityType.CAT, 8, MemoryModuleType.INTERACTION_TARGET, walkingSpeed, 2), 1), Pair.of(new net.minecraft.entity.ai.brain.task.FindWalkTargetTask(walkingSpeed), 1), Pair.of(new net.minecraft.entity.ai.brain.task.WalkTowardsLookTargetTask(walkingSpeed, 2), 1), Pair.of(new net.minecraft.entity.ai.brain.task.JumpOnBedTask(walkingSpeed), 2), Pair.of(new net.minecraft.entity.ai.brain.task.DummyTask(20, 40), 2)))), Pair.of(99, new net.minecraft.entity.ai.brain.task.UpdateActivityTask()));
   }

   public static ImmutableList<com.mojang.datafixers.util.Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> rest(float walkingSpeed) {
      return ImmutableList.of(Pair.of(2, new StayNearPointTask1(MemoryModuleType.HOME, walkingSpeed, 1, 150, 1200)), com.mojang.datafixers.util.Pair.of(3, new net.minecraft.entity.ai.brain.task.ExpirePOITask(PointOfInterestType.HOME, MemoryModuleType.HOME)), com.mojang.datafixers.util.Pair.of(3, new net.minecraft.entity.ai.brain.task.SleepAtHomeTask()), com.mojang.datafixers.util.Pair.of(5, new com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj.FirstShuffledTask1<>(ImmutableMap.of(MemoryModuleType.HOME, MemoryModuleStatus.VALUE_ABSENT), ImmutableList.of(com.mojang.datafixers.util.Pair.of(new net.minecraft.entity.ai.brain.task.WalkToHouseTask(walkingSpeed), 1), com.mojang.datafixers.util.Pair.of(new net.minecraft.entity.ai.brain.task.WalkRandomlyInsideTask(walkingSpeed), 4), com.mojang.datafixers.util.Pair.of(new com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj.WalkToPOITask1(walkingSpeed, 4), 2), com.mojang.datafixers.util.Pair.of(new net.minecraft.entity.ai.brain.task.DummyTask(20, 40), 2)))), lookAtPlayerOrVillager(), com.mojang.datafixers.util.Pair.of(99, new net.minecraft.entity.ai.brain.task.UpdateActivityTask()));
   }

   public static ImmutableList<Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> meet(float p_220637_1_) {
      return ImmutableList.of(Pair.of(2, new FirstShuffledTask1<>(ImmutableList.of(Pair.of(new WorkTask(MemoryModuleType.MEETING_POINT, 40), 2), Pair.of(new CongregateTask(), 2)))), Pair.of(10, new ShowWaresTask1(400, 1600)), Pair.of(10, new FindInteractionAndLookTargetTask(EntityType.PLAYER, 4)), Pair.of(2, new StayNearPointTask1(MemoryModuleType.MEETING_POINT, p_220637_1_, 6, 100, 200)), Pair.of(3, new ExpirePOITask(PointOfInterestType.MEETING, MemoryModuleType.MEETING_POINT)), Pair.of(3, new MultiTask1<>(ImmutableMap.of(), ImmutableSet.of(MemoryModuleType.INTERACTION_TARGET), MultiTask1.Ordering.ORDERED, MultiTask1.RunType.RUN_ONE, ImmutableList.of(Pair.of(new ShareItemsTask1(), 1)))), lookAtMany(), Pair.of(99, new UpdateActivityTask()));
   }

   public static ImmutableList<Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> idle(float p_220641_1_) {
      return ImmutableList.of(Pair.of(2, new FirstShuffledTask1<>(ImmutableList.of(Pair.of(InteractWithEntityTask.func_220445_a(EntityInit.THUVRUJ_ENTITY.get(), 8, MemoryModuleType.INTERACTION_TARGET, p_220641_1_, 2), 2), Pair.of(new InteractWithEntityTask<>(EntityInit.THUVRUJ_ENTITY.get(), 8, AgeableEntity::canBreed, AgeableEntity::canBreed, MemoryModuleType.BREED_TARGET, p_220641_1_, 2), 1), Pair.of(InteractWithEntityTask.func_220445_a(EntityType.CAT, 8, MemoryModuleType.INTERACTION_TARGET, p_220641_1_, 2), 1), Pair.of(new FindWalkTargetTask(p_220641_1_), 1), Pair.of(new WalkTowardsLookTargetTask(p_220641_1_, 2), 1), Pair.of(new JumpOnBedTask(p_220641_1_), 1), Pair.of(new DummyTask(30, 60), 1)))), Pair.of(3, new FindInteractionAndLookTargetTask(EntityType.PLAYER, 4)), Pair.of(3, new ShowWaresTask1(400, 1600)), Pair.of(3, new MultiTask1<>(ImmutableMap.of(), ImmutableSet.of(MemoryModuleType.INTERACTION_TARGET), MultiTask1.Ordering.ORDERED, MultiTask1.RunType.RUN_ONE, ImmutableList.of(Pair.of(new ShareItemsTask1(), 1)))), Pair.of(3, new MultiTask1<>(ImmutableMap.of(), ImmutableSet.of(MemoryModuleType.BREED_TARGET), MultiTask1.Ordering.ORDERED, MultiTask1.RunType.RUN_ONE, ImmutableList.of(Pair.of(new CreateBabyThuvrujTask(), 1)))), lookAtMany(), Pair.of(99, new UpdateActivityTask()));
   }

   public static ImmutableList<Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> panic(float p_220636_1_) {
      float f = p_220636_1_ * 1.5F;
      return ImmutableList.of(Pair.of(0, new ClearHurtTask1()), Pair.of(1, RunAwayTask.func_233965_b_(MemoryModuleType.NEAREST_HOSTILE, f, 6, false)), Pair.of(1, RunAwayTask.func_233965_b_(MemoryModuleType.HURT_BY_ENTITY, f, 6, false)), Pair.of(3, new FindWalkTargetTask(f, 2, 2)), lookAtPlayerOrVillager());
   }

   public static ImmutableList<Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> preRaid(float p_220642_1_) {
      return ImmutableList.of(Pair.of(0, new RingBellTask()), Pair.of(0, new FirstShuffledTask1<>(ImmutableList.of(Pair.of(new StayNearPointTask1(MemoryModuleType.MEETING_POINT, p_220642_1_ * 1.5F, 2, 150, 200), 6), Pair.of(new FindWalkTargetTask(p_220642_1_ * 1.5F), 2)))), lookAtPlayerOrVillager(), Pair.of(99, new ForgetRaidTask()));
   }

   public static ImmutableList<Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> raid(float p_220640_1_) {
      return ImmutableList.of(Pair.of(0, new FirstShuffledTask1<>(ImmutableList.of(Pair.of(new GoOutsideAfterRaidTask(p_220640_1_), 5), Pair.of(new FindWalkTargetAfterRaidVictoryTask(p_220640_1_ * 1.1F), 2)))), Pair.of(0, new CelebrateRaidVictoryTask1(600, 600)), Pair.of(2, new FindHidingPlaceDuringRaidTask(24, p_220640_1_ * 1.4F)), lookAtPlayerOrVillager(), Pair.of(99, new ForgetRaidTask()));
   }

   public static ImmutableList<Pair<Integer, ? extends net.minecraft.entity.ai.brain.task.Task<? super ThuvrujEntity>>> hide(float p_220644_1_) {
      int i = 2;
      return ImmutableList.of(Pair.of(0, new ExpireHidingTask(15, 3)), Pair.of(1, new FindHidingPlaceTask(32, p_220644_1_ * 1.25F, 2)), lookAtPlayerOrVillager());
   }

   private static Pair<Integer, Task<LivingEntity>> lookAtMany() {
      return Pair.of(5, new FirstShuffledTask<>(ImmutableList.of(Pair.of(new LookAtEntityTask(EntityType.CAT, 8.0F), 8), Pair.of(new LookAtEntityTask(EntityInit.THUVRUJ_ENTITY.get(), 8.0F), 2), Pair.of(new LookAtEntityTask(EntityType.PLAYER, 8.0F), 2), Pair.of(new LookAtEntityTask(EntityClassification.CREATURE, 8.0F), 1), Pair.of(new LookAtEntityTask(EntityClassification.WATER_CREATURE, 8.0F), 1), Pair.of(new LookAtEntityTask(EntityClassification.WATER_AMBIENT, 8.0F), 1), Pair.of(new LookAtEntityTask(EntityClassification.MONSTER, 8.0F), 1), Pair.of(new DummyTask(30, 60), 2))));
   }

   private static Pair<Integer, Task<LivingEntity>> lookAtPlayerOrVillager() {
      return Pair.of(5, new FirstShuffledTask<>(ImmutableList.of(Pair.of(new LookAtEntityTask(EntityInit.THUVRUJ_ENTITY.get(), 8.0F), 2), Pair.of(new LookAtEntityTask(EntityType.PLAYER, 8.0F), 2), Pair.of(new DummyTask(30, 60), 8))));
   }*/
}