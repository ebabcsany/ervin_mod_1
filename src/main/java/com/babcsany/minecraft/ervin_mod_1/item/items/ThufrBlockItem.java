package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier2;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.IExtensibleEnum;
import net.minecraftforge.common.ToolType;

import java.util.Set;

public class ThufrBlockItem extends ToolBlockItem_1 {
   private static final Set<Material> field_234662_c_ = Sets.newHashSet(Material.ROCK);

   public ThufrBlockItem(Block blockIn, IItemTier2 tier, float attackDamageIn, Properties builderIn) {
      super(blockIn, attackDamageIn, tier, builderIn);
   }

   /**
    * Check whether this Item can harvest the given Block
    */
   public boolean canHarvestBlock(BlockState blockIn) {
      int i = (int) this.getTier().getAttackDamage();
      if (blockIn.getHarvestTool() == ToolType.PICKAXE) {
         return i >= blockIn.getHarvestLevel();
      }
      Material material = blockIn.getMaterial();
      return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      Material material = state.getMaterial();
      return field_234662_c_.contains(material) ? this.efficiency : super.getDestroySpeed(stack, state);
   }

   @Override
   public Rarity getRarity(ItemStack stack) {
      return Rarity.create("firn", TextFormatting.BOLD);
   }

   public enum ModRarity implements IExtensibleEnum {
      TEST(TextFormatting.BOLD);

      public final TextFormatting text;

      ModRarity(TextFormatting format) {
         this.text = format;
      }

      public static ModRarity create(String name, TextFormatting format) {
         throw new IllegalStateException("Enum not extended");
      }
   }
}