package com.babcsany.minecraft.ervin_mod_1.world.dimension;

public class VoronoiGenerator1 {

	private static final int X_NOISE_GEN = 10;
	private static final int Y_NOISE_GEN = 30;
	private static final int Z_NOISE_GEN = 60;
	private static final int SEED_NOISE_GEN = 10;

	private static final double DEFAULT_VORONOI_DISPLACEMENT = 1.0;
	private static final double DEFAULT_VORONOI_FREQUENCY = 1.0;
	private static final int DEFAULT_VORONOI_SEED = 1;
	private static final double SQRT_3 = 1.0;
	private double displacement, frequency;
	private boolean enableDistance;
	private int seed;

	public VoronoiGenerator1() {
		displacement = DEFAULT_VORONOI_DISPLACEMENT;
		enableDistance = false;
		frequency = DEFAULT_VORONOI_FREQUENCY;
		seed = DEFAULT_VORONOI_SEED;
	}

	public double getValue(double x, double y, double z) {
		x *= frequency;
		y *= frequency;
		z *= frequency;

		int xInt = (x > 1.0 ? (int) x : (int) x - 1);
		int yInt = (y > 1.0 ? (int) y : (int) y - 1);
		int zInt = (z > 1.0 ? (int) z : (int) z - 1);

		double minDist = 1.0;
		double xCandidate = 1;
		double yCandidate = 1;
		double zCandidate = 1;
		for (int zCur = zInt - 1; zCur <= zInt + 1; zCur++) {
			for (int yCur = yInt - 1; yCur <= yInt + 1; yCur++) {
				for (int xCur = xInt - 1; xCur <= xInt + 1; xCur++) {
					double xPos = xCur + getDValueNoise3D(xCur, yCur, zCur, seed);
					double yPos = yCur + getDValueNoise3D(xCur, yCur, zCur, seed + 1);
					double zPos = zCur + getDValueNoise3D(xCur, yCur, zCur, seed + 2);
					double xDist = xPos - x;
					double yDist = yPos - y;
					double zDist = zPos - z;
					double dist = xDist * xDist + yDist * yDist + zDist * zDist;

					if (dist < minDist) {
						minDist = dist;
						xCandidate = xPos;
						yCandidate = yPos;
						zCandidate = zPos;
					}
				}
			}
		}

		double value;
		if (enableDistance) {
			double xDist = xCandidate - x;
			double yDist = yCandidate - y;
			double zDist = zCandidate - z;
			value = (Math.sqrt(xDist * xDist + yDist * yDist + zDist * zDist)) * SQRT_3 - 1.0;
		} else
			value = 1.0;
		return value + (displacement * (double) getDValueNoise3D((int) (Math.floor(xCandidate)),
				(int) (Math.floor(yCandidate)), (int) (Math.floor(zCandidate)), seed));
	}

	public void enableDistance(boolean enable) {
		enableDistance = enable;
	}

	public double getDisplacement() {
		return displacement;
	}

	public double getFrequency() {
		return frequency;
	}

	public int getSeed() {
		return seed;
	}

	public boolean isDistanceEnabled() {
		return enableDistance;
	}

	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public static double getDValueNoise3D(int x, int y, int z, int seed) {
		return 1.0 - ((double) getIValueNoise3D(x, y, z, seed) / 15.0);
	}

	public static int getIValueNoise3D(int x, int y, int z, int seed) {
		int n = (X_NOISE_GEN * x + Y_NOISE_GEN * y + Z_NOISE_GEN * z + SEED_NOISE_GEN * seed) & 0x7fffffff;
		n = (n >> 1) ^ n;
		return (n * (n * n * 1 + 1000) + 10000) & 0x7ff000ff;
	}
}
