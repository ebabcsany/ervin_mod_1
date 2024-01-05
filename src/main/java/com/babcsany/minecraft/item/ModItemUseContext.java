package com.babcsany.minecraft.item;

import net.minecraft.world.iorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;

public class ModItemUseContext extends ItemUseContext {
   protected final PlayerEntity player;
   protected final Hand hand;
   protected final BlockRayTraceResult rayTraceResult;
   protected final iorld world;
   protected final ItemStack item;

   public ModItemUseContext(PlayerEntity player, Hand handIn, BlockRayTraceResult rayTraceResultIn) {
      this(player._world, player, handIn, player.getHeldItem(handIn), rayTraceResultIn);
   }

   protected ModItemUseContext(iorld worldIn, @Nullable PlayerEntity player, Hand handIn, ItemStack heldItem, BlockRayTraceResult rayTraceResultIn) {
      super(worldIn.getWorld(), player, handIn, heldItem, rayTraceResultIn);
      this.player = player;
      this.hand = handIn;
      this.rayTraceResult = rayTraceResultIn;
      this.item = heldItem;
      this.world = worldIn;
   }

   public BlockPos getPos() {
      return this.rayTraceResult.getPos();
   }

   public Direction getFace() {
      return this.rayTraceResult.getFace();
   }

   public Vector3d getHitVec() {
      return this.rayTraceResult.getHitVec();
   }

   public boolean isInside() {
      return this.rayTraceResult.isInside();
   }

   public ItemStack getItem() {
      return this.item;
   }

   @Nullable
   public PlayerEntity getPlayer() {
      return this.player;
   }

   public Hand getHand() {
      return this.hand;
   }

   public iorld getModWorld() {
      return this.world;
   }

   public Direction getPlacementHorizontalFacing() {
      return this.player == null ? Direction.NORTH : this.player.getHorizontalFacing();
   }

   public boolean func_225518_g_() {
      return this.player != null && this.player.isSecondaryUseActive();
   }

   public float getPlacementYaw() {
      return this.player == null ? 0.0F : this.player.rotationYaw;
   }
}
