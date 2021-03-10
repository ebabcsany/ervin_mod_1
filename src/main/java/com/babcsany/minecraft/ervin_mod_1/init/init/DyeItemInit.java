package com.babcsany.minecraft.ervin_mod_1.init.init;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.ViltEntity1;
import com.google.common.collect.Maps;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

import java.util.Map;

public class DyeItemInit extends Item {
   private static final Map<DyeColorInit, DyeItemInit> COLOR_DYE_ITEM_MAP = Maps.newEnumMap(DyeColorInit.class);
   private final DyeColorInit dyeColor;

   public DyeItemInit(DyeColorInit dyeColorIn, Properties builder) {
      super(builder);
      this.dyeColor = dyeColorIn;
      COLOR_DYE_ITEM_MAP.put(dyeColorIn, this);
   }

   /**
    * Returns true if the item can be used on the given entity, e.g. shears on sheep.
    */
   public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
      if (target instanceof ViltEntity1) {
         ViltEntity1 sheepentity = (ViltEntity1)target;
         if (sheepentity.isAlive() && !sheepentity.getSheared() && sheepentity.getFleeceColor() != this.dyeColor) {
            if (!playerIn.world.isRemote) {
               sheepentity.setFleeceColor(this.dyeColor);
               stack.shrink(1);
            }

            return ActionResultType.func_233537_a_(playerIn.world.isRemote);
         }
      }

      return ActionResultType.PASS;
   }

   public DyeColorInit getDyeColor() {
      return this.dyeColor;
   }

   public static DyeItemInit getItem(DyeColorInit color) {
      return COLOR_DYE_ITEM_MAP.get(color);
   }
}