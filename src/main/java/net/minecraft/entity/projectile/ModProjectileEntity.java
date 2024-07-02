package net.minecraft.entity.projectile;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class ModProjectileEntity extends ProjectileEntity {
   private UUID owner;
   private int id;
   private boolean leftOwner;

   public ModProjectileEntity(EntityType<? extends ModProjectileEntity> type, World world) {
      super(type, world);
   }

   public void setShooter(@Nullable Entity entityIn) {
      if (entityIn != null) {
         this.owner = entityIn.getUniqueID();
         this.id = entityIn.getEntityId();
      }

   }

   @Override
   @Nullable
   public Entity getShooter() {
      if (this.owner != null && this.world instanceof ServerWorld) {
         return ((ServerWorld)this.world).getEntityByUuid(this.owner);
      } else {
         return this.id != 0 ? this.world.getEntityByID(this.id) : null;
      }
   }

   protected void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   protected void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
   }

   /**
    * Called to update the entity's position/logic.
    */
   @Override
   public void tick() {
      if (!this.leftOwner) {
         this.leftOwner = this.func_234615_h_();
      }

      super.tick();
   }

   private boolean func_234615_h_() {
      Entity entity = this.getShooter();
      if (entity != null) {
         for(Entity entity1 : this.world.getEntitiesInAABBexcluding(this, this.getBoundingBox().expand(this.getMotion()).grow(1.0D), (p_234613_0_) -> {
            return !p_234613_0_.isSpectator() && p_234613_0_.canBeCollidedWith();
         })) {
            if (entity1.getLowestRidingEntity() == entity.getLowestRidingEntity()) {
               return false;
            }
         }
      }

      return true;
   }

   /**
    * Called when this EntityFireball hits a block or entity.
    */
   @Override
   protected void onImpact(RayTraceResult result) {
      RayTraceResult.Type raytraceresult$type = result.getType();
      if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
         this.onEntityHit((EntityRayTraceResult)result);
      } else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
         this.func_230299_a_((BlockRayTraceResult)result);
      }

   }

   /**
    * Called when the arrow hits an entity
    */
   @Override
   protected void onEntityHit(EntityRayTraceResult result) {
   }

   @Override
   protected void func_230299_a_(BlockRayTraceResult result) {
      BlockState blockstate = this.world.getBlockState(result.getPos());
      blockstate.onProjectileCollision(this.world, blockstate, result, this);
   }

   /**
    * Updates the entity motion clientside, called by packets from the server
    */
   @OnlyIn(Dist.CLIENT)
   public void setVelocity(double x, double y, double z) {
      this.setMotion(x, y, z);
      if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
         float f = MathHelper.sqrt(x * x + z * z);
         this.rotationPitch = (float)(MathHelper.atan2(y, (double)f) * (double)(180F / (float)Math.PI));
         this.rotationYaw = (float)(MathHelper.atan2(x, z) * (double)(180F / (float)Math.PI));
         this.prevRotationPitch = this.rotationPitch;
         this.prevRotationYaw = this.rotationYaw;
         this.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
      }

   }

   @Override
   protected boolean func_230298_a_(Entity entityIn) {
      if (!entityIn.isSpectator() && entityIn.isAlive() && entityIn.canBeCollidedWith()) {
         Entity entity = this.getShooter();
         return entity == null || this.leftOwner || !entity.isRidingSameEntity(entityIn);
      } else {
         return false;
      }
   }
}