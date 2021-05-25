package com.babcsany.minecraft.ervin_mod_1.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.config.ModConfig.ModConfigEvent;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigHelper {
    public static <T> T register(Type configType, BiFunction<Builder, Subscriber, T> configBuilder, String registerConfig) {
        return register(ModLoadingContext.get(), configType, configBuilder, registerConfig);
    }

    public static <T> T register(ModLoadingContext modContext, Type configType, BiFunction<Builder, ConfigHelper.Subscriber, T> configBuilder, String registerConfig) {
        List<ConfigValueListener<?>> subscriptionList = new ArrayList();
        Pair<T, ForgeConfigSpec> entry = (new Builder()).configure((builder) -> configBuilder.apply(builder, getSubscriber(subscriptionList)));
        T config = entry.getLeft();
        ForgeConfigSpec spec = (ForgeConfigSpec)entry.getRight();
        modContext.registerConfig(configType, spec, registerConfig);
        Consumer<ModConfigEvent> configUpdate = (event) -> {
            if (event.getConfig().getSpec() == spec) {
                Iterator var3 = subscriptionList.iterator();

                while(var3.hasNext()) {
                    ConfigHelper.ConfigValueListener<?> value = (ConfigHelper.ConfigValueListener)var3.next();
                    value.update();
                }
            }

        };
        FMLJavaModLoadingContext.get().getModEventBus().addListener(configUpdate);
        return config;
    }

    private static ConfigHelper.Subscriber getSubscriber(List<ConfigHelper.ConfigValueListener<?>> list) {
        return new ConfigHelper.Subscriber(list);
    }

    public static class ConfigValueListener<T> implements Supplier<T> {
        private T value = null;
        private final ConfigValue<T> configValue;

        private ConfigValueListener(ConfigValue<T> configValue) {
            this.configValue = configValue;
        }

        public static <T> ConfigHelper.ConfigValueListener<T> of(ConfigValue<T> configValue, List<ConfigHelper.ConfigValueListener<?>> valueList) {
            ConfigHelper.ConfigValueListener<T> value = new ConfigHelper.ConfigValueListener(configValue);
            valueList.add(value);
            return value;
        }

        public void update() {
            this.value = this.configValue.get();
        }

        public T get() {
            if (this.value == null) {
                this.update();
            }

            return this.value;
        }
    }

    public static class Subscriber {
        final List<ConfigHelper.ConfigValueListener<?>> list;

        Subscriber(List<ConfigHelper.ConfigValueListener<?>> list) {
            this.list = list;
        }

        public <T> ConfigHelper.ConfigValueListener<T> subscribe(ConfigValue<T> value) {
            return ConfigHelper.ConfigValueListener.of(value, this.list);
        }
    }
}
