package com.babcsany.minecraft.forge.event.world;

import com.babcsany.minecraft.ervin_mod_1.block.ExampleNetherPortalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.eventbus.api.Cancelable;

public class BlockEvent extends net.minecraftforge.event.world.BlockEvent {
    public BlockEvent(IWorld world, BlockPos pos, BlockState state) {
        super(world, pos, state);
    }

    /* Fired when an attempt is made to spawn a nether portal from
     * {@link net.minecraft.block.BlockPortal#trySpawnPortal(World, BlockPos)}.
     *
     * If cancelled, the portal will not be spawned.
     */
    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent
    {
        private final ExampleNetherPortalBlock.Size size;

        public PortalSpawnEvent(IWorld world, BlockPos pos, BlockState state, ExampleNetherPortalBlock.Size size)
        {
            super(world, pos, state);
            this.size = size;
        }

        public ExampleNetherPortalBlock.Size getPortalSize()
        {
            return size;
        }
    }
}
