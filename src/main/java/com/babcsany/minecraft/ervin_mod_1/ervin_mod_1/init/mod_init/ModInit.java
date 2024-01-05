package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.biome.BiomeInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.container.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.decorator.DecoratorInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.entity.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.feature.FeatureInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.fluid.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.particle.ParticleInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.sound.SoundInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.surface_builder.SurfaceBuilderInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.tile_entity.TileEntityInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.tree_decorator.TreeDecoratorInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.world_carver.WorldCarverInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModInit {

    public ModInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        new BiomeInit(modEventBus);
        new BlockInit(modEventBus);
        new ContainerInit(modEventBus);
        new DecoratorInit(modEventBus);
        new EntityInit(modEventBus);
        new FeatureInit(modEventBus);
        new FluidInit(modEventBus);
        new ItemInit(modEventBus);
        new ParticleInit(modEventBus);
        new SoundInit(modEventBus);
        new SurfaceBuilderInit(modEventBus);
        new TileEntityInit(modEventBus);
        new TreeDecoratorInit(modEventBus);
        new WorldCarverInit(modEventBus);
        return modEventBus;
    }
}
