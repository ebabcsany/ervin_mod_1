package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import com.babcsany.minecraft.ervin_mod_1.item.special.ModOperatorOnlyItem;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.item.FishBucketItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> JURK_BUCKET = registerBucket("jurk_bucket", FluidInit.JURK.orElse(Fluids.WATER), Items.BUCKET);
    public static final RegistryObject<Item> REGDEM = registerWithModGroup("regdem");
    public static final RegistryObject<Item> DREIN = registerWithModGroup("drein");
    public static final RegistryObject<Item> NIRG = registerWithModGroup("nirg");
    public static final RegistryObject<Item> KIRT = registerWithModGroup("kirt");
    public static final RegistryObject<Item> KIRT_STICK = registerWithModGroup("kirt_stick");
    public static final RegistryObject<Item> KIRT_STIK_STICK = registerWithModGroup("kirt_stik_stick");
    public static final RegistryObject<Item> KIRT_STIK = registerWithModGroup("kirt_stik");
    public static final RegistryObject<Item> RUBY = registerWithModGroup("ruby");
    public static final RegistryObject<Item> FRIN = registerWithModGroup("frin");
    public static final RegistryObject<Item> BREND = registerWithModGroup("brend");
    public static final RegistryObject<Item> SIRK = registerWithModGroup("sirk");
    public static final RegistryObject<Item> FRIT = registerWithModGroup("frit");
    public static final RegistryObject<Item> FIRK = registerWithModGroup("firk");
    public static final RegistryObject<Item> RASC = registerWithModGroup("rasc");
    public static final RegistryObject<Item> SACR = registerWithModGroup("sacr");
    public static final RegistryObject<Item> SCRA = registerWithModGroup("scra");
    public static final RegistryObject<Item> SRAC = registerWithModGroup("srac");
    public static final RegistryObject<Item> CRAST = registerWithModGroup("crast");
    public static final RegistryObject<Item> SRACT = registerWithModGroup("sract");
    public static final RegistryObject<Item> SRACH = registerWithModGroup("srach");
    public static final RegistryObject<Item> SARCT = registerWithModGroup("sarct");
    public static final RegistryObject<Item> SACHT = registerWithModGroup("sacht");
    public static final RegistryObject<Item> RASCH = registerWithModGroup("rasch");
    public static final RegistryObject<Item> RASCHT = registerWithModGroup("rascht");
    public static final RegistryObject<Item> SCRAF = registerWithModGroup("scraf");
    public static final RegistryObject<Item> SCRAFT = registerWithModGroup("scraft");
    public static final RegistryObject<Item> RAFTSH = registerWithModGroup("raftsh");
    public static final RegistryObject<Item> RAFTSC = registerWithModGroup("raftsc");
    public static final RegistryObject<Item> RAFTSCH = registerWithModGroup("raftsch");
    public static final RegistryObject<Item> SCHRAFT = registerWithModGroup("schraft");
    public static final RegistryObject<Item> ENDER_SCRAK = registerWithModGroup("ender_scrak");
    public static final RegistryObject<Item> ENDER_SCRAKT = registerWithModGroup("ender_scrakt");
    public static final RegistryObject<Item> ENDER_SRACKT = registerWithModGroup("ender_srackt");
    public static final RegistryObject<Item> END_STONE_STIK = registerWithModGroup("end_stone_stik");
    public static final RegistryObject<Item> PACK = registerWithModGroup("pack");
    public static final RegistryObject<Item> KALT = registerWithModGroup("kalt");
    public static final RegistryObject<Item> TRINK = registerWithModGroup("trink");
    public static final RegistryObject<Item> GNITH = registerWithModGroup("gnith");
    public static final RegistryObject<Item> GRITK = registerWithModGroup("gritk");
    public static final RegistryObject<Item> CHAK = registerWithModGroup("chak");
    public static final RegistryObject<Item> GURL = registerWithModGroup("gurl");
    public static final RegistryObject<Item> GRUV = registerWithModGroup("gruv");
    public static final RegistryObject<Item> GRUK = registerWithModGroup("gruk");
    public static final RegistryObject<Item> GRUKT = registerWithModGroup("grukt");
    public static final RegistryObject<Item> SCIK = registerWithModGroup("scik");
    public static final RegistryObject<Item> GURLT = registerWithModGroup("gurlt");
    public static final RegistryObject<Item> ENDER_CRAKTH = registerWithModGroup("ender_crakth");
    public static final RegistryObject<Item> ENDER_CRAKTHS = registerWithModGroup("ender_crakths");
    public static final RegistryObject<Item> CRAKH = registerWithModGroup("crakh");
    public static final RegistryObject<Item> BLACK_IRON_INGOT = registerWithModGroup("iron/ingots/black_iron_ingot");
    public static final RegistryObject<Item> BLUE_IRON_INGOT = registerWithModGroup("iron/ingots/blue_iron_ingot");
    public static final RegistryObject<Item> BROWN_IRON_INGOT = registerWithModGroup("iron/ingots/brown_iron_ingot");
    public static final RegistryObject<Item> CYAN_IRON_INGOT = registerWithModGroup("iron/ingots/cyan_iron_ingot");
    public static final RegistryObject<Item> GRAY_IRON_INGOT = registerWithModGroup("iron/ingots/gray_iron_ingot");
    public static final RegistryObject<Item> GREEN_IRON_INGOT = registerWithModGroup("iron/ingots/green_iron_ingot");
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_INGOT = registerWithModGroup("iron/ingots/light_blue1_iron_ingot");
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_INGOT = registerWithModGroup("iron/ingots/light_blue_iron_ingot");
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_INGOT = registerWithModGroup("iron/ingots/light_gray_iron_ingot");
    public static final RegistryObject<Item> LIME_IRON_INGOT = registerWithModGroup("iron/ingots/lime_iron_ingot");
    public static final RegistryObject<Item> MAGENTA_IRON_INGOT = registerWithModGroup("iron/ingots/magenta_iron_ingot");
    public static final RegistryObject<Item> ORANGE_IRON_INGOT = registerWithModGroup("iron/ingots/orange_iron_ingot");
    public static final RegistryObject<Item> PINK_IRON_INGOT = registerWithModGroup("iron/ingots/pink_iron_ingot");
    public static final RegistryObject<Item> PURPLE_IRON_INGOT = registerWithModGroup("iron/ingots/purple_iron_ingot");
    public static final RegistryObject<Item> RED_IRON_INGOT = registerWithModGroup("iron/ingots/red_iron_ingot");
    public static final RegistryObject<Item> WHITE_IRON_INGOT = registerWithModGroup("iron/ingots/white_iron_ingot");
    public static final RegistryObject<Item> YELLOW_IRON_INGOT = registerWithModGroup("iron/ingots/yellow_iron_ingot");
    public static final RegistryObject<Item> GURT = registerWithModGroup("gurt");
    public static final RegistryObject<Item> GURB = registerWithModGroup("gurb");
    public static final RegistryObject<Item> GURK = registerWithModGroup("gurk");
    public static final RegistryObject<Item> GURKT = registerWithModGroup("gurkt");
    public static final RegistryObject<Item> GURKTH = registerWithModGroup("gurkth");
    public static final RegistryObject<Item> GANT = registerWithModGroup("gant");
    public static final RegistryObject<Item> GANB = registerWithModGroup("ganb");
    public static final RegistryObject<Item> GANK = registerWithModGroup("gank");
    public static final RegistryObject<Item> ZURT = registerWithModGroup("zurt");
    public static final RegistryObject<Item> ZURB = registerWithModGroup("zurb");
    public static final RegistryObject<Item> ZURK = registerWithModGroup("zurk");
    public static final RegistryObject<Item> MLONK = registerWithModGroup("mlonk");
    public static final RegistryObject<Item> GWURST_FEATHER = registerWithModGroup("gwurst_feather");
    public static final RegistryObject<Item> HTRAW = registerWithModGroup("htraw");
    public static final RegistryObject<Item> LIGHT_BLUE1_DYE = register("light_blue1_dye", new ModDyeItem(ModDyeColor.LIGHT_BLUE1, (new Item.Properties()).group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> JURK_BUCKETI = register("jurk_buckett", new JurkBucketItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GUBROV_BUCKET = ITEMS.register("gubrov_bucket", () -> new FishBucketItem(EntityInit.GUBROV, () -> Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> DGUCHSR = register("dguchsr", new BurningItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS)), 3405));
    public static final RegistryObject<Item> TAWROL = register("tawrol", new TawrolItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> FREIN_BALL = register("frein_ball", new FreinballItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> SCRAKTHS_PEARL = register("scrakths_pearl", new ScrakthsPearlItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> TURG_SHIELD = register("turg_shield", new TurgShieldItem((new Item.Properties()).maxDamage(5000).group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> FIRT = ITEMS.register("firt", () -> new BurningItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS)), 2400));
    public static final RegistryObject<Item> HTRAW_MEAL = register("htraw_meal", new HtrawMealItem((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> EPKIN = ITEMS.register("epkin", () -> new ModOperatorOnlyItem(BlockItemInit_.EPKIN.get(), (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));

    private static RegistryObject<Item> registerFishBucket(String name, EntityType<?> type, Fluid fluid, ItemGroup group) {
        return register(name, new FishBucketItem(() -> type, () -> fluid, (new Item.Properties()).maxStackSize(1).group(group)));
    }

    private static RegistryObject<Item> registerBucket(String name, Fluid fluid, Item containerItem) {
        return register(name, new BucketItem(() -> fluid, (new Item.Properties()).containerItem(containerItem)));
    }

    public static RegistryObject<Item> registerWithModGroup(String name) {
        return register(name, ModItemGroup.ERVIN_MOD_1_ITEMS);
    }

    public static RegistryObject<Item> register(String name, ItemGroup group) {
        return UnusedItemInit.registryObject(ITEMS, name, () -> new Item(new Item.Properties().group(group)));
    }

    public static RegistryObject<Item> register(String name, Item item) {
        return UnusedItemInit.registryObject(ITEMS, name, () -> item);
    }
}
