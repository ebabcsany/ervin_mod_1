package com.babcsany.minecraft.ervin_mod_1.util;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.*;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.dgrurb.DrurgbkRenderer;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.CraintBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.IrtrewScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.LeatBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.ModBoatRenderer;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.ModSetup;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Ervin_mod_1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    @Deprecated
    public static void clientSetup(FMLClientSetupEvent event) {
        Minecraft minecraft = event.getMinecraftSupplier().get();
        ItemRenderer itemRenderer = minecraft.getItemRenderer();
        new ModSetup();
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LIWRAY.get(), LiwrayRender::new);
//        RenderingRegistry.registerEntityRenderingHandler(com.babcsany.minecraft.init.EntityInit.MOD_BOAT.get(), ModBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GWURST.get(), GwurstRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR.get(), ZurEntityRender::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_NIRTRE_ENTITY, ZurNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ROVENT_ENTITY.get(), RoventRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.VILT.get(), ViltEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FREIN.get(), FreinEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRACH_ENTITY.get(), SrachRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SHERT_ENTITY.get(), ShertRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DGRURB.get(), DrurgbkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRECH_ENTITY.get(), SrechRender::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.HHIJ.get(), HhijRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreRender::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTRE1_ENTITY, TraderNirtre1Render::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.$_TRADER.get(), $TraderRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZOMBIE_TRADER_ENTITY.get(), ZombieTraderRender::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.NIRTRE_ENTITY, ZurEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GUBROV.get(), GubrovRenderer::new);
//        RenderingRegistry.registerEntityRenderingHandler(com.babcsany.minecraft.init.EntityInit.HUIHK.get(), HuihkRenderer::new);
//        RenderingRegistry.registerEntityRenderingHandler(com.babcsany.minecraft.init.EntityInit.TAWROL.get(), manager -> new SpriteRenderer<>(manager, itemRenderer));

        //EntitySpawnPlacementRegistry.canSpawnEntity(EntityInit.$_TRADER_ENTITY.get(), World.field_234917_f_.comapFlatMap(), SpawnReason.NATURAL);
        /*EntitySpawnPlacementRegistry.register(EntityInit.DGRURB_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.FREIN_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FreinEntity::func_223366_c);
        EntitySpawnPlacementRegistry.register(EntityInit.GUBROV_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(EntityInit.GWURST.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.HHIJ_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HhijEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.LIWRAY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.ROVENT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RoventEntity::canRoventSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.SHERT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ShertEntity::func_223318_c);
        EntitySpawnPlacementRegistry.register(EntityInit.SRACH_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.VILT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        EntitySpawnPlacementRegistry.register(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.ZOMBIE_TRADER_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EntityInit.ZUR_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);*/
        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        DeferredWorkQueue.runLater(() -> {
            ScreenManager.registerFactory(ContainerInit.LEAT_BLOCK_CRAFTING_TABLE.get(), LeatBlockCraftingTableScreen::new);
            ScreenManager.registerFactory(ContainerInit.CRAINT_BLOCK_CRAFTING_TABLE.get(), CraintBlockCraftingTableScreen::new);
            ScreenManager.registerFactory(ContainerInit.IRTREW.get(), IrtrewScreen::new);
        });
    }
}
