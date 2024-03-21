package com.babcsany.minecraft.ervin_mod_1.init.block.item;

import com.babcsany.minecraft.ervin_mod_1.init.block.registerBlockInit;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

import static com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.BURNABLE_ITEMS;

public class isBurnableBurningBlockItemInit_ {

    public static isBurnableBurningBlockItemInit_ BURNING_BLOCK_ITEMS;

    public static final RegistryObject<Item> TRAGN = register("tragn", registerBlockInit.TRAGN, (int) 15305500800000000L);
    public static final RegistryObject<Item> TRAGK_BLOCK = register("tragk_block", registerBlockInit.TRAGK_BLOCK, (int) 24488801280000L);
    public static final RegistryObject<Item> TRAGK_SLAB = register("tragk_slab", registerBlockInit.TRAGK_SLAB, (int) 12244400640000L);
    public static final RegistryObject<Item> TRAGK_STAIRS = register("tragk_stairs", registerBlockInit.TRAGK_STAIRS, (int) 18366600960000L);
    public static final RegistryObject<Item> GARK_BLOCK = register("gark_block", registerBlockInit.GARK_BLOCK, 131220000);
    public static final RegistryObject<Item> GARK_SLAB = register("gark_slab", registerBlockInit.GARK_SLAB, 65610000);
    public static final RegistryObject<Item> GARK_STAIRS = register("gark_stairs", registerBlockInit.GARK_STAIRS, 98415000);

    public static RegistryObject<Item> register(String name, Supplier<Block> blockSupplier, int burnTime) {
        return BURNABLE_ITEMS.register(name, () -> new BlockItem(blockSupplier.get(), (new Item.Properties().isImmuneToFire())) {
            @Override
            public int getBurnTime(ItemStack itemStack) {
                return burnTime;
            }
        });
    }
}
