package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurEntityModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractZurNirtreRender<T extends ZurNirtreEntity, M extends ZurEntityModel<T>> extends BipedRenderer<T, M> {
   private static final ResourceLocation field_217771_a = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/zur_nirtre.png");

   protected AbstractZurNirtreRender(EntityRendererManager p_i50974_1_, M p_i50974_2_, M p_i50974_3_, M p_i50974_4_) {
      super(p_i50974_1_, p_i50974_2_, 0.5F);
      this.addLayer(new BipedArmorLayer<>(this, p_i50974_3_, p_i50974_4_));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(ZurNirtreEntity entity) {
      return field_217771_a;
   }

   protected boolean func_230495_a_(T p_230495_1_) {
      return p_230495_1_.isDrowning();
   }
}