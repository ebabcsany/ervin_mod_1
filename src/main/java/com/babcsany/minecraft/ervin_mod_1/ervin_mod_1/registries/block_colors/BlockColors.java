package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.block_colors;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.world.ModFoliageColors;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.state.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class BlockColors {
    private final java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Block>, IBlockColor> colors = new java.util.HashMap<>();
    private final Map<Block, Set<Property<?>>> colorStates = Maps.newHashMap();

    public static BlockColors init() {
        BlockColors blockColors = new BlockColors();
        blockColors.register((BlockState, IBlockDisplayReader, BlockPos, i) -> ModFoliageColors.getFirg(), isBurnableBlockItemInit.FIRG_LEAVES);
        blockColors.register((BlockState, IBlockDisplayReader, BlockPos, i) -> ModFoliageColors.getFrim(), BlockItemInit.FRIM_LEAVES);
        return blockColors;
    }

    public int getColor(BlockState blockStateIn, @Nullable IBlockDisplayReader lightReaderIn, @Nullable BlockPos blockPosIn, int tintIndexIn) {
        IBlockColor iblockcolor = this.colors.get(blockStateIn.getBlock().delegate);
        return iblockcolor == null ? -1 : iblockcolor.getColor(blockStateIn, lightReaderIn, blockPosIn, tintIndexIn);
    }

    public void register(IBlockColor blockColor, Block... blocksIn) {
        for(Block block : blocksIn) {
            this.colors.put(block.delegate, blockColor);
        }

    }

    @SafeVarargs
    public final void register(IBlockColor blockColor, Supplier<Block>... blocksIn) {
        for(Supplier<Block> block : blocksIn) {
            this.colors.put(block.get().delegate, blockColor);
        }

    }

    private void addColorStates(Set<Property<?>> propertiesIn, Block... blocksIn) {
        for(Block block : blocksIn) {
            this.colorStates.put(block, propertiesIn);
        }

    }

    private void addColorState(Property<?> propertyIn, Block... blocksIn) {
        this.addColorStates(ImmutableSet.of(propertyIn), blocksIn);
    }

    public Set<Property<?>> getColorProperties(Block blockIn) {
        return this.colorStates.getOrDefault(blockIn, ImmutableSet.of());
    }
}
