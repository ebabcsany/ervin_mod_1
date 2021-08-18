package com.babcsany.minecraft.item.icsvre;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

import com.babcsany.minecraft.ervin_mod_1.block.ModBlock;
import com.babcsany.minecraft.ervin_mod_1.entity.trigger.CriteriaTriggers1;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.BlockIcsvreUseContext;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.IcsvreUseContext;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockIcsvre extends Icsvre {
   @Deprecated
   private final Block block;
   private static BlockIcsvre blockIcsvre;
   private ModBlock modBlock;

   public BlockIcsvre(Block blockIn, Properties builder, Item.Properties builder1) {
      super(builder, builder1);
      this.block = blockIn;
   }

   /**
    * Called when this item is used when targetting a Block
    */
   public ActionResultType onItemUse(IcsvreUseContext context) {
      ActionResultType actionresulttype = tryPlace(new BlockIcsvreUseContext(context));
      return !actionresulttype.isSuccessOrConsume() && this.isFood() ? this.onIcsvreRightClick(context.world, context.player, context.hand).getType() : actionresulttype;
   }

   public static BlockIcsvre block(Block block) {
      return blockIcsvre;
   }

   public ActionResultType tryPlace(BlockIcsvreUseContext context) {
      if (!context.canPlace()) {
         return ActionResultType.FAIL;
      } else {
         BlockIcsvreUseContext blockIcsvreUseContext = this.getBlockIcsvreUseContext(context);
         if (blockIcsvreUseContext == null) {
            return ActionResultType.FAIL;
         } else {
            BlockState blockstate = this.getStateForPlacement(blockIcsvreUseContext);
            if (blockstate == null) {
               return ActionResultType.FAIL;
            } else if (!this.placeBlock(blockIcsvreUseContext, blockstate)) {
               return ActionResultType.FAIL;
            } else {
               BlockPos blockpos = blockIcsvreUseContext.getPos();
               World world = blockIcsvreUseContext.getWorld();
               PlayerEntity playerentity = blockIcsvreUseContext.getPlayer();
               IcsvreStack icsvreStack = blockIcsvreUseContext.getIcsvre();
               BlockState blockstate1 = world.getBlockState(blockpos);
               Block block = blockstate1.getBlock();
               if (block == blockstate.getBlock()) {
                  blockstate1 = this.func_219985_a(blockpos, world, icsvreStack, blockstate1);
                  this.onBlockPlaced(blockpos, world, playerentity, icsvreStack, blockstate1);
                  modBlock.onBlockPlacedBy(world, blockpos, blockstate1, playerentity, icsvreStack);
                  if (playerentity instanceof ServerPlayerEntity) {
                     CriteriaTriggers1.PLACED_ICSVRE_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos, icsvreStack);
                  }
               }

               SoundType soundtype = blockstate1.getSoundType(world, blockpos, context.getPlayer());
               world.playSound(playerentity, blockpos, this.getPlaceSound(blockstate1, world, blockpos, context.getPlayer()), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
               if (playerentity == null || !playerentity.abilities.isCreativeMode) {
                  icsvreStack.shrink(1);
               }

               return ActionResultType.func_233537_a_(world.isRemote);
            }
         }
      }
   }

   @Deprecated //Forge: Use more sensitive version {@link BlockItem#getPlaceSound(BlockState, IBlockReader, BlockPos, Entity) }
   protected SoundEvent getPlaceSound(BlockState state) {
      return state.getSoundType().getPlaceSound();
   }

   //Forge: Sensitive version of BlockItem#getPlaceSound
   protected SoundEvent getPlaceSound(BlockState state, World world, BlockPos pos, PlayerEntity entity) {
      return state.getSoundType(world, pos, entity).getPlaceSound();
   }

   @Nullable
   public BlockIcsvreUseContext getBlockIcsvreUseContext(BlockIcsvreUseContext context) {
      return context;
   }

   protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, IcsvreStack stack, BlockState state) {
      return setTileEntityNBT(worldIn, player, pos, stack);
   }

   @Nullable
   protected BlockState getStateForPlacement(BlockIcsvreUseContext context) {
      BlockState blockstate = this.getModBlock().getStateForPlacement(context);
      return blockstate != null && this.canPlace(context, blockstate) ? blockstate : null;
   }

   private BlockState func_219985_a(BlockPos p_219985_1_, World p_219985_2_, IcsvreStack p_219985_3_, BlockState p_219985_4_) {
      BlockState blockstate = p_219985_4_;
      CompoundNBT compoundnbt = p_219985_3_.getTag();
      if (compoundnbt != null) {
         CompoundNBT compoundnbt1 = compoundnbt.getCompound("BlockStateTag");
         StateContainer<Block, BlockState> statecontainer = p_219985_4_.getBlock().getStateContainer();

         for(String s : compoundnbt1.keySet()) {
            Property<?> property = statecontainer.getProperty(s);
            if (property != null) {
               String s1 = compoundnbt1.get(s).getString();
               blockstate = func_219988_a(blockstate, property, s1);
            }
         }
      }

      if (blockstate != p_219985_4_) {
         p_219985_2_.setBlockState(p_219985_1_, blockstate, 2);
      }

      return blockstate;
   }

   private static <T extends Comparable<T>> BlockState func_219988_a(BlockState p_219988_0_, Property<T> p_219988_1_, String p_219988_2_) {
      return p_219988_1_.parseValue(p_219988_2_).map((p_219986_2_) -> {
         return p_219988_0_.with(p_219988_1_, p_219986_2_);
      }).orElse(p_219988_0_);
   }

   protected boolean canPlace(BlockIcsvreUseContext p_195944_1_, BlockState p_195944_2_) {
      PlayerEntity playerentity = p_195944_1_.getPlayer();
      ISelectionContext iselectioncontext = playerentity == null ? ISelectionContext.dummy() : ISelectionContext.forEntity(playerentity);
      return (!this.checkPosition() || p_195944_2_.isValidPosition(p_195944_1_.getWorld(), p_195944_1_.getPos())) && p_195944_1_.getWorld().func_226663_a_(p_195944_2_, p_195944_1_.getPos(), iselectioncontext);
   }

   protected boolean checkPosition() {
      return true;
   }

   protected boolean placeBlock(BlockIcsvreUseContext context, BlockState state) {
      return context.getWorld().setBlockState(context.getPos(), state, 11);
   }

   public static boolean setTileEntityNBT(World worldIn, @Nullable PlayerEntity player, BlockPos pos, IcsvreStack stackIn) {
      MinecraftServer minecraftserver = worldIn.getServer();
      if (minecraftserver == null) {
         return false;
      } else {
         CompoundNBT compoundnbt = stackIn.getChildTag("BlockEntityTag");
         if (compoundnbt != null) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity != null) {
               if (!worldIn.isRemote && tileentity.onlyOpsCanSetNbt() && (player == null || !player.canUseCommandBlock())) {
                  return false;
               }

               CompoundNBT compoundnbt1 = tileentity.write(new CompoundNBT());
               CompoundNBT compoundnbt2 = compoundnbt1.copy();
               compoundnbt1.merge(compoundnbt);
               compoundnbt1.putInt("x", pos.getX());
               compoundnbt1.putInt("y", pos.getY());
               compoundnbt1.putInt("z", pos.getZ());
               if (!compoundnbt1.equals(compoundnbt2)) {
                  tileentity.read(worldIn.getBlockState(pos), compoundnbt1);
                  tileentity.markDirty();
                  return true;
               }
            }
         }

         return false;
      }
   }

   /**
    * Returns the unlocalized name of this item.
    */
   public String getTranslationKey() {
      return this.getBlock().getTranslationKey();
   }

   /**
    * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
    */
   public void fillIcsvreGroup(ItemGroup group, NonNullList<IcsvreStack> items) {
      if (this.isInGroup(group)) {
         this.getModBlock().fillIcsvreGroup(group, items);
      }

   }

   /**
    * allows items to add custom lines of information to the mouseover description
    */
   @OnlyIn(Dist.CLIENT)
   public void addInformation(IcsvreStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
      super.addInformation(stack, worldIn, tooltip, flagIn);
      this.getModBlock().addInformation(stack, worldIn, tooltip, flagIn);
   }

   public Block getBlock() {
      return this.getBlockRaw() == null ? null : this.getBlockRaw().delegate.get();
   }

   public ModBlock getModBlock() {
      return this.getModBlockRaw() == null ? null : block(this.getModBlockRaw().delegate.get()).modBlock;
   }

   private Block getBlockRaw() {
      return this.block;
   }

   private ModBlock getModBlockRaw() {
      return this.modBlock;
   }

   public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
      blockToItemMap.put(this.getBlock(), itemIn);
   }

   public void addToBlockToIcsvreMap(Map<Block, Icsvre> blockToItemMap, Icsvre itemIn) {
      blockToItemMap.put(this.getBlock(), itemIn);
   }

   public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
      blockToItemMap.remove(this.getBlock());
   }
}
