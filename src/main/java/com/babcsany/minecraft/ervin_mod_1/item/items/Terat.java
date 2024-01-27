package com.babcsany.minecraft.ervin_mod_1.item.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtensibleEnum;
import net.minecraftforge.common.ToolType;

import java.util.Collections;

public class Terat extends ToolItem_1 {

   public Terat(IItemTier tier, float attackDamageIn, Properties builder) {
      super(tier, attackDamageIn, Collections.emptyList(), builder.addToolType(ToolType.PICKAXE, 32));
   }

   public boolean isEnchantable(ItemStack p_77616_1_) {
      return this.getItemStackLimit(p_77616_1_) == 512 && this.isDamageable();
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