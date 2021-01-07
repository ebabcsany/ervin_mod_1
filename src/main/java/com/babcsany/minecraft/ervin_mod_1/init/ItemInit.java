package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<SpecialItem> DEF_ITEM = ITEMS.register("def_item", () -> new SpecialItem(
            new Item.Properties().isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_PICKAXE = ITEMS.register("sriunk_pickaxe", () -> new PickaxeItem(
            ModItemTier.SRIUNK, 8, 22.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK = ITEMS.register("sriunk", () -> new Item(
            new Item.Properties().isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_AXE = ITEMS.register("sriunk_axe", () -> new AxeItem(
            ModItemTier.SRIUNK, 20, 40.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_HOE = ITEMS.register("sriunk_hoe", () -> new HoeItem(
            ModItemTier.SRIUNK, 6, 4.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_SHOVEL = ITEMS.register("sriunk_shovel", () -> new ShovelItem(
            ModItemTier.SRIUNK, 12, 30.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_SWORD = ITEMS.register("sriunk_sword", () -> new SwordItem(
            ModItemTier.SRIUNK, 15, 36.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_HELMET = ITEMS.register("sriunk_helmet", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_CHESTPLATE = ITEMS.register("sriunk_chestplate", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_LEGGINGS = ITEMS.register("sriunk_leggings", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_BOOTS = ITEMS.register("sriunk_boots", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> VILTDROP = ITEMS.register("viltdrop", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_STICK = ITEMS.register("sriunk_stick", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> REGDEM = ITEMS.register("regdem", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> DREIN = ITEMS.register("drein", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRG = ITEMS.register("nirg", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT = ITEMS.register("kirt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_STIK = ITEMS.register("kirt_stik", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LEAT = ITEMS.register("leat", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> CRAINT = ITEMS.register("craint", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> NARIN = ITEMS.register("narin", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT = ITEMS.register("terat", () -> new GItem(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_PICKAXE = ITEMS.register("terat_pickaxe", () -> new PickaxeItem(
            ModItemTier.TERAT, 200,200.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_AXE = ITEMS.register("terat_axe", () -> new AxeItem1(
            ModItemTier.TERAT, 400,400.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_SHOVEL = ITEMS.register("terat_shovel", () -> new ShovelItem(
            ModItemTier.TERAT, 300,150.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_HOE = ITEMS.register("terat_hoe", () -> new HoeItem(
            ModItemTier.TERAT, 100, 50.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SRIUNK_HORSE_ARMOR = ITEMS.register("sriunk_horse_armor", () -> new HorseArmorItem(
            44, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/sriunk_horse_armor.png"),
            (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_SWORD = ITEMS.register("terat_sword", () -> new SwordItem(
            ModItemTier.TERAT, 250, 60.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_HELMET = ITEMS.register("terat_helmet", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_CHESTPLATE = ITEMS.register("terat_chestplate", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_LEGGINGS = ITEMS.register("terat_leggings", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_BOOTS = ITEMS.register("terat_boots", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK = ITEMS.register("nirk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> FRIM = ITEMS.register("frim", () -> new Item(
            (new Item.Properties()).food(FoodInit.FRIM)
    ));
    public static final RegistryObject<Item> FRIN = ITEMS.register("frin", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT = ITEMS.register("firt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<SpecialItem2> FIRN = ITEMS.register("firn", () -> new SpecialItem2(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRINT = ITEMS.register("grint", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> BREND = ITEMS.register("brend", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SIRK = ITEMS.register("sirk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRG = ITEMS.register("firg", () -> new Item(
            (new Item.Properties()).food(FoodInit.FIRG)
    ));
    public static final RegistryObject<Item> AVTER = ITEMS.register("avter", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FRIT = ITEMS.register("frit", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_GRET = ITEMS.register("sriunk_gret", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> FIRK = ITEMS.register("firk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RASC = ITEMS.register("rasc", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SACR = ITEMS.register("sacr", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SCRA = ITEMS.register("scra", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRAC = ITEMS.register("srac", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> CRAST = ITEMS.register("crast", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRACT = ITEMS.register("sract", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRACH = ITEMS.register("srach", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SARCT = ITEMS.register("sarct", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SACHT = ITEMS.register("sacht", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RASCH = ITEMS.register("rasch", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RASCHT = ITEMS.register("rascht", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SCRAF = ITEMS.register("scraf", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SCRAFT = ITEMS.register("scraft", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RAFTSH = ITEMS.register("raftsh", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RAFTSC = ITEMS.register("raftsc", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RAFTSCH = ITEMS.register("raftsch", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SCRAFTH = ITEMS.register("scrafth", () -> new Item(
            (new Item.Properties()).food(FoodInit.SCRAFTH)
    ));
    public static final RegistryObject<Item> SCHRAFT = ITEMS.register("schraft", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_SRACKHT = ITEMS.register("ender_srackht", () -> new PickaxeItem(
            ModItemTier.ENDER_SRACKT, 0, 0.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_SCRAK = ITEMS.register("ender_scrak", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_SCRAKT = ITEMS.register("ender_scrakt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_SRACKT = ITEMS.register("ender_srackt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> END_STONE_STIK = ITEMS.register("end_stone_stik", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> VIRK = ITEMS.register("virk", () -> new Item(
            (new Item.Properties()).food(FoodInit.VIRK).isBurnable()
    ));
    public static final RegistryObject<Item> RED_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/red_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.RED_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_PICKAXE = ITEMS.register("firt_pickaxe", () -> new PickaxeItem(
            ModItemTier.FIRT, 4, 8.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> VIRK_BLOCK = ITEMS.register("virk_block", () -> new Item(
            (new Item.Properties()).food(FoodInit.VIRK_BLOCK)
    ));
    public static final RegistryObject<Item> ZRIPT = ITEMS.register("zript", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZRIBT = ITEMS.register("zribt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> PACK = ITEMS.register("pack", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TIRKS = ITEMS.register("tirks", () -> new Item(
            (new Item.Properties()).food(FoodInit.TIRKS).isBurnable()
    ));
    public static final RegistryObject<Item> SHZ = ITEMS.register("shz", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TIRSK = ITEMS.register("tirsk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> ZUR_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/zur_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ZUR_ENTITY, 0x6ea587, 0x446648, new Item.Properties()
    ));
    public static final RegistryObject<Item> KALT = ITEMS.register("kalt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> VILKT = ITEMS.register("vilkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_AXE = ITEMS.register("stone_axe/red_stone_axe", () -> new AxeItem(
            ModItemTier.RED_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_SHOVEL = ITEMS.register("stone_shovel/red_stone_shovel", () -> new ShovelItem(
            ModItemTier.RED_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_HOE = ITEMS.register("stone_hoe/red_stone_hoe", () -> new HoeItem(
            ModItemTier.RED_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_SWORD = ITEMS.register("stone_sword/red_stone_sword", () -> new SwordItem(
            ModItemTier.RED_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_AXE = ITEMS.register("firt_axe", () -> new AxeItem(
            ModItemTier.FIRT, 16, 21.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_SHOVEL = ITEMS.register("firt_shovel", () -> new ShovelItem(
            ModItemTier.FIRT, 12, 16.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_HOE = ITEMS.register("firt_hoe", () -> new HoeItem(
            ModItemTier.FIRT, 2, -1F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_SWORD = ITEMS.register("firt_sword", () -> new SwordItem(
            ModItemTier.FIRT, 8, 12.6F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_GRET = ITEMS.register("terat_gret", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> FIRT_HELMET = ITEMS.register("firt_helmet", () -> new ArmorItem(
            ModArmorMaterial.FIRT, EquipmentSlotType.HEAD, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_CHESTPLATE = ITEMS.register("firt_chestplate", () -> new ArmorItem(
            ModArmorMaterial.FIRT, EquipmentSlotType.CHEST, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_LEGGINGS = ITEMS.register("firt_leggings", () -> new ArmorItem(
            ModArmorMaterial.FIRT, EquipmentSlotType.LEGS, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_BOOTS = ITEMS.register("firt_boots", () -> new ArmorItem(
            ModArmorMaterial.FIRT, EquipmentSlotType.FEET, (new Item.Properties())
    ));
    public static final RegistryObject<Item> VOLMINT = ITEMS.register("volmint", () -> new Item(
            (new Item.Properties()).food(FoodInit.VOLMINT)
    ));
    public static final RegistryObject<Item> NIRK_PICKAXE = ITEMS.register("nirk_pickaxe", () -> new PickaxeItem(
            ModItemTier.NIRK, 50, 105.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> ENDER_STAKRACH = ITEMS.register("ender_stakrach", () -> new AxeItem1(
            ModItemTier.ENDER_SRACKHT, 2, 2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SURV_PICKAXE = ITEMS.register("surv_pickaxe", () -> new PickaxeItem(
            ModItemTier.SURV, 10, 3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_SRAKTCAF = ITEMS.register("ender_sraktcaf", () -> new ShovelItem(
            ModItemTier.ENDER_STAKRACH, 3, 4.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_TRASKRACH = ITEMS.register("ender_traskrach", () -> new HoeItem(
            ModItemTier.ENDER_SRAKTCAF, 1, 5F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_TRASKCRAFTH = ITEMS.register("ender_traskcrafth", () -> new SwordItem(
            ModItemTier.ENDER_TRASKRACH, 6, 6.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SURV_AXE = ITEMS.register("surv_axe", () -> new AxeItem1(
            ModItemTier.SURV, 30, 10.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SURV_SHOVEL = ITEMS.register("surv_shovel", () -> new ShovelItem(
            ModItemTier.SURV, 20, 5.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SURV_HOE = ITEMS.register("surv_hoe", () -> new HoeItem(
            ModItemTier.SURV, 5, 2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SURV_SWORD = ITEMS.register("surv_sword", () -> new SwordItem(
            ModItemTier.SURV, 15, 8.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_HORSE_ARMOR = ITEMS.register("firt_horse_armor", () -> new HorseArmorItem(
            36, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/firt_horse_armor.png"), (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> TERAT_NUGGET = ITEMS.register("terat_nugget", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_AXE = ITEMS.register("nirk_axe", () -> new AxeItem1(
            ModItemTier.NIRK, 160, 320.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_HOE = ITEMS.register("nirk_hoe", () -> new HoeItem(
            ModItemTier.NIRK, 50, 64.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_SHOVEL = ITEMS.register("nirk_shovel", () -> new ShovelItem(
            ModItemTier.NIRK, 120, 160.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> NIRK_SWORD = ITEMS.register("nirk_sword", () -> new SwordItem(
            ModItemTier.NIRK, 80, 256.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRINK = ITEMS.register("trink", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GNITH = ITEMS.register("gnith", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_STICK = ITEMS.register("kirt_stick", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_PICKAXE = ITEMS.register("kirt_pickaxe", () -> new PickaxeItem(
            ModItemTier.KIRT, 0, 1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRITK = ITEMS.register("gritk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_AXE = ITEMS.register("kirt_axe", () -> new AxeItem1(
            ModItemTier.KIRT, 3, 2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_HOE = ITEMS.register("kirt_hoe", () -> new HoeItem(
            ModItemTier.KIRT, 0, 0.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_SHOVEL = ITEMS.register("kirt_shovel", () -> new ShovelItem(
            ModItemTier.KIRT, 1, 1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_SWORD = ITEMS.register("kirt_sword", () -> new SwordItem(
            ModItemTier.KIRT, 2, 2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG = ITEMS.register("durg", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_SWORD = ITEMS.register("durg_sword", () -> new SwordItem(
            ModItemTier.DURG, 72, 113.4F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_AXE = ITEMS.register("durg_axe", () -> new AxeItem1(
            ModItemTier.DURG, 144, 189.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_SHOVEL = ITEMS.register("durg_shovel", () -> new ShovelItem(
            ModItemTier.DURG, 108, 151.2F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_PICKAXE = ITEMS.register("durg_pickaxe", () -> new PickaxeItem(
            ModItemTier.DURG, 36, 75.6F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_HOE = ITEMS.register("durg_hoe", () -> new HoeItem(
            ModItemTier.DURG, 5, 10F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TERAT_HORSE_ARMOR = ITEMS.register("terat_horse_armor", () -> new HorseArmorItem(
            440, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/terat_horse_armor.png"), (new Item.Properties()).maxStackSize(1).isBurnable().group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> CHAK = ITEMS.register("chak", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_HELMET = ITEMS.register("durg_helmet", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.HEAD, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURK = ITEMS.register("durk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_CHESTPLATE = ITEMS.register("durg_chestplate", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_LEGGINGS = ITEMS.register("durg_leggings", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_BOOTS = ITEMS.register("durg_boots", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> DURG_HORSE_ARMOR = ITEMS.register("durg_horse_armor", () -> new HorseArmorItem(
            324, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/durg_horse_armor.png"), (new Item.Properties()).maxStackSize(1).isBurnable().group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> GURT = ITEMS.register("gurt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURB = ITEMS.register("gurb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZURK = ITEMS.register("zurk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURK = ITEMS.register("gurk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURL = ITEMS.register("gurl", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRUV = ITEMS.register("gruv", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRUK = ITEMS.register("gruk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRUKT = ITEMS.register("grukt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRUGT = ITEMS.register("grugt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRUT = ITEMS.register("grut", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURF = ITEMS.register("gurf", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GART = ITEMS.register("gart", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GARB = ITEMS.register("garb", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GARK = ITEMS.register("gark", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> SCIK = ITEMS.register("scik", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZUNB = ITEMS.register("zunb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZUNK = ITEMS.register("zunk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZUNT = ITEMS.register("zunt", () -> new Item(
            (new Item.Properties()).food(FoodInit.ZUNT)
    ));
    public static final RegistryObject<Item> ZURB = ITEMS.register("zurb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZURT = ITEMS.register("zurt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURLT = ITEMS.register("gurlt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TURG_SHIELD = ITEMS.register("turg_shield", () -> new ShieldItem(
            (new Item.Properties())
                    .maxDamage(5000)
    ));
    public static final RegistryObject<Item> FREIN_BALL = ITEMS.register("frein_ball", () -> new FreinballItem(
            (new Item.Properties()).maxStackSize(16)
    ));
    public static final RegistryObject<Item> ENDER_CRAKTH = ITEMS.register("ender_crakth", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SCRAKTHS_PEARL = ITEMS.register("scrakths_pearl", () -> new ScrakthsPearlItem(
            (new Item.Properties()).maxStackSize(16)
    ));
    public static final RegistryObject<Item> ENDER_CRAKTHS = ITEMS.register("ender_crakths", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRG_BOAT = ITEMS.register("firg_boat", () -> new ModSpawnEggItem(
            EntityInit.FIRG_BOAT_ENTITY, 0xc8c8c8, 0xc8c8c8, new Item.Properties().maxStackSize(1)
    ));
    public static final RegistryObject<Item> GANT = ITEMS.register("gant", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GANK = ITEMS.register("gank", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GANB = ITEMS.register("ganb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> JURK_BUCKET = ITEMS.register("jurk_bucket", () -> new JurkBucketItem(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RUGT = ITEMS.register("rugt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> RUGB = ITEMS.register("rugb", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> RUGK = ITEMS.register("rugk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> CRAKH = ITEMS.register("crakh", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> REAT = ITEMS.register("reat", () -> new Item(
            (new Item.Properties()).food(FoodInit.REAT)
    ));
    public static final RegistryObject<Item> DURT_PICKAXE = ITEMS.register("durt_pickaxe", () -> new PickaxeItem(
            ModItemTier.DURT, 4, 1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURT_AXE = ITEMS.register("durt_axe", () -> new AxeItem(
            ModItemTier.DURT, 14, 2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURT_HOE = ITEMS.register("durt_hoe", () -> new HoeItem(
            ModItemTier.DURT, 1, 0.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURT_SHOVEL = ITEMS.register("durt_shovel", () -> new ShovelItem(
            ModItemTier.DURT, 11, 1.5F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURT_SWORD = ITEMS.register("durt_sword", () -> new SwordItem(
            ModItemTier.DURT, 8, 1.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_IRON_INGOT = ITEMS.register("iron/ingots/black_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_INGOT = ITEMS.register("iron/ingots/blue_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_IRON_INGOT = ITEMS.register("iron/ingots/brown_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_IRON_INGOT = ITEMS.register("iron/ingots/cyan_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRAY_IRON_INGOT = ITEMS.register("iron/ingots/gray_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_IRON_INGOT = ITEMS.register("iron/ingots/green_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_INGOT = ITEMS.register("iron/ingots/light_blue1_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_INGOT = ITEMS.register("iron/ingots/light_blue_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_INGOT = ITEMS.register("iron/ingots/light_gray_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_IRON_INGOT = ITEMS.register("iron/ingots/lime_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_IRON_INGOT = ITEMS.register("iron/ingots/magenta_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_IRON_INGOT = ITEMS.register("iron/ingots/orange_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_IRON_INGOT = ITEMS.register("iron/ingots/pink_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_IRON_INGOT = ITEMS.register("iron/ingots/purple_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_IRON_INGOT = ITEMS.register("iron/ingots/red_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_IRON_INGOT = ITEMS.register("iron/ingots/yellow_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> VILT_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/vilt_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.VILT_ENTITY, 0xc02020, 0xc02020, new Item.Properties()
    ));
    public static final RegistryObject<Item> TARG_SEEDS = ITEMS.register("seeds/targ_seeds", () -> new BlockNamedItem(
            BlockInit.TARG_STAGE.get(), (new Item.Properties())
    ));
    public static final RegistryObject<Item> TARG = ITEMS.register("targ", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> SRACH_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/srach_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.SRACH_ENTITY, 0x8000ff, 0x8000ff, new Item.Properties()
    ));
    public static final RegistryObject<Item> VIRKT = ITEMS.register("virkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(
            ModItemTier.OBSIDIAN, 2, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<SpecialItem1> GRITH = ITEMS.register("grith", () -> new SpecialItem1(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GURKT = ITEMS.register("gurkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURKTH = ITEMS.register("gurkth", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TRUGH = ITEMS.register("trugh", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGK = ITEMS.register("trugk", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGT = ITEMS.register("trugt", () -> new Item(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> TRUGN_PICKAXE = ITEMS.register("trugn_pickaxe", () -> new PickaxeItem(
            ModItemTier.TRUGN, 2600, 1620.0F, (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("spawn_eggs/giant_spawn_egg", () -> new SpawnEggItem(
            EntityType.GIANT, 7425368, 3462945, new Item.Properties()
    ));
    public static final RegistryObject<Item> ILLUSIONER_SPAWN_EGG = ITEMS.register("spawn_eggs/illusioner_spawn_egg", () -> new SpawnEggItem(
            EntityType.ILLUSIONER, 10574382, 10893626, new Item.Properties()
    ));
    public static final RegistryObject<Item> IRON_GOLEM_SPAWN_EGG = ITEMS.register("spawn_eggs/iron_golem_spawn_egg", () -> new SpawnEggItem(
            EntityType.IRON_GOLEM, 16777215, 5000268, new Item.Properties()
    ));
    public static final RegistryObject<Item> SNOW_GOLEM_SPAWN_EGG = ITEMS.register("spawn_eggs/snow_golem_spawn_egg", () -> new SpawnEggItem(
            EntityType.SNOW_GOLEM, 27649, 146359, new Item.Properties()
    ));
    public static final RegistryObject<Item> WITHER_SPAWN_EGG = ITEMS.register("spawn_eggs/wither_spawn_egg", () -> new SpawnEggItem(
            EntityType.WITHER, 1644825, 2468825, new Item.Properties()
    ));
    public static final RegistryObject<Item> ENDER_DRAGON_SPAWN_EGG = ITEMS.register("spawn_eggs/ender_dragon_spawn_egg", () -> new SpawnEggItem(
            EntityType.ENDER_DRAGON, 6741, 55263, new Item.Properties()
    ));
    public static final RegistryObject<Item> MLONK = ITEMS.register("mlonk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TRADER_NIRTRE_SPAWN_EGG = ITEMS.register("spawn_eggs/trader_nirtre_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.TRADER_NIRTRE_ENTITY, 0x3c7828, 0x3c2850, new Item.Properties()
    ));
    public static final RegistryObject<Item> WANDERING_TRADER_NIRTRE_SPAWN_EGG = ITEMS.register("spawn_eggs/wandering_trader_nirtre_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.WANDERING_TRADER_NIRTRE_ENTITY, 0x503c28, 0x283c50, new Item.Properties()
    ));
    public static final RegistryObject<Item> BLACK_STONE_AXE = ITEMS.register("stone/tools/stone_axe/black_stone_axe", () -> new AxeItem(
            ModItemTier.BLACK_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/black_stone_hoe", () -> new HoeItem(
            ModItemTier.BLACK_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/black_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.BLACK_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/black_stone_shovel", () -> new ShovelItem(
            ModItemTier.BLACK_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/black_stone_sword", () -> new SwordItem(
            ModItemTier.BLACK_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_AXE = ITEMS.register("stone/tools/stone_axe/blue_stone_axe", () -> new AxeItem(
            ModItemTier.BLUE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/blue_stone_hoe", () -> new HoeItem(
            ModItemTier.BLUE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/blue_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.BLUE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/blue_stone_shovel", () -> new ShovelItem(
            ModItemTier.BLUE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/blue_stone_sword", () -> new SwordItem(
            ModItemTier.BLUE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_AXE = ITEMS.register("stone/tools/stone_axe/brown_stone_axe", () -> new AxeItem(
            ModItemTier.BROWN_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/brown_stone_hoe", () -> new HoeItem(
            ModItemTier.BROWN_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/brown_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.BROWN_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/brown_stone_shovel", () -> new ShovelItem(
            ModItemTier.BROWN_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/brown_stone_sword", () -> new SwordItem(
            ModItemTier.BROWN_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_AXE = ITEMS.register("stone/tools/stone_axe/cyan_stone_axe", () -> new AxeItem(
            ModItemTier.CYAN_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/cyan_stone_hoe", () -> new HoeItem(
            ModItemTier.CYAN_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/cyan_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.CYAN_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/cyan_stone_shovel", () -> new ShovelItem(
            ModItemTier.CYAN_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/cyan_stone_sword", () -> new SwordItem(
            ModItemTier.CYAN_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_AXE = ITEMS.register("stone/tools/stone_axe/green_stone_axe", () -> new AxeItem(
            ModItemTier.GREEN_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/green_stone_hoe", () -> new HoeItem(
            ModItemTier.GREEN_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/green_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.GREEN_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/green_stone_shovel", () -> new ShovelItem(
            ModItemTier.GREEN_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/green_stone_sword", () -> new SwordItem(
            ModItemTier.GREEN_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_AXE = ITEMS.register("stone/tools/stone_axe/light_blue_stone_axe", () -> new AxeItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/light_blue_stone_hoe", () -> new HoeItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/light_blue_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/light_blue_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/light_blue_stone_sword", () -> new SwordItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_AXE = ITEMS.register("stone/tools/stone_axe/light_blue1_stone_axe", () -> new AxeItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/light_blue1_stone_hoe", () -> new HoeItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/light_blue1_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/light_blue1_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/light_blue1_stone_sword", () -> new SwordItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_AXE = ITEMS.register("stone/tools/stone_axe/light_gray_stone_axe", () -> new AxeItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_HOE = ITEMS.register("stone_hoe/light_gray_stone_hoe", () -> new HoeItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/light_gray_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/light_gray_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/light_gray_stone_sword", () -> new SwordItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_AXE = ITEMS.register("stone/tools/stone_axe/lime_stone_axe", () -> new AxeItem(
            ModItemTier.LIME_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/lime_stone_hoe", () -> new HoeItem(
            ModItemTier.LIME_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/lime_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIME_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/lime_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIME_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/lime_stone_sword", () -> new SwordItem(
            ModItemTier.LIME_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_AXE = ITEMS.register("stone/tools/stone_axe/magenta_stone_axe", () -> new AxeItem(
            ModItemTier.MAGENTA_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/magenta_stone_hoe", () -> new HoeItem(
            ModItemTier.MAGENTA_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/magenta_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.MAGENTA_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/magenta_stone_shovel", () -> new ShovelItem(
            ModItemTier.MAGENTA_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/magenta_stone_sword", () -> new SwordItem(
            ModItemTier.MAGENTA_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_AXE = ITEMS.register("stone/tools/stone_axe/orange_stone_axe", () -> new AxeItem(
            ModItemTier.ORANGE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/orange_stone_hoe", () -> new HoeItem(
            ModItemTier.ORANGE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/orange_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.ORANGE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/orange_stone_shovel", () -> new ShovelItem(
            ModItemTier.ORANGE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/orange_stone_sword", () -> new SwordItem(
            ModItemTier.ORANGE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_AXE = ITEMS.register("stone/tools/stone_axe/pink_stone_axe", () -> new AxeItem(
            ModItemTier.PINK_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/pink_stone_hoe", () -> new HoeItem(
            ModItemTier.PINK_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/pink_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.PINK_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/pink_stone_shovel", () -> new ShovelItem(
            ModItemTier.PINK_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/pink_stone_sword", () -> new SwordItem(
            ModItemTier.PINK_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_AXE = ITEMS.register("stone/tools/stone_axe/purple_stone_axe", () -> new AxeItem(
            ModItemTier.PURPLE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/purple_stone_hoe", () -> new HoeItem(
            ModItemTier.PURPLE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/purple_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.PURPLE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/purple_stone_shovel", () -> new ShovelItem(
            ModItemTier.PURPLE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/purple_stone_sword", () -> new SwordItem(
            ModItemTier.PURPLE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_AXE = ITEMS.register("stone/tools/stone_axe/white_stone_axe", () -> new AxeItem(
            ModItemTier.WHITE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/white_stone_hoe", () -> new HoeItem(
            ModItemTier.WHITE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/white_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.WHITE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/white_stone_shovel", () -> new ShovelItem(
            ModItemTier.WHITE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/white_stone_sword", () -> new SwordItem(
            ModItemTier.WHITE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_AXE = ITEMS.register("stone/tools/stone_axe/yellow_stone_axe", () -> new AxeItem(
            ModItemTier.YELLOW_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_HOE = ITEMS.register("stone/tools/stone_hoe/yellow_stone_hoe", () -> new HoeItem(
            ModItemTier.YELLOW_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_PICKAXE = ITEMS.register("stone/tools/stone_pickaxe/yellow_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.YELLOW_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_SHOVEL = ITEMS.register("stone/tools/stone_shovel/yellow_stone_shovel", () -> new ShovelItem(
            ModItemTier.YELLOW_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_SWORD = ITEMS.register("stone/tools/stone_sword/yellow_stone_sword", () -> new SwordItem(
            ModItemTier.YELLOW_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_IRON_AXE = ITEMS.register("tools/iron/axe/black_iron_axe", () -> new AxeItem(
            ModItemTier.BLACK_IRON_INGOT, 6.0F, -3.1F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_IRON_HOE = ITEMS.register("tools/iron/hoe/black_iron_hoe", () -> new HoeItem(
            ModItemTier.BLACK_IRON_INGOT, -2, -1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_IRON_PICKAXE = ITEMS.register("tools/iron/pickaxe/black_iron_pickaxe", () -> new PickaxeItem(
            ModItemTier.BLACK_IRON_INGOT, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_IRON_SHOVEL = ITEMS.register("tools/iron/shovel/black_iron_shovel", () -> new ShovelItem(
            ModItemTier.BLACK_IRON_INGOT,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_IRON_SWORD = ITEMS.register("tools/iron/sword/black_iron_sword", () -> new SwordItem(
            ModItemTier.BLACK_IRON_INGOT, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_AXE = ITEMS.register("tools/iron/axe/blue_iron_axe", () -> new AxeItem(
            ModItemTier.BLACK_IRON_INGOT, 6.0F, -3.1F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_HOE = ITEMS.register("tools/iron/hoe/blue_iron_hoe", () -> new HoeItem(
            ModItemTier.BLACK_IRON_INGOT, -2, -1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_PICKAXE = ITEMS.register("tools/iron/pickaxe/blue_iron_pickaxe", () -> new PickaxeItem(
            ModItemTier.BLACK_IRON_INGOT, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_SHOVEL = ITEMS.register("tools/iron/shovel/blue_iron_shovel", () -> new ShovelItem(
            ModItemTier.BLACK_IRON_INGOT,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_SWORD = ITEMS.register("tools/iron/sword/blue_iron_sword", () -> new SwordItem(
            ModItemTier.BLACK_IRON_INGOT, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_IRON_AXE = ITEMS.register("tools/iron/axe/red_iron_axe", () -> new AxeItem(
            ModItemTier.RED_IRON_INGOT, 6.0F, -3.1F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_IRON_HOE = ITEMS.register("tools/iron/hoe/red_iron_hoe", () -> new HoeItem(
            ModItemTier.RED_IRON_INGOT, -2, -1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_IRON_PICKAXE = ITEMS.register("tools/iron/pickaxe/red_iron_pickaxe", () -> new PickaxeItem(
            ModItemTier.RED_IRON_INGOT, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_IRON_SHOVEL = ITEMS.register("tools/iron/shovel/red_iron_shovel", () -> new ShovelItem(
            ModItemTier.RED_IRON_INGOT,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_IRON_SWORD = ITEMS.register("tools/iron/sword/red_iron_sword", () -> new SwordItem(
            ModItemTier.RED_IRON_INGOT, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> $_1$ = ITEMS.register("$/1$", () -> new $_1$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_2$ = ITEMS.register("$/2$", () -> new $_2$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_3$ = ITEMS.register("$/3$", () -> new $_3$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_4$ = ITEMS.register("$/4$", () -> new $_4$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_5$ = ITEMS.register("$/5$", () -> new $_5$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_6$ = ITEMS.register("$/6$", () -> new $_6$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_7$ = ITEMS.register("$/7$", () -> new $_7$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_8$ = ITEMS.register("$/8$", () -> new $_8$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_9$ = ITEMS.register("$/9$", () -> new $_9$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<Item> $_10$ = ITEMS.register("$/10$", () -> new $_10$(
            (new Item.Properties()).isBurnable()
    ));
    public static final RegistryObject<ModSpawnEggItem> $_TRADER_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/$_trader_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.$_TRADER_ENTITY, 0x204080, 0x402080, new Item.Properties()
    ));
    public static final RegistryObject<ModSpawnEggItem> ZOMBIE_TRADER_SPAWN_EGG = ITEMS.register("spawn_eggs/zombie_trader_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ZOMBIE_TRADER_ENTITY, 0x40c080, 0x20a0c0, new Item.Properties()
    ));
    public static final RegistryObject<ModSpawnEggItem> ROVENT_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/rovent_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ROVENT_ENTITY, 0x244830, 0x28384e, new Item.Properties()
    ));
    //public static final RegistryObject<Item> COD_BUCKET = ITEMS.register("cod_bucket", new FishBucketItem(EntityInit.GUBROV_ENTITY.get(), Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> GUBROV_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/gubrov_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.GUBROV_ENTITY, 0x244830, 0x28384e, new Item.Properties()
    ));
    public static final RegistryObject<Item> GUBROV = ITEMS.register("gubrov", () -> new Gubrov(
            (new Item.Properties()).food(FoodInit.GUBROV)
    ));
    public static final RegistryObject<Item> HHIJ_SPAWN_EGG = ITEMS.register("spawn_eggs/wolf1_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.HHIJ_ENTITY, 0x4040c0, 0x402080, new Item.Properties()
    ));
    public static final RegistryObject<Item> JAZZ_FRUIT = ITEMS.register("jazz_fruit", () -> new Item(
            (new Item.Properties()).food(FoodInit.JAZZ_FRUIT)
    ));
    public static final RegistryObject<Item> SPAWN_EGG_1 = ITEMS.register("spawn_egg_1", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_DYE = ITEMS.register("light_blue1_dye", () -> new Item(
            (new Item.Properties())
    ));
}
