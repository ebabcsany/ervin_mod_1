package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.world.server.ModServerWorld;
import com.babcsany.minecraft.world.world;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.state.StateHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class PortalBlock extends Block {
    public PortalBlock(Properties properties) {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, world worldIn, BlockPos pos, Random rand) {
    }

    public void randomTick(BlockState state, ModServerWorld worldIn, BlockPos pos, Random random) {
        this.tick(state, worldIn, pos, random);
    }

    public void tick(BlockState state, ModServerWorld worldIn, BlockPos pos, Random rand) {
    }

    public void onEntityCollision(BlockState state, world worldIn, BlockPos pos, Living entityIn) {
    }

    public abstract static class AbstractBlockState extends StateHolder<PortalBlock, BlockState> {

        protected AbstractBlockState(PortalBlock block, ImmutableMap<Property<?>, Comparable<?>> propertyValueMap, MapCodec<BlockState> stateCodec) {
            super(block, propertyValueMap, stateCodec);
        }

        protected abstract BlockState getSelf();

        public PortalBlock getBlock() {
            return this.instance;
        }

        public void tick(ModServerWorld worldIn, BlockPos posIn, Random randomIn) {
            this.getBlock().tick(this.getSelf(), worldIn, posIn, randomIn);
        }

        public void randomTick(ModServerWorld worldIn, BlockPos posIn, Random randomIn) {
            this.getBlock().randomTick(this.getSelf(), worldIn, posIn, randomIn);
        }

        public void onEntityCollision(world worldIn, BlockPos pos, Living livingIn) {
            this.getBlock().onEntityCollision(this.getSelf(), worldIn, pos, livingIn);
        }
    }
}
