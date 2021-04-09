package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.layers.ViltWoolLayer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ViltEntityModel;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ViltEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ViltEntityRender extends MobRenderer<ViltEntity, ViltEntityModel<ViltEntity>> {
    private static final ResourceLocation SHEARED_VILT_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/crask1.png");

    public ViltEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ViltEntityModel<>(), 0.7F);
        this.addLayer(new ViltWoolLayer(this));
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(ViltEntity entity) {
        return SHEARED_VILT_TEXTURES;
    }
}