package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.item.isBurnableBlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.burning.BurningItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.burning.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> AVTER = BURNABLE_ITEMS.register("avter", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> AVTER1 = BURNABLE_ITEMS.register("avter1", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TERAT_BUCKET = BURNABLE_ITEMS.register("terat_bucket", () -> new TeratBucket((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> WATER_TERAT_BUCKET = BURNABLE_ITEMS.register("water_terat_bucket", () -> new TeratBucket((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> LAVA_TERAT_BUCKET = BURNABLE_ITEMS.register("lava_terat_bucket", () -> new TeratBucket((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> DURK = BURNABLE_ITEMS.register("durk", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> SRIUNK = BURNABLE_ITEMS.register("sriunk", () -> new Item(new Item.Properties().isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> SRIFROUL = BURNABLE_ITEMS.register("srifroul", () -> new Item(new Item.Properties().isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> VILTDROP = BURNABLE_ITEMS.register("viltdrop", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> SRIUNK_STICK = BURNABLE_ITEMS.register("stick/sriunk_stick", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> LEAT = BURNABLE_ITEMS.register("leat", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> NARIN = BURNABLE_ITEMS.register("narin", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    //public static final RegistryObject<ModBoatItem> FIRG_BOAT = BURNABLE_ITEMS.register("firg_boat", () -> new ModBoatItem(ModBoatEntityhj.ModBoatType.FIRG, (new Item.Properties()).isBurnable().maxStackSize(1).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> NIRK = BURNABLE_ITEMS.register("nirk", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GRUGT = BURNABLE_ITEMS.register("grugt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TIRSK = BURNABLE_ITEMS.register("tirsk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> GRUT = BURNABLE_ITEMS.register("grut", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GURF = BURNABLE_ITEMS.register("gurf", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> SRIUNK_GRET = BURNABLE_ITEMS.register("sriunk_gret", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> ZRIPT = BURNABLE_ITEMS.register("zript", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> ZRIBT = BURNABLE_ITEMS.register("zribt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> SHZ = BURNABLE_ITEMS.register("shz", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> VILKT = BURNABLE_ITEMS.register("vilkt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TERAT_GRET = BURNABLE_ITEMS.register("terat_gret", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TERAT_NUGGET = BURNABLE_ITEMS.register("terat_nugget", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> VIRKT = BURNABLE_ITEMS.register("virkt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRUGH = BURNABLE_ITEMS.register("trugh", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRUGK = BURNABLE_ITEMS.register("trugk", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRUGT = BURNABLE_ITEMS.register("trugt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GANKT = BURNABLE_ITEMS.register("gankt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GANKTH = BURNABLE_ITEMS.register("gankth", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TNAGH = BURNABLE_ITEMS.register("tnagh", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TNAGK = BURNABLE_ITEMS.register("tnagk", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TNAGT = BURNABLE_ITEMS.register("tnagt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> ZURKT = BURNABLE_ITEMS.register("zurkt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> ZURKTH = BURNABLE_ITEMS.register("zurkth", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRUZH = BURNABLE_ITEMS.register("truzh", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRUZK = BURNABLE_ITEMS.register("truzk", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TRUZT = BURNABLE_ITEMS.register("truzt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> RUGT = BURNABLE_ITEMS.register("rugt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> RUGB = BURNABLE_ITEMS.register("rugb", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> RUGK = BURNABLE_ITEMS.register("rugk", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> RUGKT = BURNABLE_ITEMS.register("rugkt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> RUGKTH = BURNABLE_ITEMS.register("rugkth", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TGURH = BURNABLE_ITEMS.register("tgurh", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TGURK = BURNABLE_ITEMS.register("tgurk", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TGURT = BURNABLE_ITEMS.register("tgurt", () -> new Item((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> HUIHK_ROD = BURNABLE_ITEMS.register("huihk_rod", () -> new HuihkRodItem((new Item.Properties()).isBurnable().maxDamage(3842).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> THUIRTH_DUST = BURNABLE_ITEMS.register("thuirth_dust", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));
    public static final RegistryObject<Item> TRITHK = BURNABLE_ITEMS.register("trithk", () -> new Item((new Item.Properties().group(ItemGroup.ERVIN_MOD_1_ITEMS))));

    public static BurningItemInit BURNING_ITEMS = BurningItemInit.BURNING_ITEMS;
    public static isBurnableBlockItemInit_ BURNING_BLOCK_ITEMS = isBurnableBlockItemInit_.BURNING_BLOCK_ITEMS;
}
