package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CodModel;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GubrovRenderer extends MobRenderer<GubrovEntity, CodModel<GubrovEntity>> {
   private static final ResourceLocation GUBROV_LOCATION = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/fish/gubrov.png");

   public GubrovRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new CodModel<>(), 0.3F);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(GubrovEntity entity) {
      return GUBROV_LOCATION;
   }

   protected void applyRotations(GubrovEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
      super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
      float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
      if (!entityLiving.isInWater()) {
         matrixStackIn.translate((double)0.1F, (double)0.1F, (double)-0.1F);
         matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
      }

   }
}