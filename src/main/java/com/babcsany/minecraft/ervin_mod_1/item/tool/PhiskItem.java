package com.babcsany.minecraft.ervin_mod_1.item.tool;

import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class PhiskItem extends ToolItem {
   private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(UnusedBlockInit.get("tgruhuft").get());

   private static Set<Block> setEffectiveBlocks(String... keys) {
      ArrayList<Block> blocks = Arrays.stream(keys).map(key -> UnusedBlockInit.get(key).get()).collect(Collectors.toCollection(ArrayList::new));
       return ImmutableSet.copyOf(blocks);
   }

   public PhiskItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
      super((float)attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(ToolTypeInit.PHISK, tier.getHarvestLevel()));
   }

   /**
    * Check whether this Item can harvest the given Block
    */
   public boolean canHarvestBlock(BlockState blockIn) {
      int i = this.getTier().getHarvestLevel();
      if (blockIn.getHarvestTool() == ToolTypeInit.PHISK) {
         return i >= blockIn.getHarvestLevel();
      }
      Material material = blockIn.getMaterial();
      return material == Material.CORAL || material == Material.ORGANIC || material == Material.BARRIER;
   }

   public boolean isEnchantable(ItemStack p_77616_1_) {
      return this.getItemStackLimit(p_77616_1_) == 2048 && this.isDamageable();
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      Material material = state.getMaterial();
      return material != Material.CAKE && material != Material.CORAL && material != Material.DRAGON_EGG ? super.getDestroySpeed(stack, state) : this.efficiency;
   }
}
