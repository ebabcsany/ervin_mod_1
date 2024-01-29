package com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSpawnEggItemInit {

    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> SPAWN_EGG_1 = SPAWN_EGGS.register("spawn_eggs/spawn_egg_1", () -> new Item(new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> $_TRADER_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/usd_trader_spawn_egg", () -> new ModSpawnEggItem(EntityInit.$_TRADER_ENTITY, 0x204080, 0x402080, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> SRACH_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/srach_spawn_egg", () -> new ModSpawnEggItem(EntityInit.SRACH_ENTITY, 0x5016b4, 0xa056c4, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> FREIN_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/frein_spawn_egg", () -> new ModSpawnEggItem(EntityInit.FREIN_ENTITY, 0x646464, 0x000000, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> GWURST_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/gwurst_spawn_egg", () -> new ModSpawnEggItem(EntityInit.GWURST, 0x202020, 0x804020, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> DRURB_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/drurb_spawn_egg", () -> new ModSpawnEggItem(EntityInit.DRURB_ENTITY, 0x202020, 0x804020, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> GUBROV_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/gubrov_spawn_egg", () -> new ModSpawnEggItem(EntityInit.GUBROV, 0x202020, 0x804020, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> HHIJ_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/hhij_spawn_egg", () -> new ModSpawnEggItem(EntityInit.HHIJ_ENTITY, 0x4040c0, 0x402080, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> LIWRAY_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/liwray_spawn_egg", () -> new ModSpawnEggItem(EntityInit.LIWRAY, 0x5a8cc8, 0x3cd228, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> TRADER_NIRTRE_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/trader_nirtre_spawn_egg", () -> new ModSpawnEggItem(EntityInit.TRADER_NIRTRE_ENTITY, 0x3c7828, 0x3c2850, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> VILT_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/vilt_spawn_egg", () -> new ModSpawnEggItem(EntityInit.VILT_ENTITY, 0xc02020, 0xc02020, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> WANDERING_TRADER_NIRTRE_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/wandering_trader_nirtre_spawn_egg", () -> new ModSpawnEggItem(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY, 0x503c28, 0x283c50, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> ZOMBIE_TRADER_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/zombie_trader_spawn_egg", () -> new ModSpawnEggItem(EntityInit.ZOMBIE_TRADER_ENTITY, 0x40c080, 0x20a0c0, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> ZUR_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/zur_spawn_egg", () -> new ModSpawnEggItem(EntityInit.ZUR_ENTITY, 0x40c080, 0x20a0c0, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<SpawnEggItem> ROVENT_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/rovent_spawn_egg", () -> new ModSpawnEggItem(EntityInit.ROVENT_ENTITY, 0x244830, 0x28384e, new Item.Properties()));
}
