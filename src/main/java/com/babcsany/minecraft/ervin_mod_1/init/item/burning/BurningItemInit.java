package com.babcsany.minecraft.ervin_mod_1.init.item.burning;

import com.babcsany.minecraft.ervin_mod_1.item.BurningItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import static com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.BURNABLE_ITEMS;

public class BurningItemInit {

    public static BurningItemInit BURNING_ITEMS;

    public static final RegistryObject<Item> GART = BURNABLE_ITEMS.register("gart", () -> new BurningItem((new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH), 180000));
    public static final RegistryObject<Item> GARB = BURNABLE_ITEMS.register("garb", () -> new BurningItem((new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH), 1620000));
    public static final RegistryObject<Item> GARK = BURNABLE_ITEMS.register("gark", () -> new BurningItem((new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH), 14580000));
    public static final RegistryObject<Item> GARKT = BURNABLE_ITEMS.register("garkt", () -> new BurningItem((new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH), 1180980000));
    public static final RegistryObject<Item> GARKTH = BURNABLE_ITEMS.register("garkth", () -> new BurningItem((new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH), (int) 18895680000L));
    public static final RegistryObject<Item> TRAGH = BURNABLE_ITEMS.register("tragh", () -> new BurningItem((new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH), (int) 170061120000L));
    public static final RegistryObject<Item> TRAGK = BURNABLE_ITEMS.register("tragk", () -> new BurningItem((new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH), (int) 1530550080000L));
}
