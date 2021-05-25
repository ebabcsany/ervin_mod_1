package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.phase;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class ChargingPlayerPhase extends Phase {
   private static final Logger LOGGER = LogManager.getLogger();
   private Vector3d targetLocation;
   private int timeSinceCharge;

   public ChargingPlayerPhase(ZurEntity zurIn) {
      super(zurIn);
   }

   /**
    * Gives the phase a chance to update its status.
    * Called by dragon's onLivingUpdate. Only used when !worldObj.isRemote.
    * /
   public void serverTick() {
      if (this.targetLocation == null) {
         LOGGER.warn("Aborting charge player as no target was set.");
         this.zur.getPhaseManager().setPhase(PhaseType.HOLDING_PATTERN);
      } else if (this.timeSinceCharge > 0 && this.timeSinceCharge++ >= 10) {
         this.zur.getPhaseManager().setPhase(PhaseType.HOLDING_PATTERN);
      } else {
         double d0 = this.targetLocation.squareDistanceTo(this.dragon.getPosX(), this.dragon.getPosY(), this.dragon.getPosZ());
         if (d0 < 100.0D || d0 > 22500.0D || this.zur.collidedHorizontally || this.dragon.collidedVertically) {
            ++this.timeSinceCharge;
         }

      }
   }*/

   @Override
   public void onCrystalDestroyed(EnderCrystalEntity crystal, BlockPos pos, DamageSource dmgSrc, @Nullable PlayerEntity plyr) {

   }

   /**
    * Called when this phase is set to active
    */
   public void initPhase() {
      this.targetLocation = null;
      this.timeSinceCharge = 0;
   }

   public void setTarget(Vector3d p_188668_1_) {
      this.targetLocation = p_188668_1_;
   }

   /**
    * Returns the maximum amount dragon may rise or fall during this phase
    */
   public float getMaxRiseOrFall() {
      return 3.0F;
   }

   @Override
   public net.minecraft.entity.boss.dragon.phase.PhaseType<? extends IPhase> getType() {
      return null;
   }

   /**
    * Returns the location the dragon is flying toward
    */
   @Nullable
   public Vector3d getTargetLocation() {
      return this.targetLocation;
   }

   /*public PhaseType<ChargingPlayerPhase> getType() {
      return PhaseType.CHARGING_PLAYER;
   }*/
}