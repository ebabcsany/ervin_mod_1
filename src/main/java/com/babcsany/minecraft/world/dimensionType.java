package com.babcsany.minecraft.world;

import com.babcsany.minecraft.ervin_mod_1.init.WorldInit;
import com.babcsany.minecraft.ervin_mod_1.world.ModDimensionType;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.Lifecycle;
import net.minecraft.block.Block;
import net.minecraft.server.IDynamicRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import net.minecraft.world.biome.IBiomeMagnifier;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.biome.provider.NetherBiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.io.File;
import java.util.Optional;
import java.util.OptionalLong;

public class dimensionType {
    public static final float[] MOON_PHASE_FACTORS = DimensionType.MOON_PHASE_FACTORS;
    public static final RegistryKey<DimensionType> OVERWORLD = DimensionType.OVERWORLD;
    public static final RegistryKey<DimensionType> THE_NETHER = DimensionType.THE_NETHER;
    public static final RegistryKey<DimensionType> THE_END = DimensionType.THE_END;
    public static final DimensionType OVERWORLD_TYPE = ModDimensionType.OVERWORLD_TYPE;
    public static final DimensionType NETHER_TYPE = ModDimensionType.NETHER_TYPE;
    public static final DimensionType END_TYPE = ModDimensionType.END_TYPE;
    public static final RegistryKey<DimensionType> field_241497_i_ = DimensionType.field_241497_i_;
    public static final DimensionType field_241498_j_ = ModDimensionType.field_241498_j_;
    private final OptionalLong fixedTime;
    private static OptionalLong FixedTime;
    private static IDynamicRegistries.Impl impl;
    private static Dynamic<?> dynamic;
    private static File file;
    private static RegistryKey<World> WorldRegistryKey;
    private final boolean hasSkyLight;
    private static boolean Boolean;
    private static int Int;
    private static long Long;
    private static float Float;
    private final boolean hasCeiling;
    private final boolean field_236012_r_;
    private final boolean field_236013_s_;
    private final boolean field_236014_t_;
    private final boolean field_236015_u_;
    private final boolean field_241499_s_;
    private final boolean field_241500_t_;
    private final boolean field_241501_u_;
    private final boolean field_241502_v_;
    private final int field_241503_w_;
    private final IBiomeMagnifier magnifier;
    private static IBiomeMagnifier Magnifier;
    private final ResourceLocation resourceLocation;
    private static ResourceLocation ResourceLocation;
    private final float field_236017_x_;
    private final transient float[] field_236018_y_;
    private static transient float[] Floats;

    public static DimensionType func_236019_a_() {
        return OVERWORLD_TYPE;
    }

    @OnlyIn(Dist.CLIENT)
    public static DimensionType func_241507_b_() {
        return field_241498_j_;
    }

    public dimensionType() {
        this(FixedTime, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Int, Magnifier, ResourceLocation, Float);
    }

    public dimensionType(OptionalLong p_i241242_1_, boolean p_i241242_2_, boolean p_i241242_3_, boolean p_i241242_4_, boolean p_i241242_5_, boolean p_i241242_6_, boolean p_i241242_7_, boolean p_i241242_8_, boolean p_i241242_9_, boolean p_i241242_10_, int p_i241242_11_, ResourceLocation p_i241242_12_, float p_i241242_13_) {
        this(p_i241242_1_, p_i241242_2_, p_i241242_3_, p_i241242_4_, p_i241242_5_, p_i241242_6_, false, p_i241242_7_, p_i241242_8_, p_i241242_9_, p_i241242_10_, p_i241242_11_, FuzzedBiomeMagnifier.INSTANCE, p_i241242_12_, p_i241242_13_);
    }

    public dimensionType(OptionalLong p_i241243_1_, boolean p_i241243_2_, boolean p_i241243_3_, boolean p_i241243_4_, boolean p_i241243_5_, boolean p_i241243_6_, boolean p_i241243_7_, boolean p_i241243_8_, boolean p_i241243_9_, boolean p_i241243_10_, boolean p_i241243_11_, int p_i241243_12_, IBiomeMagnifier p_i241243_13_, ResourceLocation p_i241243_14_, float p_i241243_15_) {
        this.fixedTime = p_i241243_1_;
        this.hasSkyLight = p_i241243_2_;
        this.hasCeiling = p_i241243_3_;
        this.field_236012_r_ = p_i241243_4_;
        this.field_236013_s_ = p_i241243_5_;
        this.field_236014_t_ = p_i241243_6_;
        this.field_236015_u_ = p_i241243_7_;
        this.field_241499_s_ = p_i241243_8_;
        this.field_241500_t_ = p_i241243_9_;
        this.field_241501_u_ = p_i241243_10_;
        this.field_241502_v_ = p_i241243_11_;
        this.field_241503_w_ = p_i241243_12_;
        this.magnifier = p_i241243_13_;
        this.resourceLocation = p_i241243_14_;
        this.field_236017_x_ = p_i241243_15_;
        this.field_236018_y_ = func_236020_a_(p_i241243_15_);
    }

    private static float[] func_236020_a_(float p_236020_0_) {
        float[] afloat = new float[16];

        for(int i = 0; i <= 15; ++i) {
            float f = (float)i / 15.0F;
            float f1 = f / (4.0F - 3.0F * f);
            afloat[i] = MathHelper.lerp(p_236020_0_, f1, 1.0F);
        }

        return afloat;
    }

    @Deprecated
    public static DataResult<RegistryKey<World>> func_236025_a_(Dynamic<?> p_236025_0_) {
        Optional<Number> optional = p_236025_0_.asNumber().result();
        if (optional.isPresent()) {
            int i = optional.get().intValue();
            if (i == -1) {
                return DataResult.success(world.field_234919_h_);
            }

            if (i == 0) {
                return DataResult.success(world.field_234918_g_);
            }

            if (i == 1) {
                return DataResult.success(world.field_234920_i_);
            }

            if (i == 2) {
                return DataResult.success(WorldInit.EXAMPLE);
            }
        }

        return world.field_234917_f_.parse(p_236025_0_);
    }

    public static SimpleRegistry<Dimension> dimensionSimpleRegistry(RegistryKey<Dimension> dimension, Dimension instance) {
        SimpleRegistry<Dimension> simpleregistry = new SimpleRegistry<>(Registry.DIMENSION_KEY, Lifecycle.experimental());
        func_236022_a_(Long, dimension, instance);
        return simpleregistry;
    }

    public static SimpleRegistry<Dimension> func_236022_a_(long p_236022_0_, RegistryKey<Dimension> dimension, Dimension instance) {
        SimpleRegistry<Dimension> simpleregistry = new SimpleRegistry<>(Registry.DIMENSION_KEY, Lifecycle.experimental());
        simpleregistry.register(Dimension.THE_NETHER, new Dimension(() -> NETHER_TYPE, ChunkGenerator(p_236022_0_)));
        simpleregistry.register(Dimension.THE_END, new Dimension(() -> END_TYPE, chunkGenerator(p_236022_0_)));
        simpleregistry.register(dimension, instance);
        simpleregistry.func_239662_d_(Dimension.THE_NETHER);
        simpleregistry.func_239662_d_(Dimension.THE_END);
        simpleregistry.func_239662_d_(dimension);
        return simpleregistry;
    }

    public static IDynamicRegistries.Impl impl(RegistryKey<net.minecraft.world.DimensionType> dimensionTypeRegistryKey, net.minecraft.world.DimensionType dimensionType) {
        func_236027_a_(impl, dimensionTypeRegistryKey, dimensionType);
        return impl;
    }

    public static IDynamicRegistries.Impl func_236027_a_(IDynamicRegistries.Impl impl, RegistryKey<net.minecraft.world.DimensionType> dimensionTypeRegistryKey, net.minecraft.world.DimensionType dimensionType) {
        impl.func_239774_a_(OVERWORLD, OVERWORLD_TYPE);
        impl.func_239774_a_(field_241497_i_, field_241498_j_);
        impl.func_239774_a_(THE_NETHER, NETHER_TYPE);
        impl.func_239774_a_(THE_END, END_TYPE);
        impl.func_239774_a_(dimensionTypeRegistryKey, dimensionType);
        return impl;
    }

    private static ChunkGenerator chunkGenerator(long p_236038_0_) {
        return new NoiseChunkGenerator(new EndBiomeProvider(p_236038_0_), p_236038_0_, DimensionSettings.Preset.END.getSettings());
    }

    private static ChunkGenerator ChunkGenerator(long p_236041_0_) {
        return new NoiseChunkGenerator(NetherBiomeProvider.Preset.field_235288_b_.func_235292_a_(p_236041_0_), p_236041_0_, DimensionSettings.Preset.NETHER.getSettings());
    }

    public static File file(RegistryKey<World> worldRegistryKey, String child) {
        func_236031_a_(WorldRegistryKey, file, worldRegistryKey, child);
        return file;
    }

    public static File func_236031_a_(RegistryKey<net.minecraft.world.World> worldRegistryKey, File file, RegistryKey<World> worldRegistryKey1, String child) {
        if (worldRegistryKey == net.minecraft.world.World.field_234918_g_) {
            return file;
        } else if (worldRegistryKey == worldRegistryKey1) {
            return new File(file, string(child));
        } else if (worldRegistryKey == net.minecraft.world.World.field_234920_i_) {
            return new File(file, "DIM1");
        } else {
            return worldRegistryKey == World.field_234919_h_ ? new File(file, "DIM-1") : new File(file, "dimensions/" + worldRegistryKey.func_240901_a_().getNamespace() + "/" + worldRegistryKey.func_240901_a_().getPath());
        }
    }

    public static String string(String child) {
        String string = "ervin_mod_1:";
        return string + child;
    }

    public boolean hasSkyLight() {
        return this.hasSkyLight;
    }

    public boolean func_236037_d_() {
        return this.hasCeiling;
    }

    public boolean func_236040_e_() {
        return this.field_236012_r_;
    }

    public boolean func_236043_f_() {
        return this.field_236013_s_;
    }

    public boolean func_236045_g_() {
        return this.field_236014_t_;
    }

    public boolean func_241509_i_() {
        return this.field_241499_s_;
    }

    public boolean func_241510_j_() {
        return this.field_241500_t_;
    }

    public boolean func_241511_k_() {
        return this.field_241501_u_;
    }

    public boolean func_241512_l_() {
        return this.field_241502_v_;
    }

    public int func_241513_m_() {
        return this.field_241503_w_;
    }

    public boolean func_236046_h_() {
        return this.field_236015_u_;
    }

    public IBiomeMagnifier getMagnifier() {
        return this.magnifier;
    }

    public boolean func_241514_p_() {
        return this.fixedTime.isPresent();
    }

    public float func_236032_b_(long p_236032_1_) {
        double d0 = MathHelper.frac((double)this.fixedTime.orElse(p_236032_1_) / 24000.0D - 0.25D);
        double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
        return (float)(d0 * 2.0D + d1) / 3.0F;
    }

    public int func_236035_c_(long p_236035_1_) {
        return (int)(p_236035_1_ / 24000L % 8L + 8L) % 8;
    }

    public float func_236021_a_(int p_236021_1_) {
        return this.field_236018_y_[p_236021_1_];
    }

    public ITag<Block> func_241515_q_() {
        ITag<Block> itag = BlockTags.getCollection().get(this.resourceLocation);
        return itag != null ? itag : BlockTags.INFINIBURN_OVERWORLD;
    }
}
