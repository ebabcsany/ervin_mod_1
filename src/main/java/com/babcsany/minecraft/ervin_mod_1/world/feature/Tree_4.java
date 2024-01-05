package com.babcsany.minecraft.ervin_mod_1.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class Tree_4 extends Tree {
    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
     */
    @Nullable
    protected abstract net.minecraft.world.gen.feature.ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature1(Random randomIn, boolean largeHive);
    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
     */
    @Nullable
    protected abstract net.minecraft.world.gen.feature.ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature2(Random randomIn, boolean largeHive);
    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
     */
    @Nullable
    protected abstract net.minecraft.world.gen.feature.ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature3(Random randomIn, boolean largeHive);
    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
     */
    @Nullable
    protected abstract net.minecraft.world.gen.feature.ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature4(Random randomIn, boolean largeHive);

    public boolean attemptGrowTree1(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random rand) {
        ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredfeature = this.getTreeFeature1(rand, this.hasNearbyFlora(world, pos));
        if (configuredfeature == null) {
            return false;
        } else {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            configuredfeature.config.forcePlacement();
            if (configuredfeature.func_236265_a_(world, world.func_241112_a_(), chunkGenerator, rand, pos)) {
                return true;
            } else {
                world.setBlockState(pos, state, 4);
                return false;
            }
        }
    }

    public boolean attemptGrowTree2(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random rand) {
        ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredfeature = this.getTreeFeature2(rand, this.hasNearbyFlora(world, pos));
        if (configuredfeature == null) {
            return false;
        } else {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            configuredfeature.config.forcePlacement();
            if (configuredfeature.func_236265_a_(world, world.func_241112_a_(), chunkGenerator, rand, pos)) {
                return true;
            } else {
                world.setBlockState(pos, state, 4);
                return false;
            }
        }
    }

    public boolean attemptGrowTree3(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random rand) {
        ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredfeature = this.getTreeFeature3(rand, this.hasNearbyFlora(world, pos));
        if (configuredfeature == null) {
            return false;
        } else {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            configuredfeature.config.forcePlacement();
            if (configuredfeature.func_236265_a_(world, world.func_241112_a_(), chunkGenerator, rand, pos)) {
                return true;
            } else {
                world.setBlockState(pos, state, 4);
                return false;
            }
        }
    }

    public boolean attemptGrowTree4(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random rand) {
        ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredfeature = this.getTreeFeature4(rand, this.hasNearbyFlora(world, pos));
        if (configuredfeature == null) {
            return false;
        } else {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            configuredfeature.config.forcePlacement();
            if (configuredfeature.func_236265_a_(world, world.func_241112_a_(), chunkGenerator, rand, pos)) {
                return true;
            } else {
                world.setBlockState(pos, state, 4);
                return false;
            }
        }
    }

    private boolean hasNearbyFlora(IWorld world, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.Mutable.getAllInBoxMutable(pos.down().north(2).west(2), pos.up().south(2).east(2))) {
            if (world.getBlockState(blockpos).isIn(BlockTags.FLOWERS)) {
                return true;
            }
        }

        return false;
    }
}
