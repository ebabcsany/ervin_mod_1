package com.babcsany.minecraft.ervin_mod_1.init.item.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.items.Craint;
import com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier1;
import com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier2;
import com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier4;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredItem_1;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialToolItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> CRAINT = BURNABLE_ITEMS.register("craint", () -> new Craint(ModItemTier.CRAINT,320, (new TieredItem_1.Properties()).isImmuneToFire()));
}
