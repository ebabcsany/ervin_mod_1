package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.PillagerOutpostPieces;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class PillagerOutpostStructure1 extends ScatteredStructure<NoFeatureConfig> {
   /** List of enemies that can spawn in the Pillage Outpost. */
   private static final List<Biome.SpawnListEntry> PILLAGE_OUTPOST_ENEMIES = Lists.newArrayList(new Biome.SpawnListEntry(EntityType.PILLAGER, 1, 1, 1));

   public PillagerOutpostStructure1(Function<Dynamic<?>, ? extends NoFeatureConfig> pillageOutpostConfigIn) {
      super(pillageOutpostConfigIn);
   }

   public String getStructureName() {
      return "Pillager_Outpost";
   }

   public int getSize() {
      return 3;
   }

   public List<Biome.SpawnListEntry> getSpawnList() {
      return PILLAGE_OUTPOST_ENEMIES;
   }

   public boolean func_225558_a_(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
      ChunkPos chunkpos = this.getStartPositionForPosition(generatorIn, randIn, chunkX, chunkZ, 0, 0);
      if (chunkX == chunkpos.x && chunkZ == chunkpos.z) {
         int i = chunkX >> 4;
         int j = chunkZ >> 4;
         randIn.setSeed((long)(i ^ j << 4) ^ generatorIn.getSeed());
         randIn.nextInt();
         if (randIn.nextInt(5) != 0) {
            return false;
         }

         if (generatorIn.hasStructure(biomeIn, this)) {
            for(int k = chunkX - 10; k <= chunkX + 10; ++k) {
               for(int l = chunkZ - 10; l <= chunkZ + 10; ++l) {
                  if (Feature.VILLAGE.func_225558_a_(biomeManagerIn, generatorIn, randIn, k, l, biomeManagerIn.getBiome(new BlockPos((k << 4) + 9, 0, (l << 4) + 9)))) {
                     return false;
                  }
               }
            }

            return true;
         }
      }

      return false;
   }

   public IStartFactory getStartFactory() {
      return PillagerOutpostStructure1.Start::new;
   }

   protected int getSeedModifier() {
      return 165745296;
   }

   public static class Start extends MarginedStructureStart {
      public Start(Structure<?> p_i225815_1_, int p_i225815_2_, int p_i225815_3_, MutableBoundingBox p_i225815_4_, int p_i225815_5_, long p_i225815_6_) {
         super(p_i225815_1_, p_i225815_2_, p_i225815_3_, p_i225815_4_, p_i225815_5_, p_i225815_6_);
      }

      public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
         BlockPos blockpos = new BlockPos(chunkX * 16, 90, chunkZ * 16);
         PillagerOutpostPieces.func_215139_a(generator, templateManagerIn, blockpos, this.components, this.rand);
         this.recalculateStructureSize();
      }
   }
}