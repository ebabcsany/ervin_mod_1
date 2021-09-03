package com.babcsany.minecraft.ervin_mod_1.init.item;

import net.minecraft.entity.item.PaintingType;
import net.minecraft.util.registry.Registry;

public class PaintingInit {

    public static final PaintingType LBEO = register("lbeo", 1, 1);

    private static String string(String key) {
        String string = "ervin_mod_1:";
        return string + key;
    }

    private static PaintingType register(String key, int width, int height) {
        return Registry.register(Registry.MOTIVE, string(key), new PaintingType(width, height));
    }
}
