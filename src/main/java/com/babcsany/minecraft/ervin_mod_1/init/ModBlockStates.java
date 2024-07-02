package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModBlockStates {
    private static final ModBlockStates STATES = getInstance();
    private final String name;
    private final BlockState state;
    public static final BlockState AIR = Blocks.AIR.getDefaultState();
    public static final BlockState STONE = Blocks.STONE.getDefaultState();
    public static final ModBlockStates BLACK_STONE = states("black_stone", BlockItemInit.BLACK_STONE);
    public static final ModBlockStates BLUE_STONE = states("blue_stone", BlockItemInit.BLUE_STONE);
    public static final ModBlockStates BROWN_STONE = states("brown_stone", BlockItemInit.BROWN_STONE);
    public static final ModBlockStates CYAN_STONE = states("cyan_stone", BlockItemInit.CYAN_STONE);
    public static final ModBlockStates GREEN_STONE = states("green_stone", BlockItemInit.GREEN_STONE);
    public static final ModBlockStates LIGHT_BLUE1_STONE = states("light_blue_stone", BlockItemInit.LIGHT_BLUE1_STONE);
    public static final ModBlockStates LIGHT_BLUE_STONE = states("light_blue_stone", BlockItemInit.LIGHT_BLUE_STONE);
    public static final ModBlockStates LIGHT_GRAY_STONE = states("light_gray_stone", BlockItemInit.LIGHT_GRAY_STONE);
    public static final ModBlockStates LIME_STONE = states("lime_stone", BlockItemInit.LIME_STONE);
    public static final ModBlockStates MAGENTA_STONE = states("magenta_stone", BlockItemInit.MAGENTA_STONE);
    public static final ModBlockStates ORANGE_STONE = states("orange_stone", BlockItemInit.ORANGE_STONE);
    public static final ModBlockStates PINK_STONE = states("pink_stone", BlockItemInit.PINK_STONE);
    public static final ModBlockStates PURPLE_STONE = states("purple_stone", BlockItemInit.PURPLE_STONE);
    public static final ModBlockStates RED_STONE = states("red_stone", BlockItemInit.RED_STONE);
    public static final ModBlockStates WHITE_STONE = states("white_stone", BlockItemInit.WHITE_STONE);
    public static final ModBlockStates YELLOW_STONE = states("yellow_stone", BlockItemInit.YELLOW_STONE);
    public static final ModBlockStates END_SRACKT = states("end_srackt", BlockItemInit.END_SRACKT);

    private ModBlockStates() {
        this.name = null;
        this.state = null;
    }

    private ModBlockStates(Block blockIn) {
        this(blockIn.getDefaultState());
    }

    private ModBlockStates(String name, Block blockIn) {
        this(name, blockIn.getDefaultState());
    }

    private ModBlockStates(BlockState stateIn) {
        this(null, stateIn);
    }

    private ModBlockStates(String nameIn, BlockState stateIn) {
        this.name = nameIn;
        this.state = stateIn;
    }

    private static ModBlockStates states(String name, Block blockIn) {
        return new ModBlockStates(name, blockIn);
    }

    private static ModBlockStates states(Block blockIn) {
        return new ModBlockStates(blockIn);
    }

    private static BlockState state(Block blockIn) {
        return blockIn.getDefaultState();
    }

    private static ModBlockStates getInstance() {
        return new ModBlockStates();
    }

    public static void register() {
        Blocks.cacheBlockStates();
        Ervin_mod_1.register(ModBlockStates.class);
    }

    public String getName() {
        return name;
    }

    public BlockState getState() {
        return state;
    }
}
