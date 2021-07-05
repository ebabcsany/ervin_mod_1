package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.VoidStartPlatformFeature1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.FeatureGen;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.BigScrafthMushroomFeature;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeature;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.PillagerOutpostStructure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            Ervin_mod_1.MOD_ID);



    //public static final RegistryObject<Feature<NoFeatureConfig>> PILLAGER_OUTPOST = FEATURES.register("pillager_outpost", () -> new PillagerOutpostStructure(NoFeatureConfig.field_236558_a_));
    //public static final RegistryObject<Feature<OreFeatureConfig1>> ORE = FEATURES.register("ore", new OreFeature1(OreFeatureConfig1::deserialize));
    public static final RegistryObject<Feature<BigMushroomFeatureConfig>> HUGE_SCRAFTH_MUSHROOM = FEATURES.register("huge_scrafth_mushroom", () -> new BigScrafthMushroomFeature(BigMushroomFeatureConfig.field_236528_a_));
}
