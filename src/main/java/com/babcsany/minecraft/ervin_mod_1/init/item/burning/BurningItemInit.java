package com.babcsany.minecraft.ervin_mod_1.init.item.burning;

import com.babcsany.minecraft.ervin_mod_1.item.burning.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import static com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.BURNABLE_ITEMS;

public class BurningItemInit {

    public static BurningItemInit BURNING_ITEMS;

    public static final RegistryObject<Item> GART = BURNABLE_ITEMS.register("gart", () -> new Gart((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GARB = BURNABLE_ITEMS.register("garb", () -> new Garb((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GARK = BURNABLE_ITEMS.register("gark", () -> new Gark((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GARKT = BURNABLE_ITEMS.register("garkt", () -> new Garkt((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GARKTH = BURNABLE_ITEMS.register("garkth", () -> new Garkth((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRAGH = BURNABLE_ITEMS.register("tragh", () -> new Tragh((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRAGK = BURNABLE_ITEMS.register("tragk", () -> new Tragk((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRAGT = BURNABLE_ITEMS.register("tragt", () -> new Tragt((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
}
