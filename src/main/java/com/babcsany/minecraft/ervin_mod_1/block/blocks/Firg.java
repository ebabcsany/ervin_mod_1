package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.SpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import net.minecraft.block.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

import static com.babcsany.minecraft.ervin_mod_1.state.ModBlockStateProperties.HORIZONTAL_FACING;

public class Firg extends Block{
    public Firg(Block.Properties properties) { super(properties); }
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final Direction[] GENERATE_DIRECTIONS = new Direction[]{Direction.WEST};
    public static Direction getGenerationDirection(Random rand) {
        return Util.getRandomObject(GENERATE_DIRECTIONS, rand);
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemstack = player.getHeldItem(handIn);
        if (itemstack.getItem() == isBurnableSpecialItemInit.GRITHVSG.get()) {
            if (!worldIn.isRemote) {
                ZurEntity zurEntity = new ZurEntity(worldIn);
                worldIn.addEntity(zurEntity);
                itemstack.damageItem(1, player, (p_220282_1_) -> p_220282_1_.sendBreakAnimation(handIn));
            }

            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }
}
