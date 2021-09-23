package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.forge.event.ForgeEventFactory;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.world.server.ModServerWorld;
import com.babcsany.minecraft.world.world;
import com.google.common.cache.LoadingCache;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class ExamplePortalBlock extends PortalBlock {
   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
   protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
   protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
   protected com.babcsany.minecraft.entity.EntityType<?> entityType1;
   protected Entity entity;

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
   public void randomTick(BlockState state, ModServerWorld worldIn, BlockPos pos, Random random) {
      if (worldIn.dimensionType().natural() && worldIn.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING) && random.nextInt(2000) < worldIn.getDifficulty().getId()) {
         while(worldIn.getBlockState(pos).isIn(this)) {
            pos = pos.down();
         }

         if (worldIn.getBlockState(pos).canEntitySpawn(worldIn, pos, EntityInit.ZUR_ENTITY)) {
            Entity entity = this.spawn(EntityInit.ZUR_ENTITY, worldIn, null, null, null, pos.up(), SpawnReason.STRUCTURE, false, false);
            if (entity != null) {
               entity.timeUntilPortal = entity.getPortalCooldown();
            }
         }
      }

   }

   @Nullable
   public <T extends Entity> T spawn(EntityType<T> entity, world worldIn, @Nullable CompoundNBT compound, @Nullable ITextComponent customName, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220342_7_, boolean p_220342_8_) {
      T t = this.create(entity, worldIn, compound, customName, playerIn, pos, reason, p_220342_7_, p_220342_8_);
      if (t instanceof MobEntity && ForgeEventFactory.doSpecialSpawn((MobEntity) t, worldIn, pos.getX(), pos.getY(), pos.getZ(), null, reason)) return null;
      worldIn.addEntity(Objects.requireNonNull(t));
      return t;
   }

   public <T extends Entity> T create(EntityType<T> entityType, world worldIn, @Nullable CompoundNBT compound, @Nullable ITextComponent customName, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220349_7_, boolean p_220349_8_) {
      entityType1.create(entityType, worldIn);
      T t = (T) entityType1.create(entityType, worldIn);
      if (entity == null) {
         return null;
      } else {
         double d0;
         if (p_220349_7_) {
            entity.setPosition((double)pos.getX() + 0.5D, pos.getY() + 1, (double)pos.getZ() + 0.5D);
            d0 = func_208051_a(worldIn, pos, p_220349_8_, entity.getBoundingBox());
         } else {
            d0 = 0.0D;
         }

         entity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
         if (entity instanceof MobEntity) {
            MobEntity mobentity = (MobEntity)entity;
            mobentity.rotationYawHead = mobentity.rotationYaw;
            mobentity.renderYawOffset = mobentity.rotationYaw;
            mobentity.onInitialSpawn(worldIn, worldIn.getDifficultyForLocation(mobentity.getPosition()), reason, null, compound);
            mobentity.playAmbientSound();
         }

         if (customName != null && entity instanceof LivingEntity) {
            entity.setCustomName(customName);
         }

         applyItemNBT(worldIn, playerIn, entity, compound);
         return t;
      }
   }

   protected static double func_208051_a(IWorldReader worldReader, BlockPos pos, boolean p_208051_2_, AxisAlignedBB axisAlignedBB) {
      AxisAlignedBB axisalignedbb = new AxisAlignedBB(pos);
      if (p_208051_2_) {
         axisalignedbb = axisalignedbb.expand(0.0D, -1.0D, 0.0D);
      }

      Stream<VoxelShape> stream = worldReader.func_234867_d_(null, axisalignedbb, (entity) -> true);
      return 1.0D + VoxelShapes.getAllowedOffset(Direction.Axis.Y, axisAlignedBB, stream, p_208051_2_ ? -2.0D : -1.0D);
   }

   public static void applyItemNBT(world worldIn, @Nullable PlayerEntity player, @Nullable Entity spawnedEntity, @Nullable CompoundNBT itemNBT) {
      if (itemNBT != null && itemNBT.contains("EntityTag", 10)) {
         MinecraftServer minecraftserver = worldIn.getServer();
         if (minecraftserver != null && spawnedEntity != null) {
            if (worldIn.isRemote || !spawnedEntity.ignoreItemEntityData() || player != null && minecraftserver.getPlayerList().canSendCommands(player.getGameProfile())) {
               CompoundNBT compoundnbt = spawnedEntity.writeWithoutTypeId(new CompoundNBT());
               UUID uuid = spawnedEntity.getUniqueID();
               compoundnbt.merge(itemNBT.getCompound("EntityTag"));
               spawnedEntity.setUniqueId(uuid);
               spawnedEntity.read(compoundnbt);
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

   public void onEntityCollision(BlockState state, world worldIn, BlockPos pos, Living entityIn) {
      if (!entityIn.isPassenger() && !entityIn.isBeingRidden() && entityIn.isNonBoss()) {
         entityIn.setExamplePortal(pos);
      }

   }

   /* *
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
    * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
    * of whether the block can receive random update ticks
    */
   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, world worldIn, BlockPos pos, Random rand) {
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

   /**
    * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
    * blockstate.
    * @deprecated call via {@link BlockState#rotate(Rotation)} whenever possible. Implementing/overriding is
    * fine.
    */
   public BlockState rotate(BlockState state, Rotation rot) {
      switch(rot) {
      case COUNTERCLOCKWISE_90:
      case CLOCKWISE_90:
         switch(state.get(AXIS)) {
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
      public static final int FLAGS = 18;
      public static final int ZERO = 0;
      public static final int _1_ = 1;
      public static final int MIN_HEIGHT = 3;
      public static final int MAX_HEIGHT = 138;
      public static final int MIN_WIDTH = 3;
      public static final int MAX_WIDTH = 114;

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

         for(BlockPos blockpos = pos; pos.getY() > blockpos.getY() - MAX_HEIGHT && pos.getY() > ZERO && this.canConnect(worldIn.getBlockState(pos.down())); pos = pos.down()) {
         }

         int i = this.getDistanceUntilEdge(pos, this.leftDir) - _1_;
         if (i >= ZERO) {
            this.bottomLeft = pos.offset(this.leftDir, i);
            this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
            if (this.width < MIN_WIDTH || this.width > MAX_WIDTH) {
               this.bottomLeft = null;
               this.width = ZERO;
            }
         }

         if (this.bottomLeft != null) {
            this.height = this.calculatePortalHeight();
         }

      }

      protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
         int i;
         for(i = ZERO; i < MAX_HEIGHT + _1_; ++i) {
            BlockPos blockpos = pos.offset(directionIn, i);
            if (!this.canConnect(this.world.getBlockState(blockpos)) || !this.world.getBlockState(blockpos.down()).isExamplePortalFrame(world, blockpos.down())) {
               break;
            }
         }

         return this.world.getBlockState(pos.offset(directionIn, i)).isExamplePortalFrame(world, pos.offset(directionIn, i)) ? i : ZERO;
      }

      public int getHeight() {
         return this.height;
      }

      public int getWidth() {
         return this.width;
      }

      protected int calculatePortalHeight() {
         label56:
         for(this.height = ZERO; this.height < MAX_HEIGHT; ++this.height) {
            for(int i = ZERO; i < this.width; ++i) {
               BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
               BlockState blockstate = this.world.getBlockState(blockpos);
               if (!this.canConnect(blockstate)) {
                  break label56;
               }

               if (blockstate.isIn(BlockInit.EXAMPLE_PORTAL_BLOCK.get())) {
                  ++this.examplePortalBlockCount;
               }

               if (i == ZERO) {
                  if (!this.world.getBlockState(blockpos.offset(this.leftDir)).isExamplePortalFrame(world, blockpos.offset(this.leftDir))) {
                     break label56;
                  }
               } else if (i == this.width - _1_ && !this.world.getBlockState(blockpos.offset(this.rightDir)).isExamplePortalFrame(world, blockpos.offset(this.rightDir))) {
                  break label56;
               }
            }
         }

         for(int j = ZERO; j < this.width; ++j) {
            if (!this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height)).isExamplePortalFrame(world, this.bottomLeft.offset(this.rightDir, j).up(this.height))) {
               this.height = ZERO;
               break;
            }
         }

         if (this.height <= MAX_HEIGHT && this.height >= MIN_HEIGHT) {
            return this.height;
         } else {
            this.bottomLeft = null;
            this.width = ZERO;
            this.height = ZERO;
            return ZERO;
         }
      }

      protected boolean canConnect(BlockState pos) {
         return pos.isAir() || pos.isIn(BlockTags.FIRE) || pos.isIn(BlockInit.EXAMPLE_PORTAL_BLOCK.get());
      }

      public boolean isValid() {
         return this.bottomLeft != null && this.width >= MIN_WIDTH && this.width <= MAX_WIDTH && this.height >= MIN_HEIGHT && this.height <= MAX_HEIGHT;
      }

      public void placeExamplePortalBlocks() {
         for(int i = ZERO; i < this.width; ++i) {
            BlockPos blockpos = Objects.requireNonNull(this.bottomLeft).offset(this.rightDir, i);

            for(int j = ZERO; j < this.height; ++j) {
               this.world.setBlockState(blockpos.up(j), BlockInit.EXAMPLE_PORTAL_BLOCK.get().getDefaultState().with(ExamplePortalBlock.AXIS, this.axis), FLAGS);
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