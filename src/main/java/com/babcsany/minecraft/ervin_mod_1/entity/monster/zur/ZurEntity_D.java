package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ZurEntity_D extends AbstractZurEntity {
    public ServerPlayNetHandler connection;
    public ZurEntity_D(EntityType<? extends ZurEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public void applyWaveBonus(int p_213660_1_, boolean p_213660_2_) {

    }

    @Nullable
    @Override
    public AgeableZurEntity createChild(AgeableZurEntity ageable) {
        return null;
    }

    @Override
    protected void populateTradeZurData() {

    }
}
