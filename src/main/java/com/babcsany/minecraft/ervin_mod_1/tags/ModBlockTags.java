package com.babcsany.minecraft.ervin_mod_1.tags;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;

public final class ModBlockTags {
    public static final ITag.INamedTag<Block> BASE_ORANGE_STONE_OVERWORLD = makeWrapperTag("base_orange_stone_overworld");
    public static final ITag.INamedTag<Block> BASE_STONES_OVERWORLD = makeWrapperTag("base_stones_overworld");
    public static final ITag.INamedTag<Block> BASE_TURGS_OVERWORLD = makeWrapperTag("base_turgs_overworld");
    public static final ITag.INamedTag<Block> BASE_DIRTS_OVERWORLD = makeWrapperTag("base_dirts_overworld");
    public static final ITag.INamedTag<Block> BASE_TERRACOTTA_VARIANTS_OVERWORLD = makeWrapperTag("base_terracotta_variants_overworld");
    public static final ITag.INamedTag<Block> BASE_END_STONES = makeWrapperTag("base_end_stones");
    public static final ITag.INamedTag<Block> BASE_END_STONE_VARIANTS = makeWrapperTag("base_end_stone_variants");

    public static ITag.INamedTag<Block> makeWrapperTag(String path) {
        return BlockTags.makeWrapperTag(Ervin_mod_1.MOD_ID + path);
    }
}
