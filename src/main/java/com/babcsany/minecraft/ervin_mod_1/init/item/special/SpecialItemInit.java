package com.babcsany.minecraft.ervin_mod_1.init.item.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.DebugSriunkStick;
import com.babcsany.minecraft.ervin_mod_1.item.special.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Grithk> GRITHK = SPECIAL_ITEMS.register("grithk", () -> new Grithk((new Item.Properties())));
}
