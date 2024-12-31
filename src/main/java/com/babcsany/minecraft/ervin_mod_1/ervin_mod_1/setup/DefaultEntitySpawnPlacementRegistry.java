package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world.spawn.EntitySpawnPlacementRegistry;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;

public class DefaultEntitySpawnPlacementRegistry extends EntitySpawnPlacementRegistry {

    public DefaultEntitySpawnPlacementRegistry() {
        super();
        register();
        heightmapType();
        placementType();
    }

    public static void register() {
        registerOnGroundNoLeaves(EntityInit.SRACH_ENTITY.get(), AnimalEntity::canAnimalSpawn);
    }

    public void heightmapType() {
        getHeightmapType(EntityInit.SRACH_ENTITY.get());
    }

    public void placementType() {
        getPlacementType(EntityInit.SRACH_ENTITY.get());
    }
}
