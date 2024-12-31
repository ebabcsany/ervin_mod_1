package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.Epkin;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.block.BarrierBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockItemInit_ {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> EPKIN = UnusedBlockInit.BLOCK_DEFERRED_REGISTER.register("epkin", () -> new Epkin(Block.Properties.from(Blocks.BARRIER).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000.0f)));
    public static final RegistryObject<Item> COAL_SLAB = UnusedItemInit.registryObject(BLOCK_ITEMS, "coal_slab", () -> new BurningBlockItem(BlockInit.COAL_SLAB.get(), (new Item.Properties()), 8000));
    public static final RegistryObject<Item> CHARCOAL_BLOCK = UnusedItemInit.registryObject(BLOCK_ITEMS, "charcoal_block", () -> new BurningBlockItem(BlockInit.CHARCOAL_BLOCK.get(), (new Item.Properties()), 16000));
    public static final RegistryObject<Item> CHARCOAL_SLAB = UnusedItemInit.registryObject(BLOCK_ITEMS, "charcoal_slab", () -> new BurningBlockItem(BlockInit.CHARCOAL_SLAB.get(), (new Item.Properties()), 8000));
    public static final RegistryObject<Item> CHARCOAL_STAIRS = UnusedItemInit.registryObject(BLOCK_ITEMS, "charcoal_stairs", () -> new BurningBlockItem(BlockInit.CHARCOAL_STAIRS.get(), (new Item.Properties()), 12000));
    public static final RegistryObject<Item> ZUNK_SLAB = UnusedItemInit.registryObject(BLOCK_ITEMS, "zunk_slab", () -> new BlockItem(BlockInit.ZUNK_SLAB.get(), (new Item.Properties())));
    public static final RegistryObject<Item> ZUNK_STAIRS = UnusedItemInit.registryObject(BLOCK_ITEMS, "zunk_stairs", () -> new BlockItem(BlockInit.ZUNK_STAIRS.get(), (new Item.Properties())));
    public static final RegistryObject<Item> FIGHIV = UnusedItemInit.registryObject(BLOCK_ITEMS, "fighiv", () -> new BlockItem(BlockInit.FIGHIV.get(), (new Item.Properties())));
    public static final RegistryObject<BlockItem> BLACK_STRING = registerString("black_string", BlockInit.BLACK_TRIPWIRE);
    public static final RegistryObject<BlockItem> BLUE_STRING = registerString("blue_string", BlockInit.BLUE_TRIPWIRE);
    public static final RegistryObject<BlockItem> BROWN_STRING = registerString("brown_string", BlockInit.BROWN_TRIPWIRE);
    public static final RegistryObject<BlockItem> CYAN_STRING = registerString("cyan_string", BlockInit.CYAN_TRIPWIRE);
    public static final RegistryObject<BlockItem> GRAY_STRING = registerString("gray_string", BlockInit.GRAY_TRIPWIRE);
    public static final RegistryObject<BlockItem> GREEN_STRING = registerString("green_string", BlockInit.GREEN_TRIPWIRE);
    public static final RegistryObject<BlockItem> LIGHT_BLUE1_STRING = registerString("light_blue1_string", BlockInit.LIGHT_BLUE1_TRIPWIRE);
    public static final RegistryObject<BlockItem> LIGHT_BLUE_STRING = registerString("light_blue_string", BlockInit.LIGHT_BLUE_TRIPWIRE);
    public static final RegistryObject<BlockItem> LIGHT_GRAY_STRING = registerString("light_gray_string", BlockInit.LIGHT_GRAY_TRIPWIRE);
    public static final RegistryObject<BlockItem> LIME_STRING = registerString("lime_string", BlockInit.LIME_TRIPWIRE);
    public static final RegistryObject<BlockItem> MAGENTA_STRING = registerString("magenta_string", BlockInit.MAGENTA_TRIPWIRE);
    public static final RegistryObject<BlockItem> ORANGE_STRING = registerString("orange_string", BlockInit.ORANGE_TRIPWIRE);
    public static final RegistryObject<BlockItem> PINK_STRING = registerString("pink_string", BlockInit.PINK_TRIPWIRE);
    public static final RegistryObject<BlockItem> PURPLE_STRING = registerString("purple_string", BlockInit.PURPLE_TRIPWIRE);
    public static final RegistryObject<BlockItem> RED_STRING = registerString("red_string", BlockInit.RED_TRIPWIRE);
    public static final RegistryObject<BlockItem> YELLOW_STRING = registerString("yellow_string", BlockInit.YELLOW_TRIPWIRE);

    public static Item register(String name, Item item) {
        return UnusedItems.registerDefault(name, item);
    }

    public static RegistryObject<BlockItem> registerString(String name, RegistryObject<Block> blockIn) {
        return registerString(name, blockIn.orElse(Blocks.TRIPWIRE));
    }

    public static RegistryObject<BlockItem> registerString(String name, Block blockIn) {
        return UnusedBlockItemInit.registryObject(BLOCK_ITEMS, "strings/" + name, () -> new BlockItem(blockIn, new Item.Properties()));
    }

    public static BlockItem register(String name, Block blockIn, Item.Properties properties) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, blockIn, properties));
    }

    public static BlockItem register(String name, BlockItem blockItem) {
        return new Cast<BlockItem>().cast(UnusedItems.registerDefault(name, blockItem));
    }

    public static int getUseDuration(ItemStack stack, int durationIn) {
        return durationIn;
    }

    public static void register() {
        Ervin_mod_1.register(BlockItemInit_.class);
    }
}
