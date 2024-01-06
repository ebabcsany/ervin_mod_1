package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import net.minecraft.client.renderer.entity.model.AbstractZombieModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoventModel<T extends RoventEntity> extends AbstractZombieModel<T> {
   public RoventModel(float modelSize, boolean p_i1168_2_) {
      this(modelSize, 0.0F, 64, p_i1168_2_ ? 32 : 64);
   }

   protected RoventModel(float p_i48914_1_, float p_i48914_2_, int p_i48914_3_, int p_i48914_4_) {
      super(p_i48914_1_, p_i48914_2_, p_i48914_3_, p_i48914_4_);
   }

   public boolean isAggressive(T entityIn) {
      return entityIn.isAggressive();
   }
}
