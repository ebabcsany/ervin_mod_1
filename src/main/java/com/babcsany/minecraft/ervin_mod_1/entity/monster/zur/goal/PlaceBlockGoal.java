package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class PlaceBlockGoal extends Goal {
    private final AbstractZurEntity zur;

    public PlaceBlockGoal(AbstractZurEntity zurIn) {
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
        World world = this.zur.world;
        int x = MathHelper.floor(this.zur.getPosX() - 1.0D + random.nextDouble() * 2.0D);
        int y = MathHelper.floor(this.zur.getPosY() + random.nextDouble() * 2.0D);
        int z = MathHelper.floor(this.zur.getPosZ() - 1.0D + random.nextDouble() * 2.0D);
        BlockPos pos = new BlockPos(x, y, z);
        BlockState state = world.getBlockState(pos);
        BlockPos belowPos = pos.down();
        BlockState belowState = world.getBlockState(belowPos);
        BlockState heldState = this.zur.getHeldBlockState();
        if (heldState != null) {
            heldState = Block.getValidBlockForPosition(heldState, this.zur.world, pos);
            if (this.func_220836_a(world, pos, heldState, state, belowState, belowPos) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(zur, net.minecraftforge.common.util.BlockSnapshot.create(world.getDimensionKey(), world, belowPos), net.minecraft.util.Direction.UP)) {
                world.setBlockState(pos, heldState, 3);
                this.zur.setHeldBlockState(null);
            }

        }
    }

    private boolean func_220836_a(World worldIn, BlockPos pos, BlockState heldState, BlockState state, BlockState belowState, BlockPos belowPos) {
        return state.isAir(worldIn, pos) && !belowState.isAir(worldIn, belowPos) && !belowState.matchesBlock(Blocks.BEDROCK) && belowState.hasOpaqueCollisionShape(worldIn, belowPos) && heldState.isValidPosition(worldIn, pos) && worldIn.getEntitiesWithinAABBExcludingEntity(this.zur, AxisAlignedBB.fromVector(Vector3d.copy(pos))).isEmpty();
    }
}
