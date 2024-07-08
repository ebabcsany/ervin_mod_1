package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.$TraderTrades;
import com.google.common.collect.Sets;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Set;

public abstract class Abstract$TraderEntity extends AgeableEntity implements INPC, IMerchant {
    private static final DataParameter<Integer> SHAKE_HEAD_TICKS = EntityDataManager.createKey(Abstract$TraderEntity.class, DataSerializers.VARINT);
    private int timeUntilNextItem = super.rand.nextInt(4163) * 6;
    @Nullable
    private PlayerEntity customer;
    @Nullable
    protected MerchantOffers offers;
    private final Inventory $traderInventory = new Inventory(8);
    private Item spawnEgg = ModSpawnEggItemInit.SPAWN_EGG_1;
    private Item droppedItem = null;
    private int despawnDelay = 0;
    private int xp = 0;
    public final boolean hasXpBar = this.hasXPBar();

    public Abstract$TraderEntity(EntityType<? extends Abstract$TraderEntity> type, World worldIn) {
        super(type, worldIn);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 16.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1.0F);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote) {
            this.handleDespawn();
        }
        if (isSpawnItem()) {
            int nextTimeUntilNextItem = super.rand.nextInt(8321) - 1857;
            this.dropItem(this.timeUntilNextItem, ItemInit.FIRT, nextTimeUntilNextItem);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        if (spawnDataIn == null) {
            spawnDataIn = new AgeableData(false);
        }

        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D).createMutableAttribute(Attributes.MAX_HEALTH, 16.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    public int getShakeHeadTicks() {
        return this.dataManager.get(SHAKE_HEAD_TICKS);
    }

    public void setShakeHeadTicks(int ticks) {
        this.dataManager.set(SHAKE_HEAD_TICKS, ticks);
    }

    public int getXp() {
        return this.xp;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? 0.81F : 1.62F;
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SHAKE_HEAD_TICKS, 0);
    }

    public void setCustomer(@Nullable PlayerEntity player) {
        this.customer = player;
    }

    @Nullable
    public PlayerEntity getCustomer() {
        return this.customer;
    }

    public boolean hasCustomer() {
        return this.customer != null;
    }

    protected void setSpawnEgg(SpawnEggItem spawnEgg) {
        this.spawnEgg = spawnEgg;
    }

    protected ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() != this.spawnEgg && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
            if (hand == Hand.MAIN_HAND) {
                player.addStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.getOffers().isEmpty() && !this.world.isRemote) {
                this.setCustomer(player);
                this.openMerchantContainer(player, this.getDisplayName(), 1);
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.getEntityInteractionResult(player, hand);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void setClientSideOffers(@Nullable MerchantOffers offers) {
        this.offers = offers;
    }

    @Override
    public void setXP(int xpIn) {
        this.xp = xpIn;
    }



    public void setDespawnDelay(int delay) {
        this.despawnDelay = delay;
    }

    public int getDespawnDelay() {
        return this.despawnDelay;
    }

    private void handleDespawn() {
        if (this.getDespawnDelay() > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
            this.remove();
        }
    }

    public boolean isSpawnItem() {
        return this.spawnEgg == ModSpawnEggItemInit.SPAWN_EGG_1;
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return null;
    }

    /**
     * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
     * being played depending if the suggested itemstack is not null.
     */
    @Override
    public void verifySellingItem(ItemStack stack) {
        if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playSound(this.get$TraderYesNoSound(!stack.isEmpty()), this.getSoundVolume(), this.getSoundPitch());
        }
    }

    protected void dropItem(int timeUntilNextItem, Item droppedItem, int nextTimeUntilNextItem) {
        this.setTimeUntilNextItem(timeUntilNextItem);
        this.setDroppedItem(droppedItem);
        this.dropItem(nextTimeUntilNextItem);
    }

    protected void dropItem(int nextTimeUntilNextItem) {
        if (this.isDropItem()) {
            this.dropItem();
            this.setTimeUntilNextItem(nextTimeUntilNextItem);
        }
    }

    protected void dropItem() {
        if (this.isDropItem()) {
            this.entityDropItem(this.droppedItem);
        }
    }

    protected void setTimeUntilNextItem(int timeUntilNextItem) {
        this.timeUntilNextItem = timeUntilNextItem;
    }

    protected void setDroppedItem(Item droppedItem) {
        this.droppedItem = droppedItem;
    }

    public SoundEvent getYesSound() {
        return SoundEvents.AMBIENT_CAVE;
    }

    public SoundEvent getNoSound() {
        return SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS;
    }

    protected SoundEvent get$TraderYesNoSound(boolean getYesSound) {
        return getYesSound ? this.getYesSound() : this.getNoSound();
    }

    public void playCelebrateSound() {
        this.playSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, this.getSoundVolume(), this.getSoundPitch());
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("DespawnDelay", this.despawnDelay);
        MerchantOffers merchantoffers = this.getOffers();
        if (!merchantoffers.isEmpty()) {
            compound.put("Offers", merchantoffers.write());
        }

        compound.put("Inventory", this.$traderInventory.write());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("DespawnDelay", 99)) {
            this.despawnDelay = compound.getInt("DespawnDelay");
        }

        if (compound.contains("Offers", 10)) {
            this.offers = new MerchantOffers(compound.getCompound("Offers"));
        }

        this.$traderInventory.read(compound.getList("Inventory", 10));
    }

    @Nullable
    @Override
    public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        this.resetCustomer();
        return super.changeDimension(server, teleporter);
    }

    protected void resetCustomer() {
        this.setCustomer(null);
    }

    public boolean hasXPBar() {
        return false;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        this.resetCustomer();
        this.playCelebrateSound();
        this.spawnParticles(ParticleTypes.ASH);
    }

    @OnlyIn(Dist.CLIENT)
    protected void spawnParticles(IParticleData particleData) {
        for (int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(particleData, this.getPosXRandom(1.0D), this.getPosYRandom() + 1.0D, this.getPosZRandom(1.0D), d0, d1, d2);
        }
    }

    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    @Override
    public boolean canRestockTrades() {
        return true;
    }

    public Inventory get$TraderInventory() {
        return this.$traderInventory;
    }

    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
            return true;
        } else {
            int i = inventorySlot - 300;
            if (i >= 0 && i < this.$traderInventory.getSizeInventory()) {
                this.$traderInventory.setInventorySlotContents(i, itemStackIn);
                return true;
            } else {
                return false;
            }
        }
    }

    public World getWorld() {
        return this.world;
    }

    /**
     * add limites numbers of trades to the given MerchantOffers
     */
    protected void add$TraderTrades(MerchantOffers givenMerchantOffers, $TraderTrades.ITrade[] newTrades, int maxNumbers) {
        Set<Integer> set = Sets.newHashSet();
        if (newTrades.length > maxNumbers) {
            while (set.size() < maxNumbers) {
                set.add(this.rand.nextInt(newTrades.length));
            }
        } else {
            for (int i = 0; i < newTrades.length; ++i) {
                set.add(i);
            }
        }

        for (Integer integer : set) {
            $TraderTrades.ITrade $tradertrades$itrade = newTrades[integer];
            MerchantOffer merchantoffer = $tradertrades$itrade.getOffer(this, this.rand);
            if (merchantoffer != null) {
                givenMerchantOffers.add(merchantoffer);
            }
        }
    }

    protected boolean isDropItem() {
        return this.droppedItem != null && !this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilNextItem <= 0;
    }

    protected boolean isNoDropItem() {
        return !this.isDropItem();
    }
}