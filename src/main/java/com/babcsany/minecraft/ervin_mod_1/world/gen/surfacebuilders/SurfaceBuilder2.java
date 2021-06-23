package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Comparator;
import java.util.Random;

public class SurfaceBuilder2 extends ValleySurfaceBuilder {
   private static final BlockState GRITH_BLOCK = BlockInit.GRITH_BLOCK.get().getDefaultState();
   private static final BlockState RED_GRASS_BLOCK = BlockItemInit.RED_GRASS_BLOCK.get().getDefaultState();
   private static final BlockState VIRK_BLOCK = BlockInit.VIRK_BLOCK.get().getDefaultState();
   private static final BlockState VILKT_BLOCK = isBurnableBlockItemInit.VILKT_BLOCK.get().getDefaultState();
   private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
   private static final BlockState BASALT = Blocks.BASALT.getDefaultState();
   private static final BlockState FIRE = Blocks.FIRE.getDefaultState();
   private static final BlockState CAMPFIRE = Blocks.CAMPFIRE.getDefaultState();
   private static final BlockState AIR = Blocks.AIR.getDefaultState();
   private static final BlockState BLACKSTONE = Blocks.BLACKSTONE.getDefaultState();
   private static final BlockState ANCIENT_DEBRIS = Blocks.ANCIENT_DEBRIS.getDefaultState();
   private static final BlockState OBSIDIAN = Blocks.OBSIDIAN.getDefaultState();
   private static final BlockState BOOKSHELF = Blocks.BOOKSHELF.getDefaultState();
   private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
   private static final BlockState ANVIL = Blocks.ANVIL.getDefaultState();
   private static final BlockState BLOCKS_END_PORTAL = Blocks.END_PORTAL.getDefaultState();
   private static final BlockState BLOCK_ITEM_INIT_END_PORTAL = BlockItemInit.END_PORTAL.get().getDefaultState();
   private static final BlockState ENDER_TRASK = BlockItemInit.ENDER_TRASK.get().getDefaultState();
   private static final BlockState FIRG = BlockInit.FIRG.get().getDefaultState();
   private static final BlockState ENDER_SRACKTH = BlockItemInit.ENDER_SRACKTH.get().getDefaultState();
   private static final BlockState ENDER_SRAKTCAF = BlockInit.ENDER_SRAKTCAF.get().getDefaultState();
   private static final BlockState SCRAFTH = BlockInit.SCRAFTH.get().getDefaultState();
   private static final BlockState AVTER_BLOCK = BlockItemInit.AVTER_BLOCK.get().getDefaultState();
   private static final BlockState SHZ_BLOCK = isBurnableBlockItemInit.SHZ_BLOCK.get().getDefaultState();
   private static final BlockState ZURK_BLOCK = BlockItemInit.ZURK_BLOCK.get().getDefaultState();
   private static final BlockState DIAMOND_BLOCK = Blocks.DIAMOND_BLOCK.getDefaultState();
   private static final BlockState TRUGK_BLOCK = isBurnableBlockItemInit.TRUGK_BLOCK.get().getDefaultState();
   private static final BlockState ZUNK_BLOCK = BlockInit.ZUNK_BLOCK.get().getDefaultState();
   private static final BlockState LEAT_BLOCK = isBurnableBlockItemInit.LEAT_BLOCK.get().getDefaultState();
   private static final BlockState TERAT_BLOCK = BlockInit.TERAT_BLOCK.get().getDefaultState();
   private static final BlockState ENDER_SRACK = BlockItemInit.ENDER_SRACK.get().getDefaultState();
   private static final BlockState ENDER_TRASKCRAFTH = BlockInit.ENDER_TRASKCRAFTH.get().getDefaultState();
   private static final BlockState ENDER_TRASKRACH = BlockInit.ENDER_TRASKRACH.get().getDefaultState();
   private static final ImmutableList<BlockState> field_237160_a_ = ImmutableList.of(GRITH_BLOCK, BASALT, BLACKSTONE, GRAVEL, ENDER_TRASK, SCRAFTH, DIAMOND_BLOCK, TERAT_BLOCK);
   private static final ImmutableList<BlockState> field_237160_b_ = ImmutableList.of(RED_GRASS_BLOCK, FIRE, ANCIENT_DEBRIS, ANVIL, FIRG, AVTER_BLOCK, TRUGK_BLOCK, ENDER_SRACK);
   private static final ImmutableList<BlockState> field_237160_c_ = ImmutableList.of(VIRK_BLOCK, CAMPFIRE, OBSIDIAN, BLOCKS_END_PORTAL, ENDER_SRACKTH, SHZ_BLOCK, ZUNK_BLOCK, ENDER_TRASKCRAFTH);
   private static final ImmutableList<BlockState> field_237160_d_ = ImmutableList.of(VILKT_BLOCK, AIR, BOOKSHELF, BLOCK_ITEM_INIT_END_PORTAL, ENDER_SRAKTCAF, ZURK_BLOCK, LEAT_BLOCK, ENDER_TRASKRACH);
   private static final ImmutableList<BlockState> field_237160_e_ = ImmutableList.of(DIRT);

   public SurfaceBuilder2(Codec<SurfaceBuilderConfig> p_i232136_1_) {
      super(p_i232136_1_);
   }

   protected ImmutableList<BlockState> func_230387_a_() {
      return field_237160_a_;
   }

   protected ImmutableList<BlockState> func_230388_b_() {
      return field_237160_b_;
   }

   protected ImmutableList<BlockState> func_230389_c_() {
      return field_237160_c_;
   }

   protected ImmutableList<BlockState> func_230390_d_() {
      return field_237160_d_;
   }

   protected ImmutableList<BlockState> func_230391_e_() {
      return field_237160_e_;
   }

   protected BlockState func_230380_a_() {
      return GRITH_BLOCK;
   }
   protected BlockState func_230380_b_() {
      return RED_GRASS_BLOCK;
   }
   protected BlockState func_230380_c_() {
      return VIRK_BLOCK;
   }
   protected BlockState func_230380_d_() {
      return VILKT_BLOCK;
   }
   protected BlockState func_230380_e_() {
      return DIRT;
   }
   protected BlockState func_230380_f_() {
      return BASALT;
   }
   protected BlockState func_230380_g_() {
      return FIRE;
   }
   protected BlockState func_230380_h_() {
      return CAMPFIRE;
   }
   protected BlockState func_230380_i_() {
      return AIR;
   }
   protected BlockState func_230380_j_() {
      return BLACKSTONE;
   }
   protected BlockState func_230380_k_() {
      return ANCIENT_DEBRIS;
   }
   protected BlockState func_230380_l_() {
      return OBSIDIAN;
   }
   protected BlockState func_230380_m_() {
      return BOOKSHELF;
   }
   protected BlockState func_230380_n_() {
      return GRAVEL;
   }
   protected BlockState func_230380_o_() {
      return ANVIL;
   }
   protected BlockState func_230380_p_() {
      return BLOCKS_END_PORTAL;
   }
   protected BlockState func_230380_q_() {
      return BLOCK_ITEM_INIT_END_PORTAL;
   }
   protected BlockState func_230380_r_() {
      return ENDER_TRASK;
   }
   protected BlockState func_230380_s_() {
      return FIRG;
   }
   protected BlockState func_230380_t_() {
      return ENDER_SRACKTH;
   }
   protected BlockState func_230380_u_() {
      return ENDER_SRAKTCAF;
   }
   protected BlockState func_230380_v_() {
      return SCRAFTH;
   }
   protected BlockState func_230380_w_() {
      return AVTER_BLOCK;
   }
   protected BlockState func_230380_x_() {
      return SHZ_BLOCK;
   }
   protected BlockState func_230380_y_() {
      return ZURK_BLOCK;
   }
   protected BlockState func_230380_z_() {
      return DIAMOND_BLOCK;
   }
   protected BlockState func_230381_a_() {
      return TRUGK_BLOCK;
   }
   protected BlockState func_230381_b_() {
      return ZUNK_BLOCK;
   }
   protected BlockState func_230381_c_() {
      return LEAT_BLOCK;
   }
   protected BlockState func_230381_d_() {
      return TERAT_BLOCK;
   }
   protected BlockState func_230381_e_() {
      return ENDER_SRACK;
   }
   protected BlockState func_230381_f_() {
      return ENDER_TRASKCRAFTH;
   }
   protected BlockState func_230381_g_() {
      return ENDER_TRASKRACH;
   }
}