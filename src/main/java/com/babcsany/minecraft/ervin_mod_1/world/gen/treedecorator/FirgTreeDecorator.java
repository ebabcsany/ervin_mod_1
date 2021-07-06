package com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator;

import com.babcsany.minecraft.ervin_mod_1.block.blocks.Firg;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FirgTreeDecorator extends TreeDecorator {
   public static final Codec<FirgTreeDecorator> field_236863_a_ = Codec.FLOAT.fieldOf("probability").xmap(FirgTreeDecorator::new, (p_236865_0_) -> {
      return p_236865_0_.probability;
   }).codec();
   /** Probability to generate a firg */
   private final float probability;

   public FirgTreeDecorator(float probabilityIn) {
      this.probability = probabilityIn;
   }

   protected TreeDecoratorType<?> func_230380_a_() {
      return TreeDecoratorType.BEEHIVE;
   }

   public void func_225576_a_(IWorld p_225576_1_, Random p_225576_2_, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_, Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
      if (!(p_225576_2_.nextFloat() >= this.probability)) {
         int i = !p_225576_4_.isEmpty() ? Math.max(p_225576_4_.get(0).getY() - 1, p_225576_3_.get(0).getY()) : Math.min(p_225576_3_.get(0).getY() + 1 + p_225576_2_.nextInt(3), p_225576_3_.get(p_225576_3_.size() - 1).getY());
         List<BlockPos> list = p_225576_3_.stream().filter((p_236864_1_) -> p_236864_1_.getY() == i).collect(Collectors.toList());
         if (!list.isEmpty()) {
            BlockPos blockpos = list.get(p_225576_2_.nextInt(list.size()));
            if (Feature.func_236297_b_(p_225576_1_, blockpos) && Feature.func_236297_b_(p_225576_1_, blockpos.offset(Direction.SOUTH))) {
               BlockState blockstate = BlockInit.FIRG.get().getDefaultState();
               this.func_227423_a_(p_225576_1_, blockpos, blockstate, p_225576_5_, p_225576_6_);

            }
         }
      }
   }
}