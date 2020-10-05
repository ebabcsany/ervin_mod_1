package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.TraderNirtreModel;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TraderNirtreRender extends AbstractTraderNirtreRender<TraderNirtreEntity, TraderNirtreModel<TraderNirtreEntity>> {
   public TraderNirtreRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new TraderNirtreModel<>(0.0F, false), new TraderNirtreModel<>(0.5F, true), new TraderNirtreModel<>(1.0F, true));
   }
}