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

public class ExampleRuinedPortalFeature extends Feature<NoFeatureConfig> {

    private static final ResourceLocation STRUCTURE_GIANT_PORTAL_01 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/giant_portal_1");
    private static final ResourceLocation STRUCTURE_GIANT_PORTAL_02 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/giant_portal_2");
    private static final ResourceLocation STRUCTURE_GIANT_PORTAL_03 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/giant_portal_3");
    private static final ResourceLocation STRUCTURE_PORTAL_01 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_1");
    private static final ResourceLocation STRUCTURE_PORTAL_02 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_2");
    private static final ResourceLocation STRUCTURE_PORTAL_03 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_3");
    private static final ResourceLocation STRUCTURE_PORTAL_04 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_4");
    private static final ResourceLocation STRUCTURE_PORTAL_05 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_5");
    private static final ResourceLocation STRUCTURE_PORTAL_06 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_6");
    private static final ResourceLocation STRUCTURE_PORTAL_07 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_7");
    private static final ResourceLocation STRUCTURE_PORTAL_08 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_8");
    private static final ResourceLocation STRUCTURE_PORTAL_09 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_9");
    private static final ResourceLocation STRUCTURE_PORTAL_010 = new ResourceLocation(Ervin_mod_1.MOD_ID, "ruined_portal/example_biome/portal_10");
    private static final ResourceLocation[] FOSSILS = new ResourceLocation[] { STRUCTURE_GIANT_PORTAL_01, STRUCTURE_GIANT_PORTAL_02,
            STRUCTURE_GIANT_PORTAL_03, STRUCTURE_PORTAL_01, STRUCTURE_PORTAL_02, STRUCTURE_PORTAL_03,
            STRUCTURE_PORTAL_04, STRUCTURE_PORTAL_05, STRUCTURE_PORTAL_06, STRUCTURE_PORTAL_07, STRUCTURE_PORTAL_08, STRUCTURE_PORTAL_09, STRUCTURE_PORTAL_010 };

    public ExampleRuinedPortalFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean place(IWorld worldIn, ChunkGenerator generator, Random rand,
                         BlockPos pos, NoFeatureConfig config) {
        Random random = worldIn.getRandom();
        Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
        Template template = ((ServerWorld) worldIn.getWorld()).getStructureTemplateManager()
                .getTemplateDefaulted(FOSSILS[random.nextInt(FOSSILS.length)]);
        ChunkPos chunkpos = new ChunkPos(pos);
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation)
                .setBoundingBox(new MutableBoundingBox(chunkpos.getXStart(), 66, chunkpos.getZStart(),
                        chunkpos.getXEnd(), 831, chunkpos.getZEnd()))
                .setBoundingBox(new MutableBoundingBox(chunkpos.getXStart(), 364, chunkpos.getZEnd(),
                        chunkpos.getZStart(), 895, chunkpos.getXEnd()))
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

    @Override
    public boolean func_230362_a_(ISeedReader p_230362_1_, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random p_230362_4_, BlockPos p_230362_5_, NoFeatureConfig p_230362_6_) {
        return false;
    }
}