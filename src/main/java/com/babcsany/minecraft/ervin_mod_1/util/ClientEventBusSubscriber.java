package com.babcsany.minecraft.ervin_mod_1.util;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.*;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.*;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.merchant.ZurScreen;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.ModBoatRender;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.init.*;
import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.network.FMLPlayMessages;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Ervin_mod_1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LIWRAY.get(), LiwrayRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOD_BOAT_ENTITY.get(), ModBoatRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GWURST.get(), GwurstRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_ENTITY, ZurEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DGRURB_ENTITY.get(), DgrurbRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DGRURBK_ENTITY.get(), DgrurbkRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUR_NIRTRE_ENTITY.get(), ZurNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ROVENT_ENTITY.get(), RoventRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.VILT_ENTITY.get(), ViltEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FREIN_ENTITY.get(), FreinEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRACH_ENTITY.get(), SrachRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SHERT_ENTITY.get(), ShertRender::new);
        //RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRECH_ENTITY.get(), SrechRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.HHIJ_ENTITY.get(), HhijRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_NIRTREP_ENTITY.get(), TraderNirtre1Render::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.$_TRADER_ENTITY.get(), $TraderRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZOMBIE_TRADER_ENTITY.get(), ZombieTraderRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GUBROV_ENTITY.get(), GubrovRenderer::new);
        //RenderingRegistry.registerEntityRenderingHandler(EntityInit.HUIHK, HuihkRender::new);

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
            ScreenManager.registerFactory(ContainerInit.TRADER_BLOCK.get(), TraderBlockScreen::new);

            ScreenManager.registerFactory(ContainerInit.ZUR.get(), ZurScreen::new);
        });
    }

    /*private static final BlockState RUBY_ORE = BlockItemInit.RUBY_ORE.get().getDefaultState();
    public static void addOres(PlainsBiome plainsBiome, DesertBiome desertBiome) {
        plainsBiome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RUBY_ORE, 6)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(2, 32, 32))));
        desertBiome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RUBY_ORE, 6)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(2, 32, 32))));
    }*/
}
