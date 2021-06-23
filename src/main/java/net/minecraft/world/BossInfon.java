package net.minecraft.world;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.Objects;
import java.util.UUID;

public abstract class BossInfon {
   private final UUID uniqueId;
   protected ITextComponent name;
   protected float percent;
   protected Color color;
   protected com.babcsany.minecraft.ervin_mod_1.world.BossInfo.Color color1;
   protected Overlay overlay;
   protected com.babcsany.minecraft.ervin_mod_1.world.BossInfo.Overlay overlay1;
   protected boolean darkenSky;
   protected boolean playEndBossMusic;
   protected boolean createFog;

   public BossInfon(UUID uniqueIdIn, ITextComponent nameIn, Color colorIn, Overlay overlayIn) {
      super();
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

   public BossInfon setDarkenSky(boolean darkenSkyIn) {
      this.darkenSky = darkenSkyIn;
      return this;
   }

   public boolean shouldPlayEndBossMusic() {
      return this.playEndBossMusic;
   }

   public BossInfon setPlayEndBossMusic(boolean playEndBossMusicIn) {
      this.playEndBossMusic = playEndBossMusicIn;
      return this;
   }

   public BossInfon setCreateFog(boolean createFogIn) {
      this.createFog = createFogIn;
      return this;
   }

   public boolean shouldCreateFog() {
      return this.createFog;
   }

   public static enum Color {
      PINK("pink", TextFormatting.RED),
      BLUE("blue", TextFormatting.BLUE),
      RED("red", TextFormatting.DARK_RED),
      GREEN("green", TextFormatting.GREEN),
      YELLOW("yellow", TextFormatting.YELLOW),
      PURPLE("purple", TextFormatting.DARK_BLUE),
      WHITE("white", TextFormatting.WHITE),
      GOLD("gold", TextFormatting.GOLD),
      DARK_GREEN("dark_green", TextFormatting.DARK_GREEN),
      AQUA("aqua", TextFormatting.AQUA),
      DARK_AQUA("dark_aqua", TextFormatting.DARK_AQUA),
      DARK_BLUE("dark_blue", TextFormatting.DARK_BLUE),
      LIGHT_PURPLE("light_purple", TextFormatting.LIGHT_PURPLE),
      DARK_PURPLE("dark_purple", TextFormatting.DARK_PURPLE),
      GRAY("gray", TextFormatting.GRAY),
      DARK_GRAY("dark_gray", TextFormatting.DARK_GRAY),
      BLACK("black", TextFormatting.BLACK),
      BLACKL("blackl", Objects.requireNonNull(TextFormatting.fromColorIndex(210134)));

      public final String name;
      public final TextFormatting formatting;

      Color(String p_i48622_3_, TextFormatting p_i48622_4_) {
         this.name = p_i48622_3_;
         this.formatting = p_i48622_4_;
      }

      public TextFormatting getFormatting() {
         return this.formatting;
      }

      public String getName() {
         return this.name;
      }

      public Color textFormatting(TextFormatting textFormatting) {
         return this;
      }

      public static Color byName(String p_201481_0_) {
         for(Color bossinfo$color : values()) {
            if (bossinfo$color.name.equals(p_201481_0_)) {
               return bossinfo$color;
            }
         }

         return WHITE;
      }
   }

   public static enum Overlay {
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
