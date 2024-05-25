package com.babcsany.minecraft.ervin_mod_1.init;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModBlockStates {
    private static final ModBlockStates STATES = register();
    private final BlockState state;
    public static final BlockState AIR = Blocks.AIR.getDefaultState();
    public static final BlockState STONE = Blocks.STONE.getDefaultState();
    public static final BlockState BLACK_STONE = BlockItemInit.BLACK_STONE.getDefaultState();
    public static final BlockState BLUE_STONE = BlockItemInit.BLUE_STONE.getDefaultState();
    public static final BlockState BROWN_STONE = BlockItemInit.BROWN_STONE.getDefaultState();
    public static final BlockState CYAN_STONE = BlockItemInit.CYAN_STONE.getDefaultState();
    public static final BlockState GREEN_STONE = BlockItemInit.GREEN_STONE.getDefaultState();
    public static final BlockState LIGHT_BLUE1_STONE = BlockItemInit.LIGHT_BLUE1_STONE.getDefaultState();
    public static final BlockState LIGHT_BLUE_STONE = BlockItemInit.LIGHT_BLUE_STONE.getDefaultState();
    public static final BlockState LIGHT_GRAY_STONE = BlockItemInit.LIGHT_GRAY_STONE.getDefaultState();
    public static final BlockState LIME_STONE = BlockItemInit.LIME_STONE.getDefaultState();
    public static final BlockState MAGENTA_STONE = BlockItemInit.MAGENTA_STONE.getDefaultState();
    public static final BlockState ORANGE_STONE = BlockItemInit.ORANGE_STONE.getDefaultState();
    public static final BlockState PINK_STONE = BlockItemInit.PINK_STONE.getDefaultState();
    public static final BlockState PURPLE_STONE = BlockItemInit.PURPLE_STONE.getDefaultState();
    public static final BlockState RED_STONE = BlockItemInit.RED_STONE.getDefaultState();
    public static final BlockState WHITE_STONE = BlockItemInit.WHITE_STONE.getDefaultState();
    public static final BlockState YELLOW_STONE = BlockItemInit.YELLOW_STONE.getDefaultState();
    public static final BlockState END_SRACKT = AIR;

    private ModBlockStates() {
        this.state = null;
    }

    private ModBlockStates(BlockState state) {
        this.state = state;
    }

    private static ModBlockStates register() {
        return new ModBlockStates();
    }
}
