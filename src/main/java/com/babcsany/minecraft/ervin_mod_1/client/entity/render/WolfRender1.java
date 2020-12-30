package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.layers.WolfCollarLayer1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.WolfModel1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.WolfEntity1;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.WolfCollarLayer;
import net.minecraft.client.renderer.entity.model.WolfModel;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WolfRender1 extends MobRenderer<WolfEntity1, WolfModel1<WolfEntity1>> {
   private static final ResourceLocation WOLF_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/wolf1/wolf1.png");
   private static final ResourceLocation TAMED_WOLF_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/wolf1/wolf1_tame.png");
   private static final ResourceLocation ANGRY_WOLF_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/wolf1/wolf1_angry.png");

   public WolfRender1(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new WolfModel1<>(), 0.5F);
      this.addLayer(new WolfCollarLayer1(this));
   }

   /**
    * Defines what float the third param in setRotationAngles of ModelBase is
    */
   protected float handleRotationFloat(WolfEntity1 livingBase, float partialTicks) {
      return livingBase.getTailRotation();
   }

   public void render(WolfEntity1 entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      if (entityIn.isWolfWet()) {
         float f = MathHelper.clamp(entityIn.getBrightness() * entityIn.getShadingWhileWet(partialTicks), 0.0F, 1.0F);
         this.entityModel.setTint(f, f, f);
      }

      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
      if (entityIn.isWolfWet()) {
         this.entityModel.setTint(1.0F, 1.0F, 1.0F);
      }

   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(WolfEntity1 entity) {
      if (entity.isTamed()) {
         return TAMED_WOLF_TEXTURES;
      } else {
         return entity.func_233678_J__() ? ANGRY_WOLF_TEXTURES : WOLF_TEXTURES;
      }
   }
}
