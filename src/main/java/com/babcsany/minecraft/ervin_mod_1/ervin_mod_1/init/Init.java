package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.*;
import com.babcsany.minecraft.ervin_mod_1.init.block.FluidBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.container.FurnaceContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.fluid.FlowingFluidInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.$ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.FluidBucketInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.HorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableHorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds.SeedsItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.tool.ToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.BlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.brefk.BrefkStageItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.MinecraftBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialItemInit;
import com.babcsany.minecraft.init.BlockItemInit;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.init.FeatureInit;
import com.babcsany.minecraft.init.ParticleInit;
import com.babcsany.minecraft.init.TileEntityInit;
import com.babcsany.minecraft.init.*;
import com.babcsany.minecraft.init.item.ItemInit;
import com.babcsany.minecraft.init.item.icsvre.IcsvreInit;
import com.babcsany.minecraft.init.special.PaintingEntityInit;
import com.babcsany.minecraft.init.special.PaintingItemInit;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Init {

    public Init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Class(modEventBus);
        register(modEventBus);
        default_register(modEventBus);
        init();
    }

    public IEventBus Class(IEventBus modEventBus) {
        Ervin_mod_1.Class(MinecraftBlockItems.class);
        return modEventBus;
    }

    public IEventBus register(IEventBus modEventBus) {
        BiomeInit.BIOMES.register(modEventBus);
        IMolaBlocks.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit.BURNABLE_BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.animation.colors.BlockItemInit.ANIMATION_BLOCKS.register(modEventBus);
        MinecraftBlocks.BLOCKS.register(modEventBus);
        BlockItemInit_.BLOCK_ITEMS.register(modEventBus);
        SpecialBlockFoodItemInit.BURNABLE_FOOD_BLOCK_ITEMS.register(modEventBus);
        isBurnableFoodItemInit.BURNABLE_FOODS.register(modEventBus);
        BlockFoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit.BLOCK_ITEMS.register(modEventBus);
        ContainerInit.CONTAINER_TYPES.register(modEventBus);
        FurnaceContainerInit.CONTAINER_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.DecoratorInit.DECORATORS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.EntityInit.ENTITY_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.FeatureInit.FEATURES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit.FLUIDS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit.FLUID_BLOCKS.register(modEventBus);
        FluidBlockInit.FLUID_BLOCKS.register(modEventBus);
        FlowingFluidInit.FLOWING_FLUIDS.register(modEventBus);
        BrefkStageItemInit.BREFK.register(modEventBus);
        FoodItemInit.FOODS.register(modEventBus);
        FluidBucketInit.FLUID_BUCKETS.register(modEventBus);
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
        BlockNamedItemInit.ITEMS.register(modEventBus);
        isBurnableSpecialBlockItemInit.SPECIAL_ITEMS.register(modEventBus);
        isBurnableSpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.special.SpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        ToolItemInit.TOOLS.register(modEventBus);
        SpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        $ItemInit.$.register(modEventBus);
        SeedsItemInit.SEEDS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.item.ItemInit.ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.BlockFoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.FoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.BlockNamedItemInit.BLOCK_ITEMS.register(modEventBus);
        SpecialBlockInit.SPECIAL_BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.ParticleInit.PARTICLE_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.SoundInit.SOUNDS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.SurfaceBuilderInit.SURFACE_BUILDERS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.TileEntityInit.TILE_ENTITY_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.TreeDecoratorInit.TREE_DECORATOR_TYPES.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.WorldCarverInit.CARVERS.register(modEventBus);
        return modEventBus;
    }

    public IEventBus default_register(IEventBus modEventBus) {
        BlockInit BLOCKS = BlockInit.BLOCKS;
        BlockItemInit BLOCK_ITEMS = BlockItemInit.BLOCK_ITEMS;
        EntityInit ENTITIES = EntityInit.ENTITIES;
        ItemInit ITEMS = ItemInit.ITEMS;
        com.babcsany.minecraft.init.item.spawn_egg.ModSpawnEggItemInit SPAWN_EGGS = com.babcsany.minecraft.init.item.spawn_egg.ModSpawnEggItemInit.SPAWN_EGGS;
        IcsvreInit ICSVRE = IcsvreInit.ICSVRE;
        FluidInit FLUIDS = FluidInit.FLUIDS;
        FeatureInit FEATURES = FeatureInit.FEATURES;
        EffectInit EFFECTS = EffectInit.EFFECTS;
        ParticleInit PARTICLES = ParticleInit.PARTICLES;
        TileEntityInit<?> TILE_ENTITIES = TileEntityInit.TILE_ENTITIES;
        PaintingEntityInit PAINTING_ENTITIES = PaintingEntityInit.PAINTING_ENTITIES;
        PaintingItemInit PAINTING_ITEMS = PaintingItemInit.PAINTING_ITEMS;
        Dimension DIMENSIONS = DimensionInit.DIMENSIONS;
        DimensionType DIMENSION_TYPES = DimensionTypeInit.DIMENSION_TYPES;
        WorldInit WORLD = WorldInit.WORLDS;
        System.out.println(modEventBus);
        return modEventBus;
    }

    public void init() {
        new DimensionInit();
        new DimensionTypeInit();
        new WorldInit();
    }
}