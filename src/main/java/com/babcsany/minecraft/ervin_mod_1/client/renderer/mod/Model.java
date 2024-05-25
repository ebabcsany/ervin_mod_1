package com.babcsany.minecraft.ervin_mod_1.client.renderer.mod;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Consumer;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public abstract class Model implements Consumer<ModelRenderer> {
    protected final Function<ResourceLocation, RenderType> renderType;
    public int textureWidth = 64;
    public int textureHeight = 32;

    public Model(Function<ResourceLocation, RenderType> renderTypeIn) {
        this.renderType = renderTypeIn;
    }

    public Model(Function<ResourceLocation, RenderType> renderTypeIn, int textureWidth, int textureHeight) {
        this.renderType = renderTypeIn;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    public void accept(ModelRenderer p_accept_1_) {
    }

    public final RenderType getRenderType(ResourceLocation locationIn) {
        return this.renderType.apply(locationIn);
    }

    public abstract void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha);
}
