package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public class ScrafthBiome {
	public ScrafthBiome() {
		make(ModConfiguredSurfaceBuilders.SCRAFTH, ModSurfaceBuilder.SCRAFTH_CONFIG);
	}

	public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F configuredSurfaceBuilder, final C config) {
		return make(configuredSurfaceBuilder.builder.func_242929_a(config));
	}

	public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F configuredSurfaceBuilder) {
		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		spawnInfoBuilder.withSpawner(EntityClassification.MISC, new SpawnListEntry(EntityType.VILLAGER, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.MISC, new SpawnListEntry(EntityType.IRON_GOLEM, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WANDERING_TRADER, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CAT, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.COD, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SALMON, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.MOOSHROOM, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 2, 2, 10));
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON);
		biomeBuilder.withSurfaceBuilder(configuredSurfaceBuilder);

		ModDefaultBiomeFeatures.addExtraDirt(biomeBuilder);
		ModDefaultBiomeFeatures.addExtraScrafth(biomeBuilder);

		ambienceBuilder.setWaterColor(16777215);
		ambienceBuilder.setWaterFogColor(16777210);
		ambienceBuilder.setFogColor(1677241);
		ambienceBuilder.withSkyColor(ModBiomeMaker.getSkyColorWithTemperatureModifier(19.3F));
		ambienceBuilder.withGrassColor(10526880);
		builder.precipitation(Biome.RainType.SNOW);
		builder.scale(346.2F);
		builder.temperature(7.7F);
		builder.setEffects(ambienceBuilder.build());
		builder.withMobSpawnSettings(spawnInfoBuilder.build());
		builder.withGenerationSettings(biomeBuilder.build());
		builder.category(Biome.Category.THEEND);
		builder.downfall(0.5F);
		builder.depth(0.12F);

		return builder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
