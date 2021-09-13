package com.babcsany.minecraft.client.renderer;

import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ViewFrustum_ extends ViewFrustum {

    @Nullable
    @Override
    public ChunkRenderDispatcher.ChunkRender getRenderChunk(BlockPos pos) {
        return super.getRenderChunk(pos);
    }

    public ViewFrustum_(ChunkRenderDispatcher renderDispatcherIn, World worldIn, int countChunksIn, WorldRenderer renderGlobalIn) {
        super(renderDispatcherIn, worldIn, countChunksIn, renderGlobalIn);
    }
}
