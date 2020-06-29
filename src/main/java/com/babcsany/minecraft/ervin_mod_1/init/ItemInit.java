package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.GretItem;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> SRIUNK_PICKAXE = ITEMS.register("sriunk_pickaxe", () -> new PickaxeItem(
            ModItemTier.SRIUNK, 8, 22.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK = ITEMS.register("sriunk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_AXE = ITEMS.register("sriunk_axe", () -> new AxeItem(
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
    public static final RegistryObject<Item> TERAT = ITEMS.register("terat", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_PICKAXE = ITEMS.register("terat_pickaxe", () -> new PickaxeItem(
            ModItemTier.TERAT, 200,200.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_AXE = ITEMS.register("terat_axe", () -> new AxeItem(
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
            ModItemTier.RED_COBBLESTONE, 2, -1.4F, (new Item.Properties())
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
    public static final RegistryObject<Item> RED_STONE_AXE = ITEMS.register("red_stone_axe", () -> new AxeItem(
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
    public static final RegistryObject<Item> FIRT_AXE = ITEMS.register("firt_axe", () -> new AxeItem(
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
    public static final RegistryObject<Item> ENDER_STAKRACH = ITEMS.register("ender_stakrach", () -> new AxeItem(
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
    public static final RegistryObject<Item> SURV_AXE = ITEMS.register("surv_axe", () -> new AxeItem(
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
}
