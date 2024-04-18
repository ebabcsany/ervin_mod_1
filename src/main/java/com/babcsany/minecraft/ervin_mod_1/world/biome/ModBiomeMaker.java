package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.biomes.*;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

import static com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders.*;

public class ModBiomeMaker {
    public static final Biome MIGV_BIOME = MigvBiome.make(() -> MIGV_SURFACE);
    public static final Biome RIFT_BIOME = makeRiftBiome(() -> ModConfiguredSurfaceBuilders.RIFT_SURFACE, 0.125F, 0.05F);
    public static final Biome BHJUIG_BIOME = TheBhjuigBiome.make(() -> BHJUIG_SURFACE);
    public static final Biome MIG_BIOME = MigBiome.make(() -> MIG_SURFACE);
    public static final Biome SRIUNK_VALLEY_BIOME = SriunkValleyBiome.make(() -> SRIUNK_VALLEY_SURFACE);
    public static final Biome EXAMPLE0_BIOME = Example0Biome.make(() -> EXAMPLE0_SURFACE);
    public static final Biome END0_BIOME = EndBiome0.make(() -> END_SURFACE0);
    public static final Biome EXAMPLE_BIOME = ExampleBiome.make(() -> EXAMPLE_SURFACE);
    public static final Biome EXAMPLE_BIOME1 = ExampleBiome1.make(() -> EXAMPLE_SURFACE1);
    public static final Biome EXAMPLE_BIOME2 = ExampleBiome2.make(() -> EXAMPLE_SURFACE2);
    public static final Biome EXAMPLE_BIOME3 = ExampleBiome3.make(() -> EXAMPLE_SURFACE3);
    public static final Biome EXAMPLE_BIOME4 = ExampleBiome4.make(() -> EXAMPLE_SURFACE4);
    public static final Biome EXAMPLE_BIOME5 = ExampleBiome5.make(() -> EXAMPLE_SURFACE5);
    public static final Biome EXAMPLE_BIOME6 = ExampleBiome6.make(() -> EXAMPLE_SURFACE6);
    public static final Biome MUHK_BIOME = MuhkBiome.make(() -> MUHK_SURFACE);
    public static final Biome SCRAFTH_BIOME = ScrafthBiome.make(() -> SCRAFTH_SURFACE);
    public static final Biome FIRG_BIOME = FirgBiome.make(() -> FIRG_SURFACE);
    public static final Biome TWUST_BIOME = TwustBiome.make(() -> TWUST_SURFACE);
    public static final RegistryKey<Biome> RIFT_BIOME_KEY = registerBiome("rift_biome");
    public static final RegistryKey<Biome> BHJUIG_BIOME_KEY = registerBiome("bhjuig_biome");
    public static final RegistryKey<Biome> MIG_BIOME_KEY = registerBiome("mig_biome");
    public static final RegistryKey<Biome> MUHK_BIOME_KEY = registerBiome("muhk_biome");

    private static int getSkyColorWithTemperatureModifier(float p_244206_0_) {
        float lvt_1_1_ = p_244206_0_ / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome makeRiftBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
        DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.BLAZE, 100, 7, 10));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.ZOMBIFIED_PIGLIN, 50, 4, 4));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);

        biomegenerationsettings$builder.withStructure(StructureFeatures.MINESHAFT);
        biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL_SWAMP);
        biomegenerationsettings$builder.withStructure(StructureFeatures.BURIED_TREASURE);

        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);

        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withClayDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDesertVegetation(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);

        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);

        return (new Biome.Builder())
                .precipitation(Biome.RainType.SNOW)
                .category(Biome.Category.DESERT)
                .depth(depth)
                .scale(scale)
                .temperature(1.5F)
                .downfall(0.9F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(-3407872)
                        .setWaterFogColor(-16777216)
                        .setFogColor(-65536)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.8F))
                        .withFoliageColor(-3407872)
                        .withGrassColor(-3407872)
                        .setParticle(new ParticleEffectAmbience(ParticleTypes.LAVA, 0.003F))
                        .withSkyColor(-65536)
                        .setAmbientSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                        .setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0F))
                        .setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D))
                        .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST))
                        .build()
                )
                .withMobSpawnSettings(mobspawninfo$builder.build())
                .withGenerationSettings(biomegenerationsettings$builder.build())
                .build();
    }

    private static Biome makeGenericOceanBiome(MobSpawnInfo.Builder mobSpawnInfoBuilder, int waterColor, int waterFogColor, boolean isDepth, BiomeGenerationSettings.Builder biomeGenerationSettingsBuilder) {
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(isDepth ? -1.8F : -1.0F).scale(0.1F).temperature(0.5F).downfall(0.5F).setEffects((new BiomeAmbience.Builder()).setWaterColor(waterColor).setWaterFogColor(waterFogColor).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.5F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobSpawnInfoBuilder.build()).withGenerationSettings(biomeGenerationSettingsBuilder.build()).build();
    }

    private static RegistryKey<Biome> registerBiome(String name) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID, name));
    }
}
