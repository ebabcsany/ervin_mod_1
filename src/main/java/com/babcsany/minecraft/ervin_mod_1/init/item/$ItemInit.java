package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.item.Item;

public class $ItemInit {
    public static final Item $_1$ = registerDefault("1");
    public static final Item $_2$ = registerDefault("2");
    public static final Item $_3$ = registerDefault("3");
    public static final Item $_4$ = registerDefault("4");
    public static final Item $_5$ = registerDefault("5");
    public static final Item $_6$ = registerDefault("6");
    public static final Item $_7$ = registerDefault("7");
    public static final Item $_8$ = registerDefault("8");
    public static final Item $_9$ = registerDefault("9");
    public static final Item $_10$ = registerDefault("10");

    public static Item registerDefault(String name) {
        return UnusedItems.registerDefault("usd/" + name, new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS));
    }

    public static void register() {
        Ervin_mod_1.register($ItemInit.class);
    }
}
