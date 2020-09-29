package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class ExampleDimension3 /*extends Dimension*/ {

	/*public ExampleDimension3(World world, DimensionType type) {
		super(world, type, 1.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new ExampleChunkGenerator3(world,
				new ExampleBiomeProvider3(new ExampleBiomeProviderSettings3(this.world.getWorldInfo())),
				new ExampleGenSettings3());
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
		int j = 10;
		float f1 = (j + partialTicks) / 100.0f - 1.0f;
		if (f1 < 1.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 1.0d);
		f1 = f2 + (f1 - f2) / 1.0f;
		return f1;
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		return Vec3d.ZERO;
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
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.BED_EXPLODES;
	}

	@Override
	public boolean hasSkyLight() {
		return true;
	}

	@Override
	public int getActualHeight() {
		return 200;
	}*/
}
