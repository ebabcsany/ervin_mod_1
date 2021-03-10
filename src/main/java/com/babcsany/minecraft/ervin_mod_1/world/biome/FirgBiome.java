package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class FirgBiome extends Biome {

	public FirgBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.MISC, new SpawnListEntry(EntityType.VILLAGER, 10, 2, 5));
		this.addSpawn(EntityClassification.MISC, new SpawnListEntry(EntityType.IRON_GOLEM, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WANDERING_TRADER, 10, 2, 5));
		this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CAT, 10, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.COD, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 2, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SALMON, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 10, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.MOOSHROOM, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.MOOSHROOM, 10, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 10, 2, 5));
		this.addSpawn(EntityClassification.MISC, new SpawnListEntry(EntityType.PLAYER, 10, 2, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.field_236240_b_, new ProbabilityConfig(0.02F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.7421563921F)));

		ModDefaultBiomeFeatures.addExtraDirt(this);
		ModDefaultBiomeFeatures.addFirgs(this);
	}

	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
		return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
	}
	
	@Override
	public int getGrassColor(double posX, double posZ) {
		return 0xC8C8C8;
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
