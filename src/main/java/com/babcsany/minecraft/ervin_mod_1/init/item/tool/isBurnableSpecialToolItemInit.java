package com.babcsany.minecraft.ervin_mod_1.init.item.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier_;
import com.babcsany.minecraft.ervin_mod_1.item.TeratBlockItem;
import com.babcsany.minecraft.ervin_mod_1.item.burning.tool.stick.FirtSword;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import com.babcsany.minecraft.ervin_mod_1.item.item.Item_;
import com.babcsany.minecraft.ervin_mod_1.item.items.Terat;
import com.babcsany.minecraft.ervin_mod_1.item.items.Thufr;
import com.babcsany.minecraft.ervin_mod_1.item.items.ThufrBlockItem;
import com.babcsany.minecraft.ervin_mod_1.item.items.ThufrSword;
import com.babcsany.minecraft.ervin_mod_1.item.items.i_item_tiers.ToolItem;
import com.babcsany.minecraft.ervin_mod_1.item.special.Firn;
import com.babcsany.minecraft.ervin_mod_1.item.tool.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableSpecialToolItemInit {

    public static final DeferredRegister<Item> BURNABLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Terat> TERAT = BURNABLE_ITEMS.register("terat/terat", () -> new Terat(ModItemTier.TERAT,643.0F, (new TieredItem_1.Properties()).isBurnable().maxStackSize(256).group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> TERAT_STICK = BURNABLE_ITEMS.register("stick/terat_stick", () -> new Terat(ModItemTier.TERAT,562.0F, (new TieredItem_1.Properties()).isBurnable().maxStackSize(256).group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> THUFR = BURNABLE_ITEMS.register("special/thufr", () -> new ThufrBlockItem(BlockInit.THUFR.get(), ModItemTier2.THUFR,54326578.0F, (new TieredBlockItem_1.Properties()).isBurnable().maxStackSize(2048)));
    public static final RegistryObject<Item> THUFR_AXE = BURNABLE_ITEMS.register("tools/axe/thufr_axe", () -> new AxeItem(ModItemTier_.THUFR,1567849243.0F, 54926839988.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> THUFR_HOE = BURNABLE_ITEMS.register("tools/hoe/thufr_hoe", () -> new HoeItem(ModItemTier_.THUFR,215674954, 178915762.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> THUFR_PICKAXE = BURNABLE_ITEMS.register("tools/pickaxe/thufr_pickaxe", () -> new Thufr(ModItemTier_.THUFR,3917877926.0F, 8723146536.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> THUFR_SHOVEL = BURNABLE_ITEMS.register("tools/shovel/thufr_shovel", () -> new ShovelItem(ModItemTier_.THUFR,245839647.0F, 13187263405.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> THUFR_SWORD = BURNABLE_ITEMS.register("tools/sword/thufr_sword", () -> new ThufrSword(ModItemTier_.THUFR,768707893, 34629186075.0F, (new Item.Properties()).isBurnable()));
}
