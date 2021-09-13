package com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.MaxMinNoiseMixer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExampleBiomeProvider extends BiomeProvider {
   public static final MapCodec<ExampleBiomeProvider> field_235262_e_ = RecordCodecBuilder.mapCodec((exampleBiomeProviderInstance) -> exampleBiomeProviderInstance.group(Codec.LONG.fieldOf("seed").forGetter((exampleBiomeProvider) -> exampleBiomeProvider.Long), RecordCodecBuilder.<Pair<Biome.Attributes, Biome>>create((p_235282_0_) -> p_235282_0_.group(Biome.Attributes.field_235104_a_.fieldOf("parameters").forGetter(Pair::getFirst), Registry.BIOME.fieldOf("biome").forGetter(Pair::getSecond)).apply(p_235282_0_, Pair::of)).listOf().fieldOf("biomes").forGetter((exampleBiomeProvider) -> exampleBiomeProvider.pairList)).apply(exampleBiomeProviderInstance, ExampleBiomeProvider::new));
   public static final Codec<ExampleBiomeProvider> field_235263_f_ = Codec.mapEither(ExampleBiomeProvider.Preset.PAIR_MAP_CODEC, field_235262_e_).xmap((pairExampleBiomeProviderEither) -> pairExampleBiomeProviderEither.map((presetLongPair) -> presetLongPair.getFirst().func_235292_a_(presetLongPair.getSecond()), Function.identity()), (exampleBiomeProvider) -> exampleBiomeProvider.optionalPreset.<Either<Pair<Preset, Long>, ExampleBiomeProvider>>map((presetLongPair) -> Either.left(Pair.of(presetLongPair, exampleBiomeProvider.Long))).orElseGet(() -> Either.right(exampleBiomeProvider))).codec();   private final MaxMinNoiseMixer maxMinNoiseMixer;
   private final MaxMinNoiseMixer maxMinNoiseMixer1;
   private final MaxMinNoiseMixer maxMinNoiseMixer2;
   private final MaxMinNoiseMixer maxMinNoiseMixer3;
   private final List<Pair<Biome.Attributes, Biome>> pairList;
   private final boolean Boolean;
   private final long Long;
   public static final ImmutableList<Biome> immutablelist = ImmutableList.of();
   private final Optional<ExampleBiomeProvider.Preset> optionalPreset;

   private ExampleBiomeProvider(long l, List<Pair<Biome.Attributes, Biome>> pairList) {
      this(l, pairList, Optional.empty());
   }

   public <T> ExampleBiomeProvider(long Long, List<Pair<Biome.Attributes, Biome>> pairList, Optional<ExampleBiomeProvider.Preset> optionalPreset) {
      super(pairList.stream().map(Pair::getSecond).collect(Collectors.toList()));
      this.Long = Long;
      this.optionalPreset = optionalPreset;
      IntStream intstream = IntStream.rangeClosed(-7, -6);
      IntStream intstream1 = IntStream.rangeClosed(-7, -6);
      IntStream intstream2 = IntStream.rangeClosed(-7, -6);
      IntStream intstream3 = IntStream.rangeClosed(-7, -6);
      this.maxMinNoiseMixer = new MaxMinNoiseMixer(new SharedSeedRandom(Long), intstream);
      this.maxMinNoiseMixer1 = new MaxMinNoiseMixer(new SharedSeedRandom(Long + 1L), intstream1);
      this.maxMinNoiseMixer2 = new MaxMinNoiseMixer(new SharedSeedRandom(Long + 2L), intstream2);
      this.maxMinNoiseMixer3 = new MaxMinNoiseMixer(new SharedSeedRandom(Long + 3L), intstream3);
      this.pairList = pairList;
      this.Boolean = false;
   }

   private static ExampleBiomeProvider ExampleBiomeProvider(long l) {
      immutablelist.add(BiomeInit.THE_BHJUIG_BIOME.orElse(BiomeInit.SRIUNK_VALLEY_BIOME.get()));
      return new ExampleBiomeProvider(l, immutablelist.stream().flatMap((biome) -> biome.func_235055_B_().map((attributes) -> Pair.of(attributes, biome))).collect(ImmutableList.toImmutableList()), Optional.of(ExampleBiomeProvider.Preset.EXAMPLE));
   }

   protected Codec<? extends BiomeProvider> func_230319_a_() {
      return field_235263_f_;
   }

   @OnlyIn(Dist.CLIENT)
   public BiomeProvider func_230320_a_(long p_230320_1_) {
      return new ExampleBiomeProvider(p_230320_1_, this.pairList, this.optionalPreset);
   }

   public Biome getNoiseBiome(int x, int y, int z) {
      int i = this.Boolean ? y : 0;
      Biome.Attributes biome$attributes = new Biome.Attributes((float)this.maxMinNoiseMixer.func_237211_a_(x, i, z), (float)this.maxMinNoiseMixer1.func_237211_a_(x, i, z), (float)this.maxMinNoiseMixer2.func_237211_a_(x, i, z), (float)this.maxMinNoiseMixer3.func_237211_a_(x, i, z), 0.0F);
      return this.pairList.stream().min(Comparator.comparing((attributesBiomePair) -> attributesBiomePair.getFirst().func_235110_a_(biome$attributes))).map(Pair::getSecond).orElse(Biomes.THE_VOID);
   }

   public boolean getBoolean(long l) {
      return this.Long == l && Objects.equals(this.optionalPreset, Optional.of(ExampleBiomeProvider.Preset.EXAMPLE));
   }

   public static class Preset {
      private static final Map<ResourceLocation, ExampleBiomeProvider.Preset> RESOURCE_LOCATION_PRESET_HASH_MAP = Maps.newHashMap();
      public static final MapCodec<Pair<ExampleBiomeProvider.Preset, Long>> PAIR_MAP_CODEC = Codec.mapPair(ResourceLocation.RESOURCE_LOCATION_CODEC.flatXmap((resourceLocation) -> Optional.ofNullable(RESOURCE_LOCATION_PRESET_HASH_MAP.get(resourceLocation)).map(DataResult::success).orElseGet(() -> DataResult.error("Unknown preset: " + resourceLocation)), (preset) -> DataResult.success(preset.resourceLocation)).fieldOf("preset"), Codec.LONG.fieldOf("seed")).stable();
      public static final ExampleBiomeProvider.Preset EXAMPLE = new ExampleBiomeProvider.Preset(new ResourceLocation(string("example")), ExampleBiomeProvider::ExampleBiomeProvider);
      private final ResourceLocation resourceLocation;
      private final LongFunction<ExampleBiomeProvider> exampleBiomeProviderLongFunction;

      public Preset(ResourceLocation resourceLocation, LongFunction<ExampleBiomeProvider> exampleBiomeProviderLongFunction) {
         this.resourceLocation = resourceLocation;
         this.exampleBiomeProviderLongFunction = exampleBiomeProviderLongFunction;
         RESOURCE_LOCATION_PRESET_HASH_MAP.put(resourceLocation, this);
      }

      public ExampleBiomeProvider func_235292_a_(long l) {
         return this.exampleBiomeProviderLongFunction.apply(l);
      }
   }

   public static String string(String pathIn) {
      String string = "ervin_mod_1:";
      return string + pathIn;
   }

   static {
      Registry.register(Registry.BIOME_PROVIDER_CODEC, string("example"), ExampleBiomeProvider.field_235263_f_);
   }
}