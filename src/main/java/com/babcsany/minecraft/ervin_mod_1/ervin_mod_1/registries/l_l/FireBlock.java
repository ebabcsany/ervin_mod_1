package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.l_l;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.init.BlockInit;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;

public class FireBlock extends net.minecraft.block.FireBlock {
    public FireBlock(Properties builder) {
        super(builder);
    }

    private final Object2IntMap<Block> encouragements = new Object2IntOpenHashMap<>();
    private final Object2IntMap<Block> flammabilities = new Object2IntOpenHashMap<>();

    public int getFlammability(BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED) ? 0 : this.flammabilities.getInt(state.getBlock());
    }

    public int getFireSpreadSpeed(BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED) ? 0 : this.encouragements.getInt(state.getBlock());
    }

    private void setFireInfo(Block blockIn, int encouragement, int flammability) {
        if (blockIn == Blocks.AIR) throw new IllegalArgumentException("Tried to set air on fire... This is bad.");
        this.encouragements.put(blockIn, encouragement);
        this.flammabilities.put(blockIn, flammability);
    }

    public static void init() {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFireInfo(BlockInit.FIRG_PLANKS.get(), 5, 10);
        fireblock.setFireInfo(BlockItemInit.FRIM_PLANKS.get(), 2, 4);
        fireblock.setFireInfo(BlockInit.FIRG_PLANKS.get(), 5, 10);
        fireblock.setFireInfo(BlockItemInit.FRIM_PLANKS.get(), 2, 4);
    }
}
