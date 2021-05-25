package com.babcsany.minecraft.ervin_mod_1.util;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Ervin_mod_1.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	/*@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE) == null) {
			DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null,
					true);
		}
		Ervin_mod_1.LOGGER.info("Dimensions Registered!");
	}*/

    @SubscribeEvent
    public static void FillBucket(FillBucketEvent event) {
        if (event.getEmptyBucket().getItem() == isBurnableItemInit.TERAT_BUCKET.get() && Objects.requireNonNull(event.getTarget()).getType() == RayTraceResult.Type.BLOCK) {
            BlockRayTraceResult rtResult = (BlockRayTraceResult)event.getTarget();
            BlockPos blockpos = rtResult.getPos();
            Direction direction = rtResult.getFace();
            BlockPos blockpos1 = blockpos.offset(direction);
            if (event.getWorld().isBlockModifiable(event.getPlayer(), blockpos) && event.getPlayer().canPlayerEdit(blockpos1, direction, event.getEmptyBucket())) {
                BlockState blockstate1 = event.getWorld().getBlockState(blockpos);
                if (blockstate1.getBlock() instanceof FlowingFluidBlock) {
                    Fluid fluid = ((FlowingFluidBlock)blockstate1.getBlock()).getFluid();
                    if (fluid != Fluids.WATER && fluid.isIn(FluidTags.WATER)) {
                        Item bucketItem = event.getEmptyBucket().getItem();
                        event.getPlayer().addStat(Stats.ITEM_USED.get(bucketItem));
                        SoundEvent soundevent = SoundEvents.ITEM_BUCKET_FILL;
                        event.getPlayer().playSound(soundevent, 1.0F, 1.0F);
                        event.setFilledBucket(ItemStack.EMPTY);
                        event.setResult(Event.Result.ALLOW);
                        return;
                    }
                }
            }
        }

        event.setResult(Event.Result.DEFAULT);
    }
}
