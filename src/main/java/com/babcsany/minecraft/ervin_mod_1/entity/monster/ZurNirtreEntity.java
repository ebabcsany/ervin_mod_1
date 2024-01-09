package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AgeableZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.trigger.CriteriaTriggers1;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.IReputationTracking;
import net.minecraft.entity.merchant.IReputationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.UUID;

public class ZurNirtreEntity extends AgeableEntity {
   private static final DataParameter<Boolean> CONVERTING = EntityDataManager.createKey(ZurNirtreEntity.class, DataSerializers.BOOLEAN);
   private int conversionTime;
   private UUID converstionStarter;
   private CompoundNBT offers;
   private int xp;

   public ZurNirtreEntity(EntityType<ZurNirtreEntity> p_i50186_1_, World p_i50186_2_) {
      super(p_i50186_1_, p_i50186_2_);
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return AbstractZurEntity.func_234295_eP_().createMutableAttribute(Attributes.FOLLOW_RANGE, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 40.0D).createMutableAttribute(Attributes.ARMOR, 4.0D);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(CONVERTING, false);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      if (this.offers != null) {
         compound.put("Offers", this.offers);
      }

      compound.putInt("ConversionTime", this.isConverting() ? this.conversionTime : -1);
      if (this.converstionStarter != null) {
         compound.putUniqueId("ConversionPlayer", this.converstionStarter);
      }

      compound.putInt("Xp", this.xp);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);

      if (compound.contains("Offers", 10)) {
         this.offers = compound.getCompound("Offers");
      }

      if (compound.contains("ConversionTime", 99) && compound.getInt("ConversionTime") > -1) {
         this.startConverting(compound.hasUniqueId("ConversionPlayer") ? compound.getUniqueId("ConversionPlayer") : null, compound.getInt("ConversionTime"));
      }

      if (compound.contains("Xp", 3)) {
         this.xp = compound.getInt("Xp");
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      if (!this.world.isRemote && this.isAlive() && this.isConverting()) {
         int i = this.getConversionProgress();
         this.conversionTime -= i;
         if (this.conversionTime <= 0) {
            this.cureZur((ServerWorld)this.world);
         }
      }

      super.tick();
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return !this.isConverting() && this.xp == 0;
   }

   /**
    * Returns whether this zombie is in the process of converting to a villager
    */
   public boolean isConverting() {
      return this.getDataManager().get(CONVERTING);
   }

   /**
    * Starts conversion of this zombie villager to a villager
    */
   private void startConverting(@Nullable UUID conversionStarterIn, int conversionTimeIn) {
      this.converstionStarter = conversionStarterIn;
      this.conversionTime = conversionTimeIn;
      this.getDataManager().set(CONVERTING, true);
      this.removePotionEffect(Effects.WEAKNESS);
      this.addPotionEffect(new EffectInstance(Effects.STRENGTH, conversionTimeIn, Math.min(this.world.getDifficulty().getId() - 1, 0)));
      this.world.setEntityState(this, (byte)16);
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 16) {
         if (!this.isSilent()) {
            this.world.playSound(this.getPosX(), this.getPosYEye(), this.getPosZ(), SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
         }

      } else {
         super.handleStatusUpdate(id);
      }
   }

   private void cureZur(ServerWorld p_213791_1_) {
      TraderNirtreEntity traderNirtreEntity = EntityInit.TRADER_NIRTRE_ENTITY.get().create(p_213791_1_);

      for(EquipmentSlotType equipmentslottype : EquipmentSlotType.values()) {
         ItemStack itemstack = this.getItemStackFromSlot(equipmentslottype);
         if (!itemstack.isEmpty()) {
            if (EnchantmentHelper.hasBindingCurse(itemstack)) {
               traderNirtreEntity.replaceItemInInventory(equipmentslottype.getIndex() + 300, itemstack);
            } else {
               double d0 = this.getDropChance(equipmentslottype);
               if (d0 > 1.0D) {
                  this.entityDropItem(itemstack);
               }
            }
         }
      }

      if (this.offers != null) {
         traderNirtreEntity.setOffers(new MerchantOffers(this.offers));
      }

      traderNirtreEntity.setXp(this.xp);
      traderNirtreEntity.onInitialSpawn(p_213791_1_, p_213791_1_.getDifficultyForLocation(traderNirtreEntity.getPosition()), SpawnReason.CONVERSION, null, null);
      if (this.isChild()) {
         traderNirtreEntity.setGrowingAge(-24000);
      }

      this.remove();
      traderNirtreEntity.setNoAI(this.isAIDisabled());
      if (this.hasCustomName()) {
         traderNirtreEntity.setCustomName(this.getCustomName());
         traderNirtreEntity.setCustomNameVisible(this.isCustomNameVisible());
      }

      if (this.isNoDespawnRequired()) {
         traderNirtreEntity.enablePersistence();
      }

      traderNirtreEntity.setInvulnerable(this.isInvulnerable());
      p_213791_1_.addEntity(traderNirtreEntity);
      if (this.converstionStarter != null) {
         PlayerEntity playerentity = p_213791_1_.getPlayerByUuid(this.converstionStarter);
         if (playerentity instanceof ServerPlayerEntity) {
            CriteriaTriggers1.CURED_ZUR_NIRTRE.trigger((ServerPlayerEntity)playerentity, this, traderNirtreEntity);
            p_213791_1_.updateReputation(IReputationType.ZOMBIE_VILLAGER_CURED, playerentity, (IReputationTracking) traderNirtreEntity);
         }
      }

      traderNirtreEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
      if (!this.isSilent()) {
         p_213791_1_.playEvent(null, 1027, this.getPosition(), 0);
      }

   }

   private int getConversionProgress() {
      int i = 1;
      if (this.rand.nextFloat() < 0.01F) {
         int j = 0;
         BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

         for(int k = (int)this.getPosX() - 4; k < (int)this.getPosX() + 4 && j < 14; ++k) {
            for(int l = (int)this.getPosY() - 4; l < (int)this.getPosY() + 4 && j < 14; ++l) {
               for(int i1 = (int)this.getPosZ() - 4; i1 < (int)this.getPosZ() + 4 && j < 14; ++i1) {
                  Block block = this.world.getBlockState(blockpos$mutable.setPos(k, l, i1)).getBlock();
                  if (block == Blocks.IRON_BARS || block instanceof BedBlock) {
                     if (this.rand.nextFloat() < 0.3F) {
                        ++i;
                     }

                     ++j;
                  }
               }
            }
         }
      }

      return i;
   }

   /**
    * Gets the pitch of living sounds in living entities.
    */
   protected float getSoundPitch() {
      return this.isChild() ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 2.0F : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F;
   }

   /*public SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_ZOMBIE_VILLAGER_AMBIENT;
   }

   public SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_ZOMBIE_VILLAGER_HURT;
   }

   public SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_ZOMBIE_VILLAGER_DEATH;
   }

   public SoundEvent getStepSound() {
      return SoundEvents.ENTITY_ZOMBIE_VILLAGER_STEP;
   }*/

   protected ItemStack getSkullDrop() {
      return ItemStack.EMPTY;
   }

   public void setOffers(CompoundNBT p_213790_1_) {
      this.offers = p_213790_1_;
   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      //this.setVillagerData(this.getVillagerData().withType(IVillagerType.byBiome(worldIn.getBiome(this.getPosition()))));
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   @Nullable
   public AgeableEntity createChild(AgeableEntity ageable) {
      return null;
   }

   @Nullable
   public AgeableEntity createChild(AgeableZurEntity ageable) {
      return EntityInit.ZUR_ENTITY.get().create(this.world);
   }

   /*public void setVillagerData(VillagerData p_213792_1_) {
      VillagerData villagerdata = this.getVillagerData();
      if (villagerdata.getProfession() != p_213792_1_.getProfession()) {
         this.offers = null;
      }

      this.dataManager.set(VILLAGER_DATA, p_213792_1_);
   }*/

   /*public VillagerData getVillagerData() {
      return this.dataManager.get(VILLAGER_DATA);
   }*/

   public void setEXP(int p_213789_1_) {
      this.xp = p_213789_1_;
   }
}