package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.item.FirgBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.FoodInit;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

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
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(
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
    public static final RegistryObject<Item> BREND = ITEMS.register("brend", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SIRK = ITEMS.register("sirk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FRIT = ITEMS.register("frit", () -> new Item(
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
    public static final RegistryObject<Item> SCHRAFT = ITEMS.register("schraft", () -> new Item(
            (new Item.Properties())
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
    public static final RegistryObject<Item> RED_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/red_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.RED_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT_PICKAXE = ITEMS.register("firt_pickaxe", () -> new PickaxeItem(
            ModItemTier.FIRT, 4, 8.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PACK = ITEMS.register("pack", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TIRSK = ITEMS.register("tirsk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> ZUR_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/zur_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ZUR_ENTITY, 0x6ea587, 0x446648, new Item.Properties()
    ));
    public static final RegistryObject<Item> KALT = ITEMS.register("kalt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_AXE = ITEMS.register("stone/tools/axe/red_stone_axe", () -> new AxeItem(
            ModItemTier.RED_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/red_stone_shovel", () -> new ShovelItem(
            ModItemTier.RED_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_HOE = ITEMS.register("stone/tools/hoe/red_stone_hoe", () -> new HoeItem(
            ModItemTier.RED_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> RED_STONE_SWORD = ITEMS.register("stone/tools/sword/red_stone_sword", () -> new SwordItem(
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
    public static final RegistryObject<Item> SURV_PICKAXE = ITEMS.register("surv_pickaxe", () -> new PickaxeItem(
            ModItemTier.SURV, 10, 3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SURV_AXE = ITEMS.register("surv_axe", () -> new AxeItem(
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
    public static final RegistryObject<Item> CHAK = ITEMS.register("chak", () -> new Item(
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
    public static final RegistryObject<Item> ZUNKT = ITEMS.register("zunkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZUNKTH = ITEMS.register("zunkth", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TNUZT = ITEMS.register("tnuzt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TNUZH = ITEMS.register("tnuzh", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TNUZK = ITEMS.register("tnuzk", () -> new Item(
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
            (new Item.Properties())
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
            FirgBoatEntity.Type.FIRG, (new Item.Properties()).maxStackSize(1)
    ));
    public static final RegistryObject<Item> JURK_BUCKET = ITEMS.register("jurk_bucket", () -> new JurkBucketItem(
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
    public static final RegistryObject<ModSpawnEggItem> VILT_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/vilt_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.VILT_ENTITY, 0xc02020, 0xc02020, new Item.Properties()
    ));
    public static final RegistryObject<Item> TARG = ITEMS.register("targ", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<ModSpawnEggItem> SRACH_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/srach_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.SRACH_ENTITY, 0x8000ff, 0x8000ff, new Item.Properties()
    ));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(
            ModItemTier.OBSIDIAN, 2, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURT = ITEMS.register("gurt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURB = ITEMS.register("gurb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURK = ITEMS.register("gurk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURKT = ITEMS.register("gurkt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GURKTH = ITEMS.register("gurkth", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GANT = ITEMS.register("gant", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GANB = ITEMS.register("ganb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GANK = ITEMS.register("gank", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZURT = ITEMS.register("zurt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZURB = ITEMS.register("zurb", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> ZURK = ITEMS.register("zurk", () -> new Item(
            (new Item.Properties())
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
    public static final RegistryObject<Item> BLACK_STONE_AXE = ITEMS.register("stone/tools/axe/black_stone_axe", () -> new AxeItem(
            ModItemTier.BLACK_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_HOE = ITEMS.register("stone/tools/hoe/black_stone_hoe", () -> new HoeItem(
            ModItemTier.BLACK_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/black_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.BLACK_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/black_stone_shovel", () -> new ShovelItem(
            ModItemTier.BLACK_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLACK_STONE_SWORD = ITEMS.register("stone/tools/sword/black_stone_sword", () -> new SwordItem(
            ModItemTier.BLACK_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_AXE = ITEMS.register("stone/tools/axe/blue_stone_axe", () -> new AxeItem(
            ModItemTier.BLUE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_HOE = ITEMS.register("stone/tools/hoe/blue_stone_hoe", () -> new HoeItem(
            ModItemTier.BLUE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/blue_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.BLUE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/blue_stone_shovel", () -> new ShovelItem(
            ModItemTier.BLUE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_STONE_SWORD = ITEMS.register("stone/tools/sword/blue_stone_sword", () -> new SwordItem(
            ModItemTier.BLUE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_AXE = ITEMS.register("stone/tools/axe/brown_stone_axe", () -> new AxeItem(
            ModItemTier.BROWN_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_HOE = ITEMS.register("stone/tools/hoe/brown_stone_hoe", () -> new HoeItem(
            ModItemTier.BROWN_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/brown_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.BROWN_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/brown_stone_shovel", () -> new ShovelItem(
            ModItemTier.BROWN_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BROWN_STONE_SWORD = ITEMS.register("stone/tools/sword/brown_stone_sword", () -> new SwordItem(
            ModItemTier.BROWN_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_AXE = ITEMS.register("stone/tools/axe/cyan_stone_axe", () -> new AxeItem(
            ModItemTier.CYAN_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_HOE = ITEMS.register("stone/tools/hoe/cyan_stone_hoe", () -> new HoeItem(
            ModItemTier.CYAN_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/cyan_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.CYAN_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/cyan_stone_shovel", () -> new ShovelItem(
            ModItemTier.CYAN_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> CYAN_STONE_SWORD = ITEMS.register("stone/tools/sword/cyan_stone_sword", () -> new SwordItem(
            ModItemTier.CYAN_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_AXE = ITEMS.register("stone/tools/axe/green_stone_axe", () -> new AxeItem(
            ModItemTier.GREEN_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_HOE = ITEMS.register("stone/tools/hoe/green_stone_hoe", () -> new HoeItem(
            ModItemTier.GREEN_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/green_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.GREEN_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/green_stone_shovel", () -> new ShovelItem(
            ModItemTier.GREEN_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> GREEN_STONE_SWORD = ITEMS.register("stone/tools/sword/green_stone_sword", () -> new SwordItem(
            ModItemTier.GREEN_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_AXE = ITEMS.register("stone/tools/axe/light_blue_stone_axe", () -> new AxeItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_HOE = ITEMS.register("stone/tools/hoe/light_blue_stone_hoe", () -> new HoeItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/light_blue_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/light_blue_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE_STONE_SWORD = ITEMS.register("stone/tools/sword/light_blue_stone_sword", () -> new SwordItem(
            ModItemTier.LIGHT_BLUE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_AXE = ITEMS.register("stone/tools/axe/light_blue1_stone_axe", () -> new AxeItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_HOE = ITEMS.register("stone/tools/hoe/light_blue1_stone_hoe", () -> new HoeItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/light_blue1_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/light_blue1_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_STONE_SWORD = ITEMS.register("stone/tools/sword/light_blue1_stone_sword", () -> new SwordItem(
            ModItemTier.LIGHT_BLUE1_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_AXE = ITEMS.register("stone/tools/axe/light_gray_stone_axe", () -> new AxeItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_HOE = ITEMS.register("stone/tools/hoe/light_gray_stone_hoe", () -> new HoeItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/light_gray_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/light_gray_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_GRAY_STONE_SWORD = ITEMS.register("stone/tools/sword/light_gray_stone_sword", () -> new SwordItem(
            ModItemTier.LIGHT_GRAY_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_AXE = ITEMS.register("stone/tools/axe/lime_stone_axe", () -> new AxeItem(
            ModItemTier.LIME_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_HOE = ITEMS.register("stone/tools/hoe/lime_stone_hoe", () -> new HoeItem(
            ModItemTier.LIME_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/lime_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.LIME_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/lime_stone_shovel", () -> new ShovelItem(
            ModItemTier.LIME_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIME_STONE_SWORD = ITEMS.register("stone/tools/sword/lime_stone_sword", () -> new SwordItem(
            ModItemTier.LIME_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_AXE = ITEMS.register("stone/tools/axe/magenta_stone_axe", () -> new AxeItem(
            ModItemTier.MAGENTA_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_HOE = ITEMS.register("stone/tools/hoe/magenta_stone_hoe", () -> new HoeItem(
            ModItemTier.MAGENTA_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/magenta_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.MAGENTA_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/magenta_stone_shovel", () -> new ShovelItem(
            ModItemTier.MAGENTA_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> MAGENTA_STONE_SWORD = ITEMS.register("stone/tools/sword/magenta_stone_sword", () -> new SwordItem(
            ModItemTier.MAGENTA_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_AXE = ITEMS.register("stone/tools/axe/orange_stone_axe", () -> new AxeItem(
            ModItemTier.ORANGE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_HOE = ITEMS.register("stone/tools/hoe/orange_stone_hoe", () -> new HoeItem(
            ModItemTier.ORANGE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/orange_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.ORANGE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/orange_stone_shovel", () -> new ShovelItem(
            ModItemTier.ORANGE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ORANGE_STONE_SWORD = ITEMS.register("stone/tools/sword/orange_stone_sword", () -> new SwordItem(
            ModItemTier.ORANGE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_AXE = ITEMS.register("stone/tools/axe/pink_stone_axe", () -> new AxeItem(
            ModItemTier.PINK_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_HOE = ITEMS.register("stone/tools/hoe/pink_stone_hoe", () -> new HoeItem(
            ModItemTier.PINK_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/pink_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.PINK_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/pink_stone_shovel", () -> new ShovelItem(
            ModItemTier.PINK_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PINK_STONE_SWORD = ITEMS.register("stone/tools/sword/pink_stone_sword", () -> new SwordItem(
            ModItemTier.PINK_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_AXE = ITEMS.register("stone/tools/axe/purple_stone_axe", () -> new AxeItem(
            ModItemTier.PURPLE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_HOE = ITEMS.register("stone/tools/hoe/purple_stone_hoe", () -> new HoeItem(
            ModItemTier.PURPLE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/purple_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.PURPLE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/purple_stone_shovel", () -> new ShovelItem(
            ModItemTier.PURPLE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PURPLE_STONE_SWORD = ITEMS.register("stone/tools/sword/purple_stone_sword", () -> new SwordItem(
            ModItemTier.PURPLE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_AXE = ITEMS.register("stone/tools/axe/white_stone_axe", () -> new AxeItem(
            ModItemTier.WHITE_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_HOE = ITEMS.register("stone/tools/hoe/white_stone_hoe", () -> new HoeItem(
            ModItemTier.WHITE_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/white_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.WHITE_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/white_stone_shovel", () -> new ShovelItem(
            ModItemTier.WHITE_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> WHITE_STONE_SWORD = ITEMS.register("stone/tools/sword/white_stone_sword", () -> new SwordItem(
            ModItemTier.WHITE_COBBLESTONE, 3, -2.4F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_AXE = ITEMS.register("stone/tools/axe/yellow_stone_axe", () -> new AxeItem(
            ModItemTier.YELLOW_COBBLESTONE, 7.0F, -3.2F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_HOE = ITEMS.register("stone/tools/hoe/yellow_stone_hoe", () -> new HoeItem(
            ModItemTier.YELLOW_COBBLESTONE, -1, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_PICKAXE = ITEMS.register("stone/tools/pickaxe/yellow_stone_pickaxe", () -> new PickaxeItem(
            ModItemTier.YELLOW_COBBLESTONE, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_SHOVEL = ITEMS.register("stone/tools/shovel/yellow_stone_shovel", () -> new ShovelItem(
            ModItemTier.YELLOW_COBBLESTONE,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> YELLOW_STONE_SWORD = ITEMS.register("stone/tools/sword/yellow_stone_sword", () -> new SwordItem(
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
            ModItemTier.BLUE_IRON_INGOT, 6.0F, -3.1F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_HOE = ITEMS.register("tools/iron/hoe/blue_iron_hoe", () -> new HoeItem(
            ModItemTier.BLUE_IRON_INGOT, -2, -1.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_PICKAXE = ITEMS.register("tools/iron/pickaxe/blue_iron_pickaxe", () -> new PickaxeItem(
            ModItemTier.BLUE_IRON_INGOT, 1, -2.8F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_SHOVEL = ITEMS.register("tools/iron/shovel/blue_iron_shovel", () -> new ShovelItem(
            ModItemTier.BLUE_IRON_INGOT,1.5F, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> BLUE_IRON_SWORD = ITEMS.register("tools/iron/sword/blue_iron_sword", () -> new SwordItem(
            ModItemTier.BLUE_IRON_INGOT, 3, -2.4F, (new Item.Properties())
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
    public static final RegistryObject<ModSpawnEggItem> $_TRADER_SPAWN_EGG = ITEMS.register("spawn_eggs/$_trader_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.$_TRADER_ENTITY, 0x204080, 0x402080, new Item.Properties()
    ));
    public static final RegistryObject<ModSpawnEggItem> ZOMBIE_TRADER_SPAWN_EGG = ITEMS.register("spawn_eggs/zombie_trader_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ZOMBIE_TRADER_ENTITY, 0x40c080, 0x20a0c0, new Item.Properties()
    ));
    public static final RegistryObject<ModSpawnEggItem> ROVENT_SPAWN_EGG = ITEMS.register("spawn_eggs/rovent_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ROVENT_ENTITY, 0x244830, 0x28384e, new Item.Properties()
    ));
    //public static final RegistryObject<Item> COD_BUCKET = ITEMS.register("cod_bucket", new FishBucketItem(EntityInit.GUBROV_ENTITY.get(), Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> GUBROV_SPAWN_EGG = ITEMS.register("spawn_eggs/gubrov_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.GUBROV_ENTITY, 0x244830, 0x28384e, new Item.Properties()
    ));
    public static final RegistryObject<Item> GUBROV = ITEMS.register("gubrov", () -> new Gubrov(
            (new Item.Properties()).food(FoodInit.GUBROV)
    ));
    public static final RegistryObject<Item> COOKED_GUBROV = ITEMS.register("cooked_gubrov", () -> new Gubrov(
            (new Item.Properties()).food(FoodInit.COOKED_GUBROV)
    ));
    public static final RegistryObject<ModSpawnEggItem> HHIJ_SPAWN_EGG = ITEMS.register("spawn_eggs/wolf1_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.HHIJ_ENTITY, 0x4040c0, 0x402080, new Item.Properties()
    ));
    public static final RegistryObject<Item> JAZZ_FRUIT = ITEMS.register("jazz_fruit", () -> new Item(
            (new Item.Properties()).food(FoodInit.JAZZ_FRUIT)
    ));
    public static final RegistryObject<Item> SPAWN_EGG_1 = ITEMS.register("spawn_eggs/spawn_egg_1", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LIGHT_BLUE1_DYE = ITEMS.register("light_blue1_dye", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> STEEF = ITEMS.register("steef", () -> new Item(
            (new Item.Properties()).food(FoodInit.STEEF)
    ));
    public static final RegistryObject<Item> COOKED_STEEF = ITEMS.register("cooked_steef", () -> new Item(
            (new Item.Properties()).food(FoodInit.COOKED_STEEF)
    ));
    public static final RegistryObject<ModSpawnEggItem> FREIN_SPAWN_EGG = ITEMS.register("spawn_eggs/frein_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.FREIN_ENTITY, 0x000025, 0x00000050, new Item.Properties()
    ));
}
