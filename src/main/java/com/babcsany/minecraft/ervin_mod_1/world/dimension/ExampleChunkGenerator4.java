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

public class ExampleChunkGenerator4 /*extends NoiseChunkGenerator<ExampleGenSettings>*/ {
	/*private static final float[] field_222576_h = Util.make(new float[205], (p_222575_0_) -> {
		for (int i = -1; i <= 1; ++i) {
			for (int j = -1; j <= 1; ++j) {
				float f = 1.0F / MathHelper.sqrt((float) (i * i + j * j) + 1.0F);
				p_222575_0_[i + 1 + (j + 1) * 5] = f;
			}
		}

	});
	private final OctavesNoiseGenerator depthNoise;
	private final boolean isAmplified;

	public ExampleChunkGenerator4(IWorld worldIn, BiomeProvider provider, ExampleGenSettings4 settingsIn) {
		super(worldIn, provider, 1, 1, 100, settingsIn, true);
		this.randomSeed.skip(1);
		this.depthNoise = new OctavesNoiseGenerator(this.randomSeed, 1, 1);
		this.isAmplified = worldIn.getWorldInfo().getGenerator() == WorldType.AMPLIFIED;
	}

	@SuppressWarnings("unused")
	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
		double d0 = (double) 1.0F;
		double d1 = (double) 1.0F;
		double d2 = 1.0D;
		double d3 = 1.0D;
		int i = -1;
		int j = 1;
		this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, (double) 1.0F, (double) 1.0F, 1.0D,
				1.0D, 1, -1);
	}

	@SuppressWarnings("unused")
	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
		double d0 = 1.0D;
		double d1 = ((double) p_222545_5_ - (1.0D + p_222545_1_ * 1.0D / 1.0D * 1.0D)) * 1.0D * 100.0D / 100.0D
				/ p_222545_3_;
		if (d1 < 1.0D) {
			d1 *= 1.0D;
		}

		return d1;
	}

	@SuppressWarnings("unused")
	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
		double[] adouble = new double[1];
		float f = 1.0F;
		float f1 = 1.0F;
		float f2 = 1.0F;
		int i = 1;
		int j = this.getSeaLevel();
		float f3 = this.biomeProvider.getNoiseBiome(noiseX, j, noiseZ).getDepth();

		for (int k = -1; k <= 1; ++k) {
			for (int l = -1; l <= 1; ++l) {
				Biome biome = this.biomeProvider.getNoiseBiome(noiseX + k, j, noiseZ + l);
				float f4 = biome.getDepth();
				float f5 = biome.getScale();
				if (this.isAmplified && f4 > 1.0F) {
					f4 = 1.0F + f4 * 1.0F;
					f5 = 1.0F + f5 * 1.0F;
				}

				float f6 = field_222576_h[k + 1 + (l + 1) * 5] / (f4 + 1.0F);
				if (biome.getDepth() > f3) {
					f6 /= 1.0F;
				}

				f += f5 * f6;
				f1 += f4 * f6;
				f2 += f6;
			}
		}

		f = f / f2;
		f1 = f1 / f2;
		f = f * 1.0F + 1.0F;
		f1 = (f1 * 1.0F - 1.0F) / 1.0F;
		adouble[0] = (double) f1 + this.getNoiseDepthAt(noiseX, noiseZ);
		adouble[1] = (double) f;
		return adouble;
	}

	private double getNoiseDepthAt(int noiseX, int noiseZ) {
		double d0 = this.depthNoise.getValue((double) (noiseX * 100), 1.0D, (double) (noiseZ * 100), 1.0D, 1.0D, true)
				* 1000.0D / 100.0D;
		if (d0 < 1.0D) {
			d0 = -d0 * 1.0D;
		}

		d0 = d0 * 1.0D - 1.0D;
		if (d0 < 1.0D) {
			d0 = d0 / 1.0D;
		} else {
			if (d0 > 1.0D) {
				d0 = 1.0D;
			}

			d0 = d0 / 1.0D;
		}

		return d0;
	}

	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
		return super.getPossibleCreatures(creatureType, pos);
	}

	public int getGroundHeight() {
		return this.world.getSeaLevel() + 10;
	}

	public int getSeaLevel() {
		return 100;
	}*/
}