package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders.MigSurfaceBuilder;
import com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders.SriunkBlockValleySurfaceBuilder;
import com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders.SurfaceBuilder2;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {

    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Ervin_mod_1.MOD_ID);

    public static final BlockState AIR = Blocks.AIR.getDefaultState();
    public static final BlockState STONE = Blocks.STONE.getDefaultState();
    public static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static final BlockState COARSE_DIRT = Blocks.COARSE_DIRT.getDefaultState();
    public static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    public static final BlockState END_STONE = Blocks.END_STONE.getDefaultState();
    //public static final BlockState EXAMPLE_BLOCK = BlockItemInit.EXAMPLE_BLOCK.get().getDefaultState();
    //public static final BlockState DEF_BLOCK = BlockItemInit.DEF_BLOCK.get().getDefaultState();
    public static final SurfaceBuilderConfig STONE_STONE_GRAVEL_CONFIG = new SurfaceBuilderConfig(STONE, STONE, GRAVEL);
    public static final SurfaceBuilderConfig COARSE_DIRT_DIRT_GRAVEL_CONFIG = new SurfaceBuilderConfig(COARSE_DIRT, DIRT, GRAVEL);
    public static final SurfaceBuilderConfig END_STONE_CONFIG = new SurfaceBuilderConfig(END_STONE, END_STONE, END_STONE);
    //public static final SurfaceBuilderConfig EXAMPLE_BLOCK_DEF_BLOCK_END_STONE_CONFIG = new SurfaceBuilderConfig(EXAMPLE_BLOCK, DEF_BLOCK, END_STONE);
    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> EXAMPLE_BIOME_SURFACE_BUILDER = SURFACE_BUILDERS.register("soul_sand_valley", () -> new SoulSandValleySurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));
    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> SRIUNK_BLOCK_VALLEY_SURFACE_BUILDER = SURFACE_BUILDERS.register("sriunk_block_valley", () -> new SriunkBlockValleySurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));
    /**public static final SurfaceBuilder<SurfaceBuilderConfig> MIG = register("ervin_mod_1:mig", new MigSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));
    //public static final SurfaceBuilder<SurfaceBuilderConfig> SURFACE_BUILDER_2 = register("ervin_mod_1:surface_builder_2", new SurfaceBuilder2(SurfaceBuilderConfig.field_237203_a_));*/

    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return Registry.register(Registry.SURFACE_BUILDER, key, builderIn);
    }
}
