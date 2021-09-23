package com.babcsany.minecraft.init;

import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class BlockItemInit {

    public static Items BLOCK_ITEMS;

    public static final Item JURKF = namedRegister("jurkf", com.babcsany.minecraft.init.BlockInit.FIRT_BLOCK);
    public static final Item FIRG_PLANKS = register("firg_planks", BlockInit.FIRG_PLANKS, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRG_LOG = register(BlockInit.FIRG_LOG, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRG_WOOD = register(BlockInit.FIRG_WOOD, ItemGroup.BUILDING_BLOCKS);
    public static final Item STRIPPED_FIRG_LOG = register(BlockInit.STRIPPED_FIRG_LOG, ItemGroup.BUILDING_BLOCKS);
    public static final Item STRIPPED_FIRG_WOOD = register(BlockInit.STRIPPED_FIRG_WOOD, ItemGroup.BUILDING_BLOCKS);
    public static final Item FRIM_LOG = register(BlockInit.FRIM_LOG, ItemGroup.BUILDING_BLOCKS);
    public static final Item FRIM_WOOD = register(BlockInit.FRIM_WOOD, ItemGroup.BUILDING_BLOCKS);
    public static final Item STRIPPED_FRIM_LOG = register(BlockInit.STRIPPED_FRIM_LOG, ItemGroup.BUILDING_BLOCKS);
    public static final Item STRIPPED_FRIM_WOOD = register(BlockInit.STRIPPED_FRIM_WOOD, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRG_PLANKS_STAIRS = register(BlockInit.FIRG_PLANKS_STAIRS, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRG_PLANKS_DOOR = register(BlockInit.FIRG_PLANKS_DOOR, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRT_BLOCK = registerBurningModBlockItem(BlockInit.FIRT_BLOCK, ItemGroup.BUILDING_BLOCKS, 21600);
    public static final Item TRIRIJ = registerBurnable(BlockInit.TRIRIJ, ItemGroup.BUILDING_BLOCKS);
    public static final Item EXAMPLE_PORTAL_BLOCK = registerBurnable(BlockInit.EXAMPLE_PORTAL_BLOCK);

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static Item register(Block blockIn) {
        return register(new ModBlockItem(blockIn, new Item.Properties()));
    }

    private static Item registerBurnable(Block blockIn) {
        return register(new ModBlockItem(blockIn, new Item.Properties().isBurnable()));
    }

    private static Item register(Block blockIn, ItemGroup itemGroupIn) {
        return register(new ModBlockItem(blockIn, (new Item.Properties()).group(itemGroupIn)));
    }

    private static Item registerBurningModBlockItem(Block blockIn, ItemGroup itemGroupIn, int burnTimeIn) {
        return register(new ModBlockItem(blockIn, (new Item.Properties()).group(itemGroupIn)) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static Item registerBurningModBlockItem(Block blockIn, int burnTimeIn) {
        return register(new ModBlockItem(blockIn, (new Item.Properties())) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static Item registerBurnable(Block blockIn, ItemGroup itemGroupIn) {
        return register(new ModBlockItem(blockIn, (new Item.Properties()).isBurnable().group(itemGroupIn)));
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

    private static Item register(String key, Item itemIn) {
        return register(new ResourceLocation(string(key)), itemIn);
    }

    private static Item registerBurningBlockItem(String key, Block blockIn, int burnTimeIn) {
        return register(new ResourceLocation(string(key)), new BlockItem(blockIn, new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static Item registerBurningModBlockItem(String key, Block blockIn, int burnTimeIn) {
        return register(new ResourceLocation(string(key)), new ModBlockItem(blockIn, new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static Item registerBurningModBlockItem(String key, Block blockIn, ItemGroup groupIn, int burnTimeIn) {
        return register(new ResourceLocation(string(key)), new ModBlockItem(blockIn, new Item.Properties().group(groupIn)) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static Item register(String key, Block blockIn, ItemGroup groupIn) {
        return register(new ResourceLocation(string(key)), new ModBlockItem(blockIn, new Item.Properties().group(groupIn)));
    }

    private static Item namedRegister(String key, Block blockIn) {
        return register(new ResourceLocation(string(key)), new BlockNamedItem(blockIn, new Item.Properties()));
    }

    private static Item namedRegister(String key, Block blockIn, ItemGroup groupIn) {
        return register(new ResourceLocation(string(key)), new BlockNamedItem(blockIn, new Item.Properties().group(groupIn)));
    }

    private static Item namedRegisterBurnable(String key, Block blockIn) {
        return register(new ResourceLocation(string(key)), new BlockNamedItem(blockIn, new Item.Properties().isBurnable()));
    }

    private static Item registerBurnable(String key, Block blockIn) {
        return register(new ResourceLocation(string(key)), new ModBlockItem(blockIn, new Item.Properties().isBurnable()));
    }

    private static Item registerBurnable(String key, Block blockIn, ItemGroup groupIn) {
        return register(new ResourceLocation(string(key)), new ModBlockItem(blockIn, new Item.Properties().isBurnable().group(groupIn)));
    }
}
