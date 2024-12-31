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
    public static final Codec<SpawnListEntry> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Registry.ENTITY_TYPE.fieldOf("type").forGetter((spawner) -> {
            return spawner.type;
        }), Codec.INT.fieldOf("weight").forGetter((spawner) -> {
            return spawner.itemWeight;
        }), Codec.INT.fieldOf("minCount").forGetter((spawner) -> {
            return spawner.minCount;
        }), Codec.INT.fieldOf("maxCount").forGetter((spawner) -> {
            return spawner.maxCount;
        })).apply(builder, SpawnListEntry::new);
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
