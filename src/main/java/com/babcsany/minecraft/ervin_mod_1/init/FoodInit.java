package com.babcsany.minecraft.ervin_mod_1.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import static net.minecraft.potion.Effects.REGENERATION;

public class FoodInit {
    public static final Food FRIM = (new Food.Builder()).hunger(16).saturation(1.2F).build();
    public static final Food FIRG = (new Food.Builder()).hunger(0).saturation(1.2F).effect(new EffectInstance(Effects.REGENERATION, 10, 1), 1.0F).build();
}
