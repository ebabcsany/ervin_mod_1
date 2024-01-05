package com.babcsany.minecraft.ervin_mod_1.init.block.item;

import com.babcsany.minecraft.ervin_mod_1.init.block.registerBlockInit;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

import static com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit.ITEMS;

public class BlockItem_Init {

    public static final RegistryObject<Item> JAZZ_SAPLING = register("jazz_sapling", registerBlockInit.JAZZ_SAPLING, 500);

    public static RegistryObject<Item> register(String name, Supplier<Block> blockSupplier, int burnTime) {
        return ITEMS.register(name, () -> new BlockItem(blockSupplier.get(), (new Item.Properties())) {
            @Override
            public int getBurnTime(ItemStack itemStack) {
                return burnTime;
            }
        });
    }
}
