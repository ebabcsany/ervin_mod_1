package com.babcsany.minecraft.init.item.icsvre;

import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.item.icsvre.BlockIcsvre;
import com.babcsany.minecraft.item.icsvre.EnchantedBookIcsvre;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;

import static net.minecraft.item.Items.BUCKET;

public class IcsvreInit {

    public static Items ICSVRE;

    static Icsvre icsvre;

    public static final Item ENCHANTED_BOOK = register("enchanted_book", new EnchantedBookIcsvre((new Icsvre.Properties()), (new Item.Properties()).containerItem(BUCKET).maxStackSize(1).rarity(Rarity.UNCOMMON)));
    public static final Item STAPHO = register("stapho", new Icsvre((new Icsvre.Properties()), (new Item.Properties()).group(ItemGroup.MISC)));

    private static Icsvre register(String key, Icsvre icsvreIn) {
        return register(new ResourceLocation(string(key)), icsvreIn);
    }

    public static String string(String name) {
        String string = "ervin_mod_1:icsvre/";
        return string + name;
    }

    private static Icsvre register(ResourceLocation key, Icsvre icsvreIn) {
        if (icsvreIn instanceof BlockIcsvre) {
            ((BlockIcsvre)icsvreIn).addToBlockToIcsvreMap(Icsvre.BLOCK_TO_ICSVRE, icsvreIn);
        }

        return icsvre(Registry.register(Registry.ITEM, key, icsvreIn.getItem()));
    }

    private static Icsvre icsvre(Item item) {
        return icsvre;
    }

    public IEventBus register(IEventBus modEventBus) {
        return modEventBus;
    }
}
