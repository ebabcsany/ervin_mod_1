package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.client;

import com.babcsany.minecraft.client.renderer.entity.painting.modPaintingRenderer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.GubrovRenderer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.RoventRender;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.SrachRender;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.ZurEntityRender;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.dgrurb.DrurgbkRenderer;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.init.special.PaintingEntityInit;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class DefaultClientSetup {

    public DefaultClientSetup() {
        register();
    }

    public void register() {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_ENTITY, ZurEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ROVENT_ENTITY, RoventRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRACH_ENTITY, SrachRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GUBROV, GubrovRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DRURGBK, DrurgbkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PaintingEntityInit.modPainting, modPaintingRenderer::new);
    }
}
