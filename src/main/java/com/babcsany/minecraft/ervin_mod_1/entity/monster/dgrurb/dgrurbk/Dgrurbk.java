package com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk;

import com.babcsany.minecraft.IRangedAttackMob;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.DgrurbkLookAtGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.DgrurbkSwimGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.NearestAttackableDgrurbkMobTargetGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbAgeableEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.DgrurbkSkullEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.init.item.icsvre.IcsvreInit;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class Dgrurbk extends AbstractDgrurbkEntity implements IRangedAttackMob {
    private static final DataParameter<Integer> HEAD_TARGET = EntityDataManager.createKey(Dgrurbk.class, DataSerializers.VARINT);
    private static final List<DataParameter<Integer>> HEAD_TARGETS = ImmutableList.of(HEAD_TARGET);
    private final ServerBossInfo setBossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
    private static final EntityPredicate PLAYER_INVADER_CONDITION = (new EntityPredicate()).setDistance(120.0D);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(Dgrurbk.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> BABY = EntityDataManager.createKey(Dgrurbk.class, DataSerializers.BOOLEAN);
    private static final Predicate<LivingEntity> NOT_UNDEAD = (livingEntity) -> livingEntity.getCreatureAttribute() != CreatureAttribute.UNDEAD && livingEntity.attackable();
    private static final EntityPredicate ENEMY_CONDITION = (new EntityPredicate()).setDistance(20.0D).setCustomPredicate(NOT_UNDEAD);
    private static final DataParameter<Boolean> INVULNERABLE = EntityDataManager.createKey(Dgrurbk.class, DataSerializers.BOOLEAN);
    public static final DataParameter<Boolean> DROWNING = EntityDataManager.createKey(Dgrurbk.class, DataSerializers.BOOLEAN);
    private DgrurbkEatGrassGoal eatGrassGoal;
    private static BossInfo.Color color;
    private static Living living;
    private int eatingGrassTimer;
    protected int growingAge;
    public boolean dropItem;
    public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
    private int blockBreakCounter;
    private int inWaterTime;
    private int drownedConversionTime;

    public Dgrurbk(EntityType<? extends Dgrurbk> type, World worldIn) {
        super(type, worldIn);
    }

    public Dgrurbk(World world) {
        super(EntityInit.DGRURBK_ENTITY.get(), world);
    }

    protected void registerData() {
        super.registerData();
        this.getDataManager().register(DROWNING, false);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 4.0F;
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10000000000.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 20000000.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D);
    }

    public BossInfo.Color bossInfo(BossInfo.Color color) {
        return color;
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return !this.isNoDespawnRequired();
    }

    public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
        return worldIn.getBrightness(pos) - 0.5F;
    }

    @Override
    protected void registerGoals() {
        this.eatGrassGoal = new DgrurbkEatGrassGoal(this);
        this.goalSelector.addGoal(0, new RangedDgrurbkAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(0, new DgrurbkSwimGoal(this));
        this.goalSelector.addGoal(8, new DgrurbkLookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new DgrurbkLookAtGoal(this, EnderDragonEntity.class, 6.0F));
        this.goalSelector.addGoal(5, eatGrassGoal);
        this.goalSelector.addGoal(2, new DgrurbkAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(2, new NearestAttackableDgrurbkMobTargetGoal<>(this, LivingEntity.class, true));
        //this.targetSelector.addGoal(3, new NearestAttackableDgrurbkMobTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        this.eatingGrassTimer = this.eatGrassGoal.getEatingGrassTimer();

        if (this.isJumping) {
            if (this.ticksExisted % 10 == 0) {
                this.heal(10.0F);
            }

        } else {

            if (this.blockBreakCounter > 0) {
                --this.blockBreakCounter;
                if (this.blockBreakCounter == 0 && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
                    int i1 = MathHelper.floor(this.getPosY());
                    int l1 = MathHelper.floor(this.getPosX());
                    int i2 = MathHelper.floor(this.getPosZ());
                    boolean flag1 = false;

                    for(int k2 = -1; k2 <= 1; ++k2) {
                        for(int l2 = -1; l2 <= 1; ++l2) {
                            for(int j = 0; j <= 3; ++j) {
                                int i3 = l1 + k2;
                                int k = i1 + j;
                                int l = i2 + l2;
                                BlockPos blockpos = new BlockPos(i3, k, l);
                                BlockState blockstate = this.world.getBlockState(blockpos);
                                if (blockstate.canEntityDestroy(this.world, blockpos, this) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                                    flag1 = this.world.destroyBlock(blockpos, true, this) || flag1;
                                }
                            }
                        }
                    }

                    if (flag1) {
                        this.world.playEvent(null, 1022, this.getPosition(), 0);
                    }
                }
            }

            if (this.ticksExisted % 20 == 0) {
                this.heal(1.0F);
            }

            this.setBossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        }
    }

    public boolean isDrowning() {
        return this.getDataManager().get(DROWNING);
    }

    protected boolean shouldDrown() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.world.isRemote && this.isAlive() && !this.isAIDisabled()) {
            if (this.isDrowning()) {
                --this.drownedConversionTime;
                if (this.drownedConversionTime < 0) {
                    this.onEntity();
                }
            } else if (this.shouldDrown()) {
                if (this.areEyesInFluid(FluidTags.WATER)) {
                    ++this.inWaterTime;
                    if (this.inWaterTime >= 7200) {
                        this.startConversion();
                    }
                } else {
                    this.inWaterTime = 1000;
                }
            }
        }
    }

    private void startConversion() {
        this.drownedConversionTime = 600;
        this.getDataManager().set(DROWNING, true);
    }

    protected void onEntity() {
        this.func_234341_c_(com.babcsany.minecraft.init.EntityInit.DRURGBK);
        if (!this.isSilent()) {
            this.world.playEvent(null, 1040, this.getPosition(), 0);
        }
    }

    protected void applyAttributeBonuses(float difficulty) {
        this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).applyPersistentModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * (double)0.05F, AttributeModifier.Operation.ADDITION));
        double d0 = this.rand.nextDouble() * 1.5D * (double)difficulty;
        if (d0 > 1.0D) {
            this.getAttribute(Attributes.FOLLOW_RANGE).applyPersistentModifier(new AttributeModifier("Random zur-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        if (this.rand.nextFloat() < difficulty * 0.05F) {
            this.getAttribute(Attributes.MAX_HEALTH).applyPersistentModifier(new AttributeModifier("Leader zur bonus", this.rand.nextDouble() * 3.0D + 1.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

    }

    protected void func_234341_c_(EntityType<? extends Dgrurbk> dgrurbk) {
        Dgrurbk dgrurbkEntity = this.func_233656_b_(dgrurbk);
        if (dgrurbkEntity != null) {
            dgrurbkEntity.applyAttributeBonuses(dgrurbkEntity.world.getDifficultyForLocation(dgrurbkEntity.getPosition()).getClampedAdditionalDifficulty());
        }
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote) {
            this.handleDespawn();
        }
        if (this.world.isRemote) {
            this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        }
        if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isDropItem() && --this.timeUntilNextItem <= 0) {
            this.entityDropItem(IcsvreInit.STAPHO);
            living.entityDropEntity(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY);
            this.timeUntilNextItem = this.rand.nextInt(6000) + 3000;
        }
    }

    public boolean isDropItem() {
        return this.dropItem;
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (this.hasCustomName()) {
            this.setBossInfo.setName(this.getDisplayName());
        }

    }

    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.setBossInfo.setName(this.getDisplayName());
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

    public Dgrurbk createChild(DgrurbAgeableEntity ageable) {
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

    @Deprecated //Forge: DO NOT USE use BlockState.canEntityDestroy
    public static boolean canDestroyBlock(BlockState blockIn) {
        return !blockIn.isAir() && !BlockTags.WITHER_IMMUNE.contains(blockIn.getBlock());
    }

    public void setMotionMultiplier(BlockState state, Vector3d motionMultiplierIn) {
    }

    /**
     * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in order
     * to view its associated boss bar.
     */
    public void addTrackingPlayer(ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
        this.setBossInfo.addPlayer(player);
    }

    /**
     * Removes the given player from the list of players tracking this entity. See {@link Entity#addTrackingPlayer} for
     * more information on tracking.
     */
    public void removeTrackingPlayer(ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
        this.setBossInfo.removePlayer(player);
    }

    @Override
    public boolean canAttack(Entity target) {
        return false;
    }

    private double getHeadX(int head) {
        if (head <= 0) {
            return this.getPosX();
        } else {
            float f = (this.renderYawOffset + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
            float f1 = MathHelper.cos(f);
            return this.getPosX() + (double)f1 * 1.3D;
        }
    }

    private double getHeadY(int head) {
        return head <= 0 ? this.getPosY() + 3.0D : this.getPosY() + 2.2D;
    }

    private double getHeadZ(int head) {
        if (head <= 0) {
            return this.getPosZ();
        } else {
            float f = (this.renderYawOffset + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
            float f1 = MathHelper.sin(f);
            return this.getPosZ() + (double)f1 * 1.3D;
        }
    }

    private void launchWitherSkullToEntity(int head, Entity target) {
        this.launchDgrurbkSkullToCoords(head, target.getPosX(), target.getPosY() + (double)target.getEyeHeight() * 0.5D, target.getPosZ(), head == 0 && this.rand.nextFloat() < 0.001F);
    }

    /**
     * Launches a Wither skull toward (par2, par4, par6)
     */
    private void launchDgrurbkSkullToCoords(int head, double x, double y, double z, boolean invulnerable) {
        if (!this.isSilent()) {
            this.world.playEvent(null, 1024, this.getPosition(), 0);
        }

        double d0 = this.getHeadX(head);
        double d1 = this.getHeadY(head);
        double d2 = this.getHeadZ(head);
        double d3 = x - d0;
        double d4 = y - d1;
        double d5 = z - d2;
        DgrurbkSkullEntity dgrurbSkullEntity = new DgrurbkSkullEntity(this.world, this, d3, d4, d5);
        ZurEntity zur = new ZurEntity(this.world);
        dgrurbSkullEntity.setShooter(this);
        zur.setShooter(this);
        if (invulnerable) {
            dgrurbSkullEntity.setSkullInvulnerable(true);
            setZurInvulnerable(true);
        }

        dgrurbSkullEntity.setRawPosition(d0, d1, d2);
        zur.setRawPosition(d0, d1, d2);
        this.world.addEntity(dgrurbSkullEntity);
        this.world.addEntity(zur);
    }

    public void setZurInvulnerable(boolean invulnerable) {
        this.dataManager.set(INVULNERABLE, invulnerable);
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(Entity target, float distanceFactor) {
        this.launchWitherSkullToEntity(0, target);
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (source != DamageSource.DROWN && !(source.getTrueSource() instanceof Dgrurbk)) {
            if (source != DamageSource.GENERIC) {
                return false;
            } else {
                if (this.isCharged()) {
                    Entity entity = source.getImmediateSource();
                    if (entity instanceof AbstractArrowEntity) {
                        return true;
                    }
                }

                Entity entity1 = source.getTrueSource();
                if (!(entity1 instanceof PlayerEntity) && entity1 instanceof LivingEntity && ((LivingEntity) entity1).getCreatureAttribute() == this.getCreatureAttribute()) {
                    return false;
                } else {
                    if (this.blockBreakCounter <= 0) {
                        this.blockBreakCounter = 20;
                    }

                    if (!(entity1 instanceof HhijEntity) && entity1 instanceof LivingEntity && ((LivingEntity) entity1).getCreatureAttribute() == this.getCreatureAttribute()) {
                        return true;
                    }

                    return super.attackEntityFrom(source, amount);
                }
            }
        } else {
            return false;
        }
    }

    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropSpecialItems(source, looting, recentlyHitIn);
        ItemEntity craintBlockCraftingTable = this.entityDropItem(isBurnableBlockItemInit.CRAINT_BLOCK_CRAFTING_TABLE.get());
        ItemEntity itementity1 = this.entityDropItem(isBurnableBlockItemInit.NETHER_PORTAL.get());
        if (craintBlockCraftingTable != null) {
            craintBlockCraftingTable.setNoDespawn();
        }

    }

    public boolean isNonBoss() {
        return false;
    }
}

