package com.babcsany.minecraft.ervin_mod_1.init.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final BlockItem GTRZIUZHIZJKJ = register("gtrziuzhizjkj", new BlockItem(SpecialBlockInit.GTRZIUZHIZJKJ, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1))));
    public static final BlockItem TFJHU_1 = register("tfjhu/tfjhu_1", new BlockItem(SpecialBlockInit.TFJHU_1, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1))));

    public static BlockItem register(String name, BlockItem item) {
        return UnusedBlockItems.registerDefault(string(name), item);
    }

    private static String string(String name) {
        String string = "special/";
        return string + name;
    }
}
