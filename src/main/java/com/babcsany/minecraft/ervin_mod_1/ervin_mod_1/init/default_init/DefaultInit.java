package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.biome.BiomeInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.effect.EffectInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.entity.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.feature.FeatureInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.fluid.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.painting.PaintingInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.particle.ParticleInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.sound_event.SoundEventInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.tile_entity.TileEntityInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.Feature;

public class DefaultInit {
    public Biomes BIOMES;
    public Blocks BLOCKS;
    public Effects EFFECTS;
    public EntityType<?> ENTITIES;
    public Feature<?> FEATURES;
    public Fluids FLUIDS;
    public Items ITEMS;
    public PaintingType PAINTINGS;
    public ParticleTypes PARTICLES;
    public SoundEvents SOUND_EVENTS;
    public TileEntityType<?> TILE_ENTITIES;
    public DefaultInit() {
        register();
    }

    public void register() {
        new BiomeInit(BIOMES);
        new BlockInit(BLOCKS);
        new EffectInit(EFFECTS);
        new EntityInit(ENTITIES);
        new FeatureInit(FEATURES);
        new FluidInit(FLUIDS);
        new ItemInit(ITEMS);
        new PaintingInit(PAINTINGS);
        new ParticleInit(PARTICLES);
        new SoundEventInit(SOUND_EVENTS);
        new TileEntityInit(TILE_ENTITIES);
    }
}
