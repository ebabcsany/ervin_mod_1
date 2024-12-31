package com.babcsany.minecraft.ervin_mod_1.item.block;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.util.math.ModBlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;

public class Grith_Block extends BlockItem {
    public static final Block GRITH_BLOCK = BlockInit.GRITH_BLOCK.get();
    public static final Block GRITH_SLAB = BlockInit.GRITH_SLAB.get();
    public static final Block GRITH_STAIRS = BlockInit.GRITH_STAIRS.get();

    public Grith_Block(Block blockIn, Item.Properties properties) {
        super(blockIn, properties);
    }

    static ItemEntity entity;

    /**
     * Returns the unlocalized name of this item.
     */
    public String getTranslationKey() {
        return this.getDefaultTranslationKey();
    }

    @Override
    public Item asItem() {
        return super.asItem();
    }

    public void onEntityItemUpdateDown(ItemStack stack, ItemEntity entity) {
        onEntityItemUpdateDown_GrithBlock(stack, entity);
        onEntityItemUpdateDown_GrithSlab(stack, entity);
        onEntityItemUpdateDown_GrithStairs(stack, entity);
    }

    public void onEntityItemUpdateDown_GrithBlock(ItemStack stack, ItemEntity entity) {
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(4), Blocks.AIR.getDefaultState()); }
    }

    public void onEntityItemUpdateDown_GrithSlab(ItemStack stack, ItemEntity entity) {
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(4), Blocks.AIR.getDefaultState()); }
    }

    public void onEntityItemUpdateDown_GrithStairs(ItemStack stack, ItemEntity entity) {
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(2).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(3).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().down(4).south(4).east(4), Blocks.AIR.getDefaultState()); }
    }

    public void onEntityItemUpdateUp(ItemStack stack, ItemEntity entity) {
        onEntityItemUpdateUp_GrithBlock(stack, entity);
        onEntityItemUpdateUp_GrithSlab(stack, entity);
        onEntityItemUpdateUp_GrithStairs(stack, entity);
    }

    public void onEntityItemUpdateUp_GrithBlock(ItemStack stack, ItemEntity entity) {
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(4), Blocks.AIR.getDefaultState()); }
    }

    public void onEntityItemUpdateUp_GrithSlab(ItemStack stack, ItemEntity entity) {
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(4), Blocks.AIR.getDefaultState()); }
    }

    public void onEntityItemUpdateUp_GrithStairs(ItemStack stack, ItemEntity entity) {
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(2).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(3).south(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(1).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(2).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(3).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).east(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(1).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(2).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(3).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).west(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(1).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(2).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(3).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).north(4).west(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(1).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(2).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(3).east(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(1), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(2), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(3), Blocks.AIR.getDefaultState()); }
        if (!entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().up(4).south(4).east(4), Blocks.AIR.getDefaultState()); }
    }

    public void onEntityItemUpdateSide(ItemStack stack, ItemEntity entity) {
        onEntityItemUpdateSide_GrithBlock(stack, entity);
        onEntityItemUpdateSide_GrithSlab(stack, entity);
        onEntityItemUpdateSide_GrithStairs(stack, entity);
    }

    public void onEntityItemUpdateSide_GrithBlock(ItemStack stack, ItemEntity entity) {
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(1), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(2), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(3), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(4), GRITH_BLOCK.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(4), Blocks.AIR.getDefaultState()); return; }

        super.onEntityItemUpdate(stack, entity);
    }

    public void onEntityItemUpdateSide_GrithSlab(ItemStack stack, ItemEntity entity) {
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(1), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(2), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(3), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(4), GRITH_SLAB.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(4), Blocks.AIR.getDefaultState()); return; }

        super.onEntityItemUpdate(stack, entity);
    }

    public void onEntityItemUpdateSide_GrithStairs(ItemStack stack, ItemEntity entity) {
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(1).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(2).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(3).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().east(4).north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(1).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(2).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(3).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().west(4).south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(1).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(2).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(3).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().north(4).west(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(1).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(2).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(3).east(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(1), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(1), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(2), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(2), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(3), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(3), Blocks.AIR.getDefaultState()); return; }
        if (entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(4), GRITH_STAIRS.getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition().south(4).east(4), Blocks.AIR.getDefaultState()); return; }
        if (setPos(entity, 0, 0, 0, 4, 0, 4, GRITH_STAIRS.getDefaultState())) {
            setPos(entity, 0, 0, 0, 4, 0, 4, Blocks.AIR.getDefaultState());
            return;
        }

        super.onEntityItemUpdate(stack, entity);
    }

    public static boolean setUpNorthWest(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setNorthWest(entity, pos.up(up), state);
    }

    public static boolean setUpNorthEast(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setNorthEast(entity, pos.up(up), state);
    }

    public static boolean setUpSouthWest(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setSouthWest(entity, pos.up(up), state);
    }

    public static boolean setUpSouthEast(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setSouthEast(entity, pos.up(up), state);
    }

    public static boolean setUpWestNorth(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setWestNorth(entity, pos.up(up), state);
    }

    public static boolean setUpEastNorth(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setEastNorth(entity, pos.up(up), state);
    }

    public static boolean setUpWestSouth(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setWestSouth(entity, pos.up(up), state);
    }

    public static boolean setUpEastSouth(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setEastSouth(entity, pos.up(up), state);
    }

    public static boolean setNorthUpWest(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setSouthWest(entity, pos.north(north), state);
    }

    public static boolean setNorthUpEast(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setNorthEast(entity, pos.north(north), state);
    }

    public static boolean setSouthUpWest(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setSouthWest(entity, pos.south(south), state);
    }

    public static boolean setSouthUpEast(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setSouthEast(entity, pos.south(south), state);
    }

    public static boolean setWestUpNorth(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setUpNorth(entity, pos.west(west), state);
    }

    public static boolean setEastUpNorth(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setUpNorth(entity, pos.east(east), state);
    }

    public static boolean setWestUpSouth(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setUpSouth(entity, pos.west(west), state);
    }

    public static boolean setEastUpSouth(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setUpSouth(entity, pos.east(east), state);
    }

    public static boolean setNorthWestUp(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setWestUp(entity, pos.north(north), state);
    }

    public static boolean setNorthEastUp(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setEastUp(entity, pos.north(north), state);
    }

    public static boolean setSouthWestUp(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setWestUp(entity, pos.south(south), state);
    }

    public static boolean setSouthEastUp(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setEastUp(entity, pos.south(south), state);
    }

    public static boolean setWestNorthUp(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setNorthUp(entity, pos.west(west), state);
    }

    public static boolean setEastNorthUp(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setNorthUp(entity, pos.east(east), state);
    }

    public static boolean setWestSouthUp(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setSouthUp(entity, pos.west(west), state);
    }

    public static boolean setEastSouthUp(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setSouthUp(entity, pos.east(east), state);
    }

    public static boolean setDownNorthWest(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setNorthWest(entity, pos.down(down), state);
    }

    public static boolean setDownNorthEast(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setNorthEast(entity, pos.down(down), state);
    }

    public static boolean setDownSouthWest(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setSouthWest(entity, pos.down(down), state);
    }

    public static boolean setDownSouthEast(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setSouthEast(entity, pos.down(down), state);
    }

    public static boolean setDownWestNorth(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setWestNorth(entity, pos.down(down), state);
    }

    public static boolean setDownEastNorth(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setEastNorth(entity, pos.down(down), state);
    }

    public static boolean setDownWestSouth(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setWestSouth(entity, pos.down(down), state);
    }

    public static boolean setDownEastSouth(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setEastSouth(entity, pos.down(down), state);
    }

    public static boolean setNorthDownWest(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setSouthWest(entity, pos.north(north), state);
    }

    public static boolean setNorthDownEast(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setNorthEast(entity, pos.north(north), state);
    }

    public static boolean setSouthDownWest(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setSouthWest(entity, pos.south(south), state);
    }

    public static boolean setSouthDownEast(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setSouthEast(entity, pos.south(south), state);
    }

    public static boolean setWestDownNorth(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setDownNorth(entity, pos.west(west), state);
    }

    public static boolean setEastDownNorth(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setDownNorth(entity, pos.east(east), state);
    }

    public static boolean setWestDownSouth(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setDownSouth(entity, pos.west(west), state);
    }

    public static boolean setEastDownSouth(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setDownSouth(entity, pos.east(east), state);
    }

    public static boolean setNorthWestDown(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setWestDown(entity, pos.north(north), state);
    }

    public static boolean setNorthEastDown(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setEastDown(entity, pos.north(north), state);
    }

    public static boolean setSouthWestDown(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setWestDown(entity, pos.south(south), state);
    }

    public static boolean setSouthEastDown(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setEastDown(entity, pos.south(south), state);
    }

    public static boolean setWestNorthDown(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setNorthDown(entity, pos.west(west), state);
    }

    public static boolean setEastNorthDown(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setNorthDown(entity, pos.east(east), state);
    }

    public static boolean setWestSouthDown(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setSouthDown(entity, pos.west(west), state);
    }

    public static boolean setEastSouthDown(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setSouthDown(entity, pos.east(east), state);
    }

    public static boolean setUpNorth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setNorth(entity, pos.up(), state);
    }

    public static boolean setUpSouth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setSouth(entity, pos.up(), state);
    }

    public static boolean setUpWest(ItemEntity entity, BlockPos pos, BlockState state) {
        return setWest(entity, pos.up(), state);
    }

    public static boolean setUpEast(ItemEntity entity, BlockPos pos, BlockState state) {
        return setEast(entity, pos.up(), state);
    }

    public static boolean setNorthUp(ItemEntity entity, BlockPos pos, BlockState state) {
        return setNorth(entity, pos.north(), state);
    }

    public static boolean setSouthUp(ItemEntity entity, BlockPos pos, BlockState state) {
        return setSouth(entity, pos.south(), state);
    }

    public static boolean setWestUp(ItemEntity entity, BlockPos pos, BlockState state) {
        return setWest(entity, pos.west(), state);
    }

    public static boolean setEastUp(ItemEntity entity, BlockPos pos, BlockState state) {
        return setEast(entity, pos.east(), state);
    }

    public static boolean setDownNorth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setNorth(entity, pos.down(), state);
    }

    public static boolean setDownSouth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setSouth(entity, pos.down(), state);
    }

    public static boolean setDownWest(ItemEntity entity, BlockPos pos, BlockState state) {
        return setWest(entity, pos.down(), state);
    }

    public static boolean setDownEast(ItemEntity entity, BlockPos pos, BlockState state) {
        return setEast(entity, pos.down(), state);
    }

    public static boolean setNorthDown(ItemEntity entity, BlockPos pos, BlockState state) {
        return setDown(entity, pos.north(), state);
    }

    public static boolean setSouthDown(ItemEntity entity, BlockPos pos, BlockState state) {
        return setDown(entity, pos.south(), state);
    }

    public static boolean setWestDown(ItemEntity entity, BlockPos pos, BlockState state) {
        return setDown(entity, pos.west(), state);
    }

    public static boolean setEastDown(ItemEntity entity, BlockPos pos, BlockState state) {
        return setDown(entity, pos.east(), state);
    }

    public static boolean setNorthWest(ItemEntity entity, BlockPos pos, BlockState state) {
        return setWest(entity, pos.north(), state);
    }

    public static boolean setNorthEast(ItemEntity entity, BlockPos pos, BlockState state) {
        return setEast(entity, pos.north(), state);
    }

    public static boolean setSouthWest(ItemEntity entity, BlockPos pos, BlockState state) {
        return setWest(entity, pos.south(), state);
    }

    public static boolean setSouthEast(ItemEntity entity, BlockPos pos, BlockState state) {
        return setEast(entity, pos.south(), state);
    }

    public static boolean setWestNorth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setNorth(entity, pos.west(), state);
    }

    public static boolean setWestSouth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setSouth(entity, pos.west(), state);
    }

    public static boolean setEastNorth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setNorth(entity, pos.east(), state);
    }

    public static boolean setEastSouth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setSouth(entity, pos.east(), state);
    }

    public static boolean setUpNorthWest(ItemEntity entity, BlockPos pos, int up, int north, BlockState state) {
        return setNorthWest(entity, pos.up(up), north, state);
    }

    public static boolean setUpNorthEast(ItemEntity entity, BlockPos pos, int up, int north, BlockState state) {
        return setNorthEast(entity, pos.up(up), north, state);
    }

    public static boolean setUpSouthWest(ItemEntity entity, BlockPos pos, int up, int south, BlockState state) {
        return setSouthWest(entity, pos.up(up), south, state);
    }

    public static boolean setUpSouthEast(ItemEntity entity, BlockPos pos, int up, int south, BlockState state) {
        return setSouthEast(entity, pos.up(up), south, state);
    }

    public static boolean setUpWestNorth(ItemEntity entity, BlockPos pos, int up, int west, BlockState state) {
        return setWestNorth(entity, pos.up(up), west, state);
    }

    public static boolean setUpEastNorth(ItemEntity entity, BlockPos pos, int up, int east, BlockState state) {
        return setEastNorth(entity, pos.up(up), east, state);
    }

    public static boolean setUpWestSouth(ItemEntity entity, BlockPos pos, int up, int west, BlockState state) {
        return setWestSouth(entity, pos.up(up), west, state);
    }

    public static boolean setUpEastSouth(ItemEntity entity, BlockPos pos, int up, int east, BlockState state) {
        return setEastSouth(entity, pos.up(up), east, state);
    }

    public static boolean setNorthUpWest(ItemEntity entity, BlockPos pos, int north, int up, BlockState state) {
        return setSouthWest(entity, pos.north(north), up, state);
    }

    public static boolean setNorthUpEast(ItemEntity entity, BlockPos pos, int north, int up, BlockState state) {
        return setNorthEast(entity, pos.north(north), up, state);
    }

    public static boolean setSouthUpWest(ItemEntity entity, BlockPos pos, int south, int up, BlockState state) {
        return setSouthWest(entity, pos.south(south), up, state);
    }

    public static boolean setSouthUpEast(ItemEntity entity, BlockPos pos, int south, int up, BlockState state) {
        return setSouthEast(entity, pos.south(south), up, state);
    }

    public static boolean setWestUpNorth(ItemEntity entity, BlockPos pos, int west, int up, BlockState state) {
        return setUpNorth(entity, pos.west(west), up, state);
    }

    public static boolean setEastUpNorth(ItemEntity entity, BlockPos pos, int east, int up, BlockState state) {
        return setUpNorth(entity, pos.east(east), up, state);
    }

    public static boolean setWestUpSouth(ItemEntity entity, BlockPos pos, int west, int up, BlockState state) {
        return setUpSouth(entity, pos.west(west), up, state);
    }

    public static boolean setEastUpSouth(ItemEntity entity, BlockPos pos, int east, int up, BlockState state) {
        return setUpSouth(entity, pos.east(east), up, state);
    }

    public static boolean setNorthWestUp(ItemEntity entity, BlockPos pos, int north, int west, BlockState state) {
        return setWestUp(entity, pos.north(north), west, state);
    }

    public static boolean setNorthEastUp(ItemEntity entity, BlockPos pos, int north, int east, BlockState state) {
        return setEastUp(entity, pos.north(north), east, state);
    }

    public static boolean setSouthWestUp(ItemEntity entity, BlockPos pos, int south, int west, BlockState state) {
        return setWestUp(entity, pos.south(south), west, state);
    }

    public static boolean setSouthEastUp(ItemEntity entity, BlockPos pos, int south, int east, BlockState state) {
        return setEastUp(entity, pos.south(south), east, state);
    }

    public static boolean setWestNorthUp(ItemEntity entity, BlockPos pos, int west, int north, BlockState state) {
        return setNorthUp(entity, pos.west(west), north, state);
    }

    public static boolean setEastNorthUp(ItemEntity entity, BlockPos pos, int east, int north, BlockState state) {
        return setNorthUp(entity, pos.east(east), north, state);
    }

    public static boolean setWestSouthUp(ItemEntity entity, BlockPos pos, int west, int south, BlockState state) {
        return setSouthUp(entity, pos.west(west), south, state);
    }

    public static boolean setEastSouthUp(ItemEntity entity, BlockPos pos, int east, int south, BlockState state) {
        return setSouthUp(entity, pos.east(east), south, state);
    }

    public static boolean setDownNorthWest(ItemEntity entity, BlockPos pos, int down, int north, BlockState state) {
        return setNorthWest(entity, pos.down(down), north, state);
    }

    public static boolean setDownNorthEast(ItemEntity entity, BlockPos pos, int down, int north, BlockState state) {
        return setNorthEast(entity, pos.down(down), north, state);
    }

    public static boolean setDownSouthWest(ItemEntity entity, BlockPos pos, int down, int south, BlockState state) {
        return setSouthWest(entity, pos.down(down), south, state);
    }

    public static boolean setDownSouthEast(ItemEntity entity, BlockPos pos, int down, int south, BlockState state) {
        return setSouthEast(entity, pos.down(down), south, state);
    }

    public static boolean setDownWestNorth(ItemEntity entity, BlockPos pos, int down, int west, BlockState state) {
        return setWestNorth(entity, pos.down(down), west, state);
    }

    public static boolean setDownEastNorth(ItemEntity entity, BlockPos pos, int down, int east, BlockState state) {
        return setEastNorth(entity, pos.down(down), east, state);
    }

    public static boolean setDownWestSouth(ItemEntity entity, BlockPos pos, int down, int west, BlockState state) {
        return setWestSouth(entity, pos.down(down), west, state);
    }

    public static boolean setDownEastSouth(ItemEntity entity, BlockPos pos, int down, int east, BlockState state) {
        return setEastSouth(entity, pos.down(down), east, state);
    }

    public static boolean setNorthDownWest(ItemEntity entity, BlockPos pos, int north, int down, BlockState state) {
        return setSouthWest(entity, pos.north(north), down, state);
    }

    public static boolean setNorthDownEast(ItemEntity entity, BlockPos pos, int north, int down, BlockState state) {
        return setNorthEast(entity, pos.north(north), down, state);
    }

    public static boolean setSouthDownWest(ItemEntity entity, BlockPos pos, int south, int down, BlockState state) {
        return setSouthWest(entity, pos.south(south), down, state);
    }

    public static boolean setSouthDownEast(ItemEntity entity, BlockPos pos, int south, int down, BlockState state) {
        return setSouthEast(entity, pos.south(south), down, state);
    }

    public static boolean setWestDownNorth(ItemEntity entity, BlockPos pos, int west, int down, BlockState state) {
        return setDownNorth(entity, pos.west(west), down, state);
    }

    public static boolean setEastDownNorth(ItemEntity entity, BlockPos pos, int east, int down, BlockState state) {
        return setDownNorth(entity, pos.east(east), down, state);
    }

    public static boolean setWestDownSouth(ItemEntity entity, BlockPos pos, int west, int down, BlockState state) {
        return setDownSouth(entity, pos.west(west), down, state);
    }

    public static boolean setEastDownSouth(ItemEntity entity, BlockPos pos, int east, int down, BlockState state) {
        return setDownSouth(entity, pos.east(east), down, state);
    }

    public static boolean setNorthWestDown(ItemEntity entity, BlockPos pos, int north, int west, BlockState state) {
        return setWestDown(entity, pos.north(north), west, state);
    }

    public static boolean setNorthEastDown(ItemEntity entity, BlockPos pos, int north, int east, BlockState state) {
        return setEastDown(entity, pos.north(north), east, state);
    }

    public static boolean setSouthWestDown(ItemEntity entity, BlockPos pos, int south, int west, BlockState state) {
        return setWestDown(entity, pos.south(south), west, state);
    }

    public static boolean setSouthEastDown(ItemEntity entity, BlockPos pos, int south, int east, BlockState state) {
        return setEastDown(entity, pos.south(south), east, state);
    }

    public static boolean setWestNorthDown(ItemEntity entity, BlockPos pos, int west, int north, BlockState state) {
        return setNorthDown(entity, pos.west(west), north, state);
    }

    public static boolean setEastNorthDown(ItemEntity entity, BlockPos pos, int east, int north, BlockState state) {
        return setNorthDown(entity, pos.east(east), north, state);
    }

    public static boolean setWestSouthDown(ItemEntity entity, BlockPos pos, int west, int south, BlockState state) {
        return setSouthDown(entity, pos.west(west), south, state);
    }

    public static boolean setEastSouthDown(ItemEntity entity, BlockPos pos, int east, int south, BlockState state) {
        return setSouthDown(entity, pos.east(east), south, state);
    }

    public static boolean setUpNorth(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setNorth(entity, pos.up(up), state);
    }

    public static boolean setUpSouth(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setSouth(entity, pos.up(up), state);
    }

    public static boolean setUpWest(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setWest(entity, pos.up(up), state);
    }

    public static boolean setUpEast(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setEast(entity, pos.up(up), state);
    }

    public static boolean setNorthUp(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setNorth(entity, pos.north(north), state);
    }

    public static boolean setSouthUp(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setSouth(entity, pos.south(south), state);
    }

    public static boolean setWestUp(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setWest(entity, pos.west(west), state);
    }

    public static boolean setEastUp(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setEast(entity, pos.east(east), state);
    }

    public static boolean setDownNorth(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setNorth(entity, pos.down(down), state);
    }

    public static boolean setDownSouth(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setSouth(entity, pos.down(down), state);
    }

    public static boolean setDownWest(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setWest(entity, pos.down(down), state);
    }

    public static boolean setDownEast(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setEast(entity, pos.down(down), state);
    }

    public static boolean setNorthDown(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setDown(entity, pos.north(north), state);
    }

    public static boolean setSouthDown(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setDown(entity, pos.south(south), state);
    }

    public static boolean setWestDown(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setDown(entity, pos.west(west), state);
    }

    public static boolean setEastDown(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setDown(entity, pos.east(east), state);
    }

    public static boolean setNorthWest(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setWest(entity, pos.north(north), state);
    }

    public static boolean setNorthEast(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setEast(entity, pos.north(north), state);
    }

    public static boolean setSouthWest(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setWest(entity, pos.south(south), state);
    }

    public static boolean setSouthEast(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setEast(entity, pos.south(south), state);
    }

    public static boolean setWestNorth(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setNorth(entity, pos.west(west), state);
    }

    public static boolean setWestSouth(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setSouth(entity, pos.west(west), state);
    }

    public static boolean setEastNorth(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setNorth(entity, pos.east(east), state);
    }

    public static boolean setEastSouth(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setSouth(entity, pos.east(east), state);
    }

    public static boolean setUp(ItemEntity entity, BlockPos pos, BlockState state) {
        return setPos(entity, pos.up(), state);
    }

    public static boolean setDown(ItemEntity entity, BlockPos pos, BlockState state) {
        return setPos(entity, pos.down(), state);
    }

    public static boolean setNorth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setPos(entity, pos.north(), state);
    }

    public static boolean setSouth(ItemEntity entity, BlockPos pos, BlockState state) {
        return setPos(entity, pos.south(), state);
    }

    public static boolean setWest(ItemEntity entity, BlockPos pos, BlockState state) {
        return setPos(entity, pos.west(), state);
    }

    public static boolean setEast(ItemEntity entity, BlockPos pos, BlockState state) {
        return setPos(entity, pos.east(), state);
    }

    public static boolean setUpNorthWest(ItemEntity entity, BlockPos pos, int up, int north, int west, BlockState state) {
        return setNorthWest(entity, pos.up(up), north, west, state);
    }

    public static boolean setUpNorthEast(ItemEntity entity, BlockPos pos, int up, int north, int east, BlockState state) {
        return setNorthEast(entity, pos.up(up), north, east, state);
    }

    public static boolean setUpSouthWest(ItemEntity entity, BlockPos pos, int up, int south, int west, BlockState state) {
        return setSouthWest(entity, pos.up(up), south, west, state);
    }

    public static boolean setUpSouthEast(ItemEntity entity, BlockPos pos, int up, int south, int east, BlockState state) {
        return setSouthEast(entity, pos.up(up), south, east, state);
    }

    public static boolean setDownNorthWest(ItemEntity entity, BlockPos pos, int down, int north, int west, BlockState state) {
        return setNorthWest(entity, pos.down(down), north, west, state);
    }

    public static boolean setDownNorthEast(ItemEntity entity, BlockPos pos, int down, int north, int east, BlockState state) {
        return setNorthEast(entity, pos.down(down), north, east, state);
    }

    public static boolean setDownSouthWest(ItemEntity entity, BlockPos pos, int down, int south, int west, BlockState state) {
        return setSouthWest(entity, pos.down(down), south, west, state);
    }

    public static boolean setDownSouthEast(ItemEntity entity, BlockPos pos, int down, int south, int east, BlockState state) {
        return setSouthEast(entity, pos.down(down), south, east, state);
    }

    public static boolean setUpNorth(ItemEntity entity, BlockPos pos, int up, int north, BlockState state) {
        return setNorth(entity, pos.up(up), north, state);
    }

    public static boolean setUpSouth(ItemEntity entity, BlockPos pos, int up, int south, BlockState state) {
        return setSouth(entity, pos.up(up), south, state);
    }

    public static boolean setUpWest(ItemEntity entity, BlockPos pos, int up, int west, BlockState state) {
        return setWest(entity, pos.up(up), west, state);
    }

    public static boolean setUpEast(ItemEntity entity, BlockPos pos, int up, int east, BlockState state) {
        return setEast(entity, pos.up(up), east, state);
    }

    public static boolean setDownNorth(ItemEntity entity, BlockPos pos, int down, int north, BlockState state) {
        return setNorth(entity, pos.down(down), north, state);
    }

    public static boolean setDownSouth(ItemEntity entity, BlockPos pos, int down, int south, BlockState state) {
        return setSouth(entity, pos.down(down), south, state);
    }

    public static boolean setDownWest(ItemEntity entity, BlockPos pos, int down, int west, BlockState state) {
        return setWest(entity, pos.down(down), west, state);
    }

    public static boolean setDownEast(ItemEntity entity, BlockPos pos, int down, int east, BlockState state) {
        return setEast(entity, pos.down(down), east, state);
    }

    public static boolean setNorthWest(ItemEntity entity, BlockPos pos, int north, int west, BlockState state) {
        return setWest(entity, pos.north(north), west, state);
    }

    public static boolean setNorthEast(ItemEntity entity, BlockPos pos, int north, int east, BlockState state) {
        return setEast(entity, pos.north(north), east, state);
    }

    public static boolean setSouthWest(ItemEntity entity, BlockPos pos, int south, int west, BlockState state) {
        return setWest(entity, pos.south(south), west, state);
    }

    public static boolean setSouthEast(ItemEntity entity, BlockPos pos, int south, int east, BlockState state) {
        return setEast(entity, pos.south(south), east, state);
    }

    public static boolean setUp(ItemEntity entity, BlockPos pos, int up, BlockState state) {
        return setPos(entity, pos.up(up), state);
    }

    public static boolean setDown(ItemEntity entity, BlockPos pos, int down, BlockState state) {
        return setPos(entity, pos.down(down), state);
    }

    public static boolean setNorth(ItemEntity entity, BlockPos pos, int north, BlockState state) {
        return setPos(entity, pos.north(north), state);
    }

    public static boolean setSouth(ItemEntity entity, BlockPos pos, int south, BlockState state) {
        return setPos(entity, pos.south(south), state);
    }

    public static boolean setWest(ItemEntity entity, BlockPos pos, int west, BlockState state) {
        return setPos(entity, pos.west(west), state);
    }

    public static boolean setEast(ItemEntity entity, BlockPos pos, int east, BlockState state) {
        return setPos(entity, pos.east(east), state);
    }

    public static void setFromPos(Entity entity, int up, int down, int north, int south, int west, int east, BlockState fromState, BlockState toState) {
//        if (fromState.matchesBlock(Block.replaceBlock();).isValidPosition(entity.world, getPos(entity, up, down, north, south, west, east))) {
            setPos(entity, up, down, north, south, west, east, toState);
//        }
    }

    public static boolean setPos(Entity entity, int up, int down, int north, int south, int west, int east, BlockState state) {
        return ModBlockPos.setWorldPos(entity, up, down, north, south, west, east, state);
    }

    public static BlockPos getPos(Entity entity, int up, int down, int north, int south, int west, int east) {
        return ModBlockPos.getEntityPos(entity, up, down, north, south, west, east);
    }

    public static boolean setPos(ItemEntity entity, BlockPos pos, BlockState state) {
        return entity.getEntityWorld().setBlockState(pos, state);
    }
}
