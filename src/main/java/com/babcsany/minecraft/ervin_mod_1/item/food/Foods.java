package com.babcsany.minecraft.ervin_mod_1.item.food;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.Random;

import static net.minecraft.potion.Effects.REGENERATION;

public class Foods {
    public static final Food FRIM = (new Food.Builder()).hunger(16).saturation(1.2F).build();
    public static final Food DURG = (new Food.Builder()).hunger(30).saturation(24.0F).effect(() -> new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food GRINT_BLOCK = (new Food.Builder()).hunger(24).saturation(14.4F).effect(() -> new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food GRINT_SLAB = (new Food.Builder()).hunger(12).saturation(7.2F).effect(() -> new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food GRINT_STAIRS = (new Food.Builder()).hunger(18).saturation(10.8F).effect(() -> new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food GRINT = (new Food.Builder()).hunger(8).saturation(4.8F).effect(() -> new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food FIRG = (new Food.Builder()).hunger(1).saturation(1.25F).effect(() -> new EffectInstance(Effects.REGENERATION, 50, 10), 10.0F).setAlwaysEdible().fastToEat().build();
    public static final Food FIRG_SLICE = (new Food.Builder()).hunger(0).saturation(0.15F).effect(() -> new EffectInstance(Effects.REGENERATION, 10, 1), 1.25F).setAlwaysEdible().fastToEat().build();
    public static final Food FIRG_SLAB = (new Food.Builder()).hunger(new Random().nextInt(1)).saturation(0.6F).effect(() -> new EffectInstance(Effects.REGENERATION, 25, 5), 5.0F).setAlwaysEdible().fastToEat().build();
    public static final Food FIRG_STAIRS = (new Food.Builder()).hunger(0).saturation(0.9F).effect(() -> new EffectInstance(Effects.REGENERATION, 38, 8), 8.0F).setAlwaysEdible().fastToEat().build();
    public static final Food SCRAFTH = (new Food.Builder()).saturation(10).effect(() -> new EffectInstance(Effects.SLOW_FALLING, 1000, 500), 500.0F).effect(() -> new EffectInstance(Effects.NAUSEA, 5000, 100), 500).effect(() -> new EffectInstance(Effects.MINING_FATIGUE, 10000, 5000),5000).effect(() -> new EffectInstance(Effects.UNLUCK, 5000, 1000),600).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 2000, 100), 100).effect(() -> new EffectInstance(Effects.SLOWNESS, 10000, 10000), 10000).effect(() -> new EffectInstance(Effects.JUMP_BOOST, 10000, 1 ), 1).setAlwaysEdible().build();
    public static final Food VIRK_BLOCK = (new Food.Builder()).hunger(10).saturation(10).effect(() -> new EffectInstance(Effects.SLOW_FALLING, 100000, 100000), 100000.0F).effect(() -> new EffectInstance(Effects.SATURATION, 100000, 5000), 5000).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 20000, 5000), 5000).effect(() -> new EffectInstance(Effects.JUMP_BOOST, 1000000, 1000000), 1000000).effect(() -> new EffectInstance(Effects.SPEED, 100000, 1000), 1000).effect(() -> new EffectInstance(Effects.DOLPHINS_GRACE, 400000, 200000), 200000).effect(() -> new EffectInstance(Effects.HASTE, 100000, 100000), 100000).effect(() -> new EffectInstance(REGENERATION, 100000, 5000), 5000).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 100000, 100000), 100000).setAlwaysEdible().build();
    public static final Food VIRK = (new Food.Builder()).hunger(1).saturation(1).effect(() -> new EffectInstance(Effects.SLOW_FALLING, 10000, 10000), 10000.0F).effect(() -> new EffectInstance(Effects.SATURATION, 10000, 500), 500).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 2000, 500), 500).effect(() -> new EffectInstance(Effects.JUMP_BOOST, 100000, 100000), 100000).effect(() -> new EffectInstance(Effects.SPEED, 10000, 100), 100).effect(() -> new EffectInstance(Effects.DOLPHINS_GRACE, 40000, 20000), 20000).effect(() -> new EffectInstance(Effects.HASTE, 10000, 10000), 10000).effect(() -> new EffectInstance(REGENERATION, 10000, 500), 500).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 10000, 1000), 1000).setAlwaysEdible().build();
    public static final Food KIRT = (new Food.Builder()).hunger(1).saturation(1).effect(() -> new EffectInstance(Effects.SLOW_FALLING, 10000, 10000), 10000.0F).effect(() -> new EffectInstance(Effects.SATURATION, 10000, 500), 500).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 2000, 500), 500).effect(() -> new EffectInstance(Effects.JUMP_BOOST, 100000, 100000), 100000).effect(() -> new EffectInstance(Effects.SPEED, 10000, 100), 100).effect(() -> new EffectInstance(Effects.DOLPHINS_GRACE, 40000, 20000), 20000).effect(() -> new EffectInstance(Effects.HASTE, 10000, 10000), 10000).effect(() -> new EffectInstance(REGENERATION, 10000, 500), 500).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 10000, 1000), 1000).setAlwaysEdible().build();
    public static final Food TIRKS = (new Food.Builder()).effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 10000, 1000), 1000).setAlwaysEdible().fastToEat().build();
    public static final Food VOLMINT = (new Food.Builder()).hunger(1).saturation(2).effect(() -> new EffectInstance(Effects.NAUSEA, 30, 30), 30).effect(() -> new EffectInstance(Effects.HUNGER, 120, 30), 30).effect(() -> new EffectInstance(Effects.UNLUCK, 30, 30), 30).effect(() -> new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1),1).effect(() -> new EffectInstance(Effects.SLOWNESS,5, 10),10).effect(() -> new EffectInstance(Effects.SATURATION,5,2),1).effect(() -> new EffectInstance(Effects.WEAKNESS,30,30),30).effect(() -> new EffectInstance(Effects.MINING_FATIGUE,5,30),30).effect(() -> new EffectInstance(Effects.GLOWING,30,30),30).effect(() -> new EffectInstance(Effects.WITHER,2,1),1).meat().build();
    public static final Food ZUNT = (new Food.Builder()).hunger(16).saturation(1.2F).build();
    public static final Food REAT = (new Food.Builder()).hunger(24).saturation(30).effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 300, 10000), 10000.0F).setAlwaysEdible().build();
    public static final Food REAT1 = (new Food.Builder()).hunger(24).saturation(30).effect(() -> new EffectInstance(Effects.REGENERATION, 300, 10000), 10000.0F).setAlwaysEdible().fastToEat().build();
    public static final Food REAT2 = (new Food.Builder()).hunger(24).saturation(30).effect(() -> new EffectInstance(Effects.REGENERATION, 300, 10000), 10000.0F).setAlwaysEdible().fastToEat().build();
    public static final Food BEETROOT_SOUP = buildHunger(10);
    public static final Food BEETROOT_SOUP1 = buildHunger(8);
    public static final Food GUBROV = (new Food.Builder()).hunger(4).saturation(0.8F).build();
    public static final Food COOKED_GUBROV = (new Food.Builder()).hunger(8).saturation(1.6F).build();
    public static final Food STEEF = (new Food.Builder()).hunger(5).saturation(1.0F).build();
    public static final Food COOKED_STEEF = (new Food.Builder()).hunger(9).saturation(1.8F).build();
    public static final Food MRONT = (new Food.Builder()).hunger(3).saturation(0.6F).meat().build();
    public static final Food COOKED_MRONT = (new Food.Builder()).hunger(5).saturation(1.0F).meat().build();
    public static final Food JAZZ_FRUIT = (new Food.Builder()).hunger(12).saturation(4.8F).effect(() -> new EffectInstance(Effects.REGENERATION, 20, 4), 4.0F).build();
    public static final Food BREFK = (new Food.Builder()).hunger(4).saturation(10.0F).effect(() -> new EffectInstance(Effects.HUNGER, 50, 25), 25.0F).effect(() -> new EffectInstance(Effects.REGENERATION, 200, 50), 50.0F).build();
    public static final Food BREFK_STAGE = (new Food.Builder()).hunger(3).saturation(6.6F).effect(() -> new EffectInstance(Effects.HUNGER, 25, 12), 12.0F).effect(() -> new EffectInstance(REGENERATION, 100, 30), 40.0F).build();

    private static Food buildHunger(int hunger) {
        return (new Food.Builder()).hunger(hunger).saturation(20.0F).build();
    }
}
