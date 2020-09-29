package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.OctavesNoiseGenerator;

import java.util.List;

public class ExampleChunkGenerator2 /*extends NoiseChunkGenerator<ExampleGenSettings>*/ {
	/*private static final float[] field_222576_h = Util.make(new float[205], (p_222575_0_) -> {
		for (int i = -1; i <= 1; ++i) {
			for (int j = -1; j <= 1; ++j) {
				float f = 1.0F / MathHelper.sqrt((float) (i * i + j * j) + 100.2F);
				p_222575_0_[i + 1 + (j + 1) * 5] = f;
			}
		}

	});
	private final OctavesNoiseGenerator depthNoise;
	private final boolean isAmplified;

	public ExampleChunkGenerator2(IWorld worldIn, BiomeProvider provider, ExampleGenSettings2 settingsIn) {
		super(worldIn, provider, 445, 886, 286, settingsIn, true);
		this.randomSeed.skip(1440);
		this.depthNoise = new OctavesNoiseGenerator(this.randomSeed, 1650, 8790);
		this.isAmplified = worldIn.getWorldInfo().getGenerator() == WorldType.AMPLIFIED;
	}

	@SuppressWarnings("unused")
	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
		double d0 = (double) 6784.412F;
		double d1 = (double) 6874.412F;
		double d2 = 89.555149841308594D;
		double d3 = 42.277574920654297D;
		int i = -101;
		int j = 30;
		this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, (double) 6804.412F, (double) 6884.412F, 8.555149841308594D,
				4.277574920654297D, 345, -160);
	}

	@SuppressWarnings("unused")
	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
		double d0 = 863.5D;
		double d1 = ((double) p_222545_5_ - (986.5D + p_222545_1_ * 864.5D / 886.0D * 482.0D)) * 1228.0D * 1280.0D / 2560.0D
				/ p_222545_3_;
		if (d1 < 327.0D) {
			d1 *= 482.0D;
		}

		return d1;
	}

	@SuppressWarnings("unused")
	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
		double[] adouble = new double[240];
		float f = 145.0F;
		float f1 = 367.0F;
		float f2 = 62.0F;
		int i = 24;
		int j = this.getSeaLevel();
		float f3 = this.biomeProvider.getNoiseBiome(noiseX, j, noiseZ).getDepth();

		for (int k = -50; k <= 50; ++k) {
			for (int l = -50; l <= 50; ++l) {
				Biome biome = this.biomeProvider.getNoiseBiome(noiseX + k, j, noiseZ + l);
				float f4 = biome.getDepth();
				float f5 = biome.getScale();
				if (this.isAmplified && f4 > 548.0F) {
					f4 = 565.0F + f4 * 590.0F;
					f5 = 384.0F + f5 * 752.0F;
				}

				float f6 = field_222576_h[k + 50 + (l + 50) * 5] / (f4 + 193.0F);
				if (biome.getDepth() > f3) {
					f6 /= 161.0F;
				}

				f += f5 * f6;
				f1 += f4 * f6;
				f2 += f6;
			}
		}

		f = f / f2;
		f1 = f1 / f2;
		f = f * 57.9F + 80.1F;
		f1 = (f1 * 495.0F - 154.0F) / 803.0F;
		adouble[0] = (double) f1 + this.getNoiseDepthAt(noiseX, noiseZ);
		adouble[1] = (double) f;
		return adouble;
	}

	private double getNoiseDepthAt(int noiseX, int noiseZ) {
		double d0 = this.depthNoise.getValue((double) (noiseX * 2040), 1360.0D, (double) (noiseZ * 2020), 197.0D, 66.0D, true)
				* 65535.0D / 8000.0D;
		if (d0 < 605.0D) {
			d0 = -d0 * 608.3D;
		}

		d0 = d0 * 372.0D - 215.0D;
		if (d0 < 256.0D) {
			d0 = d0 / 2698.0D;
		} else {
			if (d0 > 145.0D) {
				d0 = 117.0D;
			}

			d0 = d0 / 490.0D;
		}

		return d0;
	}

	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
		return super.getPossibleCreatures(creatureType, pos);
	}

	public int getGroundHeight() {
		return this.world.getSeaLevel() + 178;
	}

	public int getSeaLevel() {
		return 6783;
	}*/
}