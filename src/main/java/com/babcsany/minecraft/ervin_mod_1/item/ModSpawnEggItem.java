package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.*;

/**
 * Exists to work around a limitation with Spawn Eggs:
 * Spawn Eggs require an EntityType, but EntityTypes are created AFTER Items.
 * Therefore it is "impossible" for modded spawn eggs to exist.
 * This class gets around it by passing "null" to the SpawnEggItem constructor
 * and doing the initialisation after registry events have finished firing.
 * <p>
 * TODO: Remove once Forge adds this stuff in itself.
 *
 * @author Cadiboo
 */
public class ModSpawnEggItem extends SpawnEggItem {

    protected static final List<ModSpawnEggItem> UNADDED_EGGS = new ArrayList<ModSpawnEggItem>();
    private Lazy<? extends EntityType<?>> entityTypeSupplier;
    private EntityType<?> typeIn;

    public ModSpawnEggItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int primaryColour,
                           final int secondaryColour, final Item.Properties properties) {
        super(null, primaryColour, secondaryColour, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }

    public ModSpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColour,
                           final int secondaryColour, final Item.Properties properties) {
        super(null, primaryColour, secondaryColour, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }

    /*public static Iterable<SpawnEggItem> getEggs() {
        return Iterables.unmodifiableIterable(UNADDED_EGGS.values());
    }*/

    public static void initSpawnEggs() {
        final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class,
                null, "field_195987_b");
        DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction),
                        SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEgg : UNADDED_EGGS) {
            EGGS.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerDispenseBehavior(spawnEgg, dispenseBehaviour);
        }
        UNADDED_EGGS.clear();
    }

    public Optional<MobEntity> func_234809_a_(PlayerEntity p_234809_1_, MobEntity p_234809_2_, EntityType<? extends MobEntity> p_234809_3_, World p_234809_4_, Vector3d p_234809_5_, ItemStack p_234809_6_) {
        if (!this.hasType(p_234809_6_.getTag(), p_234809_3_)) {
            return Optional.empty();
        } else {
            MobEntity mobentity;
            if (p_234809_2_ instanceof AgeableEntity) {
                mobentity = ((AgeableEntity)p_234809_2_).createChild((AgeableEntity)p_234809_2_);
            } else {
                mobentity = p_234809_3_.create(p_234809_4_);
            }

            if (mobentity == null) {
                return Optional.empty();
            } else {
                mobentity.setChild(true);
                if (!mobentity.isChild()) {
                    return Optional.empty();
                } else {
                    mobentity.setLocationAndAngles(p_234809_5_.getX(), p_234809_5_.getY(), p_234809_5_.getZ(), 0.0F, 0.0F);
                    p_234809_4_.addEntity(mobentity);
                    if (p_234809_6_.hasDisplayName()) {
                        mobentity.setCustomName(p_234809_6_.getDisplayName());
                    }

                    if (!p_234809_1_.abilities.isCreativeMode) {
                        p_234809_6_.shrink(1);
                    }

                    return Optional.of(mobentity);
                }
            }
        }
    }

    /**
     * Called when this item is used when targetting a Block
     */
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        if (world.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            ItemStack itemstack = context.getItem();
            BlockPos blockpos = context.getPos();
            Direction direction = context.getFace();
            BlockState blockstate = world.getBlockState(blockpos);
            if (blockstate.isIn(Blocks.SPAWNER)) {
                TileEntity tileentity = world.getTileEntity(blockpos);
                if (tileentity instanceof MobSpawnerTileEntity) {
                    AbstractSpawner abstractspawner = ((MobSpawnerTileEntity)tileentity).getSpawnerBaseLogic();
                    EntityType<?> entitytype1 = this.getType(itemstack.getTag());
                    abstractspawner.setEntityType(entitytype1);
                    tileentity.markDirty();
                    world.notifyBlockUpdate(blockpos, blockstate, blockstate, 3);
                    itemstack.shrink(1);
                    return ActionResultType.CONSUME;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(world, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.offset(direction);
            }

            EntityType<?> entitytype = this.getType(itemstack.getTag());
            if (entitytype.spawn(world, itemstack, context.getPlayer(), blockpos1, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
                itemstack.shrink(1);
            }

            return ActionResultType.CONSUME;
        }
    }

    @Override
    public EntityType<?> getType(CompoundNBT nbt) {
        return this.entityTypeSupplier.get();
    }
}
