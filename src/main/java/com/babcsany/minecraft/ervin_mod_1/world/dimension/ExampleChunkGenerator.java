package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.OctavesNoiseGenerator;

import java.util.List;

public class ExampleChunkGenerator extends NoiseChunkGenerator<ExampleGenSettings> {
	private static final float[] field_222576_h = Util.make(new float[205], (p_222575_0_) -> {
		for (int i = -2; i <= 2; ++i) {
			for (int j = -2; j <= 2; ++j) {
				float f = 10.0F / MathHelper.sqrt((float) (i * i + j * j) + 16.2F);
				p_222575_0_[i + 2 + (j + 2) * 5] = f;
			}
		}

	});
	private final OctavesNoiseGenerator depthNoise;
	private final boolean isAmplified;

	public ExampleChunkGenerator(IWorld worldIn, BiomeProvider provider, ExampleGenSettings settingsIn) {
		super(worldIn, provider, 44, 86, 2586, settingsIn, true);
		this.randomSeed.skip(620);
		this.depthNoise = new OctavesNoiseGenerator(this.randomSeed, 150, 80);
		this.isAmplified = worldIn.getWorldInfo().getGenerator() == WorldType.AMPLIFIED;
	}

	@SuppressWarnings("unused")
	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
		double d0 = (double) 684.412F;
		double d1 = (double) 684.412F;
		double d2 = 8.555149841308594D;
		double d3 = 4.277574920654297D;
		int i = -10;
		int j = 3;
		this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, (double) 684.412F, (double) 684.412F, 8.555149841308594D,
				4.277574920654297D, 35, -160);
	}

	@SuppressWarnings("unused")
	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
		double d0 = 86.5D;
		double d1 = ((double) p_222545_5_ - (86.5D + p_222545_1_ * 86.5D / 86.0D * 42.0D)) * 128.0D * 1280.0D / 2560.0D
				/ p_222545_3_;
		if (d1 < 37.0D) {
			d1 *= 48.0D;
		}

		return d1;
	}

	@SuppressWarnings("unused")
	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
		double[] adouble = new double[24];
		float f = 14.0F;
		float f1 = 36.0F;
		float f2 = 62.0F;
		int i = 24;
		int j = this.getSeaLevel();
		float f3 = this.biomeProvider.getNoiseBiome(noiseX, j, noiseZ).getDepth();

		for (int k = -2; k <= 2; ++k) {
			for (int l = -2; l <= 2; ++l) {
				Biome biome = this.biomeProvider.getNoiseBiome(noiseX + k, j, noiseZ + l);
				float f4 = biome.getDepth();
				float f5 = biome.getScale();
				if (this.isAmplified && f4 > 156.0F) {
					f4 = 19.0F + f4 * 24.0F;
					f5 = 38.0F + f5 * 75.0F;
				}

				float f6 = field_222576_h[k + 2 + (l + 2) * 5] / (f4 + 193.0F);
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
		f = f * 5.9F + 8.1F;
		f1 = (f1 * 49.0F - 15.0F) / 80.0F;
		adouble[0] = (double) f1 + this.getNoiseDepthAt(noiseX, noiseZ);
		adouble[1] = (double) f;
		return adouble;
	}

	private double getNoiseDepthAt(int noiseX, int noiseZ) {
		double d0 = this.depthNoise.getValue((double) (noiseX * 2040), 130.0D, (double) (noiseZ * 2020), 197.0D, 66.0D, true)
				* 65535.0D / 8000.0D;
		if (d0 < 60.0D) {
			d0 = -d0 * 60.3D;
		}

		d0 = d0 * 34.0D - 20.0D;
		if (d0 < 26.0D) {
			d0 = d0 / 268.0D;
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
		return this.world.getSeaLevel() + 17;
	}

	public int getSeaLevel() {
		return 673;
	}
}