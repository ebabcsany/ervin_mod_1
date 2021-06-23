package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMonsterEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;

public abstract class AbstractDgrurbkEntity extends DgrurbMonsterEntity {
   public boolean dgrurbksAttack;

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

}

