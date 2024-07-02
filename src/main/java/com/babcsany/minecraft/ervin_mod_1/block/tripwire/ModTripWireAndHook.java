package com.babcsany.minecraft.ervin_mod_1.block.tripwire;

import com.babcsany.minecraft.ervin_mod_1.block.tripwire.tripwire_hook.ModTripWireHookBlock;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class ModTripWireAndHook {
    public static ModTripWireHookBlock TRIPWIRE_HOOK = null;
    public static ModTripWireBlock TRIPWIRE = null;

    public ModTripWireAndHook(String name) {
        set(name);
    }

    public static void set(String name) {
        AbstractBlock.Properties properties = Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement();
        TRIPWIRE_HOOK = (ModTripWireHookBlock) registerBlockItem("tripwires/tripwire_hooks/" + name, new ModTripWireHookBlock(properties));
        TRIPWIRE = (ModTripWireBlock) register("tripwires/" + name, new ModTripWireBlock(TRIPWIRE_HOOK, properties));
    }

    public static Block registerBlockItem(String name, Block blockIn) {
        return UnusedBlocks.registerBlockItem(name, blockIn);
    }

    public static Block register(String name, Block blockIn) {
        return UnusedBlocks.registerDefault(name, blockIn);
    }
}
