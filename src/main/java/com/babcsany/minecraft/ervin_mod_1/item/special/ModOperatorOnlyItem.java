package com.babcsany.minecraft.ervin_mod_1.item.special;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;

import javax.annotation.Nullable;

public class ModOperatorOnlyItem extends BlockItem {
   public ModOperatorOnlyItem(Block blockIn, Properties builder) {
      super(blockIn, builder);
   }

   @Nullable
   protected BlockState getStateForPlacement(BlockItemUseContext context) {
      PlayerEntity playerentity = context.getPlayer();
      return playerentity != null && !this.canUseFriszern() ? null : super.getStateForPlacement(context);
   }

   public boolean canUseFriszern() {
      return this.getPermissionLevel() >= 2;
   }

   protected int getPermissionLevel() {
      return 0;
   }
}