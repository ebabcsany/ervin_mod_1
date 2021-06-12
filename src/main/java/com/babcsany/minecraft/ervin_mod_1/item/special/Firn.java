package com.babcsany.minecraft.ervin_mod_1.item.special;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.IExtensibleEnum;

public class Firn extends Item {

	public Firn(Properties properties) {
		super(properties);
	}

	@Override
	public Item asItem() {
		return super.asItem();
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.create("firn", TextFormatting.BLUE);
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.getEntityWorld().setBlockState(entity.getPosition().down(), isBurnableBlockItemInit.NIRK_BLOCK.get().getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 400;
	}

	public enum ModRarity implements IExtensibleEnum {
		TEST(TextFormatting.BLUE);

		public final TextFormatting color;

		ModRarity(TextFormatting format) {
			this.color = format;
		}

		public static ModRarity create(String name, TextFormatting format) {
			throw new IllegalStateException("Enum not extended");
		}
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (context.getWorld().getBlockState(context.getPos()).getBlock() == isBurnableBlockItemInit.NIRK_BLOCK.get()) {
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) {
				if (stack.isEmpty()) {
					context.getPlayer().addItemStackToInventory(new ItemStack(isBurnableSpecialItemInit.FIRN.get()));
					context.getItem().damageItem(5, context.getPlayer(), (playerIn) -> {
						playerIn.sendBreakAnimation(context.getHand());
					});
					return ActionResultType.SUCCESS;
				}
			}
			context.getWorld().addEntity(new ItemEntity(context.getWorld(), context.getPos().getX(),
					context.getPos().getY(), context.getPos().getZ(), new ItemStack(isBurnableSpecialItemInit.FIRN.get())));
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}