package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.FreinEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.GwurstEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ShertEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.DrurbFishEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;

public class ModEntitySpawnPlacementRegistry extends DefaultEntitySpawnPlacementRegistry {

    public ModEntitySpawnPlacementRegistry() {
        super();
        register();
        heightmapType();
        placementType();
    }

    public static void register() {
        registerNoRestrictionsNoLeaves(EntityInit.$_TRADER.get(), Abstract$TraderEntity::canSpawnOn);
        registerOnGroundNoLeaves(EntityInit.ROVENT_ENTITY.get(), MobEntity::canSpawnOn);
        registerNoRestrictionsNoLeaves(EntityInit.HHIJ.get(), HhijAnimalEntity::canAnimalSpawn);
        registerNoRestrictionsNoLeaves(EntityInit.FREIN.get(), FreinEntity::canFreinSpawn);
        registerNoRestrictionsNoLeaves(EntityInit.GUBROV.get(), GubrovEntity::canGubrovSpawn);
        registerNoRestrictionsNoLeaves(EntityInit.DGRURB.get(), DrurbFishEntity::canSpawnOn);
        registerNoRestrictionsNoLeaves(EntityInit.GWURST.get(), GwurstEntity::canAnimalSpawn);
        registerOnGroundNoLeaves(EntityInit.SHERT_ENTITY.get(), ShertEntity::canAnimalSpawn);
        registerNoRestrictionsNoLeaves(EntityInit.TRADER_NIRTRE_ENTITY.get(), MobEntity::canSpawnOn);
        registerOnGroundNoLeaves(EntityInit.VILT.get(), AnimalEntity::canAnimalSpawn);
        registerNoRestrictionsNoLeaves(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), MobEntity::canSpawnOn);
        registerNoRestrictionsNoLeaves(EntityInit.ZOMBIE_TRADER_ENTITY.get(), MobEntity::canSpawnOn);
//        EntitySpawnPlacementRegistry.register(EntityInit.NIRTRE_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        registerOnGroundNoLeaves(EntityInit.LIWRAY.get(), MobEntity::canSpawnOn);
        registerOnGroundNoLeaves(EntityInit.ZUR.get(), ZurEntity::canAnimalSpawn);
        Ervin_mod_1.register(ModEntitySpawnPlacementRegistry.class);
    }

    public void heightmapType() {
        getHeightmapType(EntityInit.VILT.get());
        getHeightmapType(EntityInit.LIWRAY.get());
    }

    public void placementType() {
        getPlacementType(EntityInit.VILT.get());
        getPlacementType(EntityInit.LIWRAY.get());
    }
}
