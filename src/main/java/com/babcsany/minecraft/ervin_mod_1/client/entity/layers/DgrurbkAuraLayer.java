package com.babcsany.minecraft.ervin_mod_1.client.entity.layers;

import com.babcsany.minecraft.ervin_mod_1.client.entity.layers.dgrurbk.EnergyLayer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.DgrurbkModel;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.DgrurbkRender;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk.Dgrurbk;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DgrurbkAuraLayer extends EnergyLayer<Dgrurbk, DgrurbkModel<Dgrurbk>> {
   private static final ResourceLocation DGRURBK_ARMOR = new ResourceLocation("textures/entity/wither/wither_armor.png");
   private final DgrurbkModel<Dgrurbk> dgrurbkModel = new DgrurbkModel<>(0.5F, true);

   public DgrurbkAuraLayer(DgrurbkRender dgrurbkRender) {
      super(dgrurbkRender);
   }

   protected float func_225634_a_(float p_225634_1_) {
      return MathHelper.cos(p_225634_1_ * 0.02F) * 3.0F;
   }

   protected ResourceLocation func_225633_a_() {
      return DGRURBK_ARMOR;
   }

   protected EntityModel<Dgrurbk> func_225635_b_() {
      return this.dgrurbkModel;
   }
}
