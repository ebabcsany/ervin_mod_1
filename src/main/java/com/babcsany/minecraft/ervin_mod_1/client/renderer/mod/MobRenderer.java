package com.babcsany.minecraft.ervin_mod_1.client.renderer.mod;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class MobRenderer<T extends MobEntity, M extends EntityModel<T>> extends net.minecraft.client.renderer.entity.MobRenderer<T, M> {
    public MobRenderer(EntityRendererManager renderManagerIn, M entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }
}
