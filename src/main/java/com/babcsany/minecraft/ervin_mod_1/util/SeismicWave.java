package com.babcsany.minecraft.ervin_mod_1.util;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.List;

public class SeismicWave {
    /*private final boolean affectsTerrain;
    private boolean first;

    public SeismicWave(int x, int y, int z, boolean affectsTerrain) {
        super(x, y, z);
        this.affectsTerrain = affectsTerrain;
    }

    public boolean isFirst() {
        return this.first;
    }

    public static void createWaves(World world, List<SeismicWave> list, int x1, int z1, int x2, int z2, int y) {
        int deltaX = x2 - x1;
        int deltaZ = z2 - z1;
        int xStep = deltaX < 0 ? -1 : 1;
        int zStep = deltaZ < 0 ? -1 : 1;
        deltaX = Math.abs(deltaX);
        deltaZ = Math.abs(deltaZ);
        int x = x1;
        int z = z1;
        int deltaX2 = deltaX * 2;
        int deltaZ2 = deltaZ * 2;
        SeismicWave wave = addWave(world, list, x1, y, z1);
        if (wave != null) {
            wave.first = true;
        }

        int error;
        int i;
        if (deltaX2 >= deltaZ2) {
            error = deltaX;

            for(i = 0; i < deltaX; ++i) {
                x += xStep;
                error += deltaZ2;
                if (error > deltaX2) {
                    z += zStep;
                    error -= deltaX2;
                }

                addWave(world, list, x, y, z);
            }
        } else {
            error = deltaZ;

            for(i = 0; i < deltaZ; ++i) {
                z += zStep;
                error += deltaX2;
                if (error > deltaZ2) {
                    x += xStep;
                    error -= deltaZ2;
                }

                addWave(world, list, x, y, z);
            }
        }

    }

    @Nullable
    public static SeismicWave addWave(World world, List<SeismicWave> list, int x, int y, int z) {
        y = ZombieResurrection.getSuitableGround(world, x, y, z, 3, false);
        SeismicWave wave = null;
        if (y != -1) {
            list.add(wave = new SeismicWave(x, y, z, true));
        }

        if (world.field_73012_v.nextInt(2) == 0) {
            list.add(new SeismicWave(x, y + 1, z, false));
        }

        return wave;
    }

    public void affectBlocks(World world, Entity entity) {
        if (this.affectsTerrain) {
            BlockPos posAbove = this.func_177984_a();
            BlockState blockstate = world.func_180495_p(this);
            Block block = blockstate.func_177230_c();
            PlayerEntity playerEntity = entity instanceof PlayerEntity ? (PlayerEntity)entity : null;
            if (playerEntity != null && playerEntity.func_175142_cm() || ForgeEventFactory.getMobGriefingEvent(world, entity)) {
                if (block == Blocks.field_196658_i || block == Blocks.field_185774_da || block == Blocks.field_150458_ak || block == Blocks.field_196661_l || block == Blocks.field_150391_bh) {
                    world.func_180501_a(this, Blocks.field_150346_d.func_176223_P(), 2);
                }

                float hardness = world.func_180495_p(posAbove).func_185887_b(world, posAbove);
                if (hardness > -1.0F && hardness <= 1.0F) {
                    world.func_175655_b(posAbove, playerEntity != null);
                }

                if (block instanceof DoorBlock) {
                    if (blockstate.func_185904_a() == Material.field_151575_d) {
                        world.func_217377_a(posAbove, false);
                        world.func_217379_c(1021, posAbove, 0);
                    } else if (blockstate.func_185904_a() == Material.field_151573_f) {
                        world.func_217379_c(1020, posAbove, 0);
                    }
                }

                if (block instanceof TNTBlock) {
                    block.catchFire(blockstate, world, this, (Direction)null, playerEntity);
                    world.func_217377_a(this, false);
                }
            }

            if (block instanceof BellBlock) {
                ((BellBlock)block).func_226884_a_(world, blockstate, new BlockRayTraceResult(Vector3d.func_237489_a_(this), entity.func_174811_aO(), this, false), playerEntity, true);
            }

            if (block == Blocks.field_150450_ax) {
                block.onisSlimeBlock(world, this, entity);
            }

            if (blockstate.func_204520_s().func_206888_e()) {
                world.func_217379_c(2001, posAbove, Block.func_196246_j(blockstate));
            } else {
                MBPacketHandler.INSTANCE.send(PacketDistributor.NEAR.with(() -> {
                    return new PacketDistributor.TargetPoint((double)this.func_177958_n() + 0.5D, (double)this.func_177956_o(), (double)this.func_177952_p() + 0.5D, 1024.0D, entity.field_70170_p.func_234923_W_());
                }), new FluidParticlePacket(blockstate, this));
            }

        }
    }*/
}
