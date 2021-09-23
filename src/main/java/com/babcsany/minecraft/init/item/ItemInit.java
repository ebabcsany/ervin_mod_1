package com.babcsany.minecraft.init.item;

import com.babcsany.minecraft.ervin_mod_1.item.JurkBucketItem;
import com.babcsany.minecraft.ervin_mod_1.item.book.paper.*;
import com.babcsany.minecraft.init.BlockInit;
import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.block.Block;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import static net.minecraft.item.Items.BUCKET;

public class ItemInit {

    public static Items ITEMS;

    public static final Item JURK_BUCKET = register("jurk_bucket", new JurkBucketItem((new Item.Properties()).containerItem(BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
    //public static final Item JURK_BUCKET = register("jurk_bucket", new JurkBucketItem((new Item.Properties()).containerItem(BUCKET).maxStackSize(1).group(net.minecraft.item.ItemGroup.MISC)));
    public static final Item FIRG_BOAT = register("firg_boat", new BoatItem(BoatEntity.Type.OAK, (new Item.Properties()).maxStackSize(1).group(ItemGroup.TRANSPORTATION)));
    public static final Item ENCHANTED_BOOK_BLACK = register("book/enchanted/paper/black", new EnchantedBookItemBlack((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_BLUE = register("book/enchanted/paper/blue", new EnchantedBookItemBlue((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_BROWN = register("book/enchanted/paper/brown", new EnchantedBookItemBrown((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_CYAN = register("book/enchanted/paper/cyan", new EnchantedBookItemCyan((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_GRAY = register("book/enchanted/paper/gray", new EnchantedBookItemGray((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_GREEN = register("book/enchanted/paper/green", new EnchantedBookItemGreen((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_BLUE1 = register("book/enchanted/paper/light_blue1", new EnchantedBookItemLightBlue1((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_BLUE = register("book/enchanted/paper/light_blue", new EnchantedBookItemLightBlue((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIGHT_GRAY = register("book/enchanted/paper/light_gray", new EnchantedBookItemLightGray((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_LIME = register("book/enchanted/paper/lime", new EnchantedBookItemLime((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_MAGENTA = register("book/enchanted/paper/magenta", new EnchantedBookItemMagenta((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_ORANGE = register("book/enchanted/paper/orange", new EnchantedBookItemOrange((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_PINK = register("book/enchanted/paper/pink", new EnchantedBookItemPink((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_PURPLE = register("book/enchanted/paper/purple", new EnchantedBookItemPurple((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_RED = register("book/enchanted/paper/red", new EnchantedBookItemRed((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item ENCHANTED_BOOK_YELLOW = register("book/enchanted/paper/yellow", new EnchantedBookItemYellow((new Item.Properties()).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item WRITABLE_BOOK_BLACK = register("book/writable/paper/black", new WritableBookItem((new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item WRITTEN_BOOK_BLACK = register("book/written/paper/black", new WrittenBookItem((new Item.Properties()).maxStackSize(16)));
    public static final Item REUTRIEN = register(BlockInit.REUTRIEN);
    public static final Item FRISZERN = register(BlockInit.FRISZERN);
    public static final Item CHAIN_FRISZERN = register(BlockInit.CHAIN_FRISZERN);
    public static final Item REPEATING_FRISZERN = register(BlockInit.REPEATING_FRISZERN);

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static String modId(String modId, String string) {
        return modId + ':' + string;
    }

    private static String mod_1(String name) {
        return "mod_1:" + name;
    }

    private static Item register(Block blockIn) {
        return register(new ModBlockItem(blockIn, new Item.Properties()));
    }

    private static Item registerItem(String key, int burnTimeIn) {
        return register(new ResourceLocation(string(key)), new Item(new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static Item registerItem(String key, ItemGroup groupIn, int burnTimeIn) {
        return register(new ResourceLocation(string(key)), new Item(new Item.Properties().group(groupIn)) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static Item register(String key, Item itemIn) {
        return register(new ResourceLocation(string(key)), itemIn);
    }

    private static Item register(Block blockIn, ItemGroup itemGroupIn) {
        return register(new ModBlockItem(blockIn, (new Item.Properties()).group(itemGroupIn)));
    }

    private static Item register(ModBlockItem blockItemIn) {
        return register(blockItemIn.getBlock(), blockItemIn);
    }

    protected static Item register(Block blockIn, Item itemIn) {
        return register(Registry.BLOCK.getKey(blockIn), itemIn);
    }

    private static Item register(ResourceLocation key, Item itemIn) {
        if (itemIn instanceof ModBlockItem) {
            ((ModBlockItem)itemIn).addToBlockToItemMap(Item.BLOCK_TO_ITEM, itemIn);
        }

        return Registry.register(Registry.ITEM, key, itemIn);
    }
}
