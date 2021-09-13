package com.babcsany.minecraft.init.lc.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.init.lc.block.blocks.H_u_fBlockInit;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;

public class LcBlockItemInit {

    public static Items LC_BLOCK_ITEMS;

    public static final Item FI_RT_PLOCK = register(H_u_fBlockInit.H_U_F_BLOCK);

    private static Item register(Block blockIn) {
        return register(new BlockItem(blockIn, new Item.Properties()));
    }

    private static Item register(String key, Item itemIn) {
        return Ervin_mod_1.itemRegister(new ResourceLocation(string(key)), itemIn);
    }

    private static Item register(Block blockIn, ItemGroup itemGroupIn) {
        return register(new BlockItem(blockIn, (new Item.Properties()).group(itemGroupIn)));
    }

    private static Item register(BlockItem blockItemIn) {
        return register(blockItemIn.getBlock(), blockItemIn);
    }

    protected static Item register(Block blockIn, Item itemIn) {
        return register(Registry.BLOCK.getKey(blockIn), itemIn);
    }

    private static Item register(ResourceLocation key, Item itemIn) {
        if (itemIn instanceof BlockItem) {
            ((BlockItem)itemIn).addToBlockToItemMap(Item.BLOCK_TO_ITEM, itemIn);
        }

        return Registry.register(Registry.ITEM, key, itemIn);
    }

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    public IEventBus register(IEventBus modEventBus) {
        return modEventBus;
    }
}
