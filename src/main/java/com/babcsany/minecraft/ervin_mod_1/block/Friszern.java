package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.*;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import com.babcsany.minecraft.item.ModBlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.tileentity.CommandBlockTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Friszern extends ContainerBlock {
   private static final Logger LOGGER = LogManager.getLogger();
   public static final DirectionProperty FACING = DirectionalBlock.FACING;
   public static final BooleanProperty CONDITIONAL = BlockStateProperties.CONDITIONAL;
   private static final ITextComponent field_226655_c_ = new StringTextComponent("@");
   int successCount;
   ITextComponent lastOutput;
   String commandStored = "";
   CommandSource source;
   ServerWorld serverWorld;
   public static CommandBlockTileEntity commandBlockTileEntity;
   private final ITextComponent customName = field_226655_c_;

   public Friszern(Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(CONDITIONAL, Boolean.valueOf(false)));
   }

   public TileEntity createNewTileEntity(IBlockReader worldIn) {
      CommandBlockTileEntity commandblocktileentity = new CommandBlockTileEntity();
      commandblocktileentity.setAuto(this == Blocks.CHAIN_COMMAND_BLOCK);
      return commandblocktileentity;
   }

   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
      if (!worldIn.isRemote) {
         TileEntity tileentity = worldIn.getTileEntity(pos);
         if (tileentity instanceof CommandBlockTileEntity) {
            CommandBlockTileEntity commandblocktileentity = (CommandBlockTileEntity)tileentity;
            boolean flag = worldIn.isBlockPowered(pos);
            boolean flag1 = commandblocktileentity.isPowered();
            commandblocktileentity.setPowered(flag);
            if (!flag1 && !commandblocktileentity.isAuto() && commandblocktileentity.getMode() != CommandBlockTileEntity.Mode.SEQUENCE) {
               if (flag) {
                  this.setConditionMet(commandblocktileentity);
                  worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
               }

            }
         }
      }
   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof CommandBlockTileEntity) {
         CommandBlockTileEntity commandblocktileentity = (CommandBlockTileEntity)tileentity;
         CommandBlockTileEntity.Mode commandblocktileentity$mode = commandblocktileentity.getMode();
         if (commandblocktileentity$mode == CommandBlockTileEntity.Mode.AUTO) {
            this.setConditionMet(commandblocktileentity);

            if (commandblocktileentity.isPowered() || commandblocktileentity.isAuto()) {
               worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
            }
         }

         worldIn.updateComparatorOutputLevel(pos, this);
      }

   }

   public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof CommandBlockTileEntity) {
         player.openCommandBlock((CommandBlockTileEntity)tileentity);
         return ActionResultType.func_233537_a_(worldIn.isRemote);
      } else {
         return ActionResultType.PASS;
      }
   }

   /**
    * @deprecated call via {@link BlockState#hasComparatorInputOverride()} whenever possible. Implementing/overriding
    * is fine.
    */
   public boolean hasComparatorInputOverride(BlockState state) {
      return true;
   }

   /**
    * @deprecated call via {@link BlockState#getComparatorInputOverride(World,BlockPos)} whenever possible.
    * Implementing/overriding is fine.
    */
   public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      return tileentity instanceof CommandBlockTileEntity ? ((CommandBlockTileEntity)tileentity).getCommandBlockLogic().getSuccessCount() : 0;
   }

   /**
    * Called by ItemBlocks after a block is set in the world, to allow post-place logic
    */
   public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof CommandBlockTileEntity) {
         CommandBlockTileEntity commandblocktileentity = (CommandBlockTileEntity)tileentity;
         CommandBlockLogic commandblocklogic = commandblocktileentity.getCommandBlockLogic();
         if (stack.hasDisplayName()) {
            commandblocklogic.setName(stack.getDisplayName());
         }

         if (!worldIn.isRemote) {
            if (stack.getChildTag("BlockEntityTag") == null) {
               commandblocklogic.setTrackOutput(worldIn.getGameRules().getBoolean(GameRules.SEND_COMMAND_FEEDBACK));
               commandblocktileentity.setAuto(this == Blocks.CHAIN_COMMAND_BLOCK);
            }

            if (commandblocktileentity.getMode() == CommandBlockTileEntity.Mode.SEQUENCE) {
               boolean flag = worldIn.isBlockPowered(pos);
               commandblocktileentity.setPowered(flag);
            }
         }

      }
   }

   /**
    * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
    * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
    * @deprecated call via {@link BlockState#getRenderType()} whenever possible. Implementing/overriding is fine.
    */
   public BlockRenderType getRenderType(BlockState state) {
      return BlockRenderType.MODEL;
   }

   /**
    * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
    * blockstate.
    * @deprecated call via {@link BlockState#rotate(Rotation)} whenever possible. Implementing/overriding is
    * fine.
    */
   public BlockState rotate(BlockState state, Rotation rot) {
      return state.with(FACING, rot.rotate(state.get(FACING)));
   }

   /**
    * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
    * blockstate.
    * @deprecated call via {@link BlockState#mirror(Mirror)} whenever possible. Implementing/overriding is fine.
    */
   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.toRotation(state.get(FACING)));
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(FACING, CONDITIONAL);
   }

   public BlockState getStateForPlacement(ModBlockItemUseContext context) {
      return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
   }

   /*private void executeChain(World world, BlockPos pos, Direction direction) {
      BlockPos.Mutable blockpos$mutable = pos.toMutable();
      GameRules gamerules = world.getGameRules();

      int i;
      BlockState blockstate;
      for(i = gamerules.getInt(GameRules.MAX_COMMAND_CHAIN_LENGTH); i-- > 0; direction = blockstate.get(FACING)) {
         blockpos$mutable.move(direction);
         blockstate = world.getBlockState(blockpos$mutable);
         Block block = blockstate.getBlock();
         if (!blockstate.isIn(Blocks.CHAIN_COMMAND_BLOCK)) {
            break;
         }

         TileEntity tileentity = world.getTileEntity(blockpos$mutable);
         if (!(tileentity instanceof CommandBlockTileEntity)) {
            break;
         }

         CommandBlockTileEntity commandblocktileentity = (CommandBlockTileEntity)tileentity;
         if (commandblocktileentity.getMode() != CommandBlockTileEntity.Mode.SEQUENCE) {
            break;
         }

         if (commandblocktileentity.isPowered() || commandblocktileentity.isAuto()) {
            CommandBlockLogic commandblocklogic = commandblocktileentity.getCommandBlockLogic();
            if (commandblocktileentity.setConditionMet()) {
               if (!this.trigger(world)) {
                  break;
               }

               world.updateComparatorOutputLevel(blockpos$mutable, block);
            } else if (commandblocktileentity.isConditional()) {
               commandblocklogic.setSuccessCount(0);
            }
         }
      }

      if (i <= 0) {
         int j = Math.max(gamerules.getInt(GameRules.MAX_COMMAND_CHAIN_LENGTH), 0);
         LOGGER.warn("Command Block chain tried to execute more than {} steps!", j);
      }

   }

   public boolean trigger(World worldIn) {
      this.lastOutput = new StringTextComponent("#itzlipofutzli");
      this.successCount = 1;
      this.successCount = 0;
      MinecraftServer minecraftserver = this.getWorld().getServer();
      try {
         this.lastOutput = null;
         CommandSource commandsource = this.getCommandSource().withResultConsumer((p_209527_1_, p_209527_2_, p_209527_3_) -> {
            if (p_209527_2_) {
               ++this.successCount;
            }

         });
         minecraftserver.getCommandManager().handleCommand(commandsource, this.commandStored);
      } catch (Throwable throwable) {
         CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Executing command block");
         CrashReportCategory crashreportcategory = crashreport.makeCategory("Command to be executed");
         crashreportcategory.addDetail("Command", this::getCommand);
         crashreportcategory.addDetail("Name", () -> this.getName().getString());
         throw new ReportedException(crashreport);
      }
      return true;
   }

   public CommandSource getCommandSource() {
      return this.source;
   }

   public ITextComponent getName() {
      return this.customName;
   }

   public String getCommand() {
      return this.commandStored;
   }

   public ServerWorld getWorld() {
      return this.serverWorld;
   }*/

   public boolean setConditionMet(CommandBlockTileEntity tileEntity) {
      tileEntity.conditionMet = true;
      if (tileEntity.isConditional()) {
         BlockPos blockpos = tileEntity.pos.offset(tileEntity.world.getBlockState(tileEntity.pos).get(Friszern.FACING).getOpposite());
         if (tileEntity.world.getBlockState(blockpos).getBlock() instanceof Friszern) {
            TileEntity tileentity = tileEntity.world.getTileEntity(blockpos);
            tileEntity.conditionMet = tileentity instanceof CommandBlockTileEntity;
         } else {
            tileEntity.conditionMet = false;
         }
      }

      return tileEntity.conditionMet;
   }

}
