package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.$TraderModel;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZombieTraderModel;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.ZombieTraderEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZombieTraderRender extends AbstractZombieTraderRender<ZombieTraderEntity, ZombieTraderModel<ZombieTraderEntity>> {
   public ZombieTraderRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new ZombieTraderModel<>(0.0F, false), new ZombieTraderModel<>(0.5F, true), new ZombieTraderModel<>(1.0F, true));
   }
}