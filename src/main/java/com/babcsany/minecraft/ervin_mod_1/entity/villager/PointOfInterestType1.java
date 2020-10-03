package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BedPart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PointOfInterestType1 extends net.minecraftforge.registries.ForgeRegistryEntry<PointOfInterestType1> {
   /*private static final Supplier<Set<PointOfInterestType1>> field_234168_y_ = Suppliers.memoize(() -> {
      return Registry.NIRTRE_PROFESSION.stream().map(NirtreProfession::getPointOfInterest).collect(Collectors.toSet());
   });
   public static final Predicate<PointOfInterestType1> ANY_NIRTRE_WORKSTATION = (p_221049_0_) -> {
      return field_234168_y_.get().contains(p_221049_0_);
   };
   public static final Predicate<PointOfInterestType1> MATCH_ANY = (p_234172_0_) -> {
      return true;
   };
   private static final Set<BlockState> BED_HEADS = ImmutableList.of(Blocks.RED_BED, Blocks.BLACK_BED, Blocks.BLUE_BED, Blocks.BROWN_BED, Blocks.CYAN_BED, Blocks.GRAY_BED, Blocks.GREEN_BED, Blocks.LIGHT_BLUE_BED, Blocks.LIGHT_GRAY_BED, Blocks.LIME_BED, Blocks.MAGENTA_BED, Blocks.ORANGE_BED, Blocks.PINK_BED, Blocks.PURPLE_BED, Blocks.WHITE_BED, Blocks.YELLOW_BED).stream().flatMap((p_234171_0_) -> {
      return p_234171_0_.getStateContainer().getValidStates().stream();
   }).filter((p_234173_0_) -> {
      return p_234173_0_.get(BedBlock.PART) == BedPart.HEAD;
   }).collect(ImmutableSet.toImmutableSet());
   private static final Map<BlockState, PointOfInterestType1> POIT_BY_BLOCKSTATE = Maps.newHashMap();
   public static final PointOfInterestType1 UNEMPLOYED = register("unemployed", ImmutableSet.of(), 1, ANY_NIRTRE_WORKSTATION, 1);
   public static final PointOfInterestType1 NIRTRE = register("nirtre", ImmutableSet.of(), 1, 1);
   public static final PointOfInterestType1 ARMORER = register("armorer", getAllStates(Blocks.BLAST_FURNACE), 1, 1);
   public static final PointOfInterestType1 BUTCHER = register("butcher", getAllStates(Blocks.SMOKER), 1, 1);
   public static final PointOfInterestType1 CARTOGRAPHER = register("cartographer", getAllStates(Blocks.CARTOGRAPHY_TABLE), 1, 1);
   public static final PointOfInterestType1 CLERIC = register("cleric", getAllStates(Blocks.BREWING_STAND), 1, 1);
   public static final PointOfInterestType1 FARMER = register("farmer", getAllStates(Blocks.COMPOSTER), 1, 1);
   public static final PointOfInterestType1 FISHERMAN = register("fisherman", getAllStates(Blocks.BARREL), 1, 1);
   public static final PointOfInterestType1 FLETCHER = register("fletcher", getAllStates(Blocks.FLETCHING_TABLE), 1, 1);
   public static final PointOfInterestType1 LEATHERWORKER = register("leatherworker", getAllStates(Blocks.CAULDRON), 1, 1);
   public static final PointOfInterestType1 LIBRARIAN = register("librarian", getAllStates(Blocks.LECTERN), 1, 1);
   public static final PointOfInterestType1 MASON = register("mason", getAllStates(Blocks.STONECUTTER), 1, 1);
   public static final PointOfInterestType1 NITWIT = register("nitwit", ImmutableSet.of(), 1, 1);
   public static final PointOfInterestType1 SHEPHERD = register("shepherd", getAllStates(Blocks.LOOM), 1, 1);
   public static final PointOfInterestType1 TOOLSMITH = register("toolsmith", getAllStates(Blocks.SMITHING_TABLE), 1, 1);
   public static final PointOfInterestType1 WEAPONSMITH = register("weaponsmith", getAllStates(Blocks.GRINDSTONE), 1, 1);
   public static final PointOfInterestType1 HOME = register("home", BED_HEADS, 1, 1);
   public static final PointOfInterestType1 MEETING = register("meeting", getAllStates(Blocks.BELL), 32, 6);
   public static final PointOfInterestType1 BEEHIVE = register("beehive", getAllStates(Blocks.BEEHIVE), 0, 1);
   public static final PointOfInterestType1 BEE_NEST = register("bee_nest", getAllStates(Blocks.BEE_NEST), 0, 1);
   public static final PointOfInterestType1 NETHER_PORTAL = register("nether_portal", getAllStates(Blocks.NETHER_PORTAL), 0, 1);
   public static final PointOfInterestType1 LODESTONE = register("lodestone", getAllStates(Blocks.LODESTONE), 0, 1);
   protected static final Set<BlockState> BLOCKS_OF_INTEREST = new ObjectOpenHashSet<>(POIT_BY_BLOCKSTATE.keySet());
   private final String name;
   private final Set<BlockState> blockStates;
   private final int maxFreeTickets;
   private final Predicate<PointOfInterestType1> predicate;
   private final int validRange;

   public static Set<BlockState> getAllStates(Block blockIn) {
      return ImmutableSet.copyOf(blockIn.getStateContainer().getValidStates());
   }

   public PointOfInterestType1(String nameIn, Set<BlockState> blockStatesIn, int maxFreeTicketsIn, Predicate<PointOfInterestType1> predicate, int validRange) {
      this.name = nameIn;
      this.blockStates = ImmutableSet.copyOf(blockStatesIn);
      this.maxFreeTickets = maxFreeTicketsIn;
      this.predicate = predicate;
      this.validRange = validRange;
   }

   public PointOfInterestType1(String nameIn, Set<BlockState> blockStatesIn, int maxFreeTicketsIn, int validRange) {
      this.name = nameIn;
      this.blockStates = ImmutableSet.copyOf(blockStatesIn);
      this.maxFreeTickets = maxFreeTicketsIn;
      this.predicate = (p_234170_1_) -> {
         return p_234170_1_ == this;
      };
      this.validRange = validRange;
   }

   public int getMaxFreeTickets() {
      return this.maxFreeTickets;
   }

   public Predicate<PointOfInterestType1> getPredicate() {
      return this.predicate;
   }

   public int getValidRange() {
      return this.validRange;
   }

   public String toString() {
      return this.name;
   }

   private static PointOfInterestType1 register(String key, Set<BlockState> blockStates, int maxFreeTickets, int validRange) {
      return registerBlockStates(Registry.register(Registry.POINT_OF_INTEREST_TYPE1, new ResourceLocation(key), new PointOfInterestType1(key, blockStates, maxFreeTickets, validRange)));
   }

   private static PointOfInterestType1 register(String key, Set<BlockState> blockStates, int maxFreeTickets, Predicate<PointOfInterestType1> predicate, int validRange) {
      return registerBlockStates(Registry.register(Registry.POINT_OF_INTEREST_TYPE1, new ResourceLocation(key), new PointOfInterestType1(key, blockStates, maxFreeTickets, predicate, validRange)));
   }

   private static PointOfInterestType1 registerBlockStates(PointOfInterestType1 poit) {
      poit.blockStates.forEach((p_234169_1_) -> {
         PointOfInterestType1 pointofinteresttype = POIT_BY_BLOCKSTATE.put(p_234169_1_, poit);
         if (pointofinteresttype != null) {
            throw (IllegalStateException)Util.pauseDevMode(new IllegalStateException(String.format("%s is defined in too many tags", p_234169_1_)));
         }
      });
      return poit;
   }

   public static Optional<PointOfInterestType1> forState(BlockState state) {
      return Optional.ofNullable(POIT_BY_BLOCKSTATE.get(state));
   }*/
}