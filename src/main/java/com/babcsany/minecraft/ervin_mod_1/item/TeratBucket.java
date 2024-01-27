package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class TeratBucket extends BucketItem {
    private Fluid containedBlock;

    public TeratBucket(Properties builder) {
        super(() -> Fluids.EMPTY, builder);
    }

    public TeratBucket(Supplier<? extends Fluid> supplier, Properties builder) {
        super(supplier, builder);
    }

    public TeratBucket(Fluid containedFluidIn, Properties builder) {
        super(() -> containedFluidIn, builder);
    }

    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslationTextComponent("tips.copper_bucket")).mergeStyle(TextFormatting.GREEN));
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ActionResult<ItemStack> itemStackActionResult = super.onItemRightClick(worldIn, playerIn, handIn);
        ItemStack newItemStack;
        Item itemBucket = itemStackActionResult.getResult().getItem();
        Item teratBucketIn = isBurnableItemInit.TERAT_BUCKET.get();
        Item waterTeratBucketIn = isBurnableItemInit.WATER_TERAT_BUCKET.get();
        Item lavaTeratBucketIn = isBurnableItemInit.LAVA_TERAT_BUCKET.get();
        if (itemBucket == isBurnableItemInit.TERAT_BUCKET.get()) {
            newItemStack = new ItemStack(teratBucketIn);
        } else {
            if (itemBucket == Items.LAVA_BUCKET) {
                itemBucket = lavaTeratBucketIn;
            } else if (itemBucket == Items.WATER_BUCKET) {
                itemBucket = waterTeratBucketIn;
            } else {
                itemBucket = teratBucketIn;
            }
            newItemStack = new ItemStack(itemBucket);
        }
        itemStackActionResult = new ActionResult<>(ActionResultType.CONSUME, newItemStack);

        return itemStackActionResult;
    }

    private Item fixBucketItem(Item bucketIn) {
        Item teratBucketIn = isBurnableItemInit.TERAT_BUCKET.get();
        Item waterTeratBucketIn = isBurnableItemInit.WATER_TERAT_BUCKET.get();
        Item lavaTeratBucketIn = isBurnableItemInit.LAVA_TERAT_BUCKET.get();
        if (bucketIn == teratBucketIn) {
            Item item = teratBucketIn;
            if (this.containedBlock == Fluids.LAVA) {
                item = lavaTeratBucketIn;
            } else if (this.containedBlock == Fluids.WATER) {
                item = waterTeratBucketIn;
            }
            return item;
        } else if (bucketIn == waterTeratBucketIn) {
            return teratBucketIn;
        } else if (bucketIn == lavaTeratBucketIn) {
            return teratBucketIn;
        } else {
            return teratBucketIn;
        }
    }

    protected ItemStack emptyBucket(ItemStack p_203790_1_, PlayerEntity p_203790_2_) {
        return !p_203790_2_.abilities.isCreativeMode ? new ItemStack(isBurnableItemInit.TERAT_BUCKET.get()) : p_203790_1_;
    }

    public void onLiquidPlaced(World p_203792_1_, ItemStack p_203792_2_, BlockPos p_203792_3_) {
    }

    public boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockRayTraceResult result) {
        return super.tryPlaceContainedLiquid(player, world, pos, result);
    }
}
