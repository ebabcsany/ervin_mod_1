package com.babcsany.minecraft.ervin_mod_1.client.entity.render.dgrurb;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.DrurbFishEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SalmonModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DrurgbkRenderer extends MobRenderer<DrurbFishEntity, SalmonModel<DrurbFishEntity>> {
   private static final ResourceLocation DRURGBK_LOCATION = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/dgrurb/fish/drurb.png");

   public DrurgbkRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SalmonModel<>(), 3F);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(DrurbFishEntity entity) {
      return DRURGBK_LOCATION;
   }

   protected void applyRotations(DrurbFishEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
      super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
      float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
      if (!entityLiving.isInWater()) {
         matrixStackIn.translate(0.1F, 0.1F, -0.1F);
         matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
      }

   }
}