package com.babcsany.minecraft.ervin_mod_1.item.food.foods;

import com.babcsany.minecraft.ervin_mod_1.item.UsingAndBurningBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Firg extends UsingAndBurningBlockItem {
   public Firg(Block blockIn, Item.Properties properties) {
      super(blockIn, properties, 32, 10000);
   }
}