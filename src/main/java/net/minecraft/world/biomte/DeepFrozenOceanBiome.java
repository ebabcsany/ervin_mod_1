package net.minecraft.world.biomte;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class DeepFrozenOceanBiome extends Biome {
   protected static final PerlinNoiseGenerator noiseGenerator = new PerlinNoiseGenerator(new SharedSeedRandom(3456L), ImmutableList.of(-2, -1, 0));

   public DeepFrozenOceanBiome() {
      super((new Builder()).surfaceBuilder(SurfaceBuilder.FROZEN_OCEAN, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(RainType.RAIN).category(Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(3750089).setWaterFogColor(329011).setFogColor(12638463).setMoodSound(MoodSoundAmbience.field_235027_b_).build()).parent((String)null));
      this.func_235063_a_(DefaultBiomeFeatures.OCEAN_MONUMENT_COLD);
      this.func_235063_a_(DefaultBiomeFeatures.MONUMENT);
      DefaultBiomeFeatures.func_235197_c_(this);
      this.func_235063_a_(DefaultBiomeFeatures.RUINED_PORTAL_OCEAN);
      DefaultBiomeFeatures.addOceanCarvers(this);
      DefaultBiomeFeatures.addLakes(this);
      DefaultBiomeFeatures.addIcebergs(this);
      DefaultBiomeFeatures.addMonsterRooms(this);
      DefaultBiomeFeatures.addBlueIce(this);
      DefaultBiomeFeatures.addStoneVariants(this);
      DefaultBiomeFeatures.addOres(this);
      DefaultBiomeFeatures.addSedimentDisks(this);
      DefaultBiomeFeatures.addScatteredOakTrees(this);
      DefaultBiomeFeatures.addDefaultFlowers(this);
      DefaultBiomeFeatures.addSparseGrass(this);
      DefaultBiomeFeatures.addMushrooms(this);
      DefaultBiomeFeatures.addReedsAndPumpkins(this);
      DefaultBiomeFeatures.addSprings(this);
      DefaultBiomeFeatures.addFreezeTopLayer(this);
      ModDefaultBiomeFeatures.addStones(this);
      this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SQUID, 1, 1, 4));
      this.addSpawn(EntityClassification.WATER_AMBIENT, new SpawnListEntry(EntityType.SALMON, 15, 1, 5));
      this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.POLAR_BEAR, 1, 1, 2));
      this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.DROWNED, 5, 1, 1));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
      this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
   }

   /**
    * Gets the current temperature at the given location, based off of the default for this biome, the elevation of the
    * position, and {@linkplain #TEMPERATURE_NOISE} some random perlin noise.
    */
   public float getTemperatureRaw(BlockPos pos) {
      float f = this.getDefaultTemperature();
      double d0 = noiseGenerator.noiseAt((double)pos.getX() * 0.05D, (double)pos.getZ() * 0.05D, false) * 7.0D;
      double d1 = INFO_NOISE.noiseAt((double)pos.getX() * 0.2D, (double)pos.getZ() * 0.2D, false);
      double d2 = d0 + d1;
      if (d2 < 0.3D) {
         double d3 = INFO_NOISE.noiseAt((double)pos.getX() * 0.09D, (double)pos.getZ() * 0.09D, false);
         if (d3 < 0.8D) {
            f = 0.2F;
         }
      }

      if (pos.getY() > 64) {
         float f1 = (float)(TEMPERATURE_NOISE.noiseAt((double)((float)pos.getX() / 8.0F), (double)((float)pos.getZ() / 8.0F), false) * 4.0D);
         return f - (f1 + (float)pos.getY() - 64.0F) * 0.05F / 30.0F;
      } else {
         return f;
      }
   }
}