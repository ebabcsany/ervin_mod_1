package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class FreinEntity extends SlimeEntity {

   public FreinEntity(EntityType<? extends FreinEntity> p_i48552_1_, World p_i48552_2_) {
      super(p_i48552_1_, p_i48552_2_);
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MonsterEntity.func_234295_eP_();
   }

   public static boolean canFreinSpawn(EntityType<FreinEntity> p_223366_0_, IWorld p_223366_1_, SpawnReason p_223366_2_, BlockPos p_223366_3_, Random p_223366_4_) {
      if (p_223366_1_.getDifficulty() != Difficulty.PEACEFUL) {
         if (Objects.equals(p_223366_1_.func_242406_i(p_223366_3_), Optional.of(Biomes.SWAMP)) && p_223366_3_.getY() > 50 && p_223366_3_.getY() < 70 && p_223366_4_.nextFloat() < 0.5F && p_223366_4_.nextFloat() < p_223366_1_.getMoonFactor() && p_223366_1_.getLight(p_223366_3_) <= p_223366_4_.nextInt(8)) {
            return canSpawnOn(p_223366_0_, p_223366_1_, p_223366_2_, p_223366_3_, p_223366_4_);
         }

         if (!(p_223366_1_ instanceof ISeedReader)) {
            return false;
         }

         ChunkPos chunkpos = new ChunkPos(p_223366_3_);
         boolean flag = SharedSeedRandom.createSlimeChunkSpawningSeed(chunkpos.x, chunkpos.z, ((ISeedReader)p_223366_1_).getSeed(), 987234911L).nextInt(10) == 0;
         if (p_223366_4_.nextInt(10) == 0 && flag && p_223366_3_.getY() < 40) {
            return canSpawnOn(p_223366_0_, p_223366_1_, p_223366_2_, p_223366_3_, p_223366_4_);
         }
      }

      return false;
   }
}
