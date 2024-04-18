package com.babcsany.minecraft.ervin_mod_1.world.biome.spawn;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;

public class SpawnListEntry extends MobSpawnInfo.Spawners {
    public static final Codec<MobSpawnInfo.Spawners> CODEC = RecordCodecBuilder.create((p_242592_0_) -> {
        return p_242592_0_.group(Registry.ENTITY_TYPE.fieldOf("type").forGetter((p_242595_0_) -> {
            return p_242595_0_.type;
        }), Codec.INT.fieldOf("weight").forGetter((p_242594_0_) -> {
            return p_242594_0_.itemWeight;
        }), Codec.INT.fieldOf("minCount").forGetter((p_242593_0_) -> {
            return p_242593_0_.minCount;
        }), Codec.INT.fieldOf("maxCount").forGetter((p_242591_0_) -> {
            return p_242591_0_.maxCount;
        })).apply(p_242592_0_, MobSpawnInfo.Spawners::new);
    });
    public final EntityType<?> type;
    public final int minCount;
    public final int maxCount;

    public SpawnListEntry(EntityType<?> type, int weight, int minCount, int maxCount) {
        super(type, weight, minCount, maxCount);
        this.type = type.getClassification() == EntityClassification.MISC ? EntityType.PIG : type;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public String toString() {
        return EntityType.getKey(this.type) + "*(" + this.minCount + "-" + this.maxCount + "):" + this.itemWeight;
    }
}
