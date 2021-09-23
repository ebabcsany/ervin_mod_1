package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.DefaultInit;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.ModInit;
import com.babcsany.minecraft.ervin_mod_1.forge.registries.Registries;
import com.babcsany.minecraft.ervin_mod_1.init.DimensionInit;
import com.babcsany.minecraft.ervin_mod_1.init.DimensionTypeInit;
import com.babcsany.minecraft.ervin_mod_1.init.WorldInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.MinecraftBlockItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

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

    public static class CreateRegistries<T extends IForgeRegistryEntry<T>> {
        public T object;
        public IForgeRegistry<T> ForgeRegistry;
        public String string;
        public DeferredRegister<T> OBJECT;

        public CreateRegistries(IForgeRegistry<T> iForgeRegistry, String name) {
            this.ForgeRegistry = iForgeRegistry;
            this.string = name;
            this.OBJECT = create(iForgeRegistry, name);
        }

        public static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> reg, String modid) {
            return DeferredRegister.create(reg, modid);
        }

        public static <B extends IForgeRegistryEntry<B>> Registries<B> get(IForgeRegistry<B> reg, String modId, IEventBus iEventBus) {
            DeferredRegister<B> OBJECT = create(reg, modId);
            OBJECT.register(iEventBus);
            return null;
        }
    }
}
