package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.fluid.MilkFluid;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;

import javax.annotation.Nullable;

public class NirtreProfession extends net.minecraftforge.registries.ForgeRegistryEntry<NirtreProfession> {
   /*public static final NirtreProfession NONE = register("none", PointOfInterestType1.UNEMPLOYED, (SoundEvent)null);
   public static final NirtreProfession ARMORER = register("armorer", PointOfInterestType1.ARMORER, SoundEvents.ENTITY_VILLAGER_WORK_ARMORER);
   public static final NirtreProfession NIRTRE = register("nirtre", PointOfInterestType1.NIRTRE, SoundEvents.ENTITY_VILLAGER_TRADE);
   public static final NirtreProfession BUTCHER = register("butcher", PointOfInterestType1.BUTCHER, SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER);
   public static final NirtreProfession CARTOGRAPHER = register("cartographer", PointOfInterestType1.CARTOGRAPHER, SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER);
   public static final NirtreProfession CLERIC = register("cleric", PointOfInterestType1.CLERIC, SoundEvents.ENTITY_VILLAGER_WORK_CLERIC);
   public static final NirtreProfession FARMER = register("farmer", PointOfInterestType1.FARMER, ImmutableSet.of(Items.WHEAT, Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.BONE_MEAL), ImmutableSet.of(Blocks.FARMLAND), SoundEvents.ENTITY_VILLAGER_WORK_FARMER);
   public static final NirtreProfession FISHERMAN = register("fisherman", PointOfInterestType1.FISHERMAN, SoundEvents.ENTITY_VILLAGER_WORK_FISHERMAN);
   public static final NirtreProfession FLETCHER = register("fletcher", PointOfInterestType1.FLETCHER, SoundEvents.ENTITY_VILLAGER_WORK_FLETCHER);
   public static final NirtreProfession LEATHERWORKER = register("leatherworker", PointOfInterestType1.LEATHERWORKER, SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);
   public static final NirtreProfession LIBRARIAN = register("librarian", PointOfInterestType1.LIBRARIAN, SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN);
   public static final NirtreProfession MASON = register("mason", PointOfInterestType1.MASON, SoundEvents.ENTITY_VILLAGER_WORK_MASON);
   public static final NirtreProfession NITWIT = register("nitwit", PointOfInterestType1.NITWIT, (SoundEvent)null);
   public static final NirtreProfession SHEPHERD = register("shepherd", PointOfInterestType1.SHEPHERD, SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD);
   public static final NirtreProfession TOOLSMITH = register("toolsmith", PointOfInterestType1.TOOLSMITH, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);
   public static final NirtreProfession WEAPONSMITH = register("weaponsmith", PointOfInterestType1.WEAPONSMITH, SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH);
   private final String name;
   private final PointOfInterestType1 pointOfInterest;
   /** Defines items villagers of this profession can pick up and use. */
   //private final ImmutableSet<Item> specificItems;
   /** World blocks this profession interracts with. */
   /*private final ImmutableSet<Block> relatedWorldBlocks;
   @Nullable
   private final SoundEvent sound;

   public NirtreProfession(String nameIn, PointOfInterestType1 pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, @Nullable SoundEvent soundIn) {
      this.name = nameIn;
      this.pointOfInterest = pointOfInterestIn;
      this.specificItems = specificItemsIn;
      this.relatedWorldBlocks = relatedWorldBlocksIn;
      this.sound = soundIn;
   }

   public PointOfInterestType1 getPointOfInterest() {
      return this.pointOfInterest;
   }

   /**
    * @return A shared static immutable set of the specific items this profession can handle.
    */
   /*public ImmutableSet<Item> getSpecificItems() {
      return this.specificItems;
   }

   /**
    * @return A shared static immutable set of the world blocks this profession interracts with beside job site block.
    */
   /*public ImmutableSet<Block> getRelatedWorldBlocks() {
      return this.relatedWorldBlocks;
   }

   @Nullable
   public SoundEvent getSound() {
      return this.sound;
   }

   public String toString() {
      return this.name;
   }

   static NirtreProfession register(String nameIn, PointOfInterestType1 pointOfInterestIn, @Nullable SoundEvent soundIn) {
      return register(nameIn, pointOfInterestIn, ImmutableSet.of(), ImmutableSet.of(), soundIn);
   }

   static NirtreProfession register(String nameIn, PointOfInterestType1 pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, @Nullable SoundEvent soundIn) {
      return Registry.register(Registry.NIRTRE_PROFESSION, new ResourceLocation(nameIn), new NirtreProfession(nameIn, pointOfInterestIn, specificItemsIn, relatedWorldBlocksIn, soundIn));
   }*/
}