package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class TeratStick extends Item {
   private final java.util.Map<net.minecraftforge.common.ToolType, Integer> toolClasses = Maps.newHashMap();
   public TeratStick(Properties builder) {
      super(builder);
   }

   @Override
   public int getHarvestLevel(ItemStack stack, net.minecraftforge.common.ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState) {
      return toolClasses.getOrDefault(tool, 30);
   }

   @Override
   public int getItemStackLimit(ItemStack stack) {
      return 2048;
   }

   @Override
   public int getMaxDamage(ItemStack stack) {
      return 643;
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      return 245136;
   }
}