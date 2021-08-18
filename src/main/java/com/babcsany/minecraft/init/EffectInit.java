package com.babcsany.minecraft.init;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.InstantEffect;
import net.minecraft.util.registry.Registry;

public class EffectInit extends Effects {

    public static EffectInit EFFECTS;

    public static final Effect INSTANT_HEALTH = register("instant_health", new InstantEffect(EffectType.BENEFICIAL, 16267819));
    public static final Effect BKFUR = register("bkfur", new InstantEffect(EffectType.HARMFUL, 28264839));
    public static final Effect CSADRIF = register("csadrif", new InstantEffect(EffectType.NEUTRAL, 6624656));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static Effect register(String key, Effect effectIn) {
        return Registry.register(Registry.EFFECTS, string(key), effectIn);
    }
}
