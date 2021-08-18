package com.babcsany.minecraft.ervin_mod_1.init.item.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier_;
import com.babcsany.minecraft.ervin_mod_1.item.TeratBlockItem;
import com.babcsany.minecraft.ervin_mod_1.item.item.Item_;
import com.babcsany.minecraft.ervin_mod_1.item.items.Terat;
import com.babcsany.minecraft.ervin_mod_1.item.items.Thufr;
import com.babcsany.minecraft.ervin_mod_1.item.items.ThufrBlockItem;
import com.babcsany.minecraft.ervin_mod_1.item.items.i_item_tiers.ToolItem;
import com.babcsany.minecraft.ervin_mod_1.item.special.Firn;
import com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier1;
import com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier2;
import com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier4;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableSpecialToolItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    /**public static final RegistryObject<Item> SRIUNK = BURNABLE_ITEMS.register("sriunk", () -> new Sriunk(com.babcsany.minecraft.ervin_mod_1.item.tool.ModItemTier.SRIUNK,27, (new Item.Properties()).isBurnable()));*/
    //public static final RegistryObject<Terat> TERAT = BURNABLE_ITEMS.register("terat", () -> new Terat(ModItemTier1.TERAT,312,82345, (new Item.Properties()).isBurnable()));
    //public static final RegistryObject<Terat> TERAT_STICK = BURNABLE_ITEMS.register("stick/terat_stick", () -> new Terat(ModItemTier1.TERAT,165,45632, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT = BURNABLE_ITEMS.register("terat", () -> new Terat(ModItemTier2.TERAT,643.0F, (new Item.Properties()).isBurnable().maxStackSize(64)));
    public static final RegistryObject<Item> TERAT_STICK = BURNABLE_ITEMS.register("stick/terat_stick", () -> new Terat(ModItemTier2.TERAT,562.0F, (new Item.Properties()).isBurnable().maxStackSize(64)));
    public static final RegistryObject<Item> THUFR = BURNABLE_ITEMS.register("special/thufr", () -> new ThufrBlockItem(BlockInit.THUFR.get(), ModItemTier2.THUFR,54326578.0F, ((new Item.Properties()).isBurnable()).maxStackSize(2048)));
    public static final RegistryObject<Item> THUFR_PICKAXE = BURNABLE_ITEMS.register("tools/pickaxe/thufr_pickaxe", () -> new Thufr(ModItemTier_.THUFR,54326578.0F, 1023146536.0F,(new Item.Properties()).isBurnable()));
}
