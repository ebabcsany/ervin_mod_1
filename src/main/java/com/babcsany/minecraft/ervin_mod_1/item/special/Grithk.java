package com.babcsany.minecraft.ervin_mod_1.item.special;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Objects;

public class Grithk extends Item {
	public Grithk(Properties properties) {
		super(properties);
	}

	public Item asItem() {
		return super.asItem();
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn, Throwable causeIn, String descriptionIn) {
		//worldIn.isRainingAt(BlockPos.fromLong(playerIn.getPosition().toLong()));
		worldIn.isRainingAt(playerIn.getPosition());
		worldIn.isRainingAt(playerIn.getPosition().east(10));
		worldIn.isRainingAt(playerIn.getPosition().north(10));
		worldIn.isRainingAt(playerIn.getPosition().south(10));
		worldIn.isRainingAt(playerIn.getPosition().west(10));
		//worldIn.isRaining();
		//worldIn.isThundering();
		//worldIn.fillCrashReport(CrashReport.makeCrashReport(causeIn, descriptionIn));
		worldIn.setRainStrength(20.0f);

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.getEntityWorld().setBlockState(entity.getPosition().offset(Direction.UP), Blocks.AIR.getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (context.getWorld().getBlockState(context.getPos()).getBlock() == BlockInit.GRITH_BLOCK.get()) {
			for (ItemStack stack : Objects.requireNonNull(context.getPlayer()).inventory.mainInventory) {
				if (stack.isEmpty()) {
					context.getPlayer().addItemStackToInventory(new ItemStack(isBurnableSpecialItemInit.GRITH.get()));
					context.getItem().damageItem(1, context.getPlayer(), (playerIn) -> playerIn.sendBreakAnimation(context.getHand()));
					return ActionResultType.SUCCESS;
				}
			}
			context.getWorld().addEntity(new ItemEntity(context.getWorld(), context.getPos().getX(),
					context.getPos().getY(), context.getPos().getZ(), new ItemStack(isBurnableSpecialItemInit.GRITH.get())));
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}