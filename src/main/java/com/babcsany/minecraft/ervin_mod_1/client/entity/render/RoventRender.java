package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.layers.RoventOuterLayer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.RoventModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoventRender extends AbstractZurEntityRender<RoventEntity, RoventModel<RoventEntity>> {
   private static final ResourceLocation ROVENT_LOCATION = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/zur_entity.png");

   public RoventRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new RoventModel<>(0.0F, 0.0F, 64, 64), new RoventModel<>(0.5F, true), new RoventModel<>(1.0F, true));
      this.addLayer(new RoventOuterLayer<>(this));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(ZurEntity entity) {
      return ROVENT_LOCATION;
   }

   protected void applyRotations(RoventEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
      super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
      float f = entityLiving.getSwimAnimation(partialTicks);
      if (f > 0.0F) {
         matrixStackIn.rotate(Vector3f.XP.rotationDegrees(MathHelper.lerp(f, entityLiving.rotationPitch, -10.0F - entityLiving.rotationPitch)));
      }

   }
}