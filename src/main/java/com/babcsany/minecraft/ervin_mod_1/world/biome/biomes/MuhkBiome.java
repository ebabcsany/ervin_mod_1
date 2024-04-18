package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class MuhkBiome {
    public MuhkBiome() {
        make(() -> ModConfiguredSurfaceBuilders.MUHK_SURFACE);
    }

    public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder) {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        MobSpawnInfo.Builder spawners = new MobSpawnInfo.Builder();
        BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
        Biome.Builder biomeBuilder = new Biome.Builder();
        builder.withStructure(StructureFeatures.VILLAGE_PLAINS);
        builder.withStructure(StructureFeatures.PILLAGER_OUTPOST);
        DefaultBiomeFeatures.withBadlandsStructures(builder);
        builder.withStructure(StructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.withCavesAndCanyons(builder);
        DefaultBiomeFeatures.withLavaLakes(builder);
        DefaultBiomeFeatures.withMonsterRoom(builder);
        DefaultBiomeFeatures.withPlainGrassVegetation(builder);
        DefaultBiomeFeatures.withInfestedStone(builder);
        DefaultBiomeFeatures.withOverworldOres(builder);
        DefaultBiomeFeatures.withClayDisks(builder);
        DefaultBiomeFeatures.withBadlandsOakTrees(builder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(builder);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(builder);
        DefaultBiomeFeatures.withFrozenTopLayer(builder);
        spawners.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        spawners.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        spawners.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        spawners.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        spawners.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 5, 2, 6));
        spawners.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DONKEY, 1, 1, 3));
        spawners.withSpawner(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        ambienceBuilder.setWaterColor(13359760);
        ambienceBuilder.setWaterFogColor(-1563244);
        ambienceBuilder.setFogColor(16773130);
        ambienceBuilder.setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
        biomeBuilder.precipitation(Biome.RainType.RAIN);
        biomeBuilder.category(Biome.Category.PLAINS);
        biomeBuilder.depth(0.325F);
        biomeBuilder.scale(0.15F);
        biomeBuilder.temperature(0.1F);
        biomeBuilder.downfall(0.04F);
        biomeBuilder.setEffects(ambienceBuilder.build());
        biomeBuilder.withGenerationSettings(builder.withSurfaceBuilder(surfaceBuilder).build());
        return (biomeBuilder.build());
    }
}
