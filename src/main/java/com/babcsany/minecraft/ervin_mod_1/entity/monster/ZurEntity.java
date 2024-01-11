package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeConfig;

import java.util.Random;
import java.util.UUID;

public class ZurEntity extends MonsterEntity {
    private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier BABY_SPEED_BOOST;
    private static final DataParameter<Boolean> IS_CHILD;

    public ZurEntity(EntityType<ZurEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23000000417232513).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0).createMutableAttribute(Attributes.ARMOR, 2.0).createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

    protected boolean canBreakDoors() {
        return true;
    }

    public boolean isChild() {
        return (Boolean)this.getDataManager().get(IS_CHILD);
    }

    protected int getExperiencePoints(PlayerEntity p_70693_1_) {
        if (this.isChild()) {
            this.experienceValue = (int)((float)this.experienceValue * 2.5F);
        }

        return super.getExperiencePoints(p_70693_1_);
    }

    public void setChild(boolean p_82227_1_) {
        this.getDataManager().set(IS_CHILD, p_82227_1_);
        if (this.world != null && !this.world.isRemote) {
            ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
            modifiableattributeinstance.removeModifier(BABY_SPEED_BOOST);
            if (p_82227_1_) {
                modifiableattributeinstance.applyNonPersistentModifier(BABY_SPEED_BOOST);
            }
        }

    }

    public void notifyDataManagerChange(DataParameter<?> p_184206_1_) {
        if (IS_CHILD.equals(p_184206_1_)) {
            this.recalculateSize();
        }

        super.notifyDataManagerChange(p_184206_1_);
    }

    protected boolean shouldDrown() {
        return true;
    }

    public void tick() {


        super.tick();
    }

    public void livingTick() {
        if (this.isAlive()) {
            boolean flag = this.shouldBurnInDay() && this.isInDaylight();
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
                    this.setFire(8);
                }
            }
        }

        super.livingTick();
    }

    protected boolean shouldBurnInDay() {
        return true;
    }

    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        if (!super.attackEntityFrom(p_70097_1_, p_70097_2_)) {
            return false;
        } else {
            LivingEntity livingentity = this.getAttackTarget();
            if (livingentity == null && p_70097_1_.getTrueSource() instanceof LivingEntity) {
                livingentity = (LivingEntity)p_70097_1_.getTrueSource();
            }
        }
        return false;
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        boolean flag = super.attackEntityAsMob(p_70652_1_);
        if (flag) {
            float f = this.world.getDifficultyForLocation(this.getPosition()).getAdditionalDifficulty();
            if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
                p_70652_1_.setFire(2 * (int)f);
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

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance p_180481_1_) {
        super.setEquipmentBasedOnDifficulty(p_180481_1_);
        if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = this.rand.nextInt(3);
            if (i == 0) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SWORD));
            } else {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
            }
        }

    }

    public void writeAdditional(CompoundNBT p_213281_1_) {
        super.writeAdditional(p_213281_1_);
        if (this.isChild()) {
            p_213281_1_.putBoolean("IsBaby", true);
        }
    }

    public void readAdditional(CompoundNBT p_70037_1_) {
        super.readAdditional(p_70037_1_);
        if (p_70037_1_.getBoolean("IsBaby")) {
            this.setChild(true);
        }

    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return this.isChild() ? 0.93F : 1.74F;
    }

    public boolean canEquipItem(ItemStack p_175448_1_) {
        return p_175448_1_.getItem() == Items.EGG && this.isChild() && this.isPassenger() ? false : super.canEquipItem(p_175448_1_);
    }

    public static boolean func_241399_a_(Random p_241399_0_) {
        return (double)p_241399_0_.nextFloat() < (Double) ForgeConfig.SERVER.zombieBabyChance.get();
    }

    protected void func_230291_eT_() {
        this.getAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS).setBaseValue(this.rand.nextDouble() * (Double)ForgeConfig.SERVER.zombieBaseSummonChance.get());
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
        return new ItemStack(Items.ZOMBIE_HEAD);
    }

    static {
        BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5, AttributeModifier.Operation.MULTIPLY_BASE);
        IS_CHILD = EntityDataManager.createKey(ZombieEntity.class, DataSerializers.BOOLEAN);
    }

    public static class GroupData implements ILivingEntityData {
        public final boolean isChild;
        public final boolean field_241400_b_;

        public GroupData(boolean p_i231567_1_, boolean p_i231567_2_) {
            this.isChild = p_i231567_1_;
            this.field_241400_b_ = p_i231567_2_;
        }
    }
}
