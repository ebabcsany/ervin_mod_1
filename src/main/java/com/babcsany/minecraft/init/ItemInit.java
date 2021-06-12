package com.babcsany.minecraft.init;

import com.babcsany.minecraft.entity.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.book.paper.*;
import com.babcsany.minecraft.item.BucketItem;
import com.babcsany.minecraft.item.ModBoatItem;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.Items.BUCKET;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item JURK_BUCKET = register("ervin_mod_1:jurk_bucket", new BucketItem(Fluids.EMPTY, (new Item.Properties()).containerItem(BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item FIRG_BOAT = register("ervin_mod_1:firg_boat", new ModBoatItem(ModBoatEntity.Type.FIRG_PLANKS, (new Item.Properties()).maxStackSize(1).group(ItemGroup.TRANSPORTATION)));
    public static final Item ENCHANTED_BOOK_BLACK = register("ervin_mod_1:enchanted_book_black", new EnchantedBookItemBlack((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_BLUE = register("ervin_mod_1:enchanted_book_blue", new EnchantedBookItemBlue((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_BROWN = register("ervin_mod_1:enchanted_book_brown", new EnchantedBookItemBrown((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_CYAN = register("ervin_mod_1:enchanted_book_cyan", new EnchantedBookItemCyan((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_GRAY = register("ervin_mod_1:enchanted_book_gray", new EnchantedBookItemGray((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_GREEN = register("ervin_mod_1:enchanted_book_green", new EnchantedBookItemGreen((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_BLUE1 = register("ervin_mod_1:enchanted_book_light_blue1", new EnchantedBookItemLightBlue1((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_BLUE = register("ervin_mod_1:enchanted_book_light_blue", new EnchantedBookItemLightBlue((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_GRAY = register("ervin_mod_1:enchanted_book_light_gray", new EnchantedBookItemLightGray((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIME = register("ervin_mod_1:enchanted_book_lime", new EnchantedBookItemLime((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_MAGENTA = register("ervin_mod_1:enchanted_book_magenta", new EnchantedBookItemMagenta((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_ORANGE = register("ervin_mod_1:enchanted_book_orange", new EnchantedBookItemOrange((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_PINK = register("ervin_mod_1:enchanted_book_pink", new EnchantedBookItemPink((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_PURPLE = register("ervin_mod_1:enchanted_book_purple", new EnchantedBookItemPurple((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_RED = register("ervin_mod_1:enchanted_book_red", new EnchantedBookItemRed((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_YELLOW = register("ervin_mod_1:enchanted_book_yellow", new EnchantedBookItemYellow((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));

    private static Item register(String key, Item itemIn) {
        return Ervin_mod_1.itemRegister(new ResourceLocation(key), itemIn);
    }
}
