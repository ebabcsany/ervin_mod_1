package com.babcsany.minecraft.ervin_mod_1.fluid;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.state.Property;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class IntegerProperty1 extends Property<Integer> {
   private final ImmutableSet<Integer> allowedValues;

   protected IntegerProperty1(String name, int min, int max) {
      super(name, Integer.class);
      if (min < 0) {
         throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
      } else if (max <= min) {
         throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
      } else {
         Set<Integer> set = Sets.newHashSet();

         for(int i = min; i <= max; ++i) {
            set.add(i);
         }

         this.allowedValues = ImmutableSet.copyOf(set);
      }
   }

   public Collection<Integer> getAllowedValues() {
      return this.allowedValues;
   }

   public boolean equals(Object p_equals_1_) {
      if (this == p_equals_1_) {
         return true;
      } else if (p_equals_1_ instanceof IntegerProperty1 && super.equals(p_equals_1_)) {
         IntegerProperty1 integerproperty = (IntegerProperty1)p_equals_1_;
         return this.allowedValues.equals(integerproperty.allowedValues);
      } else {
         return false;
      }
   }

   public int computeHashCode() {
      return 31 * super.computeHashCode() + this.allowedValues.hashCode();
   }

   public static IntegerProperty1 create(String name, int min, int max) {
      return new IntegerProperty1(name, min, max);
   }

   public Optional<Integer> parseValue(String value) {
      try {
         Integer integer = Integer.valueOf(value);
         return this.allowedValues.contains(integer) ? Optional.of(integer) : Optional.empty();
      } catch (NumberFormatException var3) {
         return Optional.empty();
      }
   }

   /**
    * Get the name for the given value.
    */
   public String getName(Integer value) {
      return value.toString();
   }
}