package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class UnusedBlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEM_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);
    private static final ArrayList<RegistryObject<BlockItem>> UNUSED_BLOCK_ITEMS = new ArrayList<>();
    private static RegistryObject<BlockItem> LAST_BLOCK_ITEM;
    private static final ArrayList<String> UNUSED_BLOCK_ITEMS_PATHS = new ArrayList<>();

    public static void setUnusedBlockItems() {
        setBlockItemFrom("air", new BlockItem(UnusedBlockInit.getBlock("air"), new Item.Properties()));
        setBlockItemFrom("tgruhuft", new BlockItem(UnusedBlockInit.getBlock("tgruhuft"), new Item.Properties()));
    }

    public static <T extends BlockItem> RegistryObject<BlockItem> getBlockItem(String name, T blockItem) {
        final RegistryObject<BlockItem> lastBlockItem = BLOCK_ITEM_DEFERRED_REGISTER.register(path(name), () -> blockItem);
        LAST_BLOCK_ITEM = lastBlockItem;
        UNUSED_BLOCK_ITEMS.add(lastBlockItem);
        UNUSED_BLOCK_ITEMS_PATHS.add(lastBlockItem.getId().getPath());
        return lastBlockItem;
    }

    public static <T extends BlockItem> void setBlockItemFrom(String name, T blockItem) {
        getBlockItem(name, blockItem);
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    public static BlockItem getBlockItem(String name) {
        return get(name).get();
    }

    public static RegistryObject<BlockItem> get(String name) {
        int index = UNUSED_BLOCK_ITEMS_PATHS.indexOf(path(name));
        return get(index);
    }

    public static RegistryObject<BlockItem> get(int index) {
        return UNUSED_BLOCK_ITEMS.get(index);
    }

    public static BlockItem getLastBlockItem() {
        return LAST_BLOCK_ITEM.get();
    }
}
