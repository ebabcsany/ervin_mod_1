package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.TraderNirtre1Model;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.TraderNirtreModel;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtre1Entity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TraderNirtre1Render extends AbstractTraderNirtre1Render<TraderNirtre1Entity, TraderNirtre1Model<TraderNirtre1Entity>> {
   public TraderNirtre1Render(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new TraderNirtre1Model<>(0.0F, false), new TraderNirtre1Model<>(0.5F, true), new TraderNirtre1Model<>(1.0F, true));
   }
}