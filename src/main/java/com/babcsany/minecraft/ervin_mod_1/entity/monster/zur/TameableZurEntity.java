package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur;

import com.babcsany.minecraft.ervin_mod_1.trigger.ModCriteriaTriggers;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.*;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class TameableZurEntity extends AnimalEntity {
   private static final UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
   public static final AttributeModifier MODIFIER = new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", 0.6D, AttributeModifier.Operation.ADDITION);
   public static final DataParameter<Boolean> IS_DRINKING = EntityDataManager.createKey(TameableZurEntity.class, DataSerializers.BOOLEAN);
   protected static final DataParameter<Byte> TAMED = EntityDataManager.createKey(TameableZurEntity.class, DataSerializers.BYTE);
   protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.createKey(TameableZurEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
   public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
   private boolean field_233683_bw_;
   static TraderZurEntity traderZurEntity;
   public boolean zurDropItem;
   private int despawnDelay;
   public int potionUseTimer;
   public float wingRotDelta = 1.0F;
   private int eatingGrassTimer;
   public float wingRotation;

   protected TameableZurEntity(EntityType<? extends TameableZurEntity> type, World worldIn) {
      super(type, worldIn);
      this.setupTamedAI();
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(TAMED, (byte)0);
      this.dataManager.register(IS_DRINKING, Boolean.TRUE);
      this.dataManager.register(OWNER_UNIQUE_ID, Optional.empty());
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zurs and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      this.updateArmSwingProgress();
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (this.world.isRemote) {
         this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
      }

      if (!this.world.isRemote) {
         this.handleDespawn();
      }

      if (!this.world.isRemote && this.isAlive()) {
         if (this.isDrinkingPotion()) {
            if (this.potionUseTimer-- <= 1) {
               this.setDrinkingPotion(false);
               ItemStack itemstack = this.getHeldItemMainhand();
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
               if (itemstack.getItem() == isBurnableItemInit.VIRKT.get()) {
                  List<EffectInstance> list = PotionUtils.getEffectsFromStack(itemstack);
                  for(EffectInstance effectinstance : list) {
                     this.addPotionEffect(new EffectInstance(effectinstance));
                  }
               }

               this.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(MODIFIER);
            }
         } else {
            Potion potion = null;
            if (this.rand.nextFloat() < 0.15F && this.areEyesInFluid(FluidTags.WATER) && !this.isPotionActive(Effects.WATER_BREATHING)) {
               potion = Potions.WATER_BREATHING;
            } else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(Effects.FIRE_RESISTANCE)) {
               potion = Potions.FIRE_RESISTANCE;
            } else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
               potion = Potions.HEALING;
            } else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(Effects.STRENGTH) && this.getAttackTarget().getDistanceSq(this) > 2.0D || !this.isPotionActive(Effects.SPEED) && !this.isPotionActive(Effects.JUMP_BOOST)) {
               potion = Potions.SWIFTNESS;
            }

            if (potion != null) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(isBurnableItemInit.VIRKT.get()), potion));
               this.potionUseTimer = this.getHeldItemMainhand().getUseDuration();
               this.setDrinkingPotion(true);
               if (!this.isSilent()) {
                  this.world.playSound(null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
               }

               ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
               modifiableattributeinstance.removeModifier(MODIFIER);
               modifiableattributeinstance.applyNonPersistentModifier(MODIFIER);
            }
         }

         if (this.rand.nextFloat() < 7.5E-4F) {
            this.world.setEntityState(this, (byte)15);
         }
      }
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && this.isZurDropItem() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(isBurnableItemInit.LEAT.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
   }

   public boolean isZurDropItem() {
      return !this.zurDropItem;
   }

   public void setDrinkingPotion(boolean drinkingPotion) {
      this.getDataManager().set(IS_DRINKING, drinkingPotion);
   }

   public void handleDespawn() {
      if (this.despawnDelay > 0 && !traderZurEntity.hasCustomer() && --this.despawnDelay == 0) {
         this.remove();
      }

   }

   public boolean isDrinkingPotion() {
      return this.getDataManager().get(IS_DRINKING);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      if (this.getOwnerId() != null) {
         compound.putUniqueId("Owner", this.getOwnerId());
      }

      compound.putBoolean("Sitting", this.field_233683_bw_);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      UUID uuid;
      if (compound.hasUniqueId("Owner")) {
         uuid = compound.getUniqueId("Owner");
      } else {
         String s = compound.getString("Owner");
         uuid = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), s);
      }

      if (uuid != null) {
         try {
            this.setOwnerId(uuid);
            this.setTamed(true);
         } catch (Throwable throwable) {
            this.setTamed(false);
         }
      }

      this.field_233683_bw_ = compound.getBoolean("Sitting");
      this.func_233686_v_(this.field_233683_bw_);
   }

   public boolean canBeLeashedTo(PlayerEntity player) {
      return !this.getLeashed();
   }

   /**
    * Play the taming effect, will either be hearts or smoke depending on status
    */
   @OnlyIn(Dist.CLIENT)
   protected void playTameEffect(boolean play) {
      IParticleData iparticledata = ParticleTypes.HEART;
      if (!play) {
         iparticledata = ParticleTypes.SMOKE;
      }

      for(int i = 0; i < 7; ++i) {
         double d0 = this.rand.nextGaussian() * 0.02D;
         double d1 = this.rand.nextGaussian() * 0.02D;
         double d2 = this.rand.nextGaussian() * 0.02D;
         this.world.addParticle(iparticledata, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), d0, d1, d2);
      }

   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 7) {
         this.playTameEffect(true);
      } else if (id == 6) {
         this.playTameEffect(false);
      } else {
         super.handleStatusUpdate(id);
      }

   }

   public boolean isTamed() {
      return (this.dataManager.get(TAMED) & 4) != 0;
   }

   public void setTamed(boolean tamed) {
      byte b0 = this.dataManager.get(TAMED);
      if (tamed) {
         this.dataManager.set(TAMED, (byte)(b0 | 4));
      } else {
         this.dataManager.set(TAMED, (byte)(b0 & -5));
      }

      this.setupTamedAI();
   }

   protected void setupTamedAI() {
   }

   public boolean func_233684_eK_() {
      return (this.dataManager.get(TAMED) & 1) != 0;
   }

   public void func_233686_v_(boolean p_233686_1_) {
      byte b0 = this.dataManager.get(TAMED);
      if (p_233686_1_) {
         this.dataManager.set(TAMED, (byte)(b0 | 1));
      } else {
         this.dataManager.set(TAMED, (byte)(b0 & -2));
      }

   }

   @Nullable
   public UUID getOwnerId() {
      return this.dataManager.get(OWNER_UNIQUE_ID).orElse((UUID)null);
   }

   public void setOwnerId(@Nullable UUID p_184754_1_) {
      this.dataManager.set(OWNER_UNIQUE_ID, Optional.ofNullable(p_184754_1_));
   }

   public void setTamedBy(PlayerEntity player) {
      this.setTamed(true);
      this.setOwnerId(player.getUniqueID());
      if (player instanceof ServerPlayerEntity) {
         ModCriteriaTriggers.TAME_ZUR_ANIMAL.trigger((ServerPlayerEntity)player, this);
      }

   }

   @Nullable
   public LivingEntity getOwner() {
      try {
         UUID uuid = this.getOwnerId();
         return uuid == null ? null : this.world.getPlayerByUuid(uuid);
      } catch (IllegalArgumentException illegalargumentexception) {
         return null;
      }
   }

   public boolean canAttack(LivingEntity target) {
      return this.isOwner(target) ? false : super.canAttack(target);
   }

   public boolean isOwner(LivingEntity entityIn) {
      return entityIn == this.getOwner();
   }

   public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
      return true;
   }

   public Team getTeam() {
      if (this.isTamed()) {
         LivingEntity livingentity = this.getOwner();
         if (livingentity != null) {
            return livingentity.getTeam();
         }
      }

      return super.getTeam();
   }

   /**
    * Returns whether this Entity is on the same team as the given Entity.
    */
   public boolean isOnSameTeam(Entity entityIn) {
      if (this.isTamed()) {
         LivingEntity livingentity = this.getOwner();
         if (entityIn == livingentity) {
            return true;
         }

         if (livingentity != null) {
            return livingentity.isOnSameTeam(entityIn);
         }
      }

      return super.isOnSameTeam(entityIn);
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void onDeath(DamageSource cause) {
      if (!this.world.isRemote && this.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) && this.getOwner() instanceof ServerPlayerEntity) {
         this.getOwner().sendMessage(this.getCombatTracker().getDeathMessage(), Util.DUMMY_UUID);
      }

      super.onDeath(cause);
   }

   public boolean func_233685_eM_() {
      return this.field_233683_bw_;
   }

   public void func_233687_w_(boolean p_233687_1_) {
      this.field_233683_bw_ = p_233687_1_;
   }
}
