package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.ervin_mod_1.init.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

import java.util.stream.Collectors;

import static com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ervin_mod_1.MOD_ID)
public class Ervin_mod_1 {

    public static final String MOD_ID = "ervin_mod_1";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ResourceLocation EXAMPLE_DIM_TYPE = new ResourceLocation(Ervin_mod_1.MOD_ID, "example");
    public static final ResourceLocation EXAMPLE_DIM_TYPE0 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example0");
    public static final ResourceLocation EXAMPLE_DIM_TYPE1 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example1");
    public static final ResourceLocation EXAMPLE_DIM_TYPE2 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example2");
    public static final ResourceLocation EXAMPLE_DIM_TYPE3 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example3");

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
        ContainerInit.CONTAINER_TYPES.register(modEventBus);
        DecoratorInit.DECORATORS.register(modEventBus);
        EntityInit.ENTITY_TYPES.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);
        SoundInit.SOUNDS.register(modEventBus);
        FluidInit.FLUIDS.register(modEventBus);
        DimensionInit.MOD_DIMENSIONS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
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
            BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                if (!block.equals(BlockInit.FIRG.get()))
                if (!block.equals(BlockInit.VIRK_BLOCK.get()))
                if (!block.equals(BlockInit.ENDER_SRACKHT.get()))
                if (!block.equals(BlockInit.ENDER_STAKRACH.get()))
                if (!block.equals(BlockInit.ENDER_SRAKTCAF.get()))
                if (!block.equals(BlockInit.ENDER_TRASKRACH.get()))
                if (!block.equals(BlockInit.ENDER_TRASKCRAFTH.get()))
                if (!block.equals(BlockInit.SCRAFTH.get())) {
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
        }

        @SubscribeEvent
        public static void onRegisterRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            ShapedRecipe.setCraftingSize(5, 5);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLeftClickBlock(final PlayerInteractEvent.LeftClickBlock event) {
            PlayerEntity player = event.getPlayer();
            ResourceLocation MaterialBlocksTagId = new ResourceLocation(Ervin_mod_1.MOD_ID, "material_blocks");
            Tag<Block> MaterialBlocks = BlockTags.getCollection().get(MaterialBlocksTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> {
                assert MaterialBlocks != null;
                return blockState.isIn(MaterialBlocks) && player.isCreative();
            })) {
                event.setCanceled(true);
            }
        }
    }
}
