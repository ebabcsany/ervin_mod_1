package com.babcsany.minecraft.world;

import com.babcsany.minecraft.ervin_mod_1.init.DimensionTypeInit;
import com.babcsany.minecraft.ervin_mod_1.init.WorldInit;
import com.babcsany.minecraft.ervin_mod_1.init.dimension.settings.ModDimensionSettings;
import com.babcsany.minecraft.ervin_mod_1.registry.ModRegistry;
import com.babcsany.minecraft.ervin_mod_1.tags.BlockTags1;
import com.babcsany.minecraft.ervin_mod_1.world.ModDimensionType;
import com.babcsany.minecraft.server.IDynamicRegistries;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.codec.RangeCodec;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.ColumnFuzzedBiomeMagnifier;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import net.minecraft.world.biome.IBiomeMagnifier;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.biome.provider.NetherBiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.io.File;
import java.util.Optional;
import java.util.OptionalLong;

import static com.babcsany.minecraft.ervin_mod_1.init.DimensionTypeInit.EXAMPLE_TYPE;

public class dimensionType {
    public static final MapCodec<dimensionType> DIMENSION_TYPE_CODEC = RecordCodecBuilder.mapCodec((dimensionTypeInstance) -> dimensionTypeInstance.group(Codec.LONG.optionalFieldOf("fixed_time").xmap((longOptional) -> longOptional.map(OptionalLong::of).orElseGet(OptionalLong::empty), (optionalLong) -> optionalLong.isPresent() ? Optional.of(optionalLong.getAsLong()) : Optional.empty()).forGetter((dimensionType) -> dimensionType.fixedTime), Codec.BOOL.fieldOf("has_skylight").forGetter(dimensionType::hasSkyLight), Codec.BOOL.fieldOf("has_ceiling").forGetter(dimensionType::hasCeiling), Codec.BOOL.fieldOf("ultraWarm").forGetter(dimensionType::ultraWarm), Codec.BOOL.fieldOf("natural").forGetter(dimensionType::natural), Codec.BOOL.fieldOf("shrunk").forGetter(dimensionType::shrunk), Codec.BOOL.fieldOf("piglin_safe").forGetter(dimensionType::piglinSafe), Codec.BOOL.fieldOf("bed_works").forGetter(dimensionType::bedWorks), Codec.BOOL.fieldOf("respawn_anchor_works").forGetter(dimensionType::respawnAnchorWorks), Codec.BOOL.fieldOf("has_raids").forGetter(dimensionType::hasRaids), RangeCodec.func_232989_a_(0, 1024).fieldOf("logical_height").forGetter(dimensionType::logicalHeight), ResourceLocation.RESOURCE_LOCATION_CODEC.fieldOf("infiniburn").forGetter((dimensionType) -> dimensionType.resourceLocation), Codec.FLOAT.fieldOf("ambient_light").forGetter((dimensionType) -> dimensionType.field_236017_x_)).apply(dimensionTypeInstance, dimensionType::new));
    public static final float[] MOON_PHASE_FACTORS = DimensionType.MOON_PHASE_FACTORS;
    public static final RegistryKey<DimensionType> OVERWORLD = DimensionType.OVERWORLD;
    public static final RegistryKey<DimensionType> THE_NETHER = DimensionType.THE_NETHER;
    public static final RegistryKey<DimensionType> THE_END = DimensionType.THE_END;
    public static final DimensionType OVERWORLD_TYPE = ModDimensionType.OVERWORLD_TYPE;
    public static final DimensionType NETHER_TYPE = ModDimensionType.NETHER_TYPE;
    public static final DimensionType END_TYPE = ModDimensionType.END_TYPE;
    public static final RegistryKey<DimensionType> field_241497_i_ = DimensionType.field_241497_i_;
    public static final DimensionType field_241498_j_ = ModDimensionType.field_241498_j_;
    public static final RegistryKey<dimensionType> DIMENSION = RegistryKey.func_240903_a_(ModRegistry.MOD_DIMENSION_TYPE_KEY, new ResourceLocation("example_world_caves"));
    public static final dimensionType DIMENSION_TYPE = new dimensionType(OptionalLong.of(18000L), true, true, false, true, false, false, true, false, true, true, 1024, ColumnFuzzedBiomeMagnifier.INSTANCE, BlockTags1.INFINIBURN_EXAMPLE_WORLD.getName(), 0.0F);
    private final OptionalLong fixedTime;
    private static OptionalLong FixedTime;
    public static IDynamicRegistries.Impl impl;
    private static RegistryKey<Dimension> dimension;
    private static Dimension instance;
    public static RegistryKey<Dimension> dimensionRegistryKey;
    public static Dynamic<?> dynamic;
    public static File file;
    public static RegistryKey<World> WorldRegistryKey;
    private final boolean hasSkyLight;
    private static boolean Boolean;
    private static int Int;
    public static long Long;
    private static float Float;
    private final boolean hasCeiling;
    private final boolean ultraWarm;
    private final boolean natural;
    private final boolean shrunk;
    private final boolean field_236015_u_;
    private final boolean piglinSafe;
    private final boolean bedWorks;
    private final boolean respawnAnchorWorks;
    private final boolean hasRaids;
    private final int logicalHeight;
    private final IBiomeMagnifier magnifier;
    private static IBiomeMagnifier Magnifier;
    private final ResourceLocation resourceLocation;
    private static ResourceLocation Resource_Location;
    private final float field_236017_x_;
    public static int i;
    private final transient float[] field_236018_y_;
    private static transient float[] Floats;

    public static dimensionType func_236019_a_() {
        return EXAMPLE_TYPE;
    }

    @OnlyIn(Dist.CLIENT)
    public static dimensionType func_241507_b_() {
        return DIMENSION_TYPE;
    }

    public dimensionType() {
        this(FixedTime, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Int, Magnifier, Resource_Location, Float);
        Magnifier = this.magnifier;
    }

    public dimensionType(OptionalLong p_i241242_1_, boolean p_i241242_2_, boolean p_i241242_3_, boolean p_i241242_4_, boolean p_i241242_5_, boolean p_i241242_6_, boolean p_i241242_7_, boolean p_i241242_8_, boolean p_i241242_9_, boolean p_i241242_10_, int p_i241242_11_, ResourceLocation p_i241242_12_, float p_i241242_13_) {
        this(p_i241242_1_, p_i241242_2_, p_i241242_3_, p_i241242_4_, p_i241242_5_, p_i241242_6_, false, p_i241242_7_, p_i241242_8_, p_i241242_9_, p_i241242_10_, p_i241242_11_, FuzzedBiomeMagnifier.INSTANCE, p_i241242_12_, p_i241242_13_);
    }

    public dimensionType(OptionalLong optionalLong, boolean hasSkyLight, boolean hasCelling, boolean UltraWarm, boolean Natural, boolean Shrunk, boolean p_i241243_7_, boolean piglinSafe, boolean bedWorks, boolean respawnAnchorWorks, boolean hasRaids, int logicalHeight, IBiomeMagnifier magnifier, ResourceLocation resourceLocation, float p_i241243_15_) {
        this.fixedTime = optionalLong;
        this.hasSkyLight = hasSkyLight;
        this.hasCeiling = hasCelling;
        this.ultraWarm = UltraWarm;
        this.natural = Natural;
        this.shrunk = Shrunk;
        this.field_236015_u_ = p_i241243_7_;
        this.piglinSafe = piglinSafe;
        this.bedWorks = bedWorks;
        this.respawnAnchorWorks = respawnAnchorWorks;
        this.hasRaids = hasRaids;
        this.logicalHeight = logicalHeight;
        this.magnifier = magnifier;
        this.resourceLocation = resourceLocation;
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

    public static DataResult<RegistryKey<World>> dataResult(Dynamic<?> p_236025_0_) {
        Optional<Number> optional = p_236025_0_.asNumber().result();
        if (optional.isPresent()) {
            if (i == -1) {
                return DataResult.success(world.field_234919_h_);
            }

            if (i == 0) {
                return DataResult.success(world.field_234918_g_);
            }

            if (i == 1) {
                return DataResult.success(world.field_234920_i_);
            }
        }

        return world.field_234917_f_.parse(p_236025_0_);
    }

    public static SimpleRegistry<dimension> simpleRegistry(long l) {
        SimpleRegistry<Dimension> simpleregistry = new SimpleRegistry<>(Registry.DIMENSION_KEY, Lifecycle.experimental());
        simpleregistry.register(Dimension.THE_NETHER, new Dimension(() -> NETHER_TYPE, NetherChunkGenerator(l)));
        simpleregistry.register(Dimension.THE_END, new Dimension(() -> END_TYPE, EndChunkGenerator(l)));
        simpleregistry.func_239662_d_(Dimension.THE_NETHER);
        simpleregistry.func_239662_d_(Dimension.THE_END);
        return DimensionTypeInit.SimpleRegistry(l);
    }

    public static IDynamicRegistries.Impl impl(IDynamicRegistries.Impl impl) {
        impl.func_239774_a_(OVERWORLD, OVERWORLD_TYPE);
        impl.func_239774_a_(field_241497_i_, field_241498_j_);
        impl.func_239774_a_(THE_NETHER, NETHER_TYPE);
        impl.func_239774_a_(THE_END, END_TYPE);
        return DimensionTypeInit.Impl(impl);
    }

    private static ChunkGenerator EndChunkGenerator(long p_236038_0_) {
        return new NoiseChunkGenerator(new EndBiomeProvider(p_236038_0_), p_236038_0_, ModDimensionSettings.Preset.END.getSettings());
    }

    private static ChunkGenerator NetherChunkGenerator(long l) {
        return new NoiseChunkGenerator(NetherBiomeProvider.Preset.field_235288_b_.func_235292_a_(l), l, ModDimensionSettings.Preset.NETHER.getSettings());
    }

    public static File file(RegistryKey<World> WorldRegistryKey, RegistryKey<world> worldRegistryKey) {
        if (WorldRegistryKey == world.field_234918_g_) {
            return file;
        } else if (WorldRegistryKey == world.field_234920_i_) {
            return new File(file, "DIM1");
        } else if (worldRegistryKey == WorldInit.EXAMPLE) {
            return new File(file, string("DIM_1"));
        } else {
            return WorldRegistryKey == world.field_234919_h_ ? new File(file, "DIM-1") : new File(file, "dimensions/" + worldRegistryKey.func_240901_a_().getNamespace() + "/" + worldRegistryKey.func_240901_a_().getPath());
        }
    }

    public static String string(String child) {
        String string = "ervin_mod_1:";
        return string + child;
    }

    public boolean hasSkyLight() {
        return this.hasSkyLight;
    }

    public boolean hasCeiling() {
        return this.hasCeiling;
    }

    public boolean ultraWarm() {
        return this.ultraWarm;
    }

    public boolean natural() {
        return this.natural;
    }

    public boolean shrunk() {
        return this.shrunk;
    }

    public boolean piglinSafe() {
        return this.piglinSafe;
    }

    public boolean bedWorks() {
        return this.bedWorks;
    }

    public boolean respawnAnchorWorks() {
        return this.respawnAnchorWorks;
    }

    public boolean hasRaids() {
        return this.hasRaids;
    }

    public int logicalHeight() {
        return this.logicalHeight;
    }

    public boolean func_236046_h_() {
        return this.field_236015_u_;
    }

    public IBiomeMagnifier getMagnifier() {
        return this.magnifier;
    }

    public boolean fixedTime() {
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

    public static class T extends dimensionType {
        public static final long exampleLong = 24000L;
    }
}
