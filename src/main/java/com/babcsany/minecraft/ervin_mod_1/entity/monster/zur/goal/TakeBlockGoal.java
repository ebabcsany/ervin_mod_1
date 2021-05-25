package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.tags.BlockTags1;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class TakeBlockGoal extends Goal {
    private final ZurEntity zur;

    public TakeBlockGoal(ZurEntity zurIn) {
        this.zur = zurIn;
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
        if (this.zur.getHeldBlockState() != null) {
            return false;
        } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.zur.world, this.zur)) {
            return false;
        } else {
            return this.zur.getRNG().nextInt(20) == 0;
        }
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        Random random = this.zur.getRNG();
        World world = this.zur.world;
        int i = MathHelper.floor(this.zur.getPosX() - 2.0D + random.nextDouble() * 4.0D);
        int j = MathHelper.floor(this.zur.getPosY() + random.nextDouble() * 3.0D);
        int k = MathHelper.floor(this.zur.getPosZ() - 2.0D + random.nextDouble() * 4.0D);
        BlockPos blockpos = new BlockPos(i, j, k);
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        Vector3d vector3d = new Vector3d((double)MathHelper.floor(this.zur.getPosX()) + 0.5D, (double)j + 0.5D, (double)MathHelper.floor(this.zur.getPosZ()) + 0.5D);
        Vector3d vector3d1 = new Vector3d((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D);
        BlockRayTraceResult blockraytraceresult = world.rayTraceBlocks(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, this.zur));
        boolean flag = blockraytraceresult.getPos().equals(blockpos);
        if (/*block.isIn(BlockTags1.ZUR_HOLDABLE) && */flag) {
            this.zur.setHeldBlockState(blockstate);
            world.removeBlock(blockpos, false);
        }

    }
}
