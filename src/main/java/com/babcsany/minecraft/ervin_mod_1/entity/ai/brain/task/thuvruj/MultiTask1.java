package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj;

import com.ibm.icu.impl.Pair;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.util.WeightedList;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MultiTask1<E extends LivingEntity> extends Task<E> {
   public final Set<MemoryModuleType<?>> field_220416_b;
   public final MultiTask1.Ordering field_220417_c;
   public final MultiTask1.RunType field_220418_d;
   public final WeightedList<Task<? super E>> field_220419_e = new WeightedList<>();

   public MultiTask1(Map<MemoryModuleType<?>, MemoryModuleStatus> p_i51503_1_, Set<MemoryModuleType<?>> p_i51503_2_, MultiTask1.Ordering p_i51503_3_, MultiTask1.RunType p_i51503_4_, List<Pair<Task<? super E>, Integer>> p_i51503_5_) {
      super(p_i51503_1_);
      this.field_220416_b = p_i51503_2_;
      this.field_220417_c = p_i51503_3_;
      this.field_220418_d = p_i51503_4_;
      /*p_i51503_5_.forEach((p_220411_1_) -> {
         this.field_220419_e.func_226313_a_(p_220411_1_.getFirst(), p_220411_1_.getSecond());
      });*/
   }

   public boolean isTimedOut(long gameTime) {
      return false;
   }

   public void startExecuting(ServerWorld worldIn, E entityIn, long gameTimeIn) {
      this.field_220417_c.func_220628_a(this.field_220419_e);
      this.field_220418_d.func_220630_a(this.field_220419_e, worldIn, entityIn, gameTimeIn);
   }

   public void updateTask(ServerWorld worldIn, E owner, long gameTime) {
      this.field_220419_e.func_220655_b().filter((p_220408_0_) -> {
         return p_220408_0_.getStatus() == Status.RUNNING;
      }).forEach((p_220409_4_) -> {
         p_220409_4_.tick(worldIn, owner, gameTime);
      });
   }

   public void resetTask(ServerWorld worldIn, E entityIn, long gameTimeIn) {
      this.field_220419_e.func_220655_b().filter((p_220407_0_) -> {
         return p_220407_0_.getStatus() == Status.RUNNING;
      }).forEach((p_220412_4_) -> {
         p_220412_4_.stop(worldIn, entityIn, gameTimeIn);
      });
      this.field_220416_b.forEach(entityIn.getBrain()::removeMemory);
   }

   public String toString() {
      Set<? extends Task<? super E>> set = this.field_220419_e.func_220655_b().filter((p_220410_0_) -> {
         return p_220410_0_.getStatus() == Status.RUNNING;
      }).collect(Collectors.toSet());
      return "(" + this.getClass().getSimpleName() + "): " + set;
   }

   public static enum Ordering {
      ORDERED((p_220627_0_) -> {
      }),
      SHUFFLED(WeightedList::func_226309_a_);

      public final Consumer<WeightedList<?>> field_220629_c;

      private Ordering(Consumer<WeightedList<?>> p_i50849_3_) {
         this.field_220629_c = p_i50849_3_;
      }

      public void func_220628_a(WeightedList<?> p_220628_1_) {
         this.field_220629_c.accept(p_220628_1_);
      }
   }

   public static enum RunType {
      RUN_ONE {
         public <E extends LivingEntity> void func_220630_a(WeightedList<Task<? super E>> p_220630_1_, ServerWorld p_220630_2_, E p_220630_3_, long p_220630_4_) {
            p_220630_1_.func_220655_b().filter((p_220634_0_) -> {
               return p_220634_0_.getStatus() == Status.STOPPED;
            }).filter((p_220633_4_) -> {
               return p_220633_4_.start(p_220630_2_, p_220630_3_, p_220630_4_);
            }).findFirst();
         }
      },
      TRY_ALL {
         public <E extends LivingEntity> void func_220630_a(WeightedList<Task<? super E>> p_220630_1_, ServerWorld p_220630_2_, E p_220630_3_, long p_220630_4_) {
            p_220630_1_.func_220655_b().filter((p_220632_0_) -> {
               return p_220632_0_.getStatus() == Status.STOPPED;
            }).forEach((p_220631_4_) -> {
               p_220631_4_.start(p_220630_2_, p_220630_3_, p_220630_4_);
            });
         }
      };

      private RunType() {
      }

      public abstract <E extends LivingEntity> void func_220630_a(WeightedList<Task<? super E>> p_220630_1_, ServerWorld p_220630_2_, E p_220630_3_, long p_220630_4_);
   }
}