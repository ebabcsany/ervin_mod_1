package com.babcsany.minecraft.ervin_mod_1.item;

import com.google.common.collect.Maps;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.TextFormatting;
import com.babcsany.minecraft.ervin_mod_1.item.TextFormatting1;

public enum Rarity1 implements com.babcsany.minecraft.ervin_mod_1.item.IExtensibleEnum1 {
   COMMON(TextFormatting1.WHITE),
   UNCOMMON(TextFormatting1.YELLOW),
   RARE(TextFormatting1.AQUA),
   EPIC(TextFormatting1.LIGHT_PURPLE),
   Wr(TextFormatting1.Wr);

   public final TextFormatting1 color;

   private Rarity1(TextFormatting1 p_i48837_3_) {
      this.color = p_i48837_3_;
   }

   public static Rarity1 create(String name, TextFormatting1 p_i48837_3_) {
      throw new IllegalStateException("Enum not extended");
   }
}