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
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Ervin_mod_1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    public final Map<EntityType<?>, EntityRenderer<?>> renderers = Maps.newHashMap();

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        Minecraft minecraft = event.getMinecraftSupplier().get();
        ItemRenderer itemRenderer = minecraft.getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LIWRAY, LiwrayRender::new);
        RenderingRegistry.registerEntityRenderingHandler(com.babcsany.minecraft.init.EntityInit.MOD_BOAT, ModBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GWURST, GwurstRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR, ZurEntityRender::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_NIRTRE_ENTITY, ZurNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ROVENT_ENTITY, RoventRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.VILT_ENTITY, ViltEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FREIN_ENTITY, FreinEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRACH_ENTITY, SrachRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SHERT_ENTITY, ShertRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DRURB_ENTITY, DrurgbkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRECH_ENTITY, SrechRender::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.HHIJ_ENTITY, HhijRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY, WanderingTraderNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTRE_ENTITY, TraderNirtreRender::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTRE1_ENTITY, TraderNirtre1Render::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.$_TRADER_ENTITY, $TraderRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZOMBIE_TRADER_ENTITY, ZombieTraderRender::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.NIRTRE_ENTITY, ZurEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GUBROV, GubrovRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(com.babcsany.minecraft.init.EntityInit.HUIHK, HuihkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(com.babcsany.minecraft.init.EntityInit.TAWROL, manager -> new SpriteRenderer<>(manager, itemRenderer));
        new ModSetup();

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
