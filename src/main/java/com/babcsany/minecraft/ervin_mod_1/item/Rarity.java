package com.babcsany.minecraft.ervin_mod_1.item;

import java.awt.*;

public enum Rarity implements net.minecraftforge.common.IExtensibleEnum {
   COMMON(Color.WHITE),
   UNCOMMON(Color.YELLOW),
   RARE(Color1.AQUA),
   EPIC(Color1.LIGHT_PURPLE);

   public final Color color;

   Rarity(Color p_i48837_3_) {
      this.color = p_i48837_3_;
   }

   public static Rarity create(String name, Color p_i48837_3_) {
      throw new IllegalStateException("Enum not extended");
   }
}
