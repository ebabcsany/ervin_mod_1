package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biomes;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class FreinEntity extends SlimeEntity implements IMob {
    private static final DataParameter<Integer> FREIN_SIZE = EntityDataManager.createKey(FreinEntity.class, DataSerializers.VARINT);
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean wasOnGround;

    public FreinEntity(EntityType<? extends FreinEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new FreinEntity.MoveHelperController(this);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FreinEntity.FloatGoal(this));
        this.goalSelector.addGoal(2, new FreinEntity.AttackGoal(this));
        this.goalSelector.addGoal(3, new FreinEntity.FaceRandomGoal(this));
        this.goalSelector.addGoal(5, new FreinEntity.HopGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (living) -> Math.abs(living.getPosY() - this.getPosY()) <= 4.0D));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(FREIN_SIZE, 1);
    }

    protected void setFreinSize(int size, boolean resetHealth) {
        this.dataManager.set(FREIN_SIZE, size);
        this.recenterBoundingBox();
        this.recalculateSize();
        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(size * size);
        Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(0.2F + 0.1F * (float) size);
        Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(size);
        if (resetHealth) {
            this.setHealth(this.getMaxHealth());
        }

        this.experienceValue = size;
    }

    /**
     * Returns the size of the slime.
     */
    public int getFreinSize() {
        return this.dataManager.get(FREIN_SIZE);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Size", this.getFreinSize() - 1);
        compound.putBoolean("wasOnGround", this.wasOnGround);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        int i = compound.getInt("Size");
        if (i < 0) {
            i = 0;
        }

        this.setFreinSize(i + 1, false);
        super.readAdditional(compound);
        this.wasOnGround = compound.getBoolean("wasOnGround");
    }

    public boolean isSmallFrein() {
        return this.getFreinSize() <= 1;
    }

    protected IParticleData getSquishParticle() {
        return ParticleTypes.ITEM_SLIME;
    }

    protected boolean isDespawnPeaceful() {
        return this.getFreinSize() > 0;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.tick();
        if (this.onGround && !this.wasOnGround) {
            int i = this.getFreinSize();

            if (spawnCustomParticles()) i = 0; // don't spawn particles if it's handled by the implementation itself
            for (int j = 0; j < i * 8; ++j) {
                float f = this.rand.nextFloat() * ((float) Math.PI * 2F);
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float) i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float) i * 0.5F * f1;
                this.world.addParticle(this.getSquishParticle(), this.getPosX() + (double) f2, this.getPosY(), this.getPosZ() + (double) f3, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.squishAmount = -0.5F;
        } else if (!this.onGround && this.wasOnGround) {
            this.squishAmount = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.6F;
    }

    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    protected int getJumpDelay() {
        return this.rand.nextInt(20) + 10;
    }

    public void recalculateSize() {
        double d0 = this.getPosX();
        double d1 = this.getPosY();
        double d2 = this.getPosZ();
        super.recalculateSize();
        this.setPosition(d0, d1, d2);
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        if (FREIN_SIZE.equals(key)) {
            this.recalculateSize();
            this.rotationYaw = this.rotationYawHead;
            this.renderYawOffset = this.rotationYawHead;
            if (this.isInWater() && this.rand.nextInt(20) == 0) {
                this.doWaterSplashEffect();
            }
        }

        super.notifyDataManagerChange(key);
    }

    @SuppressWarnings("unchecked")
    public EntityType<? extends FreinEntity> getType() {
        return (EntityType<? extends FreinEntity>) super.getType();
    }

    @Override
    @Deprecated
    public void remove(boolean keepData) {
        int i = this.getFreinSize();
        if (!this.world.isRemote && i > 1 && this.getShouldBeDead() && !this.removed) {
            ITextComponent itextcomponent = this.getCustomName();
            boolean flag = this.isAIDisabled();
            float f = (float) i / 4.0F;
            int j = i / 2;
            int k = 2 + this.rand.nextInt(3);

            for (int l = 0; l < k; ++l) {
                float f1 = ((float) (l % 2) - 0.5F) * f;
                float f2 = ((float) (l / 2) - 0.5F) * f;
                FreinEntity freinEntity = this.getType().create(this.world);
                if (this.isNoDespawnRequired()) {
                    if (freinEntity == null) throw new AssertionError();
                    freinEntity.enablePersistence();
                }

                if (freinEntity == null) throw new AssertionError();
                freinEntity.setCustomName(itextcomponent);
                freinEntity.setNoAI(flag);
                freinEntity.setInvulnerable(this.isInvulnerable());
                freinEntity.setFreinSize(j, true);
                freinEntity.setLocationAndAngles(this.getPosX() + (double) f1, this.getPosY() + 0.5D, this.getPosZ() + (double) f2, this.rand.nextFloat() * 360.0F, 0.0F);
                this.world.addEntity(freinEntity);
            }
        }

        super.remove(keepData);
    }

    /**
     * Applies a velocity to the entities, to push them away from each other.
     */
    public void applyEntityCollision(Entity entityIn) {
        super.applyEntityCollision(entityIn);
        if (entityIn instanceof IronGolemEntity && this.canDamagePlayer()) {
            this.dealDamage((LivingEntity) entityIn);
        }

    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(PlayerEntity entityIn) {
        if (this.canDamagePlayer()) {
            this.dealDamage(entityIn);
        }

    }

    protected void dealDamage(LivingEntity entityIn) {
        if (this.isAlive()) {
            int i = this.getFreinSize();
            if (this.getDistanceSq(entityIn) < 0.6D * (double) i * 0.6D * (double) i && this.canEntityBeSeen(entityIn) && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackDamage())) {
                this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                this.applyEnchantments(this, entityIn);
            }
        }

    }

    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */
    protected boolean canDamagePlayer() {
        return !this.isSmallFrein() && this.isServerWorld();
    }

    protected float getAttackDamage() {
        return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return this.isSmallFrein() ? SoundEvents.ENTITY_SLIME_HURT_SMALL : SoundEvents.ENTITY_SLIME_HURT;
    }

    protected SoundEvent getDeathSound() {
        return this.isSmallFrein() ? SoundEvents.ENTITY_SLIME_DEATH_SMALL : SoundEvents.ENTITY_SLIME_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return this.isSmallFrein() ? SoundEvents.ENTITY_SLIME_SQUISH_SMALL : SoundEvents.ENTITY_SLIME_SQUISH;
    }

    protected ResourceLocation getLootTable() {
        return this.getFreinSize() == 1 ? this.getType().getLootTable() : LootTables.EMPTY;
    }

    public static boolean canFreinSpawn(EntityType<FreinEntity> frein, IWorld world, SpawnReason reason, BlockPos pos, Random randomIn) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            if (Objects.equals(world.func_242406_i(pos), Optional.of(Biomes.SWAMP)) && pos.getY() > 50 && pos.getY() < 70 && randomIn.nextFloat() < 0.5F && randomIn.nextFloat() < world.getMoonFactor() && world.getLight(pos) <= randomIn.nextInt(8)) {
                return canSpawnOn(frein, world, reason, pos, randomIn);
            }

            if (!(world instanceof ISeedReader)) {
                return false;
            }

            ChunkPos chunkpos = new ChunkPos(pos);
            boolean flag = SharedSeedRandom.createSlimeChunkSpawningSeed(chunkpos.x, chunkpos.z, ((ISeedReader) world).getSeed(), 987234911L).nextInt(10) == 0;
            if (randomIn.nextInt(10) == 0 && flag && pos.getY() < 40) {
                return canSpawnOn(frein, world, reason, pos, randomIn);
            }
        }

        return false;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F * (float) this.getFreinSize();
    }

    /**
     * The speed it takes to move the entity living's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed() {
        return 0;
    }

    /**
     * Returns true if the slime makes a sound when it jumps (based upon the slime's size)
     */
    protected boolean makesSoundOnJump() {
        return this.getFreinSize() > 0;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump() {
        Vector3d vector3d = this.getMotion();
        this.setMotion(vector3d.x, this.getJumpUpwardsMotion(), vector3d.z);
        this.isAirBorne = true;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        int i = this.rand.nextInt(9);
        if (i < 2 && this.rand.nextFloat() < 0.5F * difficultyIn.getClampedAdditionalDifficulty()) {
            ++i;
        }

        int j = 1 << i;
        this.setFreinSize(j, true);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    protected float getSoundPitch() {
        float f = this.isSmallFrein() ? 1.4F : 0.8F;
        return ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * f;
    }

    protected SoundEvent getJumpSound() {
        return this.isSmallFrein() ? SoundEvents.ENTITY_SLIME_JUMP_SMALL : SoundEvents.ENTITY_SLIME_JUMP;
    }

    public EntitySize getSize(Pose poseIn) {
        return super.getSize(poseIn).scale(0.255F * (float) this.getFreinSize());
    }

    /**
     * Called when the slime spawns particles on landing, see onUpdate.
     * Return true to prevent the spawning of the default particles.
     */
    protected boolean spawnCustomParticles() {
        return false;
    }

    static class AttackGoal extends Goal {
        private final FreinEntity frein;
        private int growTieredTimer;

        public AttackGoal(FreinEntity slimeIn) {
            this.frein = slimeIn;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            LivingEntity livingentity = this.frein.getAttackTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                return (!(livingentity instanceof PlayerEntity) || !((PlayerEntity) livingentity).abilities.disableDamage) && this.frein.getMoveHelper() instanceof MoveHelperController;
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.growTieredTimer = 300;
            super.startExecuting();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            LivingEntity livingentity = this.frein.getAttackTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else if (livingentity instanceof PlayerEntity && ((PlayerEntity) livingentity).abilities.disableDamage) {
                return false;
            } else {
                return --this.growTieredTimer > 0;
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            this.frein.faceEntity(Objects.requireNonNull(this.frein.getAttackTarget()), 10.0F, 10.0F);
            ((FreinEntity.MoveHelperController) this.frein.getMoveHelper()).setDirection(this.frein.rotationYaw, this.frein.canDamagePlayer());
        }
    }

    static class FaceRandomGoal extends Goal {
        private final FreinEntity frein;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public FaceRandomGoal(FreinEntity slimeIn) {
            this.frein = slimeIn;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return this.frein.getAttackTarget() == null && (this.frein.onGround || this.frein.isInWater() || this.frein.isInLava() || this.frein.isPotionActive(Effects.LEVITATION)) && this.frein.getMoveHelper() instanceof FreinEntity.MoveHelperController;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = 40 + this.frein.getRNG().nextInt(60);
                this.chosenDegrees = (float) this.frein.getRNG().nextInt(360);
            }

            ((FreinEntity.MoveHelperController) this.frein.getMoveHelper()).setDirection(this.chosenDegrees, false);
        }
    }

    static class FloatGoal extends Goal {
        private final FreinEntity frein;

        public FloatGoal(FreinEntity slimeIn) {
            this.frein = slimeIn;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            slimeIn.getNavigator().setCanSwim(true);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return (this.frein.isInWater() || this.frein.isInLava()) && this.frein.getMoveHelper() instanceof FreinEntity.MoveHelperController;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.frein.getRNG().nextFloat() < 0.8F) {
                this.frein.getJumpController().setJumping();
            }

            ((FreinEntity.MoveHelperController) this.frein.getMoveHelper()).setSpeed(1.2D);
        }
    }

    static class HopGoal extends Goal {
        private final FreinEntity frein;

        public HopGoal(FreinEntity slimeIn) {
            this.frein = slimeIn;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return !this.frein.isPassenger();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            ((FreinEntity.MoveHelperController) this.frein.getMoveHelper()).setSpeed(1.0D);
        }
    }

    static class MoveHelperController extends MovementController {
        private float yRot;
        private int jumpDelay;
        private final FreinEntity frein;
        private boolean isAggressive;

        public MoveHelperController(FreinEntity slimeIn) {
            super(slimeIn);
            this.frein = slimeIn;
            this.yRot = 180.0F * slimeIn.rotationYaw / (float) Math.PI;
        }

        public void setDirection(float yRotIn, boolean aggressive) {
            this.yRot = yRotIn;
            this.isAggressive = aggressive;
        }

        public void setSpeed(double speedIn) {
            this.speed = speedIn;
            this.action = MovementController.Action.MOVE_TO;
        }

        public void tick() {
            this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, this.yRot, 90.0F);
            this.mob.rotationYawHead = this.mob.rotationYaw;
            this.mob.renderYawOffset = this.mob.rotationYaw;
            if (this.action != MovementController.Action.MOVE_TO) {
                this.mob.setMoveForward(0.0F);
            } else {
                this.action = MovementController.Action.WAIT;
                if (this.mob.isOnGround()) {
                    this.mob.setAIMoveSpeed((float) (this.speed * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.frein.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.frein.getJumpController().setJumping();
                        if (this.frein.makesSoundOnJump()) {
                            this.frein.playSound(this.frein.getJumpSound(), this.frein.getSoundVolume(), this.frein.getSoundPitch());
                        }
                    } else {
                        this.frein.moveStrafing = 0.0F;
                        this.frein.moveForward = 0.0F;
                        this.mob.setAIMoveSpeed(0.0F);
                    }
                } else {
                    this.mob.setAIMoveSpeed((float) (this.speed * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }

            }
        }
    }
}
