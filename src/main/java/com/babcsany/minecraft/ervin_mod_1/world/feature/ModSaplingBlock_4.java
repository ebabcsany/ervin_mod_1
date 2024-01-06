package com.babcsany.minecraft.ervin_mod_1.world.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Random;
import java.util.function.Supplier;

public class ModSaplingBlock_4 extends BushBlock implements IGrowable {

	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	private final Supplier<Tree_4> tree;

	public ModSaplingBlock_4(Supplier<Tree_4> treeIn, Properties properties) {
		super(properties);
		this.tree = treeIn;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if (!worldIn.isAreaLoaded(pos, 1)) {
			return;
		}
		if (worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
			this.grow(worldIn, pos, state, rand);
			this.grow1(worldIn, pos, state, rand);
			this.grow2(worldIn, pos, state, rand);
			this.grow3(worldIn, pos, state, rand);
			this.grow4(worldIn, pos, state, rand);
		}
	}

	public void grow(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
		if (state.get(STAGE) == 0) {
			serverWorld.setBlockState(pos, state.func_235896_a_(STAGE), 4);
		} else {
			if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos))
				return;
			this.tree.get().attemptGrowTree(serverWorld, serverWorld.getChunkProvider().getChunkGenerator(), pos, state,
					rand);
		}
	}

	public void grow1(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
		if (state.get(STAGE) == 0) {
			serverWorld.setBlockState(pos, state.func_235896_a_(STAGE), 4);
		} else {
			if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos))
				return;
			this.tree.get().attemptGrowTree1(serverWorld, serverWorld.getChunkProvider().getChunkGenerator(), pos, state,
					rand);
		}
	}

	public void grow2(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
		if (state.get(STAGE) == 0) {
			serverWorld.setBlockState(pos, state.func_235896_a_(STAGE), 4);
		} else {
			if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos))
				return;
			this.tree.get().attemptGrowTree2(serverWorld, serverWorld.getChunkProvider().getChunkGenerator(), pos, state,
					rand);
		}
	}

	public void grow3(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
		if (state.get(STAGE) == 0) {
			serverWorld.setBlockState(pos, state.func_235896_a_(STAGE), 4);
		} else {
			if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos))
				return;
			this.tree.get().attemptGrowTree3(serverWorld, serverWorld.getChunkProvider().getChunkGenerator(), pos, state,
					rand);
		}
	}

	public void grow4(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
		if (state.get(STAGE) == 0) {
			serverWorld.setBlockState(pos, state.func_235896_a_(STAGE), 4);
		} else {
			if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos))
				return;
			this.tree.get().attemptGrowTree4(serverWorld, serverWorld.getChunkProvider().getChunkGenerator(), pos, state,
					rand);
		}
	}

	@Override
	public void grow(ServerWorld serverWorld, Random rand, BlockPos pos, BlockState state) {
		this.grow(serverWorld, pos, state, rand);
		this.grow1(serverWorld, pos, state, rand);
		this.grow2(serverWorld, pos, state, rand);
		this.grow3(serverWorld, pos, state, rand);
		this.grow4(serverWorld, pos, state, rand);
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return (double) worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}
}