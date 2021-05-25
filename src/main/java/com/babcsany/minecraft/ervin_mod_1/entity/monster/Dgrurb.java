package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtre1Entity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.UUID;

import static com.babcsany.minecraft.ervin_mod_1.entity.monster.AbstractZurEntity.BABY_SPEED_BOOST;

public class Dgrurb extends MonsterEntity {
    /**
     * The attribute which determines the chance that this mob will spawn reinforcements
     */
    //private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    //private static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(Dgrurb.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> BABY = EntityDataManager.createKey(Dgrurb.class, DataSerializers.BOOLEAN);

    private EatGrassGoal eatGrassGoal;
    private int eatingGrassTimer;
    protected int growingAge;

    public Dgrurb(EntityType<? extends Dgrurb> type, World worldIn) {
        super(type, worldIn);
    }

    public Dgrurb(World world) {
        super(EntityInit.DGRURB_ENTITY.get(), world);
    }

    public void applyWaveBonus(int p_213660_1_, boolean p_213660_2_) {

    }

    public void setChild(boolean childDgrurb) {
        this.getDataManager().set(IS_CHILD, childDgrurb);
        if (this.world != null && !this.world.isRemote) {
            ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
            modifiableattributeinstance.removeModifier(BABY_SPEED_BOOST);
            if (childDgrurb) {
                modifiableattributeinstance.applyNonPersistentModifier(BABY_SPEED_BOOST);
            }
        }

    }

    protected void onZurTrade(MerchantOffer offer) {

    }

    protected boolean populateTradeData() {
        return false;
    }

    @Override
    protected void registerGoals() {
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
           new TemptGoal(this, 4.4D, Ingredient.fromItems(ItemInit.TARG.get()), false);
        //this.goalSelector.addGoal(8, new
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, eatGrassGoal);
        this.goalSelector.addGoal(2, new DgrurbAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }


    @Override
    protected void updateAITasks() {
        this.eatingGrassTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        if (this.world.isRemote) {
            this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        }
        super.livingTick();
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return Dgrurb.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 10000000000.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 20000000.0D);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.eatingGrassTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    private boolean entityLivingUpdate(Dgrurb entity)
    {
        return false;
    }

    public boolean onEntityLivingUpdate(Dgrurb entity) {
        entity.getEntityWorld().setBlockState(entity.getPosition().down(1), isBurnableBlockItemInit.NIRTK.get().getDefaultState());
        return entityLivingUpdate(entity);
    }

    public Dgrurb createChild(AgeableEntity ageable) {
        return EntityInit.DGRURB_ENTITY.get().create(this.world);
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


    //   @Override
    // protected SoundEvent getAmbientSound() {
    //   return SoundInit.AMBIENT.get();

    public void onStruckByLightning(LightningBoltEntity lightningBolt) {
        if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
            LOGGER.info("Trader Nirtre {} was struck by lightning {}.", this, lightningBolt);
            Dgrurbk dgrurbk = EntityInit.DGRURBK_ENTITY.get().create(this.world);
            dgrurbk.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
            dgrurbk.onInitialSpawn(this.world, this.world.getDifficultyForLocation(dgrurbk.getPosition()), SpawnReason.CONVERSION, null, null);
            dgrurbk.setNoAI(this.isAIDisabled());
            if (this.hasCustomName()) {
                dgrurbk.setCustomName(this.getCustomName());
                dgrurbk.setCustomNameVisible(this.isCustomNameVisible());
            }

            dgrurbk.enablePersistence();
            this.world.addEntity(dgrurbk);
            this.remove();
        } else {
            super.onStruckByLightning(lightningBolt);
        }

    }
}

