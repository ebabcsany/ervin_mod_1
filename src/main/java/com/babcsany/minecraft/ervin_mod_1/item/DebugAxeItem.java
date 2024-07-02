package com.babcsany.minecraft.ervin_mod_1.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DebugAxeItem extends ToolItem {
   private static final Set<Material> field_234662_c_ = Sets.newHashSet(Material.WOOD, Material.NETHER_WOOD, Material.PLANTS, Material.TALL_PLANTS, Material.BAMBOO, Material.GOURD);
   public static final Set<Block> field_150917_d_ = Sets.newHashSet(Blocks.LADDER, Blocks.SCAFFOLDING, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON);
   protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();

   public DebugAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties properties) {
      super(attackDamageIn, attackSpeedIn, tier, field_150917_d_, properties.addToolType(net.minecraftforge.common.ToolType.AXE, tier.getHarvestLevel()));
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      Material material = state.getMaterial();
      return field_234662_c_.contains(material) ? this.efficiency : super.getDestroySpeed(stack, state);
   }

   /**
    * Returns true if this item has an enchantment glint. By default, this returns <code>stack.isItemEnchanted()</code>,
    * but other items can override it (for instance, written books always return true).
    *  
    * Note that if you override this method, you generally want to also call the super version (on {@link Item}) to get
    * the glint for enchanted items. Of course, that is unnecessary if the overwritten version always returns true.
    */
   public boolean hasEffect(ItemStack stack) {
      return true;
   }

   public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      if (!worldIn.isRemote) {
         this.handleClick(player, state, worldIn, pos, false, player.getHeldItem(Hand.MAIN_HAND));
      }

      return false;
   }

   /**
    * Called when this item is used when targetting a Block
    */
   public ActionResultType onItemUse(ItemUseContext context) {
      PlayerEntity playerentity = context.getPlayer();
      World world = context.getWorld();
      if (!world.isRemote && playerentity != null) {
         BlockPos blockpos = context.getPos();
         this.handleClick(playerentity, world.getBlockState(blockpos), world, blockpos, true, context.getItem());
      }
      BlockPos blockpos = context.getPos();
      BlockState blockstate = world.getBlockState(blockpos);
      Block block = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
      if (block != null) {
         world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
         if (!world.isRemote) {
            world.setBlockState(blockpos, block.getDefaultState().with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
            if (playerentity != null) {
               context.getItem().damageItem(1, playerentity, (p_220040_1_) -> {
                  p_220040_1_.sendBreakAnimation(context.getHand());
               });
            }
         }

         return ActionResultType.func_233537_a_(world.isRemote);
      } else {
         return ActionResultType.PASS;
      }
   }

   private void handleClick(PlayerEntity player, BlockState state, IWorld worldIn, BlockPos pos, boolean rightClick, ItemStack stack) {
      Block block = state.getBlock();
      StateContainer<Block, BlockState> stateContainer = block.getStateContainer();
      Collection<Property<?>> collection = stateContainer.getProperties();
      String s = Registry.BLOCK.getKey(block).toString();
      if (collection.isEmpty()) {
         sendMessage(player, new TranslationTextComponent(this.getTranslationKey() + " Empty", s));
      } else {
         CompoundNBT compoundnbt = stack.getOrCreateChildTag("DebugProperty");
         String s1 = compoundnbt.getString(s);
         Property<?> property = stateContainer.getProperty(s1);
         if (rightClick) {
            if (property == null) {
               property = collection.iterator().next();
            }

            BlockState blockstate = cycleProperty(state, property, player.isSecondaryUseActive());
            worldIn.setBlockState(pos, blockstate, 18);
            sendMessage(player, new TranslationTextComponent(this.getTranslationKey() + " Update", property.getName(), func_195957_a(blockstate, property)));
         } else {
            property = getAdjacentValue(collection, property, player.isSecondaryUseActive());
            String s2 = property.getName();
            compoundnbt.putString(s, s2);
            sendMessage(player, new TranslationTextComponent(this.getTranslationKey() + " Select", s2, func_195957_a(state, property)));
         }

      }
   }

   private static <T extends Comparable<T>> BlockState cycleProperty(BlockState state, Property<T> propertyIn, boolean backwards) {
      return state.with(propertyIn, getAdjacentValue(propertyIn.getAllowedValues(), state.get(propertyIn), backwards));
   }

   private static <T> T getAdjacentValue(Iterable<T> allowedValues, @Nullable T currentValue, boolean backwards) {
      return backwards ? Util.getElementBefore(allowedValues, currentValue) : Util.getElementAfter(allowedValues, currentValue);
   }

   private static void sendMessage(PlayerEntity player, ITextComponent text) {
      ((ServerPlayerEntity)player).func_241151_a_(text, ChatType.GAME_INFO, Util.DUMMY_UUID);
   }

   private static <T extends Comparable<T>> String func_195957_a(BlockState state, Property<T> propertyIn) {
      return propertyIn.getName(state.get(propertyIn));
   }
}