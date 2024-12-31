package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import com.babcsany.minecraft.ervin_mod_1.item.items.Sriunk;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredItem_1;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.CompassItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> AVTER;
    public static final RegistryObject<Item> TERAT_BUCKET;
    public static final RegistryObject<Item> WATER_TERAT_BUCKET;
    public static final RegistryObject<Item> MILK_TERAT_BUCKET;
    public static final RegistryObject<Item> LAVA_TERAT_BUCKET;
    public static final RegistryObject<Item> DURK;
    public static final RegistryObject<Item> SRIUNK;
    public static final RegistryObject<Item> SRIFROUL;
    public static final RegistryObject<Item> VILTDROP;
    public static final RegistryObject<Item> SRIUNK_STICK;
    public static final RegistryObject<Item> LEAT;
    public static final RegistryObject<Item> NARIN;
    public static final RegistryObject<Item> NIRK;
    public static final RegistryObject<Item> GRUGT;
    public static final RegistryObject<Item> TIRSK;
    public static final RegistryObject<Item> GRUT;
    public static final RegistryObject<Item> GURF;
    public static final RegistryObject<Item> SRIUNK_GRET;
    public static final RegistryObject<Item> ZRIPT;
    public static final RegistryObject<Item> ZRIBT;
    public static final RegistryObject<Item> SHZ;
    public static final RegistryObject<Item> VILKT;
    public static final RegistryObject<Item> TERAT_GRET;
    public static final RegistryObject<Item> TERAT_NUGGET;
    public static final RegistryObject<Item> VIRKT;
    public static final RegistryObject<Item> TRUGH;
    public static final RegistryObject<Item> TRUGK;
    public static final RegistryObject<Item> TRUGT;
    public static final RegistryObject<Item> GART;
    public static final RegistryObject<Item> GARB;
    public static final RegistryObject<Item> GARK;
    public static final RegistryObject<Item> GARKT;
    public static final RegistryObject<Item> GARKTH;
    public static final RegistryObject<Item> TRAGH;
    public static final RegistryObject<Item> TRAGK;
    public static final RegistryObject<Item> TRAGT;
    public static final RegistryObject<Item> GANKT;
    public static final RegistryObject<Item> GANKTH;
    public static final RegistryObject<Item> TNAGH;
    public static final RegistryObject<Item> TNAGK;
    public static final RegistryObject<Item> TNAGT;
    public static final RegistryObject<Item> ZURKT;
    public static final RegistryObject<Item> ZURKTH;
    public static final RegistryObject<Item> TRUZH;
    public static final RegistryObject<Item> TRUZK;
    public static final RegistryObject<Item> TRUZT;
    public static final RegistryObject<Item> RUGT;
    public static final RegistryObject<Item> RUGB;
    public static final RegistryObject<Item> RUGK;
    public static final RegistryObject<Item> RUGKT;
    public static final RegistryObject<Item> RUGKTH;
    public static final RegistryObject<Item> TGURH;
    public static final RegistryObject<Item> TGURK;
    public static final RegistryObject<Item> TGURT;
    public static final RegistryObject<Item> HUIHK_ROD;
    public static final RegistryObject<Item> THUIRTH_DUST;
    public static final RegistryObject<Item> TRITHK;

    public static <T extends Item> RegistryObject<Item> register(String name, T item) {
        return UnusedItemInit.registryObject(BURNABLE_ITEMS, name, () -> item);
    }

    public static RegistryObject<Item> register(String name, Item.Properties properties) {
        return register(name, new Item(properties.group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    }

    public static RegistryObject<Item> register(String name) {
        return register(name, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS));
    }

    public static RegistryObject<Item> registerSmeltable(String name, Item.Properties properties, int burningTime) {
        return register(name, new BurningItem(properties, burningTime));
    }

    public static RegistryObject<Item> registerBurnable(String name, Item.Properties properties) {
        return register(name, properties.isImmuneToFire());
    }

    public static RegistryObject<Item> registerSmeltable(String name, int burningTime) {
        return registerSmeltable(name, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS), burningTime);
    }

    public static RegistryObject<Item> registerBurnable(String name) {
        return registerBurnable(name, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS));
    }

    public static RegistryObject<Item> registerBurnAndSmeltable(String name, int burningTime) {
        return registerSmeltable(name, new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS), burningTime);
    }

    static {
        AVTER = registerBurnable("avter");
        TERAT_BUCKET = BURNABLE_ITEMS.register("terat/terat_bucket", () -> new TeratBucket(() -> Fluids.EMPTY, (new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
        WATER_TERAT_BUCKET = register("terat/water_terat_bucket", new TeratBucket(() -> Fluids.WATER, (new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
        MILK_TERAT_BUCKET = register("terat/milk_terat_bucket", new MilkTeratBucketItem((new Item.Properties()).containerItem(TERAT_BUCKET.orElse(Items.AIR)).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
        LAVA_TERAT_BUCKET = register("terat/lava_terat_bucket", new TeratBucket(() -> Fluids.LAVA, (new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
        DURK = registerBurnable("durk");
        SRIUNK = BURNABLE_ITEMS.register("sriunk", () -> new Sriunk(ModItemTier.SRIUNK, 13, new TieredItem_1.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
        SRIFROUL = register("srifroul", new CompassItem(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
        VILTDROP = registerBurnable("viltdrop");
        SRIUNK_STICK = registerBurnable("stick/sriunk_stick");
        LEAT = registerBurnable("leat");
        NARIN = registerBurnable("narin");
        NIRK = registerBurnable("nirk");
        GRUGT = registerBurnable("grugt");
        TIRSK = register("tirsk");
        GRUT = registerBurnable("grut");
        GURF = registerBurnable("gurf");
        SRIUNK_GRET = registerBurnable("sriunk_gret");
        ZRIPT = registerBurnable("zript");
        ZRIBT = registerBurnable("zribt");
        SHZ = registerBurnable("shz");
        VILKT = registerBurnable("vilkt");
        TERAT_GRET = registerBurnable("terat/terat_gret");
        TERAT_NUGGET = registerBurnable("terat/terat_nugget");
        VIRKT = registerBurnable("virkt");
        TRUGH = registerBurnable("trugh");
        TRUGK = registerBurnable("trugk");
        TRUGT = registerBurnable("trugt");
        GART = registerBurnAndSmeltable("gart",180000);
        GARB = registerBurnAndSmeltable("garb",1620000);
        GARK = registerBurnAndSmeltable("gark",14580000);
        GARKT = registerBurnAndSmeltable("garkt",1180980000);
        GARKTH = registerBurnAndSmeltable("garkth", (int) 18895680000L);
        TRAGH = registerBurnAndSmeltable("tragh", (int) 170061120000L);
        TRAGK = registerBurnAndSmeltable("tragk", (int) 1530550080000L);
        TRAGT = registerBurnAndSmeltable("tragt", (int) 612220032000000L);
        GANKT = registerBurnable("gankt");
        GANKTH = registerBurnable("gankth");
        TNAGH = registerBurnable("tnagh");
        TNAGK = registerBurnable("tnagk");
        TNAGT = registerBurnable("tnagt");
        ZURKT = registerBurnable("zurkt");
        ZURKTH = registerBurnable("zurkth");
        TRUZH = registerBurnable("truzh");
        TRUZK = registerBurnable("truzk");
        TRUZT = registerBurnable("truzt");
        RUGT = registerBurnable("rugt");
        RUGB = registerBurnable("rugb");
        RUGK = registerBurnable("rugk");
        RUGKT = registerBurnable("rugkt");
        RUGKTH = registerBurnable("rugkth");
        TGURH = registerBurnable("tgurh");
        TGURK = registerBurnable("tgurk");
        TGURT = registerBurnable("tgurt");
        HUIHK_ROD = register("huihk_rod", new HuihkRodItem((new Item.Properties()).isImmuneToFire().maxDamage(3842).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
        THUIRTH_DUST = register("thuirth_dust");
        TRITHK = register("trithk");
    }
}
