package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.dimension.settings.ModDimensionSettings;
import com.babcsany.minecraft.ervin_mod_1.world.ModDimensionType;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider.ExampleBiomeProvider;
import com.babcsany.minecraft.world.dimensionType;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.NoiseChunkGenerator;

import java.util.OptionalLong;

public class DimensionTypeInit extends dimensionType {
    public static DimensionType DIMENSION_TYPES;
    public long Long;
    public static final float[] MOON_PHASE_FACTORS = DimensionType.MOON_PHASE_FACTORS;
    public static final RegistryKey<DimensionType> EXAMPLE = RegistryKey.func_240903_a_(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID,"example"));
    public static final DimensionType EXAMPLE_TYPE = new ModDimensionType(OptionalLong.of(24000L), true, false, true, false, false, true, false, true, true, false, 1024, FuzzedBiomeMagnifier.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getName(), 0.0F);
    public static final RegistryKey<DimensionType> field_241497_i_ = RegistryKey.func_240903_a_(Registry.DIMENSION_TYPE_KEY, new ResourceLocation("overworld_caves"));
    public static final DimensionType field_241498_j_ = ModDimensionType.field_241498_j_;

    public DimensionTypeInit() {
        register();
    }

    public void register() {
        dimensionSimpleRegistry();
        impl();
        file();
    }

    public void dimensionSimpleRegistry() {
        dimensionSimpleRegistry(DimensionInit.EXAMPLE, new Dimension(() -> EXAMPLE_TYPE, chunk_generator(Long)));
    }

    public void impl() {
        impl(EXAMPLE, EXAMPLE_TYPE);
    }

    public void file() {
        file(WorldInit.EXAMPLE, "DIM_1");
    }

    private static ChunkGenerator chunk_generator(long Long) {
        return new NoiseChunkGenerator(ExampleBiomeProvider.Preset.field_235288_b_.func_235292_a_(Long), Long, ModDimensionSettings.Preset.EXAMPLE.getSettings());
    }
}
