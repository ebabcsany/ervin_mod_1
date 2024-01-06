package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.client;

import com.babcsany.minecraft.ervin_mod_1.client.entity.render.*;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.dgrurb.DrurgbkRenderer;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.ModBoatRender;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModClientSetup {

    public ModClientSetup() {
        register();
    }

    public void register() {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LIWRAY.get(), LiwrayRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOD_BOAT_ENTITY.get(), ModBoatRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GWURST.get(), GwurstRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DRURB_ENTITY.get(), DrurgbkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_NIRTRE_ENTITY.get(), ZurNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.VILT_ENTITY.get(), ViltEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FREIN_ENTITY.get(), FreinEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SHERT_ENTITY.get(), ShertRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.HHIJ_ENTITY.get(), HhijRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTRE1_ENTITY.get(), TraderNirtre1Render::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.$_TRADER_ENTITY.get(), $TraderRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZOMBIE_TRADER_ENTITY.get(), ZombieTraderRender::new);
    }
}
