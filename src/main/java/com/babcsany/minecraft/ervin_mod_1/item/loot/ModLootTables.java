package com.babcsany.minecraft.ervin_mod_1.item.loot;

import com.google.common.collect.Sets;
import net.minecraft.loot.LootTables;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class ModLootTables {
    private static final Set<ResourceLocation> LOOT_TABLES = LootTables.getReadOnlyLootTables();
    private static final Set<ResourceLocation> READ_ONLY_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);
    public static final ResourceLocation GAMEPLAY_HUIHK = register("gameplay/huihk");
    public static final ResourceLocation GAMEPLAY_HUIHK_JUNK = register("gameplay/huihk/junk");

    private static ResourceLocation register(String id) {
        return register(new ResourceLocation(id));
    }

    private static ResourceLocation register(ResourceLocation id) {
        if (LOOT_TABLES.add(id)) {
            return id;
        } else {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> getReadOnlyLootTables() {
        return READ_ONLY_LOOT_TABLES;
    }
}