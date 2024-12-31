package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.ZombieTraderTrades;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.trigger.ModCriteriaTriggers;
import com.google.common.collect.Sets;
import net.minecraft.entity.*;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Set;

public abstract class AbstractZombieTraderEntity extends AgeableEntity implements INPC, IMerchant {
   private static final DataParameter<Integer> SHAKE_HEAD_TICKS = EntityDataManager.createKey(AbstractZombieTraderEntity.class, DataSerializers.VARINT);
   private int timeUntilNextItem = super.rand.nextInt(3897) * 5;
   @Nullable
   private PlayerEntity customer;
   @Nullable
   protected MerchantOffers offers;
   private final Inventory zombieTraderInventory = new Inventory(8);
   private Item droppedItem = null;
   private int xp = 0;
   private int despawnDelay;

   public AbstractZombieTraderEntity(EntityType<? extends AbstractZombieTraderEntity> type, World worldIn) {
      super(type, worldIn);
      this.setPathPriority(PathNodeType.DANGER_FIRE, 16.0F);
      this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1.0F);
   }

   public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      if (spawnDataIn == null) {
         spawnDataIn = new AgeableData(false);
      }

      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
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

   public MerchantOffers getOffers() {
      if (this.offers == null) {
         this.setClientSideOffers(new MerchantOffers());
         this.populateTradeData();
      }

      return this.offers;
   }

   @OnlyIn(Dist.CLIENT)
   public void setClientSideOffers(@Nullable MerchantOffers offers) {
      this.offers = offers;
   }

   public void setXP(int xpIn) {
      this.xp = xpIn;
   }

   public void onTrade(MerchantOffer offer) {
      offer.increaseUses();
      this.livingSoundTime = -this.getTalkInterval();
      this.onZombieTraderTrade(offer);
      if (this.customer instanceof ServerPlayerEntity) {
         ModCriteriaTriggers.ZOMBIE_TRADER_TRADE.test((ServerPlayerEntity)this.customer, this, offer.getSellingStack());
      }

   }

   protected abstract void onZombieTraderTrade(MerchantOffer offer);

   public boolean isSpawnItem() {
      return true;
   }

   /**
    * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
    * being played depending if the suggested itemstack is not null.
    */
   public void verifySellingItem(ItemStack stack) {
      if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
         this.livingSoundTime = -this.getTalkInterval();
         this.playSound(this.getZombieTraderYesNoSound(!stack.isEmpty()), this.getSoundVolume(), this.getSoundPitch());
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
      return SoundEvents.ENTITY_ZOMBIE_HURT;
   }

   public SoundEvent getNoSound() {
      return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
   }

   protected SoundEvent getZombieTraderYesNoSound(boolean getYesSound) {
      return getYesSound ? this.getYesSound() : this.getNoSound();
   }

   public void playCelebrateSound() {
      this.playSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, this.getSoundVolume(), this.getSoundPitch());
   }

   public void setDespawnDelay(int delay) {
      this.despawnDelay = delay;
   }

   public int getDespawnDelay() {
      return this.despawnDelay;
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
         this.dropItem(this.timeUntilNextItem, ItemInit.FIRT.get(), nextTimeUntilNextItem);
      }
   }

   private void handleDespawn() {
      if (this.despawnDelay > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
         this.remove();
      }
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("DespawnDelay", this.despawnDelay);
      MerchantOffers merchantoffers = this.getOffers();
      if (!merchantoffers.isEmpty()) {
         compound.put("Offers", merchantoffers.write());
      }

      compound.put("Inventory", this.zombieTraderInventory.write());
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

      this.zombieTraderInventory.read(compound.getList("Inventory", 10));
   }

   @Override
   public boolean hasXPBar() {
      return false;
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return false;
   }

   @Nullable
   public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
      this.resetCustomer();
      return super.changeDimension(server, teleporter);
   }

   protected void resetCustomer() {
      this.setCustomer(null);
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void onDeath(DamageSource cause) {
      super.onDeath(cause);
      this.resetCustomer();
   }

   @OnlyIn(Dist.CLIENT)
   protected void spawnParticles(IParticleData particleData) {
      for(int i = 0; i < 5; ++i) {
         double d0 = this.rand.nextGaussian() * 0.02D;
         double d1 = this.rand.nextGaussian() * 0.02D;
         double d2 = this.rand.nextGaussian() * 0.02D;
         this.world.addParticle(particleData, this.getPosXRandom(1.0D), this.getPosYRandom() + 1.0D, this.getPosZRandom(1.0D), d0, d1, d2);
      }

   }

   public boolean canBeLeashedTo(PlayerEntity player) {
      return false;
   }

   public Inventory getZombieTraderInventory() {
      return this.zombieTraderInventory;
   }

   public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
      if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
         return true;
      } else {
         int i = inventorySlot - 300;
         if (i >= 0 && i < this.zombieTraderInventory.getSizeInventory()) {
            this.zombieTraderInventory.setInventorySlotContents(i, itemStackIn);
            return true;
         } else {
            return false;
         }
      }
   }

   public World getWorld() {
      return this.world;
   }

   protected abstract void populateTradeData();

   /**
    * add limites numbers of trades to the given MerchantOffers
    */
   protected void addTrades(MerchantOffers givenMerchantOffers, ZombieTraderTrades.ITrade[] newTrades, int maxNumbers) {
      Set<Integer> set = Sets.newHashSet();
      if (newTrades.length > maxNumbers) {
         while(set.size() < maxNumbers) {
            set.add(this.rand.nextInt(newTrades.length));
         }
      } else {
         for(int i = 0; i < newTrades.length; ++i) {
            set.add(i);
         }
      }

      for(Integer integer : set) {
         ZombieTraderTrades.ITrade zombieTraderTrades$itrade = newTrades[integer];
         MerchantOffer merchantoffer = zombieTraderTrades$itrade.getOffer(this, this.rand);
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