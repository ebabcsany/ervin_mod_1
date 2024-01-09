package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.AbstractZurNirtreModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZurNirtreRender extends AbstractZurNirtreRender<ZurNirtreEntity, AbstractZurNirtreModel<ZurNirtreEntity>> {
   public ZurNirtreRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new AbstractZurNirtreModel<>(0.0F, false), new AbstractZurNirtreModel<>(0.5F, true), new AbstractZurNirtreModel<>(1.0F, true));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(ZurNirtreEntity entity) {
      return field_217771_a;
   }
}