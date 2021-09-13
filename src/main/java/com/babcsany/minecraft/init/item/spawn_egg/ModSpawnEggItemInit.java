package com.babcsany.minecraft.init.item.spawn_egg;

import com.babcsany.minecraft.ervin_mod_1.item.SpawnEggItem1;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModSpawnEggItemInit {

    public static Items SPAWN_EGGS;

    public static final Item SPAWN_EGG_1 = register("spawn_eggs/spawn_egg_1", new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final Item GUBROV_SPAWN_EGG = register("spawn_eggs/gubrov_spawn_egg", new SpawnEggItem1(com.babcsany.minecraft.init.EntityInit.GUBROV, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final Item SRACH_SPAWN_EGG = register("spawn_eggs/srach_spawn_egg", new SpawnEggItem1(com.babcsany.minecraft.init.EntityInit.SRACH_ENTITY, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final Item ZUR_SPAWN_EGG = register("spawn_eggs/zur_spawn_egg", new SpawnEggItem1(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final Item ROVENT_SPAWN_EGG = register("spawn_eggs/rovent_spawn_egg", new SpawnEggItem1(com.babcsany.minecraft.init.EntityInit.ROVENT_ENTITY, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static Item register(Block blockIn) {
        return register(new BlockItem(blockIn, new Item.Properties()));
    }

    private static Item register(String key, Item itemIn) {
        return register(new ResourceLocation(string(key)), itemIn);
    }

    private static Item register(Block blockIn, net.minecraft.item.ItemGroup itemGroupIn) {
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
