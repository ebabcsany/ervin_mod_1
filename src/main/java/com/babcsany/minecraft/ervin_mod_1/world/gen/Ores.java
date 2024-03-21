package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.babcsany.minecraft.init.BlockInit;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.Tags;

public class Ores {
    public static final int OVERWORLD_VEINSIZE = 5;
    public static final int OVERWORLD_AMOUNT = 3;
    public static final int DEEPSLATE_VEINSIZE = 5;
    public static final int DEEPSLATE_AMOUNT = 3;
    public static final int NETHER_VEINSIZE = 5;
    public static final int NETHER_AMOUNT = 3;
    public static final int END_VEINSIZE = 10;
    public static final int END_AMOUNT = 6;

    public static final RuleTest IN_ENDSTONE = new TagMatchRuleTest(Tags.Blocks.END_STONES);

    public static OreFeature OVERWORLD_OREGEN;
    public static OreFeature DEEPSLATE_OREGEN;
    public static OreFeature NETHER_OREGEN;
    public static OreFeature END_OREGEN;

    public static void registerConfiguredFeatures() {
        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.FIRT_BLOCK.get().getDefaultState(), OVERWORLD_VEINSIZE);
//        OVERWORLD_OREGEN = 4
    }
}
