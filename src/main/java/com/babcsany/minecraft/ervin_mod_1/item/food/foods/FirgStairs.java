package com.babcsany.minecraft.ervin_mod_1.item.food.foods;

import com.babcsany.minecraft.ervin_mod_1.init.item.food.brefk.BrefkStageItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class FirgStairs extends BlockItem {
   public FirgStairs(Block blockIn, Item.Properties properties) {
      super(blockIn, properties);
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 24;
   }
}