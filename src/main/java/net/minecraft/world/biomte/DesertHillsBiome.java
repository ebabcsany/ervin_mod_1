package net.minecraft.world.biomte;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public final class DesertHillsBiome extends Biome {
   public DesertHillsBiome() {
      super((new Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG).precipitation(RainType.NONE).category(Category.DESERT).depth(0.45F).scale(0.3F).temperature(2.0F).downfall(0.0F).func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).setMoodSound(MoodSoundAmbience.field_235027_b_).build()).parent((String)null));
      this.func_235063_a_(DefaultBiomeFeatures.DESERT_PYRAMID);
      DefaultBiomeFeatures.func_235196_b_(this);
      this.func_235063_a_(DefaultBiomeFeatures.RUINED_PORTAL_DESERT);
      DefaultBiomeFeatures.addCarvers(this);
      DefaultBiomeFeatures.addDesertLakes(this);
      DefaultBiomeFeatures.addMonsterRooms(this);
      DefaultBiomeFeatures.addStoneVariants(this);
      DefaultBiomeFeatures.addOres(this);
      DefaultBiomeFeatures.addSedimentDisks(this);
      DefaultBiomeFeatures.addDefaultFlowers(this);
      DefaultBiomeFeatures.addSparseGrass(this);
      DefaultBiomeFeatures.addDeadBushes(this);
      DefaultBiomeFeatures.addMushrooms(this);
      DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
      DefaultBiomeFeatures.addSprings(this);
      DefaultBiomeFeatures.addDesertFeatures(this);
      DefaultBiomeFeatures.addFreezeTopLayer(this);
      ModDefaultBiomeFeatures.addStones(this);
      this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
      this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 19, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 80, 4, 4));
   }
}