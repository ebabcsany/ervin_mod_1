package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintingInit {

    public static DeferredRegister<PaintingType> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Ervin_mod_1.MOD_ID);
    public static PaintingType PAINTING_TYPES;

    public static final RegistryObject<PaintingType> LBEO = PAINTINGS.register("lbeo", () -> new PaintingType(80, 80));
    public static final RegistryObject<PaintingType> GULK_LBEO = PAINTINGS.register("gulk_lbeo", () -> new PaintingType(400, 400));
    public static final RegistryObject<PaintingType> PEPPER = PAINTINGS.register("pepper", () -> new PaintingType(48, 64));
    public static final RegistryObject<PaintingType> SPECIAL_ML_G_U_lL_SB_HU = PAINTINGS.register("special_ml_g_u/ll_sb_hu", () -> new PaintingType(564, 358));
    public static final RegistryObject<PaintingType> BEAUTIFUL_BLUE_WORLD_59606 = PAINTINGS.register("beautiful_blue_world_59606", () -> new PaintingType(600, 337));
    public static final RegistryObject<PaintingType> BEAUTIFUL_GREEN_ISLAND_50345 = PAINTINGS.register("beautiful_green_island_50345", () -> new PaintingType(300, 168));
    public static final RegistryObject<PaintingType> BEAUTIFUL_NATURE_2_3661699489 = PAINTINGS.register("beautiful_nature_photo_2_3661699489", () -> new PaintingType(2400, 1500));
    public static final RegistryObject<PaintingType> DEPOSITPHOTOS_NATURE_2_3661699489 = PAINTINGS.register("depositphotos_53954927_stock_photo_beautiful_landscape_of_scottish_nature", () -> new PaintingType(600, 400));

    private static String string(String key) {
        String string = "ervin_mod_1:";
        return string + key;
    }

    private static PaintingType register(String key, int width, int height) {
        return Registry.register(Registry.MOTIVE, string(key), new PaintingType(width, height));
    }
}
