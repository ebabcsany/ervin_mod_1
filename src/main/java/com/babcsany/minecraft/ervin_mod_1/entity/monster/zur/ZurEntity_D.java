package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.world.iorld;

public class ZurEntity_D extends ZurEntity {
    public ServerPlayNetHandler connection;
    public ZurEntity_D(EntityType<? extends ZurEntity> type, iorld worldIn) {
        super(type, worldIn);
    }
}
