package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class ThufrBlockItem extends BlockItem {
   private final java.util.Map<net.minecraftforge.common.ToolType, Integer> toolClasses = Maps.newHashMap();
   public ThufrBlockItem(Block blockIn, Properties builder) {
      super(blockIn, builder);
   }

   @Override
   public int getHarvestLevel(ItemStack stack, net.minecraftforge.common.ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState) {
      return toolClasses.getOrDefault(tool, 136);
   }

   @Override
   public int getItemStackLimit(ItemStack stack) {
      return 2048;
   }

   @Override
   public int getMaxDamage(ItemStack stack) {
      return (int) 34894525836917542.0F;
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      return 169052731040000000.0F;
   }
}