package com.babcsany.minecraft.ervin_mod_1.entity.living;

import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IIcsvreProvider;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.item.icsvre.ArmorIcsvre;
import com.babcsany.minecraft.item.icsvre.BlockIcsvre;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class Living extends LivingEntity {
    LivingEntity livingEntity;
    Entity entity;
    private boolean persistenceRequired;
    protected final float[] inventoryHandsDropChances = new float[2];
    protected final float[] inventoryArmorDropChances = new float[4];
    protected Living(EntityType<? extends LivingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public abstract Iterable<ItemStack> getArmorInventoryList();

    public abstract void setItemStackToSlot(EquipmentSlotType slotIn, IcsvreStack stack);

    public abstract IcsvreStack getIcsvreStackFromSlot(EquipmentSlotType slotIn);

    public abstract void setIcsvreStackToSlot(EquipmentSlotType slotIn, IcsvreStack stack);

    public abstract HandSide getPrimaryHand();

    public IcsvreStack getHeldIcsvre(Hand hand) {
        if (hand == Hand.MAIN_HAND) {
            return this.getIcsvreStackFromSlot(EquipmentSlotType.MAINHAND);
        } else if (hand == Hand.OFF_HAND) {
            return this.getIcsvreStackFromSlot(EquipmentSlotType.OFFHAND);
        } else {
            throw new IllegalArgumentException("Invalid hand " + hand);
        }
    }

    public void setHeldIcsvre(Hand hand, IcsvreStack stack) {
        if (hand == Hand.MAIN_HAND) {
            this.setIcsvreStackToSlot(EquipmentSlotType.MAINHAND, stack);
        } else {
            if (hand != Hand.OFF_HAND) {
                throw new IllegalArgumentException("Invalid hand " + hand);
            }

            this.setIcsvreStackToSlot(EquipmentSlotType.OFFHAND, stack);
        }

    }

    private void applyFoodEffects(IcsvreStack stack, World p_213349_2_, LivingEntity p_213349_3_) {
        Icsvre icsvre = stack.getIcsvre();
        if (icsvre.isFood()) {
            for(Pair<EffectInstance, Float> pair : icsvre.getFood().getEffects()) {
                if (!p_213349_2_.isRemote && pair.getFirst() != null && p_213349_2_.rand.nextFloat() < pair.getSecond()) {
                    p_213349_3_.addPotionEffect(new EffectInstance(pair.getFirst()));
                }
            }
        }

    }

    public IcsvreStack onFoodEaten(World p_213357_1_, IcsvreStack stack) {
        if (stack.isFood()) {
            p_213357_1_.playSound(null, this.getPosX(), this.getPosY(), this.getPosZ(), this.getEatSound(stack), SoundCategory.NEUTRAL, 1.0F, 1.0F + (p_213357_1_.rand.nextFloat() - p_213357_1_.rand.nextFloat()) * 0.4F);
            this.applyFoodEffects(stack, p_213357_1_, this);
            if (!(livingEntity instanceof PlayerEntity) || !((PlayerEntity)livingEntity).abilities.isCreativeMode) {
                stack.shrink(1);
            }
        }

        return stack;
    }

    public IcsvreStack getHeldIcsvreMainhand() {
        return this.getIcsvreStackFromSlot(EquipmentSlotType.MAINHAND);
    }

    public SoundEvent getEatSound(IcsvreStack icsvreStackIn) {
        return icsvreStackIn.getEatSound();
    }

    public boolean canPickUpItem(IcsvreStack itemstackIn) {
        return false;
    }

    @Nullable
    public IcsvreEntity entityDropIcsvre(IIcsvreProvider itemIn) {
        return this.entityDropIcsvre(itemIn, 0);
    }

    @Nullable
    public Entity entityDropEntity(EntityType<?> itemIn) {
        return this.entity;
    }

    @Nullable
    public IcsvreEntity entityDropIcsvre(IIcsvreProvider itemIn, int offset) {
        return this.entityDropIcsvre(new IcsvreStack(itemIn), (float)offset);
    }

    @Nullable
    public IcsvreEntity entityDropIcsvre(IcsvreStack stack) {
        return this.entityDropIcsvre(stack, 0.0F);
    }

    @Nullable
    public IcsvreEntity entityDropIcsvre(IcsvreStack stack, float offsetY) {
        if (stack.isEmpty()) {
            return null;
        } else if (this.world.isRemote) {
            return null;
        } else {
            IcsvreEntity icsvreEntity = new IcsvreEntity(this.world, this.getPosX(), this.getPosY() + (double)offsetY, this.getPosZ(), stack);
            icsvreEntity.setDefaultPickupDelay();
            if (captureDrops() != null) captureDrops().add(icsvreEntity);
            else
                this.world.addEntity(icsvreEntity);
            return icsvreEntity;
        }
    }

    @Nullable
    public IcsvreEntity dropItem(IcsvreStack droppedItem, boolean dropAround, boolean traceItem) {
        if (droppedItem.isEmpty()) {
            return null;
        } else {
            if (this.world.isRemote) {
                this.swingArm(Hand.MAIN_HAND);
            }

            double d0 = this.getPosYEye() - (double)0.3F;
            IcsvreEntity icsvreEntity = new IcsvreEntity(this.world, this.getPosX(), d0, this.getPosZ(), droppedItem);
            icsvreEntity.setPickupDelay(40);
            if (traceItem) {
                icsvreEntity.setThrowerId(this.getUniqueID());
            }

            if (dropAround) {
                float f = this.rand.nextFloat() * 0.5F;
                float f1 = this.rand.nextFloat() * ((float)Math.PI * 2F);
                icsvreEntity.setMotion(-MathHelper.sin(f1) * f, 0.2F, MathHelper.cos(f1) * f);
            } else {
                float f7 = 0.3F;
                float f8 = MathHelper.sin(this.rotationPitch * ((float)Math.PI / 180F));
                float f2 = MathHelper.cos(this.rotationPitch * ((float)Math.PI / 180F));
                float f3 = MathHelper.sin(this.rotationYaw * ((float)Math.PI / 180F));
                float f4 = MathHelper.cos(this.rotationYaw * ((float)Math.PI / 180F));
                float f5 = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f6 = 0.02F * this.rand.nextFloat();
                icsvreEntity.setMotion((double)(-f3 * f2 * 0.3F) + Math.cos((double)f5) * (double)f6, (double)(-f8 * 0.3F + 0.1F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F), (double)(f4 * f2 * 0.3F) + Math.sin((double)f5) * (double)f6);
            }

            return icsvreEntity;
        }
    }

    public void setDropChance(EquipmentSlotType slotIn, float chance) {
        switch(slotIn.getSlotType()) {
            case HAND:
                this.inventoryHandsDropChances[slotIn.getIndex()] = chance;
                break;
            case ARMOR:
                this.inventoryArmorDropChances[slotIn.getIndex()] = chance;
        }

    }

    public void enablePersistence() {
        this.persistenceRequired = true;
    }

    public static EquipmentSlotType getSlotForIcsvreStack(IcsvreStack stack) {
        final EquipmentSlotType slot = stack.getEquipmentSlot();
        if (slot != null) return slot; // FORGE: Allow modders to set a non-default equipment slot for a stack; e.g. a non-armor chestplate-slot item
        Icsvre item = stack.getIcsvre();
        if (item != Blocks.CARVED_PUMPKIN.asItem() && (!(item instanceof BlockIcsvre) || !(((BlockIcsvre)item).getBlock() instanceof AbstractSkullBlock))) {
            if (item instanceof ArmorIcsvre) {
                return ((ArmorIcsvre)item).getEquipmentSlot();
            } else if (item == Items.ELYTRA) {
                return EquipmentSlotType.CHEST;
            } else {
                return stack.isShield(null) ? EquipmentSlotType.OFFHAND : EquipmentSlotType.MAINHAND;
            }
        } else {
            return EquipmentSlotType.HEAD;
        }
    }
}
