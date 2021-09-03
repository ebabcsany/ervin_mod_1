package com.babcsany.minecraft.ervin_mod_1.item.burning.armor.firt;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class FirtBoots extends ArmorItem {
   public FirtBoots(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
      super(materialIn, slot, builderIn);
   }

   public int getBurnTime(ItemStack stack) {
      return 9600;
   }
}
