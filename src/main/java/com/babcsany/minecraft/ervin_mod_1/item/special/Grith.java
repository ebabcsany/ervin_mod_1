package com.babcsany.minecraft.ervin_mod_1.item.special;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.block.Grith_Block;
import com.google.common.collect.Maps;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Map;

public class Grith extends Item {
	private boolean potionsNeedUpdate = true;
	private final Map<Effect, EffectInstance> activePotionsMap = Maps.newHashMap();
	public PlayerEntity player;
	public final PlayerInventory inventory = new PlayerInventory(player);
	public World world;
	private AttributeModifierManager attributes;
	Grith_Block grith_block;
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

	public void tick(LivingEntity living) {
		this.updateTurtleHelmet(living);
	}

	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		if (grith_block.onEntityItemUpdateDown(stack, entity)) {
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
		} else {
			return false;
		}

		return super.onEntityItemUpdate(stack, entity);
	}

	private void updateTurtleHelmet(LivingEntity living) {
		ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
		if (itemstack.getItem() == isBurnableSpecialItemInit.GRITH.get()) {
			this.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 1000, 50, false, false, true), living);
		}

	}

	public boolean addPotionEffect(EffectInstance effectInstanceIn, LivingEntity living) {
		if (!living.isPotionApplicable(effectInstanceIn)) {
			return false;
		} else {
			EffectInstance effectinstance = this.activePotionsMap.get(effectInstanceIn.getPotion());
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.living.PotionEvent.PotionAddedEvent(living, effectinstance, effectInstanceIn));
			if (effectinstance == null) {
				this.activePotionsMap.put(effectInstanceIn.getPotion(), effectInstanceIn);
				this.onNewPotionEffect(effectInstanceIn, living);
				return true;
			} else if (effectinstance.combine(effectInstanceIn)) {
				this.onChangedPotionEffect(effectinstance, true, living);
				return true;
			} else {
				return false;
			}
		}
	}

	public AttributeModifierManager getAttributeManager() {
		return this.attributes;
	}

	protected void onNewPotionEffect(EffectInstance id, LivingEntity living) {
		this.potionsNeedUpdate = true;
		if (!this.world.isRemote) {
			id.getPotion().applyAttributesModifiersToEntity(living, this.getAttributeManager(), id.getAmplifier());
		}

	}

	protected void onChangedPotionEffect(EffectInstance id, boolean reapply, LivingEntity living) {
		this.potionsNeedUpdate = true;
		if (reapply && !this.world.isRemote) {
			Effect effect = id.getPotion();
			effect.removeAttributesModifiersFromEntity(living, this.getAttributeManager(), id.getAmplifier());
			effect.applyAttributesModifiersToEntity(living, this.getAttributeManager(), id.getAmplifier());
		}

	}

	public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn) {
		if (slotIn == EquipmentSlotType.MAINHAND) {
			return player.inventory.getCurrentItem();
		} else if (slotIn == EquipmentSlotType.OFFHAND) {
			return player.inventory.offHandInventory.get(0);
		} else {
			return slotIn.getSlotType() == EquipmentSlotType.Group.ARMOR ? player.inventory.armorInventory.get(slotIn.getIndex()) : ItemStack.EMPTY;
		}
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (context.getWorld().getBlockState(context.getPos()).getBlock() == BlockInit.GRITH_BLOCK.get()) {
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) {
				if (stack.isEmpty()) {
					context.getPlayer().addItemStackToInventory(new ItemStack(isBurnableSpecialItemInit.GRITH.get()));
					context.getItem().damageItem(1, context.getPlayer(), (playerIn) -> {
						playerIn.sendBreakAnimation(context.getHand());
					});
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