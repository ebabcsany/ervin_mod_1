package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.entity.AgeableEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractZurNirtreModel_1<T extends AgeableEntity> extends BipedModel<T> {
    protected AbstractZurNirtreModel_1(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
        super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, this.isAggressive(), this.swingProgress, ageInTicks);
    }

    public boolean isAggressive() {
        return false;
    }
}
