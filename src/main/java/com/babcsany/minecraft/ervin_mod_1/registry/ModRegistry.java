package com.babcsany.minecraft.ervin_mod_1.registry;

import com.babcsany.minecraft.ervin_mod_1.util.registries.modPainting_Type;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider.ExampleBiomeProvider;
import com.babcsany.minecraft.world.dimension;
import com.babcsany.minecraft.world.dimensionType;
import com.babcsany.minecraft.world.world;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.biome.provider.BiomeProvider;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.function.Supplier;

public abstract class ModRegistry<T> extends Registry<T> {
    private static final Map<ResourceLocation, Supplier<?>> LOCATION_TO_SUPPLIER = Maps.newLinkedHashMap();
    public static final RegistryKey<Registry<modPainting_Type>> modPainting_Type_KEY = createKey("ervin_mod_1:painting/modPainting/motive");
    public static final RegistryKey<Registry<dimensionType>> MOD_DIMENSION_TYPE_KEY = createKey("mod_dimension_type");
    public static final RegistryKey<Registry<world>> MOD_WORLD_KEY = createKey("mod_dimension");
    public static final RegistryKey<Registry<dimension>> MOD_DIMENSION_KEY = createKey("mod_dimension");

    //public static final DefaultedRegistry<modPainting_Type> modPainting_MOTIVE = forgeDefaulted(modPainting_Type_KEY, modPainting_Type.class, () -> modPainting_Type.lLl_Ss_hu_);

    protected ModRegistry(RegistryKey<Registry<T>> registryKey, Lifecycle lifecycle) {
        super(registryKey, lifecycle);
        this.registryKey = registryKey;
        this.lifecycle = lifecycle;
    }

    private final RegistryKey<Registry<T>> registryKey;
    private final Lifecycle lifecycle;

    public static <T> RegistryKey<Registry<T>> createKey(String name) {
        return RegistryKey.func_240904_a_(new ResourceLocation(name));
    }

    public static <T> T register(ModRegistry<? super T> registry, String identifier, T value) {
        return register(registry, new ResourceLocation(identifier), value);
    }

    private static <T> Registry<T> func_239742_a_(RegistryKey<Registry<T>> registryKey, Lifecycle lifecycle, Supplier<T> supplier) {
        return func_239743_a_(registryKey, new SimpleRegistry<>(registryKey, lifecycle), supplier);
    }

    private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> Registry<T> forge(RegistryKey<Registry<T>> key, Class<? super T> cls, Supplier<T> def) {
        return func_239743_a_(key, net.minecraftforge.registries.GameData.<T>getWrapper(cls), def);
    }

    private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> DefaultedRegistry<T> forgeDefaulted(RegistryKey<Registry<T>> key, Class<? super T> cls, Supplier<T> def) {
        return func_239743_a_(key, net.minecraftforge.registries.GameData.<T>getWrapperDefaulted(cls), def);
    }

    private static <T, R extends MutableRegistry<T>> R func_239743_a_(RegistryKey<Registry<T>> registryKey, R instance, Supplier<T> objectSupplier) {
        ResourceLocation resourcelocation = registryKey.func_240901_a_();
        LOCATION_TO_SUPPLIER.put(resourcelocation, objectSupplier);
        return (R)((MutableRegistry)ROOT_REGISTRY).register(registryKey, instance);
    }

    private static <T extends MutableRegistry<?>> void validateMutableRegistry(MutableRegistry<T> registry) {
        registry.forEach((p_239739_1_) -> {
            if (p_239739_1_.keySet().isEmpty()) {
                LOGGER.error("Registry '{}' was empty after loading", registry.getKey(p_239739_1_));
                if (SharedConstants.developmentMode) {
                    throw new IllegalStateException("Registry: '" + registry.getKey(p_239739_1_) + "' is empty, not allowed, fix me!");
                }
            }

            if (p_239739_1_ instanceof DefaultedRegistry) {
                ResourceLocation resourcelocation = ((DefaultedRegistry)p_239739_1_).getDefaultKey();
                Validate.notNull(p_239739_1_.getOrDefault(resourcelocation), "Missing default of DefaultedMappedRegistry: " + resourcelocation);
            }

        });
    }

    static {
        LOCATION_TO_SUPPLIER.forEach((registry, registrySupplier) -> {
            if (registrySupplier.get() == null) {
                LOGGER.error("Unable to bootstrap registry '{}'", (Object)registry);
            }

        });
        validateMutableRegistry(ROOT_REGISTRY);
    }

    public static void register(Registry<Codec<? extends BiomeProvider>> biomeProviderCodec, ResourceLocation resourceLocation, Codec<ExampleBiomeProvider> field_235263_f_) {
    }
}
