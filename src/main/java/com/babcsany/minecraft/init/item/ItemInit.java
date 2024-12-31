package com.babcsany.minecraft.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> REGISTER_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    //public static final Item JURK_BUCKET = register("jurk_bucket", new JurkBucketItem((new Item.Properties()).containerItem(BUCKET).maxStackSize(1).group(net.minecraft.item.ItemGroup.MISC)));
    public static final RegistryObject<Item> FIRG_BOAT = REGISTER_ITEMS.register("firg_boat", () -> new Item((new Item.Properties()).maxStackSize(1).group(ItemGroup.TRANSPORTATION)));
    public static final RegistryObject<Item> FRIM_BOAT = REGISTER_ITEMS.register("frim_boat", () -> new Item((new Item.Properties()).maxStackSize(1).group(ItemGroup.TRANSPORTATION)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_BLACK = REGISTER_ITEMS.register("book/enchanted/paper/black", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_BLUE = REGISTER_ITEMS.register("book/enchanted/paper/blue", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_BROWN = REGISTER_ITEMS.register("book/enchanted/paper/brown", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_CYAN = REGISTER_ITEMS.register("book/enchanted/paper/cyan", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_GRAY = REGISTER_ITEMS.register("book/enchanted/paper/gray", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_GREEN = REGISTER_ITEMS.register("book/enchanted/paper/green", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_LIGHT_BLUE1 = REGISTER_ITEMS.register("book/enchanted/paper/light_blue1", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_LIGHT_BLUE = REGISTER_ITEMS.register("book/enchanted/paper/light_blue", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_LIGHT_GRAY = REGISTER_ITEMS.register("book/enchanted/paper/light_gray", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_LIME = REGISTER_ITEMS.register("book/enchanted/paper/lime", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_MAGENTA = REGISTER_ITEMS.register("book/enchanted/paper/magenta", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_ORANGE = REGISTER_ITEMS.register("book/enchanted/paper/orange", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_PINK = REGISTER_ITEMS.register("book/enchanted/paper/pink", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_PURPLE = REGISTER_ITEMS.register("book/enchanted/paper/purple", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_RED = REGISTER_ITEMS.register("book/enchanted/paper/red", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_BOOK_YELLOW = REGISTER_ITEMS.register("book/enchanted/paper/yellow", () -> new Item((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> WRITABLE_BOOK_BLACK = REGISTER_ITEMS.register("book/writable/paper/black", () -> new WritableBookItem((new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> WRITTEN_BOOK_BLACK = REGISTER_ITEMS.register("book/written/paper/black", () -> new WrittenBookItem((new Item.Properties()).maxStackSize(16)));
    //public static final Item LIGHT_BLUE1_DYEM = register(string("light_blue1_dyel"), new DyeItemInit(DyeColorInit.LIGHT_BLUE1, (new Item.Properties()).group(net.minecraft.item.ItemGroup.MATERIALS)));
    //public static final Item LIGHT_BLUE1_DYEB = register(mod_1("light_blue1_dyeh"), new DyeItemInit(DyeColorInit.LIGHT_BLUE1, (new Item.Properties()).group(net.minecraft.item.ItemGroup.MATERIALS)));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static String modId(String string) {
        String modId = "mod_1:";
        return modId + string;
    }

    private static String string(String modId, String name) {
        return modId + ":" + name;
    }

    private static String mod_1(String name) {
        return "mod_1:" + name;
    }

    /*private static String name(String modId, String name) {
        return "ervin_mod_1/" + modId + ":" + name;
    }

    private static RegistryObject<Item> register(String key, Item itemIn) {
        String string = "ervin_mod_1:";
        return REGISTER_ITEMS.register(string + key, () -> itemIn);
    }*/
}
