package com.babcsany.minecraft.ervin_mod_1.block.material;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MaterialColor1 {
   /** Holds all the 16 colors used on maps, very similar of a pallete system. */
   public static final MaterialColor1[] COLORS1 = new MaterialColor1[560];
   public static final MaterialColor1 AIR = new MaterialColor1(0, 0);
   public static final MaterialColor1 GRASS = new MaterialColor1(1, 8368696);
   public static final MaterialColor1 SAND = new MaterialColor1(2, 16247203);
   public static final MaterialColor1 WOOL = new MaterialColor1(3, 13092807);
   public static final MaterialColor1 TNT = new MaterialColor1(4, 16711680);
   public static final MaterialColor1 ICE = new MaterialColor1(5, 10526975);
   public static final MaterialColor1 IRON = new MaterialColor1(6, 10987431);
   public static final MaterialColor1 FOLIAGE = new MaterialColor1(7, 31744);
   public static final MaterialColor1 SNOW = new MaterialColor1(8, 16777215);
   public static final MaterialColor1 CLAY = new MaterialColor1(9, 10791096);
   public static final MaterialColor1 DIRT = new MaterialColor1(10, 9923917);
   public static final MaterialColor1 STONE = new MaterialColor1(11, 7368816);
   public static final MaterialColor1 WATER = new MaterialColor1(12, 4210943);
   public static final MaterialColor1 WOOD = new MaterialColor1(13, 9402184);
   public static final MaterialColor1 QUARTZ = new MaterialColor1(14, 16776437);
   public static final MaterialColor1 ADOBE = new MaterialColor1(15, 14188339);
   public static final MaterialColor1 MAGENTA = new MaterialColor1(16, 11685080);
   public static final MaterialColor1 LIGHT_BLUE = new MaterialColor1(17, 6724056);
   public static final MaterialColor1 YELLOW = new MaterialColor1(18, 15066419);
   public static final MaterialColor1 LIME = new MaterialColor1(19, 8375321);
   public static final MaterialColor1 PINK = new MaterialColor1(20, 15892389);
   public static final MaterialColor1 GRAY = new MaterialColor1(21, 5000268);
   public static final MaterialColor1 LIGHT_GRAY = new MaterialColor1(22, 10066329);
   public static final MaterialColor1 CYAN = new MaterialColor1(23, 5013401);
   public static final MaterialColor1 PURPLE = new MaterialColor1(24, 8339378);
   public static final MaterialColor1 BLUE = new MaterialColor1(25, 3361970);
   public static final MaterialColor1 BROWN = new MaterialColor1(26, 6704179);
   public static final MaterialColor1 GREEN = new MaterialColor1(27, 6717235);
   public static final MaterialColor1 RED = new MaterialColor1(28, 10040115);
   public static final MaterialColor1 BLACK = new MaterialColor1(29, 1644825);
   public static final MaterialColor1 GOLD = new MaterialColor1(30, 16445005);
   public static final MaterialColor1 DIAMOND = new MaterialColor1(31, 6085589);
   public static final MaterialColor1 LAPIS = new MaterialColor1(32, 4882687);
   public static final MaterialColor1 EMERALD = new MaterialColor1(33, 55610);
   public static final MaterialColor1 OBSIDIAN = new MaterialColor1(34, 8476209);
   public static final MaterialColor1 NETHERRACK = new MaterialColor1(35, 7340544);
   public static final MaterialColor1 WHITE_TERRACOTTA = new MaterialColor1(36, 13742497);
   public static final MaterialColor1 ORANGE_TERRACOTTA = new MaterialColor1(37, 10441252);
   public static final MaterialColor1 MAGENTA_TERRACOTTA = new MaterialColor1(38, 9787244);
   public static final MaterialColor1 LIGHT_BLUE_TERRACOTTA = new MaterialColor1(39, 7367818);
   public static final MaterialColor1 YELLOW_TERRACOTTA = new MaterialColor1(40, 12223780);
   public static final MaterialColor1 LIME_TERRACOTTA = new MaterialColor1(41, 6780213);
   public static final MaterialColor1 PINK_TERRACOTTA = new MaterialColor1(42, 10505550);
   public static final MaterialColor1 GRAY_TERRACOTTA = new MaterialColor1(43, 3746083);
   public static final MaterialColor1 LIGHT_GRAY_TERRACOTTA = new MaterialColor1(44, 8874850);
   public static final MaterialColor1 CYAN_TERRACOTTA = new MaterialColor1(45, 5725276);
   public static final MaterialColor1 PURPLE_TERRACOTTA = new MaterialColor1(46, 8014168);
   public static final MaterialColor1 BLUE_TERRACOTTA = new MaterialColor1(47, 4996700);
   public static final MaterialColor1 BROWN_TERRACOTTA = new MaterialColor1(48, 4993571);
   public static final MaterialColor1 GREEN_TERRACOTTA = new MaterialColor1(49, 5001770);
   public static final MaterialColor1 RED_TERRACOTTA = new MaterialColor1(50, 9321518);
   public static final MaterialColor1 BLACK_TERRACOTTA = new MaterialColor1(51, 2430480);
   public static final MaterialColor1 CRASK = new MaterialColor1(52, 10210108);

   public final int colorValue;
   public final int colorIndex;

   private MaterialColor1(int index, int color1) {
      if (index >= 0 && index <= 63) {
         this.colorIndex = index;
         this.colorValue = color1;
         COLORS1[index] = this;
      } else {
         throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
      }
   }

   @OnlyIn(Dist.CLIENT)
   public int getMapColor(int index) {
      int i = 220;
      if (index == 3) {
         i = 135;
      }

      if (index == 2) {
         i = 255;
      }

      if (index == 1) {
         i = 220;
      }

      if (index == 0) {
         i = 180;
      }

      int j = (this.colorValue >> 16 & 255) * i / 255;
      int k = (this.colorValue >> 8 & 255) * i / 255;
      int l = (this.colorValue & 255) * i / 255;
      return -16777216 | l << 16 | k << 8 | j;
   }
}