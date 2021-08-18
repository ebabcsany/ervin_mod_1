package com.babcsany.minecraft.entity.ai.brain.memory;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.mojang.serialization.Codec;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.Optional;

public class ModMemoryModuleType {

    public static final MemoryModuleType<PiglinEntity> NEAREST_VISIBLE_BABY_ZUR = register("ervin_mod_1:nearest_visible_baby_zur");
    public static final MemoryModuleType<List<ZurEntity>> NEAREST_ADULT_ZURS = register("ervin_mod_1:nearest_adult_zurs");
    public static final MemoryModuleType<List<ZurEntity>> NEAREST_VISIBLE_ADULT_ZURS = register("ervin_mod_1:nearest_visible_adult_zurs");
    public static final MemoryModuleType<Integer> VISIBLE_ADULT_ZUR_COUNT = register("ervin_mod_1:visible_adult_zur_count");

    private static <U> MemoryModuleType<U> registerWithCodec(String identifier, Codec<U> codec) {
        return Registry.register(Registry.MEMORY_MODULE_TYPE, new ResourceLocation(identifier), new MemoryModuleType<>(Optional.of(codec)));
    }

    private static <U> MemoryModuleType<U> register(String identifier) {
        return Registry.register(Registry.MEMORY_MODULE_TYPE, new ResourceLocation(identifier), new MemoryModuleType<>(Optional.empty()));
    }
}
