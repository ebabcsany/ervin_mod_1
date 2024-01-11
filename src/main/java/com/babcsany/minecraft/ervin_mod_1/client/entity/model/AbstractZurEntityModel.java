package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import net.minecraft.entity.CreatureEntity;

public class AbstractZurEntityModel<T extends CreatureEntity> extends AbstractZurModel_1<T> {
    public AbstractZurEntityModel(float modelSize, boolean p_i1168_2_) {
        this(modelSize, 0.0F, 64, p_i1168_2_ ? 32 : 64);
    }

    protected AbstractZurEntityModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
        super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
    }

    public boolean isAggressive(T entityIn) {
        return entityIn.isAggressive();
    }
}
