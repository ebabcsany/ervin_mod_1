package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.ArrayList;

import static net.minecraft.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public class Firg extends Block {
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 7);
    private static final ArrayList<Direction> DIRECTIONS = new ArrayList<>();
    private static int DOWN_COUNT = 8;
    private static int UP_COUNT = 8;
    private static int NORTH_COUNT = 8;
    private static int SOUTH_COUNT = 8;
    private static int WEST_COUNT = 8;
    private static int EAST_COUNT = 8;
    private static int STATES = 7;
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D)
    };

    public static void makeCuboidShape(int index) {
//        Block.makeCuboidShape(index * 2, );
    }

    public Firg(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, BITES);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(BITES)];
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            ItemStack itemstack = player.getHeldItem(handIn);
            if (this.eatSlice(worldIn, pos, state, player).isSuccessOrConsume()) {
                return ActionResultType.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return this.eatSlice(worldIn, pos, state, player);
    }

    private ActionResultType eatSlice(IWorld world, BlockPos pos, BlockState state, PlayerEntity player) {
        Minecraft minecraft = Minecraft.getInstance();
        RayTraceResult rayTraceResult = minecraft.objectMouseOver;
        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.addStat(Stats.EAT_CAKE_SLICE);
            player.getFoodStats().addStats(1, 0.2F);
            player.addPotionEffect(Foods.FIRG.getEffects().get(0).getFirst());
            int i = state.get(BITES);
            if (i == 0) {
                setZeroDirectionsCount();
                DIRECTIONS.clear();
                STATES = 7;
            }
            if (rayTraceResult instanceof BlockRayTraceResult) {
                BlockRayTraceResult blockRayTraceResult = (BlockRayTraceResult) rayTraceResult;
                Direction face = blockRayTraceResult.getFace();
                LOGGER.info("Direction: " + face.toString().toUpperCase());
                add(face);
                if (!isContainsGreaterOrEqual8DirectionsOfTheSameType(face)) {
                    if (face == Direction.UP) {
                        setState(world, pos, state, i, i + 1);
                    } else if (face == Direction.DOWN) {
                        LOGGER.info("Direction: DOWN");
                    } else if (face == Direction.EAST) {
                        LOGGER.info("Direction: EAST");
                    } else if (face == Direction.WEST) {
                        LOGGER.info("Direction: WEST");
                    } else if (face == Direction.NORTH) {
                        LOGGER.info("Direction: NORTH");
                    } else if (face == Direction.SOUTH) {
                        LOGGER.info("Direction: SOUTH");
                    } else {
                        LOGGER.info(LOGGER.getMessageFactory().newMessage("No Direction"));
                    }
                }
            }

            return ActionResultType.SUCCESS;
        }
    }

    private static void setState(IWorld world, BlockPos pos, BlockState state, int current, int value) {
        if (current < STATES) {
            world.setBlockState(pos, state.with(BITES, value), 3);
        } else {
            world.removeBlock(pos, false);
        }
    }

    private static void setZeroDirectionsCount() {
        DOWN_COUNT = 0;
        UP_COUNT = 0;
        NORTH_COUNT = 0;
        SOUTH_COUNT = 0;
        WEST_COUNT = 0;
        EAST_COUNT = 0;
    }

    private static void setZeroDirectionsCountExceptForThisDirection(Direction direction) {
        if (direction == Direction.DOWN) {
            UP_COUNT = 0;
            NORTH_COUNT = 0;
            SOUTH_COUNT = 0;
            WEST_COUNT = 0;
            EAST_COUNT = 0;
        } else if (direction == Direction.UP) {
            DOWN_COUNT = 0;
            NORTH_COUNT = 0;
            SOUTH_COUNT = 0;
            WEST_COUNT = 0;
            EAST_COUNT = 0;
        } else if (direction == Direction.NORTH) {
            DOWN_COUNT = 0;
            UP_COUNT = 0;
            SOUTH_COUNT = 0;
            WEST_COUNT = 0;
            EAST_COUNT = 0;
        } else if (direction == Direction.SOUTH) {
            DOWN_COUNT = 0;
            UP_COUNT = 0;
            NORTH_COUNT = 0;
            WEST_COUNT = 0;
            EAST_COUNT = 0;
        } else if (direction == Direction.WEST) {
            DOWN_COUNT = 0;
            UP_COUNT = 0;
            NORTH_COUNT = 0;
            SOUTH_COUNT = 0;
            EAST_COUNT = 0;
        } else if (direction == Direction.EAST) {
            DOWN_COUNT = 0;
            UP_COUNT = 0;
            NORTH_COUNT = 0;
            SOUTH_COUNT = 0;
            WEST_COUNT = 0;
        }
    }

    public static void addDirectionsOfTheSomeTypeCount(Direction direction) {
        if (!isContainsGreaterOrEqual8DirectionsOfTheSameType(direction)) {
            if (direction == Direction.DOWN) {
                DOWN_COUNT++;
                UP_COUNT--;
            } else if (direction == Direction.UP) {
                UP_COUNT++;
                DOWN_COUNT--;
            } else if (direction == Direction.NORTH) {
                NORTH_COUNT++;
                SOUTH_COUNT--;
            } else if (direction == Direction.SOUTH) {
                SOUTH_COUNT++;
                NORTH_COUNT--;
            } else if (direction == Direction.WEST) {
                WEST_COUNT++;
                EAST_COUNT--;
            } else if (direction == Direction.EAST) {
                EAST_COUNT++;
                WEST_COUNT--;
            }
            DIRECTIONS.add(direction);
        }
        if (isContainsGreaterOrEqual8DirectionsOfTheSameType(direction)) {
            setZeroDirectionsCountExceptForThisDirection(direction);
        }
    }

    public static void add(Direction direction) {
        addDirectionsOfTheSomeTypeCount(direction);
    }

    public static long containsDirectionsOfTheSameTypeCount(Direction direction) {
        return DIRECTIONS.stream().filter(value -> value == direction).count();
    }

    public static boolean isContainsGreaterOrEqual8DirectionsOfTheSameType(Direction direction) {
        long count = containsDirectionsOfTheSameTypeCount(direction);
        return count >= 8;
    }

    public static ArrayList<Direction> getDirections() {
        return DIRECTIONS;
    }

    /**
     * @deprecated call via {@link BlockState#getComparatorInputOverride(World,BlockPos)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Override
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return (8 - blockState.get(BITES)) * 2;
    }

    /**
     * @deprecated call via {@link BlockState#hasComparatorInputOverride()} whenever possible. Implementing/overriding
     * is fine.
     */
    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return true;
    }
}
