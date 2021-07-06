package com.babcsany.minecraft.ervin_mod_1.state;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.*;
import net.minecraft.util.Direction;

public class ModBlockStateProperties extends BlockStateProperties {
   public static final BooleanProperty ATTACHED = BooleanProperty.create("attached");
   public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");
   public static final BooleanProperty CONDITIONAL = BooleanProperty.create("conditional");
   public static final BooleanProperty DISARMED = BooleanProperty.create("disarmed");
   public static final BooleanProperty DRAG = BooleanProperty.create("drag");
   public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");
   public static final BooleanProperty EXTENDED = BooleanProperty.create("extended");
   public static final BooleanProperty EYE = BooleanProperty.create("eye");
   public static final BooleanProperty FALLING = BooleanProperty.create("falling");
   public static final BooleanProperty HANGING = BooleanProperty.create("hanging");
   public static final BooleanProperty HAS_BOTTLE_0 = BooleanProperty.create("has_bottle_0");
   public static final BooleanProperty HAS_BOTTLE_1 = BooleanProperty.create("has_bottle_1");
   public static final BooleanProperty HAS_BOTTLE_2 = BooleanProperty.create("has_bottle_2");
   public static final BooleanProperty HAS_RECORD = BooleanProperty.create("has_record");
   public static final BooleanProperty HAS_BOOK = BooleanProperty.create("has_book");
   public static final BooleanProperty INVERTED = BooleanProperty.create("inverted");
   public static final BooleanProperty IN_WALL = BooleanProperty.create("in_wall");
   public static final BooleanProperty LIT = BooleanProperty.create("lit");
   public static final BooleanProperty LOCKED = BooleanProperty.create("locked");
   public static final BooleanProperty OCCUPIED = BooleanProperty.create("occupied");
   public static final BooleanProperty OPEN = BooleanProperty.create("open");
   public static final BooleanProperty PERSISTENT = BooleanProperty.create("persistent");
   public static final BooleanProperty POWERED = BooleanProperty.create("powered");
   public static final BooleanProperty SHORT = BooleanProperty.create("short");
   public static final BooleanProperty SIGNAL_FIRE = BooleanProperty.create("signal_fire");
   public static final BooleanProperty SNOWY = BooleanProperty.create("snowy");
   public static final BooleanProperty DEF = BooleanProperty.create("def");
   public static final BooleanProperty TRIGGERED = BooleanProperty.create("triggered");
   public static final BooleanProperty UNSTABLE = BooleanProperty.create("unstable");
   public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
   public static final EnumProperty<Direction.Axis> HORIZONTAL_AXIS = EnumProperty.create("axis", Direction.Axis.class, Direction.Axis.X, Direction.Axis.Z);
   public static final EnumProperty<Direction.Axis> AXIS = EnumProperty.create("axis", Direction.Axis.class);
   public static final BooleanProperty UP = BooleanProperty.create("up");
   public static final BooleanProperty DOWN = BooleanProperty.create("down");
   public static final BooleanProperty NORTH = BooleanProperty.create("north");
   public static final BooleanProperty EAST = BooleanProperty.create("east");
   public static final BooleanProperty SOUTH = BooleanProperty.create("south");
   public static final BooleanProperty WEST = BooleanProperty.create("west");
   public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
   public static final DirectionProperty FACING_EXCEPT_UP = DirectionProperty.create("facing", (p_208125_0_) -> {
      return p_208125_0_ != Direction.UP;
   });
   public static final DirectionProperty HORIZONTAL_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
   public static final EnumProperty<AttachFace> FACE = EnumProperty.create("face", AttachFace.class);
   public static final EnumProperty<BellAttachment> BELL_ATTACHMENT = EnumProperty.create("attachment", BellAttachment.class);
   public static final EnumProperty<RedstoneSide> REDSTONE_EAST = EnumProperty.create("east", RedstoneSide.class);
   public static final EnumProperty<RedstoneSide> REDSTONE_NORTH = EnumProperty.create("north", RedstoneSide.class);
   public static final EnumProperty<RedstoneSide> REDSTONE_SOUTH = EnumProperty.create("south", RedstoneSide.class);
   public static final EnumProperty<RedstoneSide> REDSTONE_WEST = EnumProperty.create("west", RedstoneSide.class);
   public static final EnumProperty<DoubleBlockHalf> DOUBLE_BLOCK_HALF = EnumProperty.create("half", DoubleBlockHalf.class);
   public static final EnumProperty<Half> HALF = EnumProperty.create("half", Half.class);
   public static final EnumProperty<RailShape> RAIL_SHAPE = EnumProperty.create("shape", RailShape.class);
   public static final EnumProperty<RailShape> RAIL_SHAPE_STRAIGHT = EnumProperty.create("shape", RailShape.class, (p_210409_0_) -> {
      return p_210409_0_ != RailShape.NORTH_EAST && p_210409_0_ != RailShape.NORTH_WEST && p_210409_0_ != RailShape.SOUTH_EAST && p_210409_0_ != RailShape.SOUTH_WEST;
   });
   public static final IntegerProperty AGE_0_1 = IntegerProperty.create("age", 0, 1);
   public static final IntegerProperty AGE_0_2 = IntegerProperty.create("age", 0, 2);
   public static final IntegerProperty AGE_0_3 = IntegerProperty.create("age", 0, 3);
   public static final IntegerProperty AGE_0_4 = IntegerProperty.create("age", 0, 4);
   public static final IntegerProperty AGE_0_5 = IntegerProperty.create("age", 0, 5);
   public static final IntegerProperty AGE_0_6 = IntegerProperty.create("age", 0, 6);
   public static final IntegerProperty AGE_0_7 = IntegerProperty.create("age", 0, 7);
   public static final IntegerProperty AGE_0_8 = IntegerProperty.create("age", 0, 8);
   public static final IntegerProperty AGE_0_9 = IntegerProperty.create("age", 0, 9);
   public static final IntegerProperty AGE_0_10 = IntegerProperty.create("age", 0, 10);
   public static final IntegerProperty AGE_0_11 = IntegerProperty.create("age", 0, 11);
   public static final IntegerProperty AGE_0_12 = IntegerProperty.create("age", 0, 12);
   public static final IntegerProperty AGE_0_13 = IntegerProperty.create("age", 0, 13);
   public static final IntegerProperty AGE_0_14 = IntegerProperty.create("age", 0, 14);
   public static final IntegerProperty AGE_0_15 = IntegerProperty.create("age", 0, 15);
   public static final IntegerProperty AGE_0_16 = IntegerProperty.create("age", 0, 16);
   public static final IntegerProperty AGE_0_17 = IntegerProperty.create("age", 0, 17);
   public static final IntegerProperty AGE_0_18 = IntegerProperty.create("age", 0, 18);
   public static final IntegerProperty AGE_0_19 = IntegerProperty.create("age", 0, 19);
   public static final IntegerProperty AGE_0_20 = IntegerProperty.create("age", 0, 20);
   public static final IntegerProperty AGE_0_21 = IntegerProperty.create("age", 0, 21);
   public static final IntegerProperty AGE_0_22 = IntegerProperty.create("age", 0, 22);
   public static final IntegerProperty AGE_0_23 = IntegerProperty.create("age", 0, 23);
   public static final IntegerProperty AGE_0_24 = IntegerProperty.create("age", 0, 24);
   public static final IntegerProperty AGE_0_25 = IntegerProperty.create("age", 0, 25);
   public static final IntegerProperty AGE_0_43 = IntegerProperty.create("age", 0, 43);
   public static final IntegerProperty AGE_0_44 = IntegerProperty.create("age", 0, 44);
   public static final IntegerProperty BITES_0_6 = IntegerProperty.create("bites", 0, 6);
   public static final IntegerProperty BITES_0_7 = IntegerProperty.create("bites", 0, 7);
   public static final IntegerProperty DELAY_1_4 = IntegerProperty.create("delay", 1, 4);
   public static final IntegerProperty DISTANCE_1_7 = IntegerProperty.create("distance", 1, 7);
   public static final IntegerProperty DISTANCE_1_12 = IntegerProperty.create("distance", 1, 12);
   public static final IntegerProperty DISTANCE_1_32 = IntegerProperty.create("distance", 1, 32);
   public static final IntegerProperty CHARGES = IntegerProperty.create("charges", 0, 4);
   public static final IntegerProperty CHARGES_0_16 = IntegerProperty.create("charges", 0, 16);
   public static final IntegerProperty EGGS_1_4 = IntegerProperty.create("eggs", 1, 4);
   public static final IntegerProperty HATCH_0_2 = IntegerProperty.create("hatch", 0, 2);
   public static final IntegerProperty LAYERS_1_8 = IntegerProperty.create("layers", 1, 8);
   public static final IntegerProperty LEVEL_0_3 = IntegerProperty.create("level", 0, 3);
   public static final IntegerProperty LEVEL_0_1 = IntegerProperty.create("level", 0, 1);
   public static final IntegerProperty LEVEL_0_8 = IntegerProperty.create("level", 0, 8);
   public static final IntegerProperty LEVEL_1_8 = IntegerProperty.create("level", 1, 8);
   public static final IntegerProperty LEVEL_1_16 = IntegerProperty.create("level", 1, 16);
   public static final IntegerProperty HONEY_LEVEL = IntegerProperty.create("honey_level", 0, 5);
   public static final IntegerProperty LEVEL_0_15 = IntegerProperty.create("level", 0, 15);
   public static final IntegerProperty LEVEL_0_16 = IntegerProperty.create("level", 0, 16);
   public static final IntegerProperty MOISTURE_0_7 = IntegerProperty.create("moisture", 0, 7);
   public static final IntegerProperty NOTE_0_24 = IntegerProperty.create("note", 0, 24);
   public static final IntegerProperty PICKLES_1_4 = IntegerProperty.create("pickles", 1, 4);
   public static final IntegerProperty POWER_0_15 = IntegerProperty.create("power", 0, 15);
   public static final IntegerProperty STAGE_0_1 = IntegerProperty.create("stage", 0, 1);
   public static final IntegerProperty DISTANCE_0_7 = IntegerProperty.create("distance", 0, 7);
   public static final IntegerProperty ROTATION_0_15 = IntegerProperty.create("rotation", 0, 15);
   public static final EnumProperty<BedPart> BED_PART = EnumProperty.create("part", BedPart.class);
   public static final EnumProperty<ChestType> CHEST_TYPE = EnumProperty.create("type", ChestType.class);
   public static final EnumProperty<ComparatorMode> COMPARATOR_MODE = EnumProperty.create("mode", ComparatorMode.class);
   public static final EnumProperty<DoorHingeSide> DOOR_HINGE = EnumProperty.create("hinge", DoorHingeSide.class);
   public static final EnumProperty<NoteBlockInstrument> NOTE_BLOCK_INSTRUMENT = EnumProperty.create("instrument", NoteBlockInstrument.class);
   public static final EnumProperty<PistonType> PISTON_TYPE = EnumProperty.create("type", PistonType.class);
   public static final EnumProperty<SlabType> SLAB_TYPE = EnumProperty.create("type", SlabType.class);
   public static final EnumProperty<StairsShape> STAIRS_SHAPE = EnumProperty.create("shape", StairsShape.class);
   public static final EnumProperty<StructureMode> STRUCTURE_BLOCK_MODE = EnumProperty.create("mode", StructureMode.class);
   public static final EnumProperty<BambooLeaves> BAMBOO_LEAVES = EnumProperty.create("leaves", BambooLeaves.class);
}