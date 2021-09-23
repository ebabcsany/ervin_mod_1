package net.minecraft.world.server;

import com.mojang.datafixers.DataFixer;
import net.minecraft.util.concurrent.ThreadTaskExecutor;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.IChunkLightProvider;
import net.minecraft.world.chunk.listener.IChunkStatusListener;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.SaveFormat;

import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class G extends ChunkManager {

    public G(ServerWorld p_i232602_1_, SaveFormat.LevelSave p_i232602_2_, DataFixer p_i232602_3_, TemplateManager p_i232602_4_, Executor p_i232602_5_, ThreadTaskExecutor<Runnable> p_i232602_6_, IChunkLightProvider p_i232602_7_, ChunkGenerator p_i232602_8_, IChunkStatusListener p_i232602_9_, Supplier<DimensionSavedDataManager> p_i232602_10_, int p_i232602_11_, boolean p_i232602_12_) {
        super(p_i232602_1_, p_i232602_2_, p_i232602_3_, p_i232602_4_, p_i232602_5_, p_i232602_6_, p_i232602_7_, p_i232602_8_, p_i232602_9_, p_i232602_10_, p_i232602_11_, p_i232602_12_);
    }

    @Override
    public boolean isOutsideSpawningRadius(ChunkPos chunkPosIn) {
        return super.isOutsideSpawningRadius(chunkPosIn);
    }
}
