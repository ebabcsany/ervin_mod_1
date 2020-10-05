package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biomes.ExampleBiomeSurfaceBuilder;
import com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders.ExampleSurfaceBuilder;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class SurfaceBuilderInit {

    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Ervin_mod_1.MOD_ID);

    public static final BlockState AIR = Blocks.AIR.getDefaultState();
    public static final BlockState STONE = Blocks.STONE.getDefaultState();
    public static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static final BlockState COARSE_DIRT = Blocks.COARSE_DIRT.getDefaultState();
    public static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    public static final SurfaceBuilderConfig STONE_STONE_GRAVEL_CONFIG = new SurfaceBuilderConfig(STONE, STONE, GRAVEL);
    public static final SurfaceBuilderConfig COARSE_DIRT_DIRT_CONFIG = new SurfaceBuilderConfig(STONE, STONE, GRAVEL);
    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> EXAMPLE_BIOME_SURFACE_BUILDER = SURFACE_BUILDERS.register("soul_sand_valley", () -> new SwampSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));

}
