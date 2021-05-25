package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

/*public class BucketableMobEntity extends AnimatedWaterMobEntity implements IBucketableEntity {
    private static final DataParameter<Boolean> FROM_BUCKET;

    public BucketableMobEntity(EntityType<? extends BucketableMobEntity> type, World world) {
        super(type, world);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(FROM_BUCKET, false);
    }

    protected void setBucketData(ItemStack bucket) {
        if (this.func_145818_k_()) {
            bucket.func_200302_a(this.func_200201_e());
        }

    }

    public void func_213281_b(CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74757_a("FromBucket", this.isFromBucket());
    }

    public void func_70037_a(CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setFromBucket(compound.func_74767_n("FromBucket"));
    }

    public boolean isFromBucket() {
        return (Boolean)this.setFromBucket().func_187225_a(FROM_BUCKET);
    }

    public void setFromBucket(boolean value) {
        this.field_70180_af.func_187227_b(FROM_BUCKET, value);
    }

    protected ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() == Items.BUCKET && this.func_70089_S()) {
            this.isFromBucket(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
            itemstack.func_190918_g(1);
            ItemStack itemstack1 = this.getBucket();
            this.setBucketData(itemstack1);
            if (!this.field_70170_p.field_72995_K) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemstack1);
            }

            if (itemstack.func_190926_b()) {
                player.func_184611_a(hand, itemstack1);
            } else if (!player.field_71071_by.func_70441_a(itemstack1)) {
                player.func_71019_a(itemstack1, false);
            }

            this.func_70106_y();
            return ActionResultType.SUCCESS;
        } else {
            return super.func_230254_b_(player, hand);
        }
    }

    public boolean func_213397_c(double distanceToClosestPlayer) {
        return !this.isFromBucket() && !this.func_145818_k_();
    }

    public boolean func_213392_I() {
        return this.isFromBucket();
    }

    static {
        FROM_BUCKET = EntityDataManager.func_187226_a(BucketableMobEntity.class, DataSerializers.field_187198_h);
    }
}*/
