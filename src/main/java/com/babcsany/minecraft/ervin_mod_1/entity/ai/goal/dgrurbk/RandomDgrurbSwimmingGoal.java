package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.RandomPositionGenerator;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbCreatureEntity;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;

public class RandomDgrurbSwimmingGoal extends RandomWalkingGoal {
   public RandomDgrurbSwimmingGoal(DgrurbCreatureEntity creature, double speed, int chance) {
      super(creature, speed, chance);
   }

   @Nullable
   protected Vector3d getPosition() {
      Vector3d vector3d = RandomPositionGenerator.findRandomTarget(this.creature, 10, 7);

      for(int i = 0; vector3d != null && !this.creature.world.getBlockState(new BlockPos(vector3d)).allowsMovement(this.creature.world, new BlockPos(vector3d), PathType.WATER) && i++ < 10; vector3d = RandomPositionGenerator.findRandomTarget(this.creature, 10, 7)) {
      }

      return vector3d;
   }
}
