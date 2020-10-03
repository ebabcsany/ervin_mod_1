package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurNirtreModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.VillagerLevelPendantLayer;
import net.minecraft.client.renderer.entity.model.ZombieVillagerModel;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZurNirtreRender extends BipedRenderer<ZurNirtreEntity, ZurNirtreModel<ZurNirtreEntity>> {
   private static final ResourceLocation ZUR_NIRTRE_TEXTURES = new ResourceLocation("textures/entity/zur_nirtre_entity.png");

   public ZurNirtreRender(EntityRendererManager renderManagerIn, IReloadableResourceManager resourceManagerIn) {
      super(renderManagerIn, new ZurNirtreModel<>(0.0F, false), 0.5F);
      this.addLayer(new BipedArmorLayer<>(this, new ZurNirtreModel(0.5F, true), new ZurNirtreModel(1.0F, true)));
      this.addLayer(new VillagerLevelPendantLayer(this, resourceManagerIn, "zur_nirtre"));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(ZurNirtreEntity entity) {
      return ZUR_NIRTRE_TEXTURES;
   }

   protected boolean func_230495_a_(ZurNirtreEntity p_230495_1_) {
      return p_230495_1_.isConverting();
   }
}