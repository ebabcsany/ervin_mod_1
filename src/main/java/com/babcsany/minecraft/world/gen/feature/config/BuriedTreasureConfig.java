package com.babcsany.minecraft.world.gen.feature.config;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BuriedTreasureConfig implements IFeatureConfig {
   public static final Codec<BuriedTreasureConfig> buriedTreasureConfigCodec = Codec.FLOAT.xmap(BuriedTreasureConfig::new, (p_236458_0_) -> p_236458_0_.probability);
   public final float probability;

   public BuriedTreasureConfig(float probability) {
      this.probability = probability;
   }
}
