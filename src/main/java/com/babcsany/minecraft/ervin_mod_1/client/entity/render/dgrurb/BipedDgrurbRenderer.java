package com.babcsany.minecraft.ervin_mod_1.client.entity.render.dgrurb;

import com.babcsany.minecraft.ervin_mod_1.client.entity.layers.DgrurbkAuraLayer;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class BipedDgrurbRenderer<T extends DgrurbMobEntity, M extends BipedModel<T>> extends DgrurbMobRenderer<T, M> {
   private static final ResourceLocation DEFAULT_RES_LOC = new ResourceLocation("textures/entity/steve.png");

   public BipedDgrurbRenderer(EntityRendererManager renderManagerIn, M modelBipedIn, float shadowSize) {
      this(renderManagerIn, modelBipedIn, shadowSize, 1.0F, 1.0F, 1.0F);
   }

   public BipedDgrurbRenderer(EntityRendererManager p_i232471_1_, M p_i232471_2_, float p_i232471_3_, float p_i232471_4_, float p_i232471_5_, float p_i232471_6_) {
      super(p_i232471_1_, p_i232471_2_);
      this.addLayer(new HeadLayer<>(this, p_i232471_4_, p_i232471_5_, p_i232471_6_));
      this.addLayer(new ElytraLayer<>(this));
      this.addLayer(new HeldItemLayer<>(this));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(T entity) {
      return DEFAULT_RES_LOC;
   }
}
