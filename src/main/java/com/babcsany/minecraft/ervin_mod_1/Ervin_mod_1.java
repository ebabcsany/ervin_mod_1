package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.init.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.*;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.text.ITextComponent;
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

import javax.annotation.Nullable;
import java.util.stream.Collectors;

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
    public static final ResourceLocation EXAMPLE_DIM_TYPE4 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example4");
    public static final ResourceLocation EXAMPLE_DIM_TYPE5 = new ResourceLocation(Ervin_mod_1.MOD_ID, "example5");
    public static final ResourceLocation FIRG_DIM_TYPE = new ResourceLocation(Ervin_mod_1.MOD_ID, "firg");
    public static final ResourceLocation SCRAFTH_DIM_TYPE = new ResourceLocation(Ervin_mod_1.MOD_ID, "scrafth");

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
            GlobalEntityTypeAttributes.put(EntityInit.ZUR_NIRTRE_ENTITY.get(), ZurNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.FREIN_ENTITY.get(), FreinEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.VILT_ENTITY.get(), ViltEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.SRACH_ENTITY.get(), SrachEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.SHERT_ENTITY.get(), ShertEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.HHIJ_ENTITY.get(), WolfEntity1.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreEntity.setCustomAttributes().create());
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

    public boolean func_230151_c_() {
        return !"vanilla".equals(ClientBrandRetriever.getClientModName()) || Minecraft.class.getSigners() == null;
    }
    @Nullable
    public ClientPlayNetHandler getConnection() {
        return this.player == null ? null : this.player.connection;
    }
    @Nullable
    public ClientPlayerEntity player;
    @Nullable
    public Screen currentScreen;
    private boolean connectedToRealms;
    @Nullable
    private ServerData currentServerData;
    @Nullable
    private IntegratedServer integratedServer;
    public boolean isConnectedToRealms() {
        return this.connectedToRealms;
    }
    @Nullable
    public ClientWorld world;
    private String func_230149_ax_() {
        StringBuilder stringbuilder = new StringBuilder("Minecraft");
        if (this.func_230151_c_()) {
            stringbuilder.append("*");
        }

        stringbuilder.append(" ");
        stringbuilder.append(SharedConstants.getVersion().getName());
        ClientPlayNetHandler clientplaynethandler = this.getConnection();
        if (clientplaynethandler != null && clientplaynethandler.getNetworkManager().isChannelOpen()) {
            stringbuilder.append(" - ");
            if (this.integratedServer != null && !this.integratedServer.getPublic()) {
                stringbuilder.append(I18n.format("title.singleplayer"));
            } else if (this.isConnectedToRealms()) {
                stringbuilder.append(I18n.format("title.multiplayer.realms"));
            } else if (this.integratedServer == null && (this.currentServerData == null || !this.currentServerData.isOnLAN())) {
                stringbuilder.append(I18n.format("title.multiplayer.other"));
            } else {
                stringbuilder.append(I18n.format("title.multiplayer.lan"));
            }
        }

        return stringbuilder.toString();
    }
    /*public void func_230150_b_() {
        this.mainWindow.func_230148_b_(this.func_230149_ax_());
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
        @SubscribeEvent
        public static void onRightClickBlock(final PlayerInteractEvent.RightClickBlock event) {
            PlayerEntity player = event.getPlayer();
            ResourceLocation MaterialSetblocksTagId = new ResourceLocation(Ervin_mod_1.MOD_ID, "material_setblocks");
            ITag<Block> MaterialSetblocks = BlockTags.getCollection().get(MaterialSetblocksTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> {
                assert MaterialSetblocks != null;
                return blockState.isIn(MaterialSetblocks) && player.isCreative();
            })) {
                event.setCanceled(true);
            }
        }
        @SubscribeEvent
        public static void onRightClickItem(final PlayerInteractEvent.RightClickItem event) {
            PlayerEntity player = event.getPlayer();
            ResourceLocation MaterialItemsTagId = new ResourceLocation(Ervin_mod_1.MOD_ID, "material_items");
            ITag<Item> MaterialItems = ItemTags.getCollection().get(MaterialItemsTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> {
                assert MaterialItems != null;
                return player.isCreative();
            })) {
                event.setCanceled(true);
            }
        }
    }
}
