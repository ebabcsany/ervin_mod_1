package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.biome.BiomeInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.dimension.DimensionInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.dimension_type.DimensionTypeInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.effect.EffectInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.entity.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.feature.FeatureInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.fluid.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.particle.ParticleInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.sound_event.SoundEventInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.tile_entity.TileEntityInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.world.WorldInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.Feature;

public class DefaultInit {
    public Biomes BIOMES;
    public Blocks BLOCKS;
    public Dimension DIMENSIONS;
    public DimensionType DIMENSION_TYPES;
    public Effects EFFECTS;
    public EntityType<?> ENTITIES;
    public Feature<?> FEATURES;
    public Fluids FLUIDS;
    public Items ITEMS;
    public ParticleTypes PARTICLES;
    public SoundEvents SOUND_EVENTS;
    public TileEntityType<?> TILE_ENTITIES;
    public World WORLDS;
    public DefaultInit() {
        register();
    }

    public void register() {
        new BiomeInit(BIOMES);
        new BlockInit(BLOCKS);
        new DimensionInit(DIMENSIONS);
        new DimensionTypeInit(DIMENSION_TYPES);
        new EffectInit(EFFECTS);
        new EntityInit(ENTITIES);
        new FeatureInit(FEATURES);
        new FluidInit(FLUIDS);
        new ItemInit(ITEMS);
        new ParticleInit(PARTICLES);
        new SoundEventInit(SOUND_EVENTS);
        new TileEntityInit(TILE_ENTITIES);
        new WorldInit(WORLDS);
    }
}
