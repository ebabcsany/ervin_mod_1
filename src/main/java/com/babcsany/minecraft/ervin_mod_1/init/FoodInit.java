package com.babcsany.minecraft.ervin_mod_1.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import static net.minecraft.potion.Effects.REGENERATION;

public class FoodInit {
    public static final Food FRIM = (new Food.Builder()).hunger(16).saturation(1.2F).build();
    public static final Food FIRG = (new Food.Builder()).hunger(0).saturation(1.2F).effect(new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().build();
    public static final Food SCRAFTH = (new Food.Builder()).hunger(0).saturation(10).effect(new EffectInstance(Effects.SLOW_FALLING, 1000, 500), 500.0F).effect(new EffectInstance(Effects.NAUSEA, 5000, 100), 500).effect(new EffectInstance(Effects.MINING_FATIGUE, 10000, 5000),5000).effect(new EffectInstance(Effects.UNLUCK, 5000, 1000),600).effect(new EffectInstance(Effects.WATER_BREATHING, 2000, 100), 100).effect(new EffectInstance(Effects.SLOWNESS, 10000, 10000), 10000).effect(new EffectInstance(Effects.JUMP_BOOST, 10000, 1 ), 1).setAlwaysEdible().build();
    public static final Food VIRK_BLOCK = (new Food.Builder()).hunger(10).saturation(10).effect(new EffectInstance(Effects.SLOW_FALLING, 100000, 100000), 100000.0F).effect(new EffectInstance(Effects.SATURATION, 100000, 5000), 5000).effect(new EffectInstance(Effects.WATER_BREATHING, 20000, 5000), 5000).effect(new EffectInstance(Effects.JUMP_BOOST, 1000000, 1000000), 1000000).effect(new EffectInstance(Effects.SPEED, 100000, 1000), 1000).effect(new EffectInstance(Effects.DOLPHINS_GRACE, 400000, 200000), 200000).effect(new EffectInstance(Effects.HASTE, 100000, 100000), 100000).effect(new EffectInstance(REGENERATION, 100000, 5000), 5000).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 100000, 100000), 100000).setAlwaysEdible().build();
    public static final Food VIRK = (new Food.Builder()).hunger(1).saturation(1).effect(new EffectInstance(Effects.SLOW_FALLING, 10000, 10000), 10000.0F).effect(new EffectInstance(Effects.SATURATION, 10000, 500), 500).effect(new EffectInstance(Effects.WATER_BREATHING, 2000, 500), 500).effect(new EffectInstance(Effects.JUMP_BOOST, 100000, 100000), 100000).effect(new EffectInstance(Effects.SPEED, 10000, 100), 100).effect(new EffectInstance(Effects.DOLPHINS_GRACE, 40000, 20000), 20000).effect(new EffectInstance(Effects.HASTE, 10000, 10000), 10000).effect(new EffectInstance(REGENERATION, 10000, 500), 500).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 10000, 1000), 1000).setAlwaysEdible().build();
    public static final Food TIRKS = (new Food.Builder()).hunger(0).saturation(0).effect(new EffectInstance(Effects.HEALTH_BOOST, 10000, 1000), 1000).setAlwaysEdible().build();
}
