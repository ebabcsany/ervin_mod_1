package com.babcsany.minecraft.ervin_mod_1.item.group;

import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.brefk.BrefkStageItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class ItemGroup {
   public static ItemGroup[] GROUPS = new ItemGroup[5];
   public static final ItemGroup MOD_ITEM_GROUP = new ModTabGroup("simpleores", () -> new ItemStack(com.babcsany.minecraft.ervin_mod_1.init.item.item.ItemInit.REGDEMP.get()));
   public static final net.minecraft.item.ItemGroup ERVIN_MOD_1_SEARCH = (new net.minecraft.item.ItemGroup(14, "ervin_mod_1_search") {
      @OnlyIn(Dist.CLIENT)
      public ItemStack createIcon() {
         return new ItemStack(isBurnableItemInit.SRIFROUL.get());
      }
   }).setBackgroundImageName("item_search.png");
   public static final net.minecraft.item.ItemGroup SEARCH = (new net.minecraft.item.ItemGroup(15, "search1") {
      @OnlyIn(Dist.CLIENT)
      public ItemStack createIcon() {
         return new ItemStack(isBurnableItemInit.SRIFROUL.get());
      }
   }).setBackgroundImageName("item_search.png");
   public static final net.minecraft.item.ItemGroup ERVIN_MOD_1 = (new net.minecraft.item.ItemGroup(12, "ervin_mod_1") {
      @OnlyIn(Dist.CLIENT)
      public ItemStack createIcon() {
         return new ItemStack(isBurnableItemInit.SRIFROUL.get());
      }
   }).setTabPath("ervin_mod_1_blocks");
   public static final net.minecraft.item.ItemGroup ERVIN_MOD_1_ITEMS = (new net.minecraft.item.ItemGroup(13, "ervin_mod_1_items") {
      @OnlyIn(Dist.CLIENT)
      public ItemStack createIcon() {
         return new ItemStack(ItemInit.FIRT.get());
      }
   }).setTabPath("ervin_mod_1_items");
   public static final net.minecraft.item.ItemGroup BREFK = new net.minecraft.item.ItemGroup(16, "brefk") {
      @OnlyIn(Dist.CLIENT)
      public ItemStack createIcon() {
         return new ItemStack(BrefkStageItemInit.BREFK_STAGE255.get());
      }
   };
   public static final net.minecraft.item.ItemGroup ERVIN_MOD_1_SPAWN_EGGS = new net.minecraft.item.ItemGroup(17, "ervin_mod_1_spawn_eggs") {
      @OnlyIn(Dist.CLIENT)
      public ItemStack createIcon() {
         return new ItemStack(ModSpawnEggItemInit.SPAWN_EGG_1.get());
      }
   };
   /*public static final net.minecraft.item.ItemGroup REDSTONE = new net.minecraft.item.ItemGroup(2, "redstone") {
      @OnlyIn(Dist.CLIENT)
      public ItemStack createIcon() {
         return new ItemStack(Items.REDSTONE);
      }
   };*/
   private final int index;
   private final String tabLabel;
   private String tabPath;
   private String backgroundTexture = "items.png";
   private boolean hasScrollbar = true;
   private boolean drawTitle = true;
   private EnchantmentType[] enchantmentTypes = new EnchantmentType[0];
   private ItemStack icon;

   public ItemGroup(String label) {
      this(-1, label);
   }

   public ItemGroup(int index, String label) {
      //super(index, label);
      this.tabLabel = label;
      this.icon = ItemStack.EMPTY;
      this.index = addGroupSafe(index, this);
   }

   @OnlyIn(Dist.CLIENT)
   public int getIndex() {
      return this.index;
   }

   @OnlyIn(Dist.CLIENT)
   public String getTabLabel() {
      return this.tabLabel;
   }

   /**
    * Gets the name that's valid for use in a ResourceLocation's path. This should be set if the tabLabel contains
    * illegal characters.
    */
   public String getPath() {
      return this.tabPath == null ? this.tabLabel : this.tabPath;
   }

   /**
    * Gets the translated Label.
    */
   @OnlyIn(Dist.CLIENT)
   public String getTranslationKey() {
      return "itemGroup." + this.getTabLabel();
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getIcon() {
      if (this.icon.isEmpty()) {
         this.icon = this.createIcon();
      }

      return this.icon;
   }

   @OnlyIn(Dist.CLIENT)
   public abstract ItemStack createIcon();

   @OnlyIn(Dist.CLIENT)
   public String getBackgroundImageName() {
      return this.backgroundTexture;
   }

   public ItemGroup setBackgroundImageName(String texture) {
      this.backgroundTexture = texture;
      return this;
   }

   public ItemGroup setTabPath(String pathIn) {
      this.tabPath = pathIn;
      return this;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean drawInForegroundOfTab() {
      return this.drawTitle;
   }

   public ItemGroup setNoTitle() {
      this.drawTitle = false;
      return this;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean hasScrollbar() {
      return this.hasScrollbar;
   }

   public ItemGroup setNoScrollbar() {
      this.hasScrollbar = false;
      return this;
   }

   /**
    * returns index % 6
    */
   @OnlyIn(Dist.CLIENT)
   public int getColumn() {
      if (index > 11) return ((index - 12) % 10) % 5;
      return this.index % 6;
   }

   /**
    * returns tabIndex < 6
    */
   @OnlyIn(Dist.CLIENT)
   public boolean isOnTopRow() {
      if (index > 11) return ((index - 12) % 10) < 5;
      return this.index < 6;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isAlignedRight() {
      return this.getColumn() == 5;
   }

   /**
    * Returns the enchantment types relevant to this tab
    */
   public EnchantmentType[] getRelevantEnchantmentTypes() {
      return this.enchantmentTypes;
   }

   /**
    * Sets the enchantment types for populating this tab with enchanting books
    */
   public ItemGroup setRelevantEnchantmentTypes(EnchantmentType... types) {
      this.enchantmentTypes = types;
      return this;
   }

   public boolean hasRelevantEnchantmentType(@Nullable EnchantmentType enchantmentType) {
      if (enchantmentType != null) {
         for(EnchantmentType enchantmenttype : this.enchantmentTypes) {
            if (enchantmenttype == enchantmentType) {
               return true;
            }
         }
      }

      return false;
   }

   /**
    * Fills {@code items} with all items that are in this group.
    */
   /*@OnlyIn(Dist.CLIENT)
   public void fill(NonNullList<ItemStack> items) {
      for(Item item : Registry.ITEM) {
         item.fillItemGroup(this, items);
      }

   }*/

   public int getTabPage() {
      return index < 13 ? 0 : ((index - 13) / 10) + 1;
   }

   public boolean hasSearchBar() {
      return index == ERVIN_MOD_1.index;
   }

   /**
    * Gets the width of the search bar of the creative tab, use this if your
    * creative tab name overflows together with a custom texture.
    *
    * @return The width of the search bar, 89 by default
    */
   public int getSearchbarWidth() {
      return 189;
   }

   @OnlyIn(Dist.CLIENT)
   public net.minecraft.util.ResourceLocation getBackgroundImage() {
      return new net.minecraft.util.ResourceLocation("textures/gui/container/creative_inventory/tab_" + this.getBackgroundImageName());
   }

   private static final net.minecraft.util.ResourceLocation CREATIVE_INVENTORY_TABS = new net.minecraft.util.ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
   @OnlyIn(Dist.CLIENT)
   public net.minecraft.util.ResourceLocation getTabsImage() {
      return CREATIVE_INVENTORY_TABS;
   }

   public int getLabelColor() {
      return 228655;
   }

   public int getSlotColor() {
      return -2130706433;
   }

   public static synchronized int getGroupCountSafe() {
      return ItemGroup.GROUPS.length;
   }

   private static synchronized int addGroupSafe(int index, ItemGroup newGroup) {
      if(index == -1) {
         index = GROUPS.length;
      }
      if (index >= GROUPS.length) {
         ItemGroup[] tmp = new ItemGroup[index + 1];
         System.arraycopy(GROUPS, 0, tmp, 0, GROUPS.length);
         GROUPS = tmp;
      }
      GROUPS[index] = newGroup;
      return index;
   }

   public static final class ModTabGroup extends ItemGroup {
      @Nonnull
      private final Supplier<ItemStack> iconSupplier;

      public ModTabGroup(@Nonnull String name, @Nonnull Supplier<ItemStack> iconSupplier) {
         super(name);
         this.iconSupplier = iconSupplier;
      }

      @Nonnull
      public ItemStack createIcon() {
         return this.iconSupplier.get();
      }
   }
}