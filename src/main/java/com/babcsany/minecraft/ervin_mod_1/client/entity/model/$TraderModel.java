package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;

public class $TraderModel<T extends $TraderEntity> extends Abstract$TraderModel<T> {
    public $TraderModel(float modelSize, boolean p_i1168_2_) {
        this(modelSize, 0.0F, 64, p_i1168_2_ ? 32 : 64);
    }

    protected $TraderModel(float p_i48914_1_, float p_i48914_2_, int p_i48914_3_, int p_i48914_4_) {
        super(p_i48914_1_, p_i48914_2_, p_i48914_3_, p_i48914_4_);
    }

    public boolean isAggressive(T entityIn) {
        return entityIn.isAggressive();
    }
}
