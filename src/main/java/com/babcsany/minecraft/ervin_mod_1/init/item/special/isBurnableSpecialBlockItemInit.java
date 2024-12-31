package com.babcsany.minecraft.ervin_mod_1.init.item.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.block.GrithBlock;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class isBurnableSpecialBlockItemInit {
    public static final DeferredRegister<Item> DEFERRED_REGISTER = UnusedBlockItemInit.BLOCK_ITEM_DEFERRED_REGISTER;

    public static final RegistryObject<GrithBlock> GRITH_BLOCK = DEFERRED_REGISTER.register("grith_block", () -> new GrithBlock(BlockInit.GRITH_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<GrithBlock> GRITH_SLAB = DEFERRED_REGISTER.register("grith_slab", () -> new GrithBlock(BlockInit.GRITH_SLAB.get(), (new Item.Properties())));
    public static final RegistryObject<GrithBlock> GRITH_STAIRS = DEFERRED_REGISTER.register("grith_stairs", () -> new GrithBlock(BlockInit.GRITH_STAIRS.get(), (new Item.Properties())));

    public static BlockItem register(String name, Block blockIn) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, blockIn));
    }

    public static GrithBlock register(String name, GrithBlock blockItem) {
        return (GrithBlock) UnusedItems.registerDefault(name, blockItem);
    }

    public static void register() {
        Ervin_mod_1.register(isBurnableSpecialBlockItemInit.class);
    }
}
