package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.longs.Long2FloatLinkedOpenHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModBiome<T extends Biome> extends net.minecraftforge.registries.ForgeRegistryEntry<ModBiome<?>> {
    //public static final Codec<Biome> field_235051_b_ = RecordCodecBuilder.create((p_235064_0_) -> p_235064_0_.group(RainType.RAIN_TYPE_CODEC.fieldOf("precipitation").forGetter((biome) -> biome.precipitation), Category.field_235102_r_.fieldOf("category").forGetter((p_235087_0_) -> p_235087_0_.category), Codec.FLOAT.fieldOf("depth").forGetter((p_235086_0_) -> p_235086_0_.depth), Codec.FLOAT.fieldOf("scale").forGetter((p_235085_0_) -> p_235085_0_.scale), Codec.FLOAT.fieldOf("temperature").forGetter((p_235084_0_) -> p_235084_0_.temperature), Codec.FLOAT.fieldOf("downfall").forGetter((p_235083_0_) -> p_235083_0_.downfall), BiomeAmbience.field_235204_a_.fieldOf("effects").forGetter((p_235082_0_) -> p_235082_0_.biomeAmbience), Codec.INT.fieldOf("sky_color").forGetter((p_235081_0_) -> p_235081_0_.skyColor), ConfiguredSurfaceBuilder.field_237168_a_.fieldOf("surface_builder").forGetter((p_235079_0_) -> p_235079_0_.surfaceBuilder), Codec.simpleMap(GenerationStage.Carving.field_236074_c_, ConfiguredCarver.field_236235_a_.listOf().promotePartial(Util.func_240982_a_("Carver: ", LOGGER::error)), IStringSerializable.createKeyable(GenerationStage.Carving.values())).fieldOf("carvers").forGetter((p_235078_0_) -> p_235078_0_.carvers), Codec.simpleMap(GenerationStage.Decoration.field_236076_k_, ConfiguredFeature.field_236264_b_.listOf().promotePartial(Util.func_240982_a_("Feature: ", LOGGER::error)), IStringSerializable.createKeyable(GenerationStage.Decoration.values())).fieldOf("features").forGetter((p_235076_0_) -> p_235076_0_.features), StructureFeature.field_236267_a_.listOf().promotePartial(Util.func_240982_a_("Structure start: ", LOGGER::error)).fieldOf("starts").forGetter((p_235075_0_) -> p_235075_0_.structures.values().stream().sorted(Comparator.comparing((p_235074_0_) -> Registry.STRUCTURE_FEATURE.getKey(p_235074_0_.field_236268_b_))).collect(Collectors.toList())), Codec.simpleMap(EntityClassification.CLASSIFICATION_CODEC, SpawnListEntry.SPAWN_LIST_ENTRY_CODEC.listOf().promotePartial(Util.func_240982_a_("Spawn data: ", LOGGER::error)), IStringSerializable.createKeyable(EntityClassification.values())).fieldOf("spawners").forGetter((p_235073_0_) -> p_235073_0_.spawns), Attributes.field_235104_a_.listOf().fieldOf("climate_parameters").forGetter((p_235070_0_) -> p_235070_0_.biomeAttributes), Codec.STRING.optionalFieldOf("parent").forGetter((p_235065_0_) -> Optional.ofNullable(p_235065_0_.parent))).apply(p_235064_0_, ModBiome::new));
    public static final Set<ModBiome> BIOMES = Sets.newHashSet();
    public static final ObjectIntIdentityMap<ModBiome> MUTATION_TO_BASE_ID_MAP = new ObjectIntIdentityMap<>();
    protected static final PerlinNoiseGenerator TEMPERATURE_NOISE = new PerlinNoiseGenerator(new SharedSeedRandom(1234L), ImmutableList.of(0));
    public static final PerlinNoiseGenerator INFO_NOISE = new PerlinNoiseGenerator(new SharedSeedRandom(2345L), ImmutableList.of(0));
    public Biome biome;
    @Nullable
    protected String translationKey;
    protected final float depth;
    protected final float scale;
    protected final float temperature;
    protected final float downfall;
    private final int skyColor;
    @Nullable
    public final String parent;
    protected final ConfiguredSurfaceBuilder<?> surfaceBuilder;
    protected final Category category;
    protected final RainType precipitation;
    protected final BiomeAmbience biomeAmbience;
    protected final Map<GenerationStage.Carving, List<ConfiguredCarver<?>>> carvers;
    protected final Map<GenerationStage.Decoration, List<ConfiguredFeature<?, ?>>> features;
    protected final List<ConfiguredFeature<?, ?>> flowers = Lists.newArrayList();
    private final Map<Structure<?>, StructureFeature<?, ?>> structures;
    public final Map<EntityClassification, List<Biome.SpawnListEntry>> spawns;
    private final Map<EntityType<?>, EntityDensity> field_235053_w_ = Maps.newHashMap();
    private final List<Attributes> biomeAttributes;
    private final ThreadLocal<Long2FloatLinkedOpenHashMap> field_225488_v = ThreadLocal.withInitial(() -> Util.make(() -> {
        Long2FloatLinkedOpenHashMap long2floatlinkedopenhashmap = new Long2FloatLinkedOpenHashMap(1024, 0.25F) {
            protected void rehash(int p_rehash_1_) {
            }
        };
        long2floatlinkedopenhashmap.defaultReturnValue(Float.NaN);
        return long2floatlinkedopenhashmap;
    }));

    @Nullable
    public static ModBiome getMutationForBiome(ModBiome modBiome, Biome biome) {
        return MUTATION_TO_BASE_ID_MAP.getByValue(Registry.BIOME.getId(biome));
    }

    public static <C extends ICarverConfig> ConfiguredCarver<C> createCarver(WorldCarver<C> carver, C config) {
        return new ConfiguredCarver<>(carver, config);
    }

    protected ModBiome(Builder biomeBuilder) {
        if (biomeBuilder.surfaceBuilder != null && biomeBuilder.precipitation != null && biomeBuilder.category != null && biomeBuilder.depth != null && biomeBuilder.scale != null && biomeBuilder.temperature != null && biomeBuilder.downfall != null && biomeBuilder.field_235096_j_ != null) {
            this.surfaceBuilder = biomeBuilder.surfaceBuilder;
            this.precipitation = biomeBuilder.precipitation;
            this.category = biomeBuilder.category;
            this.depth = biomeBuilder.depth;
            this.scale = biomeBuilder.scale;
            this.temperature = biomeBuilder.temperature;
            this.downfall = biomeBuilder.downfall;
            this.skyColor = this.calculateSkyColor();
            this.parent = biomeBuilder.parent;
            this.biomeAttributes = (List<Attributes>)(biomeBuilder.biomeAttributes != null ? biomeBuilder.biomeAttributes : ImmutableList.of());
            this.biomeAmbience = biomeBuilder.field_235096_j_;
            this.carvers = Maps.newHashMap();
            this.structures = Maps.newHashMap();
            this.features = Maps.newHashMap();

            for(GenerationStage.Decoration generationstage$decoration : GenerationStage.Decoration.values()) {
                this.features.put(generationstage$decoration, Lists.newArrayList());
            }

            this.spawns = Maps.newHashMap();

            for(EntityClassification entityclassification : EntityClassification.values()) {
                this.spawns.put(entityclassification, Lists.newArrayList());
            }

        } else {
            throw new IllegalStateException("You are missing parameters to build a proper biome for " + this.getClass().getSimpleName() + "\n" + biomeBuilder);
        }
    }

    /*private ModBiome(ModBiome.RainType rainType, ModBiome.Category category, float depth, float scale, float temperature, float downfall, BiomeAmbience biomeAmbience, int skyColor, ConfiguredSurfaceBuilder<?> surfaceBuilder, Map<GenerationStage.Carving, List<ConfiguredCarver<?>>> carvers, Map<GenerationStage.Decoration, List<ConfiguredFeature<?, ?>>> features, List<StructureFeature<?, ?>> structures, Map<EntityClassification, List<SpawnListEntry>> spawns, List<Attributes> biomeAttributes, Optional<String> parent) {
        super(rainType, category, depth, scale, temperature, downfall, biomeAmbience, skyColor, surfaceBuilder, carvers, features, structures, parent);
        this.precipitation = rainType;
        this.category = category;
        this.depth = depth;
        this.scale = scale;
        this.temperature = temperature;
        this.downfall = downfall;
        this.biomeAmbience = biomeAmbience;
        this.skyColor = skyColor;
        this.surfaceBuilder = surfaceBuilder;
        this.carvers = carvers;
        this.features = features;
        this.structures = structures.stream().collect(Collectors.toMap((p_235072_0_) -> p_235072_0_.field_236268_b_, Function.identity()));
        this.spawns = spawns;
        this.biomeAttributes = biomeAttributes;
        this.parent = parent.orElse(null);
        features.values().stream().flatMap(Collection::stream).filter((p_235067_0_) -> p_235067_0_.feature == Feature.DECORATED_FLOWER).forEach(this.flowers::add);
    }*/

    public boolean isMutation() {
        return this.parent != null;
    }

    private int calculateSkyColor() {
        float f = this.temperature;
        f = f / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    @OnlyIn(Dist.CLIENT)
    public int getSkyColor() {
        return this.skyColor;
    }

    public static class Builder extends Biome.Builder {
        @Nullable
        private ConfiguredSurfaceBuilder<?> surfaceBuilder;
        @Nullable
        private RainType precipitation;
        @Nullable
        private Category category;
        @Nullable
        private Float depth;
        @Nullable
        private Float scale;
        @Nullable
        private Float temperature;
        @Nullable
        private Float downfall;
        @Nullable
        private String parent;
        @Nullable
        private List<Biome.Attributes> biomeAttributes;
        @Nullable
        private BiomeAmbience field_235096_j_;

        public <SC extends ISurfaceBuilderConfig> ModBiome.Builder surfaceBuilder(SurfaceBuilder<SC> surfaceBuilderIn, SC surfaceBuilderConfigIn) {
            this.surfaceBuilder = new ConfiguredSurfaceBuilder<>(surfaceBuilderIn, surfaceBuilderConfigIn);
            return this;
        }

        public ModBiome.Builder surfaceBuilder(ConfiguredSurfaceBuilder<?> surfaceBuilderIn) {
            this.surfaceBuilder = surfaceBuilderIn;
            return this;
        }

        public ModBiome.Builder precipitation(RainType precipitationIn) {
            this.precipitation = precipitationIn;
            return this;
        }

        public ModBiome.Builder category(Category biomeCategory) {
            this.category = biomeCategory;
            return this;
        }

        public ModBiome.Builder depth(float depthIn) {
            this.depth = depthIn;
            return this;
        }

        public ModBiome.Builder scale(float scaleIn) {
            this.scale = scaleIn;
            return this;
        }

        public ModBiome.Builder temperature(float temperatureIn) {
            this.temperature = temperatureIn;
            return this;
        }

        public ModBiome.Builder downfall(float downfallIn) {
            this.downfall = downfallIn;
            return this;
        }

        public ModBiome.Builder parent(@Nullable String parentIn) {
            this.parent = parentIn;
            return this;
        }

        public ModBiome.Builder func_235098_a_(List<Biome.Attributes> p_235098_1_) {
            this.biomeAttributes = p_235098_1_;
            return this;
        }

        public ModBiome.Builder func_235097_a_(BiomeAmbience p_235097_1_) {
            this.field_235096_j_ = p_235097_1_;
            return this;
        }

        public String toString() {
            return "BiomeBuilder{\nsurfaceBuilder=" + this.surfaceBuilder + ",\nprecipitation=" + this.precipitation + ",\nbiomeCategory=" + this.category + ",\ndepth=" + this.depth + ",\nscale=" + this.scale + ",\ntemperature=" + this.temperature + ",\ndownfall=" + this.downfall + ",\nspecialEffects=" + this.field_235096_j_ + ",\nparent='" + this.parent + '\'' + "\n" + '}';
        }
    }

    public void addSpawn(EntityClassification type, Biome.SpawnListEntry spawnListEntry) {
        this.spawns.computeIfAbsent(type, k -> Lists.newArrayList()).add(spawnListEntry);
    }

    protected void func_235059_a_(EntityType<?> p_235059_1_, double p_235059_2_, double p_235059_4_) {
        this.field_235053_w_.put(p_235059_1_, new ModBiome.EntityDensity(p_235059_4_, p_235059_2_));
    }

    /**
     * Returns the correspondent list of the EnumCreatureType informed.
     * @return
     * /
    public List<SpawnListEntry> getSpawns(EntityClassification creatureType) {
        return this.spawns.computeIfAbsent(creatureType, k -> Lists.newArrayList());
    }*/

    /*@Nullable
    public ModBiome.EntityDensity func_235058_a_(EntityType<?> p_235058_1_) {
        return this.field_235053_w_.get(p_235058_1_);
    }

    public ModBiome.RainType getPrecipitation() {
        return this.precipitation;
    }*/

    /**
     * Checks to see if the rainfall level of the biome is extremely high
     * /
    public boolean isHighHumidity() {
        return this.getDownfall() > 0.85F;
    }

    /**
     * returns the chance a creature has to spawn.
     * /
    public float getSpawningChance() {
        return 0.1F;
    }

    /**
     * Gets the current temperature at the given location, based off of the default for this biome, the elevation of the
     * position, and {@linkplain #TEMPERATURE_NOISE} some random perlin noise.
     */
    public float getTemperatureRaw(BlockPos pos, Biome biome) {
        if (pos.getY() > 64) {
            float f = (float)(TEMPERATURE_NOISE.noiseAt((float)pos.getX() / 8.0F, (double)((float)pos.getZ() / 8.0F), false) * 4.0D);
            return biome.getDefaultTemperature() - (f + (float)pos.getY() - 64.0F) * 0.05F / 30.0F;
        } else {
            return biome.getDefaultTemperature();
        }
    }

    /*public final float getTemperature(BlockPos pos) {
        long i = pos.toLong();
        Long2FloatLinkedOpenHashMap long2floatlinkedopenhashmap = this.field_225488_v.get();
        float f = long2floatlinkedopenhashmap.get(i);
        if (!Float.isNaN(f)) {
            return f;
        } else {
            float f1 = this.getTemperatureRaw(pos);
            if (long2floatlinkedopenhashmap.size() == 1024) {
                long2floatlinkedopenhashmap.removeFirstFloat();
            }

            long2floatlinkedopenhashmap.put(i, f1);
            return f1;
        }
    }*/

    public boolean doesWaterFreeze(IWorldReader worldIn, BlockPos pos) {
        return this.doesWaterFreeze(worldIn, pos, true);
    }

    public boolean doesWaterFreeze(IWorldReader worldIn, BlockPos water, boolean mustBeAtEdge) {
        if (biome.getTemperature(water) >= 0.15F) {
            return false;
        } else {
            if (water.getY() >= 0 && water.getY() < 256 && worldIn.getLightFor(LightType.BLOCK, water) < 10) {
                BlockState blockstate = worldIn.getBlockState(water);
                FluidState fluidstate = worldIn.getFluidState(water);
                if (fluidstate.getFluid() == Fluids.WATER && blockstate.getBlock() instanceof FlowingFluidBlock) {
                    if (!mustBeAtEdge) {
                        return true;
                    }

                    boolean flag = worldIn.hasWater(water.west()) && worldIn.hasWater(water.east()) && worldIn.hasWater(water.north()) && worldIn.hasWater(water.south());
                    if (!flag) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean doesSnowGenerate(IWorldReader worldIn, BlockPos pos) {
        if (biome.getTemperature(pos) >= 0.15F) {
            return false;
        } else {
            if (pos.getY() >= 0 && pos.getY() < 256 && worldIn.getLightFor(LightType.BLOCK, pos) < 10) {
                BlockState blockstate = worldIn.getBlockState(pos);
                if (blockstate.isAir(worldIn, pos) && Blocks.SNOW.getDefaultState().isValidPosition(worldIn, pos)) {
                    return true;
                }
            }

            return false;
        }
    }

    public void addFeature(GenerationStage.Decoration decorationStage, ConfiguredFeature<?, ?> featureIn) {
        if (featureIn.feature == Feature.DECORATED_FLOWER) {
            this.flowers.add(featureIn);
        }

        this.features.get(decorationStage).add(featureIn);
    }

    public <C extends ICarverConfig> void addCarver(GenerationStage.Carving stage, ConfiguredCarver<C> carver) {
        this.carvers.computeIfAbsent(stage, (p_235071_0_) -> Lists.newArrayList()).add(carver);
    }

    public List<ConfiguredCarver<?>> getCarvers(GenerationStage.Carving stage) {
        return this.carvers.computeIfAbsent(stage, (p_235066_0_) -> Lists.newArrayList());
    }

    public void func_235063_a_(StructureFeature<?, ?> p_235063_1_) {
        this.structures.put(p_235063_1_.field_236268_b_, p_235063_1_);
    }

    public boolean hasStructure(Structure<?> structureIn) {
        return this.structures.containsKey(structureIn);
    }

    public Iterable<StructureFeature<?, ?>> func_235077_g_() {
        return this.structures.values();
    }

    public StructureFeature<?, ?> func_235068_b_(StructureFeature<?, ?> p_235068_1_) {
        return this.structures.getOrDefault(p_235068_1_.field_236268_b_, p_235068_1_);
    }

    public List<ConfiguredFeature<?, ?>> getFlowers() {
        return this.flowers;
    }

    public List<ConfiguredFeature<?, ?>> getFeatures(GenerationStage.Decoration decorationStage) {
        return this.features.get(decorationStage);
    }

    public void func_235061_a_(GenerationStage.Decoration p_235061_1_, StructureManager p_235061_2_, ChunkGenerator p_235061_3_, ISeedReader p_235061_4_, long p_235061_5_, SharedSeedRandom p_235061_7_, BlockPos p_235061_8_) {
        int i = 0;
        if (p_235061_2_.func_235005_a_()) {
            for(Structure<?> structure : Registry.STRUCTURE_FEATURE) {
                if (structure.func_236396_f_() == p_235061_1_) {
                    p_235061_7_.setFeatureSeed(p_235061_5_, i, p_235061_1_.ordinal());
                    int j = p_235061_8_.getX() >> 4;
                    int k = p_235061_8_.getZ() >> 4;
                    int l = j << 4;
                    int i1 = k << 4;

                    try {
                        p_235061_2_.func_235011_a_(SectionPos.from(p_235061_8_), structure).forEach((p_235060_8_) -> {
                            p_235060_8_.func_230366_a_(p_235061_4_, p_235061_2_, p_235061_3_, p_235061_7_, new MutableBoundingBox(l, i1, l + 15, i1 + 15), new ChunkPos(j, k));
                        });
                    } catch (Exception exception1) {
                        CrashReport crashreport = CrashReport.makeCrashReport(exception1, "Feature placement");
                        crashreport.makeCategory("Feature").addDetail("Id", Registry.STRUCTURE_FEATURE.getKey(structure)).addDetail("Description", () -> structure.toString());
                        throw new ReportedException(crashreport);
                    }

                    ++i;
                }
            }
        }

        for(ConfiguredFeature<?, ?> configuredfeature : this.features.get(p_235061_1_)) {
            p_235061_7_.setFeatureSeed(p_235061_5_, i, p_235061_1_.ordinal());

            try {
                configuredfeature.func_236265_a_(p_235061_4_, p_235061_2_, p_235061_3_, p_235061_7_, p_235061_8_);
            } catch (Exception exception) {
                CrashReport crashreport1 = CrashReport.makeCrashReport(exception, "Feature placement");
                crashreport1.makeCategory("Feature").addDetail("Id", Objects.requireNonNull(Registry.FEATURE.getKey(configuredfeature.feature))).addDetail("Config", configuredfeature.config).addDetail("Description", () -> configuredfeature.feature.toString());
                throw new ReportedException(crashreport1);
            }

            ++i;
        }

    }

    @OnlyIn(Dist.CLIENT)
    public int func_235080_i_() {
        return this.biomeAmbience.getFogColor();
    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(double posX, double posZ, Biome biome) {
        double d0 = MathHelper.clamp(biome.getDefaultTemperature(), 0.0F, 1.0F);
        double d1 = MathHelper.clamp(biome.getDownfall(), 0.0F, 1.0F);
        return GrassColors.get(d0, d1);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(Biome biome) {
        double d0 = MathHelper.clamp(biome.getDefaultTemperature(), 0.0F, 1.0F);
        double d1 = MathHelper.clamp(biome.getDownfall(), 0.0F, 1.0F);
        return FoliageColors.get(d0, d1);
    }

    /*public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
        this.surfaceBuilder.setSeed(seed);
        this.surfaceBuilder.buildSurface(random, chunkIn, this, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
    }*/

    public Biome.TempCategory getTempCategory(Biome biome) {
        if (this.category == com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.Category.OCEAN) {
            return Biome.TempCategory.OCEAN;
        } else if ((double)biome.getDefaultTemperature() < 0.2D) {
            return Biome.TempCategory.COLD;
        } else {
            return (double)biome.getDefaultTemperature() < 1.0D ? Biome.TempCategory.MEDIUM : Biome.TempCategory.WARM;
        }
    }

    //public final float getDepth() {
    //    return this.depth;
    //}

    /* *
     * Gets a floating point representation of this biome's rainfall
     */
    //public final float getDownfall() {
    //    return this.downfall;
   // }

    /*@OnlyIn(Dist.CLIENT)
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(this.getTranslationKey());
    }

    public String getTranslationKey(Biome biome) {
        if (this.translationKey == null) {
            this.translationKey = Util.makeTranslationKey("biome", Registry.BIOME.getKey(biome));
        }

        return this.translationKey;
    }* /

    public final float getScale() {
        return this.scale;
    }

    /**
     * Gets the constant default temperature for this biome.
     * /
    public final float getDefaultTemperature() {
        return this.temperature;
    }* /

    public BiomeAmbience func_235089_q_() {
        return this.biomeAmbience;
    }

    @OnlyIn(Dist.CLIENT)
    public final int getWaterColor() {
        return this.biomeAmbience.getWaterColor();
    }

    @OnlyIn(Dist.CLIENT)
    public final int getWaterFogColor() {
        return this.biomeAmbience.getWaterFogColor();
    }*/

    @OnlyIn(Dist.CLIENT)
    public Optional<ParticleEffectAmbience> getParticle() {
        return this.biomeAmbience.getParticle();
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<SoundEvent> getAmbientSound() {
        return this.biomeAmbience.getAmbientSound();
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<MoodSoundAmbience> getMoodSound() {
        return this.biomeAmbience.getMoodSound();
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<SoundAdditionsAmbience> getAdditionsSound() {
        return this.biomeAmbience.getAdditionsSound();
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<BackgroundMusicSelector> getMusic() {
        return this.biomeAmbience.getMusic();
    }

    /*public final ModBiome.Category getCategory() {
        return this.category;
    }*/

    public ConfiguredSurfaceBuilder<?> getSurfaceBuilder() {
        return this.surfaceBuilder;
    }

    public ISurfaceBuilderConfig getSurfaceBuilderConfig() {
        return this.surfaceBuilder.getConfig();
    }

    public Stream<ModBiome.Attributes> getBiomeAttributes() {
        return this.biomeAttributes.stream();
    }

    @Nullable
    public String getParent() {
        return this.parent;
    }

    public static class Attributes {
        public static final Codec<ModBiome.Attributes> field_235104_a_ = RecordCodecBuilder.create((p_235111_0_) -> {
            return p_235111_0_.group(Codec.FLOAT.fieldOf("temperature").forGetter((p_235116_0_) -> {
                return p_235116_0_.field_235105_b_;
            }), Codec.FLOAT.fieldOf("humidity").forGetter((p_235115_0_) -> {
                return p_235115_0_.field_235106_c_;
            }), Codec.FLOAT.fieldOf("altitude").forGetter((p_235114_0_) -> {
                return p_235114_0_.field_235107_d_;
            }), Codec.FLOAT.fieldOf("weirdness").forGetter((p_235113_0_) -> {
                return p_235113_0_.field_235108_e_;
            }), Codec.FLOAT.fieldOf("offset").forGetter((p_235112_0_) -> {
                return p_235112_0_.field_235109_f_;
            })).apply(p_235111_0_, com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.Attributes::new);
        });
        private final float field_235105_b_;
        private final float field_235106_c_;
        private final float field_235107_d_;
        private final float field_235108_e_;
        private final float field_235109_f_;

        public Attributes(float p_i231632_1_, float p_i231632_2_, float p_i231632_3_, float p_i231632_4_, float p_i231632_5_) {
            this.field_235105_b_ = p_i231632_1_;
            this.field_235106_c_ = p_i231632_2_;
            this.field_235107_d_ = p_i231632_3_;
            this.field_235108_e_ = p_i231632_4_;
            this.field_235109_f_ = p_i231632_5_;
        }

        public boolean equals(Object p_equals_1_) {
            if (this == p_equals_1_) {
                return true;
            } else if (p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
                ModBiome.Attributes biome$attributes = (ModBiome.Attributes)p_equals_1_;
                if (Float.compare(biome$attributes.field_235105_b_, this.field_235105_b_) != 0) {
                    return false;
                } else if (Float.compare(biome$attributes.field_235106_c_, this.field_235106_c_) != 0) {
                    return false;
                } else if (Float.compare(biome$attributes.field_235107_d_, this.field_235107_d_) != 0) {
                    return false;
                } else {
                    return Float.compare(biome$attributes.field_235108_e_, this.field_235108_e_) == 0;
                }
            } else {
                return false;
            }
        }

        public int hashCode() {
            int i = this.field_235105_b_ != 0.0F ? Float.floatToIntBits(this.field_235105_b_) : 0;
            i = 31 * i + (this.field_235106_c_ != 0.0F ? Float.floatToIntBits(this.field_235106_c_) : 0);
            i = 31 * i + (this.field_235107_d_ != 0.0F ? Float.floatToIntBits(this.field_235107_d_) : 0);
            return 31 * i + (this.field_235108_e_ != 0.0F ? Float.floatToIntBits(this.field_235108_e_) : 0);
        }

        public float func_235110_a_(ModBiome.Attributes p_235110_1_) {
            return (this.field_235105_b_ - p_235110_1_.field_235105_b_) * (this.field_235105_b_ - p_235110_1_.field_235105_b_) + (this.field_235106_c_ - p_235110_1_.field_235106_c_) * (this.field_235106_c_ - p_235110_1_.field_235106_c_) + (this.field_235107_d_ - p_235110_1_.field_235107_d_) * (this.field_235107_d_ - p_235110_1_.field_235107_d_) + (this.field_235108_e_ - p_235110_1_.field_235108_e_) * (this.field_235108_e_ - p_235110_1_.field_235108_e_) + (this.field_235109_f_ - p_235110_1_.field_235109_f_) * (this.field_235109_f_ - p_235110_1_.field_235109_f_);
        }
    }

    public Biome getRiver(Biome biome) {
        if (biome == Biomes.SNOWY_TUNDRA) return Biomes.FROZEN_RIVER;
        if (biome == Biomes.MUSHROOM_FIELDS || biome == Biomes.MUSHROOM_FIELD_SHORE) return Biomes.MUSHROOM_FIELD_SHORE;
        return Biomes.RIVER;
    }

    @Nullable
    public Biome getHill(net.minecraft.world.gen.INoiseRandom rand) {
        return null;
    }


    public enum Category implements IStringSerializable {
        NONE("none"),
        TAIGA("taiga"),
        EXTREME_HILLS("extreme_hills"),
        JUNGLE("jungle"),
        MESA("mesa"),
        PLAINS("plains"),
        SAVANNA("savanna"),
        ICY("icy"),
        THEEND("the_end"),
        BEACH("beach"),
        FOREST("forest"),
        OCEAN("ocean"),
        DESERT("desert"),
        RIVER("river"),
        SWAMP("swamp"),
        MUSHROOM("mushroom"),
        NETHER("nether");

        public static final Codec<ModBiome.Category> field_235102_r_ = IStringSerializable.createEnumCodec(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.Category::values, com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.Category::func_235103_a_);
        private static final Map<String, ModBiome.Category> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.Category::getName, (p_222353_0_) -> p_222353_0_));
        private final String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static ModBiome.Category func_235103_a_(String p_235103_0_) {
            return BY_NAME.get(p_235103_0_);
        }

        public String getString() {
            return this.name;
        }
    }

    public static class EntityDensity {
        private final double field_235117_a_;
        private final double field_235118_b_;

        public EntityDensity(double p_i231633_1_, double p_i231633_3_) {
            this.field_235117_a_ = p_i231633_1_;
            this.field_235118_b_ = p_i231633_3_;
        }

        public double func_235119_a_() {
            return this.field_235117_a_;
        }

        public double func_235120_b_() {
            return this.field_235118_b_;
        }
    }

    public enum RainType implements IStringSerializable {
        NONE("none"),
        RAIN("rain"),
        SNOW("snow");

        public static final Codec<ModBiome.RainType> RAIN_TYPE_CODEC = IStringSerializable.createEnumCodec(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.RainType::values, com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.RainType::getRainType);
        private static final Map<String, ModBiome.RainType> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.RainType::getName, (p_222360_0_) -> p_222360_0_));
        private final String name;

        RainType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static ModBiome.RainType getRainType(String name) {
            return BY_NAME.get(name);
        }

        public String getString() {
            return this.name;
        }
    }

    public static class SpawnListEntry extends WeightedRandom.Item {
        public static final Codec<SpawnListEntry> SPAWN_LIST_ENTRY_CODEC = RecordCodecBuilder.create((p_235125_0_) -> {
            return p_235125_0_.group(Registry.ENTITY_TYPE.fieldOf("type").forGetter((p_235128_0_) -> {
                return p_235128_0_.entityType;
            }), Codec.INT.fieldOf("weight").forGetter((p_235127_0_) -> {
                return p_235127_0_.itemWeight;
            }), Codec.INT.fieldOf("minCount").forGetter((p_235126_0_) -> {
                return p_235126_0_.minGroupCount;
            }), Codec.INT.fieldOf("maxCount").forGetter((p_235124_0_) -> {
                return p_235124_0_.maxGroupCount;
            })).apply(p_235125_0_, SpawnListEntry::new);
        });
        public final EntityType<?> entityType;
        public final int minGroupCount;
        public final int maxGroupCount;

        public SpawnListEntry(EntityType<?> entityTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
            super(weight);
            this.entityType = entityTypeIn.getClassification() == EntityClassification.MISC ? EntityType.PIG : entityTypeIn;
            this.minGroupCount = minGroupCountIn;
            this.maxGroupCount = maxGroupCountIn;
        }

        public String toString() {
            return EntityType.getKey(this.entityType) + "*(" + this.minGroupCount + "-" + this.maxGroupCount + "):" + this.itemWeight;
        }
    }

    public enum TempCategory {
        OCEAN("ocean"),
        COLD("cold"),
        MEDIUM("medium"),
        WARM("warm");

        private static final Map<String, ModBiome.TempCategory> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome.TempCategory::getName, (p_222356_0_) -> p_222356_0_));
        private final String name;

        private TempCategory(String nameIn) {
            this.name = nameIn;
        }

        public String getName() {
            return this.name;
        }
    }
}
