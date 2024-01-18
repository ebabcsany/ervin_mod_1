package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);
    public static BlockItemInit BLOCK_ITEMS;

    public static final RegistryObject<Item> JURKF = ITEMS.register("jurkf", () -> new BlockItem(com.babcsany.minecraft.init.BlockInit.FIRT_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> FIRG_PLANKS = ITEMS.register("firg_planks", () -> new BlockItem(BlockInit.FIRG_PLANKS.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> FIRG_PLANKS_STAIRS = ITEMS.register("firg_planks_stairs", () -> new BlockItem(BlockInit.FIRG_PLANKS_STAIRS.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> FIRG_PLANKS_DOOR = ITEMS.register("firg_planks_door", () -> new BlockItem(BlockInit.FIRG_PLANKS_DOOR.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> FIRT_BLOCK = ITEMS.register("firt_block", () -> new BurningBlockItem(BlockInit.FIRT_BLOCK.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS), 21600));
    public static final RegistryObject<Item> TRIRIJ = ITEMS.register("tririj", () -> new BlockItem(com.babcsany.minecraft.init.BlockInit.TRIRIJ.get(), (new Item.Properties()).isBurnable().group(ItemGroup.MATERIALS)));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static Item register(String key, Item itemIn) {
        return Ervin_mod_1.itemRegister(new ResourceLocation(string(key)), itemIn);
    }
}
