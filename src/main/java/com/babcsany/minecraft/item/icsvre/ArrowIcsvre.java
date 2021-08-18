package com.babcsany.minecraft.item.icsvre;

import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArrowIcsvre extends Icsvre {
   public ArrowIcsvre(Properties builder, Item.Properties builder1) {
      super(builder, builder1);
   }

   public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
      ArrowEntity arrowentity = new ArrowEntity(worldIn, shooter);
      arrowentity.setPotionEffect(stack);
      return arrowentity;
   }

   public boolean isInfinite(IcsvreStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
      int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
      return enchant <= 0 ? false : this.getClass() == ArrowIcsvre.class;
   }
}
