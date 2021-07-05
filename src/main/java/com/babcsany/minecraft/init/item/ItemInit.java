package com.babcsany.minecraft.init.item;

import com.babcsany.minecraft.entity.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.init.DyeColorInit;
import com.babcsany.minecraft.ervin_mod_1.init.init.DyeItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.book.paper.*;
import com.babcsany.minecraft.init.FluidInit;
import com.babcsany.minecraft.item.BucketItem;
import com.babcsany.minecraft.item.JurkBucketItem;
import com.babcsany.minecraft.item.ModBoatItem;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.item.Items.BUCKET;

public class ItemInit {

    public static ItemInit ITEMS;

    public static final Item JURK_BUCKET = register("ervin_mod_1:jurk_bucket", new JurkBucketItem(FluidInit.JURK, (new Item.Properties()).containerItem(BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item FIRG_BOAT = register("ervin_mod_1:firg_boat", new ModBoatItem(ModBoatEntity.Type.FIRG_PLANKS, (new Item.Properties()).maxStackSize(1).group(ItemGroup.TRANSPORTATION)));
    public static final Item ENCHANTED_BOOK_BLACK = register("ervin_mod_1:book/enchanted/paper/black", new EnchantedBookItemBlack((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_BLUE = register("ervin_mod_1:book/enchanted/paper/blue", new EnchantedBookItemBlue((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_BROWN = register("ervin_mod_1:book/enchanted/paper/brown", new EnchantedBookItemBrown((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_CYAN = register("ervin_mod_1:book/enchanted/paper/cyan", new EnchantedBookItemCyan((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_GRAY = register("ervin_mod_1:book/enchanted/paper/gray", new EnchantedBookItemGray((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_GREEN = register("ervin_mod_1:book/enchanted/paper/green", new EnchantedBookItemGreen((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_BLUE1 = register("ervin_mod_1:book/enchanted/paper/light_blue1", new EnchantedBookItemLightBlue1((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_BLUE = register("ervin_mod_1:book/enchanted/paper/light_blue", new EnchantedBookItemLightBlue((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_GRAY = register("ervin_mod_1:book/enchanted/paper/light_gray", new EnchantedBookItemLightGray((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIME = register("ervin_mod_1:book/enchanted/paper/lime", new EnchantedBookItemLime((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_MAGENTA = register("ervin_mod_1:book/enchanted/paper/magenta", new EnchantedBookItemMagenta((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_ORANGE = register("ervin_mod_1:book/enchanted/paper/orange", new EnchantedBookItemOrange((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_PINK = register("ervin_mod_1:book/enchanted/paper/pink", new EnchantedBookItemPink((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_PURPLE = register("ervin_mod_1:book/enchanted/paper/purple", new EnchantedBookItemPurple((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_RED = register("ervin_mod_1:book/enchanted/paper/red", new EnchantedBookItemRed((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_YELLOW = register("ervin_mod_1:book/enchanted/paper/yellow", new EnchantedBookItemYellow((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item WRITABLE_BOOK_BLACK = register("ervin_mod_1:book/writable/paper/black", new WritableBookItem((new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item WRITTEN_BOOK_BLACK = register("ervin_mod_1:book/written/paper/black", new WrittenBookItem((new Item.Properties()).maxStackSize(16)));
    public static final Item LIGHT_BLUE1_DYEM = register("ervin_mod_1:light_blue1_dyel", new DyeItemInit(DyeColorInit.LIGHT_BLUE, (new Item.Properties()).group(net.minecraft.item.ItemGroup.MATERIALS)));

    private static Item register(String key, Item itemIn) {
        return Ervin_mod_1.itemRegister(new ResourceLocation(key), itemIn);
    }
}
