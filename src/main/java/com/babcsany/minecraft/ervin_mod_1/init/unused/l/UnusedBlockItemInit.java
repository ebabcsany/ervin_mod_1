package com.babcsany.minecraft.ervin_mod_1.init.unused.l;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UnusedBlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEM_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> AIR = BLOCK_ITEM_DEFERRED_REGISTER.register(path("air"), () -> new BlockItem(UnusedBlockInit.AIR.get(), new Item.Properties()));
    public static final RegistryObject<Item> TGRUHUFT = BLOCK_ITEM_DEFERRED_REGISTER.register(path("tgruhuft"), () -> new BlockItem(UnusedBlockInit.TGRUHUFT.get(), new Item.Properties()));

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }
}
