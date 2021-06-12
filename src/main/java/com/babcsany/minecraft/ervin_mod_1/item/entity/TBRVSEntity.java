package com.babcsany.minecraft.ervin_mod_1.item.entity;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TBRVSEntity extends ProjectileItemEntity {
   public TBRVSEntity(EntityType<? extends TBRVSEntity> p_i50154_1_, World p_i50154_2_) {
      super(p_i50154_1_, p_i50154_2_);
   }

   public TBRVSEntity(World worldIn, LivingEntity throwerIn) {
      super(EntityType.EGG, throwerIn, worldIn);
   }

   public TBRVSEntity(World worldIn, double x, double y, double z) {
      super(EntityType.EGG, x, y, z, worldIn);
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 3) {
         double d0 = 0.08D;

         for(int i = 0; i < 8; ++i) {
            this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getPosX(), this.getPosY(), this.getPosZ(), ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D);
         }
      }

   }

   /**
    * Called when the arrow hits an entity
    */
   protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
      super.onEntityHit(p_213868_1_);
      p_213868_1_.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 0.0F);
   }

   /**
    * Called when this EntityFireball hits a block or entity.
    */
   protected void onImpact(RayTraceResult result) {
      super.onImpact(result);
      if (!this.world.isRemote) {
         if (this.rand.nextInt(8) == 0) {
            int i = 1;
            if (this.rand.nextInt(32) == 0) {
               i = 4;
            }

            for(int j = 0; j < i; ++j) {
               $TraderEntity $TraderEntity = EntityInit.$_TRADER_ENTITY.get().create(this.world);
               $TraderEntity.setGrowingAge(-24000);
               $TraderEntity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
               this.world.addEntity($TraderEntity);
            }
         }

         this.world.setEntityState(this, (byte)3);
         this.remove();
      }

   }

   protected Item getDefaultItem() {
      return Items.EGG;
   }
}