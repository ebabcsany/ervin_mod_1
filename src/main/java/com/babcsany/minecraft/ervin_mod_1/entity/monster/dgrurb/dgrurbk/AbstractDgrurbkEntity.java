package com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMonsterEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class AbstractDgrurbkEntity extends DgrurbMonsterEntity {
   public boolean dgrurbksAttack;
   public int eatingGrassTimer;
   @Nullable
   public PlayerEntity customer;
   private boolean doesRewardZUR = true;
   public int despawnDelay;

   public AbstractDgrurbkEntity(EntityType<? extends AbstractDgrurbkEntity> type, World worldIn) {
      super(type, worldIn);
   }

   /**
    * Called when the entity is attacked.
    */
   public boolean attackEntityFrom(DamageSource source, float amount) {
      if (this.isInvulnerableTo(source)) {
         return false;
      } else {
         boolean flag = this.isDedicatedServer() && this.canDgrurbksAttack() && "fall".equals(source.damageType);
         if (!flag && source != DamageSource.GENERIC) {
            return false;
         } else {
            if (source instanceof EntityDamageSource) {
               Entity entity = source.getTrueSource();
               if (entity instanceof AbstractDgrurbkEntity && this.canAttackDgrurb((AbstractDgrurbkEntity) entity)) {
                  return false;
               }

               if (entity instanceof AbstractArrowEntity) {
                  AbstractArrowEntity abstractarrowentity = (AbstractArrowEntity)entity;
                  Entity entity1 = abstractarrowentity.func_234616_v_();
                  if (entity1 instanceof AbstractDgrurbkEntity && this.canAttackDgrurb((AbstractDgrurbkEntity) entity1)) {
                     return false;
                  }
               }
            }

            return super.attackEntityFrom(source, amount);
         }
      }
   }

   @Override
   public void livingTick() {
      super.livingTick();
      this.updateArmSwingProgress();

      if (!this.world.isRemote) {
         this.handleDespawn();
      }

      if (this.world.isRemote) {
         this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
      }

   }

   /*public int getInvulTime() {
      return this.dataManager.get(INVULNERABILITY_TIME);
   }*/

   public boolean hasCustomer() {
      return this.customer != null;
   }

   public void handleDespawn() {
      if (this.despawnDelay > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
         this.remove();
      }

      if (this.getDoesRewardZur()) {
         int i = 1 + this.rand.nextInt(1);
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
      }
   }

   public boolean getDoesRewardZur() {
      return this.doesRewardZUR;
   }

   public boolean canAttackDgrurb(AbstractDgrurbkEntity entity) {
      return entity.canDgrurbksAttack();
   }

   /**
    * Returns if other players can attack this player
    */
   private boolean canDgrurbksAttack() {
      return this.isDgrurbksAttack();
   }

   public boolean isDgrurbksAttack() {
      return this.dgrurbksAttack;
   }

   public abstract boolean isDedicatedServer();

   public boolean isCharged() {
      return this.getHealth() <= this.getMaxHealth() / 2.0F;
   }

}

