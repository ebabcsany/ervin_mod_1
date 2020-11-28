package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.OreFeature1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.OreFeatureConfig1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.PillagerOutpostStructure1;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES,
            Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Feature<NoFeatureConfig>> PILLAGER_OUTPOST = FEATURES.register("pillager_outpost", new PillagerOutpostStructure1(NoFeatureConfig::deserialize));
    //public static final RegistryObject<Feature<OreFeatureConfig1>> ORE = FEATURES.register("ore", new OreFeature1(OreFeatureConfig1::deserialize));

}
