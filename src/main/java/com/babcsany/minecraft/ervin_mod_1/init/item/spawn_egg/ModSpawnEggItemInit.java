package com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;

public class ModSpawnEggItemInit {

    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item SPAWN_EGG_1 = registerSpawnEgg("spawn_egg_1", ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS);
    public static final SpawnEggItem $_TRADER_SPAWN_EGG = registerSpawnEgg("usd_trader_spawn_egg", EntityInit.$_TRADER_ENTITY, 0x204080, 0x402080, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem SRACH_SPAWN_EGG = registerSpawnEgg("srach_spawn_egg", EntityInit.SRACH_ENTITY, 0x5016b4, 0xa056c4, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem FREIN_SPAWN_EGG = registerSpawnEgg("frein_spawn_egg", EntityInit.FREIN_ENTITY, 0x646464, 0x000000, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem GWURST_SPAWN_EGG = registerSpawnEgg("gwurst_spawn_egg", EntityInit.GWURST, 0x202020, 0x804020, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem DRURB_SPAWN_EGG = registerSpawnEgg("drurb_spawn_egg", EntityInit.DRURB_ENTITY, 0x202020, 0x804020, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem GUBROV_SPAWN_EGG = registerSpawnEgg("gubrov_spawn_egg", EntityInit.GUBROV, 0x202020, 0x804020, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem HHIJ_SPAWN_EGG = registerSpawnEgg("hhij_spawn_egg", EntityInit.HHIJ_ENTITY, 0x4040c0, 0x402080, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem LIWRAY_SPAWN_EGG = registerSpawnEgg("liwray_spawn_egg", EntityInit.LIWRAY, 0x5a8cc8, 0x3cd228, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem TRADER_NIRTRE_SPAWN_EGG = registerSpawnEgg("trader_nirtre_spawn_egg", EntityInit.TRADER_NIRTRE_ENTITY, 0x3c7828, 0x3c2850, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem VILT_SPAWN_EGG = registerSpawnEgg("vilt_spawn_egg", EntityInit.VILT_ENTITY, 0xc02020, 0xc02020, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem WANDERING_TRADER_NIRTRE_SPAWN_EGG = registerSpawnEgg("wandering_trader_nirtre_spawn_egg", EntityInit.WANDERING_TRADER_NIRTRE_ENTITY, 0x503c28, 0x283c50, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem ZOMBIE_TRADER_SPAWN_EGG = registerSpawnEgg("zombie_trader_spawn_egg", EntityInit.ZOMBIE_TRADER_ENTITY, 0x40c080, 0x20a0c0, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem ZUR_SPAWN_EGG = registerSpawnEgg("zur_spawn_egg", EntityInit.ZUR_ENTITY, 0x40c080, 0x20a0c0, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    public static final SpawnEggItem ROVENT_SPAWN_EGG = registerSpawnEgg("rovent_spawn_egg", EntityInit.ROVENT_ENTITY, 0x244830, 0x28384e, new Item.Properties());
    
    public static SpawnEggItem registerSpawnEgg(String name, EntityType<?> type, int primaryColorIn, int secondaryColorIn) {
        return registerSpawnEgg(name, type, primaryColorIn, secondaryColorIn, ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS);
    }
    
    public static SpawnEggItem registerSpawnEgg(String name, EntityType<?> type, int primaryColorIn, int secondaryColorIn, ItemGroup... groups) {
        Item.Properties properties = new Item.Properties();
        Arrays.stream(groups).forEachOrdered(properties::group);
        return registerSpawnEgg(name, type, primaryColorIn, secondaryColorIn, properties);
    }
    
    public static SpawnEggItem registerSpawnEgg(String name, EntityType<?> type, int primaryColorIn, int secondaryColorIn, Item.Properties builder) {
        return (SpawnEggItem) registerSpawnEgg(name, new SpawnEggItem(type, primaryColorIn, secondaryColorIn, builder));
    }
    
    public static Item registerSpawnEgg(String name, ItemGroup... groups) {
        Item.Properties properties = new Item.Properties();
        Arrays.stream(groups).forEachOrdered(properties::group);
        return registerSpawnEgg(name, properties);
    }
    
    public static Item registerSpawnEgg(String name) {
        return registerSpawnEgg(name, new Item.Properties());
    }
    
    public static Item registerSpawnEgg(String name, Item.Properties properties) {
        return registerSpawnEgg(name, new Item(properties));
    }
    
    public static Item registerSpawnEgg(String name, Item item) {
        return UnusedItems.registerDefault("spawn_eggs/" + name, item);
    }
}
