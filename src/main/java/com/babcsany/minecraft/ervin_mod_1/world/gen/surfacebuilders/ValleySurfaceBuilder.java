package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Comparator;
import java.util.Random;

public abstract class ValleySurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    private long field_237170_a_;
    private final ImmutableMap<BlockState, OctavesNoiseGenerator> field_237171_b_ = ImmutableMap.of();
    private final ImmutableMap<BlockState, OctavesNoiseGenerator> field_237172_c_ = ImmutableMap.of();
    private OctavesNoiseGenerator field_237173_d_;

    public ValleySurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232136_1_) {
        super(p_i232136_1_);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int i = seaLevel + 1;
        int j = x & 15;
        int k = z & 15;
        int l = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int i1 = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        double d0 = 0.03125D;
        boolean flag = this.field_237173_d_.func_205563_a((double) x * 0.03125D, 109.0D, (double) z * 0.03125D) * 75.0D + random.nextDouble() > 0.0D;
        BlockState blockstate = this.field_237172_c_.entrySet().stream().max(Comparator.comparing((p_237176_3_) -> p_237176_3_.getValue().func_205563_a(x, seaLevel, z))).get().getKey();
        BlockState blockstate1 = this.field_237171_b_.entrySet().stream().max(Comparator.comparing((p_237174_3_) -> p_237174_3_.getValue().func_205563_a(x, seaLevel, z))).get().getKey();
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable.setPos(j, 128, k));

        for (int j1 = 127; j1 >= 0; --j1) {
            blockpos$mutable.setPos(j, j1, k);
            BlockState blockstate3 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.matchesBlock(defaultBlock.getBlock()) && (blockstate3.isAir() || blockstate3 == defaultFluid)) {
                for (int k1 = 0; k1 < l; ++k1) {
                    blockpos$mutable.move(Direction.UP);
                    if (!chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock())) {
                        break;
                    }

                    chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                }

                blockpos$mutable.setPos(j, j1, k);
            }

            if ((blockstate2.isAir() || blockstate2 == defaultFluid) && blockstate3.matchesBlock(defaultBlock.getBlock())) {
                for (int l1 = 0; l1 < i1 && chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock()); ++l1) {
                    if (flag && j1 >= i - 4 && j1 <= i + 1) {
                        chunkIn.setBlockState(blockpos$mutable, this.func_230380_a_(), false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }

                    blockpos$mutable.move(Direction.DOWN);
                }
            }
        }

        for (int j1 = 112; j1 >= 0; --j1) {
            blockpos$mutable.setPos(j, j1, k);
            BlockState blockstate3 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.matchesBlock(defaultBlock.getBlock()) && (blockstate3.isAir() || blockstate3 == defaultFluid)) {
                for (int k1 = 0; k1 < l; ++k1) {
                    blockpos$mutable.move(Direction.UP);
                    if (!chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock())) {
                        break;
                    }

                    chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                }

                blockpos$mutable.setPos(j, j1, k);
            }

            if ((blockstate2.isAir() || blockstate2 == defaultFluid) && blockstate3.matchesBlock(defaultBlock.getBlock())) {
                for (int l1 = 0; l1 < i1 && chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock()); ++l1) {
                    if (flag && j1 >= i - 8 && j1 <= i + 1) {
                        chunkIn.setBlockState(blockpos$mutable, this.func_230380_b_(), false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }

                    blockpos$mutable.move(Direction.DOWN);
                }
            }
        }

        for (int j1 = 106; j1 >= 0; --j1) {
            blockpos$mutable.setPos(j, j1, k);
            BlockState blockstate3 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.matchesBlock(defaultBlock.getBlock()) && (blockstate3.isAir() || blockstate3 == defaultFluid)) {
                for (int k1 = 0; k1 < l; ++k1) {
                    blockpos$mutable.move(Direction.UP);
                    if (!chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock())) {
                        break;
                    }

                    chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                }

                blockpos$mutable.setPos(j, j1, k);
            }

            if ((blockstate2.isAir() || blockstate2 == defaultFluid) && blockstate3.matchesBlock(defaultBlock.getBlock())) {
                for (int l1 = 0; l1 < i1 && chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock()); ++l1) {
                    if (flag && j1 >= i - 4 && j1 <= i + 1) {
                        chunkIn.setBlockState(blockpos$mutable, this.func_230380_c_(), false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }

                    blockpos$mutable.move(Direction.DOWN);
                }
            }
        }

        for (int j1 = 118; j1 >= 0; --j1) {
            blockpos$mutable.setPos(j, j1, k);
            BlockState blockstate3 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.matchesBlock(defaultBlock.getBlock()) && (blockstate3.isAir() || blockstate3 == defaultFluid)) {
                for (int k1 = 0; k1 < l; ++k1) {
                    blockpos$mutable.move(Direction.UP);
                    if (!chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock())) {
                        break;
                    }

                    chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                }

                blockpos$mutable.setPos(j, j1, k);
            }

            if ((blockstate2.isAir() || blockstate2 == defaultFluid) && blockstate3.matchesBlock(defaultBlock.getBlock())) {
                for (int l1 = 0; l1 < i1 && chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock()); ++l1) {
                    if (flag && j1 >= i - 4 && j1 <= i + 1) {
                        chunkIn.setBlockState(blockpos$mutable, this.func_230380_d_(), false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }

                    blockpos$mutable.move(Direction.DOWN);
                }
            }
        }

        for (int j1 = 125; j1 >= 0; --j1) {
            blockpos$mutable.setPos(j, j1, k);
            BlockState blockstate3 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.matchesBlock(defaultBlock.getBlock()) && (blockstate3.isAir() || blockstate3 == defaultFluid)) {
                for (int k1 = 0; k1 < l; ++k1) {
                    blockpos$mutable.move(Direction.UP);
                    if (!chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock())) {
                        break;
                    }

                    chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                }

                blockpos$mutable.setPos(j, j1, k);
            }

            if ((blockstate2.isAir() || blockstate2 == defaultFluid) && blockstate3.matchesBlock(defaultBlock.getBlock())) {
                for (int l1 = 0; l1 < i1 && chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock()); ++l1) {
                    if (flag && j1 >= i - 7 && j1 <= i + 1) {
                        chunkIn.setBlockState(blockpos$mutable, this.func_230380_e_(), false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }

                    blockpos$mutable.move(Direction.DOWN);
                }
            }

            blockstate2 = blockstate3;
        }

        for (int j1 = 114; j1 >= 0; --j1) {
            blockpos$mutable.setPos(j, j1, k);
            BlockState blockstate3 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.matchesBlock(defaultBlock.getBlock()) && (blockstate3.isAir() || blockstate3 == defaultFluid)) {
                for (int k1 = 0; k1 < l; ++k1) {
                    blockpos$mutable.move(Direction.UP);
                    if (!chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock())) {
                        break;
                    }

                    chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                }

                blockpos$mutable.setPos(j, j1, k);
            }

            if ((blockstate2.isAir() || blockstate2 == defaultFluid) && blockstate3.matchesBlock(defaultBlock.getBlock())) {
                for (int l1 = 0; l1 < i1 && chunkIn.getBlockState(blockpos$mutable).matchesBlock(defaultBlock.getBlock()); ++l1) {
                    if (flag && j1 >= i - 5 && j1 <= i + 1) {
                        chunkIn.setBlockState(blockpos$mutable, this.func_230380_f_(), false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }

                    blockpos$mutable.move(Direction.DOWN);
                }
            }

            blockstate2 = blockstate3;
        }

    }

    protected abstract ImmutableList<BlockState> func_230387_a_();
    protected abstract ImmutableList<BlockState> func_230388_b_();
    protected abstract ImmutableList<BlockState> func_230389_c_();
    protected abstract ImmutableList<BlockState> func_230390_d_();
    protected abstract ImmutableList<BlockState> func_230391_e_();

    protected abstract BlockState func_230380_a_();
    protected abstract BlockState func_230380_b_();
    protected abstract BlockState func_230380_c_();
    protected abstract BlockState func_230380_d_();
    protected abstract BlockState func_230380_e_();
    protected abstract BlockState func_230380_f_();
    protected abstract BlockState func_230380_g_();
    protected abstract BlockState func_230380_h_();
    protected abstract BlockState func_230380_i_();
    protected abstract BlockState func_230380_j_();
    protected abstract BlockState func_230380_k_();
    protected abstract BlockState func_230380_l_();
    protected abstract BlockState func_230380_m_();
    protected abstract BlockState func_230380_n_();
    protected abstract BlockState func_230380_o_();
    protected abstract BlockState func_230380_p_();
    protected abstract BlockState func_230380_q_();
    protected abstract BlockState func_230380_r_();
    protected abstract BlockState func_230380_s_();
    protected abstract BlockState func_230380_t_();
    protected abstract BlockState func_230380_u_();
    protected abstract BlockState func_230380_v_();
    protected abstract BlockState func_230380_w_();
    protected abstract BlockState func_230380_x_();
    protected abstract BlockState func_230380_y_();
    protected abstract BlockState func_230380_z_();
    protected abstract BlockState func_230381_a_();
    protected abstract BlockState func_230381_b_();
    protected abstract BlockState func_230381_c_();
    protected abstract BlockState func_230381_d_();
    protected abstract BlockState func_230381_e_();
    protected abstract BlockState func_230381_f_();
    protected abstract BlockState func_230381_g_();
}
