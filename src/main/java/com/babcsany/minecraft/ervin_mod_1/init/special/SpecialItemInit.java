package com.babcsany.minecraft.ervin_mod_1.init.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> GTRZIUZHIZJKJ = SPECIAL_ITEMS.register(string("gtrziuzhizjkj"), () -> new BlockItem(SpecialBlockInit.GTRZIUZHIZJKJ.get(), (new Item.Properties().group(ItemGroup.ERVIN_MOD_1))));
    public static final RegistryObject<Item> TFJHU_1 = SPECIAL_ITEMS.register(string("tfjhu/tfjhu_1"), () -> new BlockItem(SpecialBlockInit.TFJHU_1.get(), (new Item.Properties().group(ItemGroup.ERVIN_MOD_1))));

    private static String string(String name) {
        String string = "special/";
        return string + name;
    }
}
