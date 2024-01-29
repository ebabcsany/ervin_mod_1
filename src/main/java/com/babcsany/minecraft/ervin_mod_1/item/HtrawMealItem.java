package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class HtrawMealItem extends BoneMealItem {
   public HtrawMealItem(Properties builder) {
      super(builder);
   }

   /**
    * Called when this item is used when targetting a Block
    */
   public ActionResultType onItemUse(ItemUseContext context) {
      World world = context.getWorld();
      BlockPos blockpos = context.getPos();
      BlockPos blockpos1 = blockpos.offset(context.getFace());
      if (applyBonemeal(context.getItem(), world, blockpos, context.getPlayer())) {
         if (!world.isRemote) {
            world.playEvent(2005, blockpos, 0);
         }

         return ActionResultType.func_233537_a_(world.isRemote);
      } else {
         BlockState blockstate = world.getBlockState(blockpos);
         boolean flag = blockstate.isSolidSide(world, blockpos, context.getFace());
         if (flag && growSeagrass(context.getItem(), world, blockpos1, context.getFace())) {
            if (!world.isRemote) {
               world.playEvent(2005, blockpos1, 0);
            }

            return ActionResultType.func_233537_a_(world.isRemote);
         } else {
            return ActionResultType.PASS;
         }
      }
   }
}