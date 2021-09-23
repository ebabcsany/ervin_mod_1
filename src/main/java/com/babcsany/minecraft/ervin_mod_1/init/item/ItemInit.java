package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> REGDEM = registerBurningItem("regdem", ItemGroup.ERVIN_MOD_1_ITEMS, 650);
    public static final RegistryObject<Item> DREIN = register("drein", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> NIRG = registerBurningItem("nirg", ItemGroup.ERVIN_MOD_1_ITEMS, 1200);
    public static final RegistryObject<Item> KIRT = register("kirt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> KIRT_STIK = register("kirt_stik", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RUBY = register("ruby", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> FRIN = register("frin", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> FIRT = registerBurningItem("firt", ItemGroup.ERVIN_MOD_1_ITEMS, 2400);
    public static final RegistryObject<Item> BREND = register("brend", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SIRK = register("sirk", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> FRIT = register("frit", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> FIRK = register("firk", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RASC = register("rasc", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SACR = register("sacr", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SCRA = register("scra", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SRAC = register("srac", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> CRAST = register("crast", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SRACT = register("sract", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SRACH = register("srach", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SARCT = register("sarct", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SACHT = register("sacht", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RASCH = register("rasch", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RASCHT = register("rascht", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SCRAF = register("scraf", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SCRAFT = register("scraft", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RAFTSH = register("raftsh", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RAFTSC = register("raftsc", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RAFTSCH = register("raftsch", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SCHRAFT = register("schraft", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> ENDER_SCRAK = register("ender_scrak", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> ENDER_SCRAKT = register("ender_scrakt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> ENDER_SRACKT = register("ender_srackt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> END_STONE_STIK = register("end_stone_stik", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> PACK = register("pack", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> KALT = register("kalt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> TRINK = register("trink", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GNITH = register("gnith", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> KIRT_STICK = register("kirt_stick", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GRITK = register("gritk", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> CHAK = register("chak", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GURL = register("gurl", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GRUV = register("gruv", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GRUK = register("gruk", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GRUKT = register("grukt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SCIK = register("scik", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GURLT = register("gurlt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> TURG_SHIELD = ITEMS.register("turg_shield", () -> new TurgShieldItem((new Item.Properties()).maxDamage(5000).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> FREIN_BALL = ITEMS.register("frein_ball", () -> new FreinballItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ENDER_CRAKTH = register("ender_crakth", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> SCRAKTHS_PEARL = ITEMS.register("scrakths_pearl", () -> new ScrakthsPearlItem((new Item.Properties()).maxStackSize(16).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> ENDER_CRAKTHS = register("ender_crakths", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> FRIM_BOAT = ITEMS.register("frim_boat", () -> new Item((new Item.Properties()).maxStackSize(1).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> JURK_BUCKETI = ITEMS.register("jurk_buckett", () -> new JurkBucketItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> CRAKH = register("crakh", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> BLACK_IRON_INGOT = register("iron/ingots/black_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> BLUE_IRON_INGOT = register("iron/ingots/blue_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> BROWN_IRON_INGOT = register("iron/ingots/brown_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> CYAN_IRON_INGOT = register("iron/ingots/cyan_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GRAY_IRON_INGOT = register("iron/ingots/gray_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GREEN_IRON_INGOT = register("iron/ingots/green_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_INGOT = register("iron/ingots/light_blue1_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_INGOT = register("iron/ingots/light_blue_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_INGOT = register("iron/ingots/light_gray_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> LIME_IRON_INGOT = register("iron/ingots/lime_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> MAGENTA_IRON_INGOT = register("iron/ingots/magenta_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> ORANGE_IRON_INGOT = register("iron/ingots/orange_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> PINK_IRON_INGOT = register("iron/ingots/pink_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> PURPLE_IRON_INGOT = register("iron/ingots/purple_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> RED_IRON_INGOT = register("iron/ingots/red_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> WHITE_IRON_INGOT = register("iron/ingots/white_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> YELLOW_IRON_INGOT = register("iron/ingots/yellow_iron_ingot", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> TARG = register("targ", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GURT = register("gurt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GURB = register("gurb", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GURK = register("gurk", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GURKT = register("gurkt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GURKTH = register("gurkth", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GANT = register("gant", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GANB = register("ganb", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> GANK = register("gank", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> ZURT = register("zurt", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> ZURB = register("zurb", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> ZURK = register("zurk", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> MLONK = register("mlonk", ItemGroup.ERVIN_MOD_1_ITEMS);
    //public static final RegistryObject<Item> COD_BUCKET = ITEMS.register("cod_bucket", new FishBucketItem(EntityInit.GUBROV_ENTITY.get(), Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LIGHT_BLUE1_DYE = register("light_blue1_dye", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> DGUCHSR = registerBurningItem("dguchsr", ItemGroup.ERVIN_MOD_1_ITEMS, 3405);
    public static final RegistryObject<Item> TAWROL = ITEMS.register("tawrol", () -> new TawrolItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GWURST_FEATHER = register("gwurst_feather", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> HTRAW = register("htraw", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> HTRAW_MEAL = ITEMS.register("htraw_meal", () -> new HtrawMealItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));

    private static RegistryObject<Item> register(String name) {
        return ITEMS.register(name, () -> new Item((new Item.Properties())));
    }

    private static RegistryObject<Item> register(String name, net.minecraft.item.ItemGroup groupIn) {
        return ITEMS.register(name, () -> new Item((new Item.Properties().group(groupIn))));
    }

    private static RegistryObject<Item> registerBurningItem(String name, int burnTimeIn) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static RegistryObject<Item> registerBurningItem(String name, net.minecraft.item.ItemGroup groupIn, int burnTimeIn) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().group(groupIn)) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }
}
