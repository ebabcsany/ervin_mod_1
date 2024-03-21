package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders.*;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class ModConfiguredSurfaceBuilders {
    private static final Codec<SurfaceBuilderConfig> CODEC = SurfaceBuilderConfig.CODEC;
    public static ConfiguredSurfaceBuilder<?> RIFT_SURFACE = register("rift_surface", ModSurfaceBuilder.RIFT_CONFIG);
    public static ConfiguredSurfaceBuilder<?> BHJUIG_SURFACE = register("bhjuig_surface", new TheBhjuigBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.BHJUIG_CONFIG);
    public static ConfiguredSurfaceBuilder<?> MIG_SURFACE = register("mig_surface", new MigBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.MIG_CONFIG);
    public static ConfiguredSurfaceBuilder<?> MIGV_SURFACE = register("migv_surface", new MigBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.MIG_CONFIG);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE0_SURFACE = register("example0_surface", new ExampleBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.EXAMPLE0_CONFIG);
    public static ConfiguredSurfaceBuilder<?> END_SURFACE0 = register("end_surface0", new EndBiomeSurfaceBuilder0(CODEC), SurfaceBuilder.END_STONE_CONFIG);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE_SURFACE = register("example_surface", new ExampleBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.COARSE_DIRT_DIRT_DIRT_CONFIG);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE_SURFACE1 = register("example_surface1", new ExampleBiomeSurfaceBuilder1(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG1);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE_SURFACE2 = register("example_surface2", new ExampleBiomeSurfaceBuilder2(CODEC), ModSurfaceBuilder.COARSE_DIRT_DIRT_DIRT_CONFIG);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE_SURFACE3 = register("example_surface3", new ExampleBiomeSurfaceBuilder3(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG3);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE_SURFACE4 = register("example_surface4", new ExampleBiomeSurfaceBuilder4(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG4);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE_SURFACE5 = register("example_surface5", new ExampleBiomeSurfaceBuilder5(CODEC), ModSurfaceBuilder.COARSE_DIRT_DIRT_DIRT_CONFIG);
    public static ConfiguredSurfaceBuilder<?> EXAMPLE_SURFACE6 = register("example_surface6", new ExampleBiomeSurfaceBuilder6(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG6);
    public static ConfiguredSurfaceBuilder<?> SRIUNK_VALLEY_SURFACE = register("sriunk_valley_surface", new SriunkValleySurfaceBuilder(CODEC), ModSurfaceBuilder.SRIUNK_VALLEY_CONFIG);
    public static ConfiguredSurfaceBuilder<?> MUHK_SURFACE = register("muhk_surface", SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
    public static ConfiguredSurfaceBuilder<?> FIRG_SURFACE = register("firg_surface", new FirgBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.FIRG_CONFIG);
    public static ConfiguredSurfaceBuilder<?> SCRAFTH_SURFACE = register("scrafth_surface", new ScrafthBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.SCRAFTH_CONFIG);
    public static ConfiguredSurfaceBuilder<?> TWUST_SURFACE = register("twust_surface", new TwustBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.TWUST_CONFIG);

    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> ConfiguredSurfaceBuilder<C> register(String key, F builderIn, C config) {
        return new ConfiguredSurfaceBuilder<>(register(key, builderIn), config);
    }

    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return Registry.register(Registry.SURFACE_BUILDER, Ervin_mod_1.MOD_ID + ":" + key, builderIn);
    }

    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> register(String name, String top, String under, String underWater) {
        return register(name, "", top, under, underWater);
    }

    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> register(String name, String blocksNamespace, String top, String under, String underWater) {
        return register(name, getBlock(blocksNamespace, top), getBlock(blocksNamespace, under), getBlock(blocksNamespace, underWater));
    }

    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> register(String name, Block top, Block under, Block underWater) {
        return register(name, getState(top), getState(under), getState(underWater));
    }

    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> register(String name, BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial) {
        return register(name, ModSurfaceBuilder.register(topMaterial, underMaterial, underWaterMaterial));
    }

    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> register(String name, SurfaceBuilderConfig config) {
        return register(name, SurfaceBuilder.DEFAULT.func_242929_a(config));
    }

    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Ervin_mod_1.MOD_ID, name), csb);
    }

    private static Block getBlock(String path) {
        return getBlock("", path);
    }

    private static Block getBlock(String blocksNamespace, String path) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(blocksNamespace, path));
    }

    private static BlockState getState(Block block) {
        return block.getDefaultState();
    }
}
