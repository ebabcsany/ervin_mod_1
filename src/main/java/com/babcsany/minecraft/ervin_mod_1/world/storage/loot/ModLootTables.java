package com.babcsany.minecraft.ervin_mod_1.world.storage.loot;

import com.google.common.collect.Sets;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class ModLootTables {
   private static final Set<ResourceLocation> LOOT_TABLES = Sets.newHashSet();
   private static final Set<ResourceLocation> READ_ONLY_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);
   public static final ResourceLocation EMPTY = new ResourceLocation("empty");
   public static final ResourceLocation CHESTS_BURIED_TREASURE = register("ervin_mod_1:chests/buried_treasure");

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

   public static Set<ResourceLocation> func_215796_a() {
      return READ_ONLY_LOOT_TABLES;
   }
}