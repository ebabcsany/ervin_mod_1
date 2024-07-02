package com.babcsany.minecraft.ervin_mod_1.entity.player;

import com.babcsany.minecraft.ervin_mod_1.block.blocks.Hurvruj;
import com.mojang.authlib.GameProfile;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Optional;

public abstract class ModPlayerEntity extends PlayerEntity {
    public ModPlayerEntity(World worldIn, BlockPos pos, float spawnAngle, GameProfile profile) {
        super(worldIn, pos, spawnAngle, profile);
    }

    public static Optional<Vector3d> findRespawnPoint(ServerWorld worldIn, BlockPos pos, float orientation, boolean forced, boolean keepEverything) {
        BlockState blockstate = worldIn.getBlockState(pos);
        Block block = blockstate.getBlock();
        if (block instanceof RespawnAnchorBlock && blockstate.get(RespawnAnchorBlock.CHARGES) > 0 && RespawnAnchorBlock.doesRespawnAnchorWork(worldIn)) {
            Optional<Vector3d> optional = RespawnAnchorBlock.findRespawnPoint(EntityType.PLAYER, worldIn, pos);
            if (!keepEverything && optional.isPresent()) {
                worldIn.setBlockState(pos, blockstate.with(RespawnAnchorBlock.CHARGES, Integer.valueOf(blockstate.get(RespawnAnchorBlock.CHARGES) - 1)), 3);
            }

            return optional;
        } else if (block instanceof Hurvruj && blockstate.get(Hurvruj.HURVRUJ_CHARGES) > 0 && Hurvruj.doesHurvrujWork(worldIn)) {
            Optional<Vector3d> optional = Hurvruj.findRespawnPoint(EntityType.PLAYER, worldIn, pos);
            if (!keepEverything && optional.isPresent()) {
                worldIn.setBlockState(pos, blockstate.with(Hurvruj.HURVRUJ_CHARGES, Integer.valueOf(blockstate.get(Hurvruj.HURVRUJ_CHARGES) - 1)), Hurvruj.MAX_CHARGES - 1);
            }

            return optional;
        } else if (blockstate.isBed(worldIn, pos, null) && BedBlock.doesBedWork(worldIn)) {
            return blockstate.getBedSpawnPosition(EntityType.PLAYER, worldIn, pos, orientation, null);
        } else if (!forced) {
            return Optional.empty();
        } else {
            boolean flag = block.canSpawnInBlock();
            boolean flag1 = worldIn.getBlockState(pos.up()).getBlock().canSpawnInBlock();
            return flag && flag1 ? Optional.of(new Vector3d((double)pos.getX() + 0.5D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D)) : Optional.empty();
        }
    }
}
