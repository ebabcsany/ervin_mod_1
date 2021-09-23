package com.babcsany.minecraft.init.lc.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.init.lc.block.blocks.H_u_fBlockInit;
import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.block.Block;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class LcBlockItemInit {

    public static Items LC_BLOCK_ITEMS;

    public static final Item FI_RT_PLOCK = register("fi°rt_plock", new BlockNamedItem(H_u_fBlockInit.H_U_F_BLOCK, (new Item.Properties()).group(ItemGroup.ERVIN_MOD_1_SEARCH)));

    private static Item register(Block blockIn) {
        return register(new ModBlockItem(blockIn, new Item.Properties()));
    }

    private static Item register(String key, Item itemIn) {
        return Ervin_mod_1.itemRegister(new ResourceLocation(string(key)), itemIn);
    }

    private static Item register(Block blockIn, net.minecraft.item.ItemGroup itemGroupIn) {
        return register(new ModBlockItem(blockIn, (new Item.Properties()).group(itemGroupIn)));
    }

    private static Item register(ModBlockItem blockItemIn) {
        return register(blockItemIn.getBlock(), blockItemIn);
    }

    protected static Item register(Block blockIn, Item itemIn) {
        return register(Registry.BLOCK.getKey(blockIn), itemIn);
    }

    private static Item register(ResourceLocation key, Item itemIn) {
        if (itemIn instanceof ModBlockItem) {
            ((ModBlockItem)itemIn).addToBlockToItemMap(Item.BLOCK_TO_ITEM, itemIn);
        }

        return Registry.register(Registry.ITEM, key, itemIn);
    }

    private static String string(String name) {
        String string = "ervin_mod_1:lc/block/blocks/";
        return string + name;
    }
}
