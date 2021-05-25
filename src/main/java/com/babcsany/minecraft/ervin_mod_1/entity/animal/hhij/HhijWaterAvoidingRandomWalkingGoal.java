package com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij.HhijRandomPositionGenerator;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij.HhijRandomWalkingGoal;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;

public class HhijWaterAvoidingRandomWalkingGoal extends HhijRandomWalkingGoal {
   protected final float probability;

   public HhijWaterAvoidingRandomWalkingGoal(HhijCreatureEntity creature, double speedIn) {
      this(creature, speedIn, 0.001F);
   }

   public HhijWaterAvoidingRandomWalkingGoal(HhijCreatureEntity creature, double speedIn, float probabilityIn) {
      super(creature, speedIn);
      this.probability = probabilityIn;
   }

   @Nullable
   protected Vector3d getPosition() {
      if (this.creature.isInWaterOrBubbleColumn()) {
         Vector3d vector3d = HhijRandomPositionGenerator.getLandPos(this.creature, 15, 7);
         return vector3d == null ? super.getPosition() : vector3d;
      } else {
         return this.creature.getRNG().nextFloat() >= this.probability ? HhijRandomPositionGenerator.getLandPos(this.creature, 10, 7) : super.getPosition();
      }
   }
}