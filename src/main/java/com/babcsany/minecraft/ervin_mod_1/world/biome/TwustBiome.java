package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import com.babcsany.minecraft.init.BlockInit;
import com.babcsany.minecraft.init.BlockItemInit;
import com.babcsany.minecraft.init.FeatureInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class TwustBiome extends Biome {

	public TwustBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(2.64353268137F)));
		ModDefaultBiomeFeatures.addExtraDirt(this);
		//ModDefaultBiomeFeatures.addFeature(this, GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.WATER, BlockInit.FIRT_BLOCK.getDefaultState(), 30)));
	}
	
	@Override
	public int getGrassColor(double posX, double posZ) {
		return 0xe0c0a0;
	}
}

//update mappings post command:
//gradlew --refresh-dependencies