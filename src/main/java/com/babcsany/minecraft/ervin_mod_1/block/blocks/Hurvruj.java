package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.state.ModBlockStateProperties;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class Hurvruj extends Block {
   public static final IntegerProperty CHARGES = ModBlockStateProperties.CHARGES_0_16;

   public Hurvruj(Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(CHARGES, 0));
   }

   @Override
   public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      ItemStack itemstack = player.getHeldItem(handIn);
      if (handIn == Hand.MAIN_HAND && !isValidFuel(itemstack) && isValidFuel(player.getHeldItem(Hand.OFF_HAND))) {
         return ActionResultType.PASS;
      } else if (isValidFuel(itemstack) && func_235568_h_(state)) {
         chargeHurvruj(worldIn, pos, state);
         if (!player.abilities.isCreativeMode) {
            itemstack.shrink(1);
         }

         return ActionResultType.func_233537_a_(worldIn.isRemote);
      } else if (state.get(CHARGES) == 0) {
         return ActionResultType.PASS;
      } else if (!doesHurvrujWork(worldIn)) {
         if (!worldIn.isRemote) {
            this.func_235567_d_(worldIn, pos);
         }

         return ActionResultType.func_233537_a_(worldIn.isRemote);
      } else {
         if (!worldIn.isRemote) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)player;
            if (serverplayerentity.func_241141_L_() != worldIn.func_234923_W_() || !Objects.equals(serverplayerentity.func_241140_K_(), pos)) {
               serverplayerentity.func_241153_a_(worldIn.func_234923_W_(), pos, false, true);
               worldIn.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_SET_SPAWN, SoundCategory.BLOCKS, 1.0F, 1.0F);
               return ActionResultType.SUCCESS;
            }
         }

         return ActionResultType.CONSUME;
      }
   }

   private static boolean isValidFuel(ItemStack stack) {
      return stack.getItem() == isBurnableBlockItemInit.TERAT_BLOCK.get();
   }

   private static boolean func_235568_h_(BlockState state) {
      return state.get(CHARGES) < 16;
   }

   private static boolean func_235566_a_(BlockPos pos, World world) {
      FluidState fluidstate = world.getFluidState(pos);
      if (!fluidstate.isTagged(FluidTags.WATER)) {
         return false;
      } else if (fluidstate.isSource()) {
         return true;
      } else {
         float fluidstateLevel = (float)fluidstate.getLevel();
         if (fluidstateLevel < 2.0F) {
            return false;
         } else {
            FluidState fluidstate1 = world.getFluidState(pos.down());
            return !fluidstate1.isTagged(FluidTags.WATER);
         }
      }
   }

   private void func_235567_d_(World world, final BlockPos pos) {
      world.removeBlock(pos, false);
      boolean flag = Direction.Plane.HORIZONTAL.func_239636_a_().map(pos::offset).anyMatch((p_235563_1_) -> func_235566_a_(p_235563_1_, world));
      final boolean flag1 = flag || world.getFluidState(pos.up()).isTagged(FluidTags.WATER);
      IExplosionContext iexplosioncontext = new IExplosionContext() {
         public Optional<Float> func_230312_a_(Explosion p_230312_1_, IBlockReader p_230312_2_, BlockPos p_230312_3_, BlockState p_230312_4_, FluidState p_230312_5_) {
            return p_230312_3_.equals(pos) && flag1 ? Optional.of(Blocks.WATER.getExplosionResistance()) : DefaultExplosionContext.INSTANCE.func_230312_a_(p_230312_1_, p_230312_2_, p_230312_3_, p_230312_4_, p_230312_5_);
         }

         public boolean func_230311_a_(Explosion p_230311_1_, IBlockReader p_230311_2_, BlockPos p_230311_3_, BlockState p_230311_4_, float p_230311_5_) {
            return DefaultExplosionContext.INSTANCE.func_230311_a_(p_230311_1_, p_230311_2_, p_230311_3_, p_230311_4_, p_230311_5_);
         }
      };
      world.createExplosion(null, DamageSource.func_233546_a_(), iexplosioncontext, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, Explosion.Mode.DESTROY);
   }

   public static boolean doesHurvrujWork(World world) {
      return world.func_230315_m_().func_241511_k_();
   }

   public static void chargeHurvruj(World world, BlockPos pos, BlockState state) {
      world.setBlockState(pos, state.with(CHARGES, state.get(CHARGES) + 1), 15);
      world.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 1.0F, 1.0F);
   }

   /**
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
    * this method is unrelated to {@link #randomTick} and {@link #animateTick(BlockState, World, BlockPos, Random)}, and will always be called regardless
    * of whether the block can receive random update ticks
    */
   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      if (stateIn.get(CHARGES) != 0) {
         if (rand.nextInt(100) == 0) {
            worldIn.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
         }

         double d0 = (double)pos.getX() + 0.5D + (0.5D - rand.nextDouble());
         double d1 = (double)pos.getY() + 1.0D;
         double d2 = (double)pos.getZ() + 0.5D + (0.5D - rand.nextDouble());
         double d3 = (double)rand.nextFloat() * 0.04D;
         worldIn.addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, 0.0D, d3, 0.0D);
      }
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(CHARGES);
   }

   /**
    * @deprecated call via {@link BlockState#hasComparatorInputOverride()} whenever possible. Implementing/overriding
    * is fine.
    */
   @Override
   public boolean hasComparatorInputOverride(BlockState state) {
      return true;
   }

   public static int func_235565_a_(BlockState state, int charges) {
      return MathHelper.floor((float)(state.get(CHARGES)) / 16.0F * (float)charges);
   }

   /**
    * @deprecated call via {@link BlockState#getComparatorInputOverride(World,BlockPos)} whenever possible.
    * Implementing/overriding is fine.
    */
   @Override
   public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
      return func_235565_a_(blockState, 15);
   }

   public static Optional<Vector3d> getSpawn(EntityType<?> entity, IWorldReader reader, BlockPos pos) {
      for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
         Optional<Vector3d> optional = BedBlock.getWakeUpDisplacement(entity, reader, blockpos);
         if (optional.isPresent()) {
            return optional;
         }
      }

      return Optional.empty();
   }

   @Override
   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
      return false;
   }
}