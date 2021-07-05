package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.layers.DgrurbkAuraLayer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.dgrurb.DgrurbMobRenderer;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk.Dgrurbk;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DgrurbkRender extends DgrurbMobRenderer<Dgrurbk, BipedModel<Dgrurbk>> {
   private static final ResourceLocation INVULNERABLE_DGRURBK_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/dgrurb/dgrurbk_invulnerable.png");
   private static final ResourceLocation DGRURBK_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/dgrurb/dgrurbk.png");

   public DgrurbkRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new BipedModel<>(0.0F));
   }

   public int getBlockLight(Dgrurbk entityIn, BlockPos partialTicks) {
      return 15;
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(Dgrurbk entity) {
      return DGRURBK_TEXTURES;
   }

   protected void preRenderCallback(Dgrurbk entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      float f = 2.0F;

      matrixStackIn.scale(f, f, f);
   }
}
