package com.babcsany.minecraft.ervin_mod_1.container;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.inventory.LeatBlockCraftingTableInventory;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Optional;

public class LeatBlockCraftingTableContainer extends RecipeBookContainer<CraftingInventory> {
    private static final int CRAFT_MATRIX_WIDTH = 4;
    private static final int CRAFT_MATRIX_HEIGHT = 4;
    private static final int CRAFT_RESULT_X_POSITION = 159;
    private static final int CRAFT_RESULT_Y_POSITION = 44;
    private static final int CRAFT_RESULT_SLOT_INDEX = 0;
    private static final int CRAFT_MATRIX_TOP_LEFT_SLOT_X_POSITION = 47;
    private static final int CRAFT_MATRIX_TOP_LEFT_SLOT_Y_POSITION = 18;
    private static final int SLOT_WIDTH = 18;
    private static final int SLOT_HEIGHT = 18;
    private final CraftingInventory craftMatrix = new CraftingInventory(this, CRAFT_MATRIX_WIDTH, CRAFT_MATRIX_HEIGHT);
    private final CraftResultInventory craftResult = new CraftResultInventory();
    private final LeatBlockCraftingTableInventory craftingTableInventory = new LeatBlockCraftingTableInventory();
    private final IWorldPosCallable field_217070_e;
    private final PlayerEntity player;

    public LeatBlockCraftingTableContainer(int windowId, PlayerInventory playerInventory) {
        this(windowId, playerInventory, IWorldPosCallable.DUMMY);
    }

    public LeatBlockCraftingTableContainer(int windowId, PlayerInventory playerInventory, IWorldPosCallable p_i50090_3_) {
        super(ContainerInit.LEAT_BLOCK_CRAFTING_TABLE.get(), windowId);
        this.field_217070_e = p_i50090_3_;
        this.player = playerInventory.player;
        this.addSlot(new CraftingResultSlot(playerInventory.player, this.craftMatrix, this.craftResult, CRAFT_RESULT_SLOT_INDEX, CRAFT_RESULT_X_POSITION, CRAFT_RESULT_Y_POSITION));
        this.addSlot(new Slot(craftingTableInventory, 9, 209, 45));

        for(int i = 0; i < CRAFT_MATRIX_HEIGHT; ++i) {
            for(int j = 0; j < CRAFT_MATRIX_WIDTH; ++j) {
                this.addSlot(new Slot(this.craftMatrix, j + i * CRAFT_MATRIX_WIDTH, CRAFT_MATRIX_TOP_LEFT_SLOT_X_POSITION + j * SLOT_WIDTH, CRAFT_MATRIX_TOP_LEFT_SLOT_Y_POSITION + i * SLOT_HEIGHT));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(craftingTableInventory, l, 48 + l * 18, 98));
        }

        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 48 + i1 * 18, 130 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 48 + l * 18, 188));
        }

    }

    public LeatBlockCraftingTableContainer(int windowId, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(windowId, playerInventory, IWorldPosCallable.DUMMY);
    }

    protected static void func_217066_a(int p_217066_0_, World p_217066_1_, PlayerEntity p_217066_2_, CraftingInventory p_217066_3_, CraftResultInventory p_217066_4_) {
        if (!p_217066_1_.isRemote) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)p_217066_2_;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<ICraftingRecipe> optional = p_217066_1_.getServer().getRecipeManager().getRecipe(IRecipeType.CRAFTING, p_217066_3_, p_217066_1_);
            if (optional.isPresent()) {
                ICraftingRecipe icraftingrecipe = optional.get();
                if (p_217066_4_.canUseRecipe(p_217066_1_, serverplayerentity, icraftingrecipe)) {
                    itemstack = icraftingrecipe.getCraftingResult(p_217066_3_);
                }
            }

            p_217066_4_.setInventorySlotContents(0, itemstack);
            serverplayerentity.connection.sendPacket(new SSetSlotPacket(p_217066_0_, 0, itemstack));
        }
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.field_217070_e.consume((p_217069_1_, p_217069_2_) -> {
            func_217066_a(this.windowId, p_217069_1_, this.player, this.craftMatrix, this.craftResult);
        });
    }

    public void fillStackedContents(RecipeItemHelper itemHelperIn) {
        this.craftMatrix.fillStackedContents(itemHelperIn);
    }

    public void clear() {
        this.craftMatrix.clear();
        this.craftResult.clear();
    }

    public boolean matches(IRecipe<? super CraftingInventory> recipeIn) {
        return recipeIn.matches(this.craftMatrix, this.player.world);
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.field_217070_e.consume((p_217068_2_, p_217068_3_) -> {
            this.clearContainer(playerIn, p_217068_2_, this.craftMatrix);
        });
    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(this.field_217070_e, playerIn, BlockInit.LEAT_BLOCK_CRAFTING_TABLE.get());
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 0) {
                this.field_217070_e.consume((p_217067_2_, p_217067_3_) -> {
                    itemstack1.getItem().onCreated(itemstack1, p_217067_2_, playerIn);
                });
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 10 && index < 46) {
                if (!this.mergeItemStack(itemstack1, 1, 10, false)) {
                    if (index < 37) {
                        if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
            if (index == 0) {
                playerIn.dropItem(itemstack2, false);
            }
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is
     * null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }

    public int getOutputSlot() {
        return 0;
    }

    public int getWidth() {
        return this.craftMatrix.getWidth();
    }

    public int getHeight() {
        return this.craftMatrix.getHeight();
    }

    @OnlyIn(Dist.CLIENT)
    public int getSize() {
        return 20;
    }
}
