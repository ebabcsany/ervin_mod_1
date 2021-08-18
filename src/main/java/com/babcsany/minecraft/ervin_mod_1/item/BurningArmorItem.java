package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class BurningArmorItem extends ArmorItem {
   private final int durationIn;
   public BurningArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn, int durationIn) {
      super(materialIn, slot, builderIn);
      this.durationIn = durationIn;
   }

   public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }
}
