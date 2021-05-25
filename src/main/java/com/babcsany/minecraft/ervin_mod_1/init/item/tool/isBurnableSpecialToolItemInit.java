package com.babcsany.minecraft.ervin_mod_1.init.item.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.items.Terat;
import com.babcsany.minecraft.ervin_mod_1.item.items.i_item_tiers.ToolItem;
import com.babcsany.minecraft.ervin_mod_1.item.special.Firn;
import com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier1;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableSpecialToolItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    /**public static final RegistryObject<Item> SRIUNK = BURNABLE_ITEMS.register("sriunk", () -> new Sriunk(com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier.CRAINT,27, (new Item.Properties()).isBurnable()));*/
    public static final RegistryObject<Terat> TERAT = BURNABLE_ITEMS.register("terat", () -> new Terat(ModItemTier1.TERAT,103,120000, (new Item.Properties()).isBurnable().maxStackSize(2048)));
}
