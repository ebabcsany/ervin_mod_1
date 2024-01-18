package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
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
		/*this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(com.babcsany.minecraft.ervin_mod_1.init.EntityInit.SRACH_ENTITY.get(), 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.IRON_GOLEM, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WANDERING_TRADER, 1, 2, 5));
		this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CAT, 1, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 1, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.COD, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 1, 2, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 1, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SALMON, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.MOOSHROOM, 1, 2, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 10, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 1, 2, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 1, 2, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 1, 2, 10));*/
//		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 1, 1, 1));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.field_236240_b_, new ProbabilityConfig(0.2F)));
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
