package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.AbstractModBlock;
import com.babcsany.minecraft.ervin_mod_1.block.ModBlock;
import com.babcsany.minecraft.ervin_mod_1.block.ModBlock_T;
import com.babcsany.minecraft.ervin_mod_1.container.trader.TraderBlockContainer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.OptionalInt;

public class TraderBlock extends ModBlock_T<ModBlock> {
    public AbstractModBlock modBlock;
    public TraderBlock(AbstractBlock.Properties properties, AbstractModBlock.Properties modProperties) {
        super(properties, modProperties);
    }

    private static final ITextComponent field_220271_a = new TranslationTextComponent(Ervin_mod_1.MOD_ID,"block.ervin_mod_1.trader_block");

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            player.openContainer(state.getContainer(worldIn, pos));
            player.addStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
            return ActionResultType.SUCCESS;
        }
    }

    public OptionalInt openContainer(@Nullable INamedContainerProvider p_213829_1_) {
        return OptionalInt.empty();
    }

    /*public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else if (player.getHeldItemMainhand().isItemEqual(new ItemStack(() -> ItemInit.END_STONE_STIK.get())) && !player.isCreative()) {
            player.openContainer(state.getContainer(worldIn, pos));
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        } else {
            return ActionResultType.PASS;
        }
    }*/

    /*@Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult raytraceResult) {
        if (player.getHeldItemMainhand().isItemEqual(new ItemStack(ItemInit.END_STONE_STIK::get)) && !player.isCreative()) {
            return super.onBlockActivated(state, world, blockPos, player, hand, raytraceResult);
        } else {
            return ActionResultType.PASS;
        }
    }*/

    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((p_220270_2_, p_220270_3_, p_220270_4_) -> new TraderBlockContainer(p_220270_2_, p_220270_3_), field_220271_a);
    }
}
