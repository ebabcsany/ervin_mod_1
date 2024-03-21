package com.babcsany.minecraft.ervin_mod_1.world.gen.feature;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialBlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder.ModBlockState.*;

public abstract class ModSurfaceBuilder<C extends ISurfaceBuilderConfig> extends SurfaceBuilder<C> {
    public static final SurfaceBuilderConfig RIFT_CONFIG = register(REDSTONE_BLOCK, MAGMA_BLOCK, RED_CONCRETE);
    public static final SurfaceBuilderConfig BHJUIG_CONFIG = register(AIR, STONE, CAVE_AIR);
    public static final SurfaceBuilderConfig MIG_CONFIG = register(WATER, GRASS, CARVED_PUMPKIN);
    public static final SurfaceBuilderConfig SRIUNK_VALLEY_CONFIG = register(MOD_END_PORTAL, MOD_NETHER_PORTAL, DURT);
    public static final SurfaceBuilderConfig EXAMPLE0_CONFIG = register(SRURG, EPKIH, DIRT);
    public static final SurfaceBuilderConfig COARSE_DIRT_DIRT_DIRT_CONFIG = register(COARSE_DIRT, DIRT, DIRT);
    public static final SurfaceBuilderConfig EXAMPLE_CONFIG1 = register(COARSE_DIRT, GRASS_BLOCK, DIRT);
    public static final SurfaceBuilderConfig EXAMPLE_CONFIG3 = register(BEDROCK, OBSIDIAN, CAVE_AIR);
    public static final SurfaceBuilderConfig EXAMPLE_CONFIG4 = register(GRASS_BLOCK, DIRT, COARSE_DIRT);
    public static final SurfaceBuilderConfig EXAMPLE_CONFIG6 = register(KALT_BLOCK, NIRTKB, NIRTK);
    public static final SurfaceBuilderConfig SCRAFTH_CONFIG = register(SCRAFTH, SCRAFTH, SCRAFTH);
    public static final SurfaceBuilderConfig FIRG_CONFIG = register(FIRG, FIRG, FIRG);
    public static final SurfaceBuilderConfig TWUST_CONFIG = register(GRASS_BLOCK, GTRZIUZHIZJKJ, SCRAFTH);

    public ModSurfaceBuilder(Codec<C> codec) {
        super(codec);
    }

    public static SurfaceBuilderConfig modRegister(String topMaterial, String underMaterial, String underWaterMaterial) {
        return register(getModdedBlock(topMaterial), getModdedBlock(underMaterial), getModdedBlock(underWaterMaterial));
    }

    public static SurfaceBuilderConfig register(String topMaterial, String underMaterial, String underWaterMaterial) {
        return register(getBlock(topMaterial), getBlock(underMaterial), getBlock(underWaterMaterial));
    }

    public static SurfaceBuilderConfig register(String namespace, String topMaterial, String underMaterial, String underWaterMaterial) {
        return register(getBlock(namespace, topMaterial), getBlock(namespace, underMaterial), getBlock(namespace, underWaterMaterial));
    }

    public static SurfaceBuilderConfig register(Supplier<Block> topMaterial, Supplier<Block> underMaterial, Supplier<Block> underWaterMaterial) {
        return register(getState(topMaterial), getState(underMaterial), getState(underWaterMaterial));
    }

    public static SurfaceBuilderConfig register(Block topMaterial, Block underMaterial, Block underWaterMaterial) {
        return register(getState(topMaterial), getState(underMaterial), getState(underWaterMaterial));
    }

    public static SurfaceBuilderConfig register(ModBlockState topMaterial, ModBlockState underMaterial, ModBlockState underWaterMaterial) {
        return register(topMaterial.state, underMaterial.state, underWaterMaterial.state);
    }

    public static SurfaceBuilderConfig register(BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial) {
        return new SurfaceBuilderConfig(topMaterial, underMaterial, underWaterMaterial);
    }

    public static Block getModdedBlock(String path) {
        return getBlock(Ervin_mod_1.MOD_ID, path);
    }

    public static Block getBlock(String path) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(path));
    }

    public static Block getBlock(String namespace, String path) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(namespace, path));
    }

    public static BlockState getState(Supplier<Block> blockSupplier) {
        return getState(blockSupplier.get());
    }

    public static BlockState getState(Block block) {
        return block.getDefaultState();
    }

    public enum ModBlockState {
        AIR(Blocks.AIR),
        STONE(Blocks.STONE),
        GRASS_BLOCK(Blocks.GRASS_BLOCK),
        DIRT(Blocks.DIRT),
        COARSE_DIRT(Blocks.COARSE_DIRT),
        BEDROCK(Blocks.BEDROCK),
        WATER(Blocks.WATER),
        GRASS(Blocks.GRASS),
        OBSIDIAN(Blocks.OBSIDIAN),
        CARVED_PUMPKIN(Blocks.CARVED_PUMPKIN),
        REDSTONE_BLOCK(Blocks.REDSTONE_BLOCK),
        MAGMA_BLOCK(Blocks.MAGMA_BLOCK),
        RED_CONCRETE(Blocks.RED_CONCRETE),
        CAVE_AIR(Blocks.CAVE_AIR),
        FIRG(BlockInit.FIRG),
        SCRAFTH(BlockInit.SCRAFTH),
        GTRZIUZHIZJKJ(SpecialBlockInit.GTRZIUZHIZJKJ),
        MOD_END_PORTAL(BlockItemInit.END_PORTAL),
        KALT_BLOCK(BlockItemInit.KALT_BLOCK),
        DURT(BlockItemInit.DURT),
        SRURG(isBurnableBlockItemInit.SRURG),
        NIRTK(isBurnableBlockItemInit.NIRTK),
        NIRTKB(isBurnableBlockItemInit.NIRTKB),
        EPKIH(isBurnableBlockItemInit.EPKIH),
        MOD_NETHER_PORTAL(isBurnableBlockItemInit.NETHER_PORTAL);

        public final BlockState state;

        ModBlockState(Supplier<Block> block) {
            this(block.get());
        }

        ModBlockState(Block block) {
            this.state = block.getDefaultState();
        }

        public BlockState getState() {
            return this.state;
        }
    }
}
