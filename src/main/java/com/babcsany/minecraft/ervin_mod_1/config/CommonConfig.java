package com.babcsany.minecraft.ervin_mod_1.config;

import net.minecraftforge.common.ForgeConfigSpec.Builder;

public class CommonConfig {

    public static class CommonConfigValues {
        public ConfigHelper.ConfigValueListener<Boolean> placeHolder;

        public CommonConfigValues(Builder builder, ConfigHelper.Subscriber subscriber) {
            builder.comment("Common Settings for Pandoras Creatures, Entity Spawning has been moved to the new config file (entity-spawning.toml)").push("Common");
            this.placeHolder = subscriber.subscribe(builder.comment(" This value does nothing, its just a placeholder").define("placeHolder", true));
            builder.pop();
        }
    }
}
