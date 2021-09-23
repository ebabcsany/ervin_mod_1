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

    public static final RegistryObject<Item> AVTER = register("avter", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> AVTER1 = register("avter1", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TERAT_BUCKET = BURNABLE_ITEMS.register("terat_bucket", () -> new TeratBucket((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> WATER_TERAT_BUCKET = BURNABLE_ITEMS.register("water_terat_bucket", () -> new TeratBucket((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> LAVA_TERAT_BUCKET = BURNABLE_ITEMS.register("lava_terat_bucket", () -> new TeratBucket((new Item.Properties()).isBurnable().group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> DURK = register("durk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> SRIUNK = register("sriunk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> SRIFROUL = register("srifroul", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> VILTDROP = register("viltdrop", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> SRIUNK_STICK = register("stick/sriunk_stick", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> LEAT = register("leat", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> NARIN = register("narin", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    //public static final RegistryObject<ModBoatItem> FIRG_BOAT = BURNABLE_ITEMS.register("firg_boat", () -> new ModBoatItem(ModBoatEntityhj.ModBoatType.FIRG, (new Item.Properties()).isBurnable().maxStackSize(1).group(ItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> NIRK = register("nirk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> GRUGT = register("grugt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TIRSK = register("tirsk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> GRUT = register("grut", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> GURF = register("gurf", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> SRIUNK_GRET = register("sriunk_gret", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> ZRIPT = register("zript", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> ZRIBT = register("zribt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> SHZ = register("shz", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> VILKT = register("vilkt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TERAT_GRET = register("terat_gret", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TERAT_NUGGET = register("terat_nugget", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> VIRKT = register("virkt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TRUGH = register("trugh", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TRUGK = register("trugk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TRUGT = register("trugt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> GANKT = register("gankt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> GANKTH = register("gankth", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TNAGH = register("tnagh", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TNAGK = register("tnagk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TNAGT = register("tnagt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> ZURKT = register("zurkt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> ZURKTH = register("zurkth", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TRUZH = register("truzh", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TRUZK = register("truzk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TRUZT = register("truzt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> RUGT = register("rugt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> RUGB = register("rugb", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> RUGK = register("rugk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> RUGKT =  register("rugkt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> RUGKTH = register("rugkth", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TGURH = register("tgurh", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TGURK = register("tgurk", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> TGURT = register("tgurt", ItemGroup.ERVIN_MOD_1_ITEMS, ItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> HUIHK_ROD = BURNABLE_ITEMS.register("huihk_rod", () -> new HuihkRodItem((new Item.Properties()).isBurnable().maxDamage(3842).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> THUIRTH_DUST = register("thuirth_dust", ItemGroup.ERVIN_MOD_1_ITEMS);
    public static final RegistryObject<Item> TRITHK = register("trithk", ItemGroup.ERVIN_MOD_1_ITEMS);

    public static BurningItemInit BURNING_ITEMS = BurningItemInit.BURNING_ITEMS;
    public static isBurnableBlockItemInit_ BURNING_BLOCK_ITEMS = isBurnableBlockItemInit_.BURNING_BLOCK_ITEMS;

    private static RegistryObject<Item> register(String name) {
        return BURNABLE_ITEMS.register(name, () -> new Item((new Item.Properties().isBurnable())));
    }

    private static RegistryObject<Item> register(String name, net.minecraft.item.ItemGroup groupIn) {
        return BURNABLE_ITEMS.register(name, () -> new Item((new Item.Properties().isBurnable().group(groupIn))));
    }

    private static RegistryObject<Item> register(String name, net.minecraft.item.ItemGroup groupIn, net.minecraft.item.ItemGroup group1In) {
        return BURNABLE_ITEMS.register(name, () -> new Item((new Item.Properties().isBurnable().group(groupIn).group(group1In))));
    }

    private static RegistryObject<Item> registerBurningItem(String name, int burnTimeIn) {
        return BURNABLE_ITEMS.register(name, () -> new Item(new Item.Properties().isBurnable()) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }

    private static RegistryObject<Item> registerBurningItem(String name, net.minecraft.item.ItemGroup groupIn, int burnTimeIn) {
        return BURNABLE_ITEMS.register(name, () -> new Item(new Item.Properties().isBurnable().group(groupIn)) {
            @Override
            public int getBurnTime(ItemStack stack) {
                return burnTimeIn;
            }
        });
    }
}
