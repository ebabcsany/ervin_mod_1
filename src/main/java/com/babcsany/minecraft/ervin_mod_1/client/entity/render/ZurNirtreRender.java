package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.AbstractZurEntityModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZurNirtreRender extends AbstractZurNirtreRender<ZurNirtreEntity, AbstractZurEntityModel<ZurNirtreEntity>> {
   public ZurNirtreRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new AbstractZurEntityModel<>(0.0F, false), new AbstractZurEntityModel<>(0.5F, true), new AbstractZurEntityModel<>(1.0F, true));
   }
}