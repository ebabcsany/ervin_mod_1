package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;

import java.util.List;
import java.util.Map;

public class ModBiome {
    public Map<EntityClassification, List<Biome.SpawnListEntry>> spawns;
    public Biome biome;
    /*public ModBiome(Builder biomeBuilder, Map<EntityClassification, List<SpawnListEntry>> spawns) {
        super(biomeBuilder);
        //this.spawns = spawns;
        //this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 4, 1, 1));
        this.spawns = Maps.newHashMap();
    }*/

    public void addSpawn(EntityClassification type, Biome.SpawnListEntry spawnListEntry) {
        this.spawns.computeIfAbsent(type, k -> Lists.newArrayList()).add(spawnListEntry);
    }
}
