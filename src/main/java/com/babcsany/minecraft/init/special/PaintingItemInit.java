package com.babcsany.minecraft.init.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;

public class PaintingItemInit {

    public static Items PAINTING_ITEMS;

    public static final Item modPainting = register("modPainting", new HangingEntityItem(PaintingEntityInit.modPainting, (new Item.Properties()).group(ItemGroup.DECORATIONS)));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

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

    public IEventBus register(IEventBus modEventBus) {
        return modEventBus;
    }
}
