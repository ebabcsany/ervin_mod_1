package com.babcsany.minecraft.ervin_mod_1.init.dimension.settings;

import com.babcsany.minecraft.init.BlockInit;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.codec.RangeCodec;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public final class ModDimensionSettings {
   public static final Codec<ModDimensionSettings> field_236097_a_ = RecordCodecBuilder.create((p_236112_0_) -> {
      return p_236112_0_.group(DimensionStructuresSettings.field_236190_a_.fieldOf("structures").forGetter(ModDimensionSettings::getStructures), NoiseSettings.field_236156_a_.fieldOf("noise").forGetter(ModDimensionSettings::getNoise), BlockState.BLOCKSTATE_CODEC.fieldOf("default_block").forGetter(ModDimensionSettings::getDefaultBlock), BlockState.BLOCKSTATE_CODEC.fieldOf("default_fluid").forGetter(ModDimensionSettings::getDefaultFluid), RangeCodec.func_232989_a_(-20, 276).fieldOf("bedrock_roof_position").forGetter(ModDimensionSettings::func_236117_e_), RangeCodec.func_232989_a_(-20, 276).fieldOf("bedrock_floor_position").forGetter(ModDimensionSettings::func_236118_f_), RangeCodec.func_232989_a_(0, 255).fieldOf("sea_level").forGetter(ModDimensionSettings::func_236119_g_), Codec.BOOL.fieldOf("disable_mob_generation").forGetter(ModDimensionSettings::func_236120_h_)).apply(p_236112_0_, ModDimensionSettings::new);
   });
   public static final Codec<ModDimensionSettings> field_236098_b_ = Codec.either(ModDimensionSettings.Preset.PRESET_CODEC, field_236097_a_).xmap((p_236111_0_) -> {
      return p_236111_0_.map(ModDimensionSettings.Preset::getModSettings, Function.identity());
   }, (p_236110_0_) -> {
      return p_236110_0_.field_236107_k_.<Either<Preset, ModDimensionSettings>>map(Either::left).orElseGet(() -> {
         return Either.right(p_236110_0_);
      });
   });
   private final DimensionStructuresSettings structures;
   private final NoiseSettings noise;
   private final BlockState defaultBlock;
   private final BlockState defaultFluid;
   private final int field_236103_g_;
   private final int field_236104_h_;
   private final int field_236105_i_;
   private final boolean field_236106_j_;
   private final Optional<ModDimensionSettings.Preset> field_236107_k_;

   public ModDimensionSettings(DimensionStructuresSettings structures, NoiseSettings noise, BlockState defaultBlock, BlockState defaultFluid, int p_i231905_5_, int p_i231905_6_, int p_i231905_7_, boolean p_i231905_8_) {
      this(structures, noise, defaultBlock, defaultFluid, p_i231905_5_, p_i231905_6_, p_i231905_7_, p_i231905_8_, Optional.empty());
   }

   public ModDimensionSettings(DimensionStructuresSettings structures, NoiseSettings noise, BlockState defaultBlock, BlockState defaultFluid, int p_i231906_5_, int p_i231906_6_, int p_i231906_7_, boolean p_i231906_8_, Optional<ModDimensionSettings.Preset> p_i231906_9_) {
      this.structures = structures;
      this.noise = noise;
      this.defaultBlock = defaultBlock;
      this.defaultFluid = defaultFluid;
      this.field_236103_g_ = p_i231906_5_;
      this.field_236104_h_ = p_i231906_6_;
      this.field_236105_i_ = p_i231906_7_;
      this.field_236106_j_ = p_i231906_8_;
      this.field_236107_k_ = p_i231906_9_;
   }

   public DimensionStructuresSettings getStructures() {
      return this.structures;
   }

   public NoiseSettings getNoise() {
      return this.noise;
   }

   public BlockState getDefaultBlock() {
      return this.defaultBlock;
   }

   public BlockState getDefaultFluid() {
      return this.defaultFluid;
   }

   public int func_236117_e_() {
      return this.field_236103_g_;
   }

   public int func_236118_f_() {
      return this.field_236104_h_;
   }

   public int func_236119_g_() {
      return this.field_236105_i_;
   }

   @Deprecated
   protected boolean func_236120_h_() {
      return this.field_236106_j_;
   }

   public boolean func_236109_a_(ModDimensionSettings.Preset p_236109_1_) {
      return Objects.equals(this.field_236107_k_, Optional.of(p_236109_1_));
   }

   public static class Preset extends DimensionSettings.Preset {
      private static final Map<ResourceLocation, ModDimensionSettings.Preset> PRESET_MAP = Maps.newHashMap();
      public static final Codec<ModDimensionSettings.Preset> PRESET_CODEC = ResourceLocation.RESOURCE_LOCATION_CODEC.flatXmap((p_236136_0_) -> Optional.ofNullable(PRESET_MAP.get(p_236136_0_)).map(DataResult::success).orElseGet(() -> DataResult.error("Unknown preset: " + p_236136_0_)), (p_236144_0_) -> DataResult.success(p_236144_0_.presetName)).stable();
      public static final DimensionSettings.Preset OVERWORLD = DimensionSettings.Preset.OVERWORLD;
      public static final DimensionSettings.Preset AMPLIFIED = DimensionSettings.Preset.AMPLIFIED;
      public static final DimensionSettings.Preset NETHER = DimensionSettings.Preset.NETHER;
      public static final DimensionSettings.Preset END = DimensionSettings.Preset.END;
      public static final DimensionSettings.Preset CAVES = DimensionSettings.Preset.CAVES;
      public static final DimensionSettings.Preset FLOATING_ISLANDS = DimensionSettings.Preset.FLOATING_ISLANDS;
      public static final DimensionSettings.Preset EXAMPLE = new ModDimensionSettings.Preset("example", (preset) -> createSettings(new DimensionStructuresSettings(false), BlockInit.FIRT_BLOCK.getDefaultState(), Blocks.AIR.getDefaultState(), preset));
      private final ITextComponent presetNameComponent;
      private final ResourceLocation presetName;
      private final ModDimensionSettings settings;
      private static Function<DimensionSettings.Preset, DimensionSettings> presetDimensionSettingsFunction;

      public Preset(String name, Function<ModDimensionSettings.Preset, ModDimensionSettings> presetSettings) {
         super(name, presetDimensionSettingsFunction);
         this.presetName = new ResourceLocation(name);
         this.presetNameComponent = new TranslationTextComponent("generator.noise." + name);
         this.settings = presetSettings.apply(this);
         PRESET_MAP.put(this.presetName, this);
      }

      public ModDimensionSettings getModSettings() {
         return this.settings;
      }

      public static ModDimensionSettings createSettings(DimensionStructuresSettings structures, BlockState defaultBlock, BlockState defaultFluid, ModDimensionSettings.Preset preset, boolean disabledMobGeneration, boolean islandNoiseOverride) {
         return new ModDimensionSettings(structures, new NoiseSettings(128, new ScalingSettings(2.0D, 1.0D, 80.0D, 160.0D), new SlideSettings(-3000, 64, -46), new SlideSettings(-30, 7, 1), 2, 1, 0.0D, 0.0D, true, false, islandNoiseOverride, false), defaultBlock, defaultFluid, -10, -10, 0, disabledMobGeneration, Optional.of(preset));
      }

      public static ModDimensionSettings createSettings(DimensionStructuresSettings structures, BlockState defaultBlock, BlockState defaultFluid, ModDimensionSettings.Preset preset) {
         Map<Structure<?>, StructureSeparationSettings> map = Maps.newHashMap(DimensionStructuresSettings.field_236191_b_);
         map.put(Structure.field_236372_h_, new StructureSeparationSettings(25, 10, 34222645));
         return new ModDimensionSettings(new DimensionStructuresSettings(Optional.ofNullable(structures.func_236199_b_()), map), new NoiseSettings(128, new ScalingSettings(1.0D, 3.0D, 80.0D, 60.0D), new SlideSettings(120, 3, 0), new SlideSettings(320, 4, -1), 1, 2, 0.0D, 0.019921875D, false, false, false, false), defaultBlock, defaultFluid, 0, 0, 32, false, Optional.of(preset));
      }

      public static ModDimensionSettings createSettings(DimensionStructuresSettings structures, boolean amplified, ModDimensionSettings.Preset preset) {
         double d0 = 0.9999999814507745D;
         return new ModDimensionSettings(structures, new NoiseSettings(256, new ScalingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new SlideSettings(-10, 3, 0), new SlideSettings(-30, 0, 0), 1, 2, 1.0D, -0.46875D, true, true, false, amplified), Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), -10, 0, 63, false, Optional.of(preset));
      }
   }
}
