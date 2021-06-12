package com.babcsany.minecraft.ervin_mod_1.item;

/*public class MobBucketItem extends BucketItem {
    private final Supplier<EntityType<? extends BucketableMobEntity>> entityType;

    public MobBucketItem(Supplier<EntityType<? extends BucketableMobEntity>> entityType, Supplier<? extends Fluid> supplier, Item.Properties builder) {
        super(supplier, builder);
        this.entityType = entityType;
    }

    public void func_203792_a(World worldIn, ItemStack stack, BlockPos pos) {
        if (!worldIn.isRemote()) {
            this.placeEntity((ServerWorld)worldIn, stack, pos);
        }

    }

    protected void func_203791_b(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }

    private void placeEntity(ServerWorld worldIn, ItemStack stack, BlockPos pos) {
        Entity entity = ((EntityType)this.entityType.get()).spawn(worldIn, stack, null, pos, SpawnReason.BUCKET, true, false);
        if (entity != null) {
            ((BucketableMobEntity)entity).setFromBucket(true);
        }

    }
}*/
