package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class Example0Biome {
	public Example0Biome() {
		make(() -> ModConfiguredSurfaceBuilders.EXAMPLE0_SURFACE);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		generationSettingsBuilder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 5, 5, 20));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 30, 15, 40));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.SRACH_ENTITY.get(), 8, 8, 16));
		DefaultBiomeFeatures.withOceanStructures(generationSettingsBuilder);
		DefaultBiomeFeatures.withOverworldOres(generationSettingsBuilder);
		DefaultBiomeFeatures.withExtraGoldOre(generationSettingsBuilder);
		DefaultBiomeFeatures.withDefaultFlowers(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(generationSettingsBuilder);
		DefaultBiomeFeatures.withOceanCavesAndCanyons(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addStoneVariants(generationSettingsBuilder);
		DefaultBiomeFeatures.withCavesAndCanyons(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addEndCity(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addWaterLakes(generationSettingsBuilder);
		ModBiomeFeatures.addExampleFeature(generationSettingsBuilder, 1000);
		ModDefaultBiomeFeatures.addStones(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraVilktBlock(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addKiomne(generationSettingsBuilder);
		DefaultBiomeFeatures.withFrozenTopLayer(generationSettingsBuilder);
		ambienceBuilder.setWaterColor(46724639);
		ambienceBuilder.setWaterFogColor(46769357);
		ambienceBuilder.setFogColor(4253846);
		ambienceBuilder.withGrassColor(0xFF0e94);
		builder.precipitation(Biome.RainType.SNOW);
		builder.scale(121.2F);
		builder.temperature(5.5F);
		builder.setEffects(ambienceBuilder.build());
		builder.category(Biome.Category.RIVER);
		builder.downfall(5.5F);
		builder.depth(12.12F);
		return builder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
