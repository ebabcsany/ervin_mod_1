package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemInit_ {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> CHARCOAL_BLOCK = register(BlockInit.CHARCOAL_BLOCK, 16000);
    public static final RegistryObject<Item> CHARCOAL_SLAB = register(BlockInit.CHARCOAL_SLAB, 8000);
    public static final RegistryObject<Item> CHARCOAL_STAIRS = register(BlockInit.CHARCOAL_STAIRS, 12000);
    public static final RegistryObject<Item> ZUNK_SLAB = register(BlockInit.ZUNK_SLAB);
    public static final RegistryObject<Item> ZUNK_STAIRS = register(BlockInit.ZUNK_STAIRS);
    public static final RegistryObject<Item> FIGHIV = register(BlockInit.FIGHIV);
    public static final RegistryObject<Item> BLACK_STRING = register(BlockInit.BLACK_TRIPWIRE);
    public static final RegistryObject<Item> BLUE_STRING = register(BlockInit.BLUE_TRIPWIRE);
    public static final RegistryObject<Item> BROWN_STRING = register(BlockInit.BROWN_TRIPWIRE);
    public static final RegistryObject<Item> CYAN_STRING = register(BlockInit.CYAN_TRIPWIRE);
    public static final RegistryObject<Item> GRAY_STRING = register(BlockInit.GRAY_TRIPWIRE);
    public static final RegistryObject<Item> GREEN_STRING = register(BlockInit.GREEN_TRIPWIRE);
    public static final RegistryObject<Item> LIGHT_BLUE1_STRING = register(BlockInit.LIGHT_BLUE1_TRIPWIRE);
    public static final RegistryObject<Item> LIGHT_BLUE_STRING = register(BlockInit.LIGHT_BLUE_TRIPWIRE);
    public static final RegistryObject<Item> LIGHT_GRAY_STRING = register(BlockInit.LIGHT_GRAY_TRIPWIRE);
    public static final RegistryObject<Item> LIME_STRING = register(BlockInit.LIME_TRIPWIRE);
    public static final RegistryObject<Item> MAGENTA_STRING = register(BlockInit.MAGENTA_TRIPWIRE);
    public static final RegistryObject<Item> ORANGE_STRING = register(BlockInit.ORANGE_TRIPWIRE);
    public static final RegistryObject<Item> PINK_STRING = register(BlockInit.PINK_TRIPWIRE);
    public static final RegistryObject<Item> PURPLE_STRING = register(BlockInit.PURPLE_TRIPWIRE);
    public static final RegistryObject<Item> RED_STRING = register(BlockInit.RED_TRIPWIRE);
    public static final RegistryObject<Item> YELLOW_STRING = register(BlockInit.YELLOW_TRIPWIRE);

    private static RegistryObject<Item> register(String name, RegistryObject<Block> blockIn) {
        return BLOCK_ITEMS.register(name, () -> new ModBlockItem(blockIn.get(), new Item.Properties()));
    }

    private static RegistryObject<Item> register(String name, RegistryObject<Block> blockIn, int burnTimeIn) {
        return BLOCK_ITEMS.register(name, () -> new ModBlockItem(blockIn.get(), new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack itemStack) {
                return burnTimeIn;
            }
        });
    }

    private static RegistryObject<Item> register(String name, RegistryObject<Block> blockIn, ItemGroup group, int burnTimeIn) {
        return BLOCK_ITEMS.register(name, () -> new ModBlockItem(blockIn.get(), new Item.Properties().group(group)) {
            @Override
            public int getBurnTime(ItemStack itemStack) {
                return burnTimeIn;
            }
        });
    }

    private static RegistryObject<Item> register(RegistryObject<Block> blockIn, int burnTimeIn) {
        return BLOCK_ITEMS.register(blockIn.get().toString(), () -> new ModBlockItem(blockIn.get(), new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack itemStack) {
                return burnTimeIn;
            }
        });
    }

    private static RegistryObject<Item> register(String name, RegistryObject<Block> blockIn, net.minecraft.item.ItemGroup groupIn) {
        return BLOCK_ITEMS.register(name, () -> new ModBlockItem(blockIn.get(), new Item.Properties().group(groupIn)));
    }

    private static RegistryObject<Item> register(RegistryObject<Block> blockIn, ItemGroup groupIn) {
        return BLOCK_ITEMS.register(blockIn.get().toString(), () -> new ModBlockItem(blockIn.get(), new Item.Properties().group(groupIn)));
    }

    private static RegistryObject<Item> register(RegistryObject<Block> blockIn) {
        return BLOCK_ITEMS.register(blockIn.get().toString(), () -> new ModBlockItem(blockIn.get(), new Item.Properties()));
    }

    private static RegistryObject<Item> register(RegistryObject<Block> blockIn, Item.Properties properties) {
        return BLOCK_ITEMS.register(blockIn.get().toString(), () -> new ModBlockItem(blockIn.get(), properties));
    }

    private static RegistryObject<Item> register(String name, RegistryObject<Block> blockIn, Item.Properties properties) {
        return BLOCK_ITEMS.register(name, () -> new ModBlockItem(blockIn.get(), properties));
    }

    private static RegistryObject<Item> register(String name, ModBlockItem modBlockItemIn) {
        return BLOCK_ITEMS.register(name, () -> modBlockItemIn);
    }

    private static Item register(Block blockIn, ItemGroup itemGroupIn) {
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
}
