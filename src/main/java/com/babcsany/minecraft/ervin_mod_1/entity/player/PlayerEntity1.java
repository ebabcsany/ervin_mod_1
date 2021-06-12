package com.babcsany.minecraft.ervin_mod_1.entity.player;

import com.babcsany.minecraft.ervin_mod_1.block.FriszernTileEntity;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.OptionalInt;

public abstract class PlayerEntity1 extends PlayerEntity {
    private final CooldownTracker cooldownTracker = this.createCooldownTracker();
    private ItemStack itemStackMainHand = ItemStack.EMPTY;
    private int sleepTimer;

    public PlayerEntity1(World world, BlockPos pos, GameProfile gameProfile) {
        super(world, pos, gameProfile);
    }

    public void openFriszern(FriszernTileEntity friszern) {
    }

    public OptionalInt openContainer(@Nullable INamedContainerProvider p_213829_1_) {
        return OptionalInt.empty();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        net.minecraftforge.fml.hooks.BasicEventHooks.onPlayerPreTick(this);
        this.noClip = this.isSpectator();
        if (this.isSpectator()) {
            this.onGround = false;
        }

        if (this.xpCooldown > 0) {
            --this.xpCooldown;
        }

        if (this.isSleeping()) {
            ++this.sleepTimer;
            if (this.sleepTimer > 100) {
                this.sleepTimer = 100;
            }

            if (!this.world.isRemote && !net.minecraftforge.event.ForgeEventFactory.fireSleepingTimeCheck(this, getBedPosition())) {
                this.stopSleepInBed(false, true);
            }
        } else if (this.sleepTimer > 0) {
            ++this.sleepTimer;
            if (this.sleepTimer >= 110) {
                this.sleepTimer = 0;
            }
        }

        this.updateEyesInWaterPlayer();
        super.tick();
        if (!this.world.isRemote && this.openContainer != null && !this.openContainer.canInteractWith(this)) {
            this.closeScreen();
            this.openContainer = this.container;
        }

        this.updateCape();
        if (!this.world.isRemote) {
            this.foodStats.tick(this);
            this.addStat(Stats.PLAY_ONE_MINUTE);
            if (this.isAlive()) {
                this.addStat(Stats.TIME_SINCE_DEATH);
            }

            if (this.isDiscrete()) {
                this.addStat(Stats.SNEAK_TIME);
            }

            if (!this.isSleeping()) {
                this.addStat(Stats.TIME_SINCE_REST);
            }
        }

        int i = 29999999;
        double d0 = MathHelper.clamp(this.getPosX(), -2.9999999E7D, 2.9999999E7D);
        double d1 = MathHelper.clamp(this.getPosZ(), -2.9999999E7D, 2.9999999E7D);
        if (d0 != this.getPosX() || d1 != this.getPosZ()) {
            this.setPosition(d0, this.getPosY(), d1);
        }

        ++this.ticksSinceLastSwing;
        ItemStack itemstack = this.getHeldItemMainhand();
        if (!ItemStack.areItemStacksEqual(this.itemStackMainHand, itemstack)) {
            if (!ItemStack.areItemsEqualIgnoreDurability(this.itemStackMainHand, itemstack)) {
                this.resetCooldown();
            }

            this.itemStackMainHand = itemstack.copy();
        }

        this.updateTurtleHelmet();
        this.updateTurtleHelmet1();
        this.cooldownTracker.tick();
        this.updatePose();
        net.minecraftforge.fml.hooks.BasicEventHooks.onPlayerPostTick(this);
    }

    private void updateTurtleHelmet() {
        ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (itemstack.getItem() == Items.TURTLE_HELMET && !this.areEyesInFluid(FluidTags.WATER)) {
            this.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        }

    }

    private void updateTurtleHelmet1() {
        ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        if (itemstack.getItem() == isBurnableSpecialItemInit.DEBUG_SRIUNK_STICK.get()) {
            this.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 200, 100, false, false, true));
        }
        if (itemstack.getItem() == isBurnableSpecialItemInit.GRITH.get()) {
            this.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 1000, 50, false, false, true));
        }

    }

    private void updateCape() {
        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        double d0 = this.getPosX() - this.chasingPosX;
        double d1 = this.getPosY() - this.chasingPosY;
        double d2 = this.getPosZ() - this.chasingPosZ;
        double d3 = 10.0D;
        if (d0 > 10.0D) {
            this.chasingPosX = this.getPosX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 > 10.0D) {
            this.chasingPosZ = this.getPosZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 > 10.0D) {
            this.chasingPosY = this.getPosY();
            this.prevChasingPosY = this.chasingPosY;
        }

        if (d0 < -10.0D) {
            this.chasingPosX = this.getPosX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 < -10.0D) {
            this.chasingPosZ = this.getPosZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 < -10.0D) {
            this.chasingPosY = this.getPosY();
            this.prevChasingPosY = this.chasingPosY;
        }

        this.chasingPosX += d0 * 0.25D;
        this.chasingPosZ += d2 * 0.25D;
        this.chasingPosY += d1 * 0.25D;
    }
}
