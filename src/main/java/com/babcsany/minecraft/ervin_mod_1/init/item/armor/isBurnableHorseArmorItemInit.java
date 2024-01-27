package com.babcsany.minecraft.ervin_mod_1.init.item.armor;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableHorseArmorItemInit {

    public static final DeferredRegister<Item> BURNABLE_HORSE_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> DURG_HORSE_ARMOR = BURNABLE_HORSE_ARMOR.register("durg_horse_armor", () -> new HorseArmorItem(324, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/durg_horse_armor.png"), (new Item.Properties()).maxStackSize(1).isBurnable().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SRIUNK_HORSE_ARMOR = BURNABLE_HORSE_ARMOR.register("sriunk_horse_armor", () -> new HorseArmorItem(44, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/sriunk_horse_armor.png"), (new Item.Properties()).maxStackSize(1).isBurnable().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> TERAT_HORSE_ARMOR = BURNABLE_HORSE_ARMOR.register("terat/terat_horse_armor", () -> new HorseArmorItem(880, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/terat_horse_armor.png"), (new Item.Properties()).maxStackSize(1).isBurnable().group(ItemGroup.MISC)));
}
