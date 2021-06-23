package com.babcsany.minecraft.ervin_mod_1.world;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.UUID;

public abstract class BossInfo {
   private final UUID uniqueId;
   protected ITextComponent name;
   protected float percent;
   protected Color color;
   protected Overlay overlay;
   protected boolean darkenSky;
   protected boolean playEndBossMusic;
   protected boolean createFog;

   public BossInfo(UUID uniqueIdIn, ITextComponent nameIn, Color colorIn, Overlay overlayIn) {
      this.uniqueId = uniqueIdIn;
      this.name = nameIn;
      this.color = colorIn;
      this.overlay = overlayIn;
      this.percent = 1.0F;
   }

   public UUID getUniqueId() {
      return this.uniqueId;
   }

   public ITextComponent getName() {
      return this.name;
   }

   public void setName(ITextComponent nameIn) {
      this.name = nameIn;
   }

   public float getPercent() {
      return this.percent;
   }

   public void setPercent(float percentIn) {
      this.percent = percentIn;
   }

   public Color getColor() {
      return this.color;
   }

   public void setColor(Color colorIn) {
      this.color = colorIn;
   }

   public Overlay getOverlay() {
      return this.overlay;
   }

   public void setOverlay(Overlay overlayIn) {
      this.overlay = overlayIn;
   }

   public boolean shouldDarkenSky() {
      return this.darkenSky;
   }

   public BossInfo setDarkenSky(boolean darkenSkyIn) {
      this.darkenSky = darkenSkyIn;
      return this;
   }

   public boolean shouldPlayEndBossMusic() {
      return this.playEndBossMusic;
   }

   public BossInfo setPlayEndBossMusic(boolean playEndBossMusicIn) {
      this.playEndBossMusic = playEndBossMusicIn;
      return this;
   }

   public BossInfo setCreateFog(boolean createFogIn) {
      this.createFog = createFogIn;
      return this;
   }

   public boolean shouldCreateFog() {
      return this.createFog;
   }

   public enum Color {
      DARK_RED("dark_red", TextFormatting.DARK_RED),
      RED("red", TextFormatting.RED),
      GOLD("gold", TextFormatting.GOLD),
      YELLOW("yellow", TextFormatting.YELLOW),
      DARK_GREEN("dark_green", TextFormatting.DARK_GREEN),
      GREEN("green", TextFormatting.GREEN),
      AQUA("aqua", TextFormatting.AQUA),
      DARK_AQUA("dark_aqua", TextFormatting.DARK_AQUA),
      DARK_BLUE("dark_blue", TextFormatting.DARK_BLUE),
      BLUE("blue", TextFormatting.BLUE),
      LIGHT_PURPLE("light_purple", TextFormatting.LIGHT_PURPLE),
      DARK_PURPLE("dark_purple", TextFormatting.DARK_PURPLE),
      WHITE("white", TextFormatting.WHITE),
      GRAY("gray", TextFormatting.GRAY),
      DARK_GRAY("dark_gray", TextFormatting.DARK_GRAY),
      BLACK("black", TextFormatting.BLACK),
      BLACKL("blackl", TextFormatting.fromColorIndex(210134));

      private final String name;
      private final TextFormatting formatting;

      Color(String name, TextFormatting text) {
         this.name = name;
         this.formatting = text;
      }

      public TextFormatting getFormatting() {
         return this.formatting;
      }

      public String getName() {
         return this.name;
      }

      public static Color byName(String name) {
         for(Color bossinfo$color : values()) {
            if (bossinfo$color.name.equals(name)) {
               return bossinfo$color;
            }
         }

         return WHITE;
      }
   }

   public enum Overlay {
      PROGRESS("progress"),
      NOTCHED_6("notched_6"),
      NOTCHED_10("notched_10"),
      NOTCHED_12("notched_12"),
      NOTCHED_20("notched_20");

      private final String name;

      private Overlay(String p_i48621_3_) {
         this.name = p_i48621_3_;
      }

      public String getName() {
         return this.name;
      }

      public static Overlay byName(String p_201485_0_) {
         for(Overlay bossinfo$overlay : values()) {
            if (bossinfo$overlay.name.equals(p_201485_0_)) {
               return bossinfo$overlay;
            }
         }

         return PROGRESS;
      }
   }
}
