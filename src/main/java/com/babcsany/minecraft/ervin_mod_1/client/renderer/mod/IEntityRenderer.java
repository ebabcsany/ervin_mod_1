package com.babcsany.minecraft.ervin_mod_1.client.renderer.mod;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface IEntityRenderer<T extends Entity, M extends EntityModel<T>> {
    M getEntityModel();

    /**
     * Returns the location of an entity's texture.
     */
    ResourceLocation getEntityTexture(T entity);
}
