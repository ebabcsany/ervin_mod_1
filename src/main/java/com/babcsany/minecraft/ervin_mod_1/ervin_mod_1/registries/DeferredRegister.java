package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class DeferredRegister<T extends IForgeRegistryEntry<T>> {
    /**
     * Use for vanilla/forge registries. See example above.
     */
    public static <B extends IForgeRegistryEntry<B>> DeferredRegister<B> create(IForgeRegistry<B> reg, String modid)
    {
        return new DeferredRegister<>(reg, modid);
    }

    /**
     * Use for custom registries that are made during the NewRegistry event.
     */
    public static <B extends IForgeRegistryEntry<B>> DeferredRegister<B> create(Class<B> base, String modid)
    {
        return new DeferredRegister<>(base, modid);
    }

    private final Class<T> superType;
    private final String modid;
    private final Map<RegistryObject<T>, Supplier<? extends T>> entries = new LinkedHashMap<>();
    private final Set<RegistryObject<T>> entriesView = Collections.unmodifiableSet(entries.keySet());

    private IForgeRegistry<T> type;
    private Supplier<RegistryBuilder<T>> registryFactory;
    private boolean seenRegisterEvent = false;

    private DeferredRegister(Class<T> base, String modid)
    {
        this.superType = base;
        this.modid = modid;
    }

    private DeferredRegister(IForgeRegistry<T> reg, String modid)
    {
        this(reg.getRegistrySuperType(), modid);
        this.type = reg;
    }

    public DeferredRegister<T> register(String name, Supplier<T> supplier) {
        return new DeferredRegister<>(supplier.get().getRegistryType(), name);
    }
}
