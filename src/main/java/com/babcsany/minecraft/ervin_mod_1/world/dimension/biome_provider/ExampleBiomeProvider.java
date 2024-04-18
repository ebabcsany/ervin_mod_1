package com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ExampleBiomeProvider extends BiomeProvider {
   public static final Codec<ExampleBiomeProvider> CODEC = RecordCodecBuilder.create((p_235302_0_) -> {
      return p_235302_0_.group(Codec.LONG.fieldOf("seed").stable().forGetter((p_235304_0_) -> {
         return p_235304_0_.seed;
      }), Codec.BOOL.optionalFieldOf("legacy_biome_init_layer", false, Lifecycle.stable()).forGetter((p_235303_0_) -> {
         return p_235303_0_.legacyBiomes;
      }), Codec.BOOL.fieldOf("large_biomes").orElse(false).stable().forGetter((p_235301_0_) -> {
         return p_235301_0_.largeBiomes;
      }), RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((p_242637_0_) -> {
         return p_242637_0_.lookupRegistry;
      })).apply(p_235302_0_, p_235302_0_.stable(ExampleBiomeProvider::new));
   });
   private final Layer genBiomes;
   private static final List<RegistryKey<Biome>> biomes;
   private final long seed;
   private final boolean legacyBiomes;
   private final boolean largeBiomes;
   private final Registry<Biome> lookupRegistry;

   public ExampleBiomeProvider(long p_i241958_1_, boolean p_i241958_3_, boolean p_i241958_4_, Registry<Biome> p_i241958_5_) {
      super(biomes.stream().map((p_242638_1_) -> {
         return () -> {
            return (Biome) p_i241958_5_.getOrThrow(p_242638_1_);
         };
      }));
      this.seed = p_i241958_1_;
      this.legacyBiomes = p_i241958_3_;
      this.largeBiomes = p_i241958_4_;
      this.lookupRegistry = p_i241958_5_;
      this.genBiomes = LayerUtil.func_237215_a_(p_i241958_1_, p_i241958_3_, p_i241958_4_ ? 6 : 4, 4);
   }

   protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
      return CODEC;
   }

   @OnlyIn(Dist.CLIENT)
   public BiomeProvider getBiomeProvider(long p_230320_1_) {
      return new OverworldBiomeProvider(p_230320_1_, this.legacyBiomes, this.largeBiomes, this.lookupRegistry);
   }

   public Biome getNoiseBiome(int p_225526_1_, int p_225526_2_, int p_225526_3_) {
      return this.genBiomes.func_242936_a(this.lookupRegistry, p_225526_1_, p_225526_3_);
   }

   static {
      biomes = ImmutableList.of(Biomes.OCEAN, Biomes.PLAINS, Biomes.DESERT, Biomes.MOUNTAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.SWAMP, Biomes.RIVER, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS, new RegistryKey[]{Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELD_SHORE, Biomes.BEACH, Biomes.DESERT_HILLS, Biomes.WOODED_HILLS, Biomes.TAIGA_HILLS, Biomes.MOUNTAIN_EDGE, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE, Biomes.DEEP_OCEAN, Biomes.STONE_SHORE, Biomes.SNOWY_BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.DARK_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS, Biomes.WOODED_MOUNTAINS, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.BADLANDS, Biomes.WOODED_BADLANDS_PLATEAU, Biomes.BADLANDS_PLATEAU, Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SUNFLOWER_PLAINS, Biomes.DESERT_LAKES, Biomes.GRAVELLY_MOUNTAINS, Biomes.FLOWER_FOREST, Biomes.TAIGA_MOUNTAINS, Biomes.SWAMP_HILLS, Biomes.ICE_SPIKES, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE, Biomes.TALL_BIRCH_FOREST, Biomes.TALL_BIRCH_HILLS, Biomes.DARK_FOREST_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.SHATTERED_SAVANNA, Biomes.SHATTERED_SAVANNA_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.MODIFIED_BADLANDS_PLATEAU});
   }
}