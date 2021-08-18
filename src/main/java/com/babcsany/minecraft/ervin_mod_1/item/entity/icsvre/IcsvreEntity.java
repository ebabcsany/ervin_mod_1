package com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre;

import com.babcsany.minecraft.ervin_mod_1.forge.ForgeEventFactory;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.ervin_mod_1.stats.ModStats;
import com.babcsany.minecraft.forge.hooks.BasicEventHooks;
import com.babcsany.minecraft.init.EntityInit;
import com.google.common.collect.ImmutableList;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.handler.codec.EncoderException;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class IcsvreEntity extends ItemEntity {
    public final NonNullList<IcsvreStack> armorInventory = NonNullList.withSize(4, IcsvreStack.EMPTY);
    public final NonNullList<IcsvreStack> offHandInventory = NonNullList.withSize(1, IcsvreStack.EMPTY);
    private final List<NonNullList<IcsvreStack>> allInventories = ImmutableList.of(this.mainInventory, this.armorInventory, this.offHandInventory);
    public final NonNullList<IcsvreStack> mainInventory = NonNullList.withSize(36, IcsvreStack.EMPTY);
    private static final DataParameter<IcsvreStack> ICSVRE = EntityDataManager.createKey(IcsvreEntity.class, IcsvreEntity.ICSVRESTACK);
    private int age;
    public PlayerEntity player;
    public static PlayerInventory playerInventory;
    private int pickupDelay;
    private int health = 5;
    private UUID thrower;
    private UUID owner;
    public int currentItem;
    private static IcsvreEntity icsvreEntity;
    private EntityType<? extends ItemEntity> type;
    public final float hoverStart;
    private ByteBuf buf;
    private PacketBuffer packetBuffer;

    public int lifespan = 2147483647;

    public static final IDataSerializer<IcsvreStack> ICSVRESTACK = new IDataSerializer<IcsvreStack>() {
        public void write(PacketBuffer buf, IcsvreStack value) {
            icsvreEntity.writeItemStack(value);
        }

        public IcsvreStack read(PacketBuffer buf) {
            return icsvreEntity.readItemStack();
        }

        public IcsvreStack copyValue(IcsvreStack value) {
            return value.copy();
        }
    };

    public PacketBuffer writeItemStack(IcsvreStack stack) {
        return writeItemStack(stack, true);
    }

    public ByteBuf writeBoolean(boolean p_writeBoolean_1_) {
        return this.buf.writeBoolean(p_writeBoolean_1_);
    }

    public PacketBuffer writeVarInt(int input) {
        while((input & -128) != 0) {
            this.writeByte(input & 127 | 128);
            input >>>= 7;
        }

        this.writeByte(input);
        return packetBuffer;
    }

    public PacketBuffer writeItemStack(IcsvreStack stack, boolean limitedTag) {
        if (stack.isEmpty()) {
            this.writeBoolean(false);
        } else {
            this.writeBoolean(true);
            Icsvre item = stack.getIcsvre();
            this.writeVarInt(Icsvre.getIdFromItem(item.item));
            this.writeByte(stack.getCount());
            CompoundNBT compoundnbt = null;
            if (item.isDamageable() || item.shouldSyncTag()) {
                compoundnbt = limitedTag ? stack.getShareTag() : stack.getTag();
            }

            this.writeCompoundTag(compoundnbt);
        }

        return packetBuffer;
    }

    public ByteBuf writeByte(int p_writeByte_1_) {
        return this.buf.writeByte(p_writeByte_1_);
    }

    public PacketBuffer writeCompoundTag(@Nullable CompoundNBT nbt) {
        if (nbt == null) {
            this.writeByte(0);
        } else {
            try {
                CompressedStreamTools.write(nbt, new ByteBufOutputStream(buf));
            } catch (IOException ioexception) {
                throw new EncoderException(ioexception);
            }
        }

        return packetBuffer;
    }

    @Nullable
    public CompoundNBT readCompoundTag() {
        int i = this.readerIndex();
        byte b0 = this.readByte();
        if (b0 == 0) {
            return null;
        } else {
            this.readerIndex(i);

            try {
                return CompressedStreamTools.read(new ByteBufInputStream(buf), new NBTSizeTracker(2097152L));
            } catch (IOException ioexception) {
                throw new EncoderException(ioexception);
            }
        }
    }

    public int readerIndex() {
        return this.buf.readerIndex();
    }

    public ByteBuf readerIndex(int p_readerIndex_1_) {
        return this.buf.readerIndex(p_readerIndex_1_);
    }

    public int readVarInt() {
        int i = 0;
        int j = 0;

        while(true) {
            byte b0 = this.readByte();
            i |= (b0 & 127) << j++ * 7;
            if (j > 5) {
                throw new RuntimeException("VarInt too big");
            }

            if ((b0 & 128) != 128) {
                break;
            }
        }

        return i;
    }

    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    public byte readByte() {
        return this.buf.readByte();
    }

    public IcsvreStack readItemStack() {
        if (!this.readBoolean()) {
            return IcsvreStack.EMPTY;
        } else {
            int i = this.readVarInt();
            int j = this.readByte();
            IcsvreStack itemstack = new IcsvreStack(Icsvre.getItemById(i), j);
            itemstack.readShareTag(this.readCompoundTag());
            return itemstack;
        }
    }

    public IcsvreEntity(EntityType<? extends IcsvreEntity> p_i50217_1_, World world) {
        super(p_i50217_1_, world);
        this.hoverStart = (float)(Math.random() * Math.PI * 2.0D);
    }

    public IcsvreEntity(World worldIn, double x, double y, double z) {
        this(EntityInit.ICSVRE, worldIn);
        this.setPosition(x, y, z);
        this.rotationYaw = this.rand.nextFloat() * 360.0F;
        this.setMotion(this.rand.nextDouble() * 0.2D - 0.1D, 0.2D, this.rand.nextDouble() * 0.2D - 0.1D);
    }

    public IcsvreEntity(World worldIn, double x, double y, double z, IcsvreStack stack) {
        this(worldIn, x, y, z);
        this.setItem(stack);
        stack.getIcsvre();
    }

    @OnlyIn(Dist.CLIENT)
    private IcsvreEntity(IcsvreEntity icsvre) {
        super(icsvre.getType(), icsvre.world);
        this.setItem(icsvre.getItem().copy());
        this.copyLocationAndAnglesFrom(icsvre);
        this.age = icsvre.age;
        this.hoverStart = icsvre.hoverStart;
    }

    public EntityType<? extends ItemEntity> getType() {
        return this.type;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void registerData() {
        this.getDataManager().register(ICSVRE, IcsvreStack.EMPTY);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        if (getIcsvre().onEntityItemUpdate(this)) return;
        if (this.getIcsvre().isEmpty()) {
            this.remove();
        } else {
            super.tick();
            if (this.pickupDelay > 0 && this.pickupDelay != 32767) {
                --this.pickupDelay;
            }

            this.prevPosX = this.getPosX();
            this.prevPosY = this.getPosY();
            this.prevPosZ = this.getPosZ();
            Vector3d vector3d = this.getMotion();
            if (this.areEyesInFluid(FluidTags.WATER)) {
                this.applyFloatMotion();
            } else if (this.areEyesInFluid(FluidTags.LAVA)) {
                this.func_234274_v_();
            } else if (!this.hasNoGravity()) {
                this.setMotion(this.getMotion().add(0.0D, -0.04D, 0.0D));
            }

            if (this.world.isRemote) {
                this.noClip = false;
            } else {
                this.noClip = !this.world.hasNoCollisions(this);
                if (this.noClip) {
                    this.pushOutOfBlocks(this.getPosX(), (this.getBoundingBox().minY + this.getBoundingBox().maxY) / 2.0D, this.getPosZ());
                }
            }

            if (!this.onGround || horizontalMag(this.getMotion()) > (double)1.0E-5F || (this.ticksExisted + this.getEntityId()) % 4 == 0) {
                this.move(MoverType.SELF, this.getMotion());
                float f = 0.98F;
                if (this.onGround) {
                    BlockPos pos = new BlockPos(this.getPosX(), this.getPosY() - 1.0D, this.getPosZ());
                    f = this.world.getBlockState(pos).getSlipperiness(this.world, pos, this) * 0.98F;
                }

                this.setMotion(this.getMotion().mul(f, 0.98D, f));
                if (this.onGround) {
                    this.setMotion(this.getMotion().mul(1.0D, -0.5D, 1.0D));
                }
            }

            boolean flag = MathHelper.floor(this.prevPosX) != MathHelper.floor(this.getPosX()) || MathHelper.floor(this.prevPosY) != MathHelper.floor(this.getPosY()) || MathHelper.floor(this.prevPosZ) != MathHelper.floor(this.getPosZ());
            int i = flag ? 2 : 40;
            if (this.ticksExisted % i == 0) {
                if (this.world.getFluidState(this.getPosition()).isTagged(FluidTags.LAVA) && this.isImmuneToFire()) {
                    this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
                }

                if (!this.world.isRemote && this.func_213857_z()) {
                    this.searchForOtherItemsNearby();
                }
            }

            if (this.age != -32768) {
                ++this.age;
            }

            this.isAirBorne |= this.func_233566_aG_();
            if (!this.world.isRemote) {
                double d0 = this.getMotion().subtract(vector3d).lengthSquared();
                if (d0 > 0.01D) {
                    this.isAirBorne = true;
                }
            }

            IcsvreStack item = this.getIcsvre();
            if (!this.world.isRemote && this.age >= lifespan) {
                int hook = ForgeEventFactory.onIcsvreExpire(this, item);
                if (hook < 0) this.remove();
                else          this.lifespan += hook;
            }
        }
    }

    private void applyFloatMotion() {
        Vector3d vector3d = this.getMotion();
        this.setMotion(vector3d.x * (double)0.99F, vector3d.y + (double)(vector3d.y < (double)0.06F ? 5.0E-4F : 0.0F), vector3d.z * (double)0.99F);
    }

    private void func_234274_v_() {
        Vector3d vector3d = this.getMotion();
        this.setMotion(vector3d.x * (double)0.95F, vector3d.y + (double)(vector3d.y < (double)0.06F ? 5.0E-4F : 0.0F), vector3d.z * (double)0.95F);
    }

    /**
     * Looks for other itemStacks nearby and tries to stack them together
     */
    private void searchForOtherItemsNearby() {
        if (this.func_213857_z()) {
            for(IcsvreEntity icsvre : this.world.getEntitiesWithinAABB(IcsvreEntity.class, this.getBoundingBox().grow(0.5D, 0.0D, 0.5D), (icsvre) -> icsvre != this && icsvre.func_213857_z())) {
                if (icsvre.func_213857_z()) {
                    this.func_226530_a_(icsvre);
                    if (this.removed) {
                        break;
                    }
                }
            }

        }
    }

    private boolean func_213857_z() {
        ItemStack itemstack = this.getItem();
        return this.isAlive() && itemstack.getCount() < itemstack.getMaxStackSize();
    }

    private void func_226530_a_(IcsvreEntity item) {
        ItemStack itemstack = this.getItem();
        ItemStack itemStack1 = item.getItem();
        if (Objects.equals(this.getOwnerId(), item.getOwnerId()) && canMergeStacks(itemstack, itemStack1)) {
            if (itemStack1.getCount() < itemstack.getCount()) {
                func_213858_a(this, itemstack, item, itemStack1);
            } else {
                func_213858_a(item, itemStack1, this, itemstack);
            }

        }
    }

    public static boolean canMergeStacks(ItemStack stack1, ItemStack stack2) {
        if (stack2.getItem() != stack1.getItem()) {
            return false;
        } else if (stack2.getCount() + stack1.getCount() > stack2.getMaxStackSize()) {
            return false;
        } else if (stack2.hasTag() ^ stack1.hasTag()) {
            return false;
        } else if (!stack1.areCapsCompatible(stack2)) {
            return false;
        } else {
            return !stack2.hasTag() || Objects.requireNonNull(stack2.getTag()).equals(stack1.getTag());
        }
    }

    public static ItemStack mergeStacks(ItemStack stack1, ItemStack stack2, int p_226533_2_) {
        int i = Math.min(Math.min(stack1.getMaxStackSize(), p_226533_2_) - stack1.getCount(), stack2.getCount());
        ItemStack itemstack = stack1.copy();
        itemstack.grow(i);
        stack2.shrink(i);
        return itemstack;
    }

    private static void func_226531_a_(IcsvreEntity entity, ItemStack stack1, ItemStack stack2) {
        ItemStack itemstack = mergeStacks(stack1, stack2, 2048);
        entity.setItem(itemstack);
    }

    private static void func_213858_a(IcsvreEntity icsvre, ItemStack stack1, IcsvreEntity entity2, ItemStack stack2) {
        func_226531_a_(icsvre, stack1, stack2);
        icsvre.pickupDelay = Math.max(icsvre.pickupDelay, entity2.pickupDelay);
        icsvre.age = Math.min(icsvre.age, entity2.age);
        if (stack2.isEmpty()) {
            entity2.remove();
        }

    }

    public boolean isImmuneToFire() {
        return this.getItem().getItem().isBurnable() || super.isImmuneToFire();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.world.isRemote || this.removed) return false; //Forge: Fixes MC-53850
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.getItem().isEmpty() && this.getItem().getItem() == Items.NETHER_STAR && source.isExplosion()) {
            return false;
        } else if (!this.getItem().getItem().isDamageable(source)) {
            return false;
        } else {
            this.markVelocityChanged();
            this.health = (int)((float)this.health - amount);
            if (this.health <= 0) {
                this.remove();
            }

            return false;
        }
    }

    public void writeAdditional(CompoundNBT compound) {
        compound.putShort("Health", (short)this.health);
        compound.putShort("Age", (short)this.age);
        compound.putShort("PickupDelay", (short)this.pickupDelay);
        compound.putInt("Lifespan", lifespan);
        if (this.getThrowerId() != null) {
            compound.putUniqueId("Thrower", this.getThrowerId());
        }

        if (this.getOwnerId() != null) {
            compound.putUniqueId("Owner", this.getOwnerId());
        }

        if (!this.getItem().isEmpty()) {
            compound.put("Item", this.getItem().write(new CompoundNBT()));
        }

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        this.health = compound.getShort("Health");
        this.age = compound.getShort("Age");
        if (compound.contains("PickupDelay")) {
            this.pickupDelay = compound.getShort("PickupDelay");
        }
        if (compound.contains("Lifespan")) lifespan = compound.getInt("Lifespan");

        if (compound.hasUniqueId("Owner")) {
            this.owner = compound.getUniqueId("Owner");
        }

        if (compound.hasUniqueId("Thrower")) {
            this.thrower = compound.getUniqueId("Thrower");
        }

        CompoundNBT compoundnbt = compound.getCompound("Item");
        this.setItem(ItemStack.read(compoundnbt));
        if (this.getItem().isEmpty()) {
            this.remove();
        }

    }

    public boolean addIcsvreStackToInventory(IcsvreStack itemStackIn) {
        return this.add(-1, itemStackIn);
    }

    public int getFirstEmptyStack() {
        for(int i = 0; i < this.mainInventory.size(); ++i) {
            if (this.mainInventory.get(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }

    public boolean add(int slotIn, IcsvreStack stack) {
        if (stack.isEmpty()) {
            return false;
        } else {
            try {
                if (stack.isDamaged()) {
                    if (slotIn == -1) {
                        slotIn = this.getFirstEmptyStack();
                    }

                    if (slotIn >= 0) {
                        this.mainInventory.set(slotIn, stack.copy());
                        this.mainInventory.get(slotIn).setAnimationsToGo(5);
                        stack.setCount(0);
                        return true;
                    } else if (this.player.abilities.isCreativeMode) {
                        stack.setCount(0);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    int i;
                    while(true) {
                        i = stack.getCount();
                        if (slotIn == -1) {
                            stack.setCount(this.storePartialItemStack(stack));
                        } else {
                            stack.setCount(this.addResource(slotIn, stack));
                        }

                        if (stack.isEmpty() || stack.getCount() >= i) {
                            break;
                        }
                    }

                    if (stack.getCount() == i && this.player.abilities.isCreativeMode) {
                        stack.setCount(0);
                        return true;
                    } else {
                        return stack.getCount() < i;
                    }
                }
            } catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Adding item to inventory");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Icsvre being added");
                crashreportcategory.addDetail("Registry Name", () -> String.valueOf(stack.getItem().getRegistryName()));
                crashreportcategory.addDetail("Icsvre Class", () -> stack.getItem().getClass().getName());
                crashreportcategory.addDetail("Icsvre ID", Icsvre.getIdFromItem(stack.getItem()));
                crashreportcategory.addDetail("Icsvre data", stack.getDamage());
                crashreportcategory.addDetail("Icsvre name", () -> stack.getDisplayName().getString());
                throw new ReportedException(crashreport);
            }
        }
    }

    private int storePartialItemStack(IcsvreStack icsvreStackIn) {
        int i = this.storeItemStack(icsvreStackIn);
        if (i == -1) {
            i = this.getFirstEmptyStack();
        }

        return i == -1 ? icsvreStackIn.getCount() : this.addResource(i, icsvreStackIn);
    }

    private boolean canMergeStacks(IcsvreStack stack1, IcsvreStack stack2) {
        return !stack1.isEmpty() && this.stackEqualExact(stack1, stack2) && stack1.isStackable() && stack1.getCount() < stack1.getMaxStackSize() && stack1.getCount() < this.getInventoryStackLimit();
    }

    private boolean stackEqualExact(IcsvreStack stack1, IcsvreStack stack2) {
        return stack1.getItem() == stack2.getItem() && IcsvreStack.areItemStackTagsEqual(stack1, stack2);
    }

    public int storeItemStack(IcsvreStack icsvreStackIn) {
        if (this.canMergeStacks(this.getStackInSlot(this.currentItem), icsvreStackIn)) {
            return this.currentItem;
        } else if (this.canMergeStacks(this.getStackInSlot(40), icsvreStackIn)) {
            return 40;
        } else {
            for(int i = 0; i < this.mainInventory.size(); ++i) {
                if (this.canMergeStacks(this.mainInventory.get(i), icsvreStackIn)) {
                    return i;
                }
            }

            return -1;
        }
    }

    public IcsvreStack getStackInSlot(int index) {
        List<IcsvreStack> list = null;

        for(NonNullList<IcsvreStack> nonnulllist : this.allInventories) {
            if (index < nonnulllist.size()) {
                list = nonnulllist;
                break;
            }

            index -= nonnulllist.size();
        }

        return list == null ? IcsvreStack.EMPTY : list.get(index);
    }

    private int addResource(int stackInSlot, IcsvreStack icsvreStack) {
        Icsvre item = icsvreStack.getIcsvre();
        int i = icsvreStack.getCount();
        IcsvreStack icsvreStack1 = this.getStackInSlot(stackInSlot);
        if (icsvreStack1.isEmpty()) {
            icsvreStack1 = icsvreStack.copy(); // Forge: Replace Item clone above to preserve item capabilities when picking the item up.
            icsvreStack1.setCount(0);
            if (icsvreStack.hasTag()) {
                icsvreStack1.setTag(icsvreStack.getTag().copy());
            }

            this.setInventorySlotContents(stackInSlot, icsvreStack1);
        }

        int j = i;
        if (i > icsvreStack1.getMaxStackSize() - icsvreStack1.getCount()) {
            j = icsvreStack1.getMaxStackSize() - icsvreStack1.getCount();
        }

        if (j > this.getInventoryStackLimit() - icsvreStack1.getCount()) {
            j = this.getInventoryStackLimit() - icsvreStack1.getCount();
        }

        if (j == 0) {
            return i;
        } else {
            i = i - j;
            icsvreStack1.grow(j);
            icsvreStack1.setAnimationsToGo(5);
            return i;
        }
    }

    public void setInventorySlotContents(int index, IcsvreStack stack) {
        NonNullList<IcsvreStack> nonnulllist = null;

        for(NonNullList<IcsvreStack> nonnulllist1 : this.allInventories) {
            if (index < nonnulllist1.size()) {
                nonnulllist = nonnulllist1;
                break;
            }

            index -= nonnulllist1.size();
        }

        if (nonnulllist != null) {
            nonnulllist.set(index, stack);
        }

    }

    public int getInventoryStackLimit() {
        return 2048;
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(PlayerEntity entityIn) {

        if (!this.world.isRemote) {
            if (this.pickupDelay > 0) return;
            IcsvreStack icsvreStack = this.getIcsvre();
            Icsvre item = icsvreStack.getIcsvre();
            int i = icsvreStack.getCount();

            int hook = net.minecraftforge.event.ForgeEventFactory.onItemPickup(this, entityIn);
            if (hook < 0) return;

            IcsvreStack copy = icsvreStack.copy();
            if (this.pickupDelay == 0 && (this.owner == null || lifespan - this.age <= 2000000000 || this.owner.equals(entityIn.getUniqueID())) && (hook == 1 || i <= 0 || addIcsvreStackToInventory(icsvreStack))) {
                copy.setCount(copy.getCount() - getItem().getCount());
                BasicEventHooks.firePlayerItemPickupEvent(entityIn, this, copy);
                entityIn.onItemPickup(this, i);
                if (icsvreStack.isEmpty()) {
                    this.remove();
                    icsvreStack.setCount(i);
                }

                entityIn.addStat(ModStats.ICSVRE_PICKED_UP.get(item), i);
                entityIn.triggerItemPickupTrigger(this);
            }

        }
    }

    public ITextComponent getName() {
        ITextComponent itextcomponent = this.getCustomName();
        return itextcomponent != null ? itextcomponent : new TranslationTextComponent(this.getItem().getTranslationKey());
    }

    /**
     * Returns true if it's possible to attack this entity with an item.
     */
    public boolean canBeAttackedWithItem() {
        return false;
    }

    @Nullable
    public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        Entity entity = super.changeDimension(server, teleporter);
        if (!this.world.isRemote && entity instanceof IcsvreEntity) {
            ((IcsvreEntity)entity).searchForOtherItemsNearby();
        }

        return entity;
    }

    /**
     * Gets the item that this entity represents.
     */
    public IcsvreStack getIcsvre() {
        return this.getDataManager().get(ICSVRE);
    }

    /**
     * Sets the item that this entity represents.
     */
    public void setItem(IcsvreStack stack) {
        this.getDataManager().set(ICSVRE, stack);
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        super.notifyDataManagerChange(key);
        if (ICSVRE.equals(key)) {
            this.getItem().setAttachedEntity(this);
        }

    }

    @Nullable
    public UUID getOwnerId() {
        return this.owner;
    }

    public void setOwnerId(@Nullable UUID ownerId) {
        this.owner = ownerId;
    }

    @Nullable
    public UUID getThrowerId() {
        return this.thrower;
    }

    public void setThrowerId(@Nullable UUID throwerId) {
        this.thrower = throwerId;
    }

    @OnlyIn(Dist.CLIENT)
    public int getAge() {
        return this.age;
    }

    public void setDefaultPickupDelay() {
        this.pickupDelay = 10;
    }

    public void setNoPickupDelay() {
        this.pickupDelay = 0;
    }

    public void setInfinitePickupDelay() {
        this.pickupDelay = 32767;
    }

    public void setPickupDelay(int ticks) {
        this.pickupDelay = ticks;
    }

    public boolean cannotPickup() {
        return this.pickupDelay > 0;
    }

    public void makeFakeItem() {
        this.setInfinitePickupDelay();
        this.age = getItem().getEntityLifespan(world) - 1;
    }

    @OnlyIn(Dist.CLIENT)
    public float getItemHover(float partialTicks) {
        return ((float)this.getAge() + partialTicks) / 20.0F + this.hoverStart;
    }

    public IPacket<?> createSpawnPacket() {
        return new SSpawnObjectPacket(this);
    }

    @OnlyIn(Dist.CLIENT)
    public IcsvreEntity func_234273_t_() {
        return new IcsvreEntity(this);
    }
}
