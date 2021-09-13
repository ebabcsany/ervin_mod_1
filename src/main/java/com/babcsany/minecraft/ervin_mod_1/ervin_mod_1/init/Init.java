package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.DefaultInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.ModInit;
import com.babcsany.minecraft.ervin_mod_1.init.DimensionInit;
import com.babcsany.minecraft.ervin_mod_1.init.DimensionTypeInit;
import com.babcsany.minecraft.ervin_mod_1.init.WorldInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.MinecraftBlockItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Init {

    public Init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Class(modEventBus);
        register(modEventBus);
        default_register();
        init();
    }

    public IEventBus Class(IEventBus modEventBus) {
        Ervin_mod_1.Class(MinecraftBlockItems.class);
        return modEventBus;
    }

    public IEventBus register(IEventBus modEventBus) {
        new ModInit(modEventBus);
        return modEventBus;
    }

    public void default_register() {
        new DefaultInit();
    }

    public void init() {
        new DimensionInit();
        new DimensionTypeInit();
        new WorldInit();
    }
}
