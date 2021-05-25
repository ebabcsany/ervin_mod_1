package com.babcsany.minecraft.ervin_mod_1.item.special;

import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Grith extends Item {
	public Grith(Properties properties) {
		super(properties);
	}

	@Override
	public Item asItem() {
		return super.asItem();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 5000, 2550));
		playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1000, 51000));
		playerIn.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 20000, 20400));
		worldIn.setRainStrength(200.0f);

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.getEntityWorld().setBlockState(entity.getPosition().down(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().east(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().east().north(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().west(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().west().south(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().north(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().north().west(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().south(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down().south().east(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().east(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().east().north(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().west(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().west().south(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().north(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().north().west(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().south(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().up().south().east(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().east(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().east().north(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().west(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().west().south(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().north(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().north().west(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().south(), Blocks.AIR.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().south().east(), Blocks.AIR.getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}

	/**@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (context.getWorld().getBlockState(context.getPos()).getBlock() == isBurnableBlockItemInit.GRITH_BLOCK.get()) {
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) {
				if (stack.isEmpty()) {
					context.getPlayer().addItemStackToInventory(new ItemStack(isBurnableItemInit.GRITH.get()));
					context.getItem().damageItem(1, context.getPlayer(), (playerIn) -> {
						playerIn.sendBreakAnimation(context.getHand());
					});
					return ActionResultType.SUCCESS;
				}
			}
			context.getWorld().addEntity(new ItemEntity(context.getWorld(), context.getPos().getX(),
					context.getPos().getY(), context.getPos().getZ(), new ItemStack(isBurnableItemInit.GRITH.get())));
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}*/
}