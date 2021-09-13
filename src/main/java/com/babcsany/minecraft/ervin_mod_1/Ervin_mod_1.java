package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.Minecraft;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.Ervin_mod_1_;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.Init;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.DefaultEntitySpawnPlacementRegistry;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.DefaultSetup;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.ModEntitySpawnPlacementRegistry;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.ModSetup;
import com.babcsany.minecraft.ervin_mod_1.forge.fml.DeferredWorkQueue;
import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import com.babcsany.minecraft.init.item.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ervin_mod_1.MOD_ID)
public class Ervin_mod_1 {

    public static final RenderMaterial LOCATION_JURK_FLOW = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(Ervin_mod_1.MOD_ID,"block/fluid/jurk_flow"));
    public static final RenderMaterial LOCATION_JURK_OVERLAY = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(Ervin_mod_1.MOD_ID,"block/fluid/jurk_overlay"));
    public static final String MOD_ID = "ervin_mod_1";
    public static Ervin_mod_1 ervin_mod_1;
    public static Minecraft minecraft;
    //public static final ITag<EntityType<?>> blacklisted = EntityTypeTags.func_232896_a_((new ResourceLocation("ervin_mod_1", "blacklisted")).toString());
    /** Directly reference a log4j logger.*/
    public static final Logger LOGGER = LogManager.getLogger();

    public Ervin_mod_1() {
        // Register the setup method for modLoading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        // Register the enqueueIMC method for modLoading
        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modLoading
        modEventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modLoading
        modEventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        new Init();
    }

    public static void Class(Class<?>... class$) {
        class$.clone();
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        DeferredWorkQueue.runLater(() -> {
            new ModSetup();
            new DefaultSetup();
            new ModEntitySpawnPlacementRegistry();
            new DefaultEntitySpawnPlacementRegistry();

            Ervin_mod_1_.registries();
            Ervin_mod_1_.featureGen();

        });

        Ervin_mod_1_.setup();
        Ervin_mod_1_.ervin_mod_1_void();
        Ervin_mod_1_.ervin_mod_1_boolean();
        minecraft();
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
        LOGGER.info("Got IMC {}", event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
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
        public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
            BiomeInit.registerBiomes();
        }

        @SubscribeEvent
        public static void onRegisterItems (final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            Set<Block> Blocks = new HashSet<>(Arrays.asList(
                    BlockInit.ENDER_STAKRACH.get(),
                    BlockInit.ENDER_SRAKTCAF.get(),
                    BlockInit.ENDER_TRASKRACH.get(),
                    BlockInit.ENDER_TRASKCRAFTH.get()
            ));
            BlockItemInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                if (!Blocks.contains(block)) {
                    final Item.Properties properties = new Item.Properties();
                    properties.group(ItemGroup.ERVIN_MOD_1);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    ResourceLocation registryName = block.getRegistryName();
                    if (null != registryName) {
                        blockItem.setRegistryName(registryName);
                    }
                    registry.register(blockItem);
                }
            });
            com.babcsany.minecraft.ervin_mod_1.init.block.animation.colors.BlockItemInit.ANIMATION_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                if (!Blocks.contains(block)) {
                    final Item.Properties properties = new Item.Properties();
                    final BlockItem blockItem = new BlockItem(block, properties);
                    ResourceLocation registryName = block.getRegistryName();
                    if (null != registryName) {
                        blockItem.setRegistryName(registryName);
                    }
                    registry.register(blockItem);
                }
            });
            MinecraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                if (!Blocks.contains(block)) {
                    final Item.Properties properties = new Item.Properties();
                    properties.group(ItemGroup.ERVIN_MOD_1);
                    properties.group(ItemGroup.ERVIN_MOD_1_SEARCH);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    ResourceLocation registryName = block.getRegistryName();
                    if (null != registryName) {
                        blockItem.setRegistryName(registryName);
                    }
                    registry.register(blockItem);
                }
            });
            isBurnableBlockItemInit.BURNABLE_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                if (!Blocks.contains(block)) {
                    final Item.Properties properties = new Item.Properties().isBurnable();
                    properties.group(ItemGroup.ERVIN_MOD_1);
                    properties.group(ItemGroup.ERVIN_MOD_1_SEARCH);
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
            ResourceLocation MaterialBlocksTagId = new ResourceLocation(com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1.MOD_ID, "material_blocks");
            ITag<Block> MaterialBlocks = BlockTags.getCollection().get(MaterialBlocksTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> blockState.isIn(MaterialBlocks) && player.isCreative())) {
                event.setCanceled(true);
            }
        }
        @SubscribeEvent
        public static void onLeftClick1Block(final PlayerInteractEvent.LeftClickBlock event) {
            ResourceLocation Material1BlocksTagId = new ResourceLocation(com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1.MOD_ID, "material_blocks1");
            ITag<Block> MaterialBlocks1 = BlockTags.getCollection().get(Material1BlocksTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> blockState.isIn(MaterialBlocks1))) {
                event.setCanceled(true);
            }
        }
    }

    public void tick(PlayerEntity player) {
        player.tick();
        updateTurtleHelmet(player);
    }

    private void updateTurtleHelmet(PlayerEntity player) {
        ItemStack itemstack = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (itemstack.getItem() == ItemInit.FRISZERN && !player.areEyesInFluid(FluidTags.WATER)) {
            player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        }

    }

    public static Block blockRegister(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn);
    }

    public static Item itemRegister(ResourceLocation key, Item itemIn) {
        if (itemIn instanceof BlockItem) {
            ((BlockItem)itemIn).addToBlockToItemMap(Item.BLOCK_TO_ITEM, itemIn);
        }

        return Registry.register(Registry.ITEM, key, itemIn);
    }

    public static <T extends Entity> EntityType<T> entityRegister(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }

    public static String[] string(String[] strings) {
        return strings;
    }

    public static String modId(String modId, String name) {
        return modId + ':' + name;
    }

    public static void setWorldRegistryKey(String modId, String string) {
        string(decompose(modId, string, ':'));
    }

    public static String[] decompose(String string, String resourceName, char splitOn) {
        String[] astring = new String[]{string, resourceName};
        int i = resourceName.indexOf(splitOn);
        if (i >= 0) {
            astring[1] = resourceName.substring(i + 1);
            if (i >= 1) {
                astring[0] = resourceName.substring(0, i);
            }
        }

        return astring;
    }

    public Minecraft minecraft() {
        return minecraft;
    }

    //https://mcforge.readthedocs.io/en/1.16.x/concepts/sides/
}
