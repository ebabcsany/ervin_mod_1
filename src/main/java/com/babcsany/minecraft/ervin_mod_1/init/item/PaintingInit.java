package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintingInit {

    public static DeferredRegister<PaintingType> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Ervin_mod_1.MOD_ID);
    public static PaintingType PAINTING_TYPES;

    public static final PaintingType LBEO = register("lbeo", 80, 80);
    public static final PaintingType GULK_LBEO = register("gulk_lbeo", 400, 400);
    public static final PaintingType PEPPER = register("pepper", 48, 64);
    public static final PaintingType SPECIAL_ML_G_U_lL_SB_HU = register("special_ml_g_u/ll_sb_hu", 564, 358);
    public static final PaintingType BEAUTIFUL_BLUE_WORLD_59606 = register("beautiful_blue_world_59606", 600, 337);
    public static final PaintingType BEAUTIFUL_GREEN_ISLAND_50345 = register("beautiful_green_island_50345", 300, 168);
    public static final PaintingType BEAUTIFUL_NATURE_2_3661699489 = register("beautiful_nature_photo_2_3661699489", 2400, 1500);
    public static final PaintingType DEPOSITPHOTOS_NATURE_2_3661699489 = register("depositphotos_53954927_stock_photo_beautiful_landscape_of_scottish_nature", 600, 400);

    private static String string(String key) {
        String string = "ervin_mod_1:";
        return string + key;
    }

    private static PaintingType register(String key, int width, int height) {
        return Registry.register(Registry.MOTIVE, string(key), new PaintingType(width, height));
    }
}
