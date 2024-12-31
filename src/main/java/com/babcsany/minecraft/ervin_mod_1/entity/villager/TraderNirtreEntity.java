package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.NirtreLookAtCustomerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.NirtreTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.TraderNirtreTrades;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialItemInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class TraderNirtreEntity extends AbstractNirtreEntity {
    @Nullable
    private BlockPos traderNirtreTarget;
    public int timeUntilNextItem = this.rand.nextInt(8000) + 8000;
    private final int fire = -this.getFireImmuneTicks();
    public float wingRotation;
    public float wingRotDelta = 1.0F;
    public boolean dropItem;

    public TraderNirtreEntity(EntityType<? extends TraderNirtreEntity> type, World worldIn) {
        super(type, worldIn);
        super.setSpawnEgg((SpawnEggItem) ModSpawnEggItemInit.TRADER_NIRTRE_SPAWN_EGG.get());
        this.forceSpawn = true;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(-1, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_INVISIBILITY), SoundEvents.ENTITY_GENERIC_DRINK, (trader) -> !this.world.isDaytime() && !trader.isInvisible()));
        this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_GENERIC_DRINK, (trader) -> this.world.isDaytime() && trader.isInvisible()));
        this.goalSelector.addGoal(-1, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_NIGHT_VISION), SoundEvents.ENTITY_GENERIC_DRINK, (trader) -> !this.world.isRaining() && !trader.isInvisible()));
        this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_GENERIC_DRINK, (trader) -> this.world.isRaining() && trader.isInvisible()));
        this.goalSelector.addGoal(-1, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_FIRE_RESISTANCE), SoundEvents.ENTITY_GENERIC_DRINK, (trader) -> !this.world.isNightTime() && !trader.isInvisible()));
        this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_GENERIC_DRINK, (trader) -> this.world.isNightTime() && trader.isInvisible()));
        this.goalSelector.addGoal(1, new NirtreTradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new NirtreLookAtCustomerGoal(this));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
        this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 1600.0D).createMutableAttribute(Attributes.MAX_HEALTH, 400.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    protected void populateTradeData() {
        TraderNirtreTrades.ITrade[] avillagernirtretrades$itrade = TraderNirtreTrades.field_221240_b.get(1);
        if (avillagernirtretrades$itrade != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.addTraderNirtreTrades(merchantoffers, avillagernirtretrades$itrade, 10);
            int i = this.rand.nextInt(avillagernirtretrades$itrade.length);
            TraderNirtreTrades.ITrade villagertrades$itrade = avillagernirtretrades$itrade[i];
            MerchantOffer merchantoffer = villagertrades$itrade.getOffer(this, this.rand);
            if (merchantoffer != null) {
                merchantoffers.add(merchantoffer);
            }
        }
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return EntityInit.TRADER_NIRTRE_ENTITY.get().create(world);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.traderNirtreTarget != null) {
            compound.put("TraderNirtreTarget", NBTUtil.writeBlockPos(this.traderNirtreTarget));
        }

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("TraderNirtreTarget")) {
            this.traderNirtreTarget = NBTUtil.readBlockPos(compound.getCompound("TraderNirtreTarget"));
        }

        this.setGrowingAge(Math.max(0, this.getGrowingAge()));
    }

    protected void onNirtreTrade(MerchantOffer offer) {
        if (offer.getDoesRewardExp()) {
            int i = 3 + this.rand.nextInt(4);
            this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
        }

    }

    protected SoundEvent getAmbientSound() {
        return this.hasCustomer() ? SoundEvents.ENTITY_WANDERING_TRADER_TRADE : SoundEvents.ENTITY_WANDERING_TRADER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_WANDERING_TRADER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_DEATH;
    }

    public void setWanderTarget(@Nullable BlockPos pos) {
        this.traderNirtreTarget = pos;
    }

    @Nullable
    private BlockPos getWanderTarget() {
        return this.traderNirtreTarget;
    }

    public void livingTick() {
        super.livingTick();
        this.wingRotation += this.wingRotDelta * 2.0F;
        int nextTimeUntilNextItem = this.rand.nextInt(12000) + 12000;
        Item droppedItem = SpecialItemInit.TFJHU_1.get();
        super.dropItem(this.timeUntilNextItem, droppedItem, nextTimeUntilNextItem);
        this.timeUntilNextItem = nextTimeUntilNextItem;
    }
}