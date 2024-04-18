package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ModOreBlock extends Block {
    private final int experience;

    public ModOreBlock(int experienceIn, Block.Properties propertiesIn) {
        super(propertiesIn);
        this.experience = experienceIn;
    }

    public ModOreBlock(int minExperienceIn, int maxExperienceIn, Block.Properties propertiesIn) {
        super(propertiesIn);
        this.experience = MathHelper.nextInt(new Random(), minExperienceIn, maxExperienceIn);
    }

    /**
     * Perform side-effects from block dropping, such as creating silverfish
     */
    public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.experience : 0;
    }
}
