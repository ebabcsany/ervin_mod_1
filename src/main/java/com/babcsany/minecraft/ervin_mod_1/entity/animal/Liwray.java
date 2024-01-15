package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.SoundInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraftforge.api.distmarker.Dist.CLIENT;

public class Liwray extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ItemInit.TARG.get());
    public float wingRotation;
    public float wingRotDelta = 1.0F;
    private EatGrassGoal eatGrassGoal;
    private int eatingGrassTimer;
    public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
    public boolean liwrayJockey;

    public Liwray(EntityType<? extends Liwray> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
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

