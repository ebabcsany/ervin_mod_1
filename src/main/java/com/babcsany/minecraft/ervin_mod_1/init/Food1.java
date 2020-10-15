package com.babcsany.minecraft.ervin_mod_1.init;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.potion.EffectInstance;

import java.util.List;

public class Food1 {
   private final int value;
   private final float saturation;
   private final boolean meat;
   private final boolean canEatWhenFull;
   private final boolean fastToEat;
   private final List<Pair<java.util.function.Supplier<EffectInstance>, Float>> effects;

   private Food1(Food1.Builder builder) {
      this.value = builder.value;
      this.saturation = builder.saturation;
      this.meat = builder.meat;
      this.canEatWhenFull = builder.alwaysEdible;
      this.fastToEat = builder.fastToEat;
      this.effects = builder.effects;
   }

   // Forge: Use builder method instead
   @Deprecated
   private Food1(int healing, float saturationIn, boolean isMeat, boolean alwaysEdible, boolean fastEdible, List<Pair<EffectInstance, Float>> effectsIn) {
      this.value = healing;
      this.saturation = saturationIn;
      this.meat = isMeat;
      this.canEatWhenFull = alwaysEdible;
      this.fastToEat = fastEdible;
      this.effects = effectsIn.stream().map(pair -> Pair.<java.util.function.Supplier<EffectInstance>, Float>of(pair::getFirst, pair.getSecond())).collect(java.util.stream.Collectors.toList());
   }

   public int getHealing() {
      return this.value;
   }

   public float getSaturation() {
      return this.saturation;
   }

   public boolean isMeat() {
      return this.meat;
   }

   public boolean canEatWhenFull() {
      return this.canEatWhenFull;
   }

   public boolean isFastEating() {
      return this.fastToEat;
   }

   public List<Pair<EffectInstance, Float>> getEffects() {
      return this.effects.stream().map(pair -> Pair.of(pair.getFirst() != null ? pair.getFirst().get() : null, pair.getSecond())).collect(java.util.stream.Collectors.toList());
   }

   public static class Builder {
      private int value;
      private float saturation;
      private boolean meat;
      private boolean alwaysEdible;
      private boolean fastToEat;
      private final List<Pair<java.util.function.Supplier<EffectInstance>, Float>> effects = Lists.newArrayList();

      public Food1.Builder hunger(int hungerIn) {
         this.value = hungerIn;
         return this;
      }

      public Food1.Builder saturation(float saturationIn) {
         this.saturation = saturationIn;
         return this;
      }

      public Food1.Builder meat() {
         this.meat = true;
         return this;
      }

      public Food1.Builder setAlwaysEdible() {
         this.alwaysEdible = true;
         return this;
      }

      public Food1.Builder fastToEat() {
         this.fastToEat = true;
         return this;
      }

      public Food1.Builder effect(java.util.function.Supplier<EffectInstance> effectIn, float probability) {
          this.effects.add(Pair.of(effectIn, probability));
          return this;
       }

      // Forge: Use supplier method instead
      @Deprecated
      public Food1.Builder effect(EffectInstance effectIn, float probability) {
         this.effects.add(Pair.of(() -> effectIn, probability));
         return this;
      }

      public Food1 build() {
         return new Food1(this);
      }
   }
}