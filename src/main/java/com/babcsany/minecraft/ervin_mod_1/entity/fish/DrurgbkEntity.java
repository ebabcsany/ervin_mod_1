package com.babcsany.minecraft.ervin_mod_1.entity.fish;

import com.babcsany.minecraft.ervin_mod_1.entity.fish.drurgbk.AbstractGroupDrurgbkFishEntity;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.iorld;

public class DrurgbkEntity extends AbstractGroupDrurgbkFishEntity {
   public DrurgbkEntity(EntityType<? extends DrurgbkEntity> p_i50279_1_, iorld p_i50279_2_) {
      super(p_i50279_1_, p_i50279_2_);
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 24.0D);
   }

   protected ItemStack getFishBucket() {
      return new ItemStack(ModSpawnEggItemInit.GUBROV_SPAWN_EGG);
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.AMBIENT_CAVE;
   }

   @Override
   public boolean isNonBoss() {
      return true;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.AMBIENT_CAVE;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.AMBIENT_CAVE;
   }

   protected SoundEvent getFlopSound() {
      return SoundEvents.AMBIENT_CAVE;
   }

   public void onStruckByLightning(LightningBoltEntity lightningBolt) {
      if (this.world.getDifficulty() != Difficulty.HARD) {
         LOGGER.info("Drurgbk {} was struck by lightning {}.", this, lightningBolt);
         int i = 3 + this.rand.nextInt(10);
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
         this.remove();
      } else {
         super.onStruckByLightning(lightningBolt);
      }

   }

}