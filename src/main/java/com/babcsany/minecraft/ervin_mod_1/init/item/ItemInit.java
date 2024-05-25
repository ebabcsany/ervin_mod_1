package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import com.babcsany.minecraft.ervin_mod_1.item.special.ModOperatorOnlyItem;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.item.FishBucketItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item JURK_BUCKET = registerBucket("jurk_bucket", FluidInit.JURK, Items.BUCKET);
    public static final Item REGDEM = registerWithModGroup("regdem");
    public static final Item DREIN = registerWithModGroup("drein");
    public static final Item NIRG = registerWithModGroup("nirg");
    public static final Item KIRT = registerWithModGroup("kirt");
    public static final Item KIRT_STICK = registerWithModGroup("kirt_stick");
    public static final Item KIRT_STIK_STICK = registerWithModGroup("kirt_stik_stick");
    public static final Item KIRT_STIK = registerWithModGroup("kirt_stik");
    public static final Item RUBY = registerWithModGroup("ruby");
    public static final Item FRIN = registerWithModGroup("frin");
    public static final Item BREND = registerWithModGroup("brend");
    public static final Item SIRK = registerWithModGroup("sirk");
    public static final Item FRIT = registerWithModGroup("frit");
    public static final Item FIRK = registerWithModGroup("firk");
    public static final Item RASC = registerWithModGroup("rasc");
    public static final Item SACR = registerWithModGroup("sacr");
    public static final Item SCRA = registerWithModGroup("scra");
    public static final Item SRAC = registerWithModGroup("srac");
    public static final Item CRAST = registerWithModGroup("crast");
    public static final Item SRACT = registerWithModGroup("sract");
    public static final Item SRACH = registerWithModGroup("srach");
    public static final Item SARCT = registerWithModGroup("sarct");
    public static final Item SACHT = registerWithModGroup("sacht");
    public static final Item RASCH = registerWithModGroup("rasch");
    public static final Item RASCHT = registerWithModGroup("rascht");
    public static final Item SCRAF = registerWithModGroup("scraf");
    public static final Item SCRAFT = registerWithModGroup("scraft");
    public static final Item RAFTSH = registerWithModGroup("raftsh");
    public static final Item RAFTSC = registerWithModGroup("raftsc");
    public static final Item RAFTSCH = registerWithModGroup("raftsch");
    public static final Item SCHRAFT = registerWithModGroup("schraft");
    public static final Item ENDER_SCRAK = registerWithModGroup("ender_scrak");
    public static final Item ENDER_SCRAKT = registerWithModGroup("ender_scrakt");
    public static final Item ENDER_SRACKT = registerWithModGroup("ender_srackt");
    public static final Item END_STONE_STIK = registerWithModGroup("end_stone_stik");
    public static final Item PACK = registerWithModGroup("pack");
    public static final Item KALT = registerWithModGroup("kalt");
    public static final Item TRINK = registerWithModGroup("trink");
    public static final Item GNITH = registerWithModGroup("gnith");
    public static final Item GRITK = registerWithModGroup("gritk");
    public static final Item CHAK = registerWithModGroup("chak");
    public static final Item GURL = registerWithModGroup("gurl");
    public static final Item GRUV = registerWithModGroup("gruv");
    public static final Item GRUK = registerWithModGroup("gruk");
    public static final Item GRUKT = registerWithModGroup("grukt");
    public static final Item SCIK = registerWithModGroup("scik");
    public static final Item GURLT = registerWithModGroup("gurlt");
    public static final Item ENDER_CRAKTH = registerWithModGroup("ender_crakth");
    public static final Item ENDER_CRAKTHS = registerWithModGroup("ender_crakths");
    public static final Item CRAKH = registerWithModGroup("crakh");
    public static final Item BLACK_IRON_INGOT = registerWithModGroup("iron/ingots/black_iron_ingot");
    public static final Item BLUE_IRON_INGOT = registerWithModGroup("iron/ingots/blue_iron_ingot");
    public static final Item BROWN_IRON_INGOT = registerWithModGroup("iron/ingots/brown_iron_ingot");
    public static final Item CYAN_IRON_INGOT = registerWithModGroup("iron/ingots/cyan_iron_ingot");
    public static final Item GRAY_IRON_INGOT = registerWithModGroup("iron/ingots/gray_iron_ingot");
    public static final Item GREEN_IRON_INGOT = registerWithModGroup("iron/ingots/green_iron_ingot");
    public static final Item LIGHT_BLUE1_IRON_INGOT = registerWithModGroup("iron/ingots/light_blue1_iron_ingot");
    public static final Item LIGHT_BLUE_IRON_INGOT = registerWithModGroup("iron/ingots/light_blue_iron_ingot");
    public static final Item LIGHT_GRAY_IRON_INGOT = registerWithModGroup("iron/ingots/light_gray_iron_ingot");
    public static final Item LIME_IRON_INGOT = registerWithModGroup("iron/ingots/lime_iron_ingot");
    public static final Item MAGENTA_IRON_INGOT = registerWithModGroup("iron/ingots/magenta_iron_ingot");
    public static final Item ORANGE_IRON_INGOT = registerWithModGroup("iron/ingots/orange_iron_ingot");
    public static final Item PINK_IRON_INGOT = registerWithModGroup("iron/ingots/pink_iron_ingot");
    public static final Item PURPLE_IRON_INGOT = registerWithModGroup("iron/ingots/purple_iron_ingot");
    public static final Item RED_IRON_INGOT = registerWithModGroup("iron/ingots/red_iron_ingot");
    public static final Item WHITE_IRON_INGOT = registerWithModGroup("iron/ingots/white_iron_ingot");
    public static final Item YELLOW_IRON_INGOT = registerWithModGroup("iron/ingots/yellow_iron_ingot");
    public static final Item GURT = registerWithModGroup("gurt");
    public static final Item GURB = registerWithModGroup("gurb");
    public static final Item GURK = registerWithModGroup("gurk");
    public static final Item GURKT = registerWithModGroup("gurkt");
    public static final Item GURKTH = registerWithModGroup("gurkth");
    public static final Item GANT = registerWithModGroup("gant");
    public static final Item GANB = registerWithModGroup("ganb");
    public static final Item GANK = registerWithModGroup("gank");
    public static final Item ZURT = registerWithModGroup("zurt");
    public static final Item ZURB = registerWithModGroup("zurb");
    public static final Item ZURK = registerWithModGroup("zurk");
    public static final Item MLONK = registerWithModGroup("mlonk");
    public static final Item GWURST_FEATHER = registerWithModGroup("gwurst_feather");
    public static final Item HTRAW = registerWithModGroup("htraw");
    public static final Item LIGHT_BLUE1_DYE = register("light_blue1_dye", new ModDyeItem(ModDyeColor.LIGHT_BLUE1, (new Item.Properties()).group(ItemGroup.MATERIALS)));
    public static final Item JURK_BUCKETI = register("jurk_buckett", new JurkBucketItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final Item GUBROV_BUCKET = registerFishBucket("gubrov_bucket", EntityInit.GUBROV, Fluids.WATER, ItemGroup.MISC);
    public static final Item DGUCHSR = register("dguchsr", new BurningItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS)), 3405));
    public static final Item TAWROL = register("tawrol", new TawrolItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final Item FREIN_BALL = register("frein_ball", new FreinballItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final Item SCRAKTHS_PEARL = register("scrakths_pearl", new ScrakthsPearlItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final Item TURG_SHIELD = register("turg_shield", new TurgShieldItem((new Item.Properties()).maxDamage(5000).group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final Item FIRT = register("firt", new BurningItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS)), 2400));
    public static final Item HTRAW_MEAL = register("htraw_meal", new HtrawMealItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final Item EPKIN = register("epkin", new ModOperatorOnlyItem(BlockItemInit_.EPKIN, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));

    private static Item registerFishBucket(String name, EntityType<?> type, Fluid fluid, ItemGroup group) {
        return register(name, new FishBucketItem(() -> type, () -> fluid, (new Item.Properties()).maxStackSize(1).group(group)));
    }

    private static Item registerBucket(String name, Fluid fluid, Item containerItem) {
        return register(name, new BucketItem(() -> fluid, (new Item.Properties()).containerItem(containerItem)));
    }

    public static Item registerWithModGroup(String name) {
        return register(name, ModItemGroup.ERVIN_MOD_1_ITEMS);
    }

    public static Item register(String name, ItemGroup group) {
        return UnusedItems.registerDefault(name, new Item(new Item.Properties().group(group)));
    }

    public static Item register(String name, Item item) {
        return UnusedItems.registerDefault(name, item);
    }
}
