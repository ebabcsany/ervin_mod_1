package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.AbstractDgrurbkEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.Dgrurbk;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractDgrurbkModel<T extends Dgrurbk> extends BipedModel<T> {
   protected AbstractDgrurbkModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
      super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
   }

   /**
    * Sets this entity's model rotation angles
    */
   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
      ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, this.isAggressive(entityIn), this.swingProgress, ageInTicks);
   }

   public abstract boolean isAggressive(T entityIn);
}