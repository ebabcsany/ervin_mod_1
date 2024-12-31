package com.babcsany.minecraft.ervin_mod_1.enchantment;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Enchantment> LUCK_OF_THE_SEA = ENCHANTMENTS.register("luck_of_the_lava_sea", () -> new ModLootBonusEnchantment(Enchantment.Rarity.RARE, ModEnchantmentTypes.HUIHK_ROD, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> LURE = ENCHANTMENTS.register("lure_from_lava", () -> new ModLureEnchantment(Enchantment.Rarity.RARE, ModEnchantmentTypes.HUIHK_ROD, EquipmentSlotType.MAINHAND));

    private static Enchantment register(String key, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, Ervin_mod_1.identifier(key), enchantment);
    }

    public static void register() {
        Ervin_mod_1.register(ModEnchantments.class);
    }
}
