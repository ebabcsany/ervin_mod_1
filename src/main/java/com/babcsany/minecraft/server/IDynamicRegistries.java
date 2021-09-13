package com.babcsany.minecraft.server;

import com.babcsany.minecraft.ervin_mod_1.registry.ModRegistry;
import com.babcsany.minecraft.world.dimensionType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;
import java.util.Optional;

public interface IDynamicRegistries {
   <E> Optional<MutableRegistry<E>> func_230521_a_(RegistryKey<Registry<E>> p_230521_1_);

   @OnlyIn(Dist.CLIENT)
   Registry<dimensionType> func_230520_a_();

   static Impl func_239770_b_() {
      return dimensionType.impl(new Impl());
   }

   final class Impl implements IDynamicRegistries {
      public static final Codec<Impl> field_239771_a_ = SimpleRegistry.func_241743_a_(ModRegistry.MOD_DIMENSION_TYPE_KEY, Lifecycle.experimental(), dimensionType.DIMENSION_TYPE_CODEC).xmap(Impl::new, (p_239773_0_) -> p_239773_0_.field_239772_b_).fieldOf("dimension").codec();
      private final SimpleRegistry<dimensionType> field_239772_b_;
      private SimpleRegistry<DimensionType> field_239773_c_;

      public Impl() {
         this(new SimpleRegistry<>(ModRegistry.MOD_DIMENSION_TYPE_KEY, Lifecycle.experimental()));
      }

      private Impl(SimpleRegistry<dimensionType> p_i232511_1_) {
         this.field_239772_b_ = p_i232511_1_;
      }

      public void func_239774_a_(RegistryKey<dimensionType> p_239774_1_, dimensionType p_239774_2_) {
         this.field_239772_b_.register(p_239774_1_, p_239774_2_);
      }

      public void func_239774_a_(RegistryKey<DimensionType> p_239774_1_, DimensionType p_239774_2_) {
         this.field_239773_c_.register(p_239774_1_, p_239774_2_);
      }

      public <E> Optional<MutableRegistry<E>> func_230521_a_(RegistryKey<Registry<E>> p_230521_1_) {
         return Objects.equals(p_230521_1_, Registry.DIMENSION_TYPE_KEY) ? Optional.of((MutableRegistry<E>) this.field_239772_b_) : Optional.empty();
      }

      public Registry<dimensionType> func_230520_a_() {
         return this.field_239772_b_;
      }
   }
}
