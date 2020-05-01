package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.model.ZurEntityModel;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;

public class ZurEntityRender extends AbstractZurEntityRender<ZurEntity, ZurEntityModel<ZurEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Ervin_mod_1.MOD_ID,
            "textures/entity/zur_entity.png");

    public ZurEntityRender(EntityRendererManager rendererManager) {
        super(rendererManager, new ZurEntityModel<>(0.0F, false), new ZurEntityModel<>(0.5F, true), new ZurEntityModel<>(1.0F, true));
    }
}
