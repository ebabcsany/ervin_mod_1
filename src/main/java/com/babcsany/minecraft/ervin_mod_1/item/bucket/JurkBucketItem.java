package com.babcsany.minecraft.ervin_mod_1.item.bucket;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.fluid.fluids.ModFlowingFluid;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class JurkBucketItem extends Item {
   private final Fluid containedBlock;

   public JurkBucketItem(Fluid containedFluidIn, Properties builder) {
      super(builder);
      this.containedBlock = containedFluidIn;
      this.fluidSupplier = containedFluidIn.delegate;
   }

   /**
    * @param supplier A fluid supplier such as {@link net.minecraftforge.fml.RegistryObject<Fluid>}
    */
   public JurkBucketItem(java.util.function.Supplier<? extends Fluid> supplier, Properties builder) {
      super(builder);
      this.containedBlock = null;
      this.fluidSupplier = supplier;
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, this.containedBlock == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
      ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
      if (ret != null) return ret;
      if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
         return ActionResult.resultPass(itemstack);
      } else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
         return ActionResult.resultPass(itemstack);
      } else {
         BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
         BlockPos blockpos = blockraytraceresult.getPos();
         Direction direction = blockraytraceresult.getFace();
         BlockPos blockpos1 = blockpos.offset(direction);
         if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos1, direction, itemstack)) {
            if (this.containedBlock == Fluids.EMPTY) {
               BlockState blockstate1 = worldIn.getBlockState(blockpos);
               if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
                  Fluid fluid = ((IBucketPickupHandler)blockstate1.getBlock()).pickupFluid(worldIn, blockpos, blockstate1);
                  if (fluid != Fluids.EMPTY) {
                     playerIn.addStat(Stats.ITEM_USED.get(this));

                     SoundEvent soundevent = this.containedBlock.getAttributes().getEmptySound();
                     if (soundevent == null) soundevent = fluid.isIn(FluidTags.LAVA) ? SoundEvents.ITEM_BUCKET_FILL_LAVA : SoundEvents.ITEM_BUCKET_FILL;
                     playerIn.playSound(soundevent, 1.0F, 1.0F);
                     ItemStack itemstack1 = DrinkHelper.func_241445_a_(itemstack, playerIn, new ItemStack(fluid.getFilledBucket()));
                     if (!worldIn.isRemote) {
                        CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)playerIn, new ItemStack(fluid.getFilledBucket()));
                     }

                     return ActionResult.func_233538_a_(itemstack1, worldIn.isRemote());
                  }
               }

               return ActionResult.resultFail(itemstack);
            } else {
               BlockState blockstate = worldIn.getBlockState(blockpos);
               BlockPos blockpos2 = canBlockContainFluid(worldIn, blockpos, blockstate) ? blockpos : blockpos1;
               if (this.tryPlaceContainedLiquid(playerIn, worldIn, blockpos2, blockraytraceresult)) {
                  this.onLiquidPlaced(worldIn, itemstack, blockpos2);
                  if (playerIn instanceof ServerPlayerEntity) {
                     CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, blockpos2, itemstack);
                  }

                  playerIn.addStat(Stats.ITEM_USED.get(this));
                  return ActionResult.func_233538_a_(this.emptyBucket(itemstack, playerIn), worldIn.isRemote());
               } else {
                  return ActionResult.resultFail(itemstack);
               }
            }
         } else {
            return ActionResult.resultFail(itemstack);
         }
      }
   }

   protected ItemStack emptyBucket(ItemStack stack, PlayerEntity player) {
      return !player.abilities.isCreativeMode ? new ItemStack(Items.BUCKET) : stack;
   }

   public void onLiquidPlaced(World worldIn, ItemStack p_203792_2_, BlockPos pos) {
   }

   public boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World worldIn, BlockPos posIn, @Nullable BlockRayTraceResult rayTrace) {
      if (!(this.containedBlock instanceof ModFlowingFluid)) {
         return false;
      } else {
         BlockState blockstate = worldIn.getBlockState(posIn);
         Block block = blockstate.getBlock();
         Material material = blockstate.getMaterial();
         boolean flag = blockstate.isReplaceable(this.containedBlock);
         boolean flag1 = blockstate.isAir() || flag || block instanceof ILiquidContainer && ((ILiquidContainer)block).canContainFluid(worldIn, posIn, blockstate, this.containedBlock);
         if (!flag1) {
            return rayTrace != null && this.tryPlaceContainedLiquid(player, worldIn, rayTrace.getPos().offset(rayTrace.getFace()), null);
         } else if (worldIn.func_230315_m_().func_236040_e_() && this.containedBlock.isIn(FluidTags.WATER)) {
            int i = posIn.getX();
            int j = posIn.getY();
            int k = posIn.getZ();
            worldIn.playSound(player, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

            for(int l = 0; l < 8; ++l) {
               worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
            }

            return true;
         } else if (block instanceof ILiquidContainer && ((ILiquidContainer)block).canContainFluid(worldIn,posIn,blockstate,containedBlock)) {
            ((ILiquidContainer)block).receiveFluid(worldIn, posIn, blockstate, ((ModFlowingFluid)this.containedBlock).getStillFluidState(false));
            this.playEmptySound(player, worldIn, posIn);
            return true;
         } else {
            if (!worldIn.isRemote && flag && !material.isLiquid()) {
               worldIn.destroyBlock(posIn, true);
            }

            if (!worldIn.setBlockState(posIn, this.containedBlock.getDefaultState().getBlockState(), 11) && !blockstate.getFluidState().isSource()) {
               return false;
            } else {
               this.playEmptySound(player, worldIn, posIn);
               return true;
            }
         }
      }
   }

   protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
      SoundEvent soundevent = this.containedBlock.getAttributes().getEmptySound();
      if(soundevent == null) soundevent = this.containedBlock.isIn(FluidTags.LAVA) ? SoundEvents.ITEM_BUCKET_EMPTY_LAVA : SoundEvents.ITEM_BUCKET_EMPTY;
      worldIn.playSound(player, pos, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
   }

   @Override
   public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.CompoundNBT nbt) {
      if (this.getClass() == JurkBucketItem.class)
         return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
      else
         return super.initCapabilities(stack, nbt);
   }

   private final java.util.function.Supplier<? extends Fluid> fluidSupplier;
   public Fluid getFluid() { return fluidSupplier.get(); }

   private boolean canBlockContainFluid(World worldIn, BlockPos posIn, BlockState blockstate)
   {
      return blockstate.getBlock() instanceof ILiquidContainer && ((ILiquidContainer)blockstate.getBlock()).canContainFluid(worldIn, posIn, blockstate, this.containedBlock);
   }

   /**
    * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
    * the Item before the action is complete.
    */
   public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
      if (!worldIn.isRemote) entityLiving.curePotionEffects(stack); // FORGE - move up so stack.shrink does not turn stack into air

      if (entityLiving instanceof ServerPlayerEntity) {
         ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entityLiving;
         CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
         serverplayerentity.addStat(Stats.ITEM_USED.get(this));
      }

      if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
         stack.shrink(1);
      }

      if (!worldIn.isRemote) {
         entityLiving.clearActivePotions();
      }

      return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 32;
   }

   /**
    * returns the action that specifies what animation to play when the items is being used
    */
   public UseAction getUseAction(ItemStack stack) {
      return UseAction.DRINK;
   }
}