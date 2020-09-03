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
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.placement.*;

public class ExampleBiome4 extends Biome {

	public ExampleBiome4(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.IRON_GOLEM, 50, 4, 50));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 40, 10, 20));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BAT, 30, 20, 40));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5120))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.MEGA_JUNGLE_TREE.withConfiguration(ModDefaultBiomeFeatures.MEGA_FIRG_TREE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(24))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.END_CITY.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(15))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NETHER_BRIDGE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceConfig(20))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.GRASS_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(1000))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM),
								Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
						.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_BROWN_MUSHROOM),
								Feature.ACACIA_TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_TREE_CONFIG)))
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(1, 0.25F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(1, 0.125F))));
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.ACACIA_TREE.withConfiguration(ModDefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withPlacement(
						Placement.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceConfig(25))));
		//this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
		//		Feature.NORMAL_TREE.withConfiguration(JazzTree.JAZZ_TREE_CONFIG).withPlacement(
		//				Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FANCY_TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(18, 4.8f, 10))));

		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraGoldOre(this);
		ModDefaultBiomeFeatures.addExtraBlackStone(this);
		ModDefaultBiomeFeatures.addExtraBlueStone(this);
		ModDefaultBiomeFeatures.addExtraBrownStone(this);
		ModDefaultBiomeFeatures.addExtraCyanStone(this);
		ModDefaultBiomeFeatures.addExtraGreenStone(this);
		ModDefaultBiomeFeatures.addExtraLightBlueStone(this);
		ModDefaultBiomeFeatures.addExtraLightGrayStone(this);
		ModDefaultBiomeFeatures.addExtraLimeStone(this);
		ModDefaultBiomeFeatures.addExtraMagentaStone(this);
		ModDefaultBiomeFeatures.addExtraOrangeStone(this);
		ModDefaultBiomeFeatures.addExtraPinkStone(this);
		ModDefaultBiomeFeatures.addExtraPurpleStone(this);
		ModDefaultBiomeFeatures.addExtraRedStone(this);
		ModDefaultBiomeFeatures.addExtraWhiteStone(this);
		ModDefaultBiomeFeatures.addExtraYellowStone(this);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock1(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock2(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock3(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock4(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock5(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock6(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock7(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock8(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock9(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock10(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock11(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock12(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock13(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock14(this);
		ModDefaultBiomeFeatures.addExtraVilktBlock15(this);
		ModBiomeFeatures.addExampleFeature(this, 10000);
		ModDefaultBiomeFeatures.addKiomne(this);
		ModDefaultBiomeFeatures.addStones(this);
		ModDefaultBiomeFeatures.addEndCity(this);
	}

	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
		return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
	}
	
	@Override
	public int getGrassColor(double posX, double posZ) {
		return 0xFF0000;
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
