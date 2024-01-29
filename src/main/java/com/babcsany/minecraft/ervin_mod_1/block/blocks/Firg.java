package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraft.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public class Firg extends Block {
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 7);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final Direction[] GENERATE_DIRECTIONS = new Direction[]{Direction.WEST};

    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(10.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    public Firg(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, BITES);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(BITES)];
    }

    public static Direction getGenerationDirection(Random rand) {
        return Util.getRandomObject(GENERATE_DIRECTIONS, rand);
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit, Food.Builder builder, Food food) {
        if (worldIn.isRemote) {
            ItemStack itemstack = player.getHeldItem(handIn);
            if (this.eatSlice(worldIn, pos, state, player, builder, food).isSuccessOrConsume()) {
                return ActionResultType.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return this.eatSlice(worldIn, pos, state, player, builder, food);
    }

    private ActionResultType eatSlice(IWorld world, BlockPos pos, BlockState state, PlayerEntity player, Food.Builder builder, Food food) {
        if (!player.canEat(true)) {
            return ActionResultType.PASS;
        } else {
            player.addStat(Stats.EAT_CAKE_SLICE);
            player.getFoodStats().addStats( 1, 0.2F);
            player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 50, (int) 1.25));
            int i = state.get(BITES);
            if (i < 7) {
                world.setBlockState(pos, state.with(BITES, i + 1), 3);
            }

            return ActionResultType.SUCCESS;
        }
    }

    /**
     * @deprecated call via {@link BlockState#getComparatorInputOverride(World,BlockPos)} whenever possible.
     * Implementing/overriding is fine.
     */
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return (7 - blockState.get(BITES)) * 2;
    }

    /**
     * @deprecated call via {@link BlockState#hasComparatorInputOverride()} whenever possible. Implementing/overriding
     * is fine.
     */
    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return true;
    }
}
