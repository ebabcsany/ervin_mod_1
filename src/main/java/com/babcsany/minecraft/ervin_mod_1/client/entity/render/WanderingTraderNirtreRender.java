package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.NirtreModel;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WanderingTraderNirtreRender extends MobRenderer<WanderingTraderNirtreEntity, NirtreModel<WanderingTraderNirtreEntity>> {
   private static final ResourceLocation field_217780_a = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/wandering_trader_nirtre_entity.png");

   public WanderingTraderNirtreRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new NirtreModel<>(0.0F), 0.5F);
      this.addLayer(new HeadLayer<>(this));
      this.addLayer(new CrossedArmsItemLayer<>(this));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(WanderingTraderNirtreEntity entity) {
      return field_217780_a;
   }

   protected void preRenderCallback(WanderingTraderNirtreEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      float f = 0.9375F;
      matrixStackIn.scale(0.9375F, 0.9375F, 0.9375F);
   }
}