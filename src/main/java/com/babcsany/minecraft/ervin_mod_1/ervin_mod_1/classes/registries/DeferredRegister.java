package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.registries;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.*;

import java.util.*;
import java.util.function.Supplier;

public class DeferredRegister<T extends IForgeRegistryEntry<T>> {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    private final Class<T> superType;
    private Class<T> superType1;
    private Supplier<? extends Class<?>> class$;
    private Supplier<RegistryBuilder<T>> registryFactory;
    private final String modId;
    private String string;
    private final Map<RegistryObject<T>, Supplier<? extends T>> entries = new LinkedHashMap<>();
    private final Set<RegistryObject<T>> entriesView = Collections.unmodifiableSet(entries.keySet());

    private IForgeRegistry<T> type;

    private DeferredRegister(Class<T> base, String modid)
    {
        this.superType = base;
        this.modId = modid;
    }

    private DeferredRegister(IForgeRegistry<T> reg, String modId)
    {
        this(reg.getRegistrySuperType(), modId);
        this.type = reg;
    }

    /**
     * Use for vanilla/forge registries. See example above.
     */
    public static <B extends IForgeRegistryEntry<B>> DeferredRegister<B> create(IForgeRegistry<B> reg, String modid)
    {
        return new DeferredRegister<B>(reg, modid);
    }

    /**
     * Use for custom registries that are made during the NewRegistry event.
     */
    public static <B extends IForgeRegistryEntry<B>> DeferredRegister<B> create(Class<B> base, String modid)
    {
        return new DeferredRegister<B>(base, modid);
    }

    public RegistryObject<?> register1;

    public static RegistryObject<Block> blockRegistryObject;

    public void register() {
        register1.get();
    }

    public static RegistryObject<Block> BLOCKS(final String name, final Block properties) {
        BLOCKS.register(name, () -> properties);
        return blockRegistryObject;
    }

    /**
     * Adds a new supplier to the list of entries to be registered, and returns a RegistryObject that will be populated with the created entry automatically.
     *
     * @param name The new entry's name, it will automatically have the modid prefixed.
     * @param sup A factory for the new entry, it should return a new instance every time it is called.
     * @return A RegistryObject that will be updated with when the entries in the registry change.
     */
    @SuppressWarnings("unchecked")
    public <I extends T> RegistryObject<I> register(final String name, final Supplier<? extends I> sup)
    {
        Objects.requireNonNull(name);
        Objects.requireNonNull(sup);
        final ResourceLocation key = new ResourceLocation(Objects.requireNonNull(modId), name);

        RegistryObject<I> ret;
        if (this.type != null)
            ret = RegistryObject.of(key, this.type);
        else if (this.superType != null)
            ret = RegistryObject.of(key, this.superType, this.modId);
        else
            throw new IllegalStateException("Could not create RegistryObject in DeferredRegister");

        if (entries.putIfAbsent((RegistryObject<T>) ret, () -> supplier.get().setRegistryName(key)) != null) {
            throw new IllegalArgumentException("Duplicate registration " + name);
        }

        return ret;
    }

    /**
     * Adds a new supplier to the list of entries to be registered, and returns a RegistryObject that will be populated with the created entry automatically.
     *
     * @param name The new entry's name, it will automatically have the modId prefixed.
     * @param sup A factory for the new entry, it should return a new instance every time it is called.
     * @return A RegistryObject that will be updated with when the entries in the registry change.
     */
    @SuppressWarnings("unchecked")
    public <I extends T> RegistryObject<I> register(String name, Supplier<? extends PointOfInterestType> sup, SoundEvent sound)
    {
        Objects.requireNonNull(name);
        Objects.requireNonNull(sup);
        Objects.requireNonNull(sound);
        final ResourceLocation key = new ResourceLocation(Objects.requireNonNull(modId), name);

        RegistryObject<I> ret;
        if (this.type != null)
            ret = RegistryObject.of(key, this.type);
        else if (this.superType != null)
            ret = RegistryObject.of(key, this.superType, this.modId);
        else
            throw new IllegalStateException("Could not create RegistryObject in DeferredRegister");

        if (entries.putIfAbsent((RegistryObject<T>) ret, () -> supplier.get().setRegistryName(key)) != null) {
            throw new IllegalArgumentException("Duplicate registration " + name);
        }

        return ret;
    }

    public <I extends T> RegistryObject<I> schrofth(final String name, final Supplier<? extends I> sup, RegistryObject<I> registryObject) {
        return register(string, schrofth(sup, registryObject));
    }

    public <I extends T> RegistryObject<I> schrofth(Supplier<? extends I> supplier, RegistryObject<I> registryObject) {
        return registryObject;
    }

    /**
     * Adds a new supplier to the list of entries to be registered, and returns a RegistryObject that will be populated with the created entry automatically.
     *
     * @param name The new entry's name, it will automatically have the modId prefixed.
     * @param supplier A factory for the new entry, it should return a new instance every time it is called.
     * @return A RegistryObject that will be updated with when the entries in the registry change.
     */
    @SuppressWarnings("unchecked")
    public <I extends T> RegistryObject<I> register(String name, Supplier<? extends Set<BlockState>> supplier, int maxFreeTickets, int validRange)
    {
        Objects.requireNonNull(name);
        Objects.requireNonNull(supplier);
        final ResourceLocation key = new ResourceLocation(Objects.requireNonNull(modId), name);

        RegistryObject<I> ret;
        if (this.type != null)
            ret = RegistryObject.of(key, this.type);
        else if (this.superType != null)
            ret = RegistryObject.of(key, this.superType, this.modId);
        else
            throw new IllegalStateException("Could not create RegistryObject in DeferredRegister");

        if (entries.putIfAbsent((RegistryObject<T>) ret, () -> this.supplier.get().setRegistryName(key)) != null) {
            throw new IllegalArgumentException("Duplicate registration " + name);
        }

        return ret;
    }

    /**
     * Adds our event handler to the specified event bus, this MUST be called in order for this class to function.
     * See the example usage.
     *
     * @param bus The Mod Specific event bus.
     */
    public void register(IEventBus bus)
    {
        bus.register(new EventDispatcher(this));
        if (this.type == null && this.registryFactory != null) {
            bus.addListener(this::createRegistry);
        }
    }
    public static class EventDispatcher {
        private final DeferredRegister<?> register;

        public EventDispatcher(final DeferredRegister<?> register) {
            this.register = register;
        }

        @SubscribeEvent
        public void handleEvent(RegistryEvent.Register<?> event) {
            register.addEntries(event);
        }
    }

    /**
     * @return The unmodifiable view of registered entries. Useful for bulk operations on all values.
     */
    public Collection<RegistryObject<T>> getEntries()
    {
        return entriesView;
    }

    private void addEntries(RegistryEvent.Register<?> event)
    {
        if (this.type == null && this.registryFactory == null)
        {
            //If there is no type yet and we don't have a registry factory, attempt to capture the registry
            //Note: This will only ever get run on the first registry event, as after that time,
            // the type will no longer be null. This is needed here rather than during the NewRegistry event
            // to ensure that mods can properly use deferred registers for custom registries added by other mods
            captureRegistry();
        }
        if (this.type != null && event.getGenericType() == this.type.getRegistrySuperType())
        {
            boolean seenRegisterEvent = true;
            @SuppressWarnings("unchecked")
            IForgeRegistry<T> reg = (IForgeRegistry<T>)event.getRegistry();
            for (Map.Entry<RegistryObject<T>, Supplier<? extends T>> e : entries.entrySet())
            {
                reg.register(e.getValue().get());
                e.getKey().updateReference(reg);
            }
        }
    }

    private void createRegistry(RegistryEvent.NewRegistry event)
    {
        this.type = this.registryFactory.get().create();
    }

    private void captureRegistry()
    {
        if (this.superType != null)
        {
            this.type = RegistryManager.ACTIVE.getRegistry(this.superType);
            if (this.type == null)
                throw new IllegalStateException("Unable to find registry for type " + this.superType.getName() + " for modid \"" + modId + "\" after NewRegistry event");
        }
        else
            throw new IllegalStateException("Unable to find registry for mod \"" + modId + "\" No lookup criteria specified.");
    }

    private Supplier<? extends T> supplier;
}
