package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FreinEntityRender extends SlimeRenderer {
    private static final ResourceLocation FREIN_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/frein_entity.png");

    public FreinEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(SlimeEntity entity) {
        return FREIN_TEXTURES;
    }
}