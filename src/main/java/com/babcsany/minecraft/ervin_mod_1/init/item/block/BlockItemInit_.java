package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
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

public class BlockItemInit_ {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Block EPKIN = UnusedBlocks.registerBlock("epkin", new BarrierBlock(Block.Properties.from(Blocks.BARRIER).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000.0f)));
    public static final Item COAL_SLAB = register("coal_slab", new BurningBlockItem(BlockInit.COAL_SLAB, (new Item.Properties()), 8000));
    public static final Item CHARCOAL_BLOCK = register("charcoal_block", new BurningBlockItem(BlockInit.CHARCOAL_BLOCK, (new Item.Properties()), 16000));
    public static final Item CHARCOAL_SLAB = register("charcoal_slab", new BurningBlockItem(BlockInit.CHARCOAL_SLAB, (new Item.Properties()), 8000));
    public static final Item CHARCOAL_STAIRS = register("charcoal_stairs", new BurningBlockItem(BlockInit.CHARCOAL_STAIRS, (new Item.Properties()), 12000));
    public static final Item ZUNK_SLAB = register("zunk_slab", new BlockItem(BlockInit.ZUNK_SLAB, (new Item.Properties())));
    public static final Item ZUNK_STAIRS = register("zunk_stairs", new BlockItem(BlockInit.ZUNK_STAIRS, (new Item.Properties())));
    public static final Item FIGHIV = register("fighiv", new BlockItem(BlockInit.FIGHIV, (new Item.Properties())));
    public static final BlockItem BLACK_STRING = register("strings/black_string", new BlockItem(BlockInit.BLACK_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem BLUE_STRING = register("strings/blue_string", new BlockItem(BlockInit.BLUE_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem BROWN_STRING = register("strings/brown_string", new BlockItem(BlockInit.BROWN_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem CYAN_STRING = register("strings/cyan_string", new BlockItem(BlockInit.CYAN_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem GRAY_STRING = register("strings/gray_string", new BlockItem(BlockInit.GRAY_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem GREEN_STRING = register("strings/green_string", new BlockItem(BlockInit.GREEN_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem LIGHT_BLUE1_STRING = register("strings/light_blue1_string", new BlockItem(BlockInit.LIGHT_BLUE1_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem LIGHT_BLUE_STRING = register("strings/light_blue_string", new BlockItem(BlockInit.LIGHT_BLUE_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem LIGHT_GRAY_STRING = register("strings/light_gray_string", new BlockItem(BlockInit.LIGHT_GRAY_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem LIME_STRING = register("strings/lime_string", new BlockItem(BlockInit.LIME_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem MAGENTA_STRING = register("strings/magenta_string", new BlockItem(BlockInit.MAGENTA_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem ORANGE_STRING = register("strings/orange_string", new BlockItem(BlockInit.ORANGE_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem PINK_STRING = register("strings/pink_string", new BlockItem(BlockInit.PINK_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem PURPLE_STRING = register("strings/purple_string", new BlockItem(BlockInit.PURPLE_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem RED_STRING = register("strings/red_string", new BlockItem(BlockInit.RED_TRIPWIRE, (new Item.Properties())));
    public static final BlockItem YELLOW_STRING = register("strings/yellow_string", new BlockItem(BlockInit.YELLOW_TRIPWIRE, (new Item.Properties())));

    public static Item register(String name, Item item) {
        return UnusedItems.registerDefault(name, item);
    }

    public static BlockItem registerString(String name, Block blockIn) {
        return register("strings/" + name, blockIn, new Item.Properties());
    }

    public static BlockItem register(String name, Block blockIn, Item.Properties properties) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, blockIn, properties));
    }

    public static BlockItem register(String name, BlockItem blockItem) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, blockItem));
    }

    public static int getUseDuration(ItemStack stack, int durationIn) {
        return durationIn;
    }

    public static void register() {
        Ervin_mod_1.register(BlockItemInit_.class);
    }
}
