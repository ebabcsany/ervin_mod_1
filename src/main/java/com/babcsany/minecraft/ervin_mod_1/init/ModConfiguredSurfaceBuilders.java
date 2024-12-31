package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders.*;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class ModConfiguredSurfaceBuilders {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Ervin_mod_1.MOD_ID);
    private static final Codec<SurfaceBuilderConfig> CODEC = SurfaceBuilderConfig.CODEC;
//    public static RegistryObject<TheBhjuigBiomeSurfaceBuilder> BHJUIG_SURFACE = SURFACE_BUILDERS.register("bhjuig_surface", () -> new TheBhjuigBiomeSurfaceBuilder(CODEC));
//    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> RIFT_SURFACE = register("rift_surface", SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.REDSTONE_BLOCK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.RED_CONCRETE.getDefaultState())));
//    public static RegistryObject<MigBiomeSurfaceBuilder> MIG_SURFACE = SURFACE_BUILDERS.register("mig_surface", () -> new MigBiomeSurfaceBuilder(CODEC));
//    public static RegistryObject<MigBiomeSurfaceBuilder> MIGV_SURFACE = SURFACE_BUILDERS.register("migv_surface", () -> new MigBiomeSurfaceBuilder(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder> EXAMPLE0_SURFACE = SURFACE_BUILDERS.register("example0_surface", () -> new ExampleBiomeSurfaceBuilder(CODEC));
//    public static RegistryObject<EndBiomeSurfaceBuilder0> END_SURFACE0 = SURFACE_BUILDERS.register("end_surface0", () -> new EndBiomeSurfaceBuilder0(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder> EXAMPLE_SURFACE = SURFACE_BUILDERS.register("example_surface", () -> new ExampleBiomeSurfaceBuilder(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder1> EXAMPLE_SURFACE1 = SURFACE_BUILDERS.register("example_surface1", () -> new ExampleBiomeSurfaceBuilder1(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder2> EXAMPLE_SURFACE2 = SURFACE_BUILDERS.register("example_surface2", () -> new ExampleBiomeSurfaceBuilder2(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder3> EXAMPLE_SURFACE3 = SURFACE_BUILDERS.register("example_surface3", () -> new ExampleBiomeSurfaceBuilder3(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder4> EXAMPLE_SURFACE4 = SURFACE_BUILDERS.register("example_surface4", () -> new ExampleBiomeSurfaceBuilder4(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder5> EXAMPLE_SURFACE5 = SURFACE_BUILDERS.register("example_surface5", () -> new ExampleBiomeSurfaceBuilder5(CODEC));
//    public static RegistryObject<ExampleBiomeSurfaceBuilder6> EXAMPLE_SURFACE6 = SURFACE_BUILDERS.register("example_surface6", () -> new ExampleBiomeSurfaceBuilder6(CODEC));
//    public static RegistryObject<SriunkValleySurfaceBuilder> SRIUNK_VALLEY_SURFACE = SURFACE_BUILDERS.register("sriunk_valley_surface", () -> new SriunkValleySurfaceBuilder(CODEC));
//    public static RegistryObject<FirgBiomeSurfaceBuilder> FIRG = SURFACE_BUILDERS.register("firg_surface", () -> new FirgBiomeSurfaceBuilder(CODEC));
//    public static RegistryObject<ScrafthBiomeSurfaceBuilder> SCRAFTH = SURFACE_BUILDERS.register("scrafth_surface", () -> new ScrafthBiomeSurfaceBuilder(CODEC));
//    public static RegistryObject<TwustBiomeSurfaceBuilder> TWUST = SURFACE_BUILDERS.register("twust_surface", () -> new TwustBiomeSurfaceBuilder(CODEC));
//    public static RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> MUHK = SURFACE_BUILDERS.register("muhk_surface", () -> new SurfaceBuilder<SurfaceBuilderConfig>(CODEC) {
//        @Override
//        public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
//            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
//        }
//    });
//    public static RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> BLOMUJN = SURFACE_BUILDERS.register("blomujn_surface", () -> new SurfaceBuilder<SurfaceBuilderConfig>(CODEC) {
//        @Override
//        public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
//            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilder.BLOMUJN_CONFIG);
//        }
//    });

    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> RIFT_SURFACE = register("rift_surface", ModSurfaceBuilder.RIFT_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> BHJUIG_SURFACE = register("bhjuig_surface", new TheBhjuigBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.BHJUIG_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> MIG_SURFACE = register("mig_surface", new MigBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.MIG_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> MIGV_SURFACE = register("migv_surface", new MigBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.MIG_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE0_SURFACE = register("example0_surface", new ExampleBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.EXAMPLE0_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> END_SURFACE0 = register("end_surface0", new EndBiomeSurfaceBuilder0(CODEC), SurfaceBuilder.END_STONE_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE_SURFACE = register("example_surface", new ExampleBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.COARSE_DIRT_DIRT_DIRT_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE_SURFACE1 = register("example_surface1", new ExampleBiomeSurfaceBuilder1(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG1);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE_SURFACE2 = register("example_surface2", new ExampleBiomeSurfaceBuilder2(CODEC), ModSurfaceBuilder.COARSE_DIRT_DIRT_DIRT_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE_SURFACE3 = register("example_surface3", new ExampleBiomeSurfaceBuilder3(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG3);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE_SURFACE4 = register("example_surface4", new ExampleBiomeSurfaceBuilder4(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG4);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE_SURFACE5 = register("example_surface5", new ExampleBiomeSurfaceBuilder5(CODEC), ModSurfaceBuilder.COARSE_DIRT_DIRT_DIRT_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> EXAMPLE_SURFACE6 = register("example_surface6", new ExampleBiomeSurfaceBuilder6(CODEC), ModSurfaceBuilder.EXAMPLE_CONFIG6);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> SRIUNK_VALLEY_SURFACE = register("sriunk_valley_surface", new SriunkValleySurfaceBuilder(CODEC), ModSurfaceBuilder.SRIUNK_VALLEY_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> FIRG = register("firg_surface", new FirgBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.FIRG_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> SCRAFTH = register("scrafth_surface", new ScrafthBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.SCRAFTH_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> TWUST = register("twust_surface", new TwustBiomeSurfaceBuilder(CODEC), ModSurfaceBuilder.TWUST_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> MUHK = register("muhk_surface", SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
    public static ConfiguredSurfaceBuilder<SurfaceBuilderConfig> BLOMUJN = register("blomujn_surface", ModSurfaceBuilder.BLOMUJN_CONFIG);


    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> ConfiguredSurfaceBuilder<C> register(String key, F builderIn, C config) {
        return new ConfiguredSurfaceBuilder<>(register(key, builderIn), config);
    }

    @Deprecated
    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return Registry.register(Registry.SURFACE_BUILDER, Ervin_mod_1.identifier(key), builderIn);
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

    public static void register() {
        Ervin_mod_1.register(ModConfiguredSurfaceBuilders.class);
    }
}
