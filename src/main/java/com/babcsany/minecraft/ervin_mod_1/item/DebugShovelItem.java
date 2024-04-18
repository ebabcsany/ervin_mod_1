package com.babcsany.minecraft.ervin_mod_1.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
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

public class DebugShovelItem extends ToolItem {
   private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.SOUL_SOIL);
   /** Map used to lookup shovel right click interactions */
   protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));

   public DebugShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {
      super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(net.minecraftforge.common.ToolType.SHOVEL, tier.getHarvestLevel()));
   }

   /**
    * Check whether this Item can harvest the given Block
    */
   public boolean canHarvestBlock(BlockState blockIn) {
      return blockIn.matchesBlock(Blocks.SNOW) || blockIn.matchesBlock(Blocks.SNOW_BLOCK);
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
      BlockPos blockpos = context.getPos();
      World world = context.getWorld();
      BlockState blockstate = world.getBlockState(blockpos);
      if (context.getFace() == Direction.DOWN) {
         return ActionResultType.PASS;
      } else {
         BlockState blockstate1 = SHOVEL_LOOKUP.get(blockstate.getBlock());
         BlockState blockstate2 = null;
         if (blockstate1 != null && world.isAirBlock(blockpos.up())) {
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            blockstate2 = blockstate1;
         } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
            if (!world.isRemote()) {
               world.playEvent(null, 1009, blockpos, 0);
            }

            CampfireBlock.extinguish(world, blockpos, blockstate);
            blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.valueOf(false));
         }

         if (blockstate2 != null) {
            if (!world.isRemote) {
               world.setBlockState(blockpos, blockstate2, 11);
               if (playerentity != null) {
                  context.getItem().damageItem(1, playerentity, (p_220041_1_) -> {
                     p_220041_1_.sendBreakAnimation(context.getHand());
                  });
               }
            }

            return ActionResultType.func_233537_a_(world.isRemote);
         } else {
            return ActionResultType.PASS;
         }
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