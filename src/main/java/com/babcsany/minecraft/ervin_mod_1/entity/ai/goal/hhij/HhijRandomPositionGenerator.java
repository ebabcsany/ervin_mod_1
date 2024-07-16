package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijCreatureEntity;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class HhijRandomPositionGenerator {
   /**
    * finds a random target within par1(x,z) and par2 (y) blocks
    */
   @Nullable
   public static Vector3d findRandomTarget(HhijCreatureEntity creatureIn, int xz, int y) {
      return func_226339_a_(creatureIn, xz, y, 0, null, true, (float)Math.PI / 2F, creatureIn::getBlockPathWeight, false, 0, 0, true);
   }

   @Nullable
   public static Vector3d findGroundTarget(HhijCreatureEntity creatureIn, int xz, int y, int p_226338_3_, @Nullable Vector3d p_226338_4_, double p_226338_5_) {
      return func_226339_a_(creatureIn, xz, y, p_226338_3_, p_226338_4_, true, p_226338_5_, creatureIn::getBlockPathWeight, true, 0, 0, false);
   }

   @Nullable
   public static Vector3d getLandPos(HhijCreatureEntity creature, int maxXZ, int maxY) {
      return func_221024_a(creature, maxXZ, maxY, creature::getBlockPathWeight);
   }

   @Nullable
   public static Vector3d func_221024_a(HhijCreatureEntity creatureIn, int xz, int y, ToDoubleFunction<BlockPos> posToDoubleFunction) {
      return func_226339_a_(creatureIn, xz, y, 0, null, false, 0.0D, posToDoubleFunction, true, 0, 0, true);
   }

   @Nullable
   public static Vector3d findAirTarget(HhijCreatureEntity creatureIn, int maxXZ, int y, Vector3d targetVec3d, float p_226340_4_, int p_226340_5_, int p_226340_6_) {
      return func_226339_a_(creatureIn, maxXZ, y, 0, targetVec3d, false, p_226340_4_, creatureIn::getBlockPathWeight, true, p_226340_5_, p_226340_6_, true);
   }

   @Nullable
   public static Vector3d func_234133_a_(HhijCreatureEntity creatureIn, int xz, int y, Vector3d targetVec3d) {
      Vector3d vector3d = targetVec3d.subtract(creatureIn.getPosX(), creatureIn.getPosY(), creatureIn.getPosZ());
      return func_226339_a_(creatureIn, xz, y, 0, vector3d, false, (float)Math.PI / 2F, creatureIn::getBlockPathWeight, true, 0, 0, true);
   }

   /**
    * finds a random target within par1(x,z) and par2 (y) blocks in the direction of the point par3
    */
   @Nullable
   public static Vector3d findRandomTargetBlockTowards(HhijCreatureEntity creatureIn, int xz, int y, Vector3d targetVec3d) {
      Vector3d vector3d = targetVec3d.subtract(creatureIn.getPosX(), creatureIn.getPosY(), creatureIn.getPosZ());
      return func_226339_a_(creatureIn, xz, y, 0, vector3d, true, (float)Math.PI / 2F, creatureIn::getBlockPathWeight, false, 0, 0, true);
   }

   @Nullable
   public static Vector3d findRandomTargetTowardsScaled(HhijCreatureEntity creatureIn, int xz, int y, Vector3d targetVec3d, double p_203155_4_) {
      Vector3d vector3d = targetVec3d.subtract(creatureIn.getPosX(), creatureIn.getPosY(), creatureIn.getPosZ());
      return func_226339_a_(creatureIn, xz, y, 0, vector3d, true, p_203155_4_, creatureIn::getBlockPathWeight, false, 0, 0, true);
   }

   @Nullable
   public static Vector3d func_226344_b_(HhijCreatureEntity creatureIn, int xz, int y, int maxY, Vector3d targetVec3d, double p_226344_5_) {
      Vector3d vector3d = targetVec3d.subtract(creatureIn.getPosX(), creatureIn.getPosY(), creatureIn.getPosZ());
      return func_226339_a_(creatureIn, xz, y, maxY, vector3d, false, p_226344_5_, creatureIn::getBlockPathWeight, true, 0, 0, false);
   }

   /**
    * finds a random target within par1(x,z) and par2 (y) blocks in the reverse direction of the point par3
    */
   @Nullable
   public static Vector3d findRandomTargetBlockAwayFrom(HhijCreatureEntity creatureIn, int xz, int y, Vector3d targetVec3) {
      Vector3d vector3d = creatureIn.getPositionVec().subtract(targetVec3);
      return func_226339_a_(creatureIn, xz, y, 0, vector3d, true, (float)Math.PI / 2F, creatureIn::getBlockPathWeight, false, 0, 0, true);
   }

   @Nullable
   public static Vector3d func_223548_b(HhijCreatureEntity creatureIn, int xz, int y, Vector3d targetVec3) {
      Vector3d vector3d = creatureIn.getPositionVec().subtract(targetVec3);
      return func_226339_a_(creatureIn, xz, y, 0, vector3d, false, (float)Math.PI / 2F, creatureIn::getBlockPathWeight, true, 0, 0, true);
   }

   @Nullable
   private static Vector3d func_226339_a_(HhijCreatureEntity creatureIn, int xz, int y, int maxY, @Nullable Vector3d targetVec3, boolean p_226339_5_, double p_226339_6_, ToDoubleFunction<BlockPos> posToDoubleFunction, boolean p_226339_9_, int maxXZ, int p_226339_11_, boolean randomTarget) {
      PathNavigator pathnavigator = creatureIn.getNavigator();
      Random random = creatureIn.getRNG();
      boolean flag;
      if (creatureIn.detachHome()) {
         flag = creatureIn.getHomePosition().withinDistance(creatureIn.getPositionVec(), (double)(creatureIn.getMaximumHomeDistance() + (float)xz) + 1.0D);
      } else {
         flag = false;
      }

      boolean flag1 = false;
      double d0 = Double.NEGATIVE_INFINITY;
      BlockPos blockpos = creatureIn.getPosition();

      for(int i = 0; i < 10; ++i) {
         BlockPos blockpos1 = func_226343_a_(random, xz, y, maxY, targetVec3, p_226339_6_);
         if (blockpos1 != null) {
            int j = blockpos1.getX();
            int k = blockpos1.getY();
            int l = blockpos1.getZ();
            if (creatureIn.detachHome() && xz > 1) {
               BlockPos homePos = creatureIn.getHomePosition();
               if (creatureIn.getPosX() > (double)homePos.getX()) {
                  j -= random.nextInt(xz / 2);
               } else {
                  j += random.nextInt(xz / 2);
               }

               if (creatureIn.getPosZ() > (double)homePos.getZ()) {
                  l -= random.nextInt(xz / 2);
               } else {
                  l += random.nextInt(xz / 2);
               }
            }

            BlockPos blockpos3 = new BlockPos((double)j + creatureIn.getPosX(), (double)k + creatureIn.getPosY(), (double)l + creatureIn.getPosZ());
            if (blockpos3.getY() >= 0 && blockpos3.getY() <= creatureIn.world.getHeight() && (!flag || creatureIn.isWithinHomeDistanceFromPosition(blockpos3)) && (!randomTarget || pathnavigator.canEntityStandOnPos(blockpos3))) {
               if (p_226339_9_) {
                  blockpos3 = func_226342_a_(blockpos3, random.nextInt(maxXZ + 1) + p_226339_11_, creatureIn.world.getHeight(), (pos) -> creatureIn.world.getBlockState(pos).getMaterial().isSolid());
               }

               if (p_226339_5_ || !creatureIn.world.getFluidState(blockpos3).isTagged(FluidTags.WATER)) {
                  PathNodeType pathnodetype = WalkNodeProcessor.getFloorNodeType(creatureIn.world, blockpos3.toMutable());
                  if (creatureIn.getPathPriority(pathnodetype) == 0.0F) {
                     double d1 = posToDoubleFunction.applyAsDouble(blockpos3);
                     if (d1 > d0) {
                        d0 = d1;
                        blockpos = blockpos3;
                        flag1 = true;
                     }
                  }
               }
            }
         }
      }

      return flag1 ? Vector3d.copyCenteredHorizontally(blockpos) : null;
   }

   @Nullable
   private static BlockPos func_226343_a_(Random random, int xz, int y, int maxY, @Nullable Vector3d vector3d, double p_226343_5_) {
      if (vector3d != null && !(p_226343_5_ >= Math.PI)) {
         double d3 = MathHelper.atan2(vector3d.z, vector3d.x) - (double)((float)Math.PI / 2F);
         double d4 = d3 + (double)(2.0F * random.nextFloat() - 1.0F) * p_226343_5_;
         double d0 = Math.sqrt(random.nextDouble()) * (double)MathHelper.SQRT_2 * (double)xz;
         double d1 = -d0 * Math.sin(d4);
         double d2 = d0 * Math.cos(d4);
         if (!(Math.abs(d1) > (double)xz) && !(Math.abs(d2) > (double)xz)) {
            int l = random.nextInt(2 * y + 1) - y + maxY;
            return new BlockPos(d1, l, d2);
         } else {
            return null;
         }
      } else {
         int i = random.nextInt(2 * xz + 1) - xz;
         int j = random.nextInt(2 * y + 1) - y + maxY;
         int k = random.nextInt(2 * xz + 1) - xz;
         return new BlockPos(i, j, k);
      }
   }

   static BlockPos func_226342_a_(BlockPos pos, int maxXZ, int maxY, Predicate<BlockPos> posPredicate) {
      if (maxXZ < 0) {
         throw new IllegalArgumentException("aboveSolidAmount was " + maxXZ + ", expected >= 0");
      } else if (!posPredicate.test(pos)) {
         return pos;
      } else {
         BlockPos blockpos;
         for(blockpos = pos.up(); blockpos.getY() < maxY && posPredicate.test(blockpos); blockpos = blockpos.up()) {
         }

         BlockPos blockpos1;
         BlockPos blockpos2;
         for(blockpos1 = blockpos; blockpos1.getY() < maxY && blockpos1.getY() - blockpos.getY() < maxXZ; blockpos1 = blockpos2) {
            blockpos2 = blockpos1.up();
            if (posPredicate.test(blockpos2)) {
               break;
            }
         }

         return blockpos1;
      }
   }
}