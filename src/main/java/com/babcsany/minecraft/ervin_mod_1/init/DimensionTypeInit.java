package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.dimension.settings.ModDimensionSettings;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider.ExampleBiomeProvider;
import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.IDynamicRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.ColumnFuzzedBiomeMagnifier;
import net.minecraft.world.biome.IBiomeMagnifier;
import net.minecraft.world.biome.provider.NetherBiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.*;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;

public class DimensionTypeInit extends DimensionType {


    //public static final RegistryKey<Dimension> OVERWORLD = RegistryKey.func_240903_a_(Registry.DIMENSION_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID,"example_world"));
    public static final RegistryKey<DimensionType> EXAMPLE_WORLD = RegistryKey.func_240903_a_(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID,"example_world"));
    protected static final DimensionType EXAMPLE_WORLD_TYPE = new DimensionTypeInit(OptionalLong.empty(), true, false, false, true, false, false, false, true, false, true, 1000, ColumnFuzzedBiomeMagnifier.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getName(), 0.0F);

    protected DimensionTypeInit(OptionalLong p_i241242_1_, boolean p_i241242_2_, boolean p_i241242_3_, boolean p_i241242_4_, boolean p_i241242_5_, boolean p_i241242_6_, boolean p_i241242_7_, boolean p_i241242_8_, boolean p_i241242_9_, boolean p_i241242_10_, int p_i241242_11_, ResourceLocation p_i241242_12_, float p_i241242_13_) {
        super(p_i241242_1_, p_i241242_2_, p_i241242_3_, p_i241242_4_, p_i241242_5_, p_i241242_6_, p_i241242_7_, p_i241242_8_, p_i241242_9_, p_i241242_10_, p_i241242_11_, p_i241242_12_, p_i241242_13_);
    }

    protected DimensionTypeInit(OptionalLong p_i241243_1_, boolean p_i241243_2_, boolean p_i241243_3_, boolean p_i241243_4_, boolean p_i241243_5_, boolean p_i241243_6_, boolean p_i241243_7_, boolean p_i241243_8_, boolean p_i241243_9_, boolean p_i241243_10_, boolean p_i241243_11_, int p_i241243_12_, IBiomeMagnifier p_i241243_13_, ResourceLocation p_i241243_14_, float p_i241243_15_) {
        super(p_i241243_1_, p_i241243_2_, p_i241243_3_, p_i241243_4_, p_i241243_5_, p_i241243_6_, p_i241243_7_, p_i241243_8_, p_i241243_9_, p_i241243_10_, p_i241243_11_, p_i241243_12_, p_i241243_13_, p_i241243_14_, p_i241243_15_);
    }

    public static IDynamicRegistries.Impl func_236027_a_(IDynamicRegistries.Impl p_236027_0_) {
        p_236027_0_.func_239774_a_(EXAMPLE_WORLD, EXAMPLE_WORLD_TYPE);
        return p_236027_0_;
    }

    /*private static ChunkGenerator func_236041_e_(long p_236041_0_) {
        return new NoiseChunkGenerator(ExampleBiomeProvider.Preset.field_235288_b_.func_235292_a_(p_236041_0_), p_236041_0_, ModDimensionSettings.Preset.EXAMPLE.getSettings());
    }*/

    public static final ModDimensionSettings.Preset EXAMPLE = new ModDimensionSettings.Preset("example", (p_236141_0_) -> createSettings(new DimensionStructuresSettings(false), BlockItemInit.FIRT_BLOCK.get().getDefaultState(), Blocks.LAVA.getDefaultState(), p_236141_0_));

    private static ModDimensionSettings createSettings(DimensionStructuresSettings structures, BlockState defaultBlock, BlockState defaultFluid, ModDimensionSettings.Preset preset) {
        Map<Structure<?>, StructureSeparationSettings> map = Maps.newHashMap(DimensionStructuresSettings.field_236191_b_);
        map.put(Structure.field_236372_h_, new StructureSeparationSettings(25, 10, 34222645));
        return new ModDimensionSettings(new DimensionStructuresSettings(Optional.ofNullable(structures.func_236199_b_()), map), new NoiseSettings(128, new ScalingSettings(1.0D, 3.0D, 80.0D, 60.0D), new SlideSettings(120, 3, 0), new SlideSettings(320, 4, -1), 1, 2, 0.0D, 0.019921875D, false, false, false, false), defaultBlock, defaultFluid, 0, 0, 32, false, Optional.of(preset));
    }
}
