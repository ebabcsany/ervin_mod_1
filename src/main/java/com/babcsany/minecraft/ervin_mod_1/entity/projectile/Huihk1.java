package com.babcsany.minecraft.ervin_mod_1.entity.projectile;

import com.babcsany.minecraft.ervin_mod_1.entity.event.ItemHuihkedEvent;
import com.babcsany.minecraft.ervin_mod_1.item.HuihkRodItem;
import com.babcsany.minecraft.ervin_mod_1.tags.ModItemTags;
import com.babcsany.minecraft.ervin_mod_1.trigger.ModCriteriaTriggers;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.*;

public class Huihk1 extends FishingBobberEntity {
    private final Random field_234596_b_ = new Random();
    private boolean field_234597_c_;
    private int field_234598_d_;
//    private static final DataParameter<Integer> DATA_HOOKED_ENTITY = EntityDataManager.createKey(Huihk1.class, DataSerializers.VARINT);
//    private static final DataParameter<Boolean> field_234599_f_ = EntityDataManager.createKey(Huihk1.class, DataSerializers.BOOLEAN);
    private int ticksInGround;
    private int ticksCatchable;
    private int ticksCaughtDelay;
    private int ticksCatchableDelay;
    private float fishApproachAngle;
    private boolean field_234595_aq_ = true;
    private Entity caughtEntity;
    private State currentState = State.FLYING;
    private int luck;
    private int lureSpeed;
    public static final Collection<Material> VALID_MATERIALS = ImmutableList.of(Material.WATER, Material.LAVA);
    public static final Collection<ITag.INamedTag<Fluid>> VALID_FLUIDS = ImmutableList.of(FluidTags.WATER, FluidTags.LAVA);

    @OnlyIn(Dist.CLIENT)
    public Huihk1(World worldIn, PlayerEntity p_i47290_2_, double x, double y, double z) {
        super(worldIn, p_i47290_2_, x, y, z);
    }

    public Huihk1(PlayerEntity player, World world, int p_i50220_3_, int p_i50220_4_) {
        super(player, world, p_i50220_3_, p_i50220_4_);
    }

    /**
     * Checks if the entity is in range to render.
     */
    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        double d0 = 64.0D;
        return distance < 1048576.0D;
    }

    /**
     * Sets a target for the client to interpolate towards over the next few ticks
     */
    @OnlyIn(Dist.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
    }

    public boolean isTaggedSome() {
        return isTagged(0) || isTagged(1);
    }

    public boolean isNotTagged() {
        return !isTagged(0) && !isTagged(1);
    }

    public boolean isTaggedSome(FluidState fluidState) {
        return isTagged(fluidState, 0) || isTagged(fluidState, 1);
    }

    public boolean isNotTagged(FluidState fluidState) {
        return !isTagged(fluidState, 0) && !isTagged(fluidState, 1);
    }

    public boolean isTagged(int index) {
        BlockPos blockpos = this.getPosition();
        FluidState fluidState = this.world.getFluidState(blockpos);
        return isTagged(fluidState, index);
    }

    public boolean isTagged(FluidState fluidState, int index) {
        ArrayList<ITag.INamedTag<Fluid>> materials = new ArrayList<>(2);
        materials.addAll(VALID_FLUIDS);
        return (index == 0 || index == 1) && fluidState.isTagged(materials.get(index));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        this.field_234596_b_.setSeed(this.getUniqueID().getLeastSignificantBits() ^ this.world.getGameTime());
        super.tick();
        PlayerEntity playerentity = this.func_234606_i_();
        if (playerentity == null) {
            this.remove();
        } else if (this.world.isRemote || !this.func_234600_a_(playerentity)) {
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
            if (isTaggedSome()) {
                f = fluidstate.getActualHeight(this.world, blockpos);
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
                        this.field_234595_aq_ = true;
                    } else {
                        this.field_234595_aq_ = this.field_234595_aq_ && this.field_234598_d_ < 10 && this.func_234603_b_(blockpos);
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

            if (isNotTagged()) {
                this.setMotion(this.getMotion().add(0.0D, -0.03D, 0.0D));
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

    private boolean func_234600_a_(PlayerEntity player) {
        ItemStack heldItemMainhand = player.getHeldItemMainhand();
        ItemStack heldItemOffhand = player.getHeldItemOffhand();
        boolean isHeldItemMainhand = heldItemMainhand.getItem() instanceof HuihkRodItem;
        boolean isHeldItemOffhand = heldItemOffhand.getItem() instanceof HuihkRodItem;
        if (!player.removed && player.isAlive() && (isHeldItemMainhand || isHeldItemOffhand) && !(this.getDistanceSq(player) > 1024.0D)) {
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

    protected boolean func_230298_a_(Entity entityIn) {
        return super.func_230298_a_(entityIn) || entityIn.isAlive() && entityIn instanceof ItemEntity;
    }

    /**
     * Called when the arrow hits an entity
     */
    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        if (!this.world.isRemote) {
            this.caughtEntity = result.getEntity();
        }
    }

    /**
     * Check if precipitation is currently happening at a position
     */
    public boolean isHeatingAt(BlockPos position) {
        if (!this.world.isDaytime()) {
            return false;
        } else if (!this.world.canSeeSky(position)) {
            return false;
        } else if (this.world.getHeight(Heightmap.Type.MOTION_BLOCKING, position).getY() > position.getY()) {
            return false;
        } else {
            Biome biome = this.world.getBiome(position);
            return biome.getPrecipitation() == Biome.RainType.NONE && biome.getTemperature(position) <= 0.0F;
        }
    }

    private void catchingFish(BlockPos pos) {
        ServerWorld serverworld = (ServerWorld)this.world;
        int i = 1;
        BlockPos blockpos = pos.up();
        if (this.rand.nextFloat() < 0.25F && isHeatingAt(blockpos)) {
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
            }
        } else if (this.ticksCatchableDelay > 0) {
            this.ticksCatchableDelay -= i;
            if (this.ticksCatchableDelay > 0) {
                this.fishApproachAngle = (float)((double)this.fishApproachAngle + this.rand.nextGaussian() * 4.0D);
                float f = this.fishApproachAngle * ((float)Math.PI / 180F);
                float f1 = MathHelper.sin(f);
                float f2 = MathHelper.cos(f);
                double d0 = this.getPosX() + (double)(f1 * (float)this.ticksCatchableDelay * 0.1F);
                double d1 = (double)((float)MathHelper.floor(this.getPosY()) + 1.0F);
                double d2 = this.getPosZ() + (double)(f2 * (float)this.ticksCatchableDelay * 0.1F);
                BlockState blockstate = serverworld.getBlockState(new BlockPos(d0, d1 - 1.0D, d2));
                if (serverworld.getBlockState(new BlockPos((int)d0, (int)d1 - 1, (int)d2)).getMaterial() == Material.LAVA) {
                    if (this.rand.nextFloat() < 0.15F) {
                        serverworld.spawnParticle(ParticleTypes.LANDING_LAVA, d0, d1 - (double)0.1F, d2, 1, (double)f1, 0.1D, (double)f2, 0.0D);
                    }

                    float f3 = f1 * 0.04F;
                    float f4 = f2 * 0.04F;
                    serverworld.spawnParticle(ParticleTypes.FALLING_LAVA, d0, d1, d2, 0, (double)f4, 0.01D, (double)(-f3), 1.0D);
                    serverworld.spawnParticle(ParticleTypes.FALLING_LAVA, d0, d1, d2, 0, (double)(-f4), 0.01D, (double)f3, 1.0D);
                }
            } else {
                this.playSound(SoundEvents.BLOCK_LAVA_POP, 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
                double d3 = this.getPosY() + 0.5D;
                serverworld.spawnParticle(ParticleTypes.LANDING_LAVA, this.getPosX(), d3, this.getPosZ(), (int)(1.0F + this.getWidth() * 20.0F), (double)this.getWidth(), 0.0D, (double)this.getWidth(), (double)0.2F);
                serverworld.spawnParticle(ParticleTypes.FALLING_LAVA, this.getPosX(), d3, this.getPosZ(), (int)(1.0F + this.getWidth() * 20.0F), (double)this.getWidth(), 0.0D, (double)this.getWidth(), (double)0.2F);
                this.ticksCatchable = MathHelper.nextInt(this.rand, 20, 40);
            }
        } else if (this.ticksCaughtDelay > 0) {
            this.ticksCaughtDelay -= i;
            float f5 = 0.15F;
            if (this.ticksCaughtDelay < 20) {
                f5 = (float)((double)f5 + (double)(20 - this.ticksCaughtDelay) * 0.05D);
            } else if (this.ticksCaughtDelay < 40) {
                f5 = (float)((double)f5 + (double)(40 - this.ticksCaughtDelay) * 0.02D);
            } else if (this.ticksCaughtDelay < 60) {
                f5 = (float)((double)f5 + (double)(60 - this.ticksCaughtDelay) * 0.01D);
            }

            if (this.rand.nextFloat() < f5) {
                float f6 = MathHelper.nextFloat(this.rand, 0.0F, 360.0F) * ((float)Math.PI / 180F);
                float f7 = MathHelper.nextFloat(this.rand, 25.0F, 60.0F);
                double d4 = this.getPosX() + (double)(MathHelper.sin(f6) * f7 * 0.1F);
                double d5 = (double)((float)MathHelper.floor(this.getPosY()) + 1.0F);
                double d6 = this.getPosZ() + (double)(MathHelper.cos(f6) * f7 * 0.1F);
                BlockState blockstate1 = serverworld.getBlockState(new BlockPos(d4, d5 - 1.0D, d6));
                Material material = serverworld.getBlockState(new BlockPos(d4, d5 - 1.0D, d6)).getMaterial();
                BasicParticleType particle = new BasicParticleType(false);
                if (material == Material.WATER) {
                    particle = ParticleTypes.SPLASH;
                } else if (material == Material.LAVA) {
                    particle = ParticleTypes.LAVA;
                }
                if (material == Material.WATER || material == Material.LAVA) {
                    serverworld.spawnParticle(particle, d4, d5, d6, 2 + this.rand.nextInt(2), (double) 0.1F, 0.0D, (double) 0.1F, 0.0D);
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

    private boolean func_234603_b_(BlockPos p_234603_1_) {
        FluidType fishingbobberentity$watertype = FluidType.INVALID;

        for(int i = -1; i <= 2; ++i) {
            FluidType fishingbobberentity$watertype1 = this.func_234602_a_(p_234603_1_.add(-2, i, -2), p_234603_1_.add(2, i, 2));
            switch(fishingbobberentity$watertype1) {
                case INVALID:
                    return false;
                case ABOVE_FLUID:
                    if (fishingbobberentity$watertype == FluidType.INVALID) {
                        return false;
                    }
                    break;
                case INSIDE_FLUID:
                    if (fishingbobberentity$watertype == FluidType.ABOVE_FLUID) {
                        return false;
                    }
            }

            fishingbobberentity$watertype = fishingbobberentity$watertype1;
        }

        return true;
    }

    private FluidType func_234602_a_(BlockPos p_234602_1_, BlockPos p_234602_2_) {
        return BlockPos.getAllInBox(p_234602_1_, p_234602_2_).map(this::func_234604_c_).reduce((p_234601_0_, p_234601_1_) -> {
            return p_234601_0_ == p_234601_1_ ? p_234601_0_ : FluidType.INVALID;
        }).orElse(FluidType.INVALID);
    }

    private FluidType func_234604_c_(BlockPos p_234604_1_) {
        BlockState blockstate = this.world.getBlockState(p_234604_1_);
        if (!blockstate.isAir() && !blockstate.matchesBlock(Blocks.MAGMA_BLOCK)) {
            FluidState fluidstate = blockstate.getFluidState();
            return (isTaggedSome(fluidstate)) && fluidstate.isSource() && blockstate.getCollisionShapeUncached(this.world, p_234604_1_).isEmpty() ? FluidType.INSIDE_FLUID : FluidType.INVALID;
        } else {
            return FluidType.ABOVE_FLUID;
        }
    }

    public boolean func_234605_g_() {
        return this.field_234595_aq_;
    }

    public void writeAdditional(CompoundNBT compound) {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
    }

    @Override
    public int handleHookRetraction(ItemStack p_146034_1_) {
        PlayerEntity playerentity = this.func_234606_i_();
        if (!this.world.isRemote && playerentity != null) {
            int i = 0;
            ItemHuihkedEvent event = null;
            if (this.caughtEntity != null) {
                this.bringInHookedEntity();
                ModCriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity)playerentity, p_146034_1_, this, Collections.emptyList());
                this.world.setEntityState(this, (byte)31);
                i = this.caughtEntity instanceof ItemEntity ? 3 : 5;
            } else if (this.ticksCatchable > 0) {
                LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.world)).withParameter(LootParameters.ORIGIN, this.getPositionVec()).withParameter(LootParameters.TOOL, p_146034_1_).withParameter(LootParameters.THIS_ENTITY, this).withRandom(this.rand).withLuck((float)this.luck + playerentity.getLuck());
                lootcontext$builder.withParameter(LootParameters.KILLER_ENTITY, this.getShooter()).withParameter(LootParameters.THIS_ENTITY, this);
                LootTable loottable = this.world.getServer().getLootTableManager().getLootTableFromLocation(LootTables.GAMEPLAY_FISHING);
                List<ItemStack> list = loottable.generate(lootcontext$builder.build(LootParameterSets.FISHING));
                event = new ItemHuihkedEvent(list, this.onGround ? 2 : 1, (Huihk) this.caughtEntity);
                net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
                if (event.isCanceled()) {
                    this.remove();
                    return event.getRodDamage();
                }
                ModCriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity)playerentity, p_146034_1_, this, list);

                for(ItemStack itemstack : list) {
                    ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), itemstack);
                    double d0 = playerentity.getPosX() - this.getPosX();
                    double d1 = playerentity.getPosY() - this.getPosY();
                    double d2 = playerentity.getPosZ() - this.getPosZ();
                    double d3 = 0.1D;
                    itementity.setMotion(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                    this.world.addEntity(itementity);
                    playerentity.world.addEntity(new ExperienceOrbEntity(playerentity.world, playerentity.getPosX(), playerentity.getPosY() + 0.5D, playerentity.getPosZ() + 0.5D, this.rand.nextInt(6) + 1));
                    if (itemstack.getItem().isIn(ModItemTags.HUIHKS)) {
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
        PlayerEntity playerentity = this.func_234606_i_();
        if (playerentity != null) {
            playerentity.fishingBobber = null;
        }

    }

    @Nullable
    public PlayerEntity func_234606_i_() {
        Entity entity = this.getShooter();
        return entity instanceof PlayerEntity ? (PlayerEntity)entity : null;
    }

    @Nullable
    public Entity func_234607_k_() {
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

    static enum FluidType {
        ABOVE_FLUID,
        INSIDE_FLUID,
        INVALID;
    }
}
