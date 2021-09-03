package com.babcsany.minecraft.ervin_mod_1.util.registries;

import com.babcsany.minecraft.ervin_mod_1.registry.ModRegistry;

public class modPainting_Type extends net.minecraftforge.registries.ForgeRegistryEntry<modPainting_Type> {

    public static modPainting_Type modPainting_TYPE;

    public static final modPainting_Type lLl_Ss_hu_ = register("beautiful-nature-gyonyoru-termeszetfoto-2-3661699489", 2400, 1500);
    public static final modPainting_Type Klkjhgfzuiov = register("depositphotos_53954927-stock-photo-beautiful-landscape-of-scottish-nature", 600, 400);
    private final int width;
    private final int height;

    private static String string(String key) {
        String string = "ervin_mod_1:";
        return string + key;
    }

    private static modPainting_Type register(String key, int width, int height) {
        return ModRegistry.register(ModRegistry.modPainting_MOTIVE, string(key), new modPainting_Type(width, height));
    }

    public modPainting_Type(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
