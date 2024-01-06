package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world.spawn.EntitySpawnPlacementRegistry;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.gen.Heightmap;

public class DefaultEntitySpawnPlacementRegistry extends EntitySpawnPlacementRegistry {

    public DefaultEntitySpawnPlacementRegistry() {
        register();
        heightmapType();
        placementType();
    }

    public void register() {
        EntitySpawnPlacementRegistry.register(EntityInit.SRACH_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
    }

    public void heightmapType() {
        getHeightmapType(com.babcsany.minecraft.ervin_mod_1.init.EntityInit.SRACH_ENTITY.get());
    }

    public void placementType() {
        getPlacementType(com.babcsany.minecraft.ervin_mod_1.init.EntityInit.SRACH_ENTITY.get());
    }
}
