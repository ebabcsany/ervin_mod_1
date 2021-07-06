package com.babcsany.minecraft.init;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.InstantEffect;
import net.minecraft.util.registry.Registry;

public class EffectInit {

    public static EffectInit EFFECTS;

    public static final Effect INSTANT_HEALTH = register("ervin_mod_1:instant_health", new InstantEffect(EffectType.BENEFICIAL, 16267819));

    private static Effect register(String key, Effect effectIn) {
        return Registry.register(Registry.EFFECTS, key, effectIn);
    }
}
