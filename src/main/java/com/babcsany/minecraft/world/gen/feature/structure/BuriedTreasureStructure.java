package com.babcsany.minecraft.world.gen.feature.structure;

import com.babcsany.minecraft.world.gen.feature.BuriedTreasure;
import com.babcsany.minecraft.world.gen.feature.config.BuriedTreasureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class BuriedTreasureStructure extends Structure<BuriedTreasureConfig> {
   public BuriedTreasureStructure(Codec<BuriedTreasureConfig> buriedTreasureConfigCodec) {
      super(buriedTreasureConfigCodec);
   }

   protected boolean func_230363_a_(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_, SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_, Biome p_230363_8_, ChunkPos p_230363_9_, BuriedTreasureConfig p_230363_10_) {
      p_230363_5_.setLargeFeatureSeedWithSalt(p_230363_3_, p_230363_6_, p_230363_7_, 10387320);
      return p_230363_5_.nextFloat() < p_230363_10_.probability;
   }

   public IStartFactory<BuriedTreasureConfig> getStartFactory() {
      return Start::new;
   }

   public static class Start extends StructureStart<BuriedTreasureConfig> {
      public Start(Structure<BuriedTreasureConfig> structure, int chunkPosX, int chunkPosZ, MutableBoundingBox bounds, int references, long rand) {
         super(structure, chunkPosX, chunkPosZ, bounds, references, rand);
      }

      public void func_230364_a_(ChunkGenerator chunkGenerator, TemplateManager templateManager, int i1, int i2, Biome biome, BuriedTreasureConfig config) {
         int i = i1 * 16;
         int j = i2 * 16;
         BlockPos blockpos = new BlockPos(i + 9, 90, j + 9);
         this.components.add(new BuriedTreasure.Piece(blockpos));
         this.recalculateStructureSize();
      }

      public BlockPos getPos() {
         return new BlockPos((this.getChunkPosX() << 4) + 9, 0, (this.getChunkPosZ() << 4) + 9);
      }
   }
}
