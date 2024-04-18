package com.babcsany.minecraft.ervin_mod_1.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class GdrivsEntity extends ProjectileItemEntity {
    public ItemStack stack;
    public static
    Item net_item;
    public static EntityType<GdrivsEntity> net;

    public GdrivsEntity(EntityType<? extends ProjectileItemEntity> entityType, World world) {
        super(entityType, world);
        this.stack = ItemStack.EMPTY;
    }

    @Override
    protected Item getDefaultItem() {
        return net_item;
    }

    public GdrivsEntity(double x, double y, double z, World world, ItemStack newStack) {
        super(net, x, y, z, world);
        this.stack = newStack;
    }

    protected boolean func_213885_i() {
        return net_item.isDamageable();
    }

    protected void func_70227_a(@Nonnull RayTraceResult result) {
        if (!this.func_213885_i()) {
            RayTraceResult.Type type = result.getType();
            boolean containsEntity = Gdrivs.containsEntity(this.stack);
            if (containsEntity) {
                Entity entity = Gdrivs.getEntityFromStack(this.stack, this.getEntity(), true);
                BlockPos pos;
                if (type == RayTraceResult.Type.ENTITY) {
                    pos = ((EntityRayTraceResult)result).getEntity().getPosition();
                } else {
                    pos = ((BlockRayTraceResult)result).getPos();
                }

                entity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)(pos.getY() + 1), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
                this.stack.removeChildTag("entity_holder");
                this.world.addEntity(entity);
                ItemEntity emptynet = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), new ItemStack(this.stack.getItem()));
                this.world.addEntity(emptynet);
                if (this.stack.hasTag()) {
                    Entity owner = this.getEntity();
                    if (owner instanceof LivingEntity) {
                        this.stack.damageItem(1, (LivingEntity)owner, (playerEntity) -> {
                        });
                    }
                }
            } else if (type == RayTraceResult.Type.ENTITY) {
                EntityRayTraceResult entityRayTrace = (EntityRayTraceResult)result;
                Entity target = entityRayTrace.getEntity();
                if (target instanceof PlayerEntity || !target.allowLogging()) {
                    return;
                }

                Item item = this.stack.getItem();
                if (item instanceof Gdrivs && ((Gdrivs)item).isBlacklisted(target.getEntity())) {
                    return;
                }

                CompoundNBT nbt = Gdrivs.getNBTfromEntity(target);
                ItemStack newStack = this.stack.getStack();
                newStack.serializeNBT().put("entity_holder", nbt);
                ItemEntity itemEntity = new ItemEntity(target.world, target.chunkCoordX, target.chunkCoordY, target.chunkCoordZ, newStack);
                this.world.addEntity(itemEntity);
                target.remove();
            } else {
                ItemEntity emptynet = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), new ItemStack(this.stack.getItem()));
                this.world.addEntity(emptynet);
            }

            this.remove();
        }
    }

    public void func_213281_b(CompoundNBT p_213281_1_) {
        super.readAdditional(p_213281_1_);
        if (!this.stack.hasDisplayName()) {
            p_213281_1_.put("mobcatcher", this.stack.write(this.stack.getOrCreateTag()));
        }

    }

    public void func_70037_a(CompoundNBT p_70037_1_) {
        super.writeAdditional(p_70037_1_);
        this.stack = ItemStack.read(p_70037_1_.getCompound("mobcatcher"));
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
