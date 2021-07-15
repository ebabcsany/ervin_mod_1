package com.babcsany.minecraft.ervin_mod_1.init.item.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.DebugSriunkStick;
import com.babcsany.minecraft.ervin_mod_1.item.special.*;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableSpecialItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<DefItem> DEF_ITEM = SPECIAL_ITEMS.register("def_item", () -> new DefItem(new Item.Properties().isBurnable()));
    public static final RegistryObject<Grith> GRITH = SPECIAL_ITEMS.register("grith", () -> new Grith((new Item.Properties()).isBurnable()));
    public static final RegistryObject<Grithvsg> GRITHVSG = SPECIAL_ITEMS.register("grithvsg", () -> new Grithvsg((new Item.Properties()).isBurnable()));
    public static final RegistryObject<Grithvsr> GRITHVSR = SPECIAL_ITEMS.register("grithvsr", () -> new Grithvsr((new Item.Properties()).isBurnable()));
    public static final RegistryObject<Firn> FIRN = SPECIAL_ITEMS.register("firn", () -> new Firn((new Item.Properties()).isBurnable()));
    public static final RegistryObject<Troif> TROIF = SPECIAL_ITEMS.register("troif", () -> new Troif((new Item.Properties())));
    public static final RegistryObject<DebugSriunkStick> DEBUG_SRIUNK_STICK = SPECIAL_ITEMS.register("debug_sriunk_stick", () -> new DebugSriunkStick((new Item.Properties()).isBurnable()));
}
