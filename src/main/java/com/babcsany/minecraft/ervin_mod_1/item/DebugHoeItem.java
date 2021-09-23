package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.item.ModItemUseContext;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

public class DebugHoeItem extends ToolItem {
   private static final Set<Block> field_234683_c_ = ImmutableSet.of(Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.HAY_BLOCK, Blocks.DRIED_KELP_BLOCK, Blocks.TARGET, Blocks.SHROOMLIGHT, Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES);
   protected static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT, Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));

   public DebugHoeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
      super(attackDamageIn, attackSpeedIn, tier, field_234683_c_, builder.addToolType(net.minecraftforge.common.ToolType.HOE, tier.getHarvestLevel()));
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
   public ActionResultType onItemUse(ModItemUseContext context) {
      PlayerEntity playerentity = context.getPlayer();
      World world = context.getWorld();
      BlockPos blockpos = context.getPos();
      int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
      if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
      if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up())) {
         BlockState blockstate = HOE_LOOKUP.get(world.getBlockState(blockpos).getBlock());
         if (blockstate != null) {
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote) {
               world.setBlockState(blockpos, blockstate, 11);
               if (playerentity != null) {
                  context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
                     p_220043_1_.sendBreakAnimation(context.getHand());
                  });
               }
            }

            return ActionResultType.func_233537_a_(world.isRemote);
         }
      }
      if (!world.isRemote && playerentity != null) {
         this.handleClick(playerentity, world.getBlockState(blockpos), world, blockpos, true, context.getItem());
      }

      return ActionResultType.func_233537_a_(world.isRemote);
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