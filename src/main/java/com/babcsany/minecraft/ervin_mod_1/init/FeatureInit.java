package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.BigScrafthMushroomFeature;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            Ervin_mod_1.MOD_ID);



    //public static final RegistryObject<Feature<NoFeatureConfig>> PILLAGER_OUTPOST = FEATURES.register("pillager_outpost", () -> new PillagerOutpostStructure(NoFeatureConfig.field_236558_a_));
    //public static final RegistryObject<Feature<OreFeatureConfig1>> ORE = FEATURES.register("ore", new OreFeature1(OreFeatureConfig1::deserialize));
    public static final RegistryObject<Feature<BigMushroomFeatureConfig>> HUGE_SCRAFTH_MUSHROOM = FEATURES.register("huge_scrafth_mushroom", () -> new BigScrafthMushroomFeature(BigMushroomFeatureConfig.CODEC));
}
