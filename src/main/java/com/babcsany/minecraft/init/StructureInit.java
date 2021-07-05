package com.babcsany.minecraft.init;

import com.babcsany.minecraft.world.gen.feature.config.BuriedTreasureConfig;
import com.babcsany.minecraft.world.gen.feature.structure.BuriedTreasureStructure;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

import java.util.Locale;
import java.util.Map;

public abstract class StructureInit<C extends IFeatureConfig> extends Structure<C> {

    public static StructureInit<?> STRUCTURES;

    private static final Map<Structure<?>, GenerationStage.Decoration> field_236385_u_ = Maps.newHashMap();

    public static final Structure<BuriedTreasureConfig> BURIED_TREASURE_STRUCTURE = register("ervin_mod_1:Buried_Treasure", new BuriedTreasureStructure(BuriedTreasureConfig.buriedTreasureConfigCodec), GenerationStage.Decoration.UNDERGROUND_STRUCTURES);

    public StructureInit(Codec<C> p_i231997_1_) {
        super(p_i231997_1_);
    }

    public static <F extends Structure<?>> F register(String string, F F, GenerationStage.Decoration decoration) {
        field_236365_a_.put(string.toLowerCase(Locale.ROOT), F);
        field_236385_u_.put(F, decoration);
        return Registry.register(Registry.STRUCTURE_FEATURE, string.toLowerCase(Locale.ROOT), F);
    }

    @Override
    public abstract IStartFactory<C> getStartFactory();
}
