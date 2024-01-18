package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.carver.UnderwaterCaveWorldCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public class WorldCarverInit {

    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS,
            Ervin_mod_1.MOD_ID);

    //protected static final BlockState AIR = BlockInit.AIR.get().getDefaultState();
    protected Set<Block> carvableBlocks = ImmutableSet.of(Blocks.STONE, BlockItemInit.BLACK_STONE.get(), BlockItemInit.BLUE_STONE.get(), BlockItemInit.BROWN_STONE.get(), BlockItemInit.CYAN_STONE.get(), BlockItemInit.GREEN_STONE.get(), BlockItemInit.LIGHT_BLUE1_STONE.get(), BlockItemInit.LIGHT_BLUE_STONE.get(), BlockItemInit.LIGHT_GRAY_STONE.get(), BlockItemInit.LIME_STONE.get(), BlockItemInit.MAGENTA_STONE.get(), BlockItemInit.ORANGE_STONE.get(), BlockItemInit.PINK_STONE.get(), BlockItemInit.PURPLE_FURNACE.get(), BlockItemInit.RED_STONE.get(), BlockItemInit.WHITE_STONE.get(), BlockItemInit.YELLOW_STONE.get(), Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.GRASS_BLOCK, Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.MYCELIUM, Blocks.SNOW, Blocks.PACKED_ICE);
    public boolean isCarvable(BlockState p_222706_1_) {
        return this.carvableBlocks.contains(p_222706_1_.getBlock());
    }
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> CAVE = CARVERS.register("cave", () -> new CaveWorldCarver(ProbabilityConfig.field_236576_b_, 256));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> UNDERWATER_CAVE = CARVERS.register("underwater_cave", () -> new UnderwaterCaveWorldCarver(ProbabilityConfig.field_236576_b_));
    //public static final RegistryObject<WorldCarver<ProbabilityConfig>> UNDERLAVA_CAVE = CARVERS.register("underlava_cave", () -> new UnderlavaCaveWorldCarver(ProbabilityConfig.field_236576_b_));
}
