package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

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
   private static final ResourceLocation INVULNERABLE_DGRURBK_TEXTURES = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
   private static final ResourceLocation DGRURBK_TEXTURES = new ResourceLocation("textures/entity/wither/wither.png");
   private static BipedModel<Dgrurbk> dgrurbkBipedModel;

   public DgrurbkRender(EntityRendererManager renderManagerIn, DgrurbkRender dgrurbkRender) {
      super(renderManagerIn, new BipedModel<>(0.0F));
      this.addLayer(new DgrurbkAuraLayer(dgrurbkRender));
   }

   public DgrurbkRender(EntityRendererManager entityRendererManager) {
      super(entityRendererManager, dgrurbkBipedModel);
   }

   public int getBlockLight(Dgrurbk entityIn, BlockPos partialTicks) {
      return 15;
   }

   @Override
   protected void addLayer(DgrurbkAuraLayer dgrurbkAuraLayer) {

   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(Dgrurbk entity) {
      int i = entity.getInvulTime();
      return i > 0 && (i > 80 || i / 5 % 2 != 1) ? INVULNERABLE_DGRURBK_TEXTURES : DGRURBK_TEXTURES;
   }

   protected void preRenderCallback(Dgrurbk entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      float f = 2.0F;
      int i = entitylivingbaseIn.getInvulTime();
      if (i > 0) {
         f -= ((float)i - partialTickTime) / 120.0F * 0.5F;
      }

      matrixStackIn.scale(f, f, f);
   }
}
