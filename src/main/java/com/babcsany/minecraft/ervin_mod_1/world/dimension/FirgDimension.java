package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class FirgDimension /*extends Dimension*/ {

	/*public FirgDimension(World world, DimensionType type) {
		super(world, type, 0.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new FirgChunkGenerator(world,
				new FirgBiomeProvider(new FirgBiomeProviderSettings(this.world.getWorldInfo())),
				new FirgGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		if (f1 < 0.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	public Vector3d getFogColor(float celestialAngle, float partialTicks) {
		return Vector3d.ZERO;
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public PlayerEntity.SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return PlayerEntity.SleepResult.OTHER_PROBLEM;
	}

	@Override
	public boolean hasSkyLight() {
		return true;
	}

	@Override
	public int getActualHeight() {
		return 256;
	}*/
}
