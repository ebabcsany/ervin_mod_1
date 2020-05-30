package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ItemInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ZurEntity extends MonsterEntity {
    /**
     * The attribute which determines the chance that this mob will spawn reinforcements
     */
    protected static final IAttribute SPAWN_REINFORCEMENTS_CHANCE = (new RangedAttribute((IAttribute) null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");
    //  private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    //  private static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);

    private EatGrassGoal eatGrassGoal;
    private int eatingGrassTimer;

    public ZurEntity(EntityType<ZurEntity> entityType, World world) {
        super(entityType, world);
    }

    public ZurEntity(World world) {
        super(EntityInit.ZUR_ENTITY.get(), world);
    }

    public ZurEntity createChild(AgeableEntity ageable) {
        ZurEntity entity = new ZurEntity(this.world);
        entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
                SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
        entity.setGlowing(true);
        return entity;
    }

    @Override
    protected void registerGoals() {
        this.eatGrassGoal = new EatGrassGoal(this);
        //this.goalSelector.addGoal(4, new ZurEntity(1.0D, this, 3));
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        new TemptGoal(this, 4.4D, Ingredient.fromItems(ItemInit.FRIM.get()), false);
        //this.goalSelector.addGoal(8, new
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, eatGrassGoal);
        this.goalSelector.addGoal(2, new ZurAttackGoal(this, 1.0D, false));
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

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(160.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.eatingGrassTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

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


    //   @Override
    // protected SoundEvent getAmbientSound() {
    //   return SoundInit.AMBIENT.get();
}

