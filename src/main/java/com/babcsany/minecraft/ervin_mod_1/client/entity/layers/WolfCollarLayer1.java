package com.babcsany.minecraft.ervin_mod_1.client.entity.layers;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.WolfModel1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.WolfEntity1;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.WolfModel;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WolfCollarLayer1 extends LayerRenderer<WolfEntity1, WolfModel1<WolfEntity1>> {
   private static final ResourceLocation WOLF_COLLAR = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/srach/shert.png");

   public WolfCollarLayer1(IEntityRenderer<WolfEntity1, WolfModel1<WolfEntity1>> rendererIn) {
      super(rendererIn);
   }

   public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, WolfEntity1 entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      if (entitylivingbaseIn.isTamed() && !entitylivingbaseIn.isInvisible()) {
         float[] afloat = entitylivingbaseIn.getCollarColor().getColorComponentValues();
         renderCutoutModel(this.getEntityModel(), WOLF_COLLAR, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, afloat[0], afloat[1], afloat[2]);
      }
   }
}