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
    public FreinEntity(EntityType<? extends SlimeEntity> p_i48552_1_, World p_i48552_2_) {
        super(p_i48552_1_, p_i48552_2_);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_();
    }

    public static boolean canFreinSpawn(EntityType<FreinEntity> frein, IWorld world, SpawnReason reason, BlockPos pos, Random randomIn) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            if (Objects.equals(world.func_242406_i(pos), Optional.of(Biomes.RIVER)) && pos.getY() > 50 && pos.getY() < 70 && randomIn.nextFloat() < 0.5F && randomIn.nextFloat() < world.getMoonFactor() && world.getLight(pos) <= randomIn.nextInt(8)) {
                return canSpawnOn(frein, world, reason, pos, randomIn);
            }

            if (!(world instanceof ISeedReader)) {
                return false;
            }

            ChunkPos chunkpos = new ChunkPos(pos);
            boolean flag = SharedSeedRandom.createSlimeChunkSpawningSeed(chunkpos.x, chunkpos.z, ((ISeedReader) world).getSeed(), 987234911L).nextInt(10) == 0;
            if (randomIn.nextInt(10) == 0 && flag && pos.getY() < 40) {
                return canSpawnOn(frein, world, reason, pos, randomIn);
            }
        }

        return false;
    }
}
