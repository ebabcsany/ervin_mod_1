package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurEntityModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractZurEntityRender<T extends ZurEntity, M extends ZurEntityModel<T>> extends BipedRenderer<T, M> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Ervin_mod_1.MOD_ID,
            "textures/entity/zur_entity.png");

    protected AbstractZurEntityRender(EntityRendererManager p_i50974_1_, M p_i50974_2_, M p_i50974_3_, M p_i50974_4_) {
        super(p_i50974_1_, p_i50974_2_, 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, p_i50974_3_, p_i50974_4_));
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(T entity) {
        return TEXTURE;
    }

    protected void applyRotations(T entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }
}
