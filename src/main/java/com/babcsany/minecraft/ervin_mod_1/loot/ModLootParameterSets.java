package com.babcsany.minecraft.ervin_mod_1.loot;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModLootParameterSets {
    private static final BiMap<ResourceLocation, LootParameterSet> REGISTRY = HashBiMap.create();
    public static final LootParameterSet HUIHKING = register("huihking", (builder) -> {
        builder.required(LootParameters.ORIGIN).required(LootParameters.TOOL).optional(LootParameters.THIS_ENTITY);
        builder.optional(LootParameters.KILLER_ENTITY).optional(LootParameters.THIS_ENTITY); //Forge: Allow fisher, and bobber
    });



    private static LootParameterSet register(String registryName, Consumer<LootParameterSet.Builder> builderConsumer) {
        LootParameterSet.Builder lootparameterset$builder = new LootParameterSet.Builder();
        builderConsumer.accept(lootparameterset$builder);
        LootParameterSet lootparameterset = lootparameterset$builder.build();
        ResourceLocation resourcelocation = new ResourceLocation(registryName);
        LootParameterSet lootparameterset1 = REGISTRY.put(resourcelocation, lootparameterset);
        if (lootparameterset1 != null) {
            throw new IllegalStateException("Loot table parameter set " + resourcelocation + " is already registered");
        } else {
            return lootparameterset;
        }
    }
}
