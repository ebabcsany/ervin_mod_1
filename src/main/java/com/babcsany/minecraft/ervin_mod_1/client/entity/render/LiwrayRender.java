package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.LiwrayModel;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.Liwray;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LiwrayRender extends MobRenderer<Liwray, LiwrayModel<Liwray>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Ervin_mod_1.MOD_ID,
            "textures/entity/zur_entity_1.png");

    public LiwrayRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new LiwrayModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(Liwray entity) {
        return TEXTURE;
    }
}
