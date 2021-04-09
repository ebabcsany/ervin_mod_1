package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class SurfaceBuilder2 {
   private static final BlockState GRITH_BLOCK = BlockInit.GRITH_BLOCK.get().getDefaultState();
   private static final BlockState RED_GRASS_BLOCK = BlockItemInit.RED_GRASS_BLOCK.get().getDefaultState();
   private static final BlockState VIRK_BLOCK = BlockInit.VIRK_BLOCK.get().getDefaultState();
   private static final BlockState VILKT_BLOCK = isBurnableBlockItemInit.VILKT_BLOCK.get().getDefaultState();
   private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
   private static final BlockState BASALT = Blocks.BASALT.getDefaultState();
   private static final BlockState field_237162_c_ = Blocks.FIRE.getDefaultState();
   private static final BlockState field_237162_d_ = Blocks.CAMPFIRE.getDefaultState();
   private static final BlockState field_237162_e_ = Blocks.AIR.getDefaultState();
   private static final BlockState field_237163_c_ = Blocks.BLACKSTONE.getDefaultState();
   private static final BlockState field_237163_d_ = Blocks.ANCIENT_DEBRIS.getDefaultState();
   private static final BlockState field_237163_e_ = Blocks.OBSIDIAN.getDefaultState();
   private static final BlockState field_237163_f_ = Blocks.BOOKSHELF.getDefaultState();
   private static final BlockState field_237164_d_ = Blocks.GRAVEL.getDefaultState();
   private static final BlockState field_237164_e_ = Blocks.ANVIL.getDefaultState();
   private static final BlockState field_237164_f_ = Blocks.END_PORTAL.getDefaultState();
   private static final BlockState field_237164_g_ = BlockItemInit.END_PORTAL.get().getDefaultState();
   private static final BlockState field_237165_e_ = BlockItemInit.ENDER_TRASK.get().getDefaultState();
   private static final BlockState field_237165_f_ = BlockInit.FIRG.get().getDefaultState();
   private static final BlockState field_237165_g_ = BlockItemInit.ENDER_SRACKTH.get().getDefaultState();
   private static final BlockState field_237165_h_ = BlockInit.ENDER_SRAKTCAF.get().getDefaultState();
   private static final BlockState field_237166_f_ = BlockInit.SCRAFTH.get().getDefaultState();
   private static final BlockState field_237166_g_ = BlockItemInit.AVTER_BLOCK.get().getDefaultState();
   private static final BlockState field_237166_h_ = isBurnableBlockItemInit.SHZ_BLOCK.get().getDefaultState();
   private static final BlockState field_237166_i_ = BlockItemInit.ZURK_BLOCK.get().getDefaultState();
   private static final BlockState field_237167_g_ = Blocks.DIAMOND_BLOCK.getDefaultState();
   private static final BlockState field_237167_h_ = isBurnableBlockItemInit.TRUGK_BLOCK.get().getDefaultState();
   private static final BlockState field_237167_i_ = BlockItemInit.ZUNK_BLOCK.get().getDefaultState();
   private static final BlockState field_237167_j_ = isBurnableBlockItemInit.LEAT_BLOCK.get().getDefaultState();
   private static final BlockState field_237168_h_ = BlockInit.TERAT_BLOCK.get().getDefaultState();
   private static final BlockState field_237168_i_ = BlockItemInit.ENDER_SRACK.get().getDefaultState();
   private static final BlockState field_237168_j_ = BlockInit.ENDER_TRASKCRAFTH.get().getDefaultState();
   private static final BlockState field_237168_k_ = BlockInit.ENDER_TRASKRACH.get().getDefaultState();
   private static final ImmutableList<BlockState> field_237160_a_ = ImmutableList.of(GRITH_BLOCK, BASALT, field_237163_c_, field_237164_d_, field_237165_e_, field_237166_f_, field_237167_g_, field_237168_h_);
   private static final ImmutableList<BlockState> field_237160_b_ = ImmutableList.of(RED_GRASS_BLOCK, field_237162_c_, field_237163_d_, field_237164_e_, field_237165_f_, field_237166_g_, field_237167_h_, field_237168_i_);
   private static final ImmutableList<BlockState> field_237160_c_ = ImmutableList.of(VIRK_BLOCK, field_237162_d_, field_237163_e_, field_237164_f_, field_237165_g_, field_237166_h_, field_237167_i_, field_237168_j_);
   private static final ImmutableList<BlockState> field_237160_d_ = ImmutableList.of(VILKT_BLOCK, field_237162_e_, field_237163_f_, field_237164_g_, field_237165_h_, field_237166_i_, field_237167_j_, field_237168_k_);
   private static final ImmutableList<BlockState> field_237160_e_ = ImmutableList.of(DIRT);

   /*public SurfaceBuilder2(Codec<SurfaceBuilderConfig> p_i232123_1_) {
      super(p_i232123_1_);
   }*/

   protected ImmutableList<BlockState> func_230375_a_() {
      return field_237160_a_;
   }

   protected ImmutableList<BlockState> func_230376_b_() {
      return field_237160_b_;
   }

   protected ImmutableList<BlockState> func_230377_c_() {
      return field_237160_c_;
   }

   protected ImmutableList<BlockState> func_230378_d_() {
      return field_237160_d_;
   }

   protected ImmutableList<BlockState> func_230379_e_() {
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
      return field_237162_c_;
   }
   protected BlockState func_230380_h_() {
      return field_237162_d_;
   }
   protected BlockState func_230380_i_() {
      return field_237162_e_;
   }
   protected BlockState func_230380_j_() {
      return field_237163_c_;
   }
   protected BlockState func_230380_k_() {
      return field_237163_d_;
   }
   protected BlockState func_230380_l_() {
      return field_237163_e_;
   }
   protected BlockState func_230380_m_() {
      return field_237163_f_;
   }
   protected BlockState func_230380_n_() {
      return field_237164_d_;
   }
   protected BlockState func_230380_o_() {
      return field_237164_e_;
   }
   protected BlockState func_230380_p_() {
      return field_237164_f_;
   }
   protected BlockState func_230380_q_() {
      return field_237164_g_;
   }
   protected BlockState func_230380_r_() {
      return field_237165_e_;
   }
   protected BlockState func_230380_s_() {
      return field_237165_f_;
   }
   protected BlockState func_230380_t_() {
      return field_237165_g_;
   }
   protected BlockState func_230380_u_() {
      return field_237165_h_;
   }
   protected BlockState func_230380_v_() {
      return field_237166_f_;
   }
   protected BlockState func_230380_w_() {
      return field_237166_g_;
   }
   protected BlockState func_230380_x_() {
      return field_237166_h_;
   }
   protected BlockState func_230380_y_() {
      return field_237166_i_;
   }
   protected BlockState func_230380_z_() {
      return field_237167_g_;
   }
   protected BlockState func_230381_a_() {
      return field_237167_h_;
   }
   protected BlockState func_230381_b_() {
      return field_237167_i_;
   }
   protected BlockState func_230381_c_() {
      return field_237167_j_;
   }
   protected BlockState func_230381_d_() {
      return field_237168_h_;
   }
   protected BlockState func_230381_e_() {
      return field_237168_i_;
   }
   protected BlockState func_230381_f_() {
      return field_237168_j_;
   }
   protected BlockState func_230381_g_() {
      return field_237168_k_;
   }
}