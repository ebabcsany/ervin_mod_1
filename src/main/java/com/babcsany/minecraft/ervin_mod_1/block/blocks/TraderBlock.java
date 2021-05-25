package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.trader_block.trades.TraderBlockTrades;
import com.babcsany.minecraft.ervin_mod_1.container.CraintBlockCraftingTableContainer;
import com.babcsany.minecraft.ervin_mod_1.container.merchant.ZurContainer;
import com.babcsany.minecraft.ervin_mod_1.container.trader.TraderBlockContainer;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.$TraderTrades;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.MerchantContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.Set;

public class TraderBlock extends Block {
    public TraderBlock(Properties properties) { super(properties); }

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
