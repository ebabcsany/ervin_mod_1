package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.SrachModel;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.SrachEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SrachRender extends MobRenderer<SrachEntity, SrachModel<SrachEntity>> {
   private static final ResourceLocation SRACH_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/srach/srach.png");

   public SrachRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SrachModel<>(), 0.7F);
   }

   /**
    * Returns the location of an entity's texture.
    */
   @Override
   public ResourceLocation getEntityTexture(SrachEntity entity) {
      return SRACH_TEXTURES;
   }
}