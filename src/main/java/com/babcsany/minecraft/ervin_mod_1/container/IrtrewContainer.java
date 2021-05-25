package com.babcsany.minecraft.ervin_mod_1.container;

import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.google.common.collect.Lists;
import net.minecraft.client.util.RecipeBookCategories;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
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

import java.util.List;
import java.util.Optional;

public class IrtrewContainer extends RecipeBookContainer<CraftingInventory> {
   private static final int CRAFT_MATRIX_WIDTH = 3;
   private static final int CRAFT_MATRIX_HEIGHT = 3;
   private static final int CRAFT_RESULT_X_POSITION = 127;
   private static final int CRAFT_RESULT_Y_POSITION = 33;
   private static final int CRAFT_RESULT_SLOT_INDEX = 0;
   private static final int CRAFT_MATRIX_TOP_LEFT_SLOT_X_POSITION = 32;
   private static final int CRAFT_MATRIX_TOP_LEFT_SLOT_Y_POSITION = 14;
   private static final int SLOT_WIDTH = 18;
   private static final int SLOT_HEIGHT = 18;
   private final CraftingInventory craftMatrix = new CraftingInventory(this, CRAFT_MATRIX_WIDTH, CRAFT_MATRIX_HEIGHT);
   private final CraftResultInventory craftResult = new CraftResultInventory();
   private final IWorldPosCallable worldPosCallable;
   private final PlayerEntity player;

   public IrtrewContainer(int windowId, PlayerInventory playerInventory) {
      this(windowId, playerInventory, IWorldPosCallable.DUMMY);
   }

   public IrtrewContainer(int id, PlayerInventory playerInventory, IWorldPosCallable p_i50090_3_) {
      super(ContainerInit.IRTREW.get(), id);
      this.worldPosCallable = p_i50090_3_;
      this.player = playerInventory.player;
      this.addSlot(new CraftingResultSlot(playerInventory.player, this.craftMatrix, this.craftResult, CRAFT_RESULT_SLOT_INDEX, CRAFT_RESULT_X_POSITION, CRAFT_RESULT_Y_POSITION));

      for(int i = 0; i < CRAFT_MATRIX_HEIGHT; ++i) {
         for(int j = 0; j < CRAFT_MATRIX_WIDTH; ++j) {
            this.addSlot(new Slot(this.craftMatrix, j + i * CRAFT_MATRIX_WIDTH, CRAFT_MATRIX_TOP_LEFT_SLOT_X_POSITION + j * SLOT_WIDTH, CRAFT_MATRIX_TOP_LEFT_SLOT_Y_POSITION + i * SLOT_HEIGHT));
         }
      }

      for(int k = 0; k < 3; ++k) {
         for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
         }
      }

      for(int l = 0; l < 9; ++l) {
         this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
      }

   }

   public IrtrewContainer(int windowId, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
      this(windowId, playerInventory, IWorldPosCallable.DUMMY);
   }

   protected static void updateCraftingResult(int id, World world, PlayerEntity player, CraftingInventory inventory, CraftResultInventory inventoryResult) {
      if (!world.isRemote) {
         ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)player;
         ItemStack itemstack = ItemStack.EMPTY;
         Optional<ICraftingRecipe> optional = world.getServer().getRecipeManager().getRecipe(IRecipeType.CRAFTING, inventory, world);
         if (optional.isPresent()) {
            ICraftingRecipe icraftingrecipe = optional.get();
            if (inventoryResult.canUseRecipe(world, serverplayerentity, icraftingrecipe)) {
               itemstack = icraftingrecipe.getCraftingResult(inventory);
            }
         }

         inventoryResult.setInventorySlotContents(0, itemstack);
         serverplayerentity.connection.sendPacket(new SSetSlotPacket(id, 0, itemstack));
      }
   }

   /**
    * Callback for when the crafting matrix is changed.
    */
   public void onCraftMatrixChanged(IInventory inventoryIn) {
      this.worldPosCallable.consume((p_217069_1_, p_217069_2_) -> {
         updateCraftingResult(this.windowId, p_217069_1_, this.player, this.craftMatrix, this.craftResult);
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
      this.worldPosCallable.consume((p_217068_2_, p_217068_3_) -> {
         this.clearContainer(playerIn, p_217068_2_, this.craftMatrix);
      });
   }

   /**
    * Determines whether supplied player can use this container
    */
   public boolean canInteractWith(PlayerEntity playerIn) {
      return isWithinUsableDistance(this.worldPosCallable, playerIn, isBurnableBlockItemInit.IRTREW.get());
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
            this.worldPosCallable.consume((p_217067_2_, p_217067_3_) -> {
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

   @Override
   public List<RecipeBookCategories> getRecipeBookCategories() {
      return Lists.newArrayList(RecipeBookCategories.SEARCH, RecipeBookCategories.CRAFTING_EQUIPMENT, RecipeBookCategories.CRAFTING_BUILDING_BLOCKS, RecipeBookCategories.CRAFTING_MISC, RecipeBookCategories.CRAFTING_REDSTONE);
   }
}
