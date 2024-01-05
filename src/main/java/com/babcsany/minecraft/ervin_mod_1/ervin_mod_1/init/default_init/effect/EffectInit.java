package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.effect;

import net.minecraft.potion.Effects;

public class EffectInit {

    public EffectInit(Effects effects) {
        register(effects);
    }

    public void register(Effects effects) {
        com.babcsany.minecraft.init.EffectInit.EFFECTS = effects;
    }
}
