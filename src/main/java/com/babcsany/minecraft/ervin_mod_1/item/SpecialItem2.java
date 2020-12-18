package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtensibleEnum;

import java.util.List;

public class SpecialItem2 extends Item {

	public SpecialItem2(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (KeyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("Test Information"));
		} else {
			tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public Item asItem() {
		return super.asItem();
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		if (enchantment.isAllowedOnBooks() && stack.hasEffect()) {
			return true;
		}
		return false;
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.create("test", TextFormatting.BLUE);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 10000, 10000));
		playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 10000, 10000));
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10000, 10000));
		playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 10000, 10000));
		worldIn.setRainStrength(2000.0f);

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.getEntityWorld().setBlockState(entity.getPosition().down(), isBurnableBlockItemInit.NIRK_BLOCK.get().getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 1200;
	}

	public enum ModRarity implements IExtensibleEnum {
		TEST(TextFormatting.BLUE);

		public final TextFormatting color;

		private ModRarity(TextFormatting format) {
			this.color = format;
		}

		public static ModRarity create(String name, TextFormatting format) {
			throw new IllegalStateException("Enum not extended");
		}
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (context.getWorld().getBlockState(context.getPos()).getBlock() == BlockItemInit.VIRK_BLOCK.get()) {
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) {
				if (stack.isEmpty()) {
					context.getPlayer().addItemStackToInventory(new ItemStack(ItemInit.FIRK.get()));
					context.getItem().damageItem(5, context.getPlayer(), (playerIn) -> {
						playerIn.sendBreakAnimation(context.getHand());
					});
					return ActionResultType.SUCCESS;
				}
			}
			context.getWorld().addEntity(new ItemEntity(context.getWorld(), context.getPos().getX(),
					context.getPos().getY(), context.getPos().getZ(), new ItemStack(ItemInit.FIRK.get())));
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}