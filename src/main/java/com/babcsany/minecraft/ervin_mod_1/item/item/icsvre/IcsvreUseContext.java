package com.babcsany.minecraft.ervin_mod_1.item.item.icsvre;

import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class IcsvreUseContext {
   public final PlayerEntity player;
   public final Hand hand;
   public final BlockRayTraceResult rayTraceResult;
   public final World world;
   public static Living living;
   public final IcsvreStack icsvre;
   public static ItemStack item;
   public static IcsvreUseContext icsvreUseContext;

   public IcsvreUseContext(PlayerEntity player, Hand handIn, BlockRayTraceResult rayTraceResultIn) {
      this(player.world, player, handIn, living.getHeldIcsvre(handIn), rayTraceResultIn);
   }

   protected IcsvreUseContext(World worldIn, @Nullable PlayerEntity player, Hand handIn, IcsvreStack heldItem, BlockRayTraceResult rayTraceResultIn) {
      this.player = player;
      this.hand = handIn;
      this.rayTraceResult = rayTraceResultIn;
      this.icsvre = heldItem;
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

   public IcsvreStack getIcsvre() {
      return this.icsvre;
   }

   @Nullable
   public PlayerEntity getPlayer() {
      return this.player;
   }

   public Hand getHand() {
      return this.hand;
   }

   public World getWorld() {
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
