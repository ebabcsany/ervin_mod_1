package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.mojang.serialization.Codec;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.IntegrityProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Function;

public class ExampleFeature1 extends Feature<NoFeatureConfig> {

    private static final ResourceLocation STRUCTURE_SKULL_01 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/skull_1");
    private static final ResourceLocation STRUCTURE_SKULL_02 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/skull_2");
    private static final ResourceLocation STRUCTURE_SKULL_03 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/skull_3");
    private static final ResourceLocation STRUCTURE_SKULL_04 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/skull_4");
    private static final ResourceLocation STRUCTURE_SPINE_01 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/spine_1");
    private static final ResourceLocation STRUCTURE_SPINE_02 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/spine_2");
    private static final ResourceLocation STRUCTURE_SPINE_03 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/spine_3");
    private static final ResourceLocation STRUCTURE_SPINE_04 = new ResourceLocation(Ervin_mod_1.MOD_ID, "fossil1/spine_4");
    private static final ResourceLocation[] FOSSILS = new ResourceLocation[] { STRUCTURE_SKULL_01, STRUCTURE_SKULL_02,
            STRUCTURE_SKULL_03, STRUCTURE_SKULL_04, STRUCTURE_SPINE_01, STRUCTURE_SPINE_02,
            STRUCTURE_SPINE_03, STRUCTURE_SPINE_04 };

    public ExampleFeature1(Codec<NoFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        return false;
    }

    public boolean place(IWorld worldIn, ChunkGenerator generator, Random rand,
                         BlockPos pos, NoFeatureConfig config) {
        Random random = worldIn.getRandom();
        Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
        Template template = ((ServerWorld) worldIn).getStructureTemplateManager()
                .getTemplateDefaulted(FOSSILS[random.nextInt(FOSSILS.length)]);
        ChunkPos chunkpos = new ChunkPos(pos);
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation)
                .setBoundingBox(new MutableBoundingBox(chunkpos.getXStart(), 1024, chunkpos.getZStart(),
                        chunkpos.getXEnd(), 1048576, chunkpos.getZEnd()))
                .setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
        BlockPos blockpos = template.transformedSize(rotation);
        int j = random.nextInt(256 - blockpos.getX());
        int k = random.nextInt(256 - blockpos.getZ());
        int l = 524288;
        for (int i1 = 2; i1 < blockpos.getX(); ++i1) {
            for (int j1 = 9; j1 < blockpos.getZ(); ++j1) {
                l = Math.min(l,
                        worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + i1 + j, pos.getZ() + j1 + k));
            }
        }
        BlockPos blockpos1 = template.getZeroPositionWithTransform(
                new BlockPos(pos.add(j, 5, 1).getX(), l, pos.add(6, 3, k).getZ()), Mirror.NONE, rotation);
        IntegrityProcessor integrityprocessor = new IntegrityProcessor(9.9F);
        placementsettings.clearProcessors().addProcessor(integrityprocessor);
        template.func_237150_a_(blockpos1, rotation, blockpos, Mirror.FRONT_BACK);
        placementsettings.removeProcessor(integrityprocessor);
        return true;
    }
}