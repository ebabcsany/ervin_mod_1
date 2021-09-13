package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.dimension.settings.ModDimensionSettings;
import com.babcsany.minecraft.ervin_mod_1.registry.ModRegistry;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider.ExampleBiomeProvider;
import com.babcsany.minecraft.ervin_mod_1.world.gen.ModNoiseChunkGenerator;
import com.babcsany.minecraft.server.IDynamicRegistries;
import com.babcsany.minecraft.world.dimension;
import com.babcsany.minecraft.world.dimensionType;
import com.babcsany.minecraft.world.world;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.Lifecycle;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Optional;
import java.util.OptionalLong;

public class DimensionTypeInit extends dimensionType.T {
    public static DimensionType DIMENSION_TYPES;
    public static final RegistryKey<dimensionType> EXAMPLE = RegistryKey.func_240903_a_(ModRegistry.MOD_DIMENSION_TYPE_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID,"example"));
    public static final dimensionType EXAMPLE_TYPE = new dimensionType(OptionalLong.of(exampleLong), true, false, true, false, false, true, false, true, true, false, 1024, FuzzedBiomeMagnifier.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getName(), 0.0F);
    SimpleRegistry<Dimension> SimpleRegistry;
    IDynamicRegistries.Impl Impl;

    public DimensionTypeInit() {
        super();
    }

    public static DataResult<RegistryKey<world>> DataResult(Dynamic<?> p_236025_0_) {
        Optional<Number> optional = p_236025_0_.asNumber().result();
        if (optional.isPresent()) {
            if (i == 2) {
                return DataResult.success(WorldInit.EXAMPLE);
            }
        }

        return world.worldRegistryKeyCodec.parse(p_236025_0_);
    }

    public static SimpleRegistry<dimension> SimpleRegistry(long l) {
        SimpleRegistry<dimension> simpleRegistry = new SimpleRegistry<>(ModRegistry.MOD_DIMENSION_KEY, Lifecycle.experimental());
        simpleRegistry.register(DimensionInit.EXAMPLE, new dimension(() -> EXAMPLE_TYPE, ExampleChunkGenerator(l)));
        simpleRegistry.func_239662_d_(DimensionInit.EXAMPLE);
        return simpleRegistry;
    }

    public static IDynamicRegistries.Impl Impl(IDynamicRegistries.Impl impl) {
        impl.func_239774_a_(EXAMPLE, EXAMPLE_TYPE);
        impl.func_239774_a_(DIMENSION, DIMENSION_TYPE);
        return impl(impl);
    }

    public static ChunkGenerator ExampleChunkGenerator(long Long) {
        return new ModNoiseChunkGenerator(ExampleBiomeProvider.Preset.EXAMPLE.func_235292_a_(Long), Long, ModDimensionSettings.Preset.EXAMPLE.getSettings());
    }
}
