package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.ZombieTraderEntity;
import com.babcsany.minecraft.ervin_mod_1.init.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ervin_mod_1.MOD_ID)
public class Ervin_mod_1 {

    public static final String MOD_ID = "ervin_mod_1";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    /*public static final ResourceLocation EXAMPLE_DIM_TYPE = new ResourceLocation(Ervin_mod_1.MOD_ID, "example");
    public static final ResourceLocation EXAMPLE_DIM_TYPE0 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example0");
    public static final ResourceLocation EXAMPLE_DIM_TYPE1 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example1");
    public static final ResourceLocation EXAMPLE_DIM_TYPE2 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example2");
    public static final ResourceLocation EXAMPLE_DIM_TYPE3 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example3");
    public static final ResourceLocation EXAMPLE_DIM_TYPE4 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example4");
    public static final ResourceLocation EXAMPLE_DIM_TYPE5 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example5");
    public static final ResourceLocation FIRG_DIM_TYPE = new ResourceLocation(Ervin_mod_1.MOD_ID, "firg");
    public static final ResourceLocation SCRAFTH_DIM_TYPE = new ResourceLocation(Ervin_mod_1.MOD_ID, "scrafth");*/

    public Ervin_mod_1() {
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        modEventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        modEventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        isBurnableBlockInit.BURNABLE_BLOCKS.register(modEventBus);
        ContainerInit.CONTAINER_TYPES.register(modEventBus);
        DecoratorInit.DECORATORS.register(modEventBus);
        EntityInit.ENTITY_TYPES.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);
        SoundInit.SOUNDS.register(modEventBus);
        FluidInit.FLUIDS.register(modEventBus);
        FeatureInit.FEATURES.register(modEventBus);
        ParticleInit.PARTICLE_TYPES.register(modEventBus);
        SurfaceBuilderInit.SURFACE_BUILDERS.register(modEventBus);
        TreeDecoratorInit.TREE_DECORATOR_TYPES.register(modEventBus);
        WorldCarverInit.CARVERS.register(modEventBus);
        //DimensionInit.MOD_DIMENSIONS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityInit.ZUR_ENTITY1.get(), ZurEntity1.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ZUR_ENTITY.get(), ZurEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ROVENT_ENTITY.get(), RoventEntity.setCustomAttributes().create());
            //GlobalEntityTypeAttributes.put(EntityInit.ZUR_NIRTRE_ENTITY.get(), ZurNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.FREIN_ENTITY.get(), FreinEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.VILT_ENTITY.get(), ViltEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.SRACH_ENTITY.get(), SrachEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.SHERT_ENTITY.get(), ShertEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.HHIJ_ENTITY.get(), WolfEntity1.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.$_TRADER_ENTITY.get(), $TraderEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ZOMBIE_TRADER_ENTITY.get(), ZombieTraderEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.GUBROV_ENTITY.get(), AbstractFishEntity.func_234176_m_().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("ervin_mod_1", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }

        @SubscribeEvent
        public static void onRegisterItems (final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            Set<Block> cannotBePlacedBlocks = new HashSet<>(Arrays.asList(
                    BlockInit.FIRG.get(),
                    BlockInit.VIRK_BLOCK.get(),
                    BlockInit.ENDER_SRACKHT.get(),
                    BlockInit.ENDER_STAKRACH.get(),
                    BlockInit.ENDER_SRAKTCAF.get(),
                    BlockInit.ENDER_TRASKRACH.get(),
                    BlockInit.ENDER_TRASKCRAFTH.get(),
                    BlockInit.SCRAFTH.get()
            ));
            BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                if (!cannotBePlacedBlocks.contains(block)) {
                        final Item.Properties properties = new Item.Properties();
                        properties.group(ItemGroup.MATERIALS);
                        final BlockItem blockItem = new BlockItem(block, properties);
                        ResourceLocation registryName = block.getRegistryName();
                        if (null != registryName) {
                            blockItem.setRegistryName(registryName);
                        }
                        registry.register(blockItem);
                }
            });
            isBurnableBlockInit.BURNABLE_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                if (!cannotBePlacedBlocks.contains(block)) {
                    final Item.Properties properties = new Item.Properties().isBurnable();
                    properties.group(ItemGroup.MATERIALS);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    ResourceLocation registryName = block.getRegistryName();
                    if (null != registryName) {
                        blockItem.setRegistryName(registryName);
                    }
                    registry.register(blockItem);
                }
            });
            
        }

        @SubscribeEvent
        public static void onRegisterRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            ShapedRecipe.setCraftingSize(5, 5);
        }
    }

    /*public boolean func_230151_c_() {
        return !"vanilla".equals(ClientBrandRetriever.getClientModName()) || Minecraft.class.getSigners() == null;
    }*/

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLeftClickBlock(final PlayerInteractEvent.LeftClickBlock event) {
            PlayerEntity player = event.getPlayer();
            ResourceLocation MaterialBlocksTagId = new ResourceLocation(Ervin_mod_1.MOD_ID, "material_blocks");
            ITag<Block> MaterialBlocks = BlockTags.getCollection().get(MaterialBlocksTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> {
                assert MaterialBlocks != null;
                return blockState.isIn(MaterialBlocks) && player.isCreative();
            })) {
                event.setCanceled(true);
            }
        }

    }
}
