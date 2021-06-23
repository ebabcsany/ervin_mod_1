package com.babcsany.minecraft.init;

import com.babcsany.minecraft.world.gen.feature.config.BuriedTreasureConfig;
import com.babcsany.minecraft.world.gen.feature.structure.BuriedTreasureStructure;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

public class StructureInit<C extends IFeatureConfig> extends Structure<C> {

    public static StructureInit<?> STRUCTURES;

    public static final Structure<BuriedTreasureConfig> BURIED_TREASURE_CONFIG_STRUCTURE = Structure.func_236394_a_("ervin_mod_1:Buried_Treasure", new BuriedTreasureStructure(BuriedTreasureConfig.buriedTreasureConfigCodec), GenerationStage.Decoration.UNDERGROUND_STRUCTURES);

    public StructureInit(Codec<C> p_i231997_1_) {
        super(p_i231997_1_);
    }

    @Override
    public IStartFactory<C> getStartFactory() {
        return null;
    }
}
