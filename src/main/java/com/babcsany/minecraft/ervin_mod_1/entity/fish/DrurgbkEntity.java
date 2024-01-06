package com.babcsany.minecraft.ervin_mod_1.entity.fish;

import com.babcsany.minecraft.ervin_mod_1.entity.fish.drurgbk.AbstractGroupDrurgbkFishEntity;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class DrurgbkEntity extends AbstractGroupDrurgbkFishEntity {
   public DrurgbkEntity(EntityType<? extends DrurgbkEntity> p_i50279_1_, World p_i50279_2_) {
      super(p_i50279_1_, p_i50279_2_);
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 24.0D);
   }

   protected ItemStack getFishBucket() {
      return new ItemStack(ModSpawnEggItemInit.DRURB_SPAWN_EGG.get());
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

   @Override
   public Entity getEntity() {
      return super.getEntity();
   }

   @Override
   public void deserializeNBT(CompoundNBT nbt) {
      super.deserializeNBT(nbt);
   }

   @Override
   public CompoundNBT serializeNBT() {
      return super.serializeNBT();
   }

   @Override
   public boolean shouldRiderSit() {
      return super.shouldRiderSit();
   }

   @Override
   public ItemStack getPickedResult(RayTraceResult target) {
      return super.getPickedResult(target);
   }

   @Override
   public boolean canRiderInteract() {
      return super.canRiderInteract();
   }

   @Override
   public boolean canBeRiddenInWater(Entity rider) {
      return super.canBeRiddenInWater(rider);
   }

   @Override
   public EntityClassification getClassification(boolean forSpawnCount) {
      return super.getClassification(forSpawnCount);
   }

   @Nonnull
   @Override
   public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
      return super.getCapability(cap);
   }
}