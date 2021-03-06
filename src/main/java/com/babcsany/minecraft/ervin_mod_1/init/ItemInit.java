package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.item.FirgBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.Items.BUCKET;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<SpecialItem> DEF_ITEM = ITEMS.register("def_item", () -> new SpecialItem(
            new Item.Properties()
    ));
    public static final RegistryObject<Item> SRIUNK_PICKAXE = ITEMS.register("sriunk_pickaxe", () -> new PickaxeItem(
            ModItemTier.SRIUNK, 8, 22.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK = ITEMS.register("sriunk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_AXE = ITEMS.register("sriunk_axe", () -> new AxeItem1(
            ModItemTier.SRIUNK, 20, 40.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_HOE = ITEMS.register("sriunk_hoe", () -> new HoeItem(
            ModItemTier.SRIUNK, 4.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_SHOVEL = ITEMS.register("sriunk_shovel", () -> new ShovelItem(
            ModItemTier.SRIUNK, 12, 30.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_SWORD = ITEMS.register("sriunk_sword", () -> new SwordItem(
            ModItemTier.SRIUNK, 15, 36.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_HELMET = ITEMS.register("sriunk_helmet", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.HEAD, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_CHESTPLATE = ITEMS.register("sriunk_chestplate", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.CHEST, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_LEGGINGS = ITEMS.register("sriunk_leggings", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.LEGS, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_BOOTS = ITEMS.register("sriunk_boots", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.FEET, (new Item.Properties())
    ));
    public static final RegistryObject<Item> VILTDROP = ITEMS.register("viltdrop", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_STICK = ITEMS.register("sriunk_stick", () -> new Item(
            (new Item.Properties())
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
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_PICKAXE = ITEMS.register("terat_pickaxe", () -> new PickaxeItem(
            ModItemTier.TERAT, 200,200.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_AXE = ITEMS.register("terat_axe", () -> new AxeItem1(
            ModItemTier.TERAT, 400,400.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_SHOVEL = ITEMS.register("terat_shovel", () -> new ShovelItem(
            ModItemTier.TERAT, 300,150.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_HOE = ITEMS.register("terat_hoe", () -> new HoeItem(
            ModItemTier.TERAT, 50.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_HORSE_ARMOR = ITEMS.register("sriunk_horse_armor", () -> new HorseArmorItem(
            44, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/sriunk_horse_armor.png"), (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> TERAT_SWORD = ITEMS.register("terat_sword", () -> new SwordItem(
            ModItemTier.TERAT, 250, 60.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_HELMET = ITEMS.register("terat_helmet", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.HEAD, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_CHESTPLATE = ITEMS.register("terat_chestplate", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.CHEST, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_LEGGINGS = ITEMS.register("terat_leggings", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.LEGS, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_BOOTS = ITEMS.register("terat_boots", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.FEET, (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRK = ITEMS.register("nirk", () -> new Item(
            (new Item.Properties())
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
    public static final RegistryObject<Item> FIRN = ITEMS.register("firn", () -> new Item(
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
            (new Item.Properties())
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
            (new Item.Properties()).food(FoodInit.VIRK)
    ));
    public static final RegistryObject<Item> RED_STONE_PICKAXE = ITEMS.register("red_stone_pickaxe", () -> new PickaxeItem(
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
            (new Item.Properties()).food(FoodInit.TIRKS)
    ));
    public static final RegistryObject<Item> SHZ = ITEMS.register("shz", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TIRSK = ITEMS.register("tirsk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> ZUR_ENTITY_SPAWN_EGG = ITEMS.register("zur_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ZUR_ENTITY, 0x6ea587, 0x446648, new Item.Properties()
    ));
    public static final RegistryObject<Item> KALT = ITEMS.register("kalt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> VILKT = ITEMS.register("vilkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_AXE = ITEMS.register("red_stone_axe", () -> new AxeItem1(
            ModItemTier.RED_COBBLESTONE, 14, 1.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_SHOVEL = ITEMS.register("red_stone_shovel", () -> new ShovelItem(
            ModItemTier.RED_COBBLESTONE,3, -1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_HOE = ITEMS.register("red_stone_hoe", () -> new HoeItem(
            ModItemTier.RED_COBBLESTONE, -1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_SWORD = ITEMS.register("red_stone_sword", () -> new SwordItem(
            ModItemTier.RED_COBBLESTONE, 6, -1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_AXE = ITEMS.register("firt_axe", () -> new AxeItem1(
            ModItemTier.FIRT, 16, 21.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_SHOVEL = ITEMS.register("firt_shovel", () -> new ShovelItem(
            ModItemTier.FIRT, 12, 16.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_HOE = ITEMS.register("firt_hoe", () -> new HoeItem(
            ModItemTier.FIRT, -1F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_SWORD = ITEMS.register("firt_sword", () -> new SwordItem(
            ModItemTier.FIRT, 8, 12.6F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_GRET = ITEMS.register("terat_gret", () -> new Item(
            (new Item.Properties())
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
            ModItemTier.NIRK, 50, 105.0F, (new Item.Properties())
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
            ModItemTier.ENDER_SRAKTCAF, 5F, (new Item.Properties())
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
            ModItemTier.SURV, 2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SURV_SWORD = ITEMS.register("surv_sword", () -> new SwordItem(
            ModItemTier.SURV, 15, 8.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_HORSE_ARMOR = ITEMS.register("firt_horse_armor", () -> new HorseArmorItem(
            36, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/firt_horse_armor.png"), (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> TERAT_NUGGET = ITEMS.register("terat_nugget", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRK_AXE = ITEMS.register("nirk_axe", () -> new AxeItem1(
            ModItemTier.NIRK, 160, 320.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRK_HOE = ITEMS.register("nirk_hoe", () -> new HoeItem(
            ModItemTier.NIRK, 64.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRK_SHOVEL = ITEMS.register("nirk_shovel", () -> new ShovelItem(
            ModItemTier.NIRK, 120, 160.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRK_SWORD = ITEMS.register("nirk_sword", () -> new SwordItem(
            ModItemTier.NIRK, 80, 256.0F, (new Item.Properties())
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
            ModItemTier.KIRT, 0.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_SHOVEL = ITEMS.register("kirt_shovel", () -> new ShovelItem(
            ModItemTier.KIRT, 1, 1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_SWORD = ITEMS.register("kirt_sword", () -> new SwordItem(
            ModItemTier.KIRT, 2, 2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG = ITEMS.register("durg", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_SWORD = ITEMS.register("durg_sword", () -> new SwordItem(
            ModItemTier.DURG, 72, 113.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_AXE = ITEMS.register("durg_axe", () -> new AxeItem1(
            ModItemTier.DURG, 144, 189.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_SHOVEL = ITEMS.register("durg_shovel", () -> new ShovelItem(
            ModItemTier.DURG, 108, 151.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_PICKAXE = ITEMS.register("durg_pickaxe", () -> new PickaxeItem(
            ModItemTier.DURG, 36, 75.6F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_HOE = ITEMS.register("durg_hoe", () -> new HoeItem(
            ModItemTier.DURG, 10F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_HORSE_ARMOR = ITEMS.register("terat_horse_armor", () -> new HorseArmorItem(
            440, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/terat_horse_armor.png"), (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)
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
            ModArmorMaterial.DURG, EquipmentSlotType.CHEST, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_LEGGINGS = ITEMS.register("durg_leggings", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.LEGS, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_BOOTS = ITEMS.register("durg_boots", () -> new ArmorItem(
            ModArmorMaterial.DURG, EquipmentSlotType.FEET, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURG_HORSE_ARMOR = ITEMS.register("durg_horse_armor", () -> new HorseArmorItem(
            324, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/durg_horse_armor.png"), (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)
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
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GARB = ITEMS.register("garb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GARK = ITEMS.register("gark", () -> new Item(
            (new Item.Properties())
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
    public static final RegistryObject<Item> FIRG_BOAT = ITEMS.register("firg_boat", () -> new FirgBoatItem(
            FirgBoatEntity.Type1.FIRG, (new Item.Properties()).maxStackSize(1)
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
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RUGB = ITEMS.register("rugb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RUGK = ITEMS.register("rugk", () -> new Item(
            (new Item.Properties())
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
            ModItemTier.DURT, 0.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURT_SHOVEL = ITEMS.register("durt_shovel", () -> new ShovelItem(
            ModItemTier.DURT, 11, 1.5F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> DURT_SWORD = ITEMS.register("durt_sword", () -> new SwordItem(
            ModItemTier.DURT, 8, 1.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_IRON_INGOT = ITEMS.register("black_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_INGOT = ITEMS.register("blue_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_IRON_INGOT = ITEMS.register("brown_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_IRON_INGOT = ITEMS.register("cyan_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRAY_IRON_INGOT = ITEMS.register("gray_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_IRON_INGOT = ITEMS.register("green_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_INGOT = ITEMS.register("light_blue_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_INGOT = ITEMS.register("light_gray_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_IRON_INGOT = ITEMS.register("lime_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_IRON_INGOT = ITEMS.register("magenta_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_IRON_INGOT = ITEMS.register("orange_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_IRON_INGOT = ITEMS.register("pink_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_IRON_INGOT = ITEMS.register("purple_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_IRON_INGOT = ITEMS.register("red_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_IRON_INGOT = ITEMS.register("yellow_iron_ingot", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> VILT_ENTITY_SPAWN_EGG = ITEMS.register("vilt_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.VILT_ENTITY, 0xc02020, 0xc02020, new Item.Properties()
    ));
    public static final RegistryObject<Item> TARG_SEEDS = ITEMS.register("targ_seeds", () -> new BlockNamedItem(
            BlockInit.TARG.get(), (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> SRACH_ENTITY_SPAWN_EGG = ITEMS.register("srach_entity_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.SRACH_ENTITY, 0x8000ff, 0x8000ff, new Item.Properties()
    ));
    public static final RegistryObject<Item> VIRKT = ITEMS.register("virkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(
            ModItemTier.OBSIDIAN, 2, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRITH = ITEMS.register("grith", () -> new SpecialItem1(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURKT = ITEMS.register("gurkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURKTH = ITEMS.register("gurkth", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TRUGH = ITEMS.register("trugh", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TRUGK = ITEMS.register("trugk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TRUGT = ITEMS.register("trugt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TRUGN_PICKAXE = ITEMS.register("trugn_pickaxe", () -> new PickaxeItem(
            ModItemTier.TRUGN, 2600, 1620.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg", () -> new SpawnEggItem(
            EntityType.GIANT, 7425368, 3462945, new Item.Properties()
    ));
    public static final RegistryObject<Item> ILLUSIONER_SPAWN_EGG = ITEMS.register("illusioner_spawn_egg", () -> new SpawnEggItem(
            EntityType.ILLUSIONER, 10574382, 10893626, new Item.Properties()
    ));
    public static final RegistryObject<Item> IRON_GOLEM_SPAWN_EGG = ITEMS.register("iron_golem_spawn_egg", () -> new SpawnEggItem(
            EntityType.IRON_GOLEM, 16777215, 5000268, new Item.Properties()
    ));
    public static final RegistryObject<Item> SNOW_GOLEM_SPAWN_EGG = ITEMS.register("snow_golem_spawn_egg", () -> new SpawnEggItem(
            EntityType.SNOW_GOLEM, 27649, 146359, new Item.Properties()
    ));
    public static final RegistryObject<Item> WITHER_SPAWN_EGG = ITEMS.register("wither_spawn_egg", () -> new SpawnEggItem(
            EntityType.WITHER, 1644825, 2468825, new Item.Properties()
    ));
    public static final RegistryObject<Item> ENDER_DRAGON_SPAWN_EGG = ITEMS.register("ender_dragon_spawn_egg", () -> new SpawnEggItem(
            EntityType.ENDER_DRAGON, 6741, 55263, new Item.Properties()
    ));
}
