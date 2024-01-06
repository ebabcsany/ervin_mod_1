package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> THUNM = ITEMS.register("thunm", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> REGDEM = ITEMS.register("regdem", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> DREIN = ITEMS.register("drein", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> NIRG = ITEMS.register("nirg", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> KIRT = ITEMS.register("kirt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> KIRT_STIK = ITEMS.register("kirt_stik", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> FRIN = ITEMS.register("frin", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> FIRT = ITEMS.register("firt", () -> new BurningItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS)), 2400));
    public static final RegistryObject<Item> BREND = ITEMS.register("brend", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SIRK = ITEMS.register("sirk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> FRIT = ITEMS.register("frit", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> FIRK = ITEMS.register("firk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RASC = ITEMS.register("rasc", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SACR = ITEMS.register("sacr", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SCRA = ITEMS.register("scra", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SRAC = ITEMS.register("srac", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> CRAST = ITEMS.register("crast", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SRACT = ITEMS.register("sract", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SRACH = ITEMS.register("srach", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SARCT = ITEMS.register("sarct", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SACHT = ITEMS.register("sacht", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RASCH = ITEMS.register("rasch", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RASCHT = ITEMS.register("rascht", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SCRAF = ITEMS.register("scraf", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SCRAFT = ITEMS.register("scraft", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RAFTSH = ITEMS.register("raftsh", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RAFTSC = ITEMS.register("raftsc", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RAFTSCH = ITEMS.register("raftsch", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SCHRAFT = ITEMS.register("schraft", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ENDER_SCRAK = ITEMS.register("ender_scrak", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ENDER_SCRAKT = ITEMS.register("ender_scrakt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ENDER_SRACKT = ITEMS.register("ender_srackt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> END_STONE_STIK = ITEMS.register("end_stone_stik", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> PACK = ITEMS.register("pack", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> KALT = ITEMS.register("kalt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> TRINK = ITEMS.register("trink", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GNITH = ITEMS.register("gnith", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> KIRT_STICK = ITEMS.register("kirt_stick", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GRITK = ITEMS.register("gritk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> CHAK = ITEMS.register("chak", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GURL = ITEMS.register("gurl", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GRUV = ITEMS.register("gruv", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GRUK = ITEMS.register("gruk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GRUKT = ITEMS.register("grukt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SCIK = ITEMS.register("scik", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GURLT = ITEMS.register("gurlt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> TURG_SHIELD = ITEMS.register("turg_shield", () -> new TurgShieldItem((new Item.Properties()).maxDamage(5000).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> FREIN_BALL = ITEMS.register("frein_ball", () -> new FreinballItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ENDER_CRAKTH = ITEMS.register("ender_crakth", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SCRAKTHS_PEARL = ITEMS.register("scrakths_pearl", () -> new ScrakthsPearlItem((new Item.Properties()).maxStackSize(16).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> ENDER_CRAKTHS = ITEMS.register("ender_crakths", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> FRIM_BOAT = ITEMS.register("frim_boat", () -> new Item((new Item.Properties()).maxStackSize(1).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> JURK_BUCKETI = ITEMS.register("jurk_buckett", () -> new JurkBucketItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> CRAKH = ITEMS.register("crakh", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> BLACK_IRON_INGOT = ITEMS.register("iron/ingots/black_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> BLUE_IRON_INGOT = ITEMS.register("iron/ingots/blue_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> BROWN_IRON_INGOT = ITEMS.register("iron/ingots/brown_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> CYAN_IRON_INGOT = ITEMS.register("iron/ingots/cyan_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GRAY_IRON_INGOT = ITEMS.register("iron/ingots/gray_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GREEN_IRON_INGOT = ITEMS.register("iron/ingots/green_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_INGOT = ITEMS.register("iron/ingots/light_blue1_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_INGOT = ITEMS.register("iron/ingots/light_blue_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_INGOT = ITEMS.register("iron/ingots/light_gray_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> LIME_IRON_INGOT = ITEMS.register("iron/ingots/lime_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> MAGENTA_IRON_INGOT = ITEMS.register("iron/ingots/magenta_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ORANGE_IRON_INGOT = ITEMS.register("iron/ingots/orange_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> PINK_IRON_INGOT = ITEMS.register("iron/ingots/pink_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> PURPLE_IRON_INGOT = ITEMS.register("iron/ingots/purple_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> RED_IRON_INGOT = ITEMS.register("iron/ingots/red_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> WHITE_IRON_INGOT = ITEMS.register("iron/ingots/white_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> YELLOW_IRON_INGOT = ITEMS.register("iron/ingots/yellow_iron_ingot", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> TARG = ITEMS.register("targ", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GURT = ITEMS.register("gurt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GURB = ITEMS.register("gurb", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GURK = ITEMS.register("gurk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GURKT = ITEMS.register("gurkt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GURKTH = ITEMS.register("gurkth", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GANT = ITEMS.register("gant", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GANB = ITEMS.register("ganb", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GANK = ITEMS.register("gank", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ZURT = ITEMS.register("zurt", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ZURB = ITEMS.register("zurb", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> ZURK = ITEMS.register("zurk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> MLONK = ITEMS.register("mlonk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    //public static final RegistryObject<Item> COD_BUCKET = ITEMS.register("cod_bucket", new FishBucketItem(EntityInit.GUBROV_ENTITY.get(), Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LIGHT_BLUE1_DYE = ITEMS.register("light_blue1_dye", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> DGUCHSR = ITEMS.register("dguchsr", () -> new BurningItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS)), 3405));
    public static final RegistryObject<Item> TAWROL = ITEMS.register("tawrol", () -> new TawrolItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GWURST_FEATHER = ITEMS.register("gwurst_feather", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> HTRAW = ITEMS.register("htraw", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> HTRAW_MEAL = ITEMS.register("htraw_meal", () -> new HtrawMealItem((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
}
