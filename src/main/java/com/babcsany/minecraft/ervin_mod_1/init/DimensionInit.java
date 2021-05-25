package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.mojang.serialization.Lifecycle;
import net.minecraft.server.IDynamicRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.ColumnFuzzedBiomeMagnifier;
import net.minecraft.world.biome.IBiomeMagnifier;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Passthrough;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.OptionalLong;
import java.util.function.Supplier;

public class DimensionInit {


    //public static final RegistryKey<Dimension> OVERWORLD = RegistryKey.func_240903_a_(Registry.DIMENSION_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID,"example_world"));
    public static final RegistryKey<Dimension> EXAMPLE_WORLD = RegistryKey.func_240903_a_(Registry.DIMENSION_KEY, new ResourceLocation("overworld"));

}
