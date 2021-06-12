package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class Dgrurbk extends AbstractDgrurbkEntity {
    //public static final DataParameter<Integer> PHASE = EntityDataManager.createKey(EnderDragonEntity.class, DataSerializers.VARINT);
    /**
     * The attribute which determines the chance that this mob will spawn reinforcements
     */
    //private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final EntityPredicate PLAYER_INVADER_CONDITION = (new EntityPredicate()).setDistance(64.0D);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(Dgrurbk.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> BABY = EntityDataManager.createKey(Dgrurbk.class, DataSerializers.BOOLEAN);

    @Nullable
    private PlayerEntity customer;
    private EatGrassGoal eatGrassGoal;
    private int despawnDelay;
    private int eatingGrassTimer;
    protected int growingAge;

    public Dgrurbk(EntityType<? extends Dgrurbk> type, World worldIn) {
        super(type, worldIn);
    }

    public Dgrurbk(World world) {
        super(EntityInit.DGRURBK_ENTITY.get(), world);
    }

    protected void registerData() {
        super.registerData();
        //this.getDataManager().register(PHASE, PhaseType.HOVER.getId());
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 50000000.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 5000000.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0D);
    }

    @Override
    protected void registerGoals() {
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new LookAtGoal(this, EnderDragonEntity.class, 6.0F));
        this.goalSelector.addGoal(5, eatGrassGoal);
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }


    @Override
    protected void updateAITasks() {
        this.eatingGrassTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    public void handleDespawn() {
        if (this.despawnDelay > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
            this.remove();
        }

    }

    public boolean hasCustomer() {
        return this.customer != null;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        boolean flag = this.isInDaylight();
        this.updateArmSwingProgress();
        if (!this.world.isRemote) {
            this.handleDespawn();
        }
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
            }
        }
        if (this.world.isRemote) {
            this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.eatingGrassTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    private boolean entityLivingUpdate(Dgrurbk entity)
    {
        return false;
    }

    public boolean onEntityLivingUpdate(Dgrurbk entity) {
        entity.getEntityWorld().setBlockState(entity.getPosition().down(1), isBurnableBlockItemInit.NIRTK.get().getDefaultState());
        return entityLivingUpdate(entity);
    }

    public Dgrurbk createChild(AgeableEntity ageable) {
        return EntityInit.DGRURBK_ENTITY.get().create(this.world);
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.eatingGrassTimer <= 0) {
            return 0.0F;
        } else if (this.eatingGrassTimer >= 4 && this.eatingGrassTimer <= 36) {
            return 1.0F;
        } else {
            return this.eatingGrassTimer < 4 ? ((float) this.eatingGrassTimer - p_70894_1_) / 4.0F
                    : -((float) (this.eatingGrassTimer - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.eatingGrassTimer > 4 && this.eatingGrassTimer <= 36) {
            float f = ((float) (this.eatingGrassTimer - 4) - p_70890_1_) / 32.0F;
            return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.eatingGrassTimer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
        }
    }

    @Override
    public void onStruckByLightning(LightningBoltEntity lightningBolt) {
        this.setGlowing(true);
    }

    public void setGrowingAge(int age) {
        int i = this.growingAge;
        this.growingAge = age;
        if (i < 0 && age >= 0 || i >= 0 && age < 0) {
            this.dataManager.set(BABY, age < 0);
            this.onGrowingAdult();
        }

    }

    protected void onGrowingAdult() {
    }

    public int getGrowingAge() {
        if (this.world.isRemote) {
            return this.dataManager.get(BABY) ? -1 : 1;
        } else {
            return this.growingAge;
        }
    }

    @Override
    public boolean isDedicatedServer() {
        return true;
    }

}

