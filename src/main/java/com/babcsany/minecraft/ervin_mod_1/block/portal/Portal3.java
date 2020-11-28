package com.babcsany.minecraft.ervin_mod_1.block.portal;

import com.babcsany.minecraft.ervin_mod_1.block.ExamplePortalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class Portal3 {

    @Cancelable
    public static class ExamplePortalSpawnEvent extends BlockEvent
    {
        private final ExamplePortalBlock.Size size;

        public ExamplePortalSpawnEvent(IWorld world, BlockPos pos, BlockState state, ExamplePortalBlock.Size size)
        {
            super(world, pos, state);
            this.size = size;
        }

        public ExamplePortalBlock.Size getExamplePortalSize()
        {
            return size;
        }
    }
}
