package com.babcsany.minecraft.ervin_mod_1.init.minecraft.item.spawn_egg;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModSpawnEggItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpawnEggItemInit {

    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> GIANT_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/giant_spawn_egg", () -> new SpawnEggItem(EntityType.GIANT, 7425368, 3462945, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> ILLUSIONER_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/illusioner_spawn_egg", () -> new SpawnEggItem(EntityType.ILLUSIONER, 10574382, 10893626, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> IRON_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/iron_golem_spawn_egg", () -> new SpawnEggItem(EntityType.IRON_GOLEM, 16777215, 5070268, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> SNOW_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/snow_golem_spawn_egg", () -> new SpawnEggItem(EntityType.SNOW_GOLEM, 27649, 146359, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> WITHER_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/wither_spawn_egg", () -> new SpawnEggItem(EntityType.WITHER, 1644825, 2468825, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> ENDER_DRAGON_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/ender_dragon_spawn_egg", () -> new SpawnEggItem(EntityType.ENDER_DRAGON, 67412, 552634, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> LIGHTING_BOLT_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/lighting_bolt_spawn_egg", () -> new SpawnEggItem(EntityType.LIGHTNING_BOLT, 16777215, 16767215, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> FISHING_BOBBER_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/fishing_bobber_spawn_egg", () -> new SpawnEggItem(EntityType.FISHING_BOBBER, 16777215, 16667215, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
    public static final RegistryObject<Item> DRAGON_FIREBALL_SPAWN_EGG = SPAWN_EGGS.register("spawn_eggs/dragon_fireball_spawn_egg", () -> new SpawnEggItem(EntityType.DRAGON_FIREBALL, 16717285, 165865215, new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SPAWN_EGGS)));
}
