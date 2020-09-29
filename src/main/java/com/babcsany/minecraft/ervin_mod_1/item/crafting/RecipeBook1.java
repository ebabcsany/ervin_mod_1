package com.babcsany.minecraft.ervin_mod_1.item.crafting;

import com.babcsany.minecraft.ervin_mod_1.inventory.container.BlastFurnaceContainer1;
import com.babcsany.minecraft.ervin_mod_1.inventory.container.FurnaceContainer1;
import com.babcsany.minecraft.ervin_mod_1.inventory.container.SmokerContainer1;
import com.google.common.collect.Sets;
import net.minecraft.inventory.container.BlastFurnaceContainer;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.SmokerContainer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Set;

public class RecipeBook1 {
   protected final Set<ResourceLocation> recipes = Sets.newHashSet();
   protected final Set<ResourceLocation> newRecipes = Sets.newHashSet();
   protected boolean isGuiOpen;
   protected boolean isFilteringCraftable;
   protected boolean isFurnaceGuiOpen;
   protected boolean isFurnaceFilteringCraftable;
   protected boolean isBlastFurnaceGuiOpen;
   protected boolean isBlastFurnaceFilteringCraftable;
   protected boolean isSmokerGuiOpen;
   protected boolean isSmokerFilteringCraftable;

   public void copyFrom(RecipeBook1 that) {
      this.recipes.clear();
      this.newRecipes.clear();
      this.isGuiOpen = that.isGuiOpen;
      this.isFilteringCraftable = that.isFilteringCraftable;
      this.isFurnaceGuiOpen = that.isFurnaceGuiOpen;
      this.isFurnaceFilteringCraftable = that.isFurnaceFilteringCraftable;
      this.isBlastFurnaceGuiOpen = that.isBlastFurnaceGuiOpen;
      this.isBlastFurnaceFilteringCraftable = that.isBlastFurnaceFilteringCraftable;
      this.isSmokerGuiOpen = that.isSmokerGuiOpen;
      this.isSmokerFilteringCraftable = that.isSmokerFilteringCraftable;
      this.recipes.addAll(that.recipes);
      this.newRecipes.addAll(that.newRecipes);
   }

   public void unlock(IRecipe<?> recipe) {
      if (!recipe.isDynamic()) {
         this.unlock(recipe.getId());
      }

   }

   protected void unlock(ResourceLocation resourceLocation) {
      this.recipes.add(resourceLocation);
   }

   public boolean isUnlocked(@Nullable IRecipe<?> recipe) {
      return recipe == null ? false : this.recipes.contains(recipe.getId());
   }

   public boolean func_226144_b_(ResourceLocation p_226144_1_) {
      return this.recipes.contains(p_226144_1_);
   }

   @OnlyIn(Dist.CLIENT)
   public void lock(IRecipe<?> recipe) {
      this.lock(recipe.getId());
   }

   protected void lock(ResourceLocation resourceLocation) {
      this.recipes.remove(resourceLocation);
      this.newRecipes.remove(resourceLocation);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isNew(IRecipe<?> recipe) {
      return this.newRecipes.contains(recipe.getId());
   }

   public void markSeen(IRecipe<?> recipe) {
      this.newRecipes.remove(recipe.getId());
   }

   public void markNew(IRecipe<?> recipe) {
      this.markNew(recipe.getId());
   }

   protected void markNew(ResourceLocation resourceLocation) {
      this.newRecipes.add(resourceLocation);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isGuiOpen() {
      return this.isGuiOpen;
   }

   public void setGuiOpen(boolean open) {
      this.isGuiOpen = open;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFilteringCraftable1(RecipeBookContainer<?> recipeBookContainer) {
      /*if (recipeBookContainer instanceof FurnaceContainer1)
      if (recipeBookContainer instanceof FurnaceContainer1)
      if (recipeBookContainer instanceof FurnaceContainer1)*/
      if (recipeBookContainer instanceof FurnaceContainer1) {
         return this.isFurnaceFilteringCraftable;
      } else if (recipeBookContainer instanceof BlastFurnaceContainer1) {
         return this.isBlastFurnaceFilteringCraftable;
      } else {
         return recipeBookContainer instanceof SmokerContainer1 ? this.isSmokerFilteringCraftable : this.isFilteringCraftable;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFilteringCraftable() {
      return this.isFilteringCraftable;
   }

   public void setFilteringCraftable(boolean shouldFilter) {
      this.isFilteringCraftable = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFurnaceGuiOpen() {
      return this.isFurnaceGuiOpen;
   }

   public void setFurnaceGuiOpen(boolean isOpen) {
      this.isFurnaceGuiOpen = isOpen;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFurnaceFilteringCraftable() {
      return this.isFurnaceFilteringCraftable;
   }

   public void setFurnaceFilteringCraftable(boolean shouldFilter) {
      this.isFurnaceFilteringCraftable = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isBlastFurnaceGuiOpen() {
      return this.isBlastFurnaceGuiOpen;
   }

   public void setBlastFurnaceGuiOpen(boolean shouldFilter) {
      this.isBlastFurnaceGuiOpen = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isBlastFurnaceFilteringCraftable() {
      return this.isBlastFurnaceFilteringCraftable;
   }

   public void setBlastFurnaceFilteringCraftable(boolean shouldFilter) {
      this.isBlastFurnaceFilteringCraftable = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isSmokerGuiOpen() {
      return this.isSmokerGuiOpen;
   }

   public void setSmokerGuiOpen(boolean isOpen) {
      this.isSmokerGuiOpen = isOpen;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isSmokerFilteringCraftable() {
      return this.isSmokerFilteringCraftable;
   }

   public void setSmokerFilteringCraftable(boolean shouldFilter) {
      this.isSmokerFilteringCraftable = shouldFilter;
   }
}