package com.babcsany.minecraft.ervin_mod_1.util;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.EntityRendererManager;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.client.DefaultClientSetup;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.client.ModClientSetup;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.client.screen.ScreenSetup;
import com.babcsany.minecraft.ervin_mod_1.forge.fml.DeferredWorkQueue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Ervin_mod_1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    static net.minecraft.client.renderer.ItemRenderer itemRenderer;

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        new ModClientSetup();
        new DefaultClientSetup();
        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        DeferredWorkQueue.runLater(() -> {
            new ScreenSetup();
        });
    }

    EntityRendererManager ENTITY_ENDERER_MANAGER = EntityRendererManager.ENTITY_ENDERER_MANAGER;
}
