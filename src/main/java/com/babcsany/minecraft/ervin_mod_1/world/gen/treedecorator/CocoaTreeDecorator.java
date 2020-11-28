package com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator;

import com.babcsany.minecraft.ervin_mod_1.block.Firg;
import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.DecoratorInit;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class CocoaTreeDecorator extends TreeDecorator {
   private final float field_227417_b_;

   public CocoaTreeDecorator(float p_i225868_1_) {
      super(TreeDecoratorType.COCOA);
      this.field_227417_b_ = p_i225868_1_;
   }

   public <T> CocoaTreeDecorator(Dynamic<T> p_i225869_1_) {
      this(p_i225869_1_.get("probability").asFloat(0.0F));
   }

   public void func_225576_a_(IWorld p_225576_1_, Random p_225576_2_, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_, Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
      if (!(p_225576_2_.nextFloat() >= this.field_227417_b_)) {
         int i = p_225576_3_.get(0).getY();
         p_225576_3_.stream().filter((p_227418_1_) -> {
            return p_227418_1_.getY() - i <= 2;
         }).forEach((p_227419_5_) -> {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
               if (p_225576_2_.nextFloat() <= 0.25F) {
                  Direction direction1 = direction.getOpposite();
                  BlockPos blockpos = p_227419_5_.add(direction1.getXOffset(), 0, direction1.getZOffset());
                  if (AbstractTreeFeature.isAir(p_225576_1_, blockpos)) {
                     BlockState blockstate = BlockInit.FIRG.get().getDefaultState();
                     this.func_227423_a_(p_225576_1_, blockpos, blockstate, p_225576_5_, p_225576_6_);
                  }
               }
            }

         });
      }
   }

   public <T> T serialize(DynamicOps<T> p_218175_1_) {
      return (new Dynamic<>(p_218175_1_, p_218175_1_.createMap(ImmutableMap.of(p_218175_1_.createString("type"), p_218175_1_.createString(Registry.TREE_DECORATOR_TYPE.getKey(this.field_227422_a_).toString()), p_218175_1_.createString("probability"), p_218175_1_.createFloat(this.field_227417_b_))))).getValue();
   }
}