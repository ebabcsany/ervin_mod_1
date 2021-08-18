package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.tileentity.CommandBlockFriszernTileEntity;
import net.minecraft.tileentity.CommandBlockTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Friszernk extends ContainerBlock {
   public Minecraft minecraft;
   private static final Logger LOGGER = LogManager.getLogger();
   public static final DirectionProperty FACING = DirectionalBlock.FACING;
   public static final BooleanProperty CONDITIONAL = BlockStateProperties.CONDITIONAL;

   public Friszernk(Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(CONDITIONAL, Boolean.FALSE));
   }

   public TileEntity createNewTileEntity(IBlockReader worldIn) {
      CommandBlockFriszernTileEntity commandBlockTileEntity = new CommandBlockFriszernTileEntity();
      commandBlockTileEntity.setAuto(this == BlockInit.CHAIN_FRISZERN);
      return commandBlockTileEntity;
   }

   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
      if (!worldIn.isRemote) {
         TileEntity tileentity = worldIn.getTileEntity(pos);
         if (tileentity instanceof CommandBlockFriszernTileEntity) {
            CommandBlockFriszernTileEntity commandBlockTileEntity = (CommandBlockFriszernTileEntity)tileentity;
            boolean flag = worldIn.isBlockPowered(pos);
            boolean flag1 = commandBlockTileEntity.isPowered();
            commandBlockTileEntity.setPowered(flag);
            if (!flag1 && !commandBlockTileEntity.isAuto() && commandBlockTileEntity.getFriszernMode() != CommandBlockFriszernTileEntity.Mode.SEQUENCE) {
               if (flag) {
                  commandBlockTileEntity.setConditionMet();
                  worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
               }

            }
         }
      }
   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      TileEntity tileEntity = worldIn.getTileEntity(pos);
      if (tileEntity instanceof CommandBlockFriszernTileEntity) {
         CommandBlockFriszernTileEntity commandBlockTileEntity = (CommandBlockFriszernTileEntity) tileEntity;
         CommandBlockLogic commandBlockLogic = commandBlockTileEntity.getCommandBlockLogic();
         boolean flag = !StringUtils.isNullOrEmpty(commandBlockLogic.getCommand());
         CommandBlockFriszernTileEntity.Mode commandBlockTileEntity$mode = commandBlockTileEntity.getFriszernMode();
         boolean flag1 = commandBlockTileEntity.isConditionMet();
         if (commandBlockTileEntity$mode == CommandBlockFriszernTileEntity.Mode.AUTO) {
            commandBlockTileEntity.setConditionMet();
            if (flag1) {
               this.execute(state, worldIn, pos, commandBlockLogic, flag);
            } else if (commandBlockTileEntity.isConditional()) {
               commandBlockLogic.setSuccessCount(0);
            }

            if (commandBlockTileEntity.isPowered() || commandBlockTileEntity.isAuto()) {
               worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
            }
         } else if (commandBlockTileEntity$mode == CommandBlockFriszernTileEntity.Mode.REDSTONE) {
            if (flag1) {
               this.execute(state, worldIn, pos, commandBlockLogic, flag);
            } else if (commandBlockTileEntity.isConditional()) {
               commandBlockLogic.setSuccessCount(0);
            }
         }

         worldIn.updateComparatorOutputLevel(pos, this);
      }

   }

   private void execute(BlockState state, World world, BlockPos pos, CommandBlockLogic logic, boolean canTrigger) {
      if (canTrigger) {
         logic.trigger(world);
      } else {
         logic.setSuccessCount(0);
      }

      executeChain(world, pos, state.get(FACING));
   }

   public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      TileEntity tileEntity = worldIn.getTileEntity(pos);
      if (tileEntity instanceof CommandBlockFriszernTileEntity) {
         player.openCommandBlock((CommandBlockTileEntity) tileEntity);
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
      TileEntity tileEntity = worldIn.getTileEntity(pos);
      return tileEntity instanceof CommandBlockFriszernTileEntity ? ((CommandBlockFriszernTileEntity)tileEntity).getCommandBlockLogic().getSuccessCount() : 0;
   }

   /**
    * Called by ItemBlocks after a block is set in the world, to allow post-place logic
    */
   public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
      TileEntity tileEntity = worldIn.getTileEntity(pos);
      if (tileEntity instanceof CommandBlockFriszernTileEntity) {
         CommandBlockFriszernTileEntity commandBlockTileEntity = (CommandBlockFriszernTileEntity)tileEntity;
         CommandBlockLogic commandBlockLogic = commandBlockTileEntity.getCommandBlockLogic();
         if (stack.hasDisplayName()) {
            commandBlockLogic.setName(stack.getDisplayName());
         }

         if (!worldIn.isRemote) {
            if (stack.getChildTag("BlockEntityTag") == null) {
               commandBlockLogic.setTrackOutput(worldIn.getGameRules().getBoolean(GameRules.SEND_COMMAND_FEEDBACK));
               commandBlockTileEntity.setAuto(this == BlockInit.CHAIN_FRISZERN);
            }

            if (commandBlockTileEntity.getFriszernMode() == CommandBlockFriszernTileEntity.Mode.SEQUENCE) {
               boolean flag = worldIn.isBlockPowered(pos);
               commandBlockTileEntity.setPowered(flag);
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

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
   }

   private static void executeChain(World world, BlockPos pos, Direction direction) {
      BlockPos.Mutable blockpos$mutable = pos.toMutable();
      GameRules gamerules = world.getGameRules();

      int i;
      BlockState blockstate;
      for(i = gamerules.getInt(GameRules.MAX_COMMAND_CHAIN_LENGTH); i-- > 0; direction = blockstate.get(FACING)) {
         blockpos$mutable.move(direction);
         blockstate = world.getBlockState(blockpos$mutable);
         Block block = blockstate.getBlock();
         if (!blockstate.isIn(BlockInit.CHAIN_FRISZERN)) {
            break;
         }

         TileEntity tileentity = world.getTileEntity(blockpos$mutable);
         if (!(tileentity instanceof CommandBlockFriszernTileEntity)) {
            break;
         }

         CommandBlockFriszernTileEntity commandBlockTileEntity = (CommandBlockFriszernTileEntity)tileentity;
         if (commandBlockTileEntity.getFriszernMode() != CommandBlockFriszernTileEntity.Mode.SEQUENCE) {
            break;
         }

         if (commandBlockTileEntity.isPowered() || commandBlockTileEntity.isAuto()) {
            CommandBlockLogic commandBlockLogic = commandBlockTileEntity.getCommandBlockLogic();
            if (commandBlockTileEntity.setConditionMet()) {
               if (!commandBlockLogic.trigger(world)) {
                  break;
               }

               world.updateComparatorOutputLevel(blockpos$mutable, block);
            } else if (commandBlockTileEntity.isConditional()) {
               commandBlockLogic.setSuccessCount(0);
            }
         }
      }

      if (i <= 0) {
         int j = Math.max(gamerules.getInt(GameRules.MAX_COMMAND_CHAIN_LENGTH), 0);
         LOGGER.warn("Friszern chain tried to execute more than {} steps!", j);
      }

   }
}