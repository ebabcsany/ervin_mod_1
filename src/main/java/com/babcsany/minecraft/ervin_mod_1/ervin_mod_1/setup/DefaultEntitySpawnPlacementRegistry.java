package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world.spawn.EntitySpawnPlacementRegistry;
import com.babcsany.minecraft.init.EntityInit;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.world.gen.Heightmap;

public class DefaultEntitySpawnPlacementRegistry extends EntitySpawnPlacementRegistry {

    public DefaultEntitySpawnPlacementRegistry() {
        register();
        heightmapType();
        placementType();
    }

    public void register() {
        EntitySpawnPlacementRegistry.register(com.babcsany.minecraft.init.EntityInit.GUBROV, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(com.babcsany.minecraft.init.EntityInit.ROVENT_ENTITY, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RoventEntity::canRoventSpawn);
        EntitySpawnPlacementRegistry.register(com.babcsany.minecraft.init.EntityInit.SRACH_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZurEntity::canZurSpawn);
    }

    public void heightmapType() {
        getHeightmapType(EntityInit.SRACH_ENTITY);
        getHeightmapType(EntityInit.ZUR_ENTITY);
    }

    public void placementType() {
        getPlacementType(EntityInit.SRACH_ENTITY);
        getPlacementType(EntityInit.ZUR_ENTITY);
    }
}
