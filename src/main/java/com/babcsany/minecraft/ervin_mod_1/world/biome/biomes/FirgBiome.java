package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class FirgBiome {

	public FirgBiome() {
		make(() -> ModConfiguredSurfaceBuilders.FIRG_SURFACE);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(com.babcsany.minecraft.ervin_mod_1.init.EntityInit.SRACH_ENTITY.get(), 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.IRON_GOLEM, 1, 2, 5));
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
		spawnInfoBuilder.withSpawner(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 10, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 1, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 1, 2, 10));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 1, 1, 1));
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON);

		ModDefaultBiomeFeatures.addExtraDirt(biomeBuilder);
		ModDefaultBiomeFeatures.addFirgTrees(biomeBuilder);
		ModDefaultBiomeFeatures.addFirgs(biomeBuilder);

		ambienceBuilder.setWaterColor(16777215);
		ambienceBuilder.setWaterFogColor(16777210);
		ambienceBuilder.setFogColor(1677241);
		ambienceBuilder.withGrassColor(0xC8C8C8);
		builder.precipitation(Biome.RainType.SNOW);
		builder.scale(166.8F);
		builder.temperature(0.5F);
		builder.setEffects(ambienceBuilder.build());
		builder.withGenerationSettings(biomeBuilder.build());
		builder.category(Biome.Category.THEEND);
		builder.downfall(1114.5F);
		builder.depth(0.12F);
		builder.withTemperatureModifier(Biome.TemperatureModifier.NONE);
		return builder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
