package com.babcsany.minecraft.ervin_mod_1.init.item.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.items.Craint;
import com.babcsany.minecraft.ervin_mod_1.item.items.Terat;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TERAT = BURNABLE_ITEMS.register("terat", () -> new Terat(
            com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier.TERAT,103, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> CRAINT = BURNABLE_ITEMS.register("craint", () -> new Craint(
            com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier.CRAINT,27, (new Item.Properties()).isBurnable()
    ));
}
