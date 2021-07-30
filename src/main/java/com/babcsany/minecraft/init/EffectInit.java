package com.babcsany.minecraft.init;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.InstantEffect;
import net.minecraft.util.registry.Registry;

public class EffectInit extends Effects {

    public static EffectInit EFFECTS;

    public static final Effect INSTANT_HEALTH = register("ervin_mod_1:instant_health", new InstantEffect(EffectType.BENEFICIAL, 16267819));
    public static final Effect BKFUR = register("ervin_mod_1:bkfur", new InstantEffect(EffectType.HARMFUL, 16267819));

    private static Effect register(String key, Effect effectIn) {
        return Registry.register(Registry.EFFECTS, key, effectIn);
    }
}
