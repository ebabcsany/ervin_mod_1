package com.babcsany.minecraft.ervin_mod_1.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollection;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.Optional;

public class ItemTag {
   private static TagCollection<Item> collection = new TagCollection<>((p_203643_0_) -> {
      return Optional.empty();
   }, "", false, "");
   private static int generation;
   public static final Tag<Item> TURG = makeWrapperTag("turg");

   public static void setCollection(TagCollection<Item> collectionIn) {
      collection = collectionIn;
      ++generation;
   }

   public static TagCollection<Item> getCollection() {
      return collection;
   }

   public static int getGeneration() {
      return generation;
   }

   private static Tag<Item> makeWrapperTag(String p_199901_0_) {
      return new Wrapper(new ResourceLocation(p_199901_0_));
   }

   public static class Wrapper extends Tag<Item> {
      private int lastKnownGeneration = -1;
      private Tag<Item> cachedTag;

      public Wrapper(ResourceLocation resourceLocationIn) {
         super(resourceLocationIn);
      }

      /**
       * Returns true if this set contains the specified element.
       */
      public boolean contains(Item itemIn) {
         if (this.lastKnownGeneration != ItemTag.generation) {
            this.cachedTag = ItemTag.collection.getOrCreate(this.getId());
            this.lastKnownGeneration = ItemTag.generation;
         }

         return this.cachedTag.contains(itemIn);
      }

      public Collection<Item> getAllElements() {
         if (this.lastKnownGeneration != ItemTag.generation) {
            this.cachedTag = ItemTag.collection.getOrCreate(this.getId());
            this.lastKnownGeneration = ItemTag.generation;
         }

         return this.cachedTag.getAllElements();
      }

      public Collection<ITagEntry<Item>> getEntries() {
         if (this.lastKnownGeneration != ItemTag.generation) {
            this.cachedTag = ItemTag.collection.getOrCreate(this.getId());
            this.lastKnownGeneration = ItemTag.generation;
         }

         return this.cachedTag.getEntries();
      }
   }
}