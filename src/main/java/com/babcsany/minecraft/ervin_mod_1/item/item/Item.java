package com.babcsany.minecraft.ervin_mod_1.item.item;

import com.google.common.collect.Maps;
import net.minecraft.item.*;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.Map;

public class Item extends net.minecraft.item.Item implements IItemProvider, net.minecraftforge.common.extensions.IForgeItem {
   private int maxStackSize = 2048;
   private int maxDamage;
   @Nullable
   public com.babcsany.minecraft.ervin_mod_1.init.item.food.Food modfood;
   private net.minecraft.item.Item containerItem;
   private net.minecraft.item.ItemGroup group;
   private com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup group1;
   private Rarity rarity = Rarity.COMMON;
   /** Sets food information to this item */
   private Food food;
   private com.babcsany.minecraft.ervin_mod_1.init.item.food.Food modFood;
   private boolean burnable;
   private boolean canRepair = true;
   private Map<net.minecraftforge.common.ToolType, Integer> toolClasses = Maps.newHashMap();
   private java.util.function.Supplier<java.util.concurrent.Callable<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer>> ister;

   public Item(net.minecraft.item.Item.Properties properties) {
      super(properties);
   }

   public static class Properties extends net.minecraft.item.Item.Properties {

      public com.babcsany.minecraft.ervin_mod_1.init.item.food.Food modfood;

      public Properties modFood(com.babcsany.minecraft.ervin_mod_1.init.item.food.Food foodIn) {
         this.modfood = foodIn;
         return this;
      }
   }

   /*public Item(Item item) {

      this.modfood = item.modfood;
   }*/

   /*public net.minecraft.item.Item.Properties food(Food foodIn) {
      this.food = foodIn;
      return this;
   }

   public Item modFood(com.babcsany.minecraft.ervin_mod_1.init.item.food.Food foodIn) {
      this.modFood = foodIn;
      return this;
   }

   public net.minecraft.item.Item.Properties maxStackSize(int maxStackSizeIn) {
      if (this.maxDamage > 0) {
         throw new RuntimeException("Unable to have damage AND stack.");
      } else {
         this.maxStackSize = maxStackSizeIn;
         return this;
      }
   }

   public net.minecraft.item.Item.Properties defaultMaxDamage(int maxDamageIn) {
      return this.maxDamage == 0 ? this.maxDamage(maxDamageIn) : this;
   }

   public net.minecraft.item.Item.Properties maxDamage(int maxDamageIn) {
      this.maxDamage = maxDamageIn;
      this.maxStackSize = 1;
      return this;
   }

   public net.minecraft.item.Item.Properties containerItem(net.minecraft.item.Item containerItemIn) {
      this.containerItem = containerItemIn;
      return this;
   }

   public net.minecraft.item.Item.Properties group(net.minecraft.item.ItemGroup groupIn) {
      this.group = groupIn;
      return this;
   }

   public net.minecraft.item.Item.Properties group1(com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup groupIn) {
      this.group1 = groupIn;
      return this;
   }

   public net.minecraft.item.Item.Properties rarity(Rarity rarityIn) {
      this.rarity = rarityIn;
      return this;
   }

   public net.minecraft.item.Item.Properties isBurnable() {
      this.burnable = true;
      return this;
   }

   public net.minecraft.item.Item.Properties setNoRepair() {
      canRepair = false;
      return this;
   }

   public net.minecraft.item.Item.Properties addToolType(net.minecraftforge.common.ToolType type, int level) {
      toolClasses.put(type, level);
      return this;
   }

   public net.minecraft.item.Item.Properties setISTER(java.util.function.Supplier<java.util.concurrent.Callable<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer>> ister) {
      this.ister = ister;
      return this;
   }

   @Override
   public Item setRegistryName(ResourceLocation name) {
      return this;
   }

   @Nullable
   @Override
   public ResourceLocation getRegistryName() {
      return null;
   }

   @Override
   public Class<Item> getRegistryType() {
      return null;
   }*/
}