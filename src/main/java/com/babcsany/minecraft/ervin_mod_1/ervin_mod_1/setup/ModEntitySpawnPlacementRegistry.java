package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.FreinEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ShertEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world.spawn.EntitySpawnPlacementRegistry;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.gen.Heightmap;

public class ModEntitySpawnPlacementRegistry extends EntitySpawnPlacementRegistry {

    public ModEntitySpawnPlacementRegistry() {
        register();
        heightmapType();
        placementType();
    }

    public void register() {
        EntitySpawnPlacementRegistry.register(EntityInit.$_TRADER_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Abstract$TraderEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.FREIN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FreinEntity::canFreinSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.HHIJ_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HhijAnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.SHERT_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ShertEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.TRADER_NIRTRE_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.VILT_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
//        EntitySpawnPlacementRegistry.register(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.ZOMBIE_TRADER_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
//        EntitySpawnPlacementRegistry.register(EntityInit.NIRTRE_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.LIWRAY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
    }

    public void heightmapType() {
        getHeightmapType(EntityInit.VILT_ENTITY);
        getHeightmapType(EntityInit.LIWRAY);
    }

    public void placementType() {
        getPlacementType(EntityInit.VILT_ENTITY);
        getPlacementType(EntityInit.LIWRAY);
    }
}
