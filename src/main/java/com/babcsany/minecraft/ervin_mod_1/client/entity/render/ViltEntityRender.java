package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ViltEntityModel;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurEntity1Model;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ViltEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ZurEntity1;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ViltEntityRender extends MobRenderer<ViltEntity, ViltEntityModel<ViltEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Ervin_mod_1.MOD_ID,
            "textures/entity/vilt_entity.png");

    public ViltEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ViltEntityModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ViltEntity entity) {
        return TEXTURE;
    }
}
