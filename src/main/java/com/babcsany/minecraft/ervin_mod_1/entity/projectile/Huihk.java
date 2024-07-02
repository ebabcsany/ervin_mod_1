package com.babcsany.minecraft.ervin_mod_1.entity.projectile;

import com.babcsany.minecraft.ervin_mod_1.entity.ModPlayer;
import com.babcsany.minecraft.ervin_mod_1.entity.event.ItemHuihkedEvent;
import com.babcsany.minecraft.ervin_mod_1.item.HuihkRodItem;
import com.babcsany.minecraft.ervin_mod_1.item.loot.ModLootTables;
import com.babcsany.minecraft.ervin_mod_1.tags.ModItemTags;
import com.babcsany.minecraft.ervin_mod_1.trigger.ModCriteriaTriggers;
import com.babcsany.minecraft.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ModProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Huihk extends ModProjectileEntity {
    private final Random field_234596_b_ = new Random();
    private boolean field_234597_c_;
    private int field_234598_d_;
    private static final DataParameter<Integer> DATA_HOOKED_ENTITY = EntityDataManager.createKey(Huihk.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> field_234599_f_ = EntityDataManager.createKey(Huihk.class, DataSerializers.BOOLEAN);
    private int ticksInGround;
    private int ticksCatchable;
    private int ticksCaughtDelay;
    private int ticksCatchableDelay;
    private float fishApproachAngle;
    private boolean canCatched = true;
    private Entity caughtEntity;
    private State currentState = State.FLYING;
    protected static final Fluid WATER = Fluids.WATER;
    protected static final Fluid LAVA = Fluids.LAVA;
    private Fluid currentFluid = Fluids.EMPTY;
    private final int luck;
    private final int lureSpeed;

    private Huihk(World worldIn, PlayerEntity playerIn, int luck, int lureSpeed) {
        super(EntityInit.HUIHK, worldIn);
        this.ignoreFrustumCheck = true;
        this.setShooter(playerIn);
        ModPlayer.huihk = this;
        this.luck = Math.max(0, luck);
        this.lureSpeed = Math.max(0, lureSpeed);
    }

    @OnlyIn(Dist.CLIENT)
    public Huihk(World worldIn, PlayerEntity playerIn, double x, double y, double z) {
        this(worldIn, playerIn, 0, 0);
        this.setPosition(x, y, z);
        this.prevPosX = this.getPosX();
        this.prevPosY = this.getPosY();
        this.prevPosZ = this.getPosZ();
    }

    public Huihk(PlayerEntity playerIn, World worldIn, int luck, int lureSpeed) {
        this(worldIn, playerIn, luck, lureSpeed);
        float f = playerIn.rotationPitch;
        float f1 = playerIn.rotationYaw;
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        double d0 = playerIn.getPosX() - (double)f3 * 0.3D;
        double d1 = playerIn.getPosYEye();
        double d2 = playerIn.getPosZ() - (double)f2 * 0.3D;
        this.setLocationAndAngles(d0, d1, d2, f1, f);
        Vector3d vector3d = new Vector3d((double)(-f3), (double)MathHelper.clamp(-(f5 / f4), -5.0F, 5.0F), (double)(-f2));
        double d3 = vector3d.length();
        vector3d = vector3d.mul(0.6D / d3 + 0.5D + this.rand.nextGaussian() * 0.0045D, 0.6D / d3 + 0.5D + this.rand.nextGaussian() * 0.0045D, 0.6D / d3 + 0.5D + this.rand.nextGaussian() * 0.0045D);
        this.setMotion(vector3d);
        this.rotationYaw = (float)(MathHelper.atan2(vector3d.x, vector3d.z) * (double)(180F / (float)Math.PI));
        this.rotationPitch = (float)(MathHelper.atan2(vector3d.y, (double)MathHelper.sqrt(horizontalMag(vector3d))) * (double)(180F / (float)Math.PI));
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    protected void registerData() {
        this.getDataManager().register(DATA_HOOKED_ENTITY, 0);
        this.getDataManager().register(field_234599_f_, false);
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        if (DATA_HOOKED_ENTITY.equals(key)) {
            int i = this.getDataManager().get(DATA_HOOKED_ENTITY);
            this.caughtEntity = i > 0 ? this.world.getEntityByID(i - 1) : null;
        }

        if (field_234599_f_.equals(key)) {
            this.field_234597_c_ = this.getDataManager().get(field_234599_f_);
            if (this.field_234597_c_) {
                this.setMotion(this.getMotion().x, (double)(-0.4F * MathHelper.nextFloat(this.field_234596_b_, 0.6F, 1.0F)), this.getMotion().z);
            }
        }

        super.notifyDataManagerChange(key);
    }

    /**
     * Checks if the entity is in range to render.
     */
    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        double d0 = 64.0D;
        return distance < 4096.0D;
    }

    /**
     * Sets a target for the client to interpolate towards over the next few ticks
     */
    @OnlyIn(Dist.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick() {
        this.field_234596_b_.setSeed(this.getUniqueID().getLeastSignificantBits() ^ this.world.getGameTime());
        super.tick();
        PlayerEntity playerentity = this.getPlayer();
        if (playerentity == null) {
            this.remove();
        } else if (this.world.isRemote || !this.isRemoved(playerentity)) {
            if (this.onGround) {
                ++this.ticksInGround;
                if (this.ticksInGround >= 1200) {
                    this.remove();
                    return;
                }
            } else {
                this.ticksInGround = 0;
            }

            float f = 0.0F;
            BlockPos blockpos = this.getPosition();
            FluidState fluidstate = this.world.getFluidState(blockpos);
            if (fluidstate.isTagged(FluidTags.WATER)) {
                f = fluidstate.getActualHeight(this.world, blockpos);
                this.currentFluid = WATER;
            } else if (fluidstate.isTagged(FluidTags.LAVA)) {
                f = fluidstate.getActualHeight(this.world, blockpos);
                this.currentFluid = LAVA;
            }

            boolean flag = f > 0.0F;
            if (this.currentState == State.FLYING) {
                if (this.caughtEntity != null) {
                    this.setMotion(Vector3d.ZERO);
                    this.currentState = State.HOOKED_IN_ENTITY;
                    return;
                }

                if (flag) {
                    this.setMotion(this.getMotion().mul(0.3D, 0.2D, 0.3D));
                    this.currentState = State.BOBBING;
                    return;
                }

                this.checkCollision();
            } else {
                if (this.currentState == State.HOOKED_IN_ENTITY) {
                    if (this.caughtEntity != null) {
                        if (this.caughtEntity.removed) {
                            this.caughtEntity = null;
                            this.currentState = State.FLYING;
                        } else {
                            this.setPosition(this.caughtEntity.getPosX(), this.caughtEntity.getPosYHeight(0.8D), this.caughtEntity.getPosZ());
                        }
                    }

                    return;
                }

                if (this.currentState == State.BOBBING) {
                    Vector3d vector3d = this.getMotion();
                    double d0 = this.getPosY() + vector3d.y - (double)blockpos.getY() - (double)f;
                    if (Math.abs(d0) < 0.01D) {
                        d0 += Math.signum(d0) * 0.1D;
                    }

                    this.setMotion(vector3d.x * 0.9D, vector3d.y - d0 * (double)this.rand.nextFloat() * 0.2D, vector3d.z * 0.9D);
                    if (this.ticksCatchable <= 0 && this.ticksCatchableDelay <= 0) {
                        this.canCatched = true;
                    } else {
                        this.canCatched = this.canCatched && this.field_234598_d_ < 10 && this.isOnFluid(blockpos);
                    }

                    if (flag) {
                        this.field_234598_d_ = Math.max(0, this.field_234598_d_ - 1);
                        if (this.field_234597_c_) {
                            this.setMotion(this.getMotion().add(0.0D, -0.1D * (double)this.field_234596_b_.nextFloat() * (double)this.field_234596_b_.nextFloat(), 0.0D));
                        }

                        if (!this.world.isRemote) {
                            this.catchingFish(blockpos);
                        }
                    } else {
                        this.field_234598_d_ = Math.min(10, this.field_234598_d_ + 1);
                    }
                }
            }

            if (!fluidstate.isTagged(FluidTags.WATER)) {
                this.setMotion(this.getMotion().add(0.0D, -0.03D, 0.0D));
                this.currentFluid = WATER;
            } else if (fluidstate.isTagged(FluidTags.LAVA)) {
                this.setMotion(this.getMotion().add(0.0D, -0.03D, 0.0D));
                this.currentFluid = LAVA;
            }

            this.move(MoverType.SELF, this.getMotion());
            this.updatePitchAndYaw();
            if (this.currentState == State.FLYING && (this.onGround || this.collidedHorizontally)) {
                this.setMotion(Vector3d.ZERO);
            }

            double d1 = 0.92D;
            this.setMotion(this.getMotion().scale(0.92D));
            this.recenterBoundingBox();
        }
    }

    private boolean isRemoved(PlayerEntity player) {
        ItemStack heldItemMainhand = player.getHeldItemMainhand();
        ItemStack heldItemOffhand = player.getHeldItemOffhand();
        boolean isHeldItemMainhand = heldItemMainhand.getItem() instanceof HuihkRodItem;
        boolean isHeldItemOffhand = heldItemOffhand.getItem() instanceof HuihkRodItem;
        boolean isHeldItem = isHeldItemMainhand || isHeldItemOffhand;
        if (!player.removed && player.isAlive() && isHeldItem && !(this.getDistanceSq(player) > 1024.0D)) {
            return false;
        } else {
            this.remove();
            return true;
        }
    }

    private void checkCollision() {
        RayTraceResult raytraceresult = ProjectileHelper.func_234618_a_(this, this::func_230298_a_);
        this.onImpact(raytraceresult);
    }

    @Override
    protected boolean func_230298_a_(Entity entityIn) {
        return super.func_230298_a_(entityIn) || entityIn.isAlive() && entityIn instanceof ItemEntity;
    }

    /**
     * Called when the arrow hits an entity
     */
    @Override
    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        if (!this.world.isRemote) {
            this.caughtEntity = result.getEntity();
            this.setHookedEntity();
        }

    }

    @Override
    protected void func_230299_a_(BlockRayTraceResult result) {
        super.func_230299_a_(result);
        this.setMotion(this.getMotion().normalize().scale(result.func_237486_a_(this)));
    }

    private void setHookedEntity() {
        this.getDataManager().set(DATA_HOOKED_ENTITY, this.caughtEntity.getEntityId() + 1);
    }

    private void catchingFish(BlockPos pos) {
        ServerWorld serverworld = (ServerWorld)this.world;
        int i = 1;
        BlockPos blockpos = pos.up();
        float f = this.fishApproachAngle * ((float)Math.PI / 180F);
        float f1 = MathHelper.sin(f);
        float f2 = MathHelper.cos(f);
        float f3 = f1 * 0.04F;
        float f4 = f2 * 0.04F;
        float f5 = 0.15F;
        float f6 = MathHelper.nextFloat(this.rand, 0.0F, 360.0F) * ((float)Math.PI / 180F);
        float f7 = MathHelper.nextFloat(this.rand, 25.0F, 60.0F);
        double d0 = this.getPosX() + (double)(f1 * (float)this.ticksCatchableDelay * 0.1F);
        double d1 = (double)((float)MathHelper.floor(this.getPosY()) + 1.0F);
        double d2 = this.getPosZ() + (double)(f2 * (float)this.ticksCatchableDelay * 0.1F);
        double d3 = this.getPosY() + 0.5D;
        double d4 = this.getPosX() + (double)(MathHelper.sin(f6) * f7 * 0.1F);
        double d5 = (double)((float)MathHelper.floor(this.getPosY()) + 1.0F);
        double d6 = this.getPosZ() + (double)(MathHelper.cos(f6) * f7 * 0.1F);
        BlockState blockstate = serverworld.getBlockState(new BlockPos(d0, d1 - 1.0D, d2));
        BlockState blockstate1 = serverworld.getBlockState(new BlockPos(d4, d5 - 1.0D, d6));
        Material material = blockstate.getMaterial();
        Material material1 = blockstate1.getMaterial();
        BasicParticleType BUBBLE = material == Material.WATER ? ParticleTypes.BUBBLE : ParticleTypes.DRIPPING_LAVA;
        BasicParticleType FISHING = material == Material.WATER ? ParticleTypes.FISHING : ParticleTypes.FALLING_LAVA;
        BasicParticleType SPLASH = material1 == Material.WATER ? ParticleTypes.SPLASH : ParticleTypes.LANDING_LAVA;
        if (this.rand.nextFloat() < 0.25F && this.world.isRainingAt(blockpos)) {
            ++i;
        }

        if (this.rand.nextFloat() < 0.5F && !this.world.canSeeSky(blockpos)) {
            --i;
        }

        if (this.ticksCatchable > 0) {
            --this.ticksCatchable;
            if (this.ticksCatchable <= 0) {
                this.ticksCaughtDelay = 0;
                this.ticksCatchableDelay = 0;
                this.getDataManager().set(field_234599_f_, false);
            }
        } else if (this.ticksCatchableDelay > 0) {
            this.ticksCatchableDelay -= i;
            if (this.ticksCatchableDelay > 0) {
                this.fishApproachAngle = (float)((double)this.fishApproachAngle + this.rand.nextGaussian() * 4.0D);
                if (material == Material.WATER || material == Material.LAVA) {
                    this.currentFluid = material == Material.WATER ? WATER : LAVA;
                    if (this.rand.nextFloat() < 0.15F) {
                        serverworld.spawnParticle(BUBBLE, d0, d1 - (double)0.1F, d2, 1, (double)f1, 0.1D, (double)f2, 0.0D);
                    }

                    serverworld.spawnParticle(FISHING, d0, d1, d2, 0, (double)f4, 0.01D, (double)(-f3), 1.0D);
                    serverworld.spawnParticle(FISHING, d0, d1, d2, 0, (double)(-f4), 0.01D, (double)f3, 1.0D);
                }
            } else {
                float width = this.getWidth();
                double posX = this.getPosX();
                double posZ = this.getPosZ();
                int particleCount = (int)(1.0F + width * 20.0F);
                double yOffset = 0.0D;
                double speed = 0.2F;
                if (this.currentFluid == WATER) {
                    this.playSound(SoundEvents.ENTITY_FISHING_BOBBER_SPLASH, 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
                    serverworld.spawnParticle(ParticleTypes.BUBBLE, posX, d3, posZ, particleCount, width, yOffset, width, speed);
                    serverworld.spawnParticle(ParticleTypes.FISHING, posX, d3, posZ, particleCount, width, yOffset, width, speed);
                } else if (this.currentFluid == LAVA) {
                    this.playSound(SoundEvents.BLOCK_LAVA_POP, 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
                    serverworld.spawnParticle(ParticleTypes.DRIPPING_LAVA, posX, d3, posZ, particleCount, width, yOffset, width, speed);
                    serverworld.spawnParticle(ParticleTypes.FALLING_LAVA, posX, d3, posZ, particleCount, width, yOffset, width, speed);
                }
                this.ticksCatchable = MathHelper.nextInt(this.rand, 20, 40);
                this.getDataManager().set(field_234599_f_, true);
            }
        } else if (this.ticksCaughtDelay > 0) {
            this.ticksCaughtDelay -= i;
            if (this.ticksCaughtDelay < 20) {
                f5 = (float)((double)f5 + (double)(20 - this.ticksCaughtDelay) * 0.05D);
            } else if (this.ticksCaughtDelay < 40) {
                f5 = (float)((double)f5 + (double)(40 - this.ticksCaughtDelay) * 0.02D);
            } else if (this.ticksCaughtDelay < 60) {
                f5 = (float)((double)f5 + (double)(60 - this.ticksCaughtDelay) * 0.01D);
            }

            if (this.rand.nextFloat() < f5) {
                if (material1 == Material.WATER) {
                    serverworld.spawnParticle(SPLASH, d4, d5, d6, 2 + this.rand.nextInt(2), (double) 0.1F, 0.0D, (double) 0.1F, 0.0D);
                    this.currentFluid = WATER;
                } else if (material1 == Material.LAVA) {
                    serverworld.spawnParticle(SPLASH, d4, d5, d6, 2 + this.rand.nextInt(2), (double) 0.1F, 0.0D, (double) 0.1F, 0.0D);
                    this.currentFluid = LAVA;
                }
            }

            if (this.ticksCaughtDelay <= 0) {
                this.fishApproachAngle = MathHelper.nextFloat(this.rand, 0.0F, 360.0F);
                this.ticksCatchableDelay = MathHelper.nextInt(this.rand, 20, 80);
            }
        } else {
            this.ticksCaughtDelay = MathHelper.nextInt(this.rand, 100, 600);
            this.ticksCaughtDelay -= this.lureSpeed * 20 * 5;
        }

    }

    private boolean isOnFluid(BlockPos p_234603_1_) {
        Type type = Type.INVALID;

        for(int i = -1; i <= 2; ++i) {
            Type type1 = this.type(p_234603_1_.add(-2, i, -2), p_234603_1_.add(2, i, 2));
            switch(type1) {
                case INVALID:
                    return false;
                case ABOVE_FLUID:
                    if (type == Type.INVALID) {
                        return false;
                    }
                    break;
                case INSIDE_FLUID:
                    if (type == Type.ABOVE_FLUID) {
                        return false;
                    }
            }

            type = type1;
        }

        return true;
    }

    private Type type(BlockPos firstPos, BlockPos secondPos) {
        return BlockPos.getAllInBox(firstPos, secondPos).map(this::type).reduce((first, second) -> first == second ? first : Type.INVALID).orElse(Type.INVALID);
    }

    private Type type(BlockPos pos) {
        BlockState blockstate = this.world.getBlockState(pos);
        if (!blockstate.isAir() && !blockstate.matchesBlock(Blocks.LILY_PAD) && !blockstate.matchesBlock(Blocks.MAGMA_BLOCK)) {
            FluidState fluidstate = blockstate.getFluidState();
            return (fluidstate.isTagged(FluidTags.WATER) || fluidstate.isTagged(FluidTags.LAVA)) && fluidstate.isSource() && blockstate.getCollisionShapeUncached(this.world, pos).isEmpty() ? Type.INSIDE_FLUID : Type.INVALID;
        } else {
            return Type.ABOVE_FLUID;
        }
    }

    public boolean func_234605_g_() {
        return this.isCanCatched();
    }

    public boolean isCanCatched() {
        return this.canCatched;
    }

    public void writeAdditional(CompoundNBT compound) {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
    }

    public int handleHookRetraction(ItemStack stack) {
        PlayerEntity playerentity = this.getPlayer();
        if (!this.world.isRemote && playerentity != null) {
            int i = 0;
            ItemHuihkedEvent event = null;
            if (this.caughtEntity != null) {
                this.bringInHookedEntity();
                ModCriteriaTriggers.HUIHK_ROD_HOOKED.trigger((ServerPlayerEntity) playerentity, stack, this, Collections.emptyList());
                this.world.setEntityState(this, (byte)31);
                i = this.caughtEntity instanceof ItemEntity ? 3 : 5;
            } else if (this.ticksCatchable > 0) {
                LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.world)).withParameter(LootParameters.ORIGIN, this.getPositionVec()).withParameter(LootParameters.TOOL, stack).withParameter(LootParameters.THIS_ENTITY, this).withRandom(this.rand).withLuck((float)this.luck + playerentity.getLuck());
                lootcontext$builder.withParameter(LootParameters.KILLER_ENTITY, Objects.requireNonNull(this.getShooter())).withParameter(LootParameters.THIS_ENTITY, this);
                ResourceLocation lootTable = this.currentFluid == WATER ? LootTables.GAMEPLAY_FISHING : this.currentFluid == LAVA ? ModLootTables.GAMEPLAY_HUIHK : LootTables.EMPTY;
                LootTable loottable = Objects.requireNonNull(this.world.getServer()).getLootTableManager().getLootTableFromLocation(lootTable);
                List<ItemStack> list = loottable.generate(lootcontext$builder.build(LootParameterSets.FISHING));
                event = new ItemHuihkedEvent(list, this.onGround ? 2 : 1, this);
                MinecraftForge.EVENT_BUS.post(event);
                if (event.isCanceled()) {
                    this.remove();
                    return event.getRodDamage();
                }
                ModCriteriaTriggers.HUIHK_ROD_HOOKED.trigger((ServerPlayerEntity) playerentity, stack, this, list);

                for(ItemStack itemstack : list) {
                    ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), itemstack);
                    double d0 = playerentity.getPosX() - this.getPosX();
                    double d1 = playerentity.getPosY() - this.getPosY();
                    double d2 = playerentity.getPosZ() - this.getPosZ();
                    double d3 = 0.1D;
                    itementity.setMotion(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                    this.world.addEntity(itementity);
                    playerentity.world.addEntity(new ExperienceOrbEntity(playerentity.world, playerentity.getPosX(), playerentity.getPosY() + 0.5D, playerentity.getPosZ() + 0.5D, this.rand.nextInt(6) + 1));
                    if (itemstack.getItem().isIn(ItemTags.FISHES) && itemstack.getItem().isIn(ModItemTags.HUIHKS)) {
                        playerentity.addStat(Stats.FISH_CAUGHT, 1);
                    }
                }

                i = 1;
            }

            if (this.onGround) {
                i = 2;
            }

            this.remove();
            return event == null ? i : event.getRodDamage();
        } else {
            return 0;
        }
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 31 && this.world.isRemote && this.caughtEntity instanceof PlayerEntity && ((PlayerEntity)this.caughtEntity).isUser()) {
            this.bringInHookedEntity();
        }

        super.handleStatusUpdate(id);
    }

    protected void bringInHookedEntity() {
        Entity entity = this.getShooter();
        if (entity != null) {
            Vector3d vector3d = (new Vector3d(entity.getPosX() - this.getPosX(), entity.getPosY() - this.getPosY(), entity.getPosZ() - this.getPosZ())).scale(0.1D);
            this.caughtEntity.setMotion(this.caughtEntity.getMotion().add(vector3d));
        }
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void remove(boolean keepData) {
        super.remove(keepData);
        PlayerEntity playerentity = this.getPlayer();
        if (playerentity != null) {
            ModPlayer.huihk = null;
        }
    }

    @Nullable
//    @Override
    public PlayerEntity func_234606_i_() {
        return this.getPlayer();
    }

    @Nullable
    public PlayerEntity getPlayer() {
        Entity entity = this.getShooter();
        return entity instanceof PlayerEntity ? (PlayerEntity)entity : null;
    }

    @Nullable
//    @Override
    public Entity func_234607_k_() {
        return this.getCaughtEntity();
    }

    @Nullable
    public Entity getCaughtEntity() {
        return this.caughtEntity;
    }

    /**
     * Returns false if this Entity can't move between dimensions. True if it can.
     */
    public boolean canChangeDimension() {
        return false;
    }

    public IPacket<?> createSpawnPacket() {
        Entity entity = this.getShooter();
        return new SSpawnObjectPacket(this, entity == null ? this.getEntityId() : entity.getEntityId());
    }

    static enum State {
        FLYING,
        HOOKED_IN_ENTITY,
        BOBBING;
    }

    static enum Type {
        ABOVE_FLUID,
        INSIDE_FLUID,
        INVALID;
    }
}
