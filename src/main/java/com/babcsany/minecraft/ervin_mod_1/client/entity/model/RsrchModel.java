package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RsrchModel<T extends Entity> extends QuadrupedModel<T> {
   public RsrchModel() {
      super(1, 1.0F, true, 1.0F, 1.0F, 1.0F, 1.0F, 1);
      this.headModel = new ModelRenderer(this, 1, 1);
      this.headModel.addBox(1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
      this.headModel.setRotationPoint(1.0F, 1.0F, 1.0F);
      this.headModel.setTextureOffset(1, 1).addBox(1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
      this.headModel.setTextureOffset(1, 1).addBox(1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
      this.body = new ModelRenderer(this, 1, 1);
      this.body.addBox(1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
      this.body.setRotationPoint(1.0F, 1.0F, 1.0F);
      this.body.setTextureOffset(1, 1).addBox(1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
      --this.legBackRight.rotationPointX;
      ++this.legBackLeft.rotationPointX;
      this.legBackRight.rotationPointZ += 1.0F;
      this.legBackLeft.rotationPointZ += 1.0F;
      --this.legFrontRight.rotationPointX;
      ++this.legFrontLeft.rotationPointX;
      --this.legFrontRight.rotationPointZ;
      --this.legFrontLeft.rotationPointZ;
   }

   public ModelRenderer getHead() {
      return this.headModel;
   }
}