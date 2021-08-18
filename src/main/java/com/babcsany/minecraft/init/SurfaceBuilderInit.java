package com.babcsany.minecraft.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.MountainSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SurfaceBuilderInit {

    public static final SurfaceBuilder<SurfaceBuilderConfig> MIG = register("ervin_mod_1:mig", new MountainSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return Registry.register(Registry.SURFACE_BUILDER, string(key), builderIn);
    }
}
