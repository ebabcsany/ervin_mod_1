package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.entity.player.PlayerEntity1;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ModBlock extends Block {
    public ModBlock(Properties properties) {
        super(properties);
    }

    @Deprecated
    ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity1 player, Hand handIn, BlockRayTraceResult hit) {
        return ActionResultType.PASS;
    }
}
