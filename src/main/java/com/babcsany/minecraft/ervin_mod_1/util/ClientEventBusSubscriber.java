package com.babcsany.minecraft.ervin_mod_1.util;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.*;
import com.babcsany.minecraft.ervin_mod_1.client.gui.CraintBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.LeatBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.init.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Ervin_mod_1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_ENTITY1.get(), ZurEntity1Render::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_ENTITY.get(), ZurEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.VILT_ENTITY.get(), ViltEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FREIN_ENTITY.get(), FreinEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRACH_ENTITY.get(), SrachRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SHERT_ENTITY.get(), SrachRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.HHIJ_ENTITY.get(), WolfRender1::new);
        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        DeferredWorkQueue.runLater(() -> {
            ScreenManager.registerFactory(ContainerInit.LEAT_BLOCK_CRAFTING_TABLE.get(), LeatBlockCraftingTableScreen::new);
        });
        DeferredWorkQueue.runLater(() -> {
            ScreenManager.registerFactory(ContainerInit.CRAINT_BLOCK_CRAFTING_TABLE.get(), CraintBlockCraftingTableScreen::new);
        });
    }
}
