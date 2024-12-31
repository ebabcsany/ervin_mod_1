package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.$TraderLookAtCustomerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.$TraderTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.$TraderTrades;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.trigger.ModCriteriaTriggers;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Objects;

public class $TraderEntity extends Abstract$TraderEntity {
    @Nullable
    private BlockPos $traderTarget;

    public $TraderEntity(EntityType<? extends $TraderEntity> type, World worldIn) {
        super(type, worldIn);
        super.setSpawnEgg((SpawnEggItem) ModSpawnEggItemInit.$_TRADER.get());
        this.forceSpawn = true;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new $TraderTradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new $TraderLookAtCustomerGoal(this));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
        this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
    }

    protected void populateTradeData() {
        $TraderTrades.ITrade[] a$tradertrades$itrade = $TraderTrades.field_221240_b.get(1);
        if (a$tradertrades$itrade != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.add$TraderTrades(merchantoffers, a$tradertrades$itrade, 10);
            int i = this.rand.nextInt(a$tradertrades$itrade.length);
            $TraderTrades.ITrade $tradertrades$itrade = a$tradertrades$itrade[i];
            MerchantOffer merchantoffer = $tradertrades$itrade.getOffer(this, this.rand);
            if (merchantoffer != null) {
                merchantoffers.add(merchantoffer);
            }
        }
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.$traderTarget != null) {
            compound.put("$traderTarget", NBTUtil.writeBlockPos(this.get$traderTarget()));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("$traderTarget")) {
            this.set$traderTarget(NBTUtil.readBlockPos(compound.getCompound("$traderTarget")));
        }

        this.setGrowingAge(Math.max(0, this.getGrowingAge()));
    }

    @Override
    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.populateTradeData();
        }

        return this.offers;
    }

    public void onTrade(MerchantOffer offer) {
        offer.increaseUses();
        this.livingSoundTime = -this.getTalkInterval();
        this.on$TraderTrade(offer);
        if (super.getCustomer() instanceof ServerPlayerEntity) {
            ModCriteriaTriggers.$_TRADER_TRADE.test((ServerPlayerEntity) super.getCustomer(), this, offer.getSellingStack());
        }
    }

    protected void on$TraderTrade(MerchantOffer offer) {
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

    protected SoundEvent getDrinkSound(ItemStack stack) {
        Item item = stack.getItem();
        return item == Items.MILK_BUCKET ? SoundEvents.ENTITY_WANDERING_TRADER_DRINK_MILK : SoundEvents.ENTITY_WANDERING_TRADER_DRINK_POTION;
    }

    public SoundEvent getYesSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_YES;
    }

    public SoundEvent getNoSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_NO;
    }

    public AgeableEntity createChild(ServerWorld serverWorld, AgeableEntity ageable) {
        return Objects.requireNonNull(EntityInit.$_TRADER.get().create(serverWorld));
    }

    public void set$traderTarget(@Nullable BlockPos pos) {
        this.$traderTarget = pos;
    }

    @Nullable
    private BlockPos get$traderTarget() {
        return this.$traderTarget;
    }
}