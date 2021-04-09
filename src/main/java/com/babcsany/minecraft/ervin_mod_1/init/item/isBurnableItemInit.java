package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<DefSpecialItem> DEF_ITEM = BURNABLE_ITEMS.register("def_item", () -> new DefSpecialItem(
            new Item.Properties().isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_PICKAXE = BURNABLE_ITEMS.register("sriunk_pickaxe", () -> new PickaxeItem(
            ModItemTier.SRIUNK, 8, 22.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK = BURNABLE_ITEMS.register("sriunk", () -> new Item(
            new Item.Properties().isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_AXE = BURNABLE_ITEMS.register("sriunk_axe", () -> new AxeItem(
            ModItemTier.SRIUNK, 20, 40.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_HOE = BURNABLE_ITEMS.register("sriunk_hoe", () -> new HoeItem(
            ModItemTier.SRIUNK, 6, 4.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_SHOVEL = BURNABLE_ITEMS.register("sriunk_shovel", () -> new ShovelItem(
            ModItemTier.SRIUNK, 12, 30.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_SWORD = BURNABLE_ITEMS.register("sriunk_sword", () -> new SwordItem(
            ModItemTier.SRIUNK, 15, 36.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_HELMET = BURNABLE_ITEMS.register("sriunk_helmet", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_CHESTPLATE = BURNABLE_ITEMS.register("sriunk_chestplate", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_LEGGINGS = BURNABLE_ITEMS.register("sriunk_leggings", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_BOOTS = BURNABLE_ITEMS.register("sriunk_boots", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> VILTDROP = BURNABLE_ITEMS.register("viltdrop", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_STICK = BURNABLE_ITEMS.register("sriunk_stick", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> LEAT = BURNABLE_ITEMS.register("leat", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NARIN = BURNABLE_ITEMS.register("narin", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_PICKAXE = BURNABLE_ITEMS.register("terat_pickaxe", () -> new PickaxeItem(
            ModItemTier.TERAT, 250,100.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_AXE = BURNABLE_ITEMS.register("terat_axe", () -> new AxeItem(
            ModItemTier.TERAT, 450,200.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_SHOVEL = BURNABLE_ITEMS.register("terat_shovel", () -> new ShovelItem(
            ModItemTier.TERAT, 350,150.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_HOE = BURNABLE_ITEMS.register("terat_hoe", () -> new HoeItem(
            ModItemTier.TERAT, 150, 50.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_HORSE_ARMOR = BURNABLE_ITEMS.register("sriunk_horse_armor", () -> new HorseArmorItem(
            44, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/sriunk_horse_armor.png"),
            (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_SWORD = BURNABLE_ITEMS.register("terat_sword", () -> new SwordItem(
            ModItemTier.TERAT, 300, 60.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_HELMET = BURNABLE_ITEMS.register("terat_helmet", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_CHESTPLATE = BURNABLE_ITEMS.register("terat_chestplate", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_LEGGINGS = BURNABLE_ITEMS.register("terat_leggings", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_BOOTS = BURNABLE_ITEMS.register("terat_boots", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK = BURNABLE_ITEMS.register("nirk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Firn> FIRN = BURNABLE_ITEMS.register("firn", () -> new Firn(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GRINT = BURNABLE_ITEMS.register("grint", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GRUGT = BURNABLE_ITEMS.register("grugt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GRUT = BURNABLE_ITEMS.register("grut", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GURF = BURNABLE_ITEMS.register("gurf", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> AVTER = BURNABLE_ITEMS.register("avter", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_GRET = BURNABLE_ITEMS.register("sriunk_gret", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> ZRIPT = BURNABLE_ITEMS.register("zript", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> ZRIBT = BURNABLE_ITEMS.register("zribt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TIRKS = BURNABLE_ITEMS.register("tirks", () -> new Item(
            (new Item.Properties()).food(Foods.TIRKS).isBurnable()
    ));
    public static final RegistryObject<Item> SHZ = BURNABLE_ITEMS.register("shz", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> VILKT = BURNABLE_ITEMS.register("vilkt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_GRET = BURNABLE_ITEMS.register("terat_gret", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_NUGGET = BURNABLE_ITEMS.register("terat_nugget", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_AXE = BURNABLE_ITEMS.register("nirk_axe", () -> new AxeItem(
            ModItemTier.NIRK, 160, 320.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_HOE = BURNABLE_ITEMS.register("nirk_hoe", () -> new HoeItem(
            ModItemTier.NIRK, 50, 64.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_PICKAXE = BURNABLE_ITEMS.register("nirk_pickaxe", () -> new PickaxeItem(
            ModItemTier.NIRK, 50, 105.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_SHOVEL = BURNABLE_ITEMS.register("nirk_shovel", () -> new ShovelItem(
            ModItemTier.NIRK, 120, 160.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_SWORD = BURNABLE_ITEMS.register("nirk_sword", () -> new SwordItem(
            ModItemTier.NIRK, 80, 256.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG = BURNABLE_ITEMS.register("durg", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_SWORD = BURNABLE_ITEMS.register("durg_sword", () -> new SwordItem(
            ModItemTier.DURG, 72, 113.4F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_AXE = BURNABLE_ITEMS.register("durg_axe", () -> new AxeItem(
            ModItemTier.DURG, 144, 189.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_SHOVEL = BURNABLE_ITEMS.register("durg_shovel", () -> new ShovelItem(
            ModItemTier.DURG, 108, 151.2F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_PICKAXE = BURNABLE_ITEMS.register("durg_pickaxe", () -> new PickaxeItem(
            ModItemTier.DURG, 36, 75.6F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_HOE = BURNABLE_ITEMS.register("durg_hoe", () -> new HoeItem(
            ModItemTier.DURG, 5, 10F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_HORSE_ARMOR = BURNABLE_ITEMS.register("terat_horse_armor", () -> new HorseArmorItem(
            880, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/terat_horse_armor.png"), (new Item.Properties()).maxStackSize(1).isBurnable().group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> DURG_HELMET = BURNABLE_ITEMS.register("durg_helmet", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURK = BURNABLE_ITEMS.register("durk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_CHESTPLATE = BURNABLE_ITEMS.register("durg_chestplate", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_LEGGINGS = BURNABLE_ITEMS.register("durg_leggings", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_BOOTS = BURNABLE_ITEMS.register("durg_boots", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_HORSE_ARMOR = BURNABLE_ITEMS.register("durg_horse_armor", () -> new HorseArmorItem(
            324, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/durg_horse_armor.png"), (new Item.Properties()).maxStackSize(1).isBurnable().group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> VIRKT = BURNABLE_ITEMS.register("virkt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Grith> GRITH = BURNABLE_ITEMS.register("grith", () -> new Grith(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Grithvsr> GRITHVSR = BURNABLE_ITEMS.register("grithvsr", () -> new Grithvsr(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Grithvsg> GRITHVSG = BURNABLE_ITEMS.register("grithvsg", () -> new Grithvsg(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGH = BURNABLE_ITEMS.register("trugh", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGK = BURNABLE_ITEMS.register("trugk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGT = BURNABLE_ITEMS.register("trugt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGN_AXE = BURNABLE_ITEMS.register("trugn_axe", () -> new AxeItem(
            ModItemTier.TRUGN, 6500, 4050.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGN_HOE = BURNABLE_ITEMS.register("trugn_hoe", () -> new HoeItem(
            ModItemTier.TRUGN, 1300, 810.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGN_PICKAXE = BURNABLE_ITEMS.register("trugn_pickaxe", () -> new PickaxeItem(
            ModItemTier.TRUGN, 2600, 1620.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGN_SHOVEL = BURNABLE_ITEMS.register("trugn_shovel", () -> new ShovelItem(
            ModItemTier.TRUGN, 5200, 3240.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGN_SWORD = BURNABLE_ITEMS.register("trugn_sword", () -> new SwordItem(
            ModItemTier.TRUGN, 3900, 2430.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GART = BURNABLE_ITEMS.register("gart", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GARB = BURNABLE_ITEMS.register("garb", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GARK = BURNABLE_ITEMS.register("gark", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GARKT = BURNABLE_ITEMS.register("garkt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GARKTH = BURNABLE_ITEMS.register("garkth", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGH = BURNABLE_ITEMS.register("tragh", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGK = BURNABLE_ITEMS.register("tragk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGT = BURNABLE_ITEMS.register("tragt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGN_AXE = BURNABLE_ITEMS.register("tragn_axe", () -> new AxeItem(
            ModItemTier.TRAGN, 650000, 405000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGN_HOE = BURNABLE_ITEMS.register("tragn_hoe", () -> new HoeItem(
            ModItemTier.TRAGN, 130000, 81000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGN_PICKAXE = BURNABLE_ITEMS.register("tragn_pickaxe", () -> new PickaxeItem(
            ModItemTier.TRAGN, 260000, 162000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGN_SHOVEL = BURNABLE_ITEMS.register("tragn_shovel", () -> new ShovelItem(
            ModItemTier.TRAGN, 520000, 324000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRAGN_SWORD = BURNABLE_ITEMS.register("tragn_sword", () -> new SwordItem(
            ModItemTier.TRAGN, 390000, 243000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GANKT = BURNABLE_ITEMS.register("gankt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GANKTH = BURNABLE_ITEMS.register("gankth", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TNAGH = BURNABLE_ITEMS.register("tnagh", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TNAGK = BURNABLE_ITEMS.register("tnagk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TNAGT = BURNABLE_ITEMS.register("tnagt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> ZURKT = BURNABLE_ITEMS.register("zurkt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> ZURKTH = BURNABLE_ITEMS.register("zurkth", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZH = BURNABLE_ITEMS.register("truzh", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZK = BURNABLE_ITEMS.register("truzk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZT = BURNABLE_ITEMS.register("truzt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZN_AXE = BURNABLE_ITEMS.register("truzn_axe", () -> new AxeItem(
            ModItemTier.TRUZN, 65000, 40500.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZN_HOE = BURNABLE_ITEMS.register("truzn_hoe", () -> new HoeItem(
            ModItemTier.TRUZN, 13000, 8100.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZN_PICKAXE = BURNABLE_ITEMS.register("truzn_pickaxe", () -> new PickaxeItem(
            ModItemTier.TRUGN, 26000, 16200.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZN_SHOVEL = BURNABLE_ITEMS.register("truzn_shovel", () -> new ShovelItem(
            ModItemTier.TRUZN, 52000, 32400.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUZN_SWORD = BURNABLE_ITEMS.register("truzn_sword", () -> new SwordItem(
            ModItemTier.TRUZN, 39000, 24300.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> RUGT = BURNABLE_ITEMS.register("rugt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> RUGB = BURNABLE_ITEMS.register("rugb", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> RUGK = BURNABLE_ITEMS.register("rugk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> RUGKT = BURNABLE_ITEMS.register("rugkt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> RUGKTH = BURNABLE_ITEMS.register("rugkth", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURH = BURNABLE_ITEMS.register("tgurh", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURK = BURNABLE_ITEMS.register("tgurk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURT = BURNABLE_ITEMS.register("tgurt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURN_AXE = BURNABLE_ITEMS.register("tgurn_axe", () -> new AxeItem(
            ModItemTier.TGURN, 11700000, 7290000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURN_HOE = BURNABLE_ITEMS.register("tgurn_hoe", () -> new HoeItem(
            ModItemTier.TGURN, 2340000, 1458000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURN_PICKAXE = BURNABLE_ITEMS.register("tgurn_pickaxe", () -> new PickaxeItem(
            ModItemTier.TGURN, 4680000, 2916000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURN_SHOVEL = BURNABLE_ITEMS.register("tgurn_shovel", () -> new ShovelItem(
            ModItemTier.TGURN, 9360000, 5832000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TGURN_SWORD = BURNABLE_ITEMS.register("tgurn_sword", () -> new SwordItem(
            ModItemTier.TGURN, 7020000, 4374000.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_1$ = BURNABLE_ITEMS.register("$/1$", () -> new $_1$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_2$ = BURNABLE_ITEMS.register("$/2$", () -> new $_2$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_3$ = BURNABLE_ITEMS.register("$/3$", () -> new $_3$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_4$ = BURNABLE_ITEMS.register("$/4$", () -> new $_4$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_5$ = BURNABLE_ITEMS.register("$/5$", () -> new $_5$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_6$ = BURNABLE_ITEMS.register("$/6$", () -> new $_6$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_7$ = BURNABLE_ITEMS.register("$/7$", () -> new $_7$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_8$ = BURNABLE_ITEMS.register("$/8$", () -> new $_8$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_9$ = BURNABLE_ITEMS.register("$/9$", () -> new $_9$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_10$ = BURNABLE_ITEMS.register("$/10$", () -> new $_10$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRURG_AXE = BURNABLE_ITEMS.register("srurg_axe", () -> new AxeItem(
            ModItemTier.SRURG, 6725, 3540.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRURG_HOE = BURNABLE_ITEMS.register("srurg_hoe", () -> new HoeItem(
            ModItemTier.SRURG, 461, 268.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRURG_PICKAXE = BURNABLE_ITEMS.register("srurg_pickaxe", () -> new PickaxeItem(
            ModItemTier.SRURG, 1356, 814.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRURG_SHOVEL = BURNABLE_ITEMS.register("srurg_shovel", () -> new ShovelItem(
            ModItemTier.SRURG, 4167, 2232.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRURG_SWORD = BURNABLE_ITEMS.register("srurg_sword", () -> new SwordItem(
            ModItemTier.SRURG, 2713, 1619.0F, (new Item.Properties()).isBurnable()
    ));
}
