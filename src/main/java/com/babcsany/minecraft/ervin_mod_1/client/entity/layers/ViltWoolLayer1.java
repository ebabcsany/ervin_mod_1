package com.babcsany.minecraft.ervin_mod_1.client.entity.layers;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ViltEntityModel1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ViltWoolModel1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ViltEntity1;
import com.babcsany.minecraft.ervin_mod_1.init.init.DyeColorInit;
import com.babcsany.minecraft.ervin_mod_1.item.DyeColor1;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ViltWoolLayer1 extends LayerRenderer<ViltEntity1, ViltEntityModel1<ViltEntity1>> {
   public static final ResourceLocation TEXTURE = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/crask1_fur.png");
   public final ViltWoolModel1<ViltEntity1> viltModel = new ViltWoolModel1<>();

   public ViltWoolLayer1(IEntityRenderer<ViltEntity1, ViltEntityModel1<ViltEntity1>> rendererIn) {
      super(rendererIn);
   }

   @Override
   public void render(MatrixStack matrixStackIn, IRenderTypeBuffer buffer1In, int packedLightIn, ViltEntity1 entitylivingbase1In, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      if (!entitylivingbase1In.getSheared() && !entitylivingbase1In.isInvisible()) {
         float f;
         float f1;
         float f2;
         if (entitylivingbase1In.hasCustomName() && "jeb_".equals(entitylivingbase1In.getName().getUnformattedComponentText())) {
            int i1 = 25;
            int i = entitylivingbase1In.ticksExisted / 25 + entitylivingbase1In.getEntityId();
            int j = DyeColor1.values().length;
            int m = i % j;
            int t = (i + 1) % j;
            float f3 = ((float)(entitylivingbase1In.ticksExisted % 25) + partialTicks) / 25.0F;
            float[] afloat1 = ViltEntity1.getDyeRgb(DyeColorInit.byId(m));
            float[] afloat2 = ViltEntity1.getDyeRgb(DyeColorInit.byId(t));
            f = afloat1[0] * (1.0F - f3) + afloat2[0] * f3;
            f1 = afloat1[1] * (1.0F - f3) + afloat2[1] * f3;
            f2 = afloat1[2] * (1.0F - f3) + afloat2[2] * f3;
         } else {
            float[] afloat1 = ViltEntity1.getDyeRgb(entitylivingbase1In.getFleeceColor());
            f = afloat1[0];
            f1 = afloat1[1];
            f2 = afloat1[2];
         }

         renderCopyCutoutModel(this.getEntityModel(), this.viltModel, TEXTURE, matrixStackIn, buffer1In, packedLightIn, entitylivingbase1In, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, f, f1, f2);
      }
   }
}