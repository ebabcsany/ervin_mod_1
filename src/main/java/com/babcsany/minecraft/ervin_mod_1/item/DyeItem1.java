package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.ViltEntity;
import com.google.common.collect.Maps;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

import java.util.Map;

public class DyeItem1 extends Item {
   private static final Map<DyeColor1, DyeItem1> COLOR_DYE_ITEM_MAP = Maps.newEnumMap(DyeColor1.class);
   private final DyeColor1 dyeColor1;

   public DyeItem1(DyeColor1 dyeColor1In, Properties builder) {
      super(builder);
      this.dyeColor1 = dyeColor1In;
      COLOR_DYE_ITEM_MAP.put(dyeColor1In, this);
   }

   /**
    * Returns true if the item can be used on the given entity, e.g. shears on sheep.
    */
   public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
      if (target instanceof ViltEntity) {
         ViltEntity viltentity = (ViltEntity)target;
         if (viltentity.isAlive() && !viltentity.getSheared1() && viltentity.getFleeceColor1() != this.dyeColor1) {
            viltentity.setFleeceColor1(this.dyeColor1);
            stack.shrink(1);
         }

         return true;
      } else {
         return false;
      }
   }

   public DyeColor1 getDyeColor1() {
      return this.dyeColor1;
   }

   public static DyeItem1 getItem(DyeColor1 color) {
      return COLOR_DYE_ITEM_MAP.get(color);
   }
}