package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SRespawnPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.server.management.PlayerList;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.*;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class Hurvruj extends Block {
    public static final int MIN_CHARGES = 0;
    public static final int MAX_CHARGES = 16;
    public static final IntegerProperty HURVRUJ_CHARGES = IntegerProperty.create("hurvruj_charges", MIN_CHARGES, MAX_CHARGES);
    private static final ImmutableList<Vector3i> field_242676_b = ImmutableList.of(new Vector3i(0, 0, -1), new Vector3i(-1, 0, 0), new Vector3i(0, 0, 1), new Vector3i(1, 0, 0), new Vector3i(-1, 0, -1), new Vector3i(1, 0, -1), new Vector3i(-1, 0, 1), new Vector3i(1, 0, 1));
    private static final ImmutableList<Vector3i> field_242677_c = (new ImmutableList.Builder<Vector3i>()).addAll(field_242676_b).addAll(field_242676_b.stream().map(Vector3i::down).iterator()).addAll(field_242676_b.stream().map(Vector3i::up).iterator()).add(new Vector3i(0, 1, 0)).build();
    public static final RegistryKey<World> WORLD_KEY = World.THE_END;
    public static BlockPos POS = BlockPos.ZERO;
    public static float playerYaw = 0.0F;
    private static PlayerEntity PLAYER;
    public static boolean canSetRespawnPoint = false;
    public static boolean isRespawnedPlayer = false;
    public int deadCounter = 0;
    public int respawnCounter = 0;
    public int respawnInBlockCounter = 0;

    public Hurvruj(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HURVRUJ_CHARGES, 0));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemstack = player.getHeldItem(handIn);
        if (handIn == Hand.MAIN_HAND && !isValidFuel(itemstack) && isValidFuel(player.getHeldItem(Hand.OFF_HAND))) {
            return ActionResultType.PASS;
        } else if (isValidFuel(itemstack) && notFullyCharged(state)) {
            chargeHurvruj(worldIn, pos, state);
            if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else if (state.get(HURVRUJ_CHARGES) == 0) {
            return ActionResultType.PASS;
        } else if (!doesHurvrujWork(worldIn)) {
            if (!worldIn.isRemote) {
                this.triggerExplosion(state, worldIn, pos);
            }

            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            if (!worldIn.isRemote) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                MinecraftServer server = serverPlayer.server;
                ServerWorld serverWorld = server.func_241755_D_();
                DimensionType dimensionType = serverWorld.getDimensionType();
                long hashedSeed = BiomeManager.getHashedSeed(serverWorld.getSeed());
                PlayerInteractionManager interactionManager = serverPlayer.interactionManager;
                GameType gameType = interactionManager.getGameType();
                GameType previousGameType = interactionManager.func_241815_c_();
                boolean isDebug = serverWorld.isDebug();
                boolean isFlatWorld = serverWorld.isFlatWorld();
                if (serverPlayer.func_241141_L_() != worldIn.getDimensionKey() || !Objects.equals(serverPlayer.func_241140_K_(), pos)) {
                    serverPlayer.func_242111_a(worldIn.getDimensionKey(), pos, 0.0F, false, true);
                    worldIn.playSound(player, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_SET_SPAWN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                    canSetRespawnPoint = true;
                    POS = pos;

                    return ActionResultType.SUCCESS;
                }
            }

            return ActionResultType.CONSUME;
        }
    }

//    @Override
//    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
//        super.tick(state, worldIn, pos, rand);
//
//        if (canSetRespawnPoint) {
//            Minecraft minecraft = Minecraft.getInstance();
//            PlayerEntity player = minecraft.player;
//            if (player == null) throw new AssertionError();
//            MinecraftServer server = minecraft.getIntegratedServer();
//            if (server == null) throw new AssertionError();
//            PlayerList list = server.getPlayerList();
//            list.tick();
//            if (player.getShouldBeDead()) {
//                this.deadCounter++;
//                player.respawnPlayer();
//                this.respawnCounter++;
//            }
//        }
//    }

    public static Optional<Vector3d> findRespawnPoint(ServerWorld worldIn, BlockPos pos, float orientation, boolean forced, boolean keepEverything) {
        BlockState blockstate = worldIn.getBlockState(pos);
        Block block = blockstate.getBlock();
        if (block instanceof Hurvruj && blockstate.get(HURVRUJ_CHARGES) > 0 && doesHurvrujWork(worldIn)) {
            Optional<Vector3d> optional = findRespawnPoint(EntityType.PLAYER, worldIn, pos);
            if (!keepEverything && optional.isPresent()) {
                setBlockState(worldIn, pos, blockstate, -1);
            }

            return optional;
        } else if (blockstate.isBed(worldIn, pos, null) && BedBlock.doesBedWork(worldIn)) {
            return blockstate.getBedSpawnPosition(EntityType.PLAYER, worldIn, pos, orientation, null);
        } else if (!forced) {
            return Optional.empty();
        } else {
            boolean flag = block.canSpawnInBlock();
            boolean flag1 = worldIn.getBlockState(pos.up()).getBlock().canSpawnInBlock();
            return flag && flag1 ? Optional.of(new Vector3d((double) pos.getX() + 0.5D, (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D)) : Optional.empty();
        }
    }

    public boolean isValidFuel(ItemStack stack) {
        return stack.getItem() == isBurnableBlockItemInit.TERAT_BLOCK;
    }

    private static boolean notFullyCharged(BlockState state) {
        return state.get(HURVRUJ_CHARGES) < MAX_CHARGES;
    }

    private static boolean isNearWater(BlockPos pos, World world) {
        FluidState fluidstate = world.getFluidState(pos);
        if (!fluidstate.isTagged(FluidTags.WATER)) {
            return false;
        } else if (fluidstate.isSource()) {
            return true;
        } else {
            float f = (float) fluidstate.getLevel();
            if (f < 2.0F) {
                return false;
            } else {
                FluidState fluidState = world.getFluidState(pos.down());
                return !fluidState.isTagged(FluidTags.WATER);
            }
        }
    }

    private void triggerExplosion(BlockState state, World world, final BlockPos pos2) {
        world.removeBlock(pos2, false);
        boolean flag = Direction.Plane.HORIZONTAL.getDirectionValues().map(pos2::offset).anyMatch((posIn) -> {
            return isNearWater(posIn, world);
        });
        final boolean flag1 = flag || world.getFluidState(pos2.up()).isTagged(FluidTags.WATER);
        ExplosionContext explosioncontext = new ExplosionContext() {
            public Optional<Float> getExplosionResistance(Explosion explosion, IBlockReader reader, BlockPos pos, BlockState state, FluidState fluid) {
                return pos.equals(pos2) && flag1 ? Optional.of(Blocks.WATER.getExplosionResistance()) : super.getExplosionResistance(explosion, reader, pos, state, fluid);
            }
        };
        world.createExplosion((Entity) null, DamageSource.causeBedExplosionDamage(), explosioncontext, (double) pos2.getX() + 0.5D, (double) pos2.getY() + 0.5D, (double) pos2.getZ() + 0.5D, 5.0F, true, Explosion.Mode.DESTROY);
    }

    public static boolean doesHurvrujWork1(World world) {
        return world.getDimensionType().doesRespawnAnchorWorks();
    }

    public static boolean doesHurvrujWork(World world) {
        return world.getDimensionKey() == World.THE_END;
    }

    public static void chargeHurvruj(World world, BlockPos pos, BlockState state) {
        setBlockState(world, pos, state);
        world.playSound(null, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    public static void setBlockState(World world, BlockPos pos, BlockState state) {
        setBlockState(world, pos, state, 1);
    }

    public static void setBlockState(World world, BlockPos pos, BlockState state, int addCharges) {
        int chargesResult = Math.min(Math.max(state.get(HURVRUJ_CHARGES) + addCharges, MIN_CHARGES), MAX_CHARGES);
        world.setBlockState(pos, state.with(HURVRUJ_CHARGES, chargesResult), MAX_CHARGES - 1);
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
     * this method is unrelated to {@link #randomTick} and {@link #animateTick(BlockState, World, BlockPos, Random)}, and will always be called regardless
     * of whether the block can receive random update ticks
     */
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(HURVRUJ_CHARGES) > 0) {
            if (rand.nextInt(100) == 0) {
                worldIn.playSound(null, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

            double d0 = (double) pos.getX() + 0.5D + (0.5D - rand.nextDouble());
            double d1 = (double) pos.getY() + 1.0D;
            double d2 = (double) pos.getZ() + 0.5D + (0.5D - rand.nextDouble());
            double d3 = (double) rand.nextFloat() * 0.04D;
            worldIn.addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, 0.0D, d3, 0.0D);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HURVRUJ_CHARGES);
    }

    @Override
    public boolean canSpawnInBlock() {
        return true;
    }

    public static int lightState(BlockState state, int charges) {
        return MathHelper.floor((float) (state.get(HURVRUJ_CHARGES)) / MAX_CHARGES * (float) charges);
    }

    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    public static int getChargeScale(BlockState state, int scale) {
        return MathHelper.floor((float) (state.get(HURVRUJ_CHARGES) - MIN_CHARGES) / MAX_CHARGES * (float) scale);
    }

    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return getChargeScale(blockState, MAX_CHARGES - 1);
    }

    public static Optional<Vector3d> findRespawnPoint(EntityType<?> entity, ICollisionReader reader, BlockPos pos) {
        Optional<Vector3d> optional = findRespawnPoint(entity, reader, pos, true);
        return optional.isPresent() ? optional : findRespawnPoint(entity, reader, pos, false);
    }

    private static Optional<Vector3d> findRespawnPoint(EntityType<?> type, ICollisionReader collisionReader, BlockPos pos, boolean checkCanSpawn) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (Vector3i vector3i : field_242677_c) {
            blockpos$mutable.setPos(pos).func_243531_h(vector3i);
            Vector3d vector3d = TransportationHelper.func_242379_a(type, collisionReader, blockpos$mutable, checkCanSpawn);
            if (vector3d != null) {
                return Optional.of(vector3d);
            }
        }

        return Optional.empty();
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}