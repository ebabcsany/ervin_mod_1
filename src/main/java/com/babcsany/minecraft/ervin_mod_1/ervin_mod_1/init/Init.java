package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.entity.ModEntityClassification;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.Compost;
import com.babcsany.minecraft.ervin_mod_1.init.*;
import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.container.FurnaceContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.$ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.PaintingInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.HorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.iron.IronArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableHorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds.SeedsItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.tool.EnderToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.BlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.brefk.BrefkStageItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.MilkBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.MilkFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.item.CropItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.iron.IronToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.stone.StoneToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.MinecraftBlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
import com.babcsany.minecraft.ervin_mod_1.world.biome.provider.ModBiomeProvider;
import com.babcsany.minecraft.init.BlockItemInit;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.init.ParticleInit;
import com.babcsany.minecraft.init.*;
import com.babcsany.minecraft.init.item.ItemInit;
import com.babcsany.minecraft.init.lc.block.blocks.H_u_fBlockInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class Init extends DefaultInit {

    public Init(IEventBus modEventBus) {
        super();
        register(modEventBus);
        default_register(modEventBus);
    }

    public static void register(IEventBus modEventBus) {
        SoundInit.register();
        BiomeInit.BIOMES.register(modEventBus);
        IMolaBlocks.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit.BLOCKS.register(modEventBus);
        BlockItemInit_.BLOCK_ITEMS.register(modEventBus);
        SpecialBlockFoodItemInit.BURNABLE_FOOD_BLOCK_ITEMS.register(modEventBus);
        isBurnableFoodItemInit.BURNABLE_FOODS.register(modEventBus);
        BlockFoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit.BLOCK_ITEMS.register(modEventBus);
        ContainerInit.CONTAINER_TYPES.register(modEventBus);
        FurnaceContainerInit.CONTAINER_TYPES.register(modEventBus);
        DecoratorInit.DECORATORS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.EntityInit.ENTITY_TYPES.register(modEventBus);
        ModFeatures.register();
        BrefkStageItemInit.REGISTER_BREFK_STAGE.register(modEventBus);
        FoodItemInit.FOODS.register(modEventBus);
        //FluidBucketInit.FLUID_BUCKETS.register(modEventBus);
        isBurnableItemInit.BURNABLE_ITEMS.register(modEventBus);
        SpecialToolItemInit.BURNABLE_ITEMS.register(modEventBus);
        ToolItemInit.TOOLS.register(modEventBus);
        isBurnableToolItemInit.BURNABLE_TOOLS.register(modEventBus);
        isBurnableSpecialToolItemInit.BURNABLE_ITEMS.register(modEventBus);
        ArmorItemInit.ARMOR.register(modEventBus);
        HorseArmorItemInit.HORSE_ARMOR.register(modEventBus);
        isBurnableArmorItemInit.BURNABLE_ARMOR.register(modEventBus);
        isBurnableHorseArmorItemInit.BURNABLE_HORSE_ARMOR.register(modEventBus);
        IronArmorItemInit.ARMOR.register(modEventBus);
        IronToolItemInit.TOOLS.register(modEventBus);
        StoneToolItemInit.TOOL_ITEMS.register(modEventBus);
        ModSpawnEggItemInit.SPAWN_EGGS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.minecraft.item.spawn_egg.SpawnEggItemInit.SPAWN_EGGS.register(modEventBus);
        BlockNamedItemInit.BLOCK_ITEMS.register(modEventBus);
        isBurnableSpecialBlockItemInit.SPECIAL_ITEMS.register(modEventBus);
        isBurnableSpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.special.SpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        EnderToolItemInit.register();
        SpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        $ItemInit.register();
        SeedsItemInit.register();
        CropItemInit.register();
        com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit.ITEMS.register(modEventBus);
        MilkBlockFoodItemInit.register();
        MilkFoodItemInit.FOOD_ITEMS.register(modEventBus);
        MinecraftBlockNamedItemInit.BLOCK_ITEMS.register(modEventBus);
        SpecialBlockInit.SPECIAL_BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.ParticleInit.PARTICLE_TYPES.register(modEventBus);
        ModTreeDecorators.register();
        com.babcsany.minecraft.ervin_mod_1.init.WorldCarverInit.CARVERS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.animation.colors.BlockItemInit.ANIMATION_BLOCKS.register(modEventBus);
        MinecraftBlocks.BLOCKS.register(modEventBus);
        isBurnableBlockItemInit.register();
    }

    public void default_register(IEventBus modEventBus) {
        BlockInit.register();
        UnusedBlockInit.BLOCK_DEFERRED_REGISTER.register(modEventBus);
        UnusedBlockItemInit.BLOCK_ITEM_DEFERRED_REGISTER.register(modEventBus);
        UnusedItemInit.ITEM_DEFERRED_REGISTER.register(modEventBus);
        H_u_fBlockInit.H_U_F_BLOCKS.register(modEventBus);
        BlockInit BLOCKS = BlockInit.BLOCKS;
        BlockItemInit.ITEMS.register(modEventBus);
        EntityInit ENTITIES = EntityInit.ENTITIES;
        ItemInit.REGISTER_ITEMS.register(modEventBus);
        FeatureInit.FEATURES.register(modEventBus);
        EffectInit EFFECTS = EffectInit.EFFECTS;
        ParticleInit PARTICLES = ParticleInit.PARTICLES;
        PaintingInit.PAINTINGS.register(modEventBus);
        registers();
        defaultRegister();
    }

    public void registers() {
        ModBiomeProvider.register();
        ModConfiguredSurfaceBuilders.register();
        ModBiomeMaker.register();
        ModEntityClassification.register();
        ModBiomeRegistry.register();
        ModDimensions.register();
        ModDimensionTypes.register();
        ModDimensionSettings.register();
        ModWorlds.register();
//        FireBlock.init();
        Compost.init();
    }

    public void defaultRegister() {
    }

    public static Init init(IEventBus modEventBus) {
        return new Init(modEventBus);
    }
}