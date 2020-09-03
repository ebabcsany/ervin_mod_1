package com.babcsany.minecraft.ervin_mod_1.tags;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollection;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.Optional;

public class FluidTag {
   private static TagCollection<Fluid> collection = new TagCollection<>((p_206955_0_) -> {
      return Optional.empty();
   }, "", false, "");
   private static int generation;
   public static final Tag<Fluid> WATER = makeWrapperTag("water");
   public static final Tag<Fluid> JURK = makeWrapperTag("jurk");
   public static final Tag<Fluid> MILK = makeWrapperTag("milk");
   public static final Tag<Fluid> LAVA = makeWrapperTag("lava");

   public static void setCollection(TagCollection<Fluid> collectionIn) {
      collection = collectionIn;
      ++generation;
   }

   public static TagCollection<Fluid> getCollection() {
      return collection;
   }

   public static int getGeneration() {
      return generation;
   }

   private static Tag<Fluid> makeWrapperTag(String p_206956_0_) {
      return new FluidTag.Wrapper(new ResourceLocation(p_206956_0_));
   }

   public static class Wrapper extends Tag<Fluid> {
      private int lastKnownGeneration = -1;
      private Tag<Fluid> cachedTag;

      public Wrapper(ResourceLocation p_i49117_1_) {
         super(p_i49117_1_);
      }

      /**
       * Returns true if this set contains the specified element.
       */
      public boolean contains(Fluid itemIn) {
         if (this.lastKnownGeneration != FluidTag.generation) {
            this.cachedTag = FluidTag.collection.getOrCreate(this.getId());
            this.lastKnownGeneration = FluidTag.generation;
         }

         return this.cachedTag.contains(itemIn);
      }

      public Collection<Fluid> getAllElements() {
         if (this.lastKnownGeneration != FluidTag.generation) {
            this.cachedTag = FluidTag.collection.getOrCreate(this.getId());
            this.lastKnownGeneration = FluidTag.generation;
         }

         return this.cachedTag.getAllElements();
      }

      public Collection<ITagEntry<Fluid>> getEntries() {
         if (this.lastKnownGeneration != FluidTag.generation) {
            this.cachedTag = FluidTag.collection.getOrCreate(this.getId());
            this.lastKnownGeneration = FluidTag.generation;
         }

         return this.cachedTag.getEntries();
      }
   }
}