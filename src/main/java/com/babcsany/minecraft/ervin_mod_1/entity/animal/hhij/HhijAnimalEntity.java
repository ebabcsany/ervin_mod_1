package com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij;

import com.babcsany.minecraft.ervin_mod_1.trigger.ModCriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;

public abstract class HhijAnimalEntity extends HhijAgeableEntity {
    private int inLove;
    private UUID playerInLove;

    protected HhijAnimalEntity(EntityType<? extends HhijAnimalEntity> type, World worldIn) {
        super(type, worldIn);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 16.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1.0F);
    }

    protected void updateAITasks() {
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }

        super.updateAITasks();
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void livingTick() {
        super.livingTick();
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }

        if (this.inLove > 0) {
            --this.inLove;
            if (this.inLove % 10 == 0) {
                double d0 = this.rand.nextGaussian() * 0.02;
                double d1 = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0), this.getPosYRandom() + 0.5, this.getPosZRandom(1.0), d0, d1, d2);
            }
        }
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            this.inLove = 0;
            return super.attackEntityFrom(source, amount);
        }
    }

    @Deprecated
    public float getBlockPathWeight(BlockPos pos, IWorldReader reader) {
        return reader.getBlockState(pos.down()).matchesBlock(Blocks.GRASS_BLOCK) ? 10.0F : reader.getBrightness(pos) - 0.5F;
    }

    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
        nbt.putInt("InLove", this.inLove);
        if (this.playerInLove != null) {
            nbt.putUniqueId("LoveCause", this.playerInLove);
        }
    }

    /**
     * Returns the Y Offset of this entity.
     */
    public double getYOffset() {
        return 0.14;
    }

    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);
        this.inLove = nbt.getInt("InLove");
        this.playerInLove = nbt.hasUniqueId("LoveCause") ? nbt.getUniqueId("LoveCause") : null;
    }

    /**
     * Static predicate for determining whether, or not an animal can spawn at the provided location.
     *
     * @param animal The animal entity to be spawned
     */
    public static boolean canAnimalSpawn(@SuppressWarnings("UnusedDeclaration") EntityType<? extends HhijAnimalEntity> animal, IWorld world, @SuppressWarnings("UnusedDeclaration") SpawnReason reason, BlockPos pos, @SuppressWarnings("UnusedDeclaration") Random random) {
        return world.getBlockState(pos.down()).matchesBlock(Blocks.GRASS_BLOCK) && world.getLightSubtracted(pos, 0) > 8;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval() {
        return 120;
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(3);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == getBreedingItem();
    }

    public Item getBreedingItem() {
        return Items.WHEAT;
    }

    public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (this.isBreedingItem(itemstack)) {
            int i = this.getGrowingAge();
            if (!this.world.isRemote && i == 0 && this.canFallInLove()) {
                this.consumeItemFromStack(player, itemstack);
                this.setInLove(player);
                return ActionResultType.SUCCESS;
            }

            if (this.isChild()) {
                this.consumeItemFromStack(player, itemstack);
                this.ageUp((int)((float)(-i / 20) * 0.1F), true);
                return ActionResultType.func_233537_a_(this.world.isRemote);
            }

            if (this.world.isRemote) {
                return ActionResultType.CONSUME;
            }
        }

        return super.getEntityInteractionResult(player, hand);
    }

    /**
     * Decreases ItemStack size by one
     */
    protected void consumeItemFromStack(PlayerEntity player, ItemStack stack) {
        if (!player.abilities.isCreativeMode) {
            stack.shrink(1);
        }

    }

    public boolean canFallInLove() {
        return this.inLove <= 0;
    }

    public void setInLove(@Nullable PlayerEntity player) {
        this.inLove = 600;
        if (player != null) {
            this.playerInLove = player.getUniqueID();
        }

        this.world.setEntityState(this, (byte) 18);
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setInLove(int ticks) {
        this.inLove = ticks;
    }

    @SuppressWarnings("UnusedDeclaration")
    public int inLove() {
        return this.inLove;
    }

    @Nullable
    public ServerPlayerEntity getLoveCause() {
        if (this.playerInLove == null) {
            return null;
        } else {
            PlayerEntity playerentity = this.world.getPlayerByUuid(this.playerInLove);
            boolean isServerPlayer = playerentity instanceof ServerPlayerEntity;
            return isServerPlayer ? (ServerPlayerEntity) playerentity : null;
        }
    }

    /**
     * Returns if the entity is currently in 'love mode'.
     */
    public boolean isInLove() {
        return this.inLove > 0;
    }

    public void resetInLove() {
        this.inLove = 0;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(HhijAnimalEntity otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (otherAnimal.getClass() != this.getClass()) {
            return false;
        } else {
            return this.isInLove() && otherAnimal.isInLove();
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    public void spawnBabyAnimal(ServerWorld serverWorld, HhijAnimalEntity animal) {
        HhijAgeableEntity ageable = this.createChild(serverWorld, animal);
        final HhijBabyEntitySpawnEvent event = new HhijBabyEntitySpawnEvent(this, animal, ageable);
        final boolean cancelled = MinecraftForge.EVENT_BUS.post(event);
        ageable = event.getChild();
        if (cancelled) {
            //Reset the "inLove" state for the animals
            this.setGrowingAge(6000);
            animal.setGrowingAge(6000);
            this.resetInLove();
            animal.resetInLove();
        } else {
            if (ageable != null) {
                ServerPlayerEntity serverPlayer = this.getLoveCause();
                if (serverPlayer == null && animal.getLoveCause() != null) {
                    serverPlayer = animal.getLoveCause();
                }

                if (serverPlayer != null) {
                    serverPlayer.addStat(Stats.ANIMALS_BRED);
                    ModCriteriaTriggers.BRED_HHIJS.trigger(serverPlayer, this, animal, ageable);
                }

                this.setGrowingAge(6000);
                animal.setGrowingAge(6000);
                this.resetInLove();
                animal.resetInLove();
                ageable.setChild(true);
                ageable.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), 0.0F, 0.0F);
                serverWorld.func_242417_l(ageable);
                serverWorld.setEntityState(this, (byte)18);
                if (serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
                    serverWorld.addEntity(new ExperienceOrbEntity(serverWorld, this.getPosX(), this.getPosY(), this.getPosZ(), this.getRNG().nextInt(7) + 1));
                }
            }
        }
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 18) {
            for (int i = 0; i < 7; ++i) {
                double d0 = this.rand.nextGaussian() * 0.02;
                double d1 = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0), this.getPosYRandom() + 0.5, this.getPosZRandom(1.0), d0, d1, d2);
            }
        } else {
            super.handleStatusUpdate(id);
        }
    }
}