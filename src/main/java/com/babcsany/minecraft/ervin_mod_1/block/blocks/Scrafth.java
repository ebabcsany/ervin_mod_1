package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.init.block.*;
import com.babcsany.minecraft.ervin_mod_1.state.*;
import net.minecraft.block.*;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class Scrafth extends Block {
    public Scrafth(Block.Properties properties) {
        super(properties);
    }
}
