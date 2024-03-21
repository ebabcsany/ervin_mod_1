package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;

import java.util.function.Supplier;

public class FireBlock extends net.minecraft.block.FireBlock {
    private final Object2IntMap<Block> encouragements = new Object2IntOpenHashMap<>();
    private final Object2IntMap<Block> flammabilities = new Object2IntOpenHashMap<>();

    public FireBlock(Properties builder) {
        super(builder);
    }

    @Deprecated //Forge: Use IForgeBlockState.getFlammability, Public for default implementation only.
    public int getFlammability(BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED) ? 0 : this.flammabilities.getInt(state.getBlock());
    }

    @Deprecated //Forge: Use IForgeBlockState.getFireSpreadSpeed
    public int getFireSpreadSpeed(BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED) ? 0 : this.encouragements.getInt(state.getBlock());
    }

    private void setFireInfo(Supplier<Block> blockSupplierIn, int encouragement, int flammability) {
        setFireInfo(blockSupplierIn.get(), encouragement, flammability);
    }

    private void setFireInfo(Block blockIn, int encouragement, int flammability) {
        if (blockIn == Blocks.AIR) throw new IllegalArgumentException("Tried to set air on fire... This is bad.");
        this.encouragements.put(blockIn, encouragement);
        this.flammabilities.put(blockIn, flammability);
    }

    public static void init() {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFireInfo(BlockItemInit.FIRG_PLANKS_SLAB, 5, 5);
        fireblock.setFireInfo(BlockItemInit.FIRG_LOG, 5, 5);
        fireblock.setFireInfo(BlockItemInit.FRIM_LOG, 5, 5);
        fireblock.setFireInfo(BlockItemInit.STRIPPED_FIRG_WOOD, 5, 5);
        fireblock.setFireInfo(BlockItemInit.STRIPPED_FRIM_WOOD, 5, 5);
        fireblock.setFireInfo(BlockItemInit.FIRG_WOOD, 5, 5);
        fireblock.setFireInfo(BlockItemInit.FRIM_WOOD, 5, 5);
        fireblock.setFireInfo(BlockItemInit.TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.ACACIA_TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.BIRCH_TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.DARK_OAK_TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.JUNGLE_TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.OAK_TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.SPRUCE_TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.FIRG_TURG, 4, 4);
        fireblock.setFireInfo(BlockItemInit.FRIM_TURG, 4, 4);
    }
}
