package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.phase;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.EndPodiumFeature;

import javax.annotation.Nullable;

public class HoldingPatternPhase extends Phase {
   private static final EntityPredicate field_221117_b = (new EntityPredicate()).setDistance(64.0D);
   private Path currentPath;
   private Vector3d targetLocation;
   private boolean clockwise;

   public HoldingPatternPhase(ZurEntity zurIn) {
      super(zurIn);
   }

   /*public PhaseType<HoldingPatternPhase> getType() {
      return PhaseType.HOLDING_PATTERN;
   }*/

   /**
    * Gives the phase a chance to update its status.
    * Called by dragon's onLivingUpdate. Only used when !worldObj.isRemote.
    */
   public void serverTick() {
      double d0 = this.targetLocation == null ? 0.0D : this.targetLocation.squareDistanceTo(this.zur.getPosX(), this.zur.getPosY(), this.zur.getPosZ());

   }

   @Override
   public void onCrystalDestroyed(EnderCrystalEntity crystal, BlockPos pos, DamageSource dmgSrc, @Nullable PlayerEntity plyr) {

   }

   /**
    * Called when this phase is set to active
    */
   public void initPhase() {
      this.currentPath = null;
      this.targetLocation = null;
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

   /*private void strafePlayer(PlayerEntity player) {
      this.zur.getPhaseManager().setPhase(PhaseType.STRAFE_PLAYER);
      this.zur.getPhaseManager().getPhase(PhaseType.STRAFE_PLAYER).setTarget(player);
   }*/

   /*private void navigateToNextPathNode() {
      if (this.currentPath != null && !this.currentPath.isFinished()) {
         Vector3i vector3i = this.currentPath.getCurrentPos();
         this.currentPath.incrementPathIndex();
         double d0 = vector3i.getX();
         double d1 = vector3i.getZ();

         double d2;
         while(true) {
            d2 = (double)((float)vector3i.getY() + this.dragon.getRNG().nextFloat() * 20.0F);
            if (!(d2 < (double)vector3i.getY())) {
               break;
            }
         }

         this.targetLocation = new Vector3d(d0, d2, d1);
      }

   }

   public void onCrystalDestroyed(EnderCrystalEntity crystal, BlockPos pos, DamageSource dmgSrc, @Nullable PlayerEntity plyr) {
      if (plyr != null && !plyr.abilities.disableDamage) {
         this.strafePlayer(plyr);
      }

   }*/
}