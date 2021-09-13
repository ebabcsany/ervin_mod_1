package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.item;

import com.babcsany.minecraft.ervin_mod_1.init.item.$ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.FluidBucketInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.HorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.isBurnableHorseArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds.SeedsItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.tool.ToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.BlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.brefk.BrefkStageItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialItemInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class ItemInit {

    public ItemInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        isBurnableFoodItemInit.BURNABLE_FOODS.register(modEventBus);
        BlockFoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit.BLOCK_ITEMS.register(modEventBus);
        BrefkStageItemInit.BREFK.register(modEventBus);
        FoodItemInit.FOODS.register(modEventBus);
        FluidBucketInit.FLUID_BUCKETS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit.ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.BURNABLE_ITEMS.register(modEventBus);
        SpecialToolItemInit.BURNABLE_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit.TOOLS.register(modEventBus);
        isBurnableToolItemInit.BURNABLE_TOOLS.register(modEventBus);
        isBurnableSpecialToolItemInit.BURNABLE_ITEMS.register(modEventBus);
        ArmorItemInit.ARMOR.register(modEventBus);
        HorseArmorItemInit.HORSE_ARMOR.register(modEventBus);
        isBurnableArmorItemInit.BURNABLE_ARMOR.register(modEventBus);
        isBurnableHorseArmorItemInit.BURNABLE_HORSE_ARMOR.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.armor.iron.ArmorItemInit.ARMOR.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.tool.iron.ToolItemInit.TOOLS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.tool.stone.ToolItemInit.TOOL_ITEMS.register(modEventBus);
        ModSpawnEggItemInit.SPAWN_EGGS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.minecraft.item.spawn_egg.SpawnEggItemInit.SPAWN_EGGS.register(modEventBus);
        BlockNamedItemInit.ITEMS.register(modEventBus);
        isBurnableSpecialBlockItemInit.SPECIAL_ITEMS.register(modEventBus);
        isBurnableSpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        SpecialBlockFoodItemInit.BURNABLE_FOOD_BLOCK_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.special.SpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        ToolItemInit.TOOLS.register(modEventBus);
        SpecialItemInit.SPECIAL_ITEMS.register(modEventBus);
        $ItemInit.$.register(modEventBus);
        SeedsItemInit.SEEDS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.item.ItemInit.ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.BlockFoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.item.food.milk.FoodItemInit.FOOD_ITEMS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.BlockNamedItemInit.BLOCK_ITEMS.register(modEventBus);
        return modEventBus;
    }
}
