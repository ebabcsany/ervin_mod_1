package com.babcsany.minecraft.ervin_mod_1.item.item.icsvre;

import com.babcsany.minecraft.ervin_mod_1.block.ModBlock;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;

import javax.annotation.Nullable;

public class BlockIcsvreUseContext extends IcsvreUseContext {
   private final BlockPos offsetPos;
   private ModBlock modBlock;
   private Block block;
   private static BlockState blockState;
   private static BlockIcsvreUseContext blockIcsvreUseContext;
   protected boolean replaceClicked = true;

   public native BlockState getSelf();

   public BlockIcsvreUseContext(PlayerEntity player, Hand hand, IcsvreStack stack, BlockRayTraceResult blockRayTraceResult) {
      this(player.world, player, hand, stack, blockRayTraceResult);
   }

   public BlockIcsvreUseContext(IcsvreUseContext context) {
      this(context.getWorld(), context.getPlayer(), context.getHand(), context.getIcsvre(), context.rayTraceResult);
   }

   protected BlockIcsvreUseContext(World worldIn, @Nullable PlayerEntity playerIn, Hand handIn, IcsvreStack stackIn, BlockRayTraceResult rayTraceResultIn) {
      super(worldIn, playerIn, handIn, stackIn, rayTraceResultIn);
      this.offsetPos = rayTraceResultIn.getPos().offset(rayTraceResultIn.getFace());
      this.replaceClicked = this.getBlockState(rayTraceResultIn.getPos(), this).isReplaceable(this);
   }

   public void blockPos(World worldIn, BlockRayTraceResult rayTraceResultIn) {
      this.getBlockState(rayTraceResultIn.getPos(), this).isReplaceable(this);
   }

   public boolean isReplaceable(BlockIcsvreUseContext useContext) {
      return this.isReplaceable(this.getSelf(), useContext);
   }

   @Deprecated
   public boolean isReplaceable(BlockState state, BlockIcsvreUseContext useContext) {
      return state.getMaterial().isReplaceable() && (useContext.getIcsvre().isEmpty() || useContext.getIcsvre().getItem() != this.getIcsvre().getItem());
   }

   public static BlockIcsvreUseContext blockState(BlockState blockState) {
      return blockIcsvreUseContext;
   }

   public static boolean isYOutOfBounds(int y) {
      return y < 0 || y >= 1024;
   }

   public static boolean isOutsideBuildHeight(BlockPos pos) {
      return isYOutOfBounds(pos.getY());
   }

   public BlockIcsvreUseContext getBlockState(BlockPos pos, BlockIcsvreUseContext blockIcsvreUseContext) {
      if (isOutsideBuildHeight(pos)) {
         return blockState(Blocks.VOID_AIR.getDefaultState());
      } else {
         Chunk chunk = this.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
         return blockState(chunk.getBlockState(pos));
      }
   }

   public Chunk getChunk(int chunkX, int chunkZ) {
      return (Chunk) this.getChunk(chunkX, chunkZ, ChunkStatus.FULL);
   }

   public IChunk getChunk(int chunkX, int chunkZ, ChunkStatus requiredStatus) {
      return this.getChunk(chunkX, chunkZ, requiredStatus, true);
   }

   @Nullable
   native IChunk getChunk(int x, int z, ChunkStatus requiredStatus, boolean nonnull);

   public static BlockIcsvreUseContext func_221536_a(BlockIcsvreUseContext context, BlockPos pos, Direction directionIn) {
      return new BlockIcsvreUseContext(context.getWorld(), context.getPlayer(), context.getHand(), context.getIcsvre(), new BlockRayTraceResult(new Vector3d((double)pos.getX() + 0.5D + (double)directionIn.getXOffset() * 0.5D, (double)pos.getY() + 0.5D + (double)directionIn.getYOffset() * 0.5D, (double)pos.getZ() + 0.5D + (double)directionIn.getZOffset() * 0.5D), directionIn, pos, false));
   }

   public BlockPos getPos() {
      return this.replaceClicked ? super.getPos() : this.offsetPos;
   }

   public boolean canPlace() {
      return this.replaceClicked || this.getBlockState(this.getPos(), this).isReplaceable(this);
   }

   public boolean replacingClickedOnBlock() {
      return this.replaceClicked;
   }

   public Direction getNearestLookingDirection() {
      return Direction.getFacingDirections(this.player)[0];
   }

   public Direction[] getNearestLookingDirections() {
      Direction[] adirection = Direction.getFacingDirections(this.player);
      if (this.replaceClicked) {
         return adirection;
      } else {
         Direction direction = this.getFace();

         int i;
         for(i = 0; i < adirection.length && adirection[i] != direction.getOpposite(); ++i) {
         }

         if (i > 0) {
            System.arraycopy(adirection, 0, adirection, 1, i);
            adirection[0] = direction.getOpposite();
         }

         return adirection;
      }
   }
}
