package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.EatPumpkinGoal;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.SoundInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraftforge.api.distmarker.Dist.CLIENT;

public class Liwray extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ItemInit.TARG.get());
    public float wingRotation;
    public float destPos;
    public float wingRotDelta = 1.0F;
    private EatGrassGoal eatGrassGoal;
    private EatPumpkinGoal eatPumpkinGoal;
    private int eatingGrassTimer;
    public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
    public boolean liwrayJockey;
    private Object lightningBolt;

    public Liwray(EntityType<? extends Liwray> type, World worldIn) {
        super(type, worldIn);
    }

    /*@Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        ZurEntity1 entity = new ZurEntity1(EntityInit.ZUR_ENTITY1.get(), this.world);

        entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos((IPosition) entity)),
                SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
        entity.setGlowing(true);
        return entity;
    }*/

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.eatPumpkinGoal = new EatPumpkinGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3,
                new TemptGoal(this, 1.1D, Ingredient.fromItems(ItemInit.TARG.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, this.eatGrassGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected void updateAITasks() {
        this.eatingGrassTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        super.livingTick();
        this.wingRotation += this.wingRotDelta * 2.0F;
        if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isLiwrayJockey() && --this.timeUntilNextItem <= 0) {
            this.entityDropItem(isBurnableFoodItemInit.TIRKS.get());
            this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
        }
        if (this.world.isRemote) {
            this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        }
    }

    public boolean isLiwrayJockey() {
        return this.liwrayJockey;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 16.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F);
    }

    @OnlyIn(CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.eatingGrassTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(CLIENT)
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

    public Liwray createChild(AgeableEntity ageable) {
        return EntityInit.LIWRAY.get().create(this.world);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return TEMPTATION_ITEMS.test(stack);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.AMBIENT.get();
    }
}

