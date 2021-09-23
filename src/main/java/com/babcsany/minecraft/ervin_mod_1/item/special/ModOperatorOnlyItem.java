package com.babcsany.minecraft.ervin_mod_1.item.special;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import com.babcsany.minecraft.item.ModBlockItem;
import com.babcsany.minecraft.item.ModBlockItemUseContext;

import javax.annotation.Nullable;

public class ModOperatorOnlyItem extends ModBlockItem {
   public ModOperatorOnlyItem(Block blockIn, Properties builder) {
      super(blockIn, builder);
   }

   @Nullable
   protected BlockState getStateForPlacement(ModBlockItemUseContext context) {
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