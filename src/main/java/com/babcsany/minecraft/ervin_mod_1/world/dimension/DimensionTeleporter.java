package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class DimensionTeleporter implements ITeleporter {
    public static BlockPos pos = BlockPos.ZERO;
    public static boolean inside = false;
    private final BlockState dimensionBlockState;

    public DimensionTeleporter(BlockPos pos, boolean inside) {
        DimensionTeleporter.pos = pos;
        DimensionTeleporter.inside = inside;
        this.dimensionBlockState = null;
    }

    public DimensionTeleporter(BlockState dimensionBlockState) {
        this.dimensionBlockState = dimensionBlockState;
    }

    public static boolean isState(BlockState state, BlockState isNotStateIn, Fluid isNotCanBeReplacedFluidIn) {
        return (state != isNotStateIn) && !state.isReplaceable(isNotCanBeReplacedFluidIn);
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = 61;
        if (!inside) y = pos.getY();
        BlockPos destPos = new BlockPos(pos.getX(), y, pos.getZ());
        int tries = 0;
        BlockState destState = destWorld.getBlockState(destPos);
        BlockState destStateUp = destWorld.getBlockState(destPos.up());
        BlockState airState = Blocks.AIR.getDefaultState();
        if (isState(destState, airState, Fluids.WATER) &&
        isState(destStateUp, airState, Fluids.WATER)) {
            destPos = destPos.up(2);
            tries++;
        }
        entity.setPosition(destPos.getX(), destPos.getY(), destPos.getZ());
        if (inside) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.getAllInBoxMutable(destPos.up(10).east(10), destPos.down(10).west(10))) {
                if (destWorld.getBlockState(checkPos).getBlock() instanceof Block) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock && (this.dimensionBlockState != null)) {
                destWorld.setBlockState(destPos, this.dimensionBlockState);
            }
        }

        return entity;
    }
}
