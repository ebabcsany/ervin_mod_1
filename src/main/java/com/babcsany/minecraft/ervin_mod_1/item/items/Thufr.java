package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.babcsany.minecraft.ervin_mod_1.init.init.MaterialInit;
import com.babcsany.minecraft.ervin_mod_1.item.IItemTier_;
import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier4;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.ToolItem;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.IExtensibleEnum;
import net.minecraftforge.common.ToolType;

import java.util.Set;

public class Thufr extends ToolItem {
   ItemEntity itemEntity;
   private static final Set<Material> field_234662_c_ = Sets.newHashSet(MaterialInit.MATERIALS);
   private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.PISTON_HEAD);

   public Thufr(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
      super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(ToolType.PICKAXE, tier.getHarvestLevel()));
   }

   public int item() {
      return itemEntity.lifespan + 999994000;
   }

   /**
    * Check whether this Item can harvest the given Block
    */
   public boolean canHarvestBlock(BlockState blockIn) {
      int i = this.getTier().getHarvestLevel();
      if (blockIn.getHarvestTool() == ToolType.PICKAXE) {
         return i >= blockIn.getHarvestLevel();
      }
      Material material = blockIn.getMaterial();
      return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      Material material = state.getMaterial();
      return field_234662_c_.contains(material) ? this.efficiency : super.getDestroySpeed(stack, state);
   }

   @Override
   public Rarity getRarity(ItemStack stack) {
      return Rarity.create("firn", TextFormatting.BOLD);
   }

   public enum ModRarity implements IExtensibleEnum {
      TEST(TextFormatting.BOLD);

      public final TextFormatting text;

      ModRarity(TextFormatting format) {
         this.text = format;
      }

      public static ModRarity create(String name, TextFormatting format) {
         throw new IllegalStateException("Enum not extended");
      }
   }
}