package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.InstantEffect;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectInit extends Effects {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Effect> INSTANT_HEALTH = EFFECTS.register("instant_health", () -> new InstantEffect(EffectType.BENEFICIAL, 16267819));
    public static final RegistryObject<Effect> BKFUR = EFFECTS.register("bkfur", () -> new InstantEffect(EffectType.HARMFUL, 28264839));
    public static final RegistryObject<Effect> CSADRIF = EFFECTS.register("csadrif", () -> new InstantEffect(EffectType.NEUTRAL, 6624656));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }
}
