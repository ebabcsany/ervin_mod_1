package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.Map;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.MinecraftBlockItems;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.util.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;

import static com.babcsany.minecraft.ervin_mod_1.init.block.item.isBurnableBlockItemInit_.*;
import static com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.*;

public abstract class AbstractFurnaceTileEntity extends net.minecraft.tileentity.AbstractFurnaceTileEntity {
    protected AbstractFurnaceTileEntity(TileEntityType<?> tileTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
        super(tileTypeIn, recipeTypeIn);
    }

    public static Map<Item, Double> init() {
        Map<Item, Double> map = Maps.newLinkedHashMap();
        BlockItemInit_.COAL_SLAB.get();
        BlockItemInit_.CHARCOAL_SLAB.get();
        MinecraftBlockItems.COAL_STAIRS.get();
        BlockItemInit_.CHARCOAL_STAIRS.get();
        BlockItemInit_.CHARCOAL_BLOCK.get();
        ItemInit.DGUCHSR.get();
        addItemBurnTime(map, GART.get(), 180000);
        addItemBurnTime(map, GARB.get(), 1620000);
        addItemBurnTime(map, GARK.get(), 14580000);
        addItemBurnTime(map, GARK_BLOCK.get(), 131220000);
        addItemBurnTime(map, GARK_SLAB.get(), 65610000);
        addItemBurnTime(map, GARK_STAIRS.get(), 98415000);
        addItemBurnTime(map, GARKT.get(), 1180980000);
        addItemBurnTime(map, GARKTH.get(), 18895680000L);
        addItemBurnTime(map, TRAGH.get(), 170061120000L);
        addItemBurnTime(map, TRAGK.get(), 1530550080000L);
        addItemBurnTime(map, TRAGK_BLOCK.get(), 24488801280000L);
        addItemBurnTime(map, TRAGK_SLAB.get(), 12244400640000L);
        addItemBurnTime(map, TRAGK_STAIRS.get(), 18366600960000L);
        addItemBurnTime(map, TRAGT.get(), 612220032000000L);
        addItemBurnTime(map, TRAGN.get(), 15305500800000000L);
        addItemBurnTime(map, ItemInit.FIRT.get(), 2400);
        addItemBurnTime(map, SpecialBlockFoodItemInit.FIRG.get(), 600);
        addItemBurnTime(map, isBurnableFoodItemInit.GRINT.get(), 5400);
        addItemBurnTime(map, SpecialBlockFoodItemInit.GRINT_BLOCK.get(), 48600);
        addItemBurnTime(map, isBurnableFoodItemInit.DURG.get(), 437400);
        addItemBurnTime(map, SpecialBlockFoodItemInit.GRINT_SLAB.get(), 24300);
        addItemBurnTime(map, SpecialBlockFoodItemInit.GRINT_STAIRS.get(), 37350);
        addItemBurnTime(map, SpecialBlockFoodItemInit.FIRG_SLAB.get(), 300);
        addItemBurnTime(map, SpecialBlockFoodItemInit.FIRG_STAIRS.get(), 450);
        addItemBurnTime(map, ToolItemInit.FIRT_AXE.get(), 7400);
        addItemBurnTime(map, ToolItemInit.FIRT_HOE.get(), 5000);
        addItemBurnTime(map, ToolItemInit.FIRT_PICKAXE.get(), 7400);
        addItemBurnTime(map, ToolItemInit.FIRT_SHOVEL.get(), 2600);
        addItemBurnTime(map, ToolItemInit.FIRT_SWORD.get(), 4900);
        addItemBurnTime(map, ArmorItemInit.FIRT_BOOTS.get(), 9600);
        addItemBurnTime(map, ArmorItemInit.FIRT_CHESTPLATE.get(), 19200);
        addItemBurnTime(map, ArmorItemInit.FIRT_HELMET.get(), 12000);
        addItemBurnTime(map, ArmorItemInit.FIRT_LEGGINGS.get(), 16800);
        addItemBurnTime(map, com.babcsany.minecraft.init.BlockItemInit.FIRT_BLOCK.get(), 21600);
        return map;
    }

    private static boolean func_235644_b_(Item p_235644_0_) {
        return ItemTags.NON_FLAMMABLE_WOOD.contains(p_235644_0_);
    }

    private static void addItemTagBurnTime(Map<Item, Float> map, ITag<Item> itemTag, float burnTimeIn) {
        for(Item item : itemTag.getAllElements()) {
            if (!func_235644_b_(item)) {
                map.put(item, burnTimeIn);
            }
        }

    }

    private static void addItemBurnTime(Map<Item, Double> map, IItemProvider itemProvider, double burnTimeIn) {
        Item item = itemProvider.asItem();
        if (func_235644_b_(item)) {
            if (SharedConstants.developmentMode) {
                throw Util.pauseDevMode(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item.getDisplayName(null).getString() + " a furnace fuel. That will not work!"));
            }
        } else {
            map.put(item, burnTimeIn);
        }
    }
}
