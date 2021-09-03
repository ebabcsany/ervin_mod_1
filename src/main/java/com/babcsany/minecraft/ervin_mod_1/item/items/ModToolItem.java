package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class ModToolItem extends Item {
   private final java.util.Map<net.minecraftforge.common.ToolType, Integer> toolClasses = Maps.newHashMap();
   private final int harvestLevel;
   private final int maxDamage;
   public ModToolItem(Properties properties, int harvestLevel, int maxDamage) {
      super(properties);
      this.harvestLevel = harvestLevel;
      this.maxDamage = maxDamage;
   }

   @Override
   public int getHarvestLevel(ItemStack stack, net.minecraftforge.common.ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState) {
      return toolClasses.getOrDefault(tool, this.harvestLevel);
   }

   @Override
   public int getMaxDamage(ItemStack stack) {
      return this.maxDamage;
   }

   @Override
   public int getItemStackLimit(ItemStack stack) {
      return 2048;
   }
}