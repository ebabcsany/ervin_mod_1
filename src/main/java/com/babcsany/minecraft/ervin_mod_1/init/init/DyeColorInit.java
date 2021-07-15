package com.babcsany.minecraft.ervin_mod_1.init.init;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public enum DyeColorInit implements IStringSerializable {
   WHITE(0, "white", 16383998, MaterialColorInit.WHITE, 15790320, 16777215),
   ORANGE(1, "orange", 16351261, MaterialColorInit.ORANGE, 15435844, 16738335),
   MAGENTA(2, "magenta", 13061821, MaterialColorInit.MAGENTA, 12801229, 16711935),
   LIGHT_BLUE(3, "light_blue", 3847130, MaterialColorInit.LIGHT_BLUE, 6719955, 10141901),
   YELLOW(5, "yellow", 16701501, MaterialColorInit.YELLOW, 14602026, 16776960),
   LIME(6, "lime", 8439583, MaterialColorInit.LIME, 4312372, 12582656),
   PINK(7, "pink", 15961002, MaterialColorInit.PINK, 14188952, 16738740),
   GRAY(8, "gray", 4673362, MaterialColorInit.GRAY, 4408131, 8421504),
   LIGHT_GRAY(9, "light_gray", 10329495, MaterialColorInit.LIGHT_GRAY, 11250603, 13882323),
   CYAN(10, "cyan", 1481884, MaterialColorInit.CYAN, 2651799, 65535),
   PURPLE(11, "purple", 8991416, MaterialColorInit.PURPLE, 8073150, 10494192),
   BLUE(12, "blue", 3949738, MaterialColorInit.BLUE, 2437522, 255),
   BROWN(13, "brown", 8606770, MaterialColorInit.BROWN, 5320730, 9127187),
   GREEN(14, "green", 6192150, MaterialColorInit.GREEN, 3887386, 65280),
   RED(15, "red", 11546150, MaterialColorInit.RED, 11743532, 16711680),
   BLACK(16, "black", 1908001, MaterialColorInit.BLACK, 1973019, 0);

   private static final DyeColorInit[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(DyeColorInit::getId)).toArray((p_199795_0_) -> new DyeColorInit[p_199795_0_]);
   private static final Int2ObjectOpenHashMap<DyeColorInit> BY_FIREWORK_COLOR = new Int2ObjectOpenHashMap<>(Arrays.stream(values()).collect(Collectors.toMap((p_199793_0_) -> p_199793_0_.fireworkColor, (p_199794_0_) -> p_199794_0_)));
   private final int id;
   private final String translationKey;
   private final MaterialColorInit mapColor;
   private final int colorValue;
   private final int swappedColorValue;
   private final float[] colorComponentValues;
   private final int fireworkColor;
   private final net.minecraft.tags.ITag<Item> tag;
   private final int textColor;

   DyeColorInit(int idIn, String translationKeyIn, int colorValueIn, MaterialColorInit mapColorIn, int fireworkColorIn, int textColorIn) {
      this.id = idIn;
      this.translationKey = translationKeyIn;
      this.colorValue = colorValueIn;
      this.mapColor = mapColorIn;
      this.textColor = textColorIn;
      int i = (colorValueIn & 16711680) >> 16;
      int j = (colorValueIn & '\uff00') >> 8;
      int k = (colorValueIn & 255) >> 0;
      this.swappedColorValue = k << 16 | j << 8 | i << 0;
      this.tag = net.minecraft.tags.ItemTags.makeWrapperTag("forge:dyes/" + translationKeyIn);
      this.colorComponentValues = new float[]{(float)i / 255.0F, (float)j / 255.0F, (float)k / 255.0F};
      this.fireworkColor = fireworkColorIn;
   }

   public int getId() {
      return this.id;
   }

   public String getTranslationKey() {
      return this.translationKey;
   }

   /**
    * Gets an array containing 3 floats ranging from 0.0 to 1.0: the red, green, and blue components of the
    * corresponding color.
    */
   public float[] getColorComponentValues() {
      return this.colorComponentValues;
   }

   public MaterialColorInit getMapColor() {
      return this.mapColor;
   }

   public int getFireworkColor() {
      return this.fireworkColor;
   }

   public int getTextColor() {
      return this.textColor;
   }

   public static DyeColorInit byId(int colorId) {
      if (colorId < 0 || colorId >= VALUES.length) {
         colorId = 0;
      }

      return VALUES[colorId];
   }

   public static DyeColorInit byTranslationKey(String translationKeyIn, DyeColorInit fallback) {
      for(DyeColorInit dyecolor : values()) {
         if (dyecolor.translationKey.equals(translationKeyIn)) {
            return dyecolor;
         }
      }

      return fallback;
   }

   @Nullable
   public static DyeColorInit byFireworkColor(int fireworkColorIn) {
      return BY_FIREWORK_COLOR.get(fireworkColorIn);
   }

   public String toString() {
      return this.translationKey;
   }

   public String getString() {
      return this.translationKey;
   }

   public int getColorValue() {
      return colorValue;
   }

   public net.minecraft.tags.ITag<Item> getTag() {
      return tag;
   }

   @Nullable
   public static DyeColorInit getColor(ItemStack stack) {
      if (stack.getItem() instanceof DyeItemInit)
         return ((DyeItemInit)stack.getItem()).getDyeColor();

      for (DyeColorInit color : VALUES) {
         if (stack.getItem().isIn(color.getTag()))
             return color;
      }

      return null;
   }
}