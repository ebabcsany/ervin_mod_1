package com.babcsany.minecraft.ervin_mod_1.init.item.armor;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HorseArmorItemInit {

    public static final DeferredRegister<Item> HORSE_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> FIRT_HORSE_ARMOR = HORSE_ARMOR.register("firt_horse_armor", () -> new HorseArmorItem(36, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/firt_horse_armor.png"), (new Item.Properties()).maxStackSize(1).group(ItemGroup.ERVIN_MOD_1_SEARCH)));

}
