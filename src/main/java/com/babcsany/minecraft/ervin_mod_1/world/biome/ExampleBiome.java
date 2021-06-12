package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class ExampleBiome extends Biome {

	public ExampleBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 30, 1, 20));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.LIWRAY.get(), 1, 1, 3));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.ROVENT_ENTITY.get(), 1, 1, 3));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY, 20, 1, 10));
		//this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityInit.GUBROV_ENTITY.get(), 1, 1, 4));
		//this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.FREIN_ENTITY.get(), 1, 0, 2));
		this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 40, 1, 20));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 2, 0, 2));
		ModDefaultBiomeFeatures.func_235197_c_(this);
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.field_236240_b_, new ProbabilityConfig(0.02F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.7421563921F)));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(64))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG3)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(120))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG2)
						.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(75))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG1)
						.withPlacement(Placement.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceConfig(100))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(50))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM),
								Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
						.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_GRINTH_MUSHROOM),
								Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_SCRAFTH_MUSHROOM)))
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								Feature.field_236291_c_.withConfiguration(ModDefaultBiomeFeatures.field_230136_t_),
								Feature.field_236291_c_.withConfiguration(ModDefaultBiomeFeatures.FRIM_TREE_CONFIG)))
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(1, 0.25F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.SCRAFTH_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(1, 0.25F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(1, 0.125F))));
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.field_236291_c_.withConfiguration(ModDefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withPlacement(
						Placement.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceConfig(10))));
		/*this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.field_236291_c_.withConfiguration(JazzTree.JAZZ_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));*/
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(45, 12.0f, 25))));

		ModDefaultBiomeFeatures.addOres(this);
		ModDefaultBiomeFeatures.addBlackIronOres(this);
		ModDefaultBiomeFeatures.addIronOres(this);
		ModDefaultBiomeFeatures.addRedIronOres(this);
		DefaultBiomeFeatures.addExtraGoldOre(this);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(this);
		ModBiomeFeatures.addExampleFeature(this, 1000);
		ModBiomeFeatures.addExampleRuinedPortalFeature(this, 10000);
		ModDefaultBiomeFeatures.addStones(this);
		ModDefaultBiomeFeatures.addKiomne(this);
		ModDefaultBiomeFeatures.addFirgTrees(this);
	}
	
	@Override
	public int getGrassColor(double posX, double posZ) {
		return 0xFF0000;
	}

}

//update mappings post command:
//gradlew --refresh-dependencies
