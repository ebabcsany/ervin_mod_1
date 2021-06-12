package com.babcsany.minecraft.tags;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollection;
import net.minecraft.tags.TagRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Set;

public class FluidTags {
   private static final TagRegistry<Fluid> collection = new TagRegistry<>();
   public static final ITag.INamedTag<Fluid> JURK = makeWrapperTag("ervin_mod_1:jurk");
   //public static final ITag.INamedTag<Fluid> LAVA = makeWrapperTag("lava");

   public static ITag.INamedTag<Fluid> makeWrapperTag(String id) {
      return collection.func_232937_a_(id);
   }

   public static void setCollection(TagCollection<Fluid> collectionIn) {
      collection.func_232935_a_(collectionIn);
   }

   @OnlyIn(Dist.CLIENT)
   public static void func_232899_a_() {
      collection.func_232932_a_();
   }

   public static TagCollection<Fluid> getCollection() {
      return collection.func_232939_b_();
   }

   public static List<TagRegistry.NamedTag<Fluid>> func_241280_c_() {
      return collection.func_241288_c_();
   }

   public static Set<ResourceLocation> func_232901_b_(TagCollection<Fluid> p_232901_0_) {
      return collection.func_232940_b_(p_232901_0_);
   }
}