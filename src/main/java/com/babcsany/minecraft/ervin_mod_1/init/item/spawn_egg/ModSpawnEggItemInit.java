package com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;

public class ModSpawnEggItemInit {

    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> SPAWN_EGG_1 = SPAWN_EGGS.register("spawn_egg_1", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> $_TRADER = SPAWN_EGGS.register("usd_trader_spawn_egg", () -> new SpawnEggItem(EntityInit.$_TRADER.get(), 0x204080, 0x402080, new Item.Properties()));
    public static final RegistryObject<Item> SRACH_SPAWN_EGG = SPAWN_EGGS.register("srach_spawn_egg", () -> new SpawnEggItem(EntityInit.SRACH_ENTITY.get(), 0x5016b4, 0xa056c4, new Item.Properties()));
    public static final RegistryObject<Item> FREIN_SPAWN_EGG = SPAWN_EGGS.register("frein_spawn_egg", () -> new SpawnEggItem(EntityInit.FREIN.get(), 0x646464, 0x245f6b, new Item.Properties()));
    public static final RegistryObject<Item> GWURST_SPAWN_EGG = SPAWN_EGGS.register("gwurst_spawn_egg", () -> new SpawnEggItem(EntityInit.GWURST.get(), 0x202020, 0x804020, new Item.Properties()));
    public static final RegistryObject<Item> DRURB_SPAWN_EGG = SPAWN_EGGS.register("drurb_spawn_egg", () -> new SpawnEggItem(EntityInit.DGRURB.get(), 0x202020, 0x804020, new Item.Properties()));
    public static final RegistryObject<Item> GUBROV_SPAWN_EGG = SPAWN_EGGS.register("gubrov_spawn_egg", () -> new SpawnEggItem(EntityInit.GUBROV.get(), 0x202020, 0x804020, new Item.Properties()));
    public static final RegistryObject<Item> HHIJ_SPAWN_EGG = SPAWN_EGGS.register("hhij_spawn_egg", () -> new SpawnEggItem(EntityInit.HHIJ.get(), 0x4040c0, 0x402080, new Item.Properties()));
    public static final RegistryObject<Item> LIWRAY_SPAWN_EGG = SPAWN_EGGS.register("liwray_spawn_egg", () -> new SpawnEggItem(EntityInit.LIWRAY.get(), 0x5a8cc8, 0x3cd228, new Item.Properties()));
    public static final RegistryObject<Item> TRADER_NIRTRE_SPAWN_EGG = SPAWN_EGGS.register("trader_nirtre_spawn_egg", () -> new SpawnEggItem(EntityInit.TRADER_NIRTRE_ENTITY.get(), 0x3c7828, 0x3c2850, new Item.Properties()));
    public static final RegistryObject<Item> VILT = SPAWN_EGGS.register("vilt_spawn_egg", () -> new SpawnEggItem(EntityInit.VILT.get(), 0xc02020, 0xc02020, new Item.Properties()));
    public static final RegistryObject<Item> WANDERING_TRADER_NIRTRE = SPAWN_EGGS.register("wandering_trader_nirtre", () -> new SpawnEggItem(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), 0x503c28, 0x283c50, new Item.Properties()));
    public static final RegistryObject<Item> ZOMBIE_TRADER_SPAWN_EGG = SPAWN_EGGS.register("zombie_trader_spawn_egg", () -> new SpawnEggItem(EntityInit.ZOMBIE_TRADER_ENTITY.get(), 0x40c080, 0x20a0c0, new Item.Properties()));
    public static final RegistryObject<Item> ZUR_SPAWN_EGG = SPAWN_EGGS.register("zur_spawn_egg", () -> new SpawnEggItem(EntityInit.ZUR.get(), 0x40c080, 0x20a0c0, new Item.Properties().isImmuneToFire()));
    public static final RegistryObject<Item> ROVENT_SPAWN_EGG = SPAWN_EGGS.register("rovent_spawn_egg", () -> new SpawnEggItem(EntityInit.ROVENT_ENTITY.get(), 0x244830, 0x28384e, new Item.Properties()));

    public static RegistryObject<Item> registerSpawnEgg(String name, EntityType<?> type, int primaryColorIn, int secondaryColorIn) {
        return registerSpawnEgg(name, type, primaryColorIn, secondaryColorIn, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    }
    
    public static RegistryObject<Item> registerSpawnEgg(String name, EntityType<?> type, int primaryColorIn, int secondaryColorIn, Item.Properties builder) {
        return registerSpawnEgg(name, new SpawnEggItem(type, primaryColorIn, secondaryColorIn, builder));
    }
    
    public static RegistryObject<Item> registerSpawnEggWithGroup(String name) {
        return registerSpawnEgg(name, ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS);
    }

    public static RegistryObject<Item> registerSpawnEgg(String name) {
        return registerSpawnEgg(name, new Item.Properties());
    }

    public static RegistryObject<Item> registerSpawnEgg(String name, ItemGroup... groups) {
        return registerSpawnEgg(name, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SPAWN_EGGS));
    }

    public static RegistryObject<Item> registerSpawnEgg(String name, Item.Properties properties) {
        return registerSpawnEgg(name, new Item(properties));
    }
    
    public static RegistryObject<Item> registerSpawnEgg(String name, Item item) {
        return SPAWN_EGGS.register("spawn_eggs/" + name, () -> item);
    }
}
