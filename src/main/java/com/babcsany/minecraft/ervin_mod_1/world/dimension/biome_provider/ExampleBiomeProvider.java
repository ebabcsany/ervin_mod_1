package com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
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
import net.minecraft.world.gen.MaxMinNoiseMixer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExampleBiomeProvider extends ModBiomeProvider {
   public static final MapCodec<ExampleBiomeProvider> field_235262_e_ = RecordCodecBuilder.mapCodec((exampleBiomeProviderInstance) -> exampleBiomeProviderInstance.group(Codec.LONG.fieldOf("seed").forGetter((exampleBiomeProvider) -> exampleBiomeProvider.field_235270_m_), RecordCodecBuilder.<Pair<Biome.Attributes, Biome>>create((pairInstance) -> pairInstance.group(Biome.Attributes.field_235104_a_.fieldOf("parameters").forGetter(Pair::getFirst), Registry.BIOME.fieldOf("biome").forGetter(Pair::getSecond)).apply(pairInstance, Pair::of)).listOf().fieldOf("biomes").forGetter((exampleBiomeProvider) -> exampleBiomeProvider.pairList)).apply(exampleBiomeProviderInstance, ExampleBiomeProvider::new));
   public static final Codec<ExampleBiomeProvider> field_235263_f_ = Codec.mapEither(ExampleBiomeProvider.Preset.field_235287_a_, field_235262_e_).xmap((p_235277_0_) -> p_235277_0_.map((p_235278_0_) -> p_235278_0_.getFirst().func_235292_a_(p_235278_0_.getSecond()), Function.identity()), (p_235275_0_) -> p_235275_0_.field_235271_n_.<Either<Pair<Preset, Long>, ExampleBiomeProvider>>map((p_235276_1_) -> Either.left(Pair.of(p_235276_1_, p_235275_0_.field_235270_m_))).orElseGet(() -> Either.right(p_235275_0_))).codec();
   private final MaxMinNoiseMixer field_235264_g_;
   private final MaxMinNoiseMixer field_235265_h_;
   private final MaxMinNoiseMixer field_235266_i_;
   private final MaxMinNoiseMixer field_235267_j_;
   private static Pair<?, ?> pair;
   private final List<Pair<Biome.Attributes, Biome>> pairList;
   private final boolean field_235269_l_;
   private final long field_235270_m_;
   private final Optional<ExampleBiomeProvider.Preset> field_235271_n_;

   private ExampleBiomeProvider(long p_i231639_1_, List<Pair<Biome.Attributes, Biome>> p_i231639_3_) {
      this(p_i231639_1_, p_i231639_3_, Optional.empty());
   }

   public ExampleBiomeProvider(long p_i231640_1_, List<Pair<Biome.Attributes, Biome>> pairList, Optional<ExampleBiomeProvider.Preset> p_i231640_4_) {
      super(pairList.stream().map(Pair::getSecond).collect(Collectors.toList()));
      this.field_235270_m_ = p_i231640_1_;
      this.field_235271_n_ = p_i231640_4_;
      IntStream intstream = IntStream.rangeClosed(-7, -6);
      IntStream intstream1 = IntStream.rangeClosed(-7, -6);
      IntStream intstream2 = IntStream.rangeClosed(-7, -6);
      IntStream intstream3 = IntStream.rangeClosed(-7, -6);
      this.field_235264_g_ = new MaxMinNoiseMixer(new SharedSeedRandom(p_i231640_1_), intstream);
      this.field_235265_h_ = new MaxMinNoiseMixer(new SharedSeedRandom(p_i231640_1_ + 1L), intstream1);
      this.field_235266_i_ = new MaxMinNoiseMixer(new SharedSeedRandom(p_i231640_1_ + 2L), intstream2);
      this.field_235267_j_ = new MaxMinNoiseMixer(new SharedSeedRandom(p_i231640_1_ + 3L), intstream3);
      this.pairList = pairList;
      this.field_235269_l_ = false;
   }

   private static ExampleBiomeProvider func_235285_d_(long l) {
      ImmutableList<Biome> immutablelist = ImmutableList.of(BiomeInit.EXAMPLE_BIOME.get(), BiomeInit.EXAMPLE_BIOME0.get());
      return new ExampleBiomeProvider(l, immutablelist.stream().flatMap((biomeSupplier) -> biomeSupplier.func_235055_B_().map((attributes) -> Pair.of(attributes, biomeSupplier))).collect(ImmutableList.toImmutableList()), Optional.of(ExampleBiomeProvider.Preset.field_235288_b_));
   }

   protected Codec<? extends ModBiomeProvider> func_230319_a_() {
      return field_235263_f_;
   }

   @OnlyIn(Dist.CLIENT)
   public ModBiomeProvider func_230320_a_(long p_230320_1_) {
      return new ExampleBiomeProvider(p_230320_1_, this.pairList, this.field_235271_n_);
   }

   public Biome getNoiseBiome(int x, int y, int z) {
      int i = this.field_235269_l_ ? y : 0;
      Biome.Attributes biome$attributes = new Biome.Attributes((float)this.field_235264_g_.func_237211_a_(x, i, z), (float)this.field_235265_h_.func_237211_a_(x, i, z), (float)this.field_235266_i_.func_237211_a_(x, i, z), (float)this.field_235267_j_.func_237211_a_(x, i, z), 0.0F);
      return this.pairList.stream().min(Comparator.comparing((attributesBiomePair) -> attributesBiomePair.getFirst().func_235110_a_(biome$attributes))).map(Pair::getSecond).orElse(BiomeInit.THE_BHJUIG_BIOME.get());
   }

   public boolean func_235280_b_(long l) {
      return this.field_235270_m_ == l && Objects.equals(this.field_235271_n_, Optional.of(ExampleBiomeProvider.Preset.field_235288_b_));
   }

   public static class Preset {
      private static final Map<ResourceLocation, ExampleBiomeProvider.Preset> field_235289_c_ = Maps.newHashMap();
      public static final MapCodec<Pair<ExampleBiomeProvider.Preset, Long>> field_235287_a_ = Codec.mapPair(ResourceLocation.RESOURCE_LOCATION_CODEC.flatXmap((p_235294_0_) -> Optional.ofNullable(field_235289_c_.get(p_235294_0_)).map(DataResult::success).orElseGet(() -> DataResult.error("Unknown preset: " + p_235294_0_)), (p_235293_0_) -> DataResult.success(p_235293_0_.field_235290_d_)).fieldOf("preset"), Codec.LONG.fieldOf("seed")).stable();
      public static final ExampleBiomeProvider.Preset field_235288_b_ = new ExampleBiomeProvider.Preset(new ResourceLocation(Ervin_mod_1.MOD_ID,"example"), ExampleBiomeProvider::func_235285_d_);
      private final ResourceLocation field_235290_d_;
      private final LongFunction<ExampleBiomeProvider> field_235291_e_;

      public Preset(ResourceLocation resourceLocation, LongFunction<ExampleBiomeProvider> exampleBiomeProviderLongFunction) {
         this.field_235290_d_ = resourceLocation;
         this.field_235291_e_ = exampleBiomeProviderLongFunction;
         field_235289_c_.put(resourceLocation, this);
      }

      public ExampleBiomeProvider func_235292_a_(long p_235292_1_) {
         return this.field_235291_e_.apply(p_235292_1_);
      }
   }
}