package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.world.World;

public class NirtreEntity extends VillagerEntity {
    public NirtreEntity(EntityType<? extends VillagerEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public NirtreEntity(EntityType<? extends VillagerEntity> type, World worldIn, VillagerType villagerType) {
        super(type, worldIn, villagerType);
    }
}
