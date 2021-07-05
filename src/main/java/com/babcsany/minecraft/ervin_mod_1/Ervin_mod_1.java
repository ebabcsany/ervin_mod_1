package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.*;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.*;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.Dgrurb;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk.Dgrurbk;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.Ervin_mod_1_;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.world.gen.FeatureGen;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Util;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraft.block.*;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.*;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.*;
import com.babcsany.minecraft.ervin_mod_1.init.*;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.container.FurnaceContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.$ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.HorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableHorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.SpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.tool.ToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.BlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.brefk.BrefkStageItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

import java.util.*;
import java.util.stream.Collectors;

import static com.babcsany.minecraft.forge.DeferredWorkQueue.runLater;
import static net.minecraft.client.renderer.model.ModelBakery.DESTROY_STAGES;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ervin_mod_1.MOD_ID)
public class Ervin_mod_1 {

    public static final RenderMaterial LOCATION_JURK_FLOW = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(Ervin_mod_1.MOD_ID,"block/fluid/jurk_flow"));
    public static final RenderMaterial LOCATION_JURK_OVERLAY = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(Ervin_mod_1.MOD_ID,"block/fluid/jurk_overlay"));
    public static final String MOD_ID = "ervin_mod_1";
    //public static final ITag<EntityType<?>> blacklisted = EntityTypeTags.func_232896_a_((new ResourceLocation("ervin_mod_1", "blacklisted")).toString());
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    //public PlayerEntity player;
    //public Fluid fluid;

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

        BiomeInit.BIOMES.register(modEventBus);
        BrefkStageItemInit.BREFK.register(modEventBus);
        FoodItemInit.FOODS.register(modEventBus);
        IMolaBlocks.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.BLOCKS.register(modEventBus);
        ContainerInit.CONTAINER_TYPES.register(modEventBus);
        FurnaceContainerInit.CONTAINER_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.DecoratorInit.DECORATORS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.EntityInit.ENTITY_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.FeatureInit.FEATURES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.FluidInit.FLUIDS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit.ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.BURNABLE_ITEMS.register(modEventBus);
        SpecialToolItemInit.BURNABLE_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit.TOOLS.register(modEventBus);
        isBurnableToolItemInit.BURNABLE_TOOLS.register(modEventBus);
        isBurnableSpecialToolItemInit.BURNABLE_ITEMS.register(modEventBus);
        ArmorItemInit.ARMOR.register(modEventBus);
        HorseArmorItemInit.HORSE_ARMOR.register(modEventBus);
        isBurnableArmorItemInit.BURNABLE_ARMOR.register(modEventBus);
        isBurnableHorseArmorItemInit.BURNABLE_HORSE_ARMOR.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.armor.iron.ArmorItemInit.ARMOR.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.tool.iron.ToolItemInit.TOOLS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.tool.stone.ToolItemInit.TOOL_ITEMS.register(modEventBus);
        ModSpawnEggItemInit.SPAWN_EGGS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.minecraft.item.spawn_egg.SpawnEggItemInit.SPAWN_EGGS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit.BURNABLE_BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit.BLOCK_ITEMS.register(modEventBus);
        BlockNamedItemInit.ITEMS.register(modEventBus);
        SpecialBlockFoodItemInit.BURNABLE_FOOD_BLOCK_ITEMS.register(modEventBus);
        isBurnableFoodItemInit.BURNABLE_FOODS.register(modEventBus);
        BlockFoodItemInit.FOOD_ITEMS.register(modEventBus);
        isBurnableSpecialBlockItemInit.SPECIAL_ITEMS.register(modEventBus);
        isBurnableSpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        SpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        ToolItemInit.TOOLS.register(modEventBus);
        $ItemInit.$.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.item.ItemInit.ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.BlockFoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.FoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.SoundInit.SOUNDS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.ParticleInit.PARTICLE_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.SurfaceBuilderInit.SURFACE_BUILDERS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.TreeDecoratorInit.TREE_DECORATOR_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.WorldCarverInit.CARVERS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.TileEntityInit.TILE_ENTITY_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.animation.colors.BlockItemInit.ANIMATION_BLOCKS.register(modEventBus);
        MinecraftBlocks.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.BlockNamedItemInit.BLOCK_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit.BLOCK_ITEMS.register(modEventBus);

        Ervin_mod_1_.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityInit.LIWRAY.get(), Liwray.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.GWURST.get(), GwurstEntity.setCustomAttributes().create());
            //GlobalEntityTypeAttributes.put(EntityInit.PLAYER1, PlayerEntity.registerAttributes().create());
            GlobalEntityTypeAttributes.put(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, ZurEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.DGRURB_ENTITY.get(), Dgrurb.registerAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.DGRURBK_ENTITY.get(), Dgrurbk.registerAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ROVENT_ENTITY.get(), RoventEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ZUR_NIRTRE_ENTITY.get(), ZurNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.FREIN_ENTITY.get(), FreinEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.VILT_ENTITY.get(), ViltEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(com.babcsany.minecraft.init.EntityInit.SRACH_ENTITY, SrachEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.SHERT_ENTITY.get(), ShertEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.HHIJ_ENTITY.get(), HhijEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTREP_ENTITY.get(), TraderNirtre1Entity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.$_TRADER_ENTITY.get(), $TraderEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ZOMBIE_TRADER_ENTITY.get(), ZombieTraderEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(com.babcsany.minecraft.init.EntityInit.GUBROV, GubrovEntity.setCustomAttributes().create());
            EntitySpawnPlacementRegistry.register(EntityInit.$_TRADER_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Abstract$TraderEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.DGRURB_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.FREIN_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FreinEntity::func_223366_c);
            EntitySpawnPlacementRegistry.register(com.babcsany.minecraft.init.EntityInit.GUBROV, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
            EntitySpawnPlacementRegistry.register(EntityInit.HHIJ_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HhijAnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.ROVENT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RoventEntity::canRoventSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.SHERT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ShertEntity::func_223318_c);
            EntitySpawnPlacementRegistry.register(com.babcsany.minecraft.init.EntityInit.SRACH_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.VILT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.ZOMBIE_TRADER_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.LIWRAY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.func_209342_b(EntityInit.LIWRAY.get());
            EntitySpawnPlacementRegistry.func_209342_b(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY);
            //EntitySpawnPlacementRegistry.canSpawnEntity(EntityInit.LIWRAY, iWorld, SpawnReason.SPAWN_EGG, BlockPos.ZERO, new Random());
            EntitySpawnPlacementRegistry.getPlacementType(EntityInit.LIWRAY.get());
            EntitySpawnPlacementRegistry.getPlacementType(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY);

            FireBlock fireblock = (FireBlock)Blocks.FIRE;
            //fireblock.setFireInfo(com.babcsany.minecraft.init.BlockInit.FIRG_PLANKS, 5, 20);
            //fireblock.setFireInfo(BlockItemInit.FRIM_PLANKS.get(), 5, 20);

            ComposterBlock.registerCompostable(0.3F, BlockNamedItemInit.TARG_SEEDS.get());
            ComposterBlock.registerCompostable(0.35F, BlockItemInit.FRIM_LEAVES.get());
            ComposterBlock.registerCompostable(0.35F, BlockItemInit.FRIM_SAPLING.get());
            ComposterBlock.registerCompostable(0.4F, isBurnableBlockItemInit.FIRG_LEAVES.get());
            ComposterBlock.registerCompostable(0.4F, isBurnableBlockItemInit.FIRG_SAPLING.get());
            ComposterBlock.registerCompostable(0.45F, BlockFoodItemInit.SCRAFTH.get());
            ComposterBlock.registerCompostable(0.5F, SpecialBlockFoodItemInit.FIRG_SLAB.get());
            ComposterBlock.registerCompostable(0.65F, FoodItemInit.JAZZ_FRUIT.get());
            ComposterBlock.registerCompostable(0.7F, ItemInit.CHAK.get());
            ComposterBlock.registerCompostable(0.75F, SpecialBlockFoodItemInit.FIRG_STAIRS.get());
            ComposterBlock.registerCompostable(0.85F, FoodItemInit.FRIM.get());
            ComposterBlock.registerCompostable(1.0F, SpecialBlockFoodItemInit.FIRG.get());
            ComposterBlock.registerCompostable(1.25F, FoodItemInit.REAT.get());
            ComposterBlock.registerCompostable(4.0F, isBurnableFoodItemInit.GRINT.get());
            ComposterBlock.registerCompostable(8.0F, SpecialBlockFoodItemInit.GRINT_SLAB.get());
            ComposterBlock.registerCompostable(12.0F, SpecialBlockFoodItemInit.GRINT_STAIRS.get());
            ComposterBlock.registerCompostable(16.0F, SpecialBlockFoodItemInit.GRINT_BLOCK.get());
            ComposterBlock.registerCompostable(64.0F, isBurnableFoodItemInit.DURG.get());
            ComposterBlock.registerCompostable(210.0F, SpecialBlockFoodItemInit.VIRK_BLOCK.get());

            World.isYOutOfBounds(1024);
        });

        DeferredWorkQueue.runLater(FeatureGen::GenerateFeature);
        DeferredWorkQueue.runLater(FeatureGen::getSpawns);
        //DeferredWorkQueue.runLater(BiomeInit::registerBiomes);

        /*Map<Item, Integer> map = Maps.newLinkedHashMap();
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.COAL_SLAB.get(), 8000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.CHARCOAL_SLAB.get(), 8000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks.COAL_STAIRS.get(), 12000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.CHARCOAL_STAIRS.get(), 12000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.CHARCOAL_BLOCK.get(), 16000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.GART.get(), 45000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.GARB.get(), 101200);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.GARK.get(), 227700);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.GARK_BLOCK.get(), 512300);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.GARK_SLAB.get(), 256150);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.GARK_STAIRS.get(), 384225);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.GARKT.get(), 1152600);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.GARKTH.get(), 4610400);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.TRAGH.get(), 10373400);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.TRAGK.get(), 23340100);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.TRAGK_BLOCK.get(), 58350200);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableItemInit.TRAGT.get(), 145875500);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.TRAGN.get(), 364688750);
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.CHARCOAL_BLOCK.get(), 16000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, ItemInit.FIRT.get(), 1200);
        AbstractFurnaceTileEntity.addItemBurnTime(map, SpecialBlockFoodItemInit.FIRG.get(), 600);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableFoodItemInit.GRINT.get(), 5400);
        AbstractFurnaceTileEntity.addItemBurnTime(map, SpecialBlockFoodItemInit.GRINT_BLOCK.get(), 48600);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableFoodItemInit.DURG.get(), 437400);
        AbstractFurnaceTileEntity.addItemBurnTime(map, SpecialBlockFoodItemInit.GRINT_SLAB.get(), 24300);
        AbstractFurnaceTileEntity.addItemBurnTime(map, SpecialBlockFoodItemInit.GRINT_STAIRS.get(), 37350);
        AbstractFurnaceTileEntity.addItemBurnTime(map, SpecialBlockFoodItemInit.FIRG_SLAB.get(), 300);
        AbstractFurnaceTileEntity.addItemBurnTime(map, SpecialBlockFoodItemInit.FIRG_STAIRS.get(), 450);
        AbstractFurnaceTileEntity.addItemBurnTime(map, com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit.FIRT_AXE.get(), 3800);
        AbstractFurnaceTileEntity.addItemBurnTime(map, com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit.FIRT_HOE.get(), 2600);
        AbstractFurnaceTileEntity.addItemBurnTime(map, ArmorItemInit.FIRT_BOOTS.get(), 4800);
        AbstractFurnaceTileEntity.addItemBurnTime(map, ArmorItemInit.FIRT_HELMET.get(), 6000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.FIRT_BLOCK.get(), 12000);*/
    }

    /*private int getInventoryStackLimit() {
        return 2048;
    }*/

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
                    properties.group(ItemGroup.ERVIN_MOD_1).group(ItemGroup.ERVIN_MOD_1_SEARCH);
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
                    properties.group(ItemGroup.ERVIN_MOD_1).group(ItemGroup.ERVIN_MOD_1_SEARCH);
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
                    properties.group(ItemGroup.ERVIN_MOD_1).group(ItemGroup.ERVIN_MOD_1_SEARCH);
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
            if (event.getWorld().hasBlockState(event.getPos(), blockState -> {
                assert MaterialBlocks != null;
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
}
