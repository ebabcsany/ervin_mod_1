package com.babcsany.minecraft.ervin_mod_1.init.item.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.DebugSriunkStick;
import com.babcsany.minecraft.ervin_mod_1.item.special.*;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableSpecialItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final DefItem DEF_ITEM = register("def_item", new DefItem(properties()));
    public static final Grith GRITH = register("grith", new Grith(properties()));
    public static final Grithvsg GRITHVSG = register("grithvsg", new Grithvsg(properties()));
    public static final Grithvsr GRITHVSR = register("grithvsr", new Grithvsr(properties()));
    public static final Firn FIRN = register("firn", new Firn(properties()));
    public static final Troif TROIF = register("troif", new Troif(properties()));
    public static final DebugSriunkStick DEBUG_SRIUNK_STICK = register("debug_sriunk_stick", new DebugSriunkStick(properties()));

    public static <T extends Item> T register(String name, T item) {
        return new Cast<T>().cast(UnusedItems.registerDefault(name, item));
    }

    public static Item.Properties properties() {
        return new Item.Properties().isImmuneToFire();
    }

    public static void register() {
        Ervin_mod_1.register(isBurnableSpecialItemInit.class);
    }
}
