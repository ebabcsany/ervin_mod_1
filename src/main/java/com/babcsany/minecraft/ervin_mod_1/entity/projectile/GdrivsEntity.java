package com.babcsany.minecraft.ervin_mod_1.entity.projectile;

public class GdrivsEntity /*extends ProjectileItemEntity*/ {
    /*public ItemStack stack;
    public static Item net_item;
    public static EntityType<GdrivsEntity> net;

    public GdrivsEntity(EntityType<? extends ProjectileItemEntity> entityType, World world) {
        super(entityType, world);
        this.stack = ItemStack.field_190927_a;
    }

    public GdrivsEntity(double x, double y, double z, World world, ItemStack newStack) {
        super(net, x, y, z, world);
        this.stack = ItemStack.field_190927_a;
        this.stack = newStack;
    }

    @Nonnull
    protected boolean func_213885_i() {
        return net_item;
    }

    protected void func_70227_a(@Nonnull RayTraceResult result) {
        if (!this.func_213885_i()) {
            RayTraceResult.Type type = result.getType();
            boolean containsEntity = Gdrivs.containsEntity(this.stack);
            if (containsEntity) {
                Entity entity = Gdrivs.getEntityFromStack(this.stack, this.field_70170_p, true);
                BlockPos pos;
                if (type == Type.ENTITY) {
                    pos = ((EntityRayTraceResult)result).func_216348_a().func_233580_cy_();
                } else {
                    pos = ((BlockRayTraceResult)result).func_216350_a();
                }

                entity.func_70080_a((double)pos.func_177958_n() + 0.5D, (double)(pos.func_177956_o() + 1), (double)pos.func_177952_p() + 0.5D, 0.0F, 0.0F);
                this.stack.func_196083_e("entity_holder");
                this.field_70170_p.func_217376_c(entity);
                ItemEntity emptynet = new ItemEntity(this.field_70170_p, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), new ItemStack(this.stack.func_77973_b()));
                this.field_70170_p.func_217376_c(emptynet);
                if (this.stack.func_77984_f()) {
                    Entity owner = this.func_234616_v_();
                    if (owner instanceof LivingEntity) {
                        this.stack.func_222118_a(1, (LivingEntity)owner, (playerEntity) -> {
                        });
                    }
                }
            } else if (type == RayTraceResult.Type.ENTITY) {
                EntityRayTraceResult entityRayTrace = (EntityRayTraceResult)result;
                Entity target = entityRayTrace.getEntity();
                if (target instanceof PlayerEntity || !target.getBoundingBox()) {
                    return;
                }

                Item item = this.stack.getStack();
                if (item instanceof Gdrivs && ((Gdrivs)item).isBlacklisted(target.getEntity())) {
                    return;
                }

                CompoundNBT nbt = Gdrivs.getNBTfromEntity(target);
                ItemStack newStack = this.stack.getStack();
                newStack.func_196082_o().func_218657_a("entity_holder", nbt);
                ItemEntity itemEntity = new ItemEntity(target.field_70170_p, target.func_226277_ct_(), target.func_226278_cu_(), target.func_226281_cx_(), newStack);
                this.field_70170_p.func_217376_c(itemEntity);
                target.func_70106_y();
            } else {
                ItemEntity emptynet = new ItemEntity(this.field_70170_p, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), new ItemStack(this.stack.func_77973_b()));
                this.field_70170_p.func_217376_c(emptynet);
            }

            this.func_70106_y();
        }
    }

    public void func_213281_b(CompoundNBT p_213281_1_) {
        super.func_213281_b(p_213281_1_);
        if (!this.stack.func_190926_b()) {
            p_213281_1_.func_218657_a("mobcatcher", this.stack.func_77955_b(this.stack.func_196082_o()));
        }

    }

    public void func_70037_a(CompoundNBT p_70037_1_) {
        super.func_70037_a(p_70037_1_);
        this.stack = ItemStack.func_199557_a(p_70037_1_.func_74775_l("mobcatcher"));
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }*/
}
