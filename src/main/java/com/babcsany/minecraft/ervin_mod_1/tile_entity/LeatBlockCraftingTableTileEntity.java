package com.babcsany.minecraft.ervin_mod_1.tile_entity;

import com.babcsany.minecraft.ervin_mod_1.init.ModTileEntities;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.Objects;

public class LeatBlockCraftingTableTileEntity extends LockableLootTileEntity {
    private NonNullList<ItemStack> leatBlockCraftingTableContents = NonNullList.withSize(20, ItemStack.EMPTY);
    private int numPlayersUsing;

    public LeatBlockCraftingTableTileEntity() {
        super(ModTileEntities.LEAT_BLOCK_CRAFTING_TABLE);
    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.leatBlockCraftingTableContents);
        }

        return compound;
    }

    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.leatBlockCraftingTableContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.leatBlockCraftingTableContents);
        }

    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return 27;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.leatBlockCraftingTableContents;
    }

    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.leatBlockCraftingTableContents = itemsIn;
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.crafting");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return createLeatBlockCraftingTableMenu(id, player, this);
    }

    public Container createLeatBlockCraftingTableMenu(int id, PlayerInventory player, IInventory blockEntity) {
        return new ChestContainer(ContainerType.GENERIC_9X1, id, player, blockEntity, 1);
    }

    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;

            this.scheduleTick();
        }

    }

    private void scheduleTick() {
        this.world.getPendingBlockTicks().scheduleTick(this.getPos(), this.getBlockState().getBlock(), 5);
    }

    public void leatBlockCraftingTableTick() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        this.numPlayersUsing = ChestTileEntity.calculatePlayersUsing(this.world, this, i, j, k);
        if (this.numPlayersUsing > 0) {
            this.scheduleTick();
        } else {
            BlockState blockstate = this.getBlockState();
            if (!blockstate.matchesBlock(isBurnableBlockItemInit.LEAT_BLOCK_CRAFTING_TABLE.getBlock())) {
                this.remove();
            }
        }
    }

    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
        }

    }

    private void setOpenProperty(BlockState state, boolean open) {
        this.world.setBlockState(this.getPos(), state.with(BarrelBlock.PROPERTY_OPEN, Boolean.valueOf(open)), 3);
    }

    private void playSound(BlockState state, SoundEvent sound) {
        Vector3i vector3i = state.get(BarrelBlock.PROPERTY_FACING).getDirectionVec();
        double d0 = (double)this.pos.getX() + 0.5D + (double)vector3i.getX() / 2.0D;
        double d1 = (double)this.pos.getY() + 0.5D + (double)vector3i.getY() / 2.0D;
        double d2 = (double)this.pos.getZ() + 0.5D + (double)vector3i.getZ() / 2.0D;
        this.world.playSound((PlayerEntity)null, d0, d1, d2, sound, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
    }
}
