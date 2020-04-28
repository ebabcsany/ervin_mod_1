package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurEntity1Model;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ZurEntity1;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ZurEntity1Render extends MobRenderer<ZurEntity1, ZurEntity1Model<ZurEntity1>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Ervin_mod_1.MOD_ID,
            "textures/entity/zur_entity_1.png");

    public ZurEntity1Render(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ZurEntity1Model<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ZurEntity1 entity) {
        return TEXTURE;
    }
}

