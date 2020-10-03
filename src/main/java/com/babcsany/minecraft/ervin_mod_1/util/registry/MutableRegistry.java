package com.babcsany.minecraft.ervin_mod_1.util.registry;

import com.mojang.serialization.Lifecycle;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;

public abstract class MutableRegistry<T> extends net.minecraft.util.registry.Registry<T> {
   public MutableRegistry(RegistryKey<Registry<T>> registryKey, Lifecycle lifecycle) {
      super(registryKey, lifecycle);
   }

   public abstract <V extends T> V register(int id, RegistryKey<T> name, V instance);

   public abstract <V extends T> V register(RegistryKey<T> name, V instance);

   public abstract void func_239662_d_(RegistryKey<T> key);
}