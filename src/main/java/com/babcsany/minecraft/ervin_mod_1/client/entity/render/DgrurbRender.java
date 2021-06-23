package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.DgrurbModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.Dgrurb;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DgrurbRender extends AbstractDgrurbRender<Dgrurb, DgrurbModel<Dgrurb>> {
   public DgrurbRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new DgrurbModel<>(0.0F, false), new DgrurbModel<>(0.5F, true), new DgrurbModel<>(1.0F, true));
   }
}