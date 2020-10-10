package com.babcsany.minecraft.ervin_mod_1.world.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.placement.*;

public class Example0Biome extends Biome {
	public Example0Biome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
		//this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 5, 5, 20));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 30, 15, 40));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.SRACH_ENTITY.get(), 8, 8, 16));
		DefaultBiomeFeatures.func_235196_b_(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraGoldOre(this);
		DefaultBiomeFeatures.addExtraDefaultFlowers(this);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(this);
		ModDefaultBiomeFeatures.addOceanCarvers(this);
		ModDefaultBiomeFeatures.addStoneVariants(this);
		ModDefaultBiomeFeatures.addCarvers(this);
		ModDefaultBiomeFeatures.addEndCity(this);
		ModDefaultBiomeFeatures.addWaterLakes(this);
		ModBiomeFeatures.addExampleFeature(this, 1000);
		ModDefaultBiomeFeatures.addStones(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock(this);
		ModDefaultBiomeFeatures.addKiomne(this);
	}
	
	@Override
	public int getGrassColor(double posX, double posZ) {
		return 0xFF0e94;
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
