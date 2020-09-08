package com.babcsany.minecraft.ervin_mod_1.util;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.*;
import com.babcsany.minecraft.ervin_mod_1.client.gui.CraintBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.LeatBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.init.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.DimensionInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.DimensionManager;
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
        if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE0) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE0, DimensionInit.EXAMPLE_DIM0.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE1) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE1, DimensionInit.EXAMPLE_DIM1.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE2) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE2, DimensionInit.EXAMPLE_DIM2.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE3) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE3, DimensionInit.EXAMPLE_DIM3.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE4) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE4, DimensionInit.EXAMPLE_DIM4.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE5) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE5, DimensionInit.EXAMPLE_DIM5.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.FIRG_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.FIRG_DIM_TYPE, DimensionInit.FIRG_DIM.get(), null,
                    true);
        }
        if (DimensionType.byName(Ervin_mod_1.SCRAFTH_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Ervin_mod_1.SCRAFTH_DIM_TYPE, DimensionInit.SCRAFTH_DIM.get(), null,
                    true);
        }
    }
}
