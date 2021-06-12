package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class OreBlock2 extends HorizontalBlock {
   public OreBlock2(Properties properties) {
      super(properties);
   }

   protected int getExperience(Random rand) {
      if (this == BlockInit.GNRTHIRJ.get()) {
         return MathHelper.nextInt(rand, 3, 7);
      /*} else if (this == BlockItemInit.GNITH_BLOCK.get()) {
         return MathHelper.nextInt(rand, 2, 9);
      } else if (this == BlockItemInit.KALT_BLOCK.get()) {
         return MathHelper.nextInt(rand, 5, 12);
      } else if (this == BlockItemInit.RUBY_ORE.get()) {
         return MathHelper.nextInt(rand, 3, 7);
      } else if (this == Blocks.LAPIS_ORE) {
         return MathHelper.nextInt(rand, 2, 5);
      } else if (this == Blocks.NETHER_QUARTZ_ORE) {
         return MathHelper.nextInt(rand, 2, 5);*/
      } else {
         return this == isBurnableBlockItemInit.VILKT_BLOCK.get() ? MathHelper.nextInt(rand, 0, 18) : 0;
      }
   }

   /**
    * Perform side-effects from block dropping, such as creating silverfish
    */
   public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
      super.spawnAdditionalDrops(state, worldIn, pos, stack);
   }

   @Override
   public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
      return silktouch == 0 ? this.getExperience(RANDOM) : 0;
   }
}