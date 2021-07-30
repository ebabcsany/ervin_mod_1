package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.init.sound.SoundInit;
import com.babcsany.minecraft.ervin_mod_1.world.storage.loot.LootTables1;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.Property;
import net.minecraft.state.StateHolder;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public abstract class AbstractModBlock extends ForgeRegistryEntry<Block> {
    protected static final Direction[] UPDATE_ORDER = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH, Direction.DOWN, Direction.UP};
    public final Material material;
    protected final boolean canCollide;
    protected final float blastResistance;
    /**
     * Flags whether or not this block is of a type that needs random ticking. Ref-counted by ExtendedBlockStorage in
     * order to broadly cull a chunk from the random chunk update list for efficiency's sake.
     */
    protected final boolean ticksRandomly;
    protected final SoundType soundType;
    /** Determines how much velocity is maintained while moving on top of this block */
    protected final float slipperiness;
    protected final float speedFactor;
    protected final float jumpFactor;
    protected final boolean variableOpacity;
    protected final AbstractModBlock.Properties modProperties;
    protected static AbstractBlock.Properties properties1;
    @Nullable
    protected ResourceLocation lootTable;

    public AbstractModBlock(AbstractModBlock.Properties properties) {
        this.material = properties.material;
        this.canCollide = properties.blocksMovement;
        this.lootTable = properties.location;
        this.blastResistance = properties.resistance;
        this.ticksRandomly = properties.ticksRandomly;
        this.soundType = properties.soundType;
        this.slipperiness = properties.slipperiness;
        this.speedFactor = properties.speedFactor;
        this.jumpFactor = properties.jumpFactor;
        this.variableOpacity = properties.variableOpacity;
        this.modProperties = properties;
        final ResourceLocation lootTableCache = properties.location;
        this.lootTableSupplier = lootTableCache != null ? () -> lootTableCache : properties.lootTableSupplier != null ? properties.lootTableSupplier : () -> new ResourceLocation(this.getRegistryName().getNamespace(), "blocks/" + this.getRegistryName().getPath());
    }

    /**
     * performs updates on diagonal neighbors of the target position and passes in the flags. The flags can be referenced
     * from the docs for {@link IWorldWriter#setBlockState(BlockPos, BlockState, int)}.
     */
    @Deprecated
    public void updateDiagonalNeighbors(BlockState state, IWorld worldIn, BlockPos pos, int flags, int recursionLeft) {
    }

    @Deprecated
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        switch(type) {
            case LAND:
                return !state.hasOpaqueCollisionShape(worldIn, pos);
            case WATER:
                return worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
            case AIR:
                return !state.hasOpaqueCollisionShape(worldIn, pos);
            default:
                return false;
        }
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    @Deprecated
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return stateIn;
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        return false;
    }

    @Deprecated
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        DebugPacketSender.func_218806_a(worldIn, pos);
    }

    @Deprecated
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
    }

    @Deprecated
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.hasTileEntity() && (state.getBlock() != newState.getBlock() || !newState.hasTileEntity())) {
            worldIn.removeTileEntity(pos);
        }

    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        return ActionResultType.PASS;
    }

    /**
     * Called on server when World#addBlockEvent is called. If server returns true, then also called on the client. On
     * the Server, this may perform additional changes to the world, like pistons replacing the block with an extended
     * base. On the client, the update may involve replacing tile entities or effects such as sounds or particles
     * @deprecated call via {@link BlockState#receiveBlockEvent(World, BlockPos, int, int)} whenever possible.
     * Implementing/overriding is fine.
     */
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
        return false;
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     * @deprecated call via {@link BlockState#getRenderType()} whenever possible. Implementing/overriding is fine.
     */
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public boolean isTransparent(BlockState state) {
        return false;
    }

    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     * @deprecated call via {@link BlockState#canProvidePower()} whenever possible. Implementing/overriding is fine.
     */
    public boolean canProvidePower(BlockState state) {
        return false;
    }

    /**
     * @deprecated call via {//@link BlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine.
     */
    @Deprecated
    public PushReaction getPushReaction(BlockState state) {
        return this.material.getPushReaction();
    }

    @Deprecated
    public FluidState getFluidState(BlockState state) {
        return Fluids.EMPTY.getDefaultState();
    }

    /**
     * @deprecated call via {@link BlockState#hasComparatorInputOverride()} whenever possible. Implementing/overriding
     * is fine.
     */
    @Deprecated
    public boolean hasComparatorInputOverride(BlockState state) {
        return false;
    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.NONE;
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link BlockState#rotate(Rotation)} whenever possible. Implementing/overriding is
     * fine.
     */
    @Deprecated
    public BlockState rotate(BlockState state, Rotation rot) {
        return state;
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link BlockState#mirror(Mirror)} whenever possible. Implementing/overriding is fine.
     */
    @Deprecated
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state;
    }

    @Deprecated
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return state.getMaterial().isReplaceable() && (useContext.getItem().isEmpty() || useContext.getItem().getItem() != this.asItem());
    }

    @Deprecated
    public boolean isReplaceable(BlockState state, Fluid fluid) {
        return this.material.isReplaceable() || !this.material.isSolid();
    }

    @Deprecated
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        ResourceLocation resourcelocation = this.getLootTable();
        if (resourcelocation == LootTables.EMPTY) {
            return Collections.emptyList();
        } else {
            LootContext lootcontext = builder.withParameter(LootParameters.BLOCK_STATE, state).build(LootParameterSets.BLOCK);
            ServerWorld serverworld = lootcontext.getWorld();
            LootTable loottable = serverworld.getServer().getLootTableManager().getLootTableFromLocation(resourcelocation);
            return loottable.generate(lootcontext);
        }
    }

    /**
     * Return a random long to be passed to {@link net.minecraft.client.renderer.model.IBakedModel#getQuads(BlockState, Direction, Random, IModelData)}, used for random model rotations
     */
    @Deprecated
    @OnlyIn(Dist.CLIENT)
    public long getPositionRandom(BlockState state, BlockPos pos) {
        return MathHelper.getPositionRandom(pos);
    }

    @Deprecated
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getShape(worldIn, pos);
    }

    @Deprecated
    public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos) {
        return this.getCollisionShape(state, reader, pos, ISelectionContext.dummy());
    }

    @Deprecated
    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Deprecated
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if (state.isOpaqueCube(worldIn, pos)) {
            return worldIn.getMaxLightLevel();
        } else {
            return state.propagatesSkylightDown(worldIn, pos) ? 0 : 1;
        }
    }

    @Nullable
    @Deprecated
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return null;
    }

    @Deprecated
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return true;
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.hasOpaqueCollisionShape(worldIn, pos) ? 0.2F : 1.0F;
    }

    /**
     * @deprecated call via {@link BlockState#getComparatorInputOverride(World,BlockPos)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Deprecated
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return 0;
    }

    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.fullCube();
    }

    @Deprecated
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.canCollide ? state.getShape(worldIn, pos) : VoxelShapes.empty();
    }

    @Deprecated
    public VoxelShape getRayTraceShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return this.getCollisionShape(state, reader, pos, context);
    }

    /**
     * Performs a random tick on a block.
     */
    @Deprecated
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        this.tick(state, worldIn, pos, random);
    }

    @Deprecated
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
    }

    /**
     * Get the hardness of this Block relative to the ability of the given player
     * @deprecated call via {@link BlockState#getPlayerRelativeBlockHardness(PlayerEntity, IBlockReader, BlockPos)} whenever
     * possible. Implementing/overriding is fine.
     */
    @Deprecated
    public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        float f = state.getBlockHardness(worldIn, pos);
        if (f == -1.0F) {
            return 0.0F;
        } else {
            int i = net.minecraftforge.common.ForgeHooks.canHarvestBlock(state, player, worldIn, pos) ? 30 : 100;
            return player.getDigSpeed(state, pos) / f / (float)i;
        }
    }

    /**
     * Perform side-effects from block dropping, such as creating silverfish
     */
    @Deprecated
    public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
    }

    @Deprecated
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
    }

    /**
     * @deprecated call via {@link BlockState#getWeakPower(IBlockReader, BlockPos, Direction)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Deprecated
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 0;
    }

    @Deprecated
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
    }

    /**
     * @deprecated call via {@link BlockState#getStrongPower(IBlockReader, BlockPos, Direction)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Deprecated
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 0;
    }

    @Deprecated //Forge: Use state.hasTileEntity()
    public final boolean isTileEntityProvider() {
        return this instanceof ITileEntityProvider;
    }

    public final ResourceLocation getLootTable() {
        if (this.lootTable == null) {
            this.lootTable = this.lootTableSupplier.get();
        }

        return this.lootTable;
    }

    @Deprecated
    public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
    }

    public abstract Item asItem();

    protected abstract ModBlock getSelf();

    public MaterialColor getMaterialColor() {
        return this.modProperties.blockColors.apply(this.getSelf().getDefaultState());
    }

    /* ======================================== FORGE START ===================================== */
    private final java.util.function.Supplier<ResourceLocation> lootTableSupplier;
    /* ========================================= FORGE END ====================================== */

    public abstract static class AbstractBlockState extends StateHolder<ModBlock, BlockState> {
        private final int lightLevel;
        private final boolean transparent;
        private final boolean isAir;
        private final Material material;
        public Block block;
        private AbstractModBlock abstractModBlock;
        private final MaterialColor materialColor;
        private final float hardness;
        private final boolean requiresTool;
        private final boolean isSolid;
        private final IPositionPredicate isNormalCube;
        private final IPositionPredicate blocksVisionChecker;
        private final IPositionPredicate blocksVision;
        private final IPositionPredicate needsPostProcessing;
        private final IPositionPredicate emissiveRendering;
        @Nullable
        protected AbstractModBlock.AbstractBlockState.Cache cache;

        protected AbstractBlockState(ModBlock block, ImmutableMap<Property<?>, Comparable<?>> propertyValueMap, MapCodec<BlockState> stateCodec) {
            super(block, propertyValueMap, stateCodec);
            Properties abstractblock$properties = abstractModBlock.modProperties;
            this.lightLevel = abstractblock$properties.lightLevel.applyAsInt(this.getSelf());
            this.transparent = abstractModBlock.isTransparent(this.getSelf());
            this.isAir = abstractblock$properties.isAir;
            this.material = abstractblock$properties.material;
            this.materialColor = abstractblock$properties.blockColors.apply(this.getSelf());
            this.hardness = abstractblock$properties.hardness;
            this.requiresTool = abstractblock$properties.requiresTool;
            this.isSolid = abstractblock$properties.isSolid;
            this.isNormalCube = abstractblock$properties.isOpaque;
            this.blocksVisionChecker = abstractblock$properties.suffocates;
            this.blocksVision = abstractblock$properties.blocksVision;
            this.needsPostProcessing = abstractblock$properties.needsPostProcessing;
            this.emissiveRendering = abstractblock$properties.emmissiveRendering;
        }

        public void cacheState() {
            if (!this.getModBlock().isVariableOpacity()) {
                this.cache = new AbstractModBlock.AbstractBlockState.Cache(this.getSelf());
            }

        }

        public ModBlock getModBlock() {
            return this.instance;
        }

        public Block getBlock() {
            return this.block;
        }

        public Material getMaterial() {
            return this.material;
        }

        public boolean canEntitySpawn(IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
            return this.getModBlock().modProperties.allowsSpawn.test(this.getSelf(), worldIn, pos, type);
        }

        public boolean propagatesSkylightDown(IBlockReader worldIn, BlockPos pos) {
            return this.cache != null ? this.cache.propagatesSkylightDown : this.getModBlock().propagatesSkylightDown(this.getSelf(), worldIn, pos);
        }

        public int getOpacity(IBlockReader worldIn, BlockPos pos) {
            return this.cache != null ? this.cache.opacity : this.getModBlock().getOpacity(this.getSelf(), worldIn, pos);
        }

        public VoxelShape getFaceOcclusionShape(IBlockReader worldIn, BlockPos pos, Direction directionIn) {
            return this.cache != null && this.cache.renderShapes != null ? this.cache.renderShapes[directionIn.ordinal()] : VoxelShapes.getFaceShape(this.getRenderShapeTrue(worldIn, pos), directionIn);
        }

        public VoxelShape getRenderShapeTrue(IBlockReader reader, BlockPos pos) {
            return this.getModBlock().getRenderShape(this.getSelf(), reader, pos);
        }

        public boolean isCollisionShapeLargerThanFullBlock() {
            return this.cache == null || this.cache.isCollisionShapeLargerThanFullBlock;
        }

        public boolean isTransparent() {
            return this.transparent;
        }

        public int getLightValue() {
            return this.lightLevel;
        }

        /** @deprecated use {@link BlockState#isAir(IBlockReader, BlockPos) */
        @Deprecated
        public boolean isAir() {
            return this.isAir;
        }

        public MaterialColor getMaterialColor(IBlockReader worldIn, BlockPos pos) {
            return this.materialColor;
        }

        /** @deprecated use {@link BlockState#rotate(IWorld, BlockPos, Rotation) */
        /**
         * Returns the blockstate with the given rotation. If inapplicable, returns itself.
         */
        @Deprecated
        public BlockState rotate(Rotation rot) {
            return this.getModBlock().rotate(this.getSelf(), rot);
        }

        /**
         * Returns the blockstate mirrored in the given way. If inapplicable, returns itself.
         */
        public BlockState mirror(Mirror mirrorIn) {
            return this.getModBlock().mirror(this.getSelf(), mirrorIn);
        }

        public BlockRenderType getRenderType() {
            return this.getModBlock().getRenderType(this.getSelf());
        }

        @OnlyIn(Dist.CLIENT)
        public boolean isEmissiveRendering(IBlockReader reader, BlockPos pos) {
            return this.emissiveRendering.test(this.getSelf(), reader, pos);
        }

        @OnlyIn(Dist.CLIENT)
        public float getAmbientOcclusionLightValue(IBlockReader reader, BlockPos pos) {
            return this.getModBlock().getAmbientOcclusionLightValue(this.getSelf(), reader, pos);
        }

        public boolean isNormalCube(IBlockReader reader, BlockPos pos) {
            return this.isNormalCube.test(this.getSelf(), reader, pos);
        }

        public boolean canProvidePower() {
            return this.getModBlock().canProvidePower(this.getSelf());
        }

        public int getWeakPower(IBlockReader blockAccess, BlockPos pos, Direction side) {
            return this.getModBlock().getWeakPower(this.getSelf(), blockAccess, pos, side);
        }

        public boolean hasComparatorInputOverride() {
            return this.getModBlock().hasComparatorInputOverride(this.getSelf());
        }

        public int getComparatorInputOverride(World worldIn, BlockPos pos) {
            return this.getModBlock().getComparatorInputOverride(this.getSelf(), worldIn, pos);
        }

        public float getBlockHardness(IBlockReader worldIn, BlockPos pos) {
            return this.hardness;
        }

        public float getPlayerRelativeBlockHardness(PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
            return this.getModBlock().getPlayerRelativeBlockHardness(this.getSelf(), player, worldIn, pos);
        }

        public int getStrongPower(IBlockReader blockAccess, BlockPos pos, Direction side) {
            return this.getModBlock().getStrongPower(this.getSelf(), blockAccess, pos, side);
        }

        public PushReaction getPushReaction() {
            return this.getModBlock().getPushReaction(this.getSelf());
        }

        public boolean isOpaqueCube(IBlockReader worldIn, BlockPos pos) {
            if (this.cache != null) {
                return this.cache.opaqueCube;
            } else {
                BlockState blockstate = this.getSelf();
                return blockstate.isSolid() && Block.isOpaque(blockstate.getRenderShapeTrue(worldIn, pos));
            }
        }

        public boolean isSolid() {
            return this.isSolid;
        }

        @OnlyIn(Dist.CLIENT)
        public boolean isSideInvisible(BlockState state, Direction face) {
            return this.getModBlock().isSideInvisible(this.getSelf(), state, face);
        }

        public VoxelShape getShape(IBlockReader worldIn, BlockPos pos) {
            return this.getShape(worldIn, pos, ISelectionContext.dummy());
        }

        public VoxelShape getShape(IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return this.getModBlock().getShape(this.getSelf(), worldIn, pos, context);
        }

        public VoxelShape getCollisionShape(IBlockReader worldIn, BlockPos pos) {
            return this.cache != null ? this.cache.collisionShape : this.getCollisionShape(worldIn, pos, ISelectionContext.dummy());
        }

        public VoxelShape getCollisionShape(IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return this.getModBlock().getCollisionShape(this.getSelf(), worldIn, pos, context);
        }

        public VoxelShape getRenderShape(IBlockReader worldIn, BlockPos pos) {
            return this.getModBlock().getCollisionShape(this.getSelf(), worldIn, pos);
        }

        public VoxelShape getRaytraceShape(IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return this.getModBlock().getRayTraceShape(this.getSelf(), worldIn, pos, context);
        }

        public VoxelShape getRayTraceShape(IBlockReader reader, BlockPos pos) {
            return this.getModBlock().getRaytraceShape(this.getSelf(), reader, pos);
        }

        public final boolean canSpawnMobs(IBlockReader reader, BlockPos p_235719_2_, Entity entity) {
            return this.isTopSolid(reader, p_235719_2_, entity, Direction.UP);
        }

        /**
         * True if the collision box of this state covers the entire upper face of the blockspace
         */
        public final boolean isTopSolid(IBlockReader reader, BlockPos pos, Entity entityIn, Direction direction) {
            return Block.doesSideFillSquare(this.getCollisionShape(reader, pos, ISelectionContext.forEntity(entityIn)), direction);
        }

        public Vector3d getOffset(IBlockReader access, BlockPos pos) {
            AbstractBlock.OffsetType abstractblock$offsettype = this.getModBlock().getOffsetType();
            if (abstractblock$offsettype == AbstractBlock.OffsetType.NONE) {
                return Vector3d.ZERO;
            } else {
                long i = MathHelper.getCoordinateRandom(pos.getX(), 0, pos.getZ());
                return new Vector3d(((double)((float)(i & 15L) / 15.0F) - 0.5D) * 0.5D, abstractblock$offsettype == AbstractBlock.OffsetType.XYZ ? ((double)((float)(i >> 4 & 15L) / 15.0F) - 1.0D) * 0.2D : 0.0D, ((double)((float)(i >> 8 & 15L) / 15.0F) - 0.5D) * 0.5D);
            }
        }

        public boolean receiveBlockEvent(World world, BlockPos pos, int id, int param) {
            return this.getModBlock().eventReceived(this.getSelf(), world, pos, id, param);
        }

        public void neighborChanged(World worldIn, BlockPos posIn, Block blockIn, BlockPos fromPosIn, boolean isMoving) {
            this.getModBlock().neighborChanged(this.getSelf(), worldIn, posIn, blockIn, fromPosIn, isMoving);
        }

        public final void updateNeighbours(IWorld world, BlockPos pos, int flag) {
            this.updateNeighbours(world, pos, flag, 512);
        }

        public final void updateNeighbours(IWorld world, BlockPos pos, int flag, int recursionLeft) {
            this.getModBlock();
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for(Direction direction : AbstractModBlock.UPDATE_ORDER) {
                blockpos$mutable.func_239622_a_(pos, direction);
                BlockState blockstate = world.getBlockState(blockpos$mutable);
                BlockState blockstate1 = blockstate.updatePostPlacement(direction.getOpposite(), this.getSelf(), world, blockpos$mutable, pos);
                Block.func_241468_a_(blockstate, blockstate1, world, blockpos$mutable, flag, recursionLeft);
            }

        }

        /**
         * Performs validations on the block state and possibly neighboring blocks to validate whether the incoming state
         * is valid to stay in the world. Currently used only by redstone wire to update itself if neighboring blocks have
         * changed and to possibly break itself.
         */
        public final void updateDiagonalNeighbors(IWorld worldIn, BlockPos pos, int flags) {
            this.updateDiagonalNeighbors(worldIn, pos, flags, 512);
        }

        public void updateDiagonalNeighbors(IWorld world, BlockPos pos, int flags, int recursionLeft) {
            this.getModBlock().updateDiagonalNeighbors(this.getSelf(), world, pos, flags, recursionLeft);
        }

        public void onBlockAdded(World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
            this.getModBlock().onBlockAdded(this.getSelf(), worldIn, pos, oldState, isMoving);
        }

        public void onReplaced(World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
            this.getModBlock().onReplaced(this.getSelf(), worldIn, pos, newState, isMoving);
        }

        public void tick(ServerWorld worldIn, BlockPos posIn, Random randomIn) {
            this.getModBlock().tick(this.getSelf(), worldIn, posIn, randomIn);
        }

        public void randomTick(ServerWorld worldIn, BlockPos posIn, Random randomIn) {
            this.getModBlock().randomTick(this.getSelf(), worldIn, posIn, randomIn);
        }

        public void onEntityCollision(World worldIn, BlockPos pos, Entity entityIn) {
            this.getModBlock().onEntityCollision(this.getSelf(), worldIn, pos, entityIn);
        }

        public void spawnAdditionalDrops(World worldIn, BlockPos pos, ItemStack stack) {
            this.getModBlock().spawnAdditionalDrops(this.getSelf(), worldIn, pos, stack);
        }

        public List<ItemStack> getDrops(LootContext.Builder builder) {
            return this.getModBlock().getDrops(this.getSelf(), builder);
        }

        public ActionResultType onBlockActivated(World worldIn, PlayerEntity player, Hand handIn, BlockRayTraceResult resultIn) {
            return this.getModBlock().onBlockActivated(this.getSelf(), worldIn, resultIn.getPos(), player, handIn, resultIn);
        }

        public void onBlockClicked(World worldIn, BlockPos pos, PlayerEntity player) {
            this.getModBlock().onBlockClicked(this.getSelf(), worldIn, pos, player);
        }

        public boolean isSuffocating(IBlockReader blockReaderIn, BlockPos blockPosIn) {
            return this.blocksVisionChecker.test(this.getSelf(), blockReaderIn, blockPosIn);
        }

        @OnlyIn(Dist.CLIENT)
        public boolean causesSuffocation(IBlockReader worldIn, BlockPos pos) {
            return this.blocksVision.test(this.getSelf(), worldIn, pos);
        }

        public BlockState updatePostPlacement(Direction face, BlockState queried, IWorld worldIn, BlockPos currentPos, BlockPos offsetPos) {
            return this.getModBlock().updatePostPlacement(this.getSelf(), face, queried, worldIn, currentPos, offsetPos);
        }

        public boolean allowsMovement(IBlockReader worldIn, BlockPos pos, PathType type) {
            return this.getModBlock().allowsMovement(this.getSelf(), worldIn, pos, type);
        }

        public boolean isReplaceable(BlockItemUseContext useContext) {
            return this.getModBlock().isReplaceable(this.getSelf(), useContext);
        }

        public boolean isReplaceable(Fluid fluidIn) {
            return this.getModBlock().isReplaceable(this.getSelf(), fluidIn);
        }

        public boolean isValidPosition(IWorldReader worldIn, BlockPos pos) {
            return this.getModBlock().isValidPosition(this.getSelf(), worldIn, pos);
        }

        public boolean blockNeedsPostProcessing(IBlockReader worldIn, BlockPos pos) {
            return this.needsPostProcessing.test(this.getSelf(), worldIn, pos);
        }

        @Nullable
        public INamedContainerProvider getContainer(World worldIn, BlockPos pos) {
            return this.getModBlock().getContainer(this.getSelf(), worldIn, pos);
        }

        public boolean isIn(ITag<Block> tag) {
            return this.getBlock().isIn(tag);
        }

        public boolean isInAndMatches(ITag<Block> tag, Predicate<AbstractModBlock.AbstractBlockState> predicate) {
            return this.getBlock().isIn(tag) && predicate.test(this);
        }

        public boolean isIn(ModBlock tagIn) {
            return this.getModBlock().matchesBlock(tagIn);
        }

        public FluidState getFluidState() {
            return this.getModBlock().getFluidState(this.getSelf());
        }

        public boolean ticksRandomly() {
            return this.getModBlock().ticksRandomly(this.getSelf());
        }

        @OnlyIn(Dist.CLIENT)
        public long getPositionRandom(BlockPos pos) {
            return this.getModBlock().getPositionRandom(this.getSelf(), pos);
        }

        public SoundType getSoundType() {
            return this.getModBlock().getSoundType(this.getSelf());
        }

        public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
            this.getModBlock().onProjectileCollision(worldIn, state, hit, projectile);
        }

        public boolean isSolidSide(IBlockReader blockReaderIn, BlockPos blockPosIn, Direction directionIn) {
            return this.cache != null ? this.cache.solidSides[directionIn.ordinal()] : Block.hasSolidSide(this.getSelf(), blockReaderIn, blockPosIn, directionIn);
        }

        public boolean hasOpaqueCollisionShape(IBlockReader reader, BlockPos pos) {
            return this.cache != null ? this.cache.opaqueCollisionShape : Block.isOpaque(this.getCollisionShape(reader, pos));
        }

        protected abstract BlockState getSelf();

        public boolean getRequiresTool() {
            return this.requiresTool;
        }

        static final class Cache {
            private static final Direction[] DIRECTIONS = Direction.values();
            protected final boolean opaqueCube;
            private final boolean propagatesSkylightDown;
            private final int opacity;
            @Nullable
            private final VoxelShape[] renderShapes;
            protected final VoxelShape collisionShape;
            protected final boolean isCollisionShapeLargerThanFullBlock;
            protected final boolean[] solidSides;
            protected final boolean opaqueCollisionShape;

            private Cache(BlockState stateIn) {
                Block block = stateIn.getBlock();
                this.opaqueCube = stateIn.isOpaqueCube(EmptyBlockReader.INSTANCE, BlockPos.ZERO);
                this.propagatesSkylightDown = block.propagatesSkylightDown(stateIn, EmptyBlockReader.INSTANCE, BlockPos.ZERO);
                this.opacity = block.getOpacity(stateIn, EmptyBlockReader.INSTANCE, BlockPos.ZERO);
                if (!stateIn.isSolid()) {
                    this.renderShapes = null;
                } else {
                    this.renderShapes = new VoxelShape[DIRECTIONS.length];
                    VoxelShape voxelshape = block.getRenderShape(stateIn, EmptyBlockReader.INSTANCE, BlockPos.ZERO);

                    for(Direction direction : DIRECTIONS) {
                        this.renderShapes[direction.ordinal()] = VoxelShapes.getFaceShape(voxelshape, direction);
                    }
                }

                this.collisionShape = block.getCollisionShape(stateIn, EmptyBlockReader.INSTANCE, BlockPos.ZERO, ISelectionContext.dummy());
                this.isCollisionShapeLargerThanFullBlock = Arrays.stream(Direction.Axis.values()).anyMatch((p_235796_1_) -> {
                    return this.collisionShape.getStart(p_235796_1_) < 0.0D || this.collisionShape.getEnd(p_235796_1_) > 1.0D;
                });
                this.solidSides = new boolean[6];

                for(Direction direction1 : DIRECTIONS) {
                    this.solidSides[direction1.ordinal()] = Block.hasSolidSide(stateIn, EmptyBlockReader.INSTANCE, BlockPos.ZERO, direction1);
                }

                this.opaqueCollisionShape = Block.isOpaque(stateIn.getCollisionShape(EmptyBlockReader.INSTANCE, BlockPos.ZERO));
            }
        }
    }

    public interface IExtendedPositionPredicate<A> {
        boolean test(BlockState p_test_1_, IBlockReader p_test_2_, BlockPos p_test_3_, A p_test_4_);
    }

    public interface IPositionPredicate {
        boolean test(BlockState p_test_1_, IBlockReader p_test_2_, BlockPos p_test_3_);
    }

    public static enum OffsetType {
        NONE,
        XZ,
        XYZ;
    }

    public static class Properties {
        public Material material;
        private AbstractBlock.Properties properties;
        private Properties modProperties;
        public Function<BlockState, MaterialColor> blockColors;
        public boolean blocksMovement = true;
        public SoundType soundType = SoundType.STONE;
        public SoundInit soundInit = SoundInit.WOIK;
        public ToIntFunction<BlockState> lightLevel = (light) -> 0;
        public float resistance;
        public float hardness;
        public boolean requiresTool;
        public boolean ticksRandomly;
        public float slipperiness = 0.6F;
        public float speedFactor = 1.0F;
        public float jumpFactor = 1.0F;
        /** Sets loot table information */
        public ResourceLocation location;
        public boolean isSolid = true;
        public boolean isAir;
        public int harvestLevel = -1;
        public net.minecraftforge.common.ToolType harvestTool;
        private java.util.function.Supplier<ResourceLocation> lootTableSupplier;
        private IExtendedPositionPredicate<EntityType<?>> allowsSpawn = (state, reader, pos, entityType) -> state.isSolidSide(reader, pos, Direction.UP) && state.getLightValue() < 14;
        private IPositionPredicate isOpaque = (state, reader, pos) -> state.getMaterial().isOpaque() && state.hasOpaqueCollisionShape(reader, pos);
        private IPositionPredicate suffocates = (state, reader, pos) -> this.material.blocksMovement() && state.hasOpaqueCollisionShape(reader, pos);
        /** If it blocks vision on the client side. */
        private IPositionPredicate blocksVision = this.suffocates;
        private IPositionPredicate needsPostProcessing = (state, reader, pos) -> false;
        private IPositionPredicate emmissiveRendering = (state, reader, pos) -> false;
        public boolean variableOpacity;

        public Properties(Material materialIn, MaterialColor mapColorIn) {
            this(materialIn, (p_235837_1_) -> mapColorIn);
        }

        public Properties(AbstractBlock.Properties properties, Properties properties1) {
            this(properties);
        }

        public Properties(Material materialIn, MaterialColor mapColorIn, AbstractBlock.Properties properties) {
            this(materialIn, (p_235837_1_) -> mapColorIn, properties);
        }

        public Properties(Material material, Function<BlockState, MaterialColor> stateColorFunction) {
            this.material = material;
            this.blockColors = stateColorFunction;
        }

        public Properties(AbstractBlock.Properties properties) {
            this.properties = properties;
        }

        public Properties(Properties properties) {
            this.modProperties = properties;
        }

        public Properties(Material material, Function<BlockState, MaterialColor> stateColorFunction, AbstractBlock.Properties properties) {
            this.material = material;
            this.blockColors = stateColorFunction;
            this.properties = properties;
        }

        public static Properties createProperties(AbstractBlock.Properties properties) {
            return createProperties(properties, 1);
        }

        public static Properties createProperties(Properties properties) {
            return createProperties(properties, 1);
        }

        public static Properties create(Material materialIn) {
            return create(materialIn, materialIn.getColor());
        }

        public static Properties create(Material materialIn, AbstractBlock.Properties properties) {
            return create(materialIn, materialIn.getColor(), properties);
        }

        public static Properties create(Material materialIn, DyeColor color) {
            return create(materialIn, color.getMapColor());
        }

        public static Properties create(Material materialIn, DyeColor color, AbstractBlock.Properties properties) {
            return create(materialIn, color.getMapColor(), properties);
        }

        public static Properties create(Material materialIn, MaterialColor mapColorIn) {
            return new Properties(materialIn, mapColorIn);
        }

        public static Properties createProperties(AbstractBlock.Properties properties, int i) {
            return new Properties(properties);
        }

        public static Properties createProperties(Properties properties, int i) {
            return new Properties(properties);
        }

        public static Properties create(Material materialIn, MaterialColor mapColorIn, AbstractBlock.Properties properties) {
            return new Properties(materialIn, mapColorIn, properties);
        }

        public static Properties create(Material material, Function<BlockState, MaterialColor> stateColorFunction) {
            return new Properties(material, stateColorFunction);
        }

        public static Properties create(Material material, Function<BlockState, MaterialColor> stateColorFunction, AbstractBlock.Properties properties) {
            return new Properties(material, stateColorFunction, properties);
        }

        public Properties doesNotBlockMovement_() {
            this.blocksMovement = false;
            return this;
        }

        public Properties hardness(float hardnessIn) {
            this.hardness = hardnessIn;
            return this;
        }

        public Properties resistance(float resistanceIn) {
            this.resistance = Math.max(0.0F, resistanceIn);
            return this;
        }

        public Properties doesNotBlockMovement() {
            this.blocksMovement = false;
            this.isSolid = false;
            return this;
        }

        public Properties notSolid() {
            this.isSolid = false;
            return this;
        }

        public Properties harvestLevel(int harvestLevel) {
            this.harvestLevel = harvestLevel;
            return this;
        }

        public Properties harvestTool(net.minecraftforge.common.ToolType harvestTool) {
            this.harvestTool = harvestTool;
            return this;
        }

        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        public net.minecraftforge.common.ToolType getHarvestTool() {
            return this.harvestTool;
        }

        public Properties slipperiness(float slipperinessIn) {
            this.slipperiness = slipperinessIn;
            return this;
        }

        public Properties speedFactor(float factor) {
            this.speedFactor = factor;
            return this;
        }

        public Properties jumpFactor(float factor) {
            this.jumpFactor = factor;
            return this;
        }

        public Properties soundType(SoundType soundTypeIn) {
            this.soundType = soundTypeIn;
            return this;
        }

        public Properties soundInit(SoundInit soundInitIn) {
            this.soundInit = soundInitIn;
            return this;
        }

        public Properties setLightLevel(ToIntFunction<BlockState> stateLightFunction) {
            this.lightLevel = stateLightFunction;
            return this;
        }

        public Properties hardnessAndResistance(float hardnessIn, float resistanceIn) {
            this.hardness = hardnessIn;
            this.resistance = Math.max(0.0F, resistanceIn);
            return this;
        }

        public Properties variableOpacity() {
            this.variableOpacity = true;
            return this;
        }

        public Properties noDrops() {
            this.location = LootTables.EMPTY;
            return this;
        }

        public Properties lootFrom(Block blockIn) {
            this.lootTableSupplier = () -> blockIn.delegate.get().getLootTable();
            return this;
        }

        public Properties lootFrom(ModBlock blockIn) {
            this.lootTableSupplier = () -> blockIn.delegate.get().getLootTable();
            return this;
        }

        public Properties setAir() {
            this.isAir = true;
            return this;
        }

        public Properties setAllowsSpawn(IExtendedPositionPredicate<EntityType<?>> spawnPredicate) {
            this.allowsSpawn = spawnPredicate;
            return this;
        }

        public Properties setOpaque(IPositionPredicate opaquePredicate) {
            this.isOpaque = opaquePredicate;
            return this;
        }

        public Properties setSuffocates(IPositionPredicate suffocatesPredicate) {
            this.suffocates = suffocatesPredicate;
            return this;
        }

        public Properties resourceLocation(ResourceLocation resourceLocation) {
            this.location = resourceLocation;
            return this;
        }
    }
}
