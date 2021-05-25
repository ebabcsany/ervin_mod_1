package com.babcsany.minecraft.ervin_mod_1.config;

import net.minecraftforge.common.ForgeConfigSpec.Builder;
import com.babcsany.minecraft.ervin_mod_1.config.ConfigHelper.ConfigValueListener;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClientConfig {
    public static class ClientConfigValues {
        public ConfigValueListener<Boolean> shouldShowUpdateMessage;
        public ConfigValueListener<Boolean> shouldShowUpdateCheckFailedMessage;
        public ConfigValueListener<Boolean> shouldShowInvalidJarMessage;
        public ConfigValueListener<Boolean> shouldButtonsInCreativeTabBeEnabled;
        public ConfigValueListener<Integer> buttonDiscordOffsetX;
        public ConfigValueListener<Integer> buttonDiscordOffsetY;
        public ConfigValueListener<Integer> buttonCurseForgeOffsetX;
        public ConfigValueListener<Integer> buttonCurseForgeOffsetY;
        public ConfigValueListener<Integer> buttonYouTubeOffsetX;
        public ConfigValueListener<Integer> buttonYouTubeOffsetY;
        public ConfigValueListener<Integer> buttonTwitchOffsetX;
        public ConfigValueListener<Integer> buttonTwitchOffsetY;
        public ConfigValueListener<Integer> buttonPatreonOffsetX;
        public ConfigValueListener<Integer> buttonPatreonOffsetY;
        public ConfigValueListener<Integer> buttonFadeInTime;

        public ClientConfigValues(Builder builder, ConfigHelper.Subscriber subscriber) {
            builder.comment("Settings for Ervin Mod 1").push("chat");
            this.shouldShowUpdateMessage = subscriber.subscribe(builder.comment("Turn the notification the player gets when joining and a new update has been found on and off.").define("shouldShowUpdateMessage", true));
            this.shouldShowUpdateCheckFailedMessage = subscriber.subscribe(builder.comment("Turn the notification the player gets when joining and a the mod wasnt able to check for a new version on and off.").define("shouldShowUpdateCheckFailedMessage", true));
            this.shouldShowInvalidJarMessage = subscriber.subscribe(builder.comment("Turn the notification the player gets when joining and the mod detected an invalid .jar on and off.").define("shouldShowInvalidJarMessage", true));
            builder.pop();
            builder.push("creativeTabButtonsGeneral");
            this.shouldButtonsInCreativeTabBeEnabled = subscriber.subscribe(builder.comment("Choose if the buttons that get rendered in the Pandoras Creatures Creative Tab should be disabled or enabled.").define("shouldButtonsInCreativeTabBeEnabled", true));
            this.buttonFadeInTime = subscriber.subscribe(builder.comment("The amount of seconds it takes for the buttons to fully appear. Set it to 0 in order to disable the fading").defineInRange("buttonFadeInTime", 1, 0, 5));
            builder.pop();
            builder.push("creativeTabButtonsOffset");
            this.buttonDiscordOffsetX = subscriber.subscribe(builder.comment("Offset the Discord Button on the X axis").define("buttonDiscordOffsetX", 0));
            this.buttonDiscordOffsetY = subscriber.subscribe(builder.comment("Offset the Discord Button on the Y axis").define("buttonDiscordOffsetY", 0));
            this.buttonCurseForgeOffsetX = subscriber.subscribe(builder.comment("Offset the CurseForge Button on the X axis").define("buttonCurseForgeOffsetX", 0));
            this.buttonCurseForgeOffsetY = subscriber.subscribe(builder.comment("Offset the CurseForge Button on the Y axis").define("buttonCurseForgeOffsetY", 0));
            this.buttonYouTubeOffsetX = subscriber.subscribe(builder.comment("Offset the YouTube Button on the X axis").define("buttonYouTubeOffsetX", 0));
            this.buttonYouTubeOffsetY = subscriber.subscribe(builder.comment("Offset the YouTube Button on the Y axis").define("buttonYouTubeOffsetY", 0));
            this.buttonTwitchOffsetX = subscriber.subscribe(builder.comment("Offset the Twitch Button on the X axis").define("buttonTwitchOffsetX", 0));
            this.buttonTwitchOffsetY = subscriber.subscribe(builder.comment("Offset the Twitch Button on the Y axis").define("buttonTwitchOffsetY", 0));
            this.buttonPatreonOffsetX = subscriber.subscribe(builder.comment("Offset the Patreon Button on the X axis").define("buttonPatreonOffsetX", 0));
            this.buttonPatreonOffsetY = subscriber.subscribe(builder.comment("Offset the Patreon Button on the Y axis").define("buttonPatreonOffsetY", 0));
            builder.pop();
        }
    }
}
