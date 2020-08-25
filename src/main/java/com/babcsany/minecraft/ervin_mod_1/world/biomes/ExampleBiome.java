package com.babcsany.minecraft.ervin_mod_1.world.biomes;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.SrachEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ViltEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.WolfEntity1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ZurEntity1;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.JazzTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.fml.RegistryObject;

public class ExampleBiome extends Biome {

	private static final EntityType<ZurEntity> ZUR_ENTITY = register("zur_entity", EntityType.Builder.<ZurEntity>create(ZurEntity::new, EntityClassification.MONSTER).size(0.9F, 1.95F));
	private static final EntityType<ZurEntity1> ZUR_ENTITY1 = register("zur_entity1", EntityType.Builder.<ZurEntity1>create(ZurEntity1::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	private static final EntityType<ViltEntity> VILT_ENTITY = register("vilt_entity", EntityType.Builder.<ViltEntity>create(ViltEntity::new, EntityClassification.CREATURE).size(1.0F, 2.0F));
	private static final EntityType<SrachEntity> SRACH_ENTITY = register("srach_entity", EntityType.Builder.<SrachEntity>create(SrachEntity::new, EntityClassification.CREATURE).size(0.9F, 1.4F));

	public ExampleBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
		//this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(ZUR_ENTITY, 5, 5, 20));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(ZUR_ENTITY1, 15, 10, 30));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(VILT_ENTITY, 30, 15, 40));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(SRACH_ENTITY, 8, 8, 16));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.02F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.7421563921F)));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FANCY_TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG3)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(240))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FANCY_TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG2)
						.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(150))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FANCY_TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG1)
						.withPlacement(Placement.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceConfig(200))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FANCY_TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(100))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM),
								Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
						.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								Feature.FANCY_TREE.withConfiguration(ModDefaultBiomeFeatures.field_230136_t_),
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
						Placement.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceConfig(250))));
		//this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
		//		Feature.NORMAL_TREE.withConfiguration(JazzTree.JAZZ_TREE_CONFIG).withPlacement(
		//				Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FANCY_TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(18, 4.8f, 10))));

		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraGoldOre(this);
		DefaultBiomeFeatures.addExtraEmeraldOre(this);
		ModBiomeFeatures.addExampleFeature(this, 1000);
		ModDefaultBiomeFeatures.addKiomne(this);
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
