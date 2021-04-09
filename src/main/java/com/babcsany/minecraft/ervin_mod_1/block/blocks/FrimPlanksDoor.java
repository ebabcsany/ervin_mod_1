package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrimPlanksDoor extends DoorBlock {
    public FrimPlanksDoor() {
        super(Properties.create(Material.WOOD, MaterialColor.WOOD)
                .hardnessAndResistance(3.0F)
                .sound(SoundType.WOOD)
                .variableOpacity()
                .notSolid()
        );
    }
}
