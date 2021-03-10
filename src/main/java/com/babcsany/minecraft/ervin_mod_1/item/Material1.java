package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public final class Material1 {
   public static final Material1 AIR = (new Material1.Builder(MaterialColor1.AIR)).doesNotBlockMovement().notOpaque().notSolid().replaceable().build();
   public static final Material1 STRUCTURE_VOID = (new Material1.Builder(MaterialColor1.AIR)).doesNotBlockMovement().notOpaque().notSolid().replaceable().build();
   public static final Material1 PORTAL = (new Material1.Builder(MaterialColor1.AIR)).doesNotBlockMovement().notOpaque().notSolid().pushBlocks().build();
   public static final Material1 CARPET = (new Material1.Builder(MaterialColor1.WOOL)).doesNotBlockMovement().notOpaque().notSolid().flammable().build();
   public static final Material1 PLANTS = (new Material1.Builder(MaterialColor1.FOLIAGE)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().build();
   public static final Material1 OCEAN_PLANT = (new Material1.Builder(MaterialColor1.WATER)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().build();
   public static final Material1 TALL_PLANTS = (new Material1.Builder(MaterialColor1.FOLIAGE)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().flammable().build();
   public static final Material1 SEA_GRASS = (new Material1.Builder(MaterialColor1.WATER)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().build();
   public static final Material1 WATER = (new Material1.Builder(MaterialColor1.WATER)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().liquid().build();
   public static final Material1 BUBBLE_COLUMN = (new Material1.Builder(MaterialColor1.WATER)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().liquid().build();
   public static final Material1 LAVA = (new Material1.Builder(MaterialColor1.TNT)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().liquid().build();
   public static final Material1 SNOW = (new Material1.Builder(MaterialColor1.SNOW)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().requiresTool().build();
   public static final Material1 FIRE = (new Material1.Builder(MaterialColor1.AIR)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().build();
   public static final Material1 MISCELLANEOUS = (new Material1.Builder(MaterialColor1.AIR)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().build();
   public static final Material1 WEB = (new Material1.Builder(MaterialColor1.WOOL)).doesNotBlockMovement().notOpaque().pushDestroys().requiresTool().build();
   public static final Material1 REDSTONE_LIGHT = (new Material1.Builder(MaterialColor1.AIR)).build();
   public static final Material1 CLAY = (new Material1.Builder(MaterialColor1.CLAY)).build();
   public static final Material1 EARTH = (new Material1.Builder(MaterialColor1.DIRT)).build();
   public static final Material1 ORGANIC = (new Material1.Builder(MaterialColor1.GRASS)).build();
   public static final Material1 PACKED_ICE = (new Material1.Builder(MaterialColor1.ICE)).build();
   public static final Material1 SAND = (new Material1.Builder(MaterialColor1.SAND)).build();
   public static final Material1 SPONGE = (new Material1.Builder(MaterialColor1.YELLOW)).build();
   public static final Material1 SHULKER = (new Material1.Builder(MaterialColor1.PURPLE)).build();
   public static final Material1 WOOD = (new Material1.Builder(MaterialColor1.WOOD)).flammable().build();
   public static final Material1 BAMBOO_SAPLING = (new Material1.Builder(MaterialColor1.WOOD)).flammable().pushDestroys().doesNotBlockMovement().build();
   public static final Material1 BAMBOO = (new Material1.Builder(MaterialColor1.WOOD)).flammable().pushDestroys().build();
   public static final Material1 WOOL = (new Material1.Builder(MaterialColor1.WOOL)).flammable().build();
   public static final Material1 TNT = (new Material1.Builder(MaterialColor1.TNT)).flammable().notOpaque().build();
   public static final Material1 LEAVES = (new Material1.Builder(MaterialColor1.FOLIAGE)).flammable().notOpaque().pushDestroys().build();
   public static final Material1 GLASS = (new Material1.Builder(MaterialColor1.AIR)).notOpaque().build();
   public static final Material1 ICE = (new Material1.Builder(MaterialColor1.ICE)).notOpaque().build();
   public static final Material1 CACTUS = (new Material1.Builder(MaterialColor1.FOLIAGE)).notOpaque().pushDestroys().build();
   public static final Material1 ROCK = (new Material1.Builder(MaterialColor1.STONE)).requiresTool().build();
   public static final Material1 IRON = (new Material1.Builder(MaterialColor1.IRON)).requiresTool().build();
   /** The material for crafted snow. */
   public static final Material1 SNOW_BLOCK = (new Material1.Builder(MaterialColor1.SNOW)).requiresTool().build();
   public static final Material1 ANVIL = (new Material1.Builder(MaterialColor1.IRON)).requiresTool().pushBlocks().build();
   public static final Material1 BARRIER = (new Material1.Builder(MaterialColor1.AIR)).requiresTool().pushBlocks().build();
   public static final Material1 PISTON = (new Material1.Builder(MaterialColor1.STONE)).pushBlocks().build();
   public static final Material1 CORAL = (new Material1.Builder(MaterialColor1.FOLIAGE)).pushDestroys().build();
   public static final Material1 GOURD = (new Material1.Builder(MaterialColor1.FOLIAGE)).pushDestroys().build();
   public static final Material1 DRAGON_EGG = (new Material1.Builder(MaterialColor1.FOLIAGE)).pushDestroys().build();
   public static final Material1 CAKE = (new Material1.Builder(MaterialColor1.AIR)).pushDestroys().build();
   /** The color index used to draw the blocks of this material on maps. */
   private final MaterialColor1 color;
   /**
    * Mobility information flag. 0 indicates that this block is normal, 1 indicates that it can't push other blocks, 2
    * indicates that it can't be pushed.
    */
   private final PushReaction pushReaction;
   private final boolean blocksMovement;
   private final boolean flammable;
   private final boolean requiresNoTool;
   private final boolean isLiquid;
   private final boolean isOpaque;
   private final boolean replaceable;
   private final boolean isSolid;

   public Material1(MaterialColor1 materialMapColorIn, boolean liquid, boolean solid, boolean doesBlockMovement, boolean opaque, boolean requiresNoToolIn, boolean canBurnIn, boolean replaceableIn, PushReaction mobilityFlag) {
      this.color = materialMapColorIn;
      this.isLiquid = liquid;
      this.isSolid = solid;
      this.blocksMovement = doesBlockMovement;
      this.isOpaque = opaque;
      this.requiresNoTool = requiresNoToolIn;
      this.flammable = canBurnIn;
      this.replaceable = replaceableIn;
      this.pushReaction = mobilityFlag;
   }

   /**
    * Returns if blocks of these materials are liquids.
    */
   public boolean isLiquid() {
      return this.isLiquid;
   }

   /**
    * Returns true if the block is a considered solid. This is true by default.
    */
   public boolean isSolid() {
      return this.isSolid;
   }

   /**
    * Returns if this material is considered solid or not
    */
   public boolean blocksMovement() {
      return this.blocksMovement;
   }

   /**
    * Returns if the block can burn or not.
    */
   public boolean isFlammable() {
      return this.flammable;
   }

   /**
    * Returns whether the material can be replaced by other blocks when placed - eg snow, vines and tall grass.
    */
   public boolean isReplaceable() {
      return this.replaceable;
   }

   /**
    * Indicate if the material is opaque
    */
   public boolean isOpaque() {
      return this.isOpaque;
   }

   /**
    * Returns true if the material can be harvested without a tool (or with the wrong tool)
    */
   public boolean isToolNotRequired() {
      return this.requiresNoTool;
   }

   public PushReaction getPushReaction() {
      return this.pushReaction;
   }

   /**
    * Retrieves the color index of the block. This is is the same color used by vanilla maps to represent this block.
    */
   public MaterialColor1 getColor() {
      return this.color;
   }

   public static class Builder {
      private PushReaction pushReaction = PushReaction.NORMAL;
      private boolean blocksMovement = true;
      private boolean canBurn;
      private boolean requiresNoTool = true;
      private boolean isLiquid;
      private boolean isReplaceable;
      private boolean isSolid = true;
      private final MaterialColor1 color;
      private boolean isOpaque = true;

      public Builder(MaterialColor1 color) {
         this.color = color;
      }

      public Material1.Builder liquid() {
         this.isLiquid = true;
         return this;
      }

      public Material1.Builder notSolid() {
         this.isSolid = false;
         return this;
      }

      public Material1.Builder doesNotBlockMovement() {
         this.blocksMovement = false;
         return this;
      }

      private Material1.Builder notOpaque() {
         this.isOpaque = false;
         return this;
      }

      protected Material1.Builder requiresTool() {
         this.requiresNoTool = false;
         return this;
      }

      protected Material1.Builder flammable() {
         this.canBurn = true;
         return this;
      }

      public Material1.Builder replaceable() {
         this.isReplaceable = true;
         return this;
      }

      protected Material1.Builder pushDestroys() {
         this.pushReaction = PushReaction.DESTROY;
         return this;
      }

      protected Material1.Builder pushBlocks() {
         this.pushReaction = PushReaction.BLOCK;
         return this;
      }

      public Material1 build() {
         return new Material1(this.color, this.isLiquid, this.isSolid, this.blocksMovement, this.isOpaque, this.requiresNoTool, this.canBurn, this.isReplaceable, this.pushReaction);
      }
   }
}