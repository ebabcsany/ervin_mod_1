package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class OreBlock1 extends Block {
   public OreBlock1(Properties properties) {
      super(properties);
   }

   protected int getExperience(Random rand) {
      if (this == Blocks.COAL_ORE) {
         return MathHelper.nextInt(rand, 0, 2);
      } else if (this == Blocks.DIAMOND_ORE) {
         return MathHelper.nextInt(rand, 3, 7);
      } else if (this == BlockInit.SRIUNK_ORE.get()) {
         return MathHelper.nextInt(rand, 4, 9);
      } else if (this == Blocks.EMERALD_ORE) {
         return MathHelper.nextInt(rand, 3, 7);
      } else if (this == Blocks.LAPIS_ORE) {
         return MathHelper.nextInt(rand, 2, 5);
      } else if (this == Blocks.NETHER_QUARTZ_ORE) {
         return MathHelper.nextInt(rand, 2, 5);
      } else {
         return this == Blocks.NETHER_GOLD_ORE ? MathHelper.nextInt(rand, 0, 1) : 0;
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