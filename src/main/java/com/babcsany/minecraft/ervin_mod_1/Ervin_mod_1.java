package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.ShertEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.Init;
import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.animation.colors.AnimationBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemModelsProperties;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import com.babcsany.minecraft.ervin_mod_1.network.ModNetworkManager;
import com.babcsany.minecraft.ervin_mod_1.world.gen.FeatureGen;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketDirection;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
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

    /**Game objects*/
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, MOD_ID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MOD_ID);

    /**Villages*/
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, MOD_ID);

    /**Worldgen*/
    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, MOD_ID);



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

        Init.init(modEventBus);
    }

    public void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        DeferredWorkQueue.runLater(() -> {
            EntitySpawnPlacementRegistry.register(EntityInit.$_TRADER.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Abstract$TraderEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.DGRURB.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.FREIN.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.GUBROV.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GubrovEntity::canGubrovSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.HHIJ.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HhijAnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.ROVENT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RoventEntity::canMonsterSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.SHERT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ShertEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.SRACH_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.VILT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.ZOMBIE_TRADER_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
//            EntitySpawnPlacementRegistry.register(EntityInit.NIRTRE_ENTITY, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.ZUR.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.WORLD_SURFACE_WG, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.LIWRAY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.func_209342_b(EntityInit.LIWRAY.get());
            EntitySpawnPlacementRegistry.func_209342_b(EntityInit.ZUR.get());
            EntitySpawnPlacementRegistry.getPlacementType(EntityInit.LIWRAY.get());
            EntitySpawnPlacementRegistry.getPlacementType(EntityInit.ZUR.get());


        });

        DeferredWorkQueue.runLater(FeatureGen::generateFeature);
        DeferredWorkQueue.runLater(FeatureGen::getSpawns);
        DeferredWorkQueue.runLater(FeatureGen::generateBlackStone);
//        new MixinConnector().connect();
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
        ModItemModelsProperties.init();
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
//            BlockItemInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
//                if (!Blocks.contains(block)) {
//                    final Item.Properties properties = new Item.Properties();
//                    properties.group(ModItemGroup.ERVIN_MOD_1).group(ModItemGroup.ERVIN_MOD_1_SEARCH);
//                    final BlockItem blockItem = new BlockItem(block, properties);
//                    ResourceLocation registryName = block.getRegistryName();
//                    if (null != registryName) {
//                        blockItem.setRegistryName(registryName);
//                    }
//                    registry.register(blockItem);
//                }
//            });
            AnimationBlockItemInit.ANIMATION_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
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
                    properties.group(ModItemGroup.ERVIN_MOD_1).group(ModItemGroup.ERVIN_MOD_1_SEARCH);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    ResourceLocation registryName = block.getRegistryName();
                    if (null != registryName) {
                        blockItem.setRegistryName(registryName);
                    }
                    registry.register(blockItem);
                }
            });
//            isBurnableBlockItemInit.BURNABLE_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
//                if (!Blocks.contains(block)) {
//                    final Item.Properties properties = new Item.Properties().isImmuneToFire();
//                    properties.group(ModItemGroup.ERVIN_MOD_1).group(ModItemGroup.ERVIN_MOD_1_SEARCH);
//                    final BlockItem blockItem = new BlockItem(block, properties);
//                    ResourceLocation registryName = block.getRegistryName();
//                    if (null != registryName) {
//                        blockItem.setRegistryName(registryName);
//                    }
//                    registry.register(blockItem);
//                }
//            });
            
        }

        @SubscribeEvent
        public static void onRegisterRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            ShapedRecipe.setCraftingSize(5, 5);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
        public static int respawnCountAtHurvruj = 0;

        @SubscribeEvent
        public static void onChangeDimension(final PlayerEvent.PlayerChangedDimensionEvent event) {
            PlayerEntity player = event.getPlayer();
            player.createSpawnPacket();
            player.setPosition(30, 30, 30);
            player.respawnPlayer();
            player.addExperienceLevel(30);
            player.preparePlayerToSpawn();
            EntityType.PLAYER.create(player.world);
            player.addItemStackToInventory(new ItemStack(ItemInit.EPKIN.get()));
            if (player instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                ServerWorld serverWorld = serverPlayer.getServerWorld();
            }
        }

        public static void  on(final Event event) {
//            event.
        }

        @SubscribeEvent
        public static void onRespawn(final PlayerEvent.PlayerRespawnEvent event) {

            try {
                ModNetworkManager modNetworkManager = new ModNetworkManager(PacketDirection.CLIENTBOUND);
                modNetworkManager.tick();
            } catch (Throwable throwable) {
                System.out.println(throwable.getLocalizedMessage());
            }
        }

        @SubscribeEvent
        public static void onLeftClickBlock(final PlayerInteractEvent.LeftClickBlock event) {
            PlayerEntity player = event.getPlayer();
            ResourceLocation MaterialBlocksTagId = new ResourceLocation(com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1.MOD_ID, "material_blocks");
            ITag<Block> MaterialBlocks = BlockTags.getCollection().get(MaterialBlocksTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> {
                if (MaterialBlocks == null) throw new AssertionError();
                return blockState.isIn(MaterialBlocks) && player.isCreative();
            })) {
                event.setCanceled(true);
            }
        }
        @SubscribeEvent
        public static void onLeftClick1Block(final PlayerInteractEvent.LeftClickBlock event) {
            ResourceLocation Material1BlocksTagId = new ResourceLocation(com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1.MOD_ID, "material_blocks1");
            ITag<Block> Material1Blocks = BlockTags.getCollection().get(Material1BlocksTagId);
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> {
                assert Material1Blocks != null;
                return blockState.isIn(Material1Blocks);
            })) {
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
        if (itemstack.getItem() == Items.TURTLE_HELMET && !player.areEyesInFluid(FluidTags.WATER)) {
            player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        }

    }

    @Deprecated
    public static <T extends Entity> EntityType<T> entityRegister(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }

    public static ResourceLocation getKey(String pathIn) {
        return new ResourceLocation(MOD_ID, pathIn);
    }

    public static void register(Class<?> value) {
        register(value.getName());
    }

    private static void register(String value) {
        System.out.println("Registered " + value + " in " + Ervin_mod_1.MOD_ID);
    }

    public static String identifier(String key) {
        return MOD_ID + ":" + key;
    }

    //https://mcforge.readthedocs.io/en/1.16.x/concepts/sides/
}
