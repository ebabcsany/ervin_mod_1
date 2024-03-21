package com.babcsany.minecraft.ervin_mod_1.entity.projectile;

import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.entity.EntityInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ScrakthsPearlEntity extends EnderPearlEntity {
   public ScrakthsPearlEntity(EntityType<? extends ScrakthsPearlEntity> p_i50153_1_, World world) {
      super(p_i50153_1_, world);
   }

   public ScrakthsPearlEntity(World worldIn, LivingEntity throwerIn) {
      super(worldIn, throwerIn);
   }

   @OnlyIn(Dist.CLIENT)
   public ScrakthsPearlEntity(World worldIn, double x, double y, double z) {
      super(worldIn, x, y, z);
   }

   protected Item getDefaultItem() {
      return ItemInit.SCRAKTHS_PEARL.get();
   }

   /**
    * Called when the arrow hits an entity
    */
   protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
      super.onEntityHit(p_213868_1_);
      p_213868_1_.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0.0F);
   }

   /**
    * Called when this EntityFireball hits a block or entity.
    */
   protected void onImpact(RayTraceResult result) {
      super.onImpact(result);
      Entity entity = this.getShooter();

      for(int i = 0; i < 32; ++i) {
         this.world.addParticle(ParticleTypes.PORTAL, this.getPosX(), this.getPosY() + this.rand.nextDouble() * 2.0D, this.getPosZ(), this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
      }

      if (!this.world.isRemote && !this.removed) {
         if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entity;
            if (serverplayerentity.connection.getNetworkManager().isChannelOpen() && serverplayerentity.world == this.world && !serverplayerentity.isSleeping()) {
               net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(serverplayerentity, this.getPosX(), this.getPosY(), this.getPosZ(), 5.0F);
               if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) { // Don't indent to lower patch size
               if (this.rand.nextFloat() < 0.05F && this.world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                  EndermiteEntity endermiteentity = EntityType.ENDERMITE.create(this.world);
                  endermiteentity.setSpawnedByPlayer(true);
                  endermiteentity.setLocationAndAngles(entity.getPosX(), entity.getPosY(), entity.getPosZ(), entity.rotationYaw, entity.rotationPitch);
                  this.world.addEntity(endermiteentity);
               }

               if (entity.isPassenger()) {
                  entity.stopRiding();
               }

               entity.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
               entity.fallDistance = 0.0F;
               entity.attackEntityFrom(DamageSource.GENERIC, event.getAttackDamage());
               } //Forge: End
            }
         } else if (entity != null) {
            entity.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
            entity.fallDistance = 0.0F;
         }

         this.remove();
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      Entity entity = this.getShooter();
      if (entity instanceof PlayerEntity && !entity.isAlive()) {
         this.remove();
      } else {
         super.tick();
      }

   }

   @Nullable
   public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
      Entity entity = this.getShooter();
      if (entity != null && entity.world.getDimensionKey() != server.getDimensionKey()) {
         this.setShooter(null);
      }

      return super.changeDimension(server, teleporter);
   }
}