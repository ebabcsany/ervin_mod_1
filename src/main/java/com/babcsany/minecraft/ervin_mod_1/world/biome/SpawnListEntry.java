package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class SpawnListEntry extends WeightedRandom.Item {
    public static final Codec<Biome.SpawnListEntry> SPAWN_LIST_ENTRY_CODEC = RecordCodecBuilder.create((p_235125_0_) -> {
        return p_235125_0_.group(Registry.ENTITY_TYPE.fieldOf("type").forGetter((p_235128_0_) -> {
            return p_235128_0_.entityType;
        }), Codec.INT.fieldOf("weight").forGetter((p_235127_0_) -> {
            return p_235127_0_.itemWeight;
        }), Codec.INT.fieldOf("minCount").forGetter((p_235126_0_) -> {
            return p_235126_0_.minGroupCount;
        }), Codec.INT.fieldOf("maxCount").forGetter((p_235124_0_) -> {
            return p_235124_0_.maxGroupCount;
        })).apply(p_235125_0_, Biome.SpawnListEntry::new);
    });
    public final EntityType<?> entityType;
    public final int minGroupCount;
    public final int maxGroupCount;

    public SpawnListEntry(EntityType<?> entityTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
        super(weight);
        this.entityType = entityTypeIn.getClassification() == EntityClassification.MISC ? EntityType.PIG : entityTypeIn;
        this.minGroupCount = minGroupCountIn;
        this.maxGroupCount = maxGroupCountIn;
    }

    public String toString() {
        return EntityType.getKey(this.entityType) + "*(" + this.minGroupCount + "-" + this.maxGroupCount + "):" + this.itemWeight;
    }
}
