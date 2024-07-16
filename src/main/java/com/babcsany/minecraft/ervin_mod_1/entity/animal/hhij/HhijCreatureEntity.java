package com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class HhijCreatureEntity extends MobEntity {
   protected HhijCreatureEntity(EntityType<? extends HhijCreatureEntity> type, World worldIn) {
      super(type, worldIn);
   }

   public float getBlockPathWeight(BlockPos pos) {
      return this.getBlockPathWeight(pos, this.world);
   }

   public float getBlockPathWeight(BlockPos pos, IWorldReader reader) {
      return 0.0F;
   }

   public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
      return this.getBlockPathWeight(this.getPosition(), worldIn) >= 0.0F;
   }

   public boolean hasPath() {
      return !this.getNavigator().noPath();
   }

   protected void updateLeashedState() {
      super.updateLeashedState();
      Entity leashedEntity = this.getLeashHolder();
      if (leashedEntity != null && leashedEntity.world == this.world) {
         this.setHomePosAndDistance(leashedEntity.getPosition(), 5);
         float distance = this.getDistance(leashedEntity);
         if (this instanceof HhijTameableEntity && ((HhijTameableEntity)this).isEntitySleeping()) {
            if (distance > 10.0F) {
               this.clearLeashed(true, true);
            }

            return;
         }

         this.onLeashDistance(distance);
         if (distance > 10.0F) {
            this.clearLeashed(true, true);
            this.goalSelector.disableFlag(Goal.Flag.MOVE);
         } else if (distance > 6.0F) {
            double x = (leashedEntity.getPosX() - this.getPosX()) / (double)distance;
            double y = (leashedEntity.getPosY() - this.getPosY()) / (double)distance;
            double z = (leashedEntity.getPosZ() - this.getPosZ()) / (double)distance;
            this.setMotion(this.getMotion().add(Math.copySign(x * x * 0.4, x), Math.copySign(y * y * 0.4, y), Math.copySign(z * z * 0.4, z)));
         } else {
            this.goalSelector.enableFlag(Goal.Flag.MOVE);
            float f = 2.0F;
            Vector3d vector3d = (new Vector3d(leashedEntity.getPosX() - this.getPosX(), leashedEntity.getPosY() - this.getPosY(), leashedEntity.getPosZ() - this.getPosZ())).normalize().scale(Math.max(distance - f, 0.0F));
            this.getNavigator().tryMoveToXYZ(this.getPosX() + vector3d.x, this.getPosY() + vector3d.y, this.getPosZ() + vector3d.z, this.followLeashSpeed());
         }
      }
   }

   protected double followLeashSpeed() {
      return 1.0;
   }

   protected void onLeashDistance(@SuppressWarnings("UnusedDeclaration") float distance) {
   }
}
