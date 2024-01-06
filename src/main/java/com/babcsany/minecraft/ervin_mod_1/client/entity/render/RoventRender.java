package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.RoventModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoventRender extends AbstractRoventRender<RoventEntity, RoventModel<RoventEntity>> {
   public RoventRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new RoventModel<>(0.0F, false), new RoventModel<>(0.5F, true), new RoventModel<>(1.0F, true));
   }
}
