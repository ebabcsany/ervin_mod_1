package com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator;

import com.babcsany.minecraft.ervin_mod_1.block.Firg;
import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.DecoratorInit;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirgTreeDecorator extends TreeDecorator {

   /*public static final TreeDecoratorType<FirgTreeDecorator> FIRG = registerTreeDecoratorType("firg", FirgTreeDecorator::new);

   public static TreeDecoratorType<FirgTreeDecorator> registerTreeDecoratorType(String name, Function<Dynamic<?>, FirgTreeDecorator> constructor) {
      Method registerMethod = null;
      try {
         registerMethod = TreeDecoratorType.class.getDeclaredMethod("register", String.class, Function.class);
         return (TreeDecoratorType<FirgTreeDecorator>) registerMethod.invoke(null, name, constructor);
      } catch (NoSuchMethodException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      }
      return null;
   }*/

   /** Probability to generate a beehive */
   private final float probability;

   public FirgTreeDecorator(float probabilityIn) {
      super(TreeDecoratorType.BEEHIVE);
      this.probability = probabilityIn;
   }

   public <T> FirgTreeDecorator(Dynamic<T> p_i225867_1_) {
      this(p_i225867_1_.get("probability").asFloat(0.0F));
   }

   public void func_225576_a_(IWorld p_225576_1_, Random p_225576_2_, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_, Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
      if (!(p_225576_2_.nextFloat() >= this.probability)) {
         Direction direction = Direction.EAST;
         int i = !p_225576_4_.isEmpty() ? Math.max(p_225576_4_.get(0).getY() - 1, p_225576_3_.get(0).getY()) : Math.min(p_225576_3_.get(0).getY() + 1 + p_225576_2_.nextInt(3), p_225576_3_.get(p_225576_3_.size() - 1).getY());
         List<BlockPos> list = p_225576_3_.stream().filter((p_227416_1_) -> {
            return p_227416_1_.getY() == i;
         }).collect(Collectors.toList());
         if (!list.isEmpty()) {
            BlockPos blockpos = list.get(p_225576_2_.nextInt(list.size()));
            BlockPos blockpos1 = blockpos.offset(direction);
            if (AbstractTreeFeature.isAir(p_225576_1_, blockpos1) && AbstractTreeFeature.isAir(p_225576_1_, blockpos1.offset(Direction.SOUTH))) {
               BlockState blockstate = BlockInit.FIRG.get().getDefaultState()/*.with(BeehiveBlock.FACING, Direction.SOUTH)*/;
               this.func_227423_a_(p_225576_1_, blockpos1, blockstate, p_225576_5_, p_225576_6_);
               /*TileEntity tileentity = p_225576_1_.getTileEntity(blockpos1);
               if (tileentity instanceof TileEntity) {
                  BeehiveTileEntity beehivetileentity = (BeehiveTileEntity)tileentity;
                  int j = 2 + p_225576_2_.nextInt(2);

                  for(int k = 0; k < j; ++k) {
                     BeeEntity beeentity = new BeeEntity(EntityType.BEE, p_225576_1_.getWorld());
                     beehivetileentity.tryEnterHive(beeentity, false, p_225576_2_.nextInt(599));
                  }
               }*/
            }

         }
      }
   }

   public <T> T serialize(DynamicOps<T> p_218175_1_) {
      return (new Dynamic<>(p_218175_1_, p_218175_1_.createMap(ImmutableMap.of(p_218175_1_.createString("type"), p_218175_1_.createString(Registry.TREE_DECORATOR_TYPE.getKey(this.field_227422_a_).toString()), p_218175_1_.createString("probability"), p_218175_1_.createFloat(this.probability))))).getValue();
   }
}
