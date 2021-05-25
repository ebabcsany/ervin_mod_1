package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public abstract class ZurBreakBlockGoal extends AgeableEntity {
    protected static final Random rand = new Random();
    public GoalSelector goalSelector;

    public ZurBreakBlockGoal(EntityType<? extends AbstractZurEntity> type, World worldIn) {
        super(type, worldIn);
    }

    class AttackDirtGoal extends net.minecraft.entity.ai.goal.BreakBlockGoal {
        public AttackDirtGoal(CreatureEntity creatureIn, double speed, int yMax) {
            super(Blocks.DIRT, creatureIn, speed, yMax);
        }

        public void playBreakingSound(IWorld worldIn, BlockPos pos) {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_STEP, SoundCategory.HOSTILE, 0.5F, 0.9F + ZurBreakBlockGoal.this.rand.nextFloat() * 0.2F);
        }

        public void playBrokenSound(World worldIn, BlockPos pos) {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
        }

        public double getTargetDistanceSq() {
            return 1.14D;
        }
    }

    class AttackGrassBlockGoal extends net.minecraft.entity.ai.goal.BreakBlockGoal {
        public AttackGrassBlockGoal(CreatureEntity creatureIn, double speed, int yMax) {
            super(Blocks.GRASS_BLOCK, creatureIn, speed, yMax);
        }

        public void playBreakingSound(IWorld worldIn, BlockPos pos) {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_STEP, SoundCategory.HOSTILE, 0.5F, 0.9F + ZurBreakBlockGoal.this.rand.nextFloat() * 0.2F);
        }

        public void playBrokenSound(World worldIn, BlockPos pos) {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
        }

        public double getTargetDistanceSq() {
            return 1.14D;
        }
    }
}
