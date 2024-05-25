package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item JURKF = register("jurkf", com.babcsany.minecraft.init.BlockInit.FIRT_BLOCK);
    public static final Item FIRG_PLANKS = register("firg_planks", BlockInit.FIRG_PLANKS, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRG_PLANKS_STAIRS = register("firg_planks_stairs", BlockInit.FIRG_PLANKS_STAIRS, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRG_PLANKS_DOOR = register("firg_planks_door", BlockInit.FIRG_PLANKS_DOOR, ItemGroup.BUILDING_BLOCKS);
    public static final Item FIRT_BLOCK = register("firt_block", new BurningBlockItem(BlockInit.FIRT_BLOCK, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS), 21600));
    public static final Item TRIRIJ = register("tririj", com.babcsany.minecraft.init.BlockInit.TRIRIJ, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS));
    public static final Item REUTRIEN = register("reutrien", BlockInit.REUTRIEN, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS));

    public static Item register(String name, Block blockIn) {
        return register(name, blockIn, (new Item.Properties()));
    }

    public static Item register(String name, Block blockIn, ItemGroup group) {
        return register(name, blockIn, (new Item.Properties()).group(group));
    }

    public static Item register(String name, Block blockIn, Item.Properties properties) {
        return UnusedBlockItems.registerDefault(name, blockIn, properties);
    }

    public static Item register(String name, Item item) {
        return UnusedItems.registerDefault(name, item);
    }
}
