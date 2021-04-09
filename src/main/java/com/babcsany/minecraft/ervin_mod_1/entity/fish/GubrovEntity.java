package com.babcsany.minecraft.ervin_mod_1.entity.fish;

import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class GubrovEntity extends AbstractGroupFishEntity {
   public GubrovEntity(EntityType<? extends GubrovEntity> p_i50279_1_, World p_i50279_2_) {
      super(p_i50279_1_, p_i50279_2_);
   }

   protected ItemStack getFishBucket() {
      return new ItemStack(ModSpawnEggItemInit.GUBROV_SPAWN_EGG.get());
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_COD_AMBIENT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_COD_DEATH;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_COD_HURT;
   }

   protected SoundEvent getFlopSound() {
      return SoundEvents.ENTITY_COD_FLOP;
   }
}