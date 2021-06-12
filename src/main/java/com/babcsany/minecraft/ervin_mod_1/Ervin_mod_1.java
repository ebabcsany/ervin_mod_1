package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.forge.DeferredWorkQueue;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.Hurvruj;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.*;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.world.gen.FeatureGen;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
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
import net.minecraft.world.server.ServerWorld;
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

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ervin_mod_1.MOD_ID)
public class Ervin_mod_1 {

    public static final RenderMaterial LOCATION_WATER_FLOW = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/water_flow"));
    public static final RenderMaterial LOCATION_WATER_OVERLAY = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/water_overlay"));
    public static final String MOD_ID = "ervin_mod_1";
    //public static final ITag<EntityType<?>> blacklisted = EntityTypeTags.func_232896_a_((new ResourceLocation("ervin_mod_1", "blacklisted")).toString());
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

        com.babcsany.minecraft.init.BlockInit.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.init.BlockItemInit.BLOCK_ITEMS.register(modEventBus);
        com.babcsany.minecraft.init.EntityInit.ENTITIES.register(modEventBus);
        //com.babcsany.minecraft.init.FluidInit.FLUIDS.register(modEventBus);
        com.babcsany.minecraft.init.ItemInit.ITEMS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityInit.LIWRAY.get(), Liwray.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.GWURST.get(), GwurstEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ZUR_ENTITY, ZurEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.DGRURB_ENTITY.get(), Dgrurb.registerAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.DGRURBK_ENTITY.get(), Dgrurbk.registerAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ROVENT_ENTITY.get(), RoventEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ZUR_NIRTRE_ENTITY.get(), ZurNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.FREIN_ENTITY.get(), FreinEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.VILT_ENTITY.get(), ViltEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.SRACH_ENTITY.get(), SrachEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.SHERT_ENTITY.get(), ShertEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.HHIJ_ENTITY.get(), HhijEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTREP_ENTITY.get(), TraderNirtre1Entity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.$_TRADER_ENTITY.get(), $TraderEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.ZOMBIE_TRADER_ENTITY.get(), ZombieTraderEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(EntityInit.GUBROV_ENTITY.get(), GubrovEntity.setCustomAttributes().create());
            EntitySpawnPlacementRegistry.register(EntityInit.$_TRADER_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Abstract$TraderEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.DGRURB_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.FREIN_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FreinEntity::func_223366_c);
            EntitySpawnPlacementRegistry.register(EntityInit.GUBROV_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
            EntitySpawnPlacementRegistry.register(EntityInit.HHIJ_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HhijAnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.ROVENT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RoventEntity::canRoventSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.SHERT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ShertEntity::func_223318_c);
            EntitySpawnPlacementRegistry.register(EntityInit.SRACH_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.VILT_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
            EntitySpawnPlacementRegistry.register(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.ZOMBIE_TRADER_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.ZUR_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.register(EntityInit.LIWRAY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
            EntitySpawnPlacementRegistry.func_209342_b(EntityInit.LIWRAY.get());
            EntitySpawnPlacementRegistry.func_209342_b(EntityInit.ZUR_ENTITY);
            //EntitySpawnPlacementRegistry.canSpawnEntity(EntityInit.LIWRAY, iWorld, SpawnReason.SPAWN_EGG, BlockPos.ZERO, new Random());
            EntitySpawnPlacementRegistry.getPlacementType(EntityInit.LIWRAY.get());
            EntitySpawnPlacementRegistry.getPlacementType(EntityInit.ZUR_ENTITY);

            float f_0_3F = 0.3F;
            float f_0_35F = 0.35F;
            float f_0_4F = 0.4F;
            float f_0_45F = 0.45F;
            float f_0_5F = 0.5F;
            float f_0_65F = 0.65F;
            float f_0_7F = 0.7F;
            float f3 = 0.85F;
            float f4 = 1.0F;
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

            //BiomeInit.registerBiomes();
        });

        DeferredWorkQueue.runLater(FeatureGen::GenerateFeature);
        DeferredWorkQueue.runLater(FeatureGen::getSpawns);
        //DeferredWorkQueue.runLater(BiomeInit::registerBiomes);

        /*Map<Item, Integer> map = Maps.newLinkedHashMap();
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.COAL_SLAB.get(), 8000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.CHARCOAL_SLAB.get(), 8000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.BlockItemInit.COAL_STAIRS.get(), 12000);
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
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockFoodItemInit.FIRG.get(), 600);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableFoodItemInit.GRINT.get(), 5400);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.GRINT_BLOCK.get(), 48600);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableFoodItemInit.DURG.get(), 437400);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.GRINT_SLAB.get(), 24300);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockItemInit.GRINT_STAIRS.get(), 37350);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockFoodItemInit.FIRG_SLAB.get(), 300);
        AbstractFurnaceTileEntity.addItemBurnTime(map, isBurnableBlockFoodItemInit.FIRG_STAIRS.get(), 450);
        AbstractFurnaceTileEntity.addItemBurnTime(map, com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit.FIRT_AXE.get(), 3800);
        AbstractFurnaceTileEntity.addItemBurnTime(map, com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit.FIRT_HOE.get(), 2600);
        AbstractFurnaceTileEntity.addItemBurnTime(map, ArmorItemInit.FIRT_BOOTS.get(), 4800);
        AbstractFurnaceTileEntity.addItemBurnTime(map, ArmorItemInit.FIRT_HELMET.get(), 6000);
        AbstractFurnaceTileEntity.addItemBurnTime(map, BlockItemInit.FIRT_BLOCK.get(), 12000);*/
    }

    /**protected static final Set<RenderMaterial> LOCATIONS_BUILTIN_TEXTURES = Util.make(Sets.newHashSet(), (p_229337_0_) -> {
        p_229337_0_.add(LOCATION_WATER_FLOW);
        //p_229337_0_.add(LOCATION_LAVA_FLOW);
        p_229337_0_.add(LOCATION_WATER_OVERLAY);
        //p_229337_0_.add(LOCATION_FIRE_0);
        //p_229337_0_.add(LOCATION_FIRE_1);
        p_229337_0_.add(BellTileEntityRenderer.BELL_BODY_TEXTURE);
        p_229337_0_.add(ConduitTileEntityRenderer.BASE_TEXTURE);
        p_229337_0_.add(ConduitTileEntityRenderer.CAGE_TEXTURE);
        p_229337_0_.add(ConduitTileEntityRenderer.WIND_TEXTURE);
        p_229337_0_.add(ConduitTileEntityRenderer.VERTICAL_WIND_TEXTURE);
        p_229337_0_.add(ConduitTileEntityRenderer.OPEN_EYE_TEXTURE);
        p_229337_0_.add(ConduitTileEntityRenderer.CLOSED_EYE_TEXTURE);
        p_229337_0_.add(EnchantmentTableTileEntityRenderer.TEXTURE_BOOK);
        //p_229337_0_.add(LOCATION_BANNER_BASE);
        //p_229337_0_.add(LOCATION_SHIELD_BASE);
        //p_229337_0_.add(LOCATION_SHIELD_NO_PATTERN);

        for(ResourceLocation resourcelocation : DESTROY_STAGES) {
            p_229337_0_.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, resourcelocation));
        }

        p_229337_0_.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, PlayerContainer1.EMPTY_ARMOR_SLOT_HELMET));
        p_229337_0_.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, PlayerContainer1.EMPTY_ARMOR_SLOT_CHESTPLATE));
        p_229337_0_.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, PlayerContainer1.EMPTY_ARMOR_SLOT_LEGGINGS));
        p_229337_0_.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, PlayerContainer1.EMPTY_ARMOR_SLOT_BOOTS));
        p_229337_0_.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, PlayerContainer1.EMPTY_ARMOR_SLOT_SHIELD));
        Atlases.collectAllMaterials(p_229337_0_::add);
    });* /

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
                    properties.group(ItemGroup.ERVIN_MOD_1);
                    //properties.group(ItemGroup.ERVIN_MOD_1_SEARCH);
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

    public static Optional<Vector3d> func_234567_a_(ServerWorld serverWorld, BlockPos pos, boolean p_234567_2_, boolean p_234567_3_) {
        BlockState blockstate = serverWorld.getBlockState(pos);
        Block block = blockstate.getBlock();
        if (block instanceof Hurvruj && blockstate.get(Hurvruj.CHARGES) > 0 && Hurvruj.doesHurvrujWork(serverWorld)) {
            Optional<Vector3d> optional = Hurvruj.func_235560_a_(EntityType.PLAYER, serverWorld, pos);
            if (!p_234567_3_ && optional.isPresent()) {
                serverWorld.setBlockState(pos, blockstate.with(Hurvruj.CHARGES, blockstate.get(Hurvruj.CHARGES) - 1), 15);
            }

            return optional;
        } else if (blockstate.isBed(serverWorld, pos, null) && BedBlock.func_235330_a_(serverWorld)) {
            return blockstate.getBedSpawnPosition(EntityType.PLAYER, serverWorld, pos, null);
        } else if (!p_234567_2_) {
            return Optional.empty();
        } else {
            boolean canSpawnInBlock = block.canSpawnInBlock();
            boolean spawnInBlock = serverWorld.getBlockState(pos.up()).getBlock().canSpawnInBlock();
            return canSpawnInBlock && spawnInBlock ? Optional.of(new Vector3d((double)pos.getX() + 0.5D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D)) : Optional.empty();
        }
    }

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
        public static void onLeftClick1Block(final PlayerInteractEvent.LeftClickBlock event) {
            ResourceLocation Material1BlocksTagId = new ResourceLocation(Ervin_mod_1.MOD_ID, "material_blocks1");
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

    /*@Nullable
    public ResourceLocation getName() {
        return this.name;
    }

    private static void addEntitiesToBiomes(Ervin_mod_1 event) {
        String arachnonSpawnBiomes = Configs.PCEntitySpawningConfig.arachnonSpawnBiomes.get();
        String arachnonSpawnTags = Configs.PCEntitySpawningConfig.arachnonDictionaryTags.get();
        String arachnonDictionaryBiomeBlacklist = Configs.PCEntitySpawningConfig.arachnonDictionaryBiomeBlacklist.get();
        int arachnonWeight = Configs.PCEntitySpawningConfig.arachnonDictionaryWeight.get();
        int arachnonMinSpawns = Configs.PCEntitySpawningConfig.arachnonDictionaryMinSpawns.get();
        int arachnonMaxSpawns = Configs.PCEntitySpawningConfig.arachnonDictionaryMaxSpawns.get();
        addEntitySpawnsToBiomes(event, EntityInit.GUBROV_ENTITY.get(), EntityClassification.MONSTER, arachnonSpawnBiomes, arachnonSpawnTags, arachnonDictionaryBiomeBlacklist, arachnonWeight, arachnonMinSpawns, arachnonMaxSpawns);
        String hellhoundSpawnBiomes = Configs.PCEntitySpawningConfig.hellhoundSpawnBiomes.get();
        String hellhoundSpawnTags = Configs.PCEntitySpawningConfig.hellhoundDictionaryTags.get();
        String hellhoundDictionaryBiomeBlacklist = Configs.PCEntitySpawningConfig.hellhoundDictionaryBiomeBlacklist.get();
        int hellhoundWeight = Configs.PCEntitySpawningConfig.hellhoundDictionaryWeight.get();
        int hellhoundMinSpawns = Configs.PCEntitySpawningConfig.hellhoundDictionaryMinSpawns.get();
        int hellhoundMaxSpawns = Configs.PCEntitySpawningConfig.hellhoundDictionaryMaxSpawns.get();
        addEntitySpawnsToBiomes(event, EntityInit.HHIJ_ENTITY.get(), EntityClassification.MONSTER, hellhoundSpawnBiomes, hellhoundSpawnTags, hellhoundDictionaryBiomeBlacklist, hellhoundWeight, hellhoundMinSpawns, hellhoundMaxSpawns);
        String crabSpawnBiomes = Configs.PCEntitySpawningConfig.crabSpawnBiomes.get();
        String crabSpawnTags = Configs.PCEntitySpawningConfig.crabDictionaryTags.get();
        String crabDictionaryBiomeBlacklist = Configs.PCEntitySpawningConfig.crabDictionaryBiomeBlacklist.get();
        int crabWeight = (Integer)Configs.PCEntitySpawningConfig.crabDictionaryWeight.get();
        int crabMinSpawns = (Integer)Configs.PCEntitySpawningConfig.crabDictionaryMinSpawns.get();
        int crabMaxSpawns = (Integer)Configs.PCEntitySpawningConfig.crabDictionaryMaxSpawns.get();
        addEntitySpawnsToBiomes(event, EntityInit.ROVENT_ENTITY.get(), EntityClassification.AMBIENT, crabSpawnBiomes, crabSpawnTags, crabDictionaryBiomeBlacklist, crabWeight, crabMinSpawns, crabMaxSpawns);
        String seahorseSpawnBiomes = (String)Configs.PCEntitySpawningConfig.seahorseSpawnBiomes.get();
        String seahorseSpawnTags = (String)Configs.PCEntitySpawningConfig.seahorseDictionaryTags.get();
        String seahorseDictionaryBiomeBlacklist = (String)Configs.PCEntitySpawningConfig.seahorseDictionaryBiomeBlacklist.get();
        int seahorseWeight = (Integer)Configs.PCEntitySpawningConfig.seahorseDictionaryWeight.get();
        int seahorseMinSpawns = (Integer)Configs.PCEntitySpawningConfig.seahorseDictionaryMinSpawns.get();
        int seahorseMaxSpawns = (Integer)Configs.PCEntitySpawningConfig.seahorseDictionaryMaxSpawns.get();
        addEntitySpawnsToBiomes(event, EntityInit.SRACH_ENTITY.get(), EntityClassification.AMBIENT, seahorseSpawnBiomes, seahorseSpawnTags, seahorseDictionaryBiomeBlacklist, seahorseWeight, seahorseMinSpawns, seahorseMaxSpawns);
        String acidicArchvineSpawnBiomes = (String)Configs.PCEntitySpawningConfig.acidicArchvineSpawnBiomes.get();
        String acidicArchvineSpawnTags = (String)Configs.PCEntitySpawningConfig.acidicArchvineDictionaryTags.get();
        String acidicArchvineDictionaryBiomeBlacklist = (String)Configs.PCEntitySpawningConfig.acidicArchvineDictionaryBiomeBlacklist.get();
        int acidicArchvineWeight = (Integer)Configs.PCEntitySpawningConfig.acidicArchvineDictionaryWeight.get();
        int acidicArchvineMinSpawns = (Integer)Configs.PCEntitySpawningConfig.acidicArchvineDictionaryMinSpawns.get();
        int acidicArchvineMaxSpawns = (Integer)Configs.PCEntitySpawningConfig.acidicArchvineDictionaryMaxSpawns.get();
        addEntitySpawnsToBiomes(event, EntityInit.ZUR_ENTITY.get(), EntityClassification.MONSTER, acidicArchvineSpawnBiomes, acidicArchvineSpawnTags, acidicArchvineDictionaryBiomeBlacklist, acidicArchvineWeight, acidicArchvineMinSpawns, acidicArchvineMaxSpawns);
        String bufflonSpawnBiomes = (String)Configs.PCEntitySpawningConfig.bufflonSpawnBiomes.get();
        String bufflonSpawnTags = (String)Configs.PCEntitySpawningConfig.bufflonDictionaryTags.get();
        String bufflonDictionaryBiomeBlacklist = (String)Configs.PCEntitySpawningConfig.bufflonDictionaryBiomeBlacklist.get();
        int bufflonWeight = (Integer)Configs.PCEntitySpawningConfig.bufflonDictionaryWeight.get();
        int bufflonMinSpawns = (Integer)Configs.PCEntitySpawningConfig.bufflonDictionaryMinSpawns.get();
        int bufflonMaxSpawns = (Integer)Configs.PCEntitySpawningConfig.bufflonDictionaryMaxSpawns.get();
        addEntitySpawnsToBiomes(event, EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), EntityClassification.CREATURE, bufflonSpawnBiomes, bufflonSpawnTags, bufflonDictionaryBiomeBlacklist, bufflonWeight, bufflonMinSpawns, bufflonMaxSpawns);
    }

    private static void addEntitySpawnsToBiomes(Ervin_mod_1 event, EntityType<?> entity, EntityClassification entityClassification, String entitySpawnBiomes, String entitySpawnTags, String entityDictionaryBiomeBlacklist, int entitySpawnWeight, int entityMinSpawns, int entityMaxSpawns) {
        List<String> foundBiomes = Arrays.asList(entitySpawnBiomes.replaceAll(" ", "").split(","));

        for(int i = 0; i < foundBiomes.size(); ++i) {
            List<String> entityBiomeSpawnValues = Arrays.asList(foundBiomes.get(i).replaceAll(" ", "").split("/"));
            if (((String)entityBiomeSpawnValues.get(0)).equals(event.getName().toString())) {
                Integer weight = null;
                Integer minSpawns = null;
                Integer maxSpawns = null;

                try {
                    if (entityBiomeSpawnValues.get(1) != null && entityBiomeSpawnValues.get(2) != null && entityBiomeSpawnValues.get(3) != null) {
                        try {
                            weight = Integer.parseInt((String)entityBiomeSpawnValues.get(1));
                            minSpawns = Integer.parseInt((String)entityBiomeSpawnValues.get(2));
                            maxSpawns = Integer.parseInt((String)entityBiomeSpawnValues.get(3));
                        } catch (NumberFormatException var18) {
                            System.out.println();
                            System.out.println("Pandoras Creatures has detected a problem in the entity-spawning config");
                            System.out.println("The Entity with the problem is: " + entity/*.func_212546_e().getString()* /);
                            System.out.println("One of the 3 Values for Biome: " + (String)entityBiomeSpawnValues.get(0) + " was invalid");
                            System.out.println(var18.toString());
                        }
                    }
                } catch (IndexOutOfBoundsException var19) {
                    System.out.println();
                    System.out.println("Pandoras Creatures has detected a problem in the entity-spawning config");
                    System.out.println("The Entity with the problem is: " + entity/*.func_212546_e().getString()* /);
                    System.out.println("One (or more), of the 3 Values for Biome: " + entityBiomeSpawnValues.get(0) + " was not found");
                }

                if (weight != null && minSpawns != null && maxSpawns != null) {
                    //event.getSpawns().func_242575_a(entityClassification, new Spawners(entity, MathHelper.func_76125_a(weight, 1, 1000), MathHelper.func_76125_a(minSpawns, 1, 100), MathHelper.func_76125_a(maxSpawns, 1, 100)));
                    if ((Boolean)Configs.PCEntitySpawningConfig.isDebugModeEnabled.get()) {
                        System.out.println("Added " + entity/*.func_212546_e().getString()* / + " to: " + (String)entityBiomeSpawnValues.get(0) + " weight: " + weight + " min: " + minSpawns + " max: " + maxSpawns);
                    }
                }
            }
        }

        List<String> foundTags = Arrays.asList(entitySpawnTags.replaceAll(" ", "").toUpperCase().split(","));

        label77:
        for(int i = 0; i < foundTags.size(); ++i) {
            Iterator var22 = BiomeDictionary.getBiomes(BiomeDictionary.Type.getType((String)foundTags.get(i), new BiomeDictionary.Type[]{}[0])).iterator();

            while(true) {
                RegistryKey biome;
                List blackListedBiomes;
                do {
                    do {
                        if (!var22.hasNext()) {
                            continue label77;
                        }

                        biome = (RegistryKey)var22.next();
                    } while(!biome.func_240901_a_().toString().equals(event.getName().toString()));

                    blackListedBiomes = Arrays.asList(entityDictionaryBiomeBlacklist.replaceAll(" ", "").split(","));
                } while(blackListedBiomes.contains(biome.func_240901_a_().toString()));

                List<String> biomesNames = new ArrayList();

                for(int j = 0; j < foundBiomes.size(); ++j) {
                    List<String> biomesInfo = Arrays.asList(((String)foundBiomes.get(j)).replaceAll(" ", "").split("/"));
                    biomesNames.add(biomesInfo.get(0));
                }

                if (!biomesNames.contains(biome.func_240901_a_().toString())) {
                    //event.getSpawns().func_242575_a(entityClassification, new Spawners(entity, entitySpawnWeight, entityMinSpawns, entityMaxSpawns));
                    if ((Boolean)Configs.PCEntitySpawningConfig.isDebugModeEnabled.get()) {
                        System.out.println("Added " + entity/*.func_212546_e().getString()* / + " to: " + biome.func_240901_a_().toString() + " weight: " + entitySpawnWeight + " min: " + entityMinSpawns + " max: " + entityMaxSpawns);
                    }
                }
            }
        }

    }

    public static class Configs {
        public static ClientConfig.ClientConfigValues PCClientConfig = null;
        public static CommonConfig.CommonConfigValues PCCommonConfig = null;
        public static EntitySpawningConfig.EntitySpawningConfigValues PCEntitySpawningConfig = null;

        public Configs() {
        }

        public static void registerConfigs() {
            PCClientConfig = ConfigHelper.register(Type.CLIENT, ClientConfig.ClientConfigValues::new, createConfigName("client"));
            PCCommonConfig = ConfigHelper.register(Type.COMMON, CommonConfig.CommonConfigValues::new, createConfigName("common"));
            PCEntitySpawningConfig = ConfigHelper.register(Type.COMMON, EntitySpawningConfig.EntitySpawningConfigValues::new, createConfigName("entity-spawning"));
        }

        private static String createConfigName(String name) {
            return "ervin_mod_1-" + name + ".toml";
        }
    }*/
}
