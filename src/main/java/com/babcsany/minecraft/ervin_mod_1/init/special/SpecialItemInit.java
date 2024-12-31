package com.babcsany.minecraft.ervin_mod_1.init.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<BlockItem> GTRZIUZHIZJKJ = SPECIAL_ITEMS.register("gtrziuzhizjkj", () -> new BlockItem(SpecialBlockInit.GTRZIUZHIZJKJ.get(), (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1))));
    public static final RegistryObject<BlockItem> TFJHU_1 = SPECIAL_ITEMS.register("tfjhu/tfjhu_1", () -> new BlockItem(SpecialBlockInit.TFJHU_1.get(), (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1))));

    public static BlockItem register(String name, BlockItem item) {
        return new Cast<BlockItem>().cast(UnusedItems.registerDefault(string(name), item));
    }

    private static String string(String name) {
        String string = "special/";
        return string + name;
    }
}
