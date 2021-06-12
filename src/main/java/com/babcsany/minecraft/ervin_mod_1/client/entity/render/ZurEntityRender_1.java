package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurEntityModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZurEntityRender_1 extends AbstractZurEntityRender<ZurEntity, ZurEntityModel<ZurEntity>> {
   public ZurEntityRender_1(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new ZurEntityModel<>(0.0F, false), new ZurEntityModel<>(0.5F, true), new ZurEntityModel<>(1.0F, true));
   }
}