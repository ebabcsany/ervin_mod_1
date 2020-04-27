package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurEntityModel;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ZurEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ZurEntityRender extends MobRenderer<ZurEntity, ZurEntityModel<ZurEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Ervin_mod_1.MOD_ID,
            "textures/entity/zur_entity.png");

    public ZurEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ZurEntityModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ZurEntity entity) {
        return TEXTURE;
    }
}

