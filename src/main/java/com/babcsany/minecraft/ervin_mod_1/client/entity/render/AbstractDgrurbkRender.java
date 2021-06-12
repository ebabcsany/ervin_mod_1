package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.DgrurbkModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.Dgrurb;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.Dgrurbk;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractDgrurbkRender<T extends Dgrurbk, M extends DgrurbkModel<T>> extends BipedRenderer<T, M> {
   private static final ResourceLocation field_217771_a = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/monster/dgrurbk.png");

   protected AbstractDgrurbkRender(EntityRendererManager p_i50974_1_, M p_i50974_2_, M p_i50974_3_, M p_i50974_4_) {
      super(p_i50974_1_, p_i50974_2_, 0.5F);
      this.addLayer(new BipedArmorLayer<>(this, p_i50974_3_, p_i50974_4_));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(Dgrurb entity) {
      return field_217771_a;
   }

   /*protected boolean func_230495_a_(T p_230495_1_) {
      return p_230495_1_.isDrowning();
   }*/
}