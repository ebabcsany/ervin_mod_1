package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.$TraderModel;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.TraderNirtreModel;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class $TraderRender extends Abstract$TraderRender<$TraderEntity, $TraderModel<$TraderEntity>> {
   public $TraderRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new $TraderModel<>(0.0F, false), new $TraderModel<>(0.5F, true), new $TraderModel<>(1.0F, true));
   }
}