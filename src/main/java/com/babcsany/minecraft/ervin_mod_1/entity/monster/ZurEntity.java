package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.ZurTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.trigger.CriteriaTriggers1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ZurEntity extends AbstractZurEntity {

    public ZurEntity(EntityType<ZurEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new ZurTradeWithPlayerGoal(this));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 9.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.FOLLOW_RANGE, 350.0).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.023000000417232513).createMutableAttribute(Attributes.ATTACK_DAMAGE, 30.0).createMutableAttribute(Attributes.ARMOR, 20.0).createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

    protected int getExperiencePoints(PlayerEntity p_70693_1_) {
        if (this.isChild()) {
            this.experienceValue = (int)((float)this.experienceValue * 2.5F);
        }

        return super.getExperiencePoints(p_70693_1_);
    }

    public void tick() {


        super.tick();
    }

    public void livingTick() {
        if (this.isAlive()) {
            boolean flag = this.isInDaylight();
            if (flag) {
                ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
                if (!itemstack.isEmpty()) {
                    if (itemstack.isDamageable()) {
                        itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
                        if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
                            this.sendBreakAnimation(EquipmentSlotType.HEAD);
                            this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    this.setCombatTask();
                }
            }
        }

        super.livingTick();
    }

    @Override
    protected void onZurTrade(MerchantOffer offer) {

    }

    protected boolean shouldBurnInDay() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        if (!super.attackEntityFrom(p_70097_1_, p_70097_2_)) {
            return false;
        } else {
            LivingEntity livingentity = this.getAttackTarget();
            if (livingentity == null && p_70097_1_.getTrueSource() instanceof LivingEntity) {
                livingentity = (LivingEntity) p_70097_1_.getTrueSource();
            }
        }
        return false;
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        boolean flag = super.attackEntityAsMob(p_70652_1_);
        if (flag) {
            float f = this.world.getDifficultyForLocation(this.getPosition()).getAdditionalDifficulty();
            if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
                p_70652_1_.setFire(2 * (int) f);
            }
        }

        return flag;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public void onTrade(MerchantOffer offer) {
        offer.increaseUses();
        this.livingSoundTime = -this.getTalkInterval();
        this.onZurTrade(offer);
        if (this.getCustomer() instanceof ServerPlayerEntity) {
            CriteriaTriggers1.ZUR_TRADE.test((ServerPlayerEntity) this.getCustomer(), this, offer.getSellingStack());
        }

    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance p_180481_1_) {
        super.setEquipmentBasedOnDifficulty(p_180481_1_);
        if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = this.rand.nextInt(9);
            if (i == 0) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SWORD));
            } else if (i == 1) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
            } else if (i == 2) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
            } else if (i == 3) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.NETHERITE_SHOVEL));
            } else if (i == 4) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
            } else if (i == 5) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.DIAMOND_SHOVEL));
            } else if (i == 6) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.NETHERITE_AXE));
            } else {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BEDROCK));
            }
        }

    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageableEntity) {
        return EntityInit.ZUR_ENTITY.get().create(this.world);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        MerchantOffers merchantoffers = this.getOffers();
        if (!merchantoffers.isEmpty()) {
            compound.put("Offers", merchantoffers.write());
        }
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("Offers", 50)) {
            this.offers = new MerchantOffers(compound.getCompound("Offers"));
        }
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return this.isChild() ? 0.93F : 1.74F;
    }

    public boolean canEquipItem(ItemStack p_175448_1_) {
        return p_175448_1_.getItem() == Items.EGG && this.isChild() && this.isPassenger() ? false : super.canEquipItem(p_175448_1_);
    }

    public double getYOffset() {
        return this.isChild() ? 0.0 : -0.45;
    }

    protected void dropSpecialItems(DamageSource p_213333_1_, int p_213333_2_, boolean p_213333_3_) {
        super.dropSpecialItems(p_213333_1_, p_213333_2_, p_213333_3_);
        Entity entity = p_213333_1_.getTrueSource();
        if (entity instanceof CreeperEntity) {
            CreeperEntity creeperentity = (CreeperEntity)entity;
            if (creeperentity.ableToCauseSkullDrop()) {
                creeperentity.incrementDroppedSkulls();
                ItemStack itemstack = this.getSkullDrop();
                if (!itemstack.isEmpty()) {
                    this.entityDropItem(itemstack);
                }
            }
        }

    }

    protected ItemStack getSkullDrop() {
        return new ItemStack(isBurnableSpecialToolItemInit.THUFR.get());
    }

}
