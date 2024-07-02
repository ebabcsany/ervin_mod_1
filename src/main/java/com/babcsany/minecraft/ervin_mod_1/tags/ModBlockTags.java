package com.babcsany.minecraft.ervin_mod_1.tags;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.tags.*;

public final class ModBlockTags {
    public static final ITag.INamedTag<Block> BASE_ORANGE_STONE_OVERWORLD = createTag("base_orange_stone_overworld");
    public static final ITag.INamedTag<Block> BASE_STONES_OVERWORLD = createTag("base_stones_overworld");
    public static final ITag.INamedTag<Block> BASE_TURGS_OVERWORLD = createTag("base_turgs_overworld");
    public static final ITag.INamedTag<Block> BASE_DIRTS_OVERWORLD = createTag("base_dirts_overworld");
    public static final ITag.INamedTag<Block> BASE_TERRACOTTA_VARIANTS_OVERWORLD = createTag("base_terracotta_variants_overworld");
    public static final ITag.INamedTag<Block> BASE_END_STONES = createTag("base_end_stones");
    public static final ITag.INamedTag<Block> BASE_END_STONE_VARIANTS = createTag("base_end_stone_variants");
    public static final ITag.INamedTag<Block> SCRAFTH_MUSHROOM_BLOCK = createTag("scrafth_mushroom_block");
    public static final ITag.INamedTag<Block> RESPAWN_BLOCKS = createTag("respawn_blocks");

    public static ITag.INamedTag<Block> createTag(String id) {
        return BlockTags.createOptional(Ervin_mod_1.getKey(id));
    }
}
