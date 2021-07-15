package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.init.EntityInit;
import com.google.common.cache.LoadingCache;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class ExamplePortalBlock extends Block {
   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
   protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
   protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
   public int timeUntilExamplePortal;
   protected boolean inExamplePortal;
   protected BlockPos lastExamplePortalPos;
   protected Vector3d lastExamplePortalVec;
   private Vector3d positionVec;
   protected Direction teleportDirection;
   public World world;

   public ExamplePortalBlock(Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
   }

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      switch(state.get(AXIS)) {
      case Z:
         return Z_AABB;
      case X:
      default:
         return X_AABB;
      }
   }

   /**
    * Performs a random tick on a block.
    */
   public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      if (worldIn.func_230315_m_().func_236043_f_() && worldIn.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING) && random.nextInt(2000) < worldIn.getDifficulty().getId()) {
         while(worldIn.getBlockState(pos).isIn(this)) {
            pos = pos.down();
         }

         if (worldIn.getBlockState(pos).canEntitySpawn(worldIn, pos, EntityInit.ZUR_ENTITY)) {
            Entity entity = com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY.spawn(worldIn, null, null, null, pos.up(), SpawnReason.STRUCTURE, false, false);
            if (entity != null) {
               entity.timeUntilPortal = entity.getPortalCooldown();
            }
         }
      }

   }

   public static boolean trySpawnExamplePortal(IWorld world, BlockPos worldIn) {
      ExamplePortalBlock.Size exampleportalblock$size = isExamplePortal(world, worldIn);
      if (exampleportalblock$size != null && !com.babcsany.minecraft.ervin_mod_1.block.portal.Portal.onTrySpawnExamplePortal(world, worldIn, exampleportalblock$size)) {
         exampleportalblock$size.placeExamplePortalBlocks();
         return true;
      } else {
         return false;
      }
   }

   @Nullable
   public static ExamplePortalBlock.Size isExamplePortal(IWorld world, BlockPos worldIn) {
      ExamplePortalBlock.Size exampleportalblock$size = new ExamplePortalBlock.Size(world, worldIn, Direction.Axis.X);
      if (exampleportalblock$size.isValid() && exampleportalblock$size.examplePortalBlockCount == 0) {
         return exampleportalblock$size;
      } else {
         ExamplePortalBlock.Size exampleportalblock$size1 = new ExamplePortalBlock.Size(world, worldIn, Direction.Axis.Z);
         return exampleportalblock$size1.isValid() && exampleportalblock$size1.examplePortalBlockCount == 0 ? exampleportalblock$size1 : null;
      }
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      Direction.Axis direction$axis = facing.getAxis();
      Direction.Axis direction$axis1 = stateIn.get(AXIS);
      boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
      return !flag && !facingState.isIn(this) && !(new ExamplePortalBlock.Size(worldIn, currentPos, direction$axis1)).validatePortal() ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
   }

   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
      if (!entityIn.isPassenger() && !entityIn.isBeingRidden() && entityIn.isNonBoss()) {
         setExamplePortal(pos);
      }

   }

   public int getPortalCooldown() {
      return 300;
   }

   public void setExamplePortal(BlockPos pos) {
      if (this.timeUntilExamplePortal > 0) {
         this.timeUntilExamplePortal = this.getPortalCooldown();
      } else {
         if (!this.world.isRemote && !pos.equals(this.lastExamplePortalPos)) {
            this.lastExamplePortalPos = new BlockPos(pos);
            ExamplePortalBlock examplePortalBlock = (ExamplePortalBlock) BlockInit.EXAMPLE_PORTAL_BLOCK.get();
            BlockPattern.PatternHelper blockpattern$patternhelper = ExamplePortalBlock.createPatternHelper(this.world, this.lastExamplePortalPos);
            double d0 = blockpattern$patternhelper.getForwards().getAxis() == Direction.Axis.X ? (double)blockpattern$patternhelper.getFrontTopLeft().getZ() : (double)blockpattern$patternhelper.getFrontTopLeft().getX();
            double d1 = MathHelper.clamp(Math.abs(MathHelper.func_233020_c_((blockpattern$patternhelper.getForwards().getAxis() == Direction.Axis.X ? this.getPosZ() : this.getPosX()) - (double)(blockpattern$patternhelper.getForwards().rotateY().getAxisDirection() == Direction.AxisDirection.NEGATIVE ? 1 : 0), d0, d0 - (double)blockpattern$patternhelper.getWidth())), 0.0D, 1.0D);
            double d2 = MathHelper.clamp(MathHelper.func_233020_c_(this.getPosY() - 1.0D, blockpattern$patternhelper.getFrontTopLeft().getY(), blockpattern$patternhelper.getFrontTopLeft().getY() - blockpattern$patternhelper.getHeight()), 0.0D, 1.0D);
            this.lastExamplePortalVec = new Vector3d(d1, d2, 0.0D);
            this.teleportDirection = blockpattern$patternhelper.getForwards();
         }

         this.inExamplePortal = true;
      }
   }

   public final double getPosX() {
      return this.positionVec.x;
   }

   public final double getPosY() {
      return this.positionVec.y;
   }

   public final double getPosZ() {
      return this.positionVec.z;
   }

   /* *
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
    * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
    * of whether the block can receive random update ticks
    */
   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      if (rand.nextInt(100) == 0) {
         worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
      }

      for(int i = 0; i < 4; ++i) {
         double d0 = (double)pos.getX() + rand.nextDouble();
         double d1 = (double)pos.getY() + rand.nextDouble();
         double d2 = (double)pos.getZ() + rand.nextDouble();
         double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
         double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
         double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
         int j = rand.nextInt(2) * 2 - 1;
         if (!worldIn.getBlockState(pos.west()).isIn(this) && !worldIn.getBlockState(pos.east()).isIn(this)) {
            d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
            d3 = rand.nextFloat() * 2.0F * (float)j;
         } else {
            d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
            d5 = rand.nextFloat() * 2.0F * (float)j;
         }

         worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
      }

   }

   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
      return ItemStack.EMPTY;
   }

   /* *
    * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
    * blockstate.
    * @deprecated call via {@link IBlockState#withRotation(Rotation)} whenever possible. Implementing/overriding is
    * fine.
    */
   public BlockState rotate(BlockState state, Rotation rot) {
      switch(rot) {
      case COUNTERCLOCKWISE_90:
      case CLOCKWISE_90:
         switch((Direction.Axis)state.get(AXIS)) {
         case Z:
            return state.with(AXIS, Direction.Axis.X);
         case X:
            return state.with(AXIS, Direction.Axis.Z);
         default:
            return state;
         }
      default:
         return state;
      }
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(AXIS);
   }

   public static BlockPattern.PatternHelper createPatternHelper(IWorld world, BlockPos worldIn) {
      Direction.Axis direction$axis = Direction.Axis.Z;
      ExamplePortalBlock.Size exampleportalblock$size = new ExamplePortalBlock.Size(world, worldIn, Direction.Axis.X);
      LoadingCache<BlockPos, CachedBlockInfo> loadingcache = BlockPattern.createLoadingCache(world, true);
      if (!exampleportalblock$size.isValid()) {
         direction$axis = Direction.Axis.X;
         exampleportalblock$size = new ExamplePortalBlock.Size(world, worldIn, Direction.Axis.Z);
      }

      if (!exampleportalblock$size.isValid()) {
         return new BlockPattern.PatternHelper(worldIn, Direction.NORTH, Direction.UP, loadingcache, 1, 1, 1);
      } else {
         int[] aint = new int[Direction.AxisDirection.values().length];
         Direction direction = exampleportalblock$size.rightDir.rotateYCCW();
         BlockPos blockpos = exampleportalblock$size.bottomLeft.up(exampleportalblock$size.getHeight() - 1);

         for(Direction.AxisDirection direction$axisdirection : Direction.AxisDirection.values()) {
            BlockPattern.PatternHelper blockpattern$patternhelper = new BlockPattern.PatternHelper(direction.getAxisDirection() == direction$axisdirection ? blockpos : blockpos.offset(exampleportalblock$size.rightDir, exampleportalblock$size.getWidth() - 1), Direction.getFacingFromAxis(direction$axisdirection, direction$axis), Direction.UP, loadingcache, exampleportalblock$size.getWidth(), exampleportalblock$size.getHeight(), 1);

            for(int i = 0; i < exampleportalblock$size.getWidth(); ++i) {
               for(int j = 0; j < exampleportalblock$size.getHeight(); ++j) {
                  CachedBlockInfo cachedblockinfo = blockpattern$patternhelper.translateOffset(i, j, 1);
                  if (!cachedblockinfo.getBlockState().isAir()) {
                     ++aint[direction$axisdirection.ordinal()];
                  }
               }
            }
         }

         Direction.AxisDirection direction$axisdirection1 = Direction.AxisDirection.POSITIVE;

         for(Direction.AxisDirection direction$axisdirection2 : Direction.AxisDirection.values()) {
            if (aint[direction$axisdirection2.ordinal()] < aint[direction$axisdirection1.ordinal()]) {
               direction$axisdirection1 = direction$axisdirection2;
            }
         }

         return new BlockPattern.PatternHelper(direction.getAxisDirection() == direction$axisdirection1 ? blockpos : blockpos.offset(exampleportalblock$size.rightDir, exampleportalblock$size.getWidth() - 1), Direction.getFacingFromAxis(direction$axisdirection1, direction$axis), Direction.UP, loadingcache, exampleportalblock$size.getWidth(), exampleportalblock$size.getHeight(), 1);
      }
   }

   public static class Size {
      private final IWorld world;
      private final Direction.Axis axis;
      private final Direction rightDir;
      private final Direction leftDir;
      private int examplePortalBlockCount;
      @Nullable
      private BlockPos bottomLeft;
      private int height;
      private int width;

      public Size(IWorld worldIn, BlockPos pos, Direction.Axis axisIn) {
         this.world = worldIn;
         this.axis = axisIn;
         if (axisIn == Direction.Axis.X) {
            this.leftDir = Direction.EAST;
            this.rightDir = Direction.WEST;
         } else {
            this.leftDir = Direction.NORTH;
            this.rightDir = Direction.SOUTH;
         }

         for(BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.canConnect(worldIn.getBlockState(pos.down())); pos = pos.down()) {
         }

         int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
         if (i >= 0) {
            this.bottomLeft = pos.offset(this.leftDir, i);
            this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
            if (this.width < 2 || this.width > 21) {
               this.bottomLeft = null;
               this.width = 0;
            }
         }

         if (this.bottomLeft != null) {
            this.height = this.calculatePortalHeight();
         }

      }

      protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
         int i;
         for(i = 0; i < 22; ++i) {
            BlockPos blockpos = pos.offset(directionIn, i);
            if (!this.canConnect(this.world.getBlockState(blockpos)) || !this.world.getBlockState(blockpos.down()).isExamplePortalFrame(world, blockpos.down())) {
               break;
            }
         }

         return this.world.getBlockState(pos.offset(directionIn, i)).isExamplePortalFrame(world, pos.offset(directionIn, i)) ? i : 0;
      }

      public int getHeight() {
         return this.height;
      }

      public int getWidth() {
         return this.width;
      }

      protected int calculatePortalHeight() {
         label56:
         for(this.height = 0; this.height < 21; ++this.height) {
            for(int i = 0; i < this.width; ++i) {
               BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
               BlockState blockstate = this.world.getBlockState(blockpos);
               if (!this.canConnect(blockstate)) {
                  break label56;
               }

               if (blockstate.isIn(BlockInit.EXAMPLE_PORTAL_BLOCK.get())) {
                  ++this.examplePortalBlockCount;
               }

               if (i == 0) {
                  if (!this.world.getBlockState(blockpos.offset(this.leftDir)).isExamplePortalFrame(world, blockpos.offset(this.leftDir))) {
                     break label56;
                  }
               } else if (i == this.width - 1 && !this.world.getBlockState(blockpos.offset(this.rightDir)).isExamplePortalFrame(world, blockpos.offset(this.rightDir))) {
                  break label56;
               }
            }
         }

         for(int j = 0; j < this.width; ++j) {
            if (!this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height)).isExamplePortalFrame(world, this.bottomLeft.offset(this.rightDir, j).up(this.height))) {
               this.height = 0;
               break;
            }
         }

         if (this.height <= 34 && this.height >= 5) {
            return this.height;
         } else {
            this.bottomLeft = null;
            this.width = 0;
            this.height = 0;
            return 0;
         }
      }

      protected boolean canConnect(BlockState pos) {
         return pos.isAir() || pos.isIn(BlockTags.FIRE) || pos.isIn(BlockInit.EXAMPLE_PORTAL_BLOCK.get());
      }

      public boolean isValid() {
         return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
      }

      public void placeExamplePortalBlocks() {
         for(int i = 0; i < this.width; ++i) {
            BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);

            for(int j = 0; j < this.height; ++j) {
               this.world.setBlockState(blockpos.up(j), BlockInit.EXAMPLE_PORTAL_BLOCK.get().getDefaultState().with(ExamplePortalBlock.AXIS, this.axis), 18);
            }
         }

      }

      private boolean isExamplePortalCountValidForSize() {
         return this.examplePortalBlockCount >= this.width * this.height;
      }

      public boolean validatePortal() {
         return this.isValid() && this.isExamplePortalCountValidForSize();
      }
   }
}