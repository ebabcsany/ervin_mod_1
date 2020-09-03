package com.babcsany.minecraft.ervin_mod_1.block.portal;

import com.babcsany.minecraft.ervin_mod_1.block.ExamplePortalBlock;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;

public class Portal {

    public static boolean onTrySpawnExamplePortal(IWorld world, BlockPos pos, ExamplePortalBlock.Size size)
    {
        return MinecraftForge.EVENT_BUS.post(new Portal3.ExamplePortalSpawnEvent(world, pos, world.getBlockState(pos), size));
    }
}
