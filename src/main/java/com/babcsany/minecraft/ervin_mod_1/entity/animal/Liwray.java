package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.item.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Liwray extends AnimalEntity {
    public float wingRotation;
    public float destPos;
    public float oFlapSpeed;
    public float oFlap;
    public float wingRotDelta = 1.0F;
    public int timeUntilNextEgg;
    public boolean liwrayJockey;

    public Liwray(EntityType<Liwray> p_i50282_1_, World p_i50282_2_) {
        super(p_i50282_1_, p_i50282_2_);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.setPathPriority(PathNodeType.WATER, 0.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return this.isChild() ? p_213348_2_.height * 0.85F : p_213348_2_.height * 0.92F;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public void livingTick() {
        super.livingTick();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3);
        this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);
        if (!this.onGround && this.wingRotDelta < 1.0F) {
            this.wingRotDelta = 1.0F;
        }

        this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9);
        Vector3d lvt_1_1_ = this.getMotion();
        if (!this.onGround && lvt_1_1_.y < 0.0) {
            this.setMotion(lvt_1_1_.mul(1.0, 0.6, 1.0));
        }

        this.wingRotation += this.wingRotDelta * 2.0F;
        if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isLiwrayJockey() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(isBurnableFoodItemInit.TIRKS.get());
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }

    }

    public boolean onLivingFall(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    public Liwray createChild(ServerWorld serverWorld, AgeableEntity p_90011_1_) {
        return EntityInit.LIWRAY.get().create(serverWorld);
    }

    protected int getExperiencePoints(PlayerEntity p_70693_1_) {
        return this.isLiwrayJockey() ? 10 : super.getExperiencePoints(p_70693_1_);
    }

    public void readAdditional(CompoundNBT p_70037_1_) {
        super.readAdditional(p_70037_1_);
        this.liwrayJockey = p_70037_1_.getBoolean("IsLiwrayJockey");
        if (p_70037_1_.contains("TirksLayTime")) {
            this.timeUntilNextEgg = p_70037_1_.getInt("TirksLayTime");
        }

    }

    public void writeAdditional(CompoundNBT p_213281_1_) {
        super.writeAdditional(p_213281_1_);
        p_213281_1_.putBoolean("IsLiwrayJockey", this.liwrayJockey);
        p_213281_1_.putInt("TirksLayTime", this.timeUntilNextEgg);
    }

    public boolean canDespawn(double p_213397_1_) {
        return this.isLiwrayJockey();
    }

    public void updatePassenger(Entity p_184232_1_) {
        super.updatePassenger(p_184232_1_);
        float lvt_2_1_ = MathHelper.sin(this.renderYawOffset * 0.017453292F);
        float lvt_3_1_ = MathHelper.cos(this.renderYawOffset * 0.017453292F);
        float lvt_4_1_ = 0.1F;
        float lvt_5_1_ = 0.0F;
        p_184232_1_.setPosition(this.getPosX() + (double)(0.1F * lvt_2_1_), this.getPosYHeight(0.5) + p_184232_1_.getYOffset() + 0.0, this.getPosZ() - (double)(0.1F * lvt_3_1_));
        if (p_184232_1_ instanceof LivingEntity) {
            ((LivingEntity)p_184232_1_).renderYawOffset = this.renderYawOffset;
        }

    }

    public boolean isLiwrayJockey() {
        return this.liwrayJockey;
    }

    public void setLiwrayJockey(boolean liwrayJockey) {
        this.liwrayJockey = liwrayJockey;
    }
}

