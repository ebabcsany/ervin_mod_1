package com.babcsany.minecraft.ervin_mod_1.item.special;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.util.KeyboardHelper;
import com.babcsany.minecraft.ervin_mod_1.util.text.TextFormatting1;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtensibleEnum;

import java.util.List;

public class Troif extends Item {

	public Troif(Properties properties) {
		super(properties);
	}

	@Override
	public Item asItem() {
		return super.asItem();
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.create("test", TextFormatting.fromColorIndex(102134634));
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.getEntityWorld().setBlockState(entity.getPosition().down(), isBurnableBlockItemInit.NIRTKB.get().getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}

	public enum ModRarity implements IExtensibleEnum {
		TEST(TextFormatting.fromColorIndex(32456));

		public final TextFormatting color;

		ModRarity(TextFormatting format) {
			this.color = format;
		}

		public static ModRarity create(String name, TextFormatting format) {
			throw new IllegalStateException("Enum not extended");
		}
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 1200;
	}
}