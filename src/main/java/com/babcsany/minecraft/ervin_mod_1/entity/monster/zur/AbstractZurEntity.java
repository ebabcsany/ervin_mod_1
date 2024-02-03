package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij.HhijBreedGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.zur.ZurBreedGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAgeableEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijBabyEntitySpawnEvent;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.event.ZurTameEvent;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.goal.BowAttackGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.trigger.CriteriaTriggers1;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.ZurTrades;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.potion.*;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.village.GossipManager;
import net.minecraft.world.*;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

public abstract class AbstractZurEntity extends AgeableEntity implements INPC, IMerchant {
    public final NonNullList<ItemStack> inventory = NonNullList.withSize(1000000, ItemStack.EMPTY);
    private final BowAttackGoal<AbstractZurEntity> aiArrowAttack = new BowAttackGoal<>(this, 1.0D, 20, 15.0F);
    private static final UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
    public static final AttributeModifier MODIFIER = new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", 0.6D, AttributeModifier.Operation.ADDITION);
    private static final DataParameter<Integer> SHAKE_HEAD_TICKS = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IS_DRINKING = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BOOLEAN);
    private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    public static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TRADER_TYPE = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.VARINT);
    public static final DataParameter<Boolean> ROVENT = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BYTE);
    private final List<NonNullList<ItemStack>> allInventories = ImmutableList.of(this.inventory);
    private final BreakDoorGoal breakDoor = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
    private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> p_213697_0_ == Difficulty.HARD;
    protected static final DataParameter<Byte> TAMED = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.BYTE);
    protected static final DataParameter<Optional<BlockState>> CARRIED_BLOCK = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.OPTIONAL_BLOCK_STATE);
    public static final Map<Item, Integer> FOOD_VALUES = ImmutableMap.of(Items.BREAD, 4, Items.POTATO, 1, Items.CARROT, 1, Items.BEETROOT, 1);
    protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.createKey(AbstractZurEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    @Nullable
    public BlockPos zurTarget;
    @Nullable
    protected PlayerEntity previousCustomer;
    private AbstractZurEntity zur;
    @Nullable
    protected MerchantOffers offers;
    private boolean swimmingUp;
    @Nullable
    private BlockPos wanderTarget;
    private boolean field_233683_bw_;
    @Nullable
    private PlayerEntity customer;
    private CompoundNBT dataTag;
    private boolean doesRewardEXP = true;
    protected final SwimmerPathNavigator waterNavigator;
    protected final GroundPathNavigator groundNavigator;
    public int potionUseTimer;
    public float wingRotation;
    public int experienceLevel;
    public int experienceTotal;
    public float experience;
    protected int xpSeed;
    private int inWaterTime;
    @Nullable
    protected Raid raid;
    private int sleepTimer;
    public int xpCooldown;
    private byte foodLevel;
    protected int xp;
    private final GossipManager gossip = new GossipManager();
    private boolean field_234542_bL_;
    private long lastGossipDecay;
    private int level;
    protected int timeUntilReset;
    protected boolean leveledUp;
    private int despawnDelay;
    private int inLove;
    private UUID playerInLove;
    public boolean zurDropItem;
    public float wingRotDelta = 1.0F;
    private boolean isBreakDoorsTaskSet;
    private int eatingGrassTimer;
    private int drownedConversionTime;
    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2D, true) {
        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            super.resetTask();
            AbstractZurEntity.this.setAggroed(false);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            super.startExecuting();
            AbstractZurEntity.this.setAggroed(true);
        }
    };
    public int currentItem;
    public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;

    public AbstractZurEntity(EntityType<? extends AbstractZurEntity> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 5;
        this.waterNavigator = new SwimmerPathNavigator(this, worldIn);
        this.goalSelector.addGoal(7, new ZurBreedGoal(this, 1.0D));
        this.groundNavigator = new GroundPathNavigator(this, worldIn);
        this.setCanPickUpLoot(true);
    }

    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        if (spawnDataIn == null) {
            spawnDataIn = new AgeableData();
            ((AgeableData) spawnDataIn).setCanBabySpawn(true);
        }

        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public boolean isPushedByWater() {
        return !this.isSwimming();
    }

    private boolean func_204715_dF() {
        if (this.swimmingUp) {
            return true;
        } else {
            LivingEntity livingentity = this.getAttackTarget();
            return livingentity != null && livingentity.isInWater();
        }
    }

    public void travel(Vector3d travelVector) {
        if (this.isServerWorld() && this.isInWater() && this.func_204715_dF()) {
            this.moveRelative(0.01F, travelVector);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale(0.9D));
        } else {
            super.travel(travelVector);
        }

    }

    public void updateSwimming() {
        if (!this.world.isRemote) {
            if (this.isServerWorld() && this.isInWater() && this.func_204715_dF()) {
                this.navigator = this.waterNavigator;
                this.setSwimming(true);
            } else {
                this.navigator = this.groundNavigator;
                this.setSwimming(false);
            }
        }

    }

    protected boolean isCloseToPathTarget() {
        Path path = this.getNavigator().getPath();
        if (path != null) {
            BlockPos blockpos = path.getTarget();
            double d0 = this.getDistanceSq(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            return d0 < 4.0D;
        }

        return false;
    }

    /**
     * sets this entity's combat AI.
     */
    public void setCombatTask() {
        if (this.world != null && !this.world.isRemote) {
            this.goalSelector.removeGoal(this.aiAttackOnCollide);
            this.goalSelector.removeGoal(this.aiArrowAttack);
            ItemStack itemstack = this.getHeldItem(ProjectileHelper.getHandWith(this, isBurnableItemInit.TRITHK.get()));
            if (itemstack.getItem() instanceof net.minecraft.item.BowItem) {
                int i = 20;
                if (this.world.getDifficulty() != Difficulty.HARD) {
                    i = 40;
                }

                this.aiArrowAttack.setAttackCooldown(i);
                this.goalSelector.addGoal(4, this.aiArrowAttack);
            } else {
                this.goalSelector.addGoal(4, this.aiAttackOnCollide);
            }

            this.tickGossip();
        }
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(TAMED, (byte) 0);
        this.dataManager.register(OWNER_UNIQUE_ID, Optional.empty());
        this.dataManager.register(CARRIED_BLOCK, Optional.empty());
        this.dataManager.register(CLIMBING, (byte) 3);
        this.dataManager.register(SHAKE_HEAD_TICKS, 0);
        this.dataManager.register(IS_DRINKING, Boolean.TRUE);
        this.getDataManager().register(IS_CHILD, false);
    }

    public int getLevel() {
        return this.level;
    }

    protected boolean canLevelUp() {
        int i = this.getLevel();
        return canLevelUp(i) && this.xp >= VillagerData.func_221127_c(i);
    }

    public static boolean canLevelUp(int level) {
        return level >= 1 && level < 5;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new AttackGoal(this));
    }

    public void func_234438_m_(ItemStack p_234438_1_) {
        this.func_233657_b_(EquipmentSlotType.MAINHAND, p_234438_1_);
    }

    protected boolean shouldDrown() {
        return true;
    }

    public boolean isDrowning() {
        return this.getDataManager().get(ROVENT);
    }

    public boolean isNotChild() {
        return !this.isChild();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }

        if (this.xpCooldown > 0) {
            --this.xpCooldown;
        }
    }

    private void tickGossip() {
        long i = this.world.getGameTime();
        if (this.lastGossipDecay == 0L) {
            this.lastGossipDecay = i;
        } else if (i >= this.lastGossipDecay + 24000L) {
            this.gossip.tick();
            this.lastGossipDecay = i;
        }
    }

    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.populateTradeData();
        }

        return this.offers;
    }

    protected void populateTradeData() {
        ZurTrades.ITrade[] aWanderingTraderNirtreTrades$iTrade = ZurTrades.trade.get(1);
        if (aWanderingTraderNirtreTrades$iTrade != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.addZurTrades(merchantoffers, aWanderingTraderNirtreTrades$iTrade, 10);
            int i = this.rand.nextInt(aWanderingTraderNirtreTrades$iTrade.length);
            ZurTrades.ITrade wanderingTraderNirtreTrades$iTrade = aWanderingTraderNirtreTrades$iTrade[i];
            MerchantOffer merchantoffer = wanderingTraderNirtreTrades$iTrade.getOffer(this, this.rand);
            if (merchantoffer != null) {
                merchantoffers.add(merchantoffer);
            }

        }
    }

    /**
     * add limites numbers of trades to the given MerchantOffers
     */
    protected void addZurTrades(MerchantOffers givenMerchantOffers, ZurTrades.ITrade[] newTrades, int maxNumbers) {
        Set<Integer> set = Sets.newHashSet();
        if (newTrades.length > maxNumbers) {
            while (set.size() < maxNumbers) {
                set.add(this.rand.nextInt(newTrades.length));
            }
        } else {
            for (int i = 0; i < newTrades.length; ++i) {
                set.add(i);
            }
        }

        for (Integer integer : set) {
            ZurTrades.ITrade wanderingTraderNirtreTrades$iTrade = newTrades[integer];
            MerchantOffer merchantoffer = wanderingTraderNirtreTrades$iTrade.getOffer(this, this.rand);
            if (merchantoffer != null) {
                givenMerchantOffers.add(merchantoffer);
            }
        }

    }

    public void startSleeping(BlockPos pos) {
        super.startSleeping(pos);
        this.brain.setMemory(MemoryModuleType.LAST_SLEPT, this.world.getGameTime());
        this.brain.removeMemory(MemoryModuleType.WALK_TARGET);
        this.brain.removeMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
    }

    public ActionResultType setAnimalActionResult(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (this.isBreedingItem(itemstack)) {
            int i = this.getGrowingAge();
            if (!this.world.isRemote && i == 0 && this.canBreed()) {
                this.consumeItemFromStack(player, itemstack);
                this.setInLove(player);
                return ActionResultType.SUCCESS;
            }

            if (this.isChild()) {
                this.consumeItemFromStack(player, itemstack);
                this.ageUp((int) ((float) (-i / 20) * 0.1F), true);
                return ActionResultType.func_233537_a_(this.world.isRemote);
            }

            if (this.world.isRemote) {
                return ActionResultType.CONSUME;
            }
        }

        return super.func_230254_b_(player, hand);
    }

    public void wakeUp() {
        super.wakeUp();
        this.brain.setMemory(MemoryModuleType.LAST_WOKEN, this.world.getGameTime());
    }

    public int getPlayerReputation(PlayerEntity player) {
        return this.gossip.getReputation(player.getUniqueID(), (p_223103_0_) -> true);
    }

    public boolean isTamed() {
        return (this.dataManager.get(TAMED) & 4) != 0;
    }

    public void setTamed(boolean tamed) {
        byte b0 = this.dataManager.get(TAMED);
        if (tamed) {
            this.dataManager.set(TAMED, (byte) (b0 | 4));
        } else {
            this.dataManager.set(TAMED, (byte) (b0 & -5));
        }

        this.setupTamedAI();
    }

    protected void setupTamedAI() {
    }

    public boolean func_233684_eK_() {
        return (this.dataManager.get(TAMED) & 1) != 0;
    }

    public void func_233686_v_(boolean p_233686_1_) {
        byte b0 = this.dataManager.get(TAMED);
        if (p_233686_1_) {
            this.dataManager.set(TAMED, (byte) (b0 | 1));
        } else {
            this.dataManager.set(TAMED, (byte) (b0 & -2));
        }

    }

    @Nullable
    public UUID getOwnerId() {
        return this.dataManager.get(OWNER_UNIQUE_ID).orElse(null);
    }

    public void setOwnerId(@Nullable UUID p_184754_1_) {
        this.dataManager.set(OWNER_UNIQUE_ID, Optional.ofNullable(p_184754_1_));
    }

    public void setTamedBy(PlayerEntity player) {
        this.setTamed(true);
        this.setOwnerId(player.getUniqueID());
        if (player instanceof ServerPlayerEntity) {
            CriteriaTriggers1.TAME_ZUR.trigger((ServerPlayerEntity) player, this);
        }

    }

    @Nullable
    public LivingEntity getOwner() {
        try {
            UUID lvt_1_1_ = this.getOwnerId();
            return lvt_1_1_ == null ? null : this.world.getPlayerByUuid(lvt_1_1_);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }

    public ActionResultType setTameActionResultType(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.world.isRemote) {
            boolean flag = this.isOwner(player) || this.isTamed() || item == isBurnableItemInit.LEAT.get() && !this.isTamed();
            return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
        } else {
            if (this.isTamed()) {
                if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }

                    this.heal((float) item.getFood().getHealing());
                    return ActionResultType.SUCCESS;
                }

                if (!(item instanceof DyeItem)) {
                    ActionResultType actionresulttype = super.func_230254_b_(player, hand);
                    if ((!actionresulttype.isSuccessOrConsume() || this.isChild()) && this.isOwner(player)) {
                        this.isJumping = false;
                        this.navigator.clearPath();
                        this.setAttackTarget((LivingEntity) null);
                        return ActionResultType.SUCCESS;
                    }

                    return actionresulttype;
                }
            } else if (item == isBurnableItemInit.LEAT.get()) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                if (this.rand.nextInt(9) == 0 && !onZurTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget(null);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.world.setEntityState(this, (byte) 6);
                }

                return ActionResultType.SUCCESS;
            }

            return super.func_230254_b_(player, hand);
        }
    }

    public static boolean onZurTame(AbstractZurEntity animal, PlayerEntity tamer) {
        return MinecraftForge.EVENT_BUS.post(new ZurTameEvent(animal, tamer));
    }

    public boolean isOwner(LivingEntity p_152114_1_) {
        return p_152114_1_ == this.getOwner();
    }

    public boolean isBreedingItem(ItemStack p_70877_1_) {
        Item item = p_70877_1_.getItem();
        return item.isFood() && item.getFood().isMeat();
    }

    public boolean canBeLeader() {
        return true;
    }

    protected boolean canBreakDoors() {
        return true;
    }

    /**
     * Sets or removes EntityAIBreakDoor task
     */
    public void setBreakDoorsAItask(boolean enabled) {
        if (this.canBreakDoors()) {
            if (this.isBreakDoorsTaskSet != enabled) {
                this.isBreakDoorsTaskSet = enabled;
                ((GroundPathNavigator) this.getNavigator()).setBreakDoors(enabled);
                if (enabled) {
                    this.goalSelector.addGoal(1, this.breakDoor);
                } else {
                    this.goalSelector.removeGoal(this.breakDoor);
                }
            }
        } else if (this.isBreakDoorsTaskSet) {
            this.goalSelector.removeGoal(this.breakDoor);
            this.isBreakDoorsTaskSet = false;
        }

    }

    private void startRovent() {
        this.drownedConversionTime = 600;
        this.getDataManager().set(ROVENT, true);
    }

    protected void onRovent() {
        this.func_234341_c_(EntityInit.ROVENT_ENTITY.get());
        if (!this.isSilent()) {
            this.world.playEvent(null, 1040, this.getPosition(), 0);
        }
    }

    protected void func_234341_c_(EntityType<RoventEntity> zur) {
        RoventEntity zurEntity = this.func_233656_b_(zur);
        if (zurEntity != null) {
            zurEntity.applyAttributeBonuses(zurEntity.world.getDifficultyForLocation(zurEntity.getPosition()).getClampedAdditionalDifficulty());
        }
    }

    protected void applyAttributeBonuses(float difficulty) {
        this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).applyPersistentModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * (double) 0.05F, AttributeModifier.Operation.ADDITION));
        double d0 = this.rand.nextDouble() * 1.5D * (double) difficulty;
        if (d0 > 1.0D) {
            this.getAttribute(Attributes.FOLLOW_RANGE).applyPersistentModifier(new AttributeModifier("Random zur-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        if (this.rand.nextFloat() < difficulty * 0.05F) {
            this.getAttribute(Attributes.MAX_HEALTH).applyPersistentModifier(new AttributeModifier("Leader zur bonus", this.rand.nextDouble() * 3.0D + 1.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

    }

    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        if (itemstack.getItem() != ModSpawnEggItemInit.ZUR_SPAWN_EGG.get() && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
            if (p_230254_2_ == Hand.MAIN_HAND) {
                p_230254_1_.addStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.getOffers().isEmpty()) {
                if (!this.world.isRemote) {
                    this.setCustomer(p_230254_1_);
                    this.openMerchantContainer(p_230254_1_, this.getDisplayName(), 1);
                }

            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        }
    }

    public boolean isBreakDoorsTaskSet() {
        return this.isBreakDoorsTaskSet;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag, ZurEntity zur) {
        if (reason != SpawnReason.SPAWN_EGG) {
            if (worldIn.getRandom().nextFloat() < 0.2F) {
                this.setChild(true);
            } else if (this.isNotChild()) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, this.func_234432_eW_());
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, this.func_234432_eW1_());
            }
        }

        this.setEquipmentBasedOnDifficulty(difficultyIn);
        this.setEquipmentBasedOnDifficulty1(difficultyIn);
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    private void equipmentSlotType(EquipmentSlotType type, ItemStack stack) {
        if (this.world.rand.nextFloat() < 0.1F) {
            this.setItemStackToSlot(type, stack);
        }

    }

    /**
     * Decreases ItemStack size by one
     */
    protected void consumeItemFromStack(PlayerEntity player, ItemStack stack) {
        if (!player.abilities.isCreativeMode) {
            stack.shrink(1);
        }

    }

    public void setInLove(@Nullable PlayerEntity player) {
        this.inLove = 600;
        if (player != null) {
            this.playerInLove = player.getUniqueID();
        }

        this.world.setEntityState(this, (byte) 18);
    }

    /**
     * Creates and drops the provided item. Depending on the dropAround, it will drop teh item around the player, instead
     * of dropping the item from where the player is pointing at. Likewise, if traceItem is true, the dropped item entity
     * will have the thrower set as the player.
     */
    @Nullable
    public ItemEntity dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem) {
        if (droppedItem.isEmpty()) {
            return null;
        } else {
            if (this.world.isRemote) {
                this.swingArm(Hand.MAIN_HAND);
            }

            double d0 = this.getPosYEye() - (double) 0.3F;
            ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), d0, this.getPosZ(), droppedItem);
            itementity.setPickupDelay(40);
            if (traceItem) {
                itementity.setThrowerId(this.getUniqueID());
            }

            if (dropAround) {
                float f = this.rand.nextFloat() * 0.5F;
                float f1 = this.rand.nextFloat() * ((float) Math.PI * 2F);
                itementity.setMotion((double) (-MathHelper.sin(f1) * f), (double) 0.2F, (double) (MathHelper.cos(f1) * f));
            } else {
                float f7 = 0.3F;
                float f8 = MathHelper.sin(this.rotationPitch * ((float) Math.PI / 180F));
                float f2 = MathHelper.cos(this.rotationPitch * ((float) Math.PI / 180F));
                float f3 = MathHelper.sin(this.rotationYaw * ((float) Math.PI / 180F));
                float f4 = MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F));
                float f5 = this.rand.nextFloat() * ((float) Math.PI * 2F);
                float f6 = 0.02F * this.rand.nextFloat();
                itementity.setMotion((double) (-f3 * f2 * 0.3F) + Math.cos((double) f5) * (double) f6, (double) (-f8 * 0.3F + 0.1F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F), (double) (f4 * f2 * 0.3F) + Math.sin((double) f5) * (double) f6);
            }

            return itementity;
        }
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        if (world.isRemote) {
            if (this.isNotChild()) {
                this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.SRIUNK_HELMET.get()));
                this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.SRIUNK_CHESTPLATE.get()));
                this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.SRIUNK_LEGGINGS.get()));
                this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.SRIUNK_BOOTS.get()));
            }
            if (this.isNotChild()) {
                this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.DURG_HELMET.get()));
                this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.DURG_CHESTPLATE.get()));
                this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.DURG_LEGGINGS.get()));
                this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.DURG_BOOTS.get()));
            }
            if (this.isNotChild()) {
                this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(isBurnableArmorItemInit.NIRK_HELMET.get()));
                this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(isBurnableArmorItemInit.NIRK_CHESTPLATE.get()));
                this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(isBurnableArmorItemInit.NIRK_LEGGINGS.get()));
                this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(isBurnableArmorItemInit.NIRK_BOOTS.get()));
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(180);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_AXE.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(144);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_SHOVEL.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(108);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_SWORD.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(72);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_PICKAXE.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(36);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.NIRK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.NIRK_HOE.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(120);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_AXE.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(96);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_SHOVEL.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(72);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_SWORD.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(48);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_PICKAXE.get()));
                }
            }
            this.rand.nextFloat();
            this.world.getDifficulty();
            {
                int i = this.rand.nextInt(24);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableFoodItemInit.DURG.get()));
                } else if (i == 1) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.DURG_HOE.get()));
                } else if (i == 2) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_PICKAXE.get()));
                }
            }
            if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
                int i = this.rand.nextInt(60);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_AXE.get()));
                }
            }
            if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
                int i = this.rand.nextInt(48);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_SHOVEL.get()));
                }
            }
            if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
                int i = this.rand.nextInt(36);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_SWORD.get()));
                }
            }
            if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.EASY ? 2.0F : 0.4F)) {
                int i = this.rand.nextInt(12);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableItemInit.SRIUNK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(isBurnableToolItemInit.SRIUNK_HOE.get()));
                }
            }
            if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.PEACEFUL ? 0.5F : 0.1F)) {
                int i = this.rand.nextInt(6);
                if (i == 0) {
                    this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(isBurnableItemInit.DURK.get()));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(isBurnableItemInit.LEAT.get()));
                }
            }
        }

    }

    protected void setEquipmentBasedOnDifficulty1(DifficultyInstance difficulty) {
        if (this.isNotChild()) {
            this.equipmentSlotType(EquipmentSlotType.HEAD, new ItemStack(ArmorItemInit.FIRT_HELMET.get()));
            this.equipmentSlotType(EquipmentSlotType.CHEST, new ItemStack(ArmorItemInit.FIRT_CHESTPLATE.get()));
            this.equipmentSlotType(EquipmentSlotType.LEGS, new ItemStack(ArmorItemInit.FIRT_LEGGINGS.get()));
            this.equipmentSlotType(EquipmentSlotType.FEET, new ItemStack(ArmorItemInit.FIRT_BOOTS.get()));
        }
        if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.PEACEFUL ? 0.5F : 0.1F)) {
            int i = this.rand.nextInt(40);
            if (i == 0) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.END_STONE_STIK.get()));
            } else if (i == 1) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.KALT.get()));
            } else if (i == 2) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.FIRK.get()));
            } else if (i == 3) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.NIRG.get()));
            } else if (i == 4) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.REGDEM.get()));
            } else {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.FRIT.get()));
            }
        }
        if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.PEACEFUL ? 0.5F : 0.1F)) {
            int i = this.rand.nextInt(60);
            if (i == 0) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.KIRT_STIK.get()));
            } else if (i == 1) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.KIRT_STICK.get()));
            } else if (i == 2) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.SCIK.get()));
            } else if (i == 3) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.SCRA.get()));
            } else if (i == 4) {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.GURT.get()));
            } else {
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.CRAST.get()));
            }
        }

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

    ItemStack func_234432_eW_() {
        return this.rand.nextFloat() < 0.5D ? new ItemStack(isBurnableItemInit.SRIUNK_STICK.get()) : new ItemStack(isBurnableSpecialItemInit.DEBUG_SRIUNK_STICK.get());
    }

    ItemStack func_234432_eW1_() {
        return this.rand.nextFloat() < 0.5D ? new ItemStack(isBurnableItemInit.VIRKT.get()) : new ItemStack(isBurnableBlockItemInit.NETHER_PORTAL.get());
    }

    /**
     * Set whether this zur is a child.
     */
    public void setChild(boolean childZur) {
        this.getDataManager().set(IS_CHILD, childZur);
        if (this.world != null && !this.world.isRemote) {
            ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
            Objects.requireNonNull(modifiableattributeinstance).removeModifier(BABY_SPEED_BOOST);
            if (childZur) {
                modifiableattributeinstance.applyNonPersistentModifier(BABY_SPEED_BOOST);
            }
        }

    }

    /**
     * If Zur, checks if the age timer is negative
     */
    public boolean isChild() {
        return this.getDataManager().get(IS_CHILD);
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(PlayerEntity player) {
        if (this.isChild()) {
            this.experienceValue = (int) ((float) this.experienceValue * 10.0F);
        }

        return super.getExperiencePoints(player);
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        if (IS_CHILD.equals(key)) {
            this.recalculateSize();
        }

        super.notifyDataManagerChange(key);
    }

    public int getXp() {
        return 0;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? 0.93F : 1.74F;
    }

    @OnlyIn(Dist.CLIENT)
    public void setClientSideOffers(@Nullable MerchantOffers offers) {
    }

    public void setXP(int xpIn) {
    }

    public boolean func_213705_dZ() {
        return true;
    }

    /**
     * Notifies the merchant of a possible merchantRecipe being fulfilled or not. Usually, this is just a sound byte
     * being played depending if the suggested itemStack is not null.
     */
    public void verifySellingItem(ItemStack stack) {
        if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playSound(this.getZurYesNoSound(!stack.isEmpty()), this.getSoundVolume(), this.getSoundPitch());
        }

    }

    public SoundEvent getYesSound() {
        return SoundEvents.AMBIENT_CAVE;
    }

    protected SoundEvent getZurYesNoSound(boolean getYesSound) {
        return getYesSound ? SoundEvents.AMBIENT_CAVE : SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS;
    }

    public void playCelebrateSound() {
        this.playSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, this.getSoundVolume(), this.getSoundPitch());
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putInt("DespawnDelay", this.despawnDelay);
        compound.putInt("InLove", this.inLove);
        if (this.playerInLove != null) {
            compound.putUniqueId("LoveCause", this.playerInLove);
        }
        if (this.getOwnerId() != null) {
            compound.putUniqueId("Owner", this.getOwnerId());
        }
        if (this.wanderTarget != null) {
            compound.put("ZurTarget", NBTUtil.writeBlockPos(this.wanderTarget));
        }

        compound.putBoolean("rewardExp", this.doesRewardEXP);
        compound.putByte("FoodLevel", this.foodLevel);
        compound.putInt("Xp", this.xp);

        if (this.isChild()) {
            compound.putBoolean("IsBaby", true);
        }

        compound.putShort("SleepTimer", (short) this.sleepTimer);
        compound.putFloat("XpP", this.experience);
        compound.putInt("XpLevel", this.experienceLevel);
        compound.putInt("XpTotal", this.experienceTotal);
        compound.putInt("XpSeed", this.xpSeed);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("DespawnDelay", 99)) {
            this.despawnDelay = compound.getInt("DespawnDelay");
        }

        this.inLove = compound.getInt("InLove");
        this.playerInLove = compound.hasUniqueId("LoveCause") ? compound.getUniqueId("LoveCause") : null;

        UUID uuid;
        if (compound.hasUniqueId("Owner")) {
            uuid = compound.getUniqueId("Owner");
        } else {
            String s = compound.getString("Owner");
            uuid = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), s);
        }

        if (uuid != null) {
            try {
                this.setOwnerId(uuid);
                this.setTamed(true);
            } catch (Throwable throwable) {
                this.setTamed(false);
            }
        }

        if (compound.contains("ZurTarget")) {
            this.zurTarget = NBTUtil.readBlockPos(compound.getCompound("ZurTarget"));
        }

        if (compound.getBoolean("IsBaby")) {
            this.setChild(true);
        }

        if (compound.contains("FoodLevel", 1)) {
            this.foodLevel = compound.getByte("FoodLevel");
        }

        if (compound.contains("Xp", 3)) {
            this.xp = compound.getInt("Xp");
        }

        this.experience = compound.getFloat("XpP");
        this.experienceLevel = compound.getInt("XpLevel");
        this.experienceTotal = compound.getInt("XpTotal");
        this.xpSeed = compound.getInt("XpSeed");
        if (this.xpSeed == 0) {
            this.xpSeed = this.rand.nextInt();
        }

        this.setGrowingAge(Math.max(0, this.getGrowingAge()));
    }

    @OnlyIn(Dist.CLIENT)
    protected void spawnParticles(IParticleData particleData) {
        for (int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(particleData, this.getPosXRandom(1.0D), this.getPosYRandom() + 1.0D, this.getPosZRandom(1.0D), d0, d1, d2);
        }

    }

    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
            return true;
        } else {
            int i = inventorySlot - 300;
            return i >= 0;
        }
    }

    public World getWorld() {
        return this.world;
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    /**
     * Set whether this witch is aggressive at an entity.
     */
    public void setDrinkingPotion(boolean drinkingPotion) {
        this.getDataManager().set(IS_DRINKING, drinkingPotion);
    }

    public boolean isDrinkingPotion() {
        return this.getDataManager().get(IS_DRINKING);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zurs and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void livingTick() {
        super.livingTick();
        this.updateArmSwingProgress();
        this.wingRotation += this.wingRotDelta * 2.0F;
        if (this.world.isRemote) {
            this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        }

        if (!this.world.isRemote) {
            this.handleDespawn();
        }

        if (!this.world.isRemote && this.isAlive()) {
            if (this.isDrinkingPotion()) {
                if (this.potionUseTimer-- <= 1) {
                    this.setDrinkingPotion(false);
                    ItemStack itemstack = this.getHeldItemMainhand();
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
                    if (itemstack.getItem() == isBurnableFoodItemInit.VIRK.get()) {
                        List<EffectInstance> list = PotionUtils.getEffectsFromStack(itemstack);
                        for (EffectInstance effectinstance : list) {
                            this.addPotionEffect(new EffectInstance(effectinstance));
                        }
                    }

                    this.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(MODIFIER);
                }
            } else {
                Potion potion = null;
                if (this.rand.nextFloat() < 0.15F && this.areEyesInFluid(FluidTags.WATER) && !this.isPotionActive(Effects.WATER_BREATHING)) {
                    potion = Potions.WATER_BREATHING;
                } else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(Effects.FIRE_RESISTANCE)) {
                    potion = Potions.FIRE_RESISTANCE;
                } else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
                    potion = Potions.HEALING;
                } else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(Effects.STRENGTH) && this.getAttackTarget().getDistanceSq(this) > 2.0D || !this.isPotionActive(Effects.SPEED) && !this.isPotionActive(Effects.JUMP_BOOST)) {
                    potion = Potions.SWIFTNESS;
                }

                if (potion != null) {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(isBurnableItemInit.VIRKT.get()), potion));
                    this.potionUseTimer = this.getHeldItemMainhand().getUseDuration();
                    this.setDrinkingPotion(true);
                    if (!this.isSilent()) {
                        this.world.playSound(null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
                    }

                    ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
                    modifiableattributeinstance.removeModifier(MODIFIER);
                    modifiableattributeinstance.applyNonPersistentModifier(MODIFIER);
                }
            }

            if (this.rand.nextFloat() < 7.5E-4F) {
                this.world.setEntityState(this, (byte) 15);
            }
        }
        if (!this.world.isRemote && this.isAlive() && !this.isChild() && this.isZurDropItem() && --this.timeUntilNextItem <= 0) {
            this.entityDropItem(isBurnableItemInit.LEAT.get());
            this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
        }
    }

    protected abstract void onZurTrade(MerchantOffer offer);

    @Nullable
    public PlayerEntity getCustomer() {
        return this.customer;
    }

    public boolean hasCustomer() {
        return this.customer != null;
    }

    public boolean isZurDropItem() {
        return !this.zurDropItem;
    }

    public void handleDespawn() {
        if (this.despawnDelay > 0 && --this.despawnDelay == 0) {
            this.remove();
        }

    }

    public boolean getDoesRewardExp() {
        return this.doesRewardEXP;
    }

    protected void func_213623_ec() {
        float f = this.getBrightness();
        if (f > 0.5F) {
            this.idleTime += 2;
        }

    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_HOSTILE_SWIM;
    }

    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_HOSTILE_SPLASH;
    }

    private boolean stackEqualExact(ItemStack stack1, ItemStack stack2) {
        return stack1.getItem() == stack2.getItem() && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }

    private boolean canMergeStacks(ItemStack stack1, ItemStack stack2) {
        return !stack1.isEmpty() && this.stackEqualExact(stack1, stack2) && stack1.isStackable() && stack1.getCount() < stack1.getMaxStackSize() && stack1.getCount() < this.getInventoryStackLimit();
    }

    int getInventoryStackLimit() {
        return 1000000000;
    }

    public int storeItemStack(ItemStack itemStackIn) {
        if (this.canMergeStacks(this.getStackInSlot(this.currentItem), itemStackIn)) {
            return this.currentItem;
        } else if (this.canMergeStacks(this.getStackInSlot(40), itemStackIn)) {
            return 40;
        } else {
            for (int i = 0; i < this.inventory.size(); ++i) {
                if (this.canMergeStacks(this.inventory.get(i), itemStackIn)) {
                    return i;
                }
            }

            return -1;
        }
    }

    public ItemStack getStackInSlot(int index) {
        List<ItemStack> list = null;

        for (NonNullList<ItemStack> nonNullList : this.allInventories) {
            if (index < nonNullList.size()) {
                list = nonNullList;
                break;
            }

            index -= nonNullList.size();
        }

        return list == null ? ItemStack.EMPTY : list.get(index);
    }

    public int getFirstEmptyStack() {
        for (int i = 0; i < this.inventory.size(); ++i) {
            if (this.inventory.get(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }

    protected SoundEvent getFallSound(int heightIn) {
        return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
    }

    public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
        return 0.5F - worldIn.getBrightness(pos);
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        BlockPos blockpos = pos.up();
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(blockpos).canEntitySpawn(worldIn, blockpos, typeIn);
    }

    public static AttributeModifierMap.MutableAttribute func_234295_eP_() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE);
    }

    /**
     * Entity won't drop items or experience points if this returns false
     */
    protected boolean canDropLoot() {
        return true;
    }

    protected boolean func_230282_cS_() {
        return true;
    }

    public boolean func_230292_f_(PlayerEntity player) {
        return true;
    }

    public ItemStack findAmmo(ItemStack shootable) {
        if (shootable.getItem() instanceof ShootableItem) {
            Predicate<ItemStack> predicate = ((ShootableItem) shootable.getItem()).getAmmoPredicate();
            ItemStack itemstack = ShootableItem.getHeldAmmo(this, predicate);
            return itemstack.isEmpty() ? new ItemStack(Items.ARROW) : itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    public void setCustomer(PlayerEntity player) {
        this.customer = player;
    }

    public boolean canBreed() {
        return this.inLove <= 0;
    }

    /**
     * Returns if the entity is currently in 'love mode'.
     */
    public boolean isInLove() {
        return this.inLove > 0;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(AbstractZurEntity zur) {
        if (zur == this) {
            return false;
        } else if (zur.getClass() != this.getClass()) {
            return false;
        } else {
            return this.isInLove() && zur.isInLove();
        }
    }

    public void func_234177_a_(World p_234177_1_, AbstractZurEntity p_234177_2_) {
        AgeableEntity ageableentity = this.createChild(p_234177_2_);
        final BabyEntitySpawnEvent event = new BabyEntitySpawnEvent(this, p_234177_2_, ageableentity);
        final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
        ageableentity = event.getChild();
        if (cancelled) {
            //Reset the "inLove" state for the animals
            this.setGrowingAge(6000);
            p_234177_2_.setGrowingAge(6000);
            this.resetInLove();
            p_234177_2_.resetInLove();
            return;
        }
        if (ageableentity != null) {
            ServerPlayerEntity serverplayerentity = this.getLoveCause();
            if (serverplayerentity == null && p_234177_2_.getLoveCause() != null) {
                serverplayerentity = p_234177_2_.getLoveCause();
            }

            if (serverplayerentity != null) {
                serverplayerentity.addStat(Stats.ANIMALS_BRED);
                CriteriaTriggers1.BRED_ZURS.trigger(serverplayerentity, this, p_234177_2_, ageableentity);
            }

            this.setGrowingAge(6000);
            p_234177_2_.setGrowingAge(6000);
            this.resetInLove();
            p_234177_2_.resetInLove();
            ageableentity.setChild(true);
            ageableentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), 0.0F, 0.0F);
            p_234177_1_.addEntity(ageableentity);
            p_234177_1_.setEntityState(this, (byte) 18);
            if (p_234177_1_.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
                p_234177_1_.addEntity(new ExperienceOrbEntity(p_234177_1_, this.getPosX(), this.getPosY(), this.getPosZ(), this.getRNG().nextInt(7) + 1));
            }

        }
    }

    @Nullable
    public ServerPlayerEntity getLoveCause() {
        if (this.playerInLove == null) {
            return null;
        } else {
            PlayerEntity playerentity = this.world.getPlayerByUuid(this.playerInLove);
            return playerentity instanceof ServerPlayerEntity ? (ServerPlayerEntity) playerentity : null;
        }
    }

    public void resetInLove() {
        this.inLove = 0;
    }

    public static class LeapAtTargetGoal extends Goal {
        private final MobEntity leaper;
        private LivingEntity leapTarget;
        private final float leapMotionY;

        public LeapAtTargetGoal(MobEntity leapingEntity, float leapMotionYIn) {
            this.leaper = leapingEntity;
            this.leapMotionY = leapMotionYIn;
            this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            if (this.leaper.isBeingRidden()) {
                return false;
            } else {
                this.leapTarget = this.leaper.getAttackTarget();
                if (this.leapTarget == null) {
                    return false;
                } else {
                    double d0 = this.leaper.getDistanceSq(this.leapTarget);
                    if (!(d0 < 4.0D) && !(d0 > 16.0D)) {
                        if (!this.leaper.isOnGround()) {
                            return false;
                        } else {
                            return this.leaper.getRNG().nextInt(5) == 0;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return !this.leaper.isOnGround();
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            Vector3d vector3d = this.leaper.getMotion();
            Vector3d vector3d1 = new Vector3d(this.leapTarget.getPosX() - this.leaper.getPosX(), 0.0D, this.leapTarget.getPosZ() - this.leaper.getPosZ());
            if (vector3d1.lengthSquared() > 1.0E-7D) {
                vector3d1 = vector3d1.normalize().scale(0.4D).add(vector3d.scale(0.2D));
            }

            this.leaper.setMotion(vector3d1.x, this.leapMotionY, vector3d1.z);
        }
    }

    public static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(AbstractZurEntity zur) {
            super(zur, 1.0D, true);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return super.shouldExecute() && !this.attacker.isBeingRidden();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            float f = this.attacker.getBrightness();
            if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
                this.attacker.setAttackTarget(null);
                return false;
            } else {
                return super.shouldContinueExecuting();
            }
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 4.0F + attackTarget.getWidth();
        }
    }

    static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public TargetGoal(ZurEntity zur, Class<T> classTarget) {
            super(zur, classTarget, true);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            float f = this.goalOwner.getBrightness();
            return !(f >= 0.5F) && super.shouldExecute();
        }
    }

    /**
     * Returns true if this entity should move as if it were on a ladder (either because it's actually on a ladder, or
     * for AI reasons)
     */
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }

    public void setMotionMultiplier(BlockState state, Vector3d motionMultiplierIn) {
        if (!state.isIn(Blocks.COBWEB)) {
            super.setMotionMultiplier(state, motionMultiplierIn);
        }

    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        if (potioneffectIn.getPotion() == Effects.POISON) {
            net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent event = new net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent(this, potioneffectIn);
            net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
            return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
        }
        return super.isPotionApplicable(potioneffectIn);
    }

    public static class MorningGiftGoal extends Goal {
        private final ZurEntity zurEntity;
        private TameableEntity tameableEntity;
        private PlayerEntity owner;
        private BlockPos bedPos;
        private int tickCounter;

        public MorningGiftGoal(ZurEntity zurIn) {
            this.zurEntity = zurIn;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return false;
        }

        private boolean func_220805_g() {


            return false;
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return !this.tameableEntity.func_233685_eM_() && this.owner != null && this.owner.isSleeping() && this.bedPos != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            if (this.bedPos != null) {
                this.tameableEntity.func_233686_v_(false);
                this.zurEntity.getNavigator().tryMoveToXYZ(this.bedPos.getX(), (double) this.bedPos.getY(), (double) this.bedPos.getZ(), (double) 1.1F);
            }

        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            float f = this.zurEntity.world.getCelestialAngle(1.0F);
            if (this.owner.getSleepTimer() >= 100 && (double) f > 0.77D && (double) f < 0.8D && (double) this.zurEntity.world.getRandom().nextFloat() < 0.7D) {
                this.func_220804_h();
            }

            this.tickCounter = 0;
            this.zurEntity.getNavigator().clearPath();
        }

        private void func_220804_h() {
            Random random = this.zurEntity.getRNG();
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
            blockpos$mutable.setPos(this.zurEntity.getPosition());
            this.zurEntity.attemptTeleport(blockpos$mutable.getX() + random.nextInt(11) - 5, blockpos$mutable.getY() + random.nextInt(5) - 2, blockpos$mutable.getZ() + random.nextInt(11) - 5, false);
            blockpos$mutable.setPos(this.zurEntity.getPosition());
            LootTable loottable = this.zurEntity.world.getServer().getLootTableManager().getLootTableFromLocation(LootTables.GAMEPLAY_CAT_MORNING_GIFT);
            LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld) this.zurEntity.world)).withParameter(LootParameters.POSITION, blockpos$mutable).withParameter(LootParameters.THIS_ENTITY, this.zurEntity).withRandom(random);

            for (ItemStack itemstack : loottable.generate(lootcontext$builder.build(LootParameterSets.GIFT))) {
                this.zurEntity.world.addEntity(new ItemEntity(this.zurEntity.world, (double) blockpos$mutable.getX() - (double) MathHelper.sin(this.zurEntity.renderYawOffset * ((float) Math.PI / 180F)), blockpos$mutable.getY(), (double) blockpos$mutable.getZ() + (double) MathHelper.cos(this.zurEntity.renderYawOffset * ((float) Math.PI / 180F)), itemstack));
            }

        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.owner != null && this.bedPos != null) {
                this.tameableEntity.func_233686_v_(false);
                this.zurEntity.getNavigator().tryMoveToXYZ(this.bedPos.getX(), (double) this.bedPos.getY(), (double) this.bedPos.getZ(), (double) 1.1F);
                if (this.zurEntity.getDistanceSq(this.owner) < 2.5D) {
                    ++this.tickCounter;
                } else {
                }
            }

        }
    }

    /**
     * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
     * setBesideClimbableBlock.
     */
    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(CLIMBING) & 1) != 0;
    }

    /**
     * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
     * false.
     */
    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.dataManager.get(CLIMBING);
        if (climbing) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.dataManager.set(CLIMBING, b0);
    }

    public boolean entityLivingUpdate(HhijEntity entity) {
        return false;
    }

    public enum Action {
        CROSSBOW_HOLD,
        ADMIRING_ITEM,
        DEFAULT;
    }
}
