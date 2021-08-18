package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.*;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.DummyTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.EndAttackTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.FindWalkTargetTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.FirstShuffledTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.GetAngryTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.InteractWithDoorTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.InteractWithEntityTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.JumpOnBedTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.LookAtEntityTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.LookTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.Task;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.UpdateActivityTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.WalkToTargetTask;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.WalkTowardsLookTargetTask;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.task.ZurIdleActivityTask;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.tags.ItemTag;
import com.google.common.collect.*;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.ai.brain.task.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.server.ServerWorld;

import java.util.*;

public class ZurTasks<E extends LivingEntity> {
   public static final Item field_234444_a_ = isBurnableItemInit.SRIUNK.get();
   private static final RangedInteger field_234445_b_ = TickRangeConverter.convertRange(30, 120);
   private static final RangedInteger field_234446_c_ = TickRangeConverter.convertRange(10, 40);
   private static final RangedInteger field_234447_d_ = TickRangeConverter.convertRange(10, 30);
   private static final RangedInteger field_234448_e_ = TickRangeConverter.convertRange(5, 20);
   private static final RangedInteger field_234449_f_ = TickRangeConverter.convertRange(5, 7);
   private static final RangedInteger field_241418_g_ = TickRangeConverter.convertRange(5, 7);
   private static final Set<Item> field_234450_g_ = ImmutableSet.of(Items.PORKCHOP, Items.COOKED_PORKCHOP);
   private final Map<Integer, Map<Activity, Set<Task<? super E>>>> field_218232_c = Maps.newTreeMap();
   private final Map<Activity, Set<Pair<MemoryModuleType<?>, MemoryModuleStatus>>> requiredMemoryStates = Maps.newHashMap();
   private final Map<Activity, Set<MemoryModuleType<?>>> field_233691_h_ = Maps.newHashMap();

   protected static Brain<?> func_234469_a_(ZurEntity p_234469_0_, Brain<ZurEntity> p_234469_1_) {
      func_234464_a_(p_234469_1_);
      //func_234485_b_(p_234469_1_);
      //func_234502_d_(p_234469_1_);
      //func_234488_b_(p_234469_0_, p_234469_1_);
      //func_234495_c_(p_234469_1_);
      //func_234507_e_(p_234469_1_);
      //func_234511_f_(p_234469_1_);
      p_234469_1_.setDefaultActivities(ImmutableSet.of(Activity.CORE));
      p_234469_1_.setFallbackActivity(Activity.IDLE);
      p_234469_1_.func_233714_e_();
      return p_234469_1_;
   }

   public static void func_234466_a_(AbstractZurEntity zur) {
      int i = field_234445_b_.func_233018_a_(zur.world.rand);
      zur.getBrain().func_233696_a_(MemoryModuleType.HUNTED_RECENTLY, true, i);
   }

   private static void func_234464_a_(Brain<ZurEntity> zurEntityBrain) {
      zurEntityBrain.func_233698_g_(Activity.CORE, 0, ImmutableList.<Task<? super ZurEntity>>of(new LookTask(45, 90), new WalkToTargetTask(200), new InteractWithDoorTask(), func_241428_d_(), func_234500_d_(), new ZurStartAdmiringItemTask<>(), new ZurAdmireItemTask<>(120), new EndAttackTask(300, ZurTasks::func_234461_a_), new GetAngryTask<>()));
   }

   /*public static ImmutableList<Pair<Integer, ? extends Task<? super ZurEntity>>> play(float walkingSpeed) {
      return ImmutableList.of(Pair.of(0, new WalkToTargetTask(100)), Pair.of(5, new WalkToVillagerBabiesTask()), Pair.of(5, new FirstShuffledTask<>(ImmutableMap.of(MemoryModuleType.VISIBLE_VILLAGER_BABIES, MemoryModuleStatus.VALUE_ABSENT), ImmutableList.of(Pair.of(InteractWithEntityTask.func_220445_a(EntityInit.ZUR_ENTITY.get(), 8, MemoryModuleType.INTERACTION_TARGET, walkingSpeed, 2), 2), Pair.of(InteractWithEntityTask.func_220445_a(EntityType.CAT, 8, MemoryModuleType.INTERACTION_TARGET, walkingSpeed, 2), 1), Pair.of(new FindWalkTargetTask(walkingSpeed), 1), Pair.of(new WalkTowardsLookTargetTask(walkingSpeed, 2), 1), Pair.of(new JumpOnBedTask(walkingSpeed), 2), Pair.of(new DummyTask(20, 40), 2)))), Pair.of(99, new UpdateActivityTask()));
   }*/

   public static ImmutableList<Pair<Integer, ?>> play(float walkingSpeed, float Float) {
      return ImmutableList.of(Pair.of(0, new WalkToTargetTask(100)), Pair.of(3, new ZurTradeTask(Float)), Pair.of(5, new WalkToVillagerBabiesTask()), Pair.of(5, new FirstShuffledTask<>(ImmutableMap.of(MemoryModuleType.VISIBLE_VILLAGER_BABIES, MemoryModuleStatus.VALUE_ABSENT), ImmutableList.of(Pair.of(InteractWithEntityTask.func_220445_a(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, 8, MemoryModuleType.INTERACTION_TARGET, walkingSpeed, 2), 2), Pair.of(InteractWithEntityTask.func_220445_a(EntityType.CAT, 8, MemoryModuleType.INTERACTION_TARGET, walkingSpeed, 2), 1), Pair.of(new FindWalkTargetTask(walkingSpeed), 1), Pair.of(new WalkTowardsLookTargetTask(walkingSpeed, 2), 1), Pair.of(new JumpOnBedTask(walkingSpeed), 2), Pair.of(new DummyTask(20, 40), 2)))), Pair.of(99, new UpdateActivityTask()));
   }

   /*public void func_233698_a_(Activity p_233698_1_, int p_233698_2_, ImmutableList<? extends com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.Task<? super E>> p_233698_3_) {
      this.registerActivity(p_233698_1_, this.func_233692_a_(p_233698_2_));
   }*/

   /*ImmutableList<? extends Pair<Integer, ? extends com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.Task<? super E>>> func_233692_a_(int p_233692_1_, ImmutableList<? extends com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.Task<E>> p_233692_2_) {
      int i = p_233692_1_;
      ImmutableList.Builder<Pair<Integer, ? extends com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.Task<? super E>>> builder = ImmutableList.builder();

      for(com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.Task<? super E> task : p_233692_2_) {
         builder.add(Pair.of(i++, task));
      }

      return builder.build();
   }*/

   public void registerActivity(Activity activityIn, ImmutableList<? extends Pair<Integer, ? extends Task<? super E>>> p_218208_2_) {
      this.func_233701_a_(activityIn, p_218208_2_, ImmutableSet.of(), Sets.newHashSet());
   }

   private void func_233701_a_(Activity p_233701_1_, ImmutableList<? extends Pair<Integer, ? extends Task<? super E>>> p_233701_2_, Set<Pair<MemoryModuleType<?>, MemoryModuleStatus>> p_233701_3_, Set<MemoryModuleType<?>> p_233701_4_) {
      this.requiredMemoryStates.put(p_233701_1_, p_233701_3_);
      if (!p_233701_4_.isEmpty()) {
         this.field_233691_h_.put(p_233701_1_, p_233701_4_);
      }

      for(Pair<Integer, ? extends Task<? super E>> pair : p_233701_2_) {
         this.field_218232_c.computeIfAbsent(pair.getFirst(), (p_233703_0_) -> {
            return Maps.newHashMap();
         }).computeIfAbsent(p_233701_1_, (p_233717_0_) -> {
            return Sets.newLinkedHashSet();
         }).add(pair.getSecond());
      }

   }

   /*private static void func_234485_b_(Brain<ZurEntity> p_234485_0_) {
      p_234485_0_.func_233698_a_(Activity.IDLE, 10, ImmutableList.of(new LookAtEntityTask(ZurTasks::func_234482_b_, 14.0F), new com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.SupplementedTask<>(ZurEntity::func_234422_eK_, new StartHuntTask<>()), func_234493_c_(), func_234505_e_(), func_234458_a_(), func_234481_b_(), new FindInteractionAndLookTargetTask(EntityType.PLAYER, 4)));
   }

   /*private static void func_234488_b_(ZurEntity p_234488_0_, Brain<ZurEntity> p_234488_1_) {
      p_234488_1_.func_233699_a_(Activity.FIGHT, 10, ImmutableList.<net.minecraft.entity.ai.brain.task.Task<? super PiglinEntity>>of(new FindNewAttackTargetTask<>((p_234523_1_) -> {
         return !func_234504_d_(p_234488_0_, p_234523_1_);
      }), new MoveToTargetTask(1.0F), new PredicateTask<>(ZurTasks::func_234525_l_, MemoryModuleType.ATTACK_TARGET)), MemoryModuleType.ATTACK_TARGET);
   }*/

   /*private static void func_234495_c_(Brain<ZurEntity> p_234495_0_) {
      p_234495_0_.func_233699_a_(Activity.CELEBRATE, 10, ImmutableList.<net.minecraft.entity.ai.brain.task.Task<? super ZurEntity>>of(func_234493_c_(), new LookAtEntityTask(ZurTasks::func_234482_b_, 14.0F), new ForgetAttackTargetTask<ZurEntity>(ZurEntity::Child), new SupplementedTask<PiglinEntity>((p_234457_0_) -> {
         return !p_234457_0_.func_234425_eN_();
      }, new HuntCelebrationTask<>(2, 1.0F)), new SupplementedTask<PiglinEntity>(PiglinEntity::func_234425_eN_, new HuntCelebrationTask<>(4, 0.6F)), new FirstShuffledTask(ImmutableList.of(Pair.of(new LookAtEntityTask(EntityType.PIGLIN, 8.0F), 1), Pair.of(new WalkRandomlyTask(0.6F, 2, 1), 1), Pair.of(new DummyTask(10, 20), 1)))), MemoryModuleType.CELEBRATE_LOCATION);
   }*/

   /*private static void func_234502_d_(Brain<ZurEntity> p_234502_0_) {
      p_234502_0_.func_233699_a_(Activity.ADMIRE_ITEM, 10, ImmutableList.<net.minecraft.entity.ai.brain.task.Task<? super ZurEntity>>of(new com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.PickupWantedItemTask<>(ZurTasks::func_234455_E_, 1.0F, true, 9), MemoryModuleType.ADMIRING_ITEM);
   }

   /*private static void func_234507_e_(Brain<ZurEntity> p_234507_0_) {
      p_234507_0_.func_233699_a_(Activity.AVOID, 10, ImmutableList.of(RunAwayTask.func_233965_b_(MemoryModuleType.AVOID_TARGET, 1.0F, 12, true), func_234458_a_(), func_234481_b_(), new PredicateTask<PiglinEntity>(ZurTasks::func_234533_t_, MemoryModuleType.AVOID_TARGET)), MemoryModuleType.AVOID_TARGET);
   }*/

   /*private static void func_234511_f_(Brain<ZurEntity> p_234511_0_) {
      p_234511_0_.func_233699_a_(Activity.RIDE, 10, ImmutableList.of(new RideEntityTask<>(0.8F), new LookAtEntityTask(ZurTasks::func_234482_b_, 8.0F), new SupplementedTask<>(Entity::isPassenger, func_234458_a_()), new StopRidingEntityTask<>(8, ZurTasks::func_234467_a_)), MemoryModuleType.RIDE_TARGET);
   }*/

   private static FirstShuffledTask<ZurEntity> func_234458_a_() {
      return new FirstShuffledTask<>(ImmutableList.of(Pair.of(new LookAtEntityTask(EntityType.PLAYER, 8.0F), 1), Pair.of(new LookAtEntityTask(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, 8.0F), 1), Pair.of(new LookAtEntityTask(8.0F), 1), Pair.of(new DummyTask(30, 60), 1)));
   }

   /*private static FirstShuffledTask<ZurEntity> func_234481_b_() {
      return new FirstShuffledTask<>(ImmutableList.of(Pair.of(new WalkRandomlyTask(0.6F), 2), Pair.of(InteractWithEntityTask.func_220445_a(EntityInit.ZUR_ENTITY.get(), 8, MemoryModuleType.INTERACTION_TARGET, 0.6F, 2), 2), Pair.of(new SupplementedTask<>(ZurTasks::func_234514_g_, new WalkTowardsLookTargetTask(0.6F, 3)), 2), Pair.of(new DummyTask(30, 60), 1)));
   }*/

   private static RunAwayTask<BlockPos> func_234493_c_() {
      return RunAwayTask.func_233963_a_(MemoryModuleType.NEAREST_REPELLENT, 1.0F, 8, false);
   }

   private static ZurIdleActivityTask<ZurEntity, LivingEntity> func_241428_d_() {
      return new ZurIdleActivityTask<>(ZurEntity::isChild, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.AVOID_TARGET, field_241418_g_);
   }

   private static ZurIdleActivityTask<ZurEntity, LivingEntity> func_234500_d_() {
      return new ZurIdleActivityTask<>(ZurTasks::func_234525_l_, MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED, MemoryModuleType.AVOID_TARGET, field_234449_f_);
   }

   protected static void func_234486_b_(ZurEntity p_234486_0_) {
      Brain<ZurEntity> brain = (Brain<ZurEntity>) p_234486_0_.getBrain();
      Activity activity = brain.func_233716_f_().orElse((Activity)null);
      brain.func_233706_a_(ImmutableList.of(Activity.ADMIRE_ITEM, Activity.FIGHT, Activity.AVOID, Activity.CELEBRATE, Activity.RIDE, Activity.IDLE));
      Activity activity1 = brain.func_233716_f_().orElse((Activity)null);
      if (activity != activity1) {
         func_241429_d_(p_234486_0_).ifPresent(p_234486_0_::func_241417_a_);
      }

      p_234486_0_.setAggroed(brain.hasMemory(MemoryModuleType.ATTACK_TARGET));
      if (!brain.hasMemory(MemoryModuleType.RIDE_TARGET) && func_234522_j_(p_234486_0_)) {
         p_234486_0_.stopRiding();
      }

      if (!brain.hasMemory(MemoryModuleType.CELEBRATE_LOCATION)) {
         brain.removeMemory(MemoryModuleType.DANCING);
      }

      p_234486_0_.func_234442_u_(brain.hasMemory(MemoryModuleType.DANCING));
   }

   private static boolean func_234522_j_(ZurEntity zur) {
      if (!zur.isChild()) {
         return false;
      } else {
         Entity entity = zur.getRidingEntity();
         return entity instanceof ZurEntity && ((ZurEntity)entity).isChild() || entity instanceof HoglinEntity && ((HoglinEntity)entity).isChild();
      }
   }

   protected static void func_234470_a_(ZurEntity zur, ItemEntity entity) {
      func_234531_r_(zur);
      ItemStack itemstack;
      if (entity.getItem().getItem() == isBurnableItemInit.AVTER.get()) {
         zur.onItemPickup(entity, entity.getItem().getCount());
         itemstack = entity.getItem();
         entity.remove();
      } else {
         zur.onItemPickup(entity, 1);
         itemstack = func_234465_a_(entity);
      }

      Item item = itemstack.getItem();
      if (func_234480_a_(item)) {
         //func_241427_c_(zur, itemstack);
         func_234501_d_(zur);
      } else if (func_234499_c_(item) && !func_234538_z_(zur)) {
         func_234536_x_(zur);
      } else {
         boolean flag = zur.func_233665_g_(itemstack);
         if (!flag) {
            func_234498_c_(zur, itemstack);
         }
      }
   }

   /*private static void func_241427_c_(ZurEntity zur, ItemStack stack) {
      if (func_234454_D_(zur)) {
         zur.entityDropItem(zur.getHeldItem(Hand.OFF_HAND));
      }

      zur.func_234439_n_(stack);
   }*/

   private static ItemStack func_234465_a_(ItemEntity entity) {
      ItemStack itemstack = entity.getItem();
      ItemStack itemstack1 = itemstack.split(1);
      if (itemstack.isEmpty()) {
         entity.remove();
      } else {
         entity.setItem(itemstack);
      }

      return itemstack1;
   }

   protected static void func_234477_a_(AbstractZurEntity zurEntity, boolean p_234477_1_) {
      ItemStack itemstack = zurEntity.getHeldItem(Hand.OFF_HAND);
      zurEntity.setHeldItem(Hand.OFF_HAND, ItemStack.EMPTY);
      if (zurEntity.isNotChild()) {
         boolean flag = itemstack.isPiglinCurrency();
         if (p_234477_1_ && flag) {
            func_234475_a_(zurEntity, func_234524_k_(zurEntity));
         } else if (!flag) {
            boolean flag1 = zurEntity.func_233665_g_(itemstack);
            if (!flag1) {
               func_234498_c_(zurEntity, itemstack);
            }
         }
      } else {
         boolean flag2 = zurEntity.func_233665_g_(itemstack);
         if (!flag2) {
            ItemStack itemstack1 = zurEntity.getHeldItemMainhand();
            if (func_234480_a_(itemstack1.getItem())) {
               func_234498_c_(zurEntity, itemstack1);
            } else {
               func_234475_a_(zurEntity, Collections.singletonList(itemstack1));
            }

            zurEntity.func_234438_m_(itemstack);
         }
      }

   }

   protected static void func_234496_c_(ZurEntity zur) {
      if (func_234451_A_(zur) && !zur.getHeldItemOffhand().isEmpty()) {
         zur.entityDropItem(zur.getHeldItemOffhand());
         zur.setHeldItem(Hand.OFF_HAND, ItemStack.EMPTY);
      }

   }

   private static void func_234498_c_(AbstractZurEntity zur, ItemStack stack) {
      ItemStack itemstack = zur.func_234436_k_(stack);
      func_234490_b_(zur, Collections.singletonList(itemstack));
   }

   private static void func_234475_a_(AbstractZurEntity zur, List<ItemStack> stackList) {
      Optional<PlayerEntity> optional = zur.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_PLAYER);
      if (optional.isPresent()) {
         func_234472_a_(zur, optional.get(), stackList);
      } else {
         func_234490_b_(zur, stackList);
      }

   }

   private static void func_234490_b_(AbstractZurEntity zur, List<ItemStack> stackList) {
      func_234476_a_(zur, stackList, func_234537_y_(zur));
   }

   private static void func_234472_a_(AbstractZurEntity zur, PlayerEntity player, List<ItemStack> p_234472_2_) {
      func_234476_a_(zur, p_234472_2_, player.getPositionVec());
   }

   private static void func_234476_a_(AbstractZurEntity zur, List<ItemStack> p_234476_1_, Vector3d p_234476_2_) {
      if (!p_234476_1_.isEmpty()) {
         zur.swingArm(Hand.OFF_HAND);

         for(ItemStack itemstack : p_234476_1_) {
            BrainUtil.func_233865_a_(zur, itemstack, p_234476_2_.add(0.0D, 1.0D, 0.0D));
         }
      }

   }

   private static List<ItemStack> func_234524_k_(AbstractZurEntity p_234524_0_) {
      LootTable loottable = p_234524_0_.world.getServer().getLootTableManager().getLootTableFromLocation(LootTables.field_237385_ay_);
      return loottable.generate((new LootContext.Builder((ServerWorld)p_234524_0_.world)).withParameter(LootParameters.THIS_ENTITY, p_234524_0_).withRandom(p_234524_0_.world.rand).build(LootParameterSets.field_237453_h_));
   }

   private static boolean func_234461_a_(LivingEntity p_234461_0_, LivingEntity p_234461_1_) {
      if (p_234461_1_.getType() != EntityType.HOGLIN) {
         return false;
      } else {
         return (new Random(p_234461_0_.world.getGameTime())).nextFloat() < 0.1F;
      }
   }

   /*protected static boolean func_234474_a_(ZurEntity zur, ItemStack stack) {
      Item item = stack.getItem();
      if (item.isIn(ItemTags.field_232902_M_)) {
         return false;
      } else if (func_234453_C_(zur) && zur.getBrain().hasMemory(MemoryModuleType.ATTACK_TARGET)) {
         return false;
      } else if (stack.isZurCurrency()) {
         return func_234455_E_(zur);
      } else {
         boolean flag = zur.func_234437_l_(stack);
         if (item == isBurnableItemInit.SRIUNK.get()) {
            return flag;
         } else if (func_234499_c_(item)) {
            return !func_234538_z_(zur) && flag;
         } else if (!func_234480_a_(item)) {
            return zur.func_234440_o_(stack);
         } else {
            return func_234455_E_(zur) && flag;
         }
      }
   }*/

   public static boolean func_234480_a_(Item item) {
      return item.isIn(ItemTag.ZUR_LOVED);
   }

   private static boolean func_234467_a_(AbstractZurEntity p_234467_0_, Entity p_234467_1_) {
      if (!(p_234467_1_ instanceof MobEntity)) {
         return false;
      } else {
         MobEntity mobentity = (MobEntity)p_234467_1_;
         return !mobentity.isChild() || !mobentity.isAlive() || func_234517_h_(p_234467_0_) || func_234517_h_(mobentity) || mobentity instanceof PiglinEntity && mobentity.getRidingEntity() == null;
      }
   }

   /*private static boolean func_234504_d_(PiglinEntity p_234504_0_, LivingEntity p_234504_1_) {
      return func_234526_m_(p_234504_0_).filter((p_234483_1_) -> {
         return p_234483_1_ == p_234504_1_;
      }).isPresent();
   }*/

   private static boolean func_234525_l_(AbstractZurEntity zurEntity) {
      Brain<AbstractZurEntity> brain;
      brain = (Brain<AbstractZurEntity>) zurEntity.getBrain();
      if (brain.hasMemory(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED)) {
         LivingEntity livingentity = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED).get();
         return zurEntity.isEntityInRange(livingentity, 6.0D);
      } else {
         return false;
      }
   }

   /*private static Optional<? extends LivingEntity> func_234526_m_(PiglinEntity p_234526_0_) {
      Brain<ZurEntity> brain = p_234526_0_.getBrain();
      if (func_234525_l_(p_234526_0_)) {
         return Optional.empty();
      } else {
         Optional<LivingEntity> optional = BrainUtil.func_233864_a_(p_234526_0_, MemoryModuleType.ANGRY_AT);
         if (optional.isPresent() && func_234506_e_(optional.get())) {
            return optional;
         } else {
            if (brain.hasMemory(MemoryModuleType.UNIVERSAL_ANGER)) {
               Optional<PlayerEntity> optional1 = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER);
               if (optional1.isPresent()) {
                  return optional1;
               }
            }

            Optional<MobEntity> optional3 = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
            if (optional3.isPresent()) {
               return optional3;
            } else {
               Optional<PlayerEntity> optional2 = brain.getMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD);
               return optional2.isPresent() && func_234506_e_(optional2.get()) ? optional2 : Optional.empty();
            }
         }
      }
   }

   /*public static void func_234478_a_(PlayerEntity p_234478_0_, boolean p_234478_1_) {
      List<ZurEntity> list = p_234478_0_.world.getEntitiesWithinAABB(PiglinEntity.class, p_234478_0_.getBoundingBox().grow(16.0D));
      list.stream().filter(ZurTasks::func_234520_i_).filter((p_234491_2_) -> {
         return !p_234478_1_ || BrainUtil.func_233876_c_(p_234491_2_, p_234478_0_);
      }).forEach((p_234479_1_) -> {
         if (p_234479_1_.world.getGameRules().getBoolean(GameRules.UNIVERSAL_ANGER)) {
            func_241431_f_(p_234479_1_, p_234478_0_);
         } else {
            func_234497_c_(p_234479_1_, p_234478_0_);
         }

      });
   }*/

   public static ActionResultType func_234471_a_(AbstractZurEntity p_234471_0_, PlayerEntity p_234471_1_, Hand p_234471_2_) {
      ItemStack itemstack = p_234471_1_.getHeldItem(p_234471_2_);
      if (func_234489_b_(p_234471_0_, itemstack)) {
         ItemStack itemstack1 = itemstack.split(1);
         //func_241427_c_(p_234471_0_, itemstack1);
         func_234501_d_(p_234471_0_);
         func_234531_r_(p_234471_0_);
         return ActionResultType.CONSUME;
      } else {
         return ActionResultType.PASS;
      }
   }

   public static boolean func_234489_b_(AbstractZurEntity p_234489_0_, ItemStack p_234489_1_) {
      return !func_234453_C_(p_234489_0_) && !func_234451_A_(p_234489_0_) && p_234489_0_.isNotChild() && p_234489_1_.isZurCurrency();
   }

   protected static void func_234468_a_(AbstractZurEntity p_234468_0_, LivingEntity p_234468_1_) {
      if (!(p_234468_1_ instanceof AbstractZurEntity)) {
         if (func_234454_D_(p_234468_0_)) {
            func_234477_a_(p_234468_0_, false);
         }

         Brain<AbstractZurEntity> brain = (Brain<AbstractZurEntity>) p_234468_0_.getBrain();
         brain.removeMemory(MemoryModuleType.CELEBRATE_LOCATION);
         brain.removeMemory(MemoryModuleType.DANCING);
         brain.removeMemory(MemoryModuleType.ADMIRING_ITEM);
         if (p_234468_1_ instanceof PlayerEntity) {
            brain.func_233696_a_(MemoryModuleType.ADMIRING_DISABLED, true, 400L);
         }

         func_234515_g_(p_234468_0_).ifPresent((p_234462_2_) -> {
            if (p_234462_2_.getType() != p_234468_1_.getType()) {
               brain.removeMemory(MemoryModuleType.AVOID_TARGET);
            }

         });
         if (p_234468_0_.isChild()) {
            brain.func_233696_a_(MemoryModuleType.AVOID_TARGET, p_234468_1_, 100L);
            /*if (func_234506_e_(p_234468_1_)) {
               func_234487_b_(p_234468_0_, p_234468_1_);
            }*/

         } else if (p_234468_1_.getType() == EntityInit.ZUR_NIRTRE_ENTITY.get() && func_234535_v_(p_234468_0_)) {
            func_234521_i_(p_234468_0_, p_234468_1_);
            //func_234516_g_(p_234468_0_, p_234468_1_);
         } else {
            func_234509_e_(p_234468_0_, p_234468_1_);
         }
      }
   }

   private static void func_234509_e_(AbstractZurEntity p_234509_0_, LivingEntity p_234509_1_) {
      if (!p_234509_0_.getBrain().hasActivity(Activity.AVOID)) {
         if (func_234506_e_(p_234509_1_)) {
            if (!BrainUtil.func_233861_a_(p_234509_0_, p_234509_1_, 4.0D)) {
               if (p_234509_1_.getType() == EntityType.PLAYER && p_234509_0_.world.getGameRules().getBoolean(GameRules.UNIVERSAL_ANGER)) {
                  func_241431_f_(p_234509_0_, p_234509_1_);
                  func_241430_f_(p_234509_0_);
               } else {
                  func_234497_c_(p_234509_0_, p_234509_1_);
                  //func_234487_b_(p_234509_0_, p_234509_1_);
               }

            }
         }
      }
   }

   public static Optional<SoundEvent> func_241429_d_(ZurEntity p_241429_0_) {
      return p_241429_0_.getBrain().func_233716_f_().map((p_241426_1_) -> func_241422_a_(p_241429_0_, p_241426_1_));
   }

   private static boolean func_234528_o_(ZurEntity p_234528_0_) {
      Brain<ZurEntity> brain = (Brain<ZurEntity>) p_234528_0_.getBrain();
      return !brain.hasMemory(MemoryModuleType.ATTACK_TARGET) ? false : brain.getMemory(MemoryModuleType.ATTACK_TARGET).get().isEntityInRange(p_234528_0_, 12.0D);
   }

   private static SoundEvent func_241422_a_(ZurEntity p_241422_0_, Activity p_241422_1_) {
      if (p_241422_1_ == Activity.FIGHT) {
         return SoundEvents.ENTITY_GENERIC_HURT;
      } else if (p_241422_0_.func_234423_eL_()) {
         return SoundEvents.ENTITY_GENERIC_HURT;
      } else if (p_241422_1_ == Activity.AVOID && func_234528_o_(p_241422_0_)) {
         return SoundEvents.ENTITY_GENERIC_HURT;
      } else if (p_241422_1_ == Activity.ADMIRE_ITEM) {
         return SoundEvents.ENTITY_GENERIC_HURT;
      } else if (p_241422_1_ == Activity.CELEBRATE) {
         return SoundEvents.ENTITY_GENERIC_HURT;
      } else if (func_234510_f_(p_241422_0_)) {
         return SoundEvents.ENTITY_GENERIC_HURT;
      } else {
         return func_234452_B_(p_241422_0_) ? SoundEvents.ENTITY_PIGLIN_RETREAT : SoundEvents.ENTITY_PIGLIN_AMBIENT;
      }
   }

   /*public static boolean func_234460_a_(LivingEntity entity) {
      for(ItemStack itemstack : entity.getArmorInventoryList()) {
         Item item = itemstack.getItem();
         if (itemstack.makesZursNeutral(entity)) {
            return true;
         }
      }

      return false;
   }*/

   private static void walkTarget(ZurEntity zur) {
      zur.getBrain().removeMemory(MemoryModuleType.WALK_TARGET);
      zur.getNavigator().clearPath();
   }

   /*private static RunSometimesTask<ZurEntity> func_234505_e_() {
      return new RunSometimesTask<>(new PiglinIdleActivityTask<>(PiglinEntity::isChild, MemoryModuleType.NEAREST_VISIBLE_BABY_HOGLIN, MemoryModuleType.RIDE_TARGET, field_234447_d_), field_234446_c_);
   }*/

   /*protected static void func_234487_b_(PiglinEntity p_234487_0_, LivingEntity p_234487_1_) {
      func_234530_q_(p_234487_0_).forEach((p_234484_1_) -> {
         if (p_234487_1_.getType() != EntityType.HOGLIN || p_234484_1_.func_234422_eK_() && ((HoglinEntity)p_234487_1_).func_234365_eM_()) {
            func_234513_f_(p_234484_1_, p_234487_1_);
         }
      });
   }*/

   private static List<ZurEntity> func_234530_q_(AbstractZurEntity zur) {
      return (List<ZurEntity>) zur.getBrain()/*.getMemory(NEAREST_ADULT_PIGLINS).orElse(ImmutableList.of())*/;
   }

   protected static void func_241430_f_(AbstractZurEntity zur) {
      func_234530_q_(zur).forEach((p_241419_0_) -> {
         func_241432_i_(p_241419_0_).ifPresent((p_241421_1_) -> {
            func_234497_c_(p_241419_0_, p_241421_1_);
         });
      });
   }

   protected static void func_234497_c_(AbstractZurEntity zur, LivingEntity entity) {
      if (func_234506_e_(entity)) {
         zur.getBrain().removeMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
         zur.getBrain().func_233696_a_(MemoryModuleType.ANGRY_AT, entity.getUniqueID(), 600L);
         if (entity.getType() == EntityInit.ZUR_NIRTRE_ENTITY.get()) {
            func_234518_h_(zur);
         }

         if (entity.getType() == EntityType.PLAYER && zur.world.getGameRules().getBoolean(GameRules.UNIVERSAL_ANGER)) {
            zur.getBrain().func_233696_a_(MemoryModuleType.UNIVERSAL_ANGER, true, 600L);
         }

      }
   }

   private static void func_234531_r_(AbstractZurEntity zur) {
      zur.getBrain().removeMemory(MemoryModuleType.WALK_TARGET);
      zur.getNavigator().clearPath();
   }

   private static void func_241431_f_(AbstractZurEntity zur, LivingEntity entity) {
      Optional<PlayerEntity> optional = func_241432_i_(zur);
      if (optional.isPresent()) {
         func_234497_c_(zur, optional.get());
      } else {
         func_234497_c_(zur, entity);
      }

   }

   private static void func_234513_f_(ZurEntity zur, LivingEntity entity) {
      Optional<LivingEntity> optional = func_234532_s_(zur);
      LivingEntity livingentity = BrainUtil.func_233867_a_(zur, optional, entity);
      if (!optional.isPresent() || optional.get() != livingentity) {
         func_234497_c_(zur, livingentity);
      }
   }

   private static Optional<LivingEntity> func_234532_s_(AbstractZurEntity zur) {
      return BrainUtil.func_233864_a_(zur, MemoryModuleType.ANGRY_AT);
   }

   public static Optional<LivingEntity> func_234515_g_(AbstractZurEntity zur) {
      return zur.getBrain().hasMemory(MemoryModuleType.AVOID_TARGET) ? zur.getBrain().getMemory(MemoryModuleType.AVOID_TARGET) : Optional.empty();
   }

   public static Optional<PlayerEntity> func_241432_i_(AbstractZurEntity zur) {
      return zur.getBrain().hasMemory(MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER) ? zur.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER) : Optional.empty();
   }

   /*private static void func_234516_g_(ZurEntity p_234516_0_, LivingEntity p_234516_1_) {
      func_234529_p_(p_234516_0_).forEach((p_234463_1_) -> {
         func_234519_h_(p_234463_1_, p_234516_1_);
      });
   }

   /*private static void func_234519_h_(ZurEntity p_234519_0_, LivingEntity p_234519_1_) {
      Brain<ZurEntity> brain = p_234519_0_.getBrain();
      LivingEntity lvt_3_1_ = BrainUtil.func_233867_a_(p_234519_0_, brain.getMemory(MemoryModuleType.AVOID_TARGET), p_234519_1_);
      lvt_3_1_ = BrainUtil.func_233867_a_(p_234519_0_, brain.getMemory(MemoryModuleType.ATTACK_TARGET), lvt_3_1_);
      func_234521_i_(p_234519_0_, lvt_3_1_);
   }

   /*private static boolean func_234533_t_(ZurEntity p_234533_0_) {
      Brain<ZurEntity> brain = p_234533_0_.getBrain();
      if (!brain.hasMemory(MemoryModuleType.AVOID_TARGET)) {
         return true;
      } else {
         LivingEntity livingentity = brain.getMemory(MemoryModuleType.AVOID_TARGET).get();
         EntityType<?> entitytype = livingentity.getType();
         if (entitytype == EntityType.HOGLIN) {
            return func_234534_u_(p_234533_0_);
         } else if (func_234459_a_(entitytype)) {
            return !brain.func_233708_b_(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED, livingentity);
         } else {
            return false;
         }
      }
   }*/

   private static boolean func_234534_u_(AbstractZurEntity zur) {
      return !func_234535_v_(zur);
   }

   private static boolean func_234535_v_(AbstractZurEntity zur) {
      int i = zur.getBrain().getMemory(MemoryModuleType.VISIBLE_ADULT_PIGLIN_COUNT).orElse(0) + 1;
      int j = zur.getBrain().getMemory(MemoryModuleType.VISIBLE_ADULT_HOGLIN_COUNT).orElse(0);
      return j > i;
   }

   private static void func_234521_i_(AbstractZurEntity zur, LivingEntity entity) {
      zur.getBrain().removeMemory(MemoryModuleType.ANGRY_AT);
      zur.getBrain().removeMemory(MemoryModuleType.ATTACK_TARGET);
      zur.getBrain().removeMemory(MemoryModuleType.WALK_TARGET);
      zur.getBrain().func_233696_a_(MemoryModuleType.AVOID_TARGET, entity, field_234448_e_.func_233018_a_(zur.world.rand));
      func_234518_h_(zur);
   }

   protected static void func_234518_h_(AbstractZurEntity zur) {
      zur.getBrain().func_233696_a_(MemoryModuleType.HUNTED_RECENTLY, true, field_234445_b_.func_233018_a_(zur.world.rand));
   }

   private static void func_234536_x_(AbstractZurEntity zur) {
      zur.getBrain().func_233696_a_(MemoryModuleType.ATE_RECENTLY, true, 200L);
   }

   private static Vector3d func_234537_y_(AbstractZurEntity zur) {
      Vector3d vector3d = RandomPositionGenerator.getLandPos(zur, 4, 2);
      return vector3d == null ? zur.getPositionVec() : vector3d;
   }

   private static boolean func_234538_z_(AbstractZurEntity zur) {
      return zur.getBrain().hasMemory(MemoryModuleType.ATE_RECENTLY);
   }

   protected static boolean idleActivity(AbstractZurEntity zur) {
      return zur.getBrain().hasActivity(Activity.IDLE);
   }

   private static void func_234501_d_(LivingEntity entity) {
      entity.getBrain().func_233696_a_(MemoryModuleType.ADMIRING_ITEM, true, 120L);
   }

   private static boolean func_234451_A_(AbstractZurEntity zur) {
      return zur.getBrain().hasMemory(MemoryModuleType.ADMIRING_ITEM);
   }

   private static boolean func_234492_b_(Item item) {
      return item == field_234444_a_;
   }

   private static boolean func_234499_c_(Item item) {
      return field_234450_g_.contains(item);
   }

   private static boolean func_234506_e_(LivingEntity entity) {
      return EntityPredicates.field_233583_f_.test(entity);
   }

   private static boolean func_234452_B_(ZurEntity zur) {
      return zur.getBrain().hasMemory(MemoryModuleType.NEAREST_REPELLENT);
   }

   private static boolean func_234510_f_(LivingEntity entity) {
      return entity.getBrain().hasMemory(MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM);
   }

   private static boolean func_234514_g_(LivingEntity entity) {
      return !func_234510_f_(entity);
   }

   public static boolean func_234482_b_(LivingEntity entity) {
      return entity.getType() == EntityType.PLAYER && entity.func_233634_a_(ZurTasks::func_234480_a_);
   }

   private static boolean func_234453_C_(AbstractZurEntity zur) {
      return zur.getBrain().hasMemory(MemoryModuleType.ADMIRING_DISABLED);
   }

   private static boolean func_234517_h_(LivingEntity entity) {
      return entity.getBrain().hasMemory(MemoryModuleType.HURT_BY);
   }

   private static boolean func_234454_D_(AbstractZurEntity entity) {
      return !entity.getHeldItemOffhand().isEmpty();
   }

   private static boolean func_234455_E_(AbstractZurEntity entity) {
      return entity.getHeldItemOffhand().isEmpty() || !func_234480_a_(entity.getHeldItemOffhand().getItem());
   }

   /*public static boolean func_234459_a_(EntityType p_234459_0_) {
      return p_234459_0_ == EntityType.ZOMBIFIED_PIGLIN || p_234459_0_ == EntityType.ZOGLIN;
   }*/

   //public static final MemoryModuleType<List<ZurEntity>> NEAREST_ADULT_PIGLINS = register("nearest_adult_piglins");

   /*private static <U> MemoryModuleType<U> register(String identifier) {
      return Registry.register(Registry.MEMORY_MODULE_TYPE, new ResourceLocation(identifier), new MemoryModuleType<>(Optional.empty()));
   }*/
}