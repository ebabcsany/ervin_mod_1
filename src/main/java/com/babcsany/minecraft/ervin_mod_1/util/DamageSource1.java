package com.babcsany.minecraft.ervin_mod_1.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class DamageSource1 extends DamageSource {
   public static final DamageSource BLACK_LIGHTNING_BOLT = new DamageSource("blackLightningBolt");
   private boolean isUnblockable;
   private boolean isDamageAllowedInCreativeMode;
   /** Whether or not the damage ignores modification by potion effects or enchantments. */
   private boolean damageIsAbsolute;
   private float hungerDamage = 0.1F;
   private boolean fireDamage;
   private boolean projectile;
   private boolean difficultyScaled;
   private boolean magicDamage;
   private boolean explosion;

   public DamageSource1(String damageTypeIn) {
      super(damageTypeIn);
   }

   public String toString() {
      return "DamageSource (" + this.damageType + ")";
   }

   /**
    * Returns true if the damage is projectile based.
    */
   public boolean isProjectile() {
      return this.projectile;
   }

   /**
    * Define the damage type as projectile based.
    */
   public DamageSource1 setProjectile() {
      this.projectile = true;
      return this;
   }

   public boolean isExplosion() {
      return this.explosion;
   }

   public DamageSource1 setExplosion() {
      this.explosion = true;
      return this;
   }

   public boolean isUnblockable() {
      return this.isUnblockable;
   }

   /**
    * How much satiate(food) is consumed by this DamageSource
    */
   public float getHungerDamage() {
      return this.hungerDamage;
   }

   public boolean canHarmInCreative() {
      return this.isDamageAllowedInCreativeMode;
   }

   /**
    * Whether or not the damage ignores modification by potion effects or enchantments.
    */
   public boolean isDamageAbsolute() {
      return this.damageIsAbsolute;
   }

   /**
    * Retrieves the immediate causer of the damage, e.g. the arrow entity, not its shooter
    */
   @Nullable
   public Entity getImmediateSource() {
      return this.getTrueSource();
   }

   /**
    * Retrieves the true causer of the damage, e.g. the player who fired an arrow, the shulker who fired the bullet,
    * etc.
    */
   @Nullable
   public Entity getTrueSource() {
      return null;
   }

   public DamageSource1 setDamageBypassesArmor() {
      this.isUnblockable = true;
      this.hungerDamage = 0.0F;
      return this;
   }

   public DamageSource1 setDamageAllowedInCreativeMode() {
      this.isDamageAllowedInCreativeMode = true;
      return this;
   }

   /**
    * Sets a value indicating whether the damage is absolute (ignores modification by potion effects or enchantments),
    * and also clears out hunger damage.
    */
   public DamageSource1 setDamageIsAbsolute() {
      this.damageIsAbsolute = true;
      this.hungerDamage = 0.0F;
      return this;
   }

   /**
    * Define the damage type as fire based.
    */
   public DamageSource1 setFireDamage() {
      this.fireDamage = true;
      return this;
   }

   /**
    * Gets the death message that is displayed when the player dies
    */
   public ITextComponent getDeathMessage(LivingEntity entityLivingBaseIn) {
      LivingEntity livingentity = entityLivingBaseIn.getAttackingEntity();
      String s = "death.attack." + this.damageType;
      String s1 = s + ".player";
      return livingentity != null ? new TranslationTextComponent(s1, entityLivingBaseIn.getDisplayName(), livingentity.getDisplayName()) : new TranslationTextComponent(s, entityLivingBaseIn.getDisplayName());
   }

   /**
    * Returns true if the damage is fire based.
    */
   public boolean isFireDamage() {
      return this.fireDamage;
   }

   /**
    * Return the name of damage type.
    */
   public String getDamageType() {
      return this.damageType;
   }

   /**
    * Set whether this damage source will have its damage amount scaled based on the current difficulty.
    */
   public DamageSource1 setDifficultyScaled() {
      this.difficultyScaled = true;
      return this;
   }

   /**
    * Return whether this damage source will have its damage amount scaled based on the current difficulty.
    */
   public boolean isDifficultyScaled() {
      return this.difficultyScaled;
   }

   /**
    * Returns true if the damage is magic based.
    */
   public boolean isMagicDamage() {
      return this.magicDamage;
   }

   /**
    * Define the damage type as magic based.
    */
   public DamageSource1 setMagicDamage() {
      this.magicDamage = true;
      return this;
   }

   public boolean isCreativePlayer() {
      Entity entity = this.getTrueSource();
      return entity instanceof PlayerEntity && ((PlayerEntity)entity).abilities.isCreativeMode;
   }

   /**
    * Gets the location from which the damage originates.
    */
   @Nullable
   public Vector3d getDamageLocation() {
      return null;
   }
}