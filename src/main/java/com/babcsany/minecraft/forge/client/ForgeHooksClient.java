package com.babcsany.minecraft.forge.client;

import com.babcsany.minecraft.ervin_mod_1.client.renderer.item.ItemIcsvreRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.item.ItemStack;

public class ForgeHooksClient {

    public static void drawIcsvreLayered(ItemIcsvreRenderer renderer, IBakedModel modelIn, ItemStack itemStackIn, MatrixStack matrixStackIn,
                                         IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, boolean fabulous)
    {
        for(com.mojang.datafixers.util.Pair<IBakedModel, RenderType> layerModel : modelIn.getLayerModels(itemStackIn, fabulous))
        {
            IBakedModel layer = layerModel.getFirst();
            RenderType rendertype = layerModel.getSecond();
            net.minecraftforge.client.ForgeHooksClient.setRenderLayer(rendertype); // neded for compatibility with MultiLayerModels
            IVertexBuilder ivertexbuilder;
            if (fabulous)
            {
                ivertexbuilder = ItemIcsvreRenderer.func_239391_c_(bufferIn, rendertype, true, itemStackIn.hasEffect());
            } else {
                ivertexbuilder = ItemIcsvreRenderer.getBuffer(bufferIn, rendertype, true, itemStackIn.hasEffect());
            }
            renderer.renderModel(layer, itemStackIn, combinedLightIn, combinedOverlayIn, matrixStackIn, ivertexbuilder);
        }
        net.minecraftforge.client.ForgeHooksClient.setRenderLayer(null);
    }
}
