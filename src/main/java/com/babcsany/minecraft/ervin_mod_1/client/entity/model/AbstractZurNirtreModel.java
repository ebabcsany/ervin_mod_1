package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import net.minecraft.entity.AgeableEntity;

public class AbstractZurNirtreModel<T extends AgeableEntity> extends AbstractZurNirtreModel_1<T> {
    public AbstractZurNirtreModel(float modelSize, boolean p_i1168_2_) {
        this(modelSize, 0.0F, 64, p_i1168_2_ ? 32 : 64);
    }

    protected AbstractZurNirtreModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
        super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
    }
}
