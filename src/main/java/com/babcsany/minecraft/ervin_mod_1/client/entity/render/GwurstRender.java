package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.GwurstModel;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.GwurstEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GwurstRender extends MobRenderer<GwurstEntity, GwurstModel<GwurstEntity>> {
   private static final ResourceLocation GWURST_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/entities/gwurst.png");

   public GwurstRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new GwurstModel<>(), 0.3F);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(GwurstEntity entity) {
      return GWURST_TEXTURES;
   }

   /**
    * Defines what float the third param in setRotationAngles of ModelBase is
    */
   protected float handleRotationFloat(GwurstEntity livingBase, float partialTicks) {
      float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
      float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
      return (MathHelper.sin(f) + 1.0F) * f1;
   }
}