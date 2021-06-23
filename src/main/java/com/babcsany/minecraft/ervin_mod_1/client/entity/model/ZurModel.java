package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;

public class ZurModel extends AbstractZurEntityModel<ZurEntity> {
    public ZurModel() {
        this(0.0F, false);
    }

    public ZurModel(float modelSize, boolean p_i51066_2_) {
        super(modelSize, 0.0F, 64, p_i51066_2_ ? 32 : 64);
    }

    public boolean isAggressive(ZurEntity entityIn) {
        return false;
    }
}
