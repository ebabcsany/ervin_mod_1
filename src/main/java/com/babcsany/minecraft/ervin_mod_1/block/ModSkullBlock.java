package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class ModSkullBlock extends SkullBlock {
   public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_0_15;
   protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

   public ModSkullBlock(ISkullType type, Properties properties) {
      super(type, properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(ROTATION, Integer.valueOf(0)));
   }

   public enum Types implements ISkullType {
      SKELETON,
      WITHER_SKELETON,
      PLAYER,
      ZOMBIE,
      CREEPER,
      ZUR,
      DRAGON;
   }
}