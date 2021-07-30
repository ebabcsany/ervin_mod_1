package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.init.item.food.Food;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import static net.minecraft.potion.Effects.REGENERATION;

public class ModFoodInit {
    public static final Food FRIM = (new Food.Builder()).hunger(16).saturation(1.2F).build();
    public static final Food FIRG = (new Food.Builder()).hunger(0).saturation(1.2F).effect(new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food FIRG_SLAB = (new Food.Builder()).hunger(0).saturation(0.6F).effect(new EffectInstance(Effects.REGENERATION, 25, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food FIRG_STAIRS = (new Food.Builder()).hunger(0).saturation(0.9F).effect(new EffectInstance(Effects.REGENERATION, 38, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food SCRAFTH = (new Food.Builder()).hunger(0).saturation(10).effect(new EffectInstance(Effects.SLOW_FALLING, 1000, 500), 500.0F).effect(new EffectInstance(Effects.NAUSEA, 5000, 100), 500).effect(new EffectInstance(Effects.MINING_FATIGUE, 10000, 5000),5000).effect(new EffectInstance(Effects.UNLUCK, 5000, 1000),600).effect(new EffectInstance(Effects.WATER_BREATHING, 2000, 100), 100).effect(new EffectInstance(Effects.SLOWNESS, 10000, 10000), 10000).effect(new EffectInstance(Effects.JUMP_BOOST, 10000, 1 ), 1).setAlwaysEdible().build();
    public static final Food VIRK_BLOCK = (new Food.Builder()).hunger(10).saturation(10).effect(new EffectInstance(Effects.SLOW_FALLING, 100000, 100000), 100000.0F).effect(new EffectInstance(Effects.SATURATION, 100000, 5000), 5000).effect(new EffectInstance(Effects.WATER_BREATHING, 20000, 5000), 5000).effect(new EffectInstance(Effects.JUMP_BOOST, 1000000, 1000000), 1000000).effect(new EffectInstance(Effects.SPEED, 100000, 1000), 1000).effect(new EffectInstance(Effects.DOLPHINS_GRACE, 400000, 200000), 200000).effect(new EffectInstance(Effects.HASTE, 100000, 100000), 100000).effect(new EffectInstance(REGENERATION, 100000, 5000), 5000).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 100000, 100000), 100000).setAlwaysEdible().build();
    public static final Food VIRK = (new Food.Builder()).hunger(1).saturation(1).effect(new EffectInstance(Effects.SLOW_FALLING, 10000, 10000), 10000.0F).effect(new EffectInstance(Effects.SATURATION, 10000, 500), 500).effect(new EffectInstance(Effects.WATER_BREATHING, 2000, 500), 500).effect(new EffectInstance(Effects.JUMP_BOOST, 100000, 100000), 100000).effect(new EffectInstance(Effects.SPEED, 10000, 100), 100).effect(new EffectInstance(Effects.DOLPHINS_GRACE, 40000, 20000), 20000).effect(new EffectInstance(Effects.HASTE, 10000, 10000), 10000).effect(new EffectInstance(REGENERATION, 10000, 500), 500).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 10000, 1000), 1000).setAlwaysEdible().build();
    public static final Food TIRKS = (new Food.Builder()).hunger(0).saturation(0).effect(new EffectInstance(Effects.HEALTH_BOOST, 10000, 1000), 1000).setAlwaysEdible().fastToEat().build();
    public static final Food VOLMINT = (new Food.Builder()).hunger(1).saturation(2).effect(new EffectInstance(Effects.NAUSEA, 30, 30), 30).effect(new EffectInstance(Effects.HUNGER, 120, 30), 30).effect(new EffectInstance(Effects.UNLUCK, 30, 30), 30).effect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1),1).effect(new EffectInstance(Effects.SLOWNESS,5, 10),10).effect(new EffectInstance(Effects.SATURATION,5,2),1).effect(new EffectInstance(Effects.WEAKNESS,30,30),30).effect(new EffectInstance(Effects.MINING_FATIGUE,5,30),30).effect(new EffectInstance(Effects.GLOWING,30,30),30).effect(new EffectInstance(Effects.WITHER,2,1),1).meat().build();
    public static final Food ZUNT = (new Food.Builder()).hunger(16).saturation(1.2F).build();
    public static final Food REAT = builder(24,30, effect(Effects.INSTANT_HEALTH, 300, 10000), 10000).setAlwaysEdible().build();
    public static final Food REAT1 = (new Food.Builder()).hunger(24).saturation(30).effect(new EffectInstance(Effects.REGENERATION, 300, 10000), 10000.0F).setAlwaysEdible().fastToEat().build();
    public static final Food REAT2 = (new Food.Builder()).hunger(24).saturation(30).effect(new EffectInstance(Effects.REGENERATION, 300, 10000), 10000.0F).setAlwaysEdible().fastToEat().build();
    public static final Food REGDEMP = buildShek(10);
    public static final Food GUBROV = (new Food.Builder()).hunger(4).saturation(0.8F).build();
    public static final Food COOKED_GUBROV = (new Food.Builder()).hunger(8).saturation(1.6F).build();
    public static final Food STEEF = (new Food.Builder()).hunger(5).saturation(1.0F).build();
    public static final Food COOKED_STEEF = (new Food.Builder()).hunger(9).saturation(1.8F).build();
    public static final Food JAZZ_FRUIT = (new Food.Builder()).hunger(12).saturation(4.8F).effect(new EffectInstance(Effects.REGENERATION, 20, 4), 4.0F).build();

    private static Food buildShek(int hunger) {
        return (new Food.Builder()).hunger(hunger).saturation(20.0F).build();
    }

    private static EffectInstance effect(Effect effect, int durationIn, int amplifierIn) {
        return new EffectInstance(effect, durationIn, amplifierIn);
    }

    private static Food.Builder effect(EffectInstance effectIn, float probability) {
        return new Food.Builder().effect(effectIn, probability);
    }

    private static Food.Builder builder(int hunger, int saturation, EffectInstance effectInstance, float probability) {
        return (new Food.Builder()).hunger(hunger).saturation(saturation).effect(effectInstance, probability);
    }
}