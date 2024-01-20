package com.babcsany.minecraft.ervin_mod_1.item.special;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
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
import java.util.Objects;

public class DefItem extends Item {
	
	public DefItem(Properties properties) {
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
		return enchantment.isAllowedOnBooks() && stack.hasEffect();
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.create("test", TextFormatting.DARK_RED);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 500, 255));
		worldIn.setRainStrength(1.0f);

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockItemInit.DEFERRED_BLOCK.get().getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 600;
	}

	public enum ModRarity implements IExtensibleEnum {
		TEST(TextFormatting.DARK_RED);

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
		if (context.getWorld().getBlockState(context.getPos()).getBlock() == BlockItemInit.DEFERRED_BLOCK.get()) {
			for (ItemStack stack : Objects.requireNonNull(context.getPlayer()).inventory.mainInventory) {
				if (stack.isEmpty()) {
					context.getPlayer().addItemStackToInventory(new ItemStack(isBurnableSpecialItemInit.DEF_ITEM.get()));
					context.getItem().damageItem(1, context.getPlayer(), (playerIn) -> playerIn.sendBreakAnimation(context.getHand()));
					return ActionResultType.SUCCESS;
				}
			}
			context.getWorld().addEntity(new ItemEntity(context.getWorld(), context.getPos().getX(),
					context.getPos().getY(), context.getPos().getZ(), new ItemStack(isBurnableSpecialItemInit.DEF_ITEM.get())));
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}