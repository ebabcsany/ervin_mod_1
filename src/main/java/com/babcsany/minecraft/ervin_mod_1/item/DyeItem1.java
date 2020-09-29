package com.babcsany.minecraft.ervin_mod_1.item;

import com.google.common.collect.Maps;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

import java.util.Map;

public class DyeItem1 extends Item {
   private static final Map<DyeColor, DyeItem1> COLOR_DYE_ITEM_MAP = Maps.newEnumMap(DyeColor.class);
   private final DyeColor dyeColor;

   public DyeItem1(DyeColor dyeColorIn, Properties builder) {
      super(builder);
      this.dyeColor = dyeColorIn;
      COLOR_DYE_ITEM_MAP.put(dyeColorIn, this);
   }

   /**
    * Returns true if the item can be used on the given entity, e.g. shears on sheep.
    */
   public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
      if (target instanceof SheepEntity) {
         SheepEntity sheepentity = (SheepEntity)target;
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

   public DyeColor getDyeColor() {
      return this.dyeColor;
   }

   public static DyeItem1 getItem(DyeColor color) {
      return COLOR_DYE_ITEM_MAP.get(color);
   }
}