package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import com.babcsany.minecraft.ervin_mod_1.item.items.Sriunk;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredItem_1;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item AVTER = register("avter", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TERAT_BUCKET = register("terat/terat_bucket", new TeratBucket(() -> Fluids.EMPTY, (new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item WATER_TERAT_BUCKET = register("terat/water_terat_bucket", new TeratBucket(() -> Fluids.WATER, (new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item MILK_TERAT_BUCKET = register("terat/milk_terat_bucket", new MilkTeratBucketItem((new Item.Properties()).containerItem(TERAT_BUCKET).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item LAVA_TERAT_BUCKET = register("terat/lava_terat_bucket", new TeratBucket(() -> Fluids.LAVA, (new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item DURK = register("durk", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item SRIUNK = register("sriunk", new Sriunk(ModItemTier.SRIUNK, 13, new TieredItem_1.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item SRIFROUL = register("srifroul", new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item VILTDROP = register("viltdrop", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item SRIUNK_STICK = register("stick/sriunk_stick", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item LEAT = register("leat", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item NARIN = register("narin", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item NIRK = register("nirk", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item GRUGT = register("grugt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TIRSK = register("tirsk", new Item((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final Item GRUT = register("grut", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item GURF = register("gurf", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item SRIUNK_GRET = register("sriunk_gret", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item ZRIPT = register("zript", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item ZRIBT = register("zribt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item SHZ = register("shz", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item VILKT = register("vilkt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TERAT_GRET = register("terat/terat_gret", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TERAT_NUGGET = register("terat/terat_nugget", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item VIRKT = register("virkt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TRUGH = register("trugh", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TRUGK = register("trugk", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TRUGT = register("trugt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item GART = register("gart", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH),180000));
    public static final Item GARB = register("garb", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH),1620000));
    public static final Item GARK = register("gark", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH),14580000));
    public static final Item GARKT = register("garkt", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH),1180980000));
    public static final Item GARKTH = register("garkth", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH), (int) 18895680000L));
    public static final Item TRAGH = register("tragh", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH), (int) 170061120000L));
    public static final Item TRAGK = register("tragk", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH), (int) 1530550080000L));
    public static final Item TRAGT = register("tragt", new BurningItem((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH), (int) 612220032000000L));
    public static final Item GANKT = register("gankt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item GANKTH = register("gankth", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TNAGH = register("tnagh", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TNAGK = register("tnagk", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TNAGT = register("tnagt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item ZURKT = register("zurkt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item ZURKTH = register("zurkth", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TRUZH = register("truzh", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TRUZK = register("truzk", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TRUZT = register("truzt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item RUGT = register("rugt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item RUGB = register("rugb", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item RUGK = register("rugk", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item RUGKT = register("rugkt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item RUGKTH = register("rugkth", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TGURH = register("tgurh", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TGURK = register("tgurk", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item TGURT = register("tgurt", new Item((new Item.Properties()).isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item HUIHK_ROD = register("huihk_rod", new HuihkRodItem((new Item.Properties()).isImmuneToFire().maxDamage(3842).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item THUIRTH_DUST = register("thuirth_dust", new Item((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final Item TRITHK = register("trithk", new Item((new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS))));

    public static Item register(String name, Item item) {
        return UnusedItems.register(name, item);
    }
}
