package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> STONE = registerOres(ModBlockStates.STONE);
    public static final ConfiguredFeature<?, ?> BLACK_STONE = registerOres(ModBlockStates.BLACK_STONE);
    public static final ConfiguredFeature<?, ?> BLUE_STONE = registerOres(ModBlockStates.BLUE_STONE);
    public static final ConfiguredFeature<?, ?> BROWN_STONE = registerOres(ModBlockStates.BROWN_STONE);
    public static final ConfiguredFeature<?, ?> CYAN_STONE = registerOres(ModBlockStates.CYAN_STONE);
    public static final ConfiguredFeature<?, ?> GREEN_STONE = registerOres(ModBlockStates.GREEN_STONE);
    public static final ConfiguredFeature<?, ?> LIGHT_BLUE1_STONE = registerOres(ModBlockStates.LIGHT_BLUE1_STONE);
    public static final ConfiguredFeature<?, ?> LIGHT_BLUE_STONE = registerOres(ModBlockStates.LIGHT_BLUE_STONE);
    public static final ConfiguredFeature<?, ?> LIGHT_GRAY_STONE = registerOres(ModBlockStates.LIGHT_GRAY_STONE);
    public static final ConfiguredFeature<?, ?> LIME_STONE = registerOres(ModBlockStates.LIME_STONE);
    public static final ConfiguredFeature<?, ?> MAGENTA_STONE = registerOres(ModBlockStates.MAGENTA_STONE);
    public static final ConfiguredFeature<?, ?> ORANGE_STONE = registerOres(ModBlockStates.ORANGE_STONE);
    public static final ConfiguredFeature<?, ?> PINK_STONE = registerOres(ModBlockStates.PINK_STONE);
    public static final ConfiguredFeature<?, ?> PURPLE_STONE = registerOres(ModBlockStates.PURPLE_STONE);
    public static final ConfiguredFeature<?, ?> RED_STONE = registerOres(ModBlockStates.RED_STONE);
    public static final ConfiguredFeature<?, ?> WHITE_STONE = registerOres(ModBlockStates.WHITE_STONE);
    public static final ConfiguredFeature<?, ?> YELLOW_STONE = registerOres(ModBlockStates.YELLOW_STONE);
    public static final ConfiguredFeature<?, ?> EXTRA_BLUE_STONE = registerExtraOres(ModBlockStates.BLUE_STONE);
    public static final ConfiguredFeature<?, ?> EXTRA_ORANGE_STONE = registerExtraOres(ModBlockStates.ORANGE_STONE);
    public static final ConfiguredFeature<?, ?> EXTRA_SCRAFTH = registerExtraOres(ModBlockStates.SCRAFTH);

    public static ConfiguredFeature<?, ?> registerExtraOres(Block blockIn) {
        return registerExtraOres(blockIn.delegate.name().getPath(), blockIn.getDefaultState());
    }

    public static ConfiguredFeature<?, ?> registerOres(Block blockIn) {
        return registerOres(blockIn.delegate.name().getPath(), blockIn.getDefaultState());
    }
    public static ConfiguredFeature<?, ?> registerExtraOres(BlockState state) {
        return registerExtraOres(state.getBlock().delegate.name().getPath(), state);
    }

    public static ConfiguredFeature<?, ?> registerOres(BlockState state) {
        return registerOres(state.getBlock().delegate.name().getPath(), state);
    }

    public static ConfiguredFeature<?, ?> registerExtraOres(String name, Block blockIn) {
        return registerExtraOres(name, blockIn.getDefaultState());
    }

    public static ConfiguredFeature<?, ?> registerOres(String name, Block blockIn) {
        return registerOres(name, blockIn.getDefaultState());
    }

    public static ConfiguredFeature<?, ?> registerExtraOres(ModBlockStates states) {
        return registerExtraOres(states.getName(), states.getState());
    }

    public static ConfiguredFeature<?, ?> registerOres(ModBlockStates states) {
        return registerOres(states.getName(), states.getState());
    }

    public static ConfiguredFeature<?, ?> registerExtraOres(String name, BlockState state) {
        return register(name, extraOres(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, state));
    }

    public static ConfiguredFeature<?, ?> registerOres(String name, BlockState state) {
        return register(name, ores(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, state));
    }

    public static ConfiguredFeature<?, ?> extraOres(RuleTest test, BlockState state) {
        return ores(test, state, 400, 0, 0, 2000);
    }

    public static ConfiguredFeature<?, ?> ores(RuleTest test, BlockState state) {
        return ores(test, state, 40, 0, 0, 320);
    }

    public static ConfiguredFeature<?, ?> ores(RuleTest test, BlockState state, int size, int bottomOffset, int topOffset, int maximum) {
        return ore(new OreFeatureConfig(test, state, size)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(bottomOffset, topOffset, maximum)));
    }

    public static ConfiguredFeature<?, ?> ores(RuleTest test, BlockState state, int size, ConfiguredPlacement<?> placement) {
        return ore(new OreFeatureConfig(test, state, size)).withPlacement(placement);
    }

    public static ConfiguredFeature<?, ?> ore(OreFeatureConfig config) {
        return Feature.ORE.withConfiguration(config);
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Ervin_mod_1.identifier(key), configuredFeature);
    }

    public static final class Configs {

    }

    public static final class Placements {

    }

    public static final class States {

    }

    public static void register() {
        Ervin_mod_1.register(ModConfiguredFeatures.class);
    }
}
