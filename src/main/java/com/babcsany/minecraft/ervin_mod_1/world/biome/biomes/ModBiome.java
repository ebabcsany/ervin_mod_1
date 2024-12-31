package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

public class ModBiome {
    private final Biome.Builder builder;

    public ModBiome(final Biome.RainType precipitationIn,
                    final Biome.Category biomeCategory,
                    final float depthIn,
                    final float scaleIn,
                    final float temperatureIn,
                    final Biome.TemperatureModifier temperatureSettings,
                    final float downfallIn,
                    final BiomeAmbience effects,
                    final BiomeGenerationSettings generationSettings,
                    final MobSpawnInfo mobSpawnSettings) {
        Biome.Builder builder = new Biome.Builder();
        builder.precipitation(precipitationIn);
        builder.category(biomeCategory);
        builder.depth(depthIn);
        builder.scale(scaleIn);
        builder.temperature(temperatureIn);
        builder.withTemperatureModifier(temperatureSettings);
        builder.downfall(downfallIn);
        builder.setEffects(effects);
        builder.withGenerationSettings(generationSettings);
        builder.withMobSpawnSettings(mobSpawnSettings);
        this.builder = builder;
    }

    public ModBiome() {
        this.builder = new Biome.Builder();
    }

    public static void addSpawner(MobSpawnInfo.Builder builder, ModSpawnerType modSpawnerTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
        builder.withSpawner(modSpawnerTypeIn.classification, new SpawnListEntry(modSpawnerTypeIn.type, weight, minGroupCountIn, maxGroupCountIn));
    }

    public static Biome make(final Biome.RainType precipitationIn,
                             final Biome.Category biomeCategory,
                             final float depthIn,
                             final float scaleIn,
                             final float temperatureIn,
                             final Biome.TemperatureModifier temperatureSettings,
                             final float downfallIn,
                             final BiomeAmbience effects,
                             final BiomeGenerationSettings generationSettings,
                             final MobSpawnInfo mobSpawnSettings) {
        Biome.Builder builder = new Biome.Builder();
        builder.precipitation(precipitationIn);
        builder.category(biomeCategory);
        builder.depth(depthIn);
        builder.scale(scaleIn);
        builder.temperature(temperatureIn);
        builder.withTemperatureModifier(temperatureSettings);
        builder.downfall(downfallIn);
        builder.setEffects(effects);
        builder.withGenerationSettings(generationSettings);
        builder.withMobSpawnSettings(mobSpawnSettings);
        return builder.build();
    }

    public Biome build(final Biome.RainType precipitationIn,
                       final Biome.Category biomeCategory,
                       final float depthIn,
                       final float scaleIn,
                       final float temperatureIn,
                       final Biome.TemperatureModifier temperatureSettings,
                       final float downfallIn,
                       final BiomeAmbience effects,
                       final BiomeGenerationSettings generationSettings,
                       final MobSpawnInfo mobSpawnSettings) {
        this.builder.precipitation(precipitationIn);
        this.builder.category(biomeCategory);
        this.builder.depth(depthIn);
        this.builder.scale(scaleIn);
        this.builder.temperature(temperatureIn);
        this.builder.withTemperatureModifier(temperatureSettings);
        this.builder.downfall(downfallIn);
        this.builder.setEffects(effects);
        this.builder.withGenerationSettings(generationSettings);
        this.builder.withMobSpawnSettings(mobSpawnSettings);
        return this.builder.build();
    }

    public Biome build() {
        return this.builder.build();
    }

    public enum ModSpawnerType {
        GUBROV(EntityClassification.WATER_CREATURE, EntityInit.GUBROV.get()),
        SRACH(EntityClassification.CREATURE, EntityInit.SRACH_ENTITY.get()),
        GWURST(EntityClassification.CREATURE, EntityInit.GWURST.get()),
        FREIN(EntityClassification.MONSTER, EntityInit.FREIN.get()),
        LIWRAY(EntityClassification.CREATURE, EntityInit.LIWRAY.get()),
        ZUR(EntityClassification.CREATURE, EntityInit.ZUR.get());

        private final EntityClassification classification;
        private final EntityType<?> type;

        ModSpawnerType(EntityClassification classification, EntityType<?> type) {
            this.classification = classification;
            this.type = type;
        }

        public EntityClassification getClassification() {
            return classification;
        }

        public EntityType<?> getType() {
            return type;
        }
    }
}
