package com.babcsany.minecraft.ervin_mod_1.mixin;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class MixinConnector implements IMixinConnector {
    public MixinConnector() {
    }

    public void connect() {
        Mixins.addConfiguration("ervin_mod_1.mixins.json");
    }
}
