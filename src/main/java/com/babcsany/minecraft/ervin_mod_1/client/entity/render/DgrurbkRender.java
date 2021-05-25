package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.DgrurbModel;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.DgrurbkModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.Dgrurb;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.Dgrurbk;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DgrurbkRender extends AbstractDgrurbkRender<Dgrurbk, DgrurbkModel<Dgrurbk>> {
   public DgrurbkRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new DgrurbkModel<>(0.0F, false), new DgrurbkModel<>(1.0F, true), new DgrurbkModel<>(2.0F, true));
   }
}