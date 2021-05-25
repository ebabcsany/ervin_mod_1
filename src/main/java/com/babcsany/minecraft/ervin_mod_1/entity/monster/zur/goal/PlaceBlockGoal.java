package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

import java.util.Random;

public class PlaceBlockGoal extends Goal {
    private final ZurEntity zur;

    public PlaceBlockGoal(ZurEntity zurIn) {
        this.zur = zurIn;
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
        if (this.zur.getHeldBlockState() == null) {
            return false;
        } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.zur.world, this.zur)) {
            return false;
        } else {
            return this.zur.getRNG().nextInt(2000) == 0;
        }
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        Random random = this.zur.getRNG();
        IWorld iworld = this.zur.world;
        int i = MathHelper.floor(this.zur.getPosX() - 1.0D + random.nextDouble() * 2.0D);
        int j = MathHelper.floor(this.zur.getPosY() + random.nextDouble() * 2.0D);
        int k = MathHelper.floor(this.zur.getPosZ() - 1.0D + random.nextDouble() * 2.0D);
        BlockPos blockpos = new BlockPos(i, j, k);
        BlockState blockstate = iworld.getBlockState(blockpos);
        BlockPos blockpos1 = blockpos.down();
        BlockState blockstate1 = iworld.getBlockState(blockpos1);
        BlockState blockstate2 = this.zur.getHeldBlockState();
        if (blockstate2 != null && this.func_220836_a(iworld, blockpos, blockstate2, blockstate, blockstate1, blockpos1)  && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(zur, net.minecraftforge.common.util.BlockSnapshot.create(iworld, blockpos1), net.minecraft.util.Direction.UP)) {
            iworld.setBlockState(blockpos, blockstate2, 3);
            this.zur.setHeldBlockState(null);
        }

    }

    private boolean func_220836_a(IWorldReader p_220836_1_, BlockPos p_220836_2_, BlockState p_220836_3_, BlockState p_220836_4_, BlockState p_220836_5_, BlockPos p_220836_6_) {
        return p_220836_4_.isAir(p_220836_1_, p_220836_2_) && !p_220836_5_.isAir(p_220836_1_, p_220836_6_) && p_220836_5_.hasOpaqueCollisionShape(p_220836_1_, p_220836_6_) && p_220836_3_.isValidPosition(p_220836_1_, p_220836_2_);
    }
}
