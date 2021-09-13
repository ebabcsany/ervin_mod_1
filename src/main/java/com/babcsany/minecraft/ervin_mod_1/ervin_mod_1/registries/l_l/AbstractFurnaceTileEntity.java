package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries.l_l;

import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.ToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.MinecraftBlockItems;
import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;

import java.util.Map;

import static com.babcsany.minecraft.ervin_mod_1.init.block.item.isBurnableBlockItemInit_.*;
import static com.babcsany.minecraft.ervin_mod_1.init.item.burning.BurningItemInit.*;

public abstract class AbstractFurnaceTileEntity extends net.minecraft.tileentity.AbstractFurnaceTileEntity {
    protected AbstractFurnaceTileEntity(TileEntityType<?> tileTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
        super(tileTypeIn, recipeTypeIn);
    }

    public static Map<Item, Integer> getBurnTimes() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        MinecraftBlockItems.COAL_SLAB.get();
        BlockItemInit_.CHARCOAL_SLAB.get();
        MinecraftBlockItems.COAL_STAIRS.get();
        BlockItemInit_.CHARCOAL_STAIRS.get();
        BlockItemInit_.CHARCOAL_BLOCK.get();
        ItemInit.DGUCHSR.get();
        GART.get();
        GARB.get();
        GARK.get();
        GARK_BLOCK.get();
        GARK_SLAB.get();
        GARK_STAIRS.get();
        GARKT.get();
        GARKTH.get();
        TRAGH.get();
        TRAGK.get();
        TRAGK_BLOCK.get();
        TRAGK_SLAB.get();
        TRAGK_STAIRS.get();
        TRAGT.get();
        TRAGN.get();
        ItemInit.FIRT.get();
        SpecialBlockFoodItemInit.FIRG.get();
        isBurnableFoodItemInit.GRINT.get();
        SpecialBlockFoodItemInit.GRINT_BLOCK.get();
        isBurnableFoodItemInit.DURG.get();
        SpecialBlockFoodItemInit.GRINT_SLAB.get();
        SpecialBlockFoodItemInit.GRINT_STAIRS.get();
        SpecialBlockFoodItemInit.FIRG_SLAB.get();
        SpecialBlockFoodItemInit.FIRG_STAIRS.get();
        ToolItemInit.FIRT_AXE.get();
        ToolItemInit.FIRT_HOE.get();
        ToolItemInit.FIRT_PICKAXE.get();
        ToolItemInit.FIRT_SHOVEL.get();
        ToolItemInit.FIRT_SWORD.get();
        ArmorItemInit.FIRT_BOOTS.get();
        ArmorItemInit.FIRT_CHESTPLATE.get();
        ArmorItemInit.FIRT_HELMET.get();
        ArmorItemInit.FIRT_LEGGINGS.get();
        com.babcsany.minecraft.init.BlockItemInit.FIRT_BLOCK.getItem();
        /*addItemBurnTime(map, ItemInit.EXAMPLE_ITEM, (int));*/
        return map;
    }

    private static boolean func_235644_b_(Item p_235644_0_) {
        return ItemTags.field_232905_P_.contains(p_235644_0_);
    }

    private static void addItemTagBurnTime(Map<Item, Float> map, ITag<Item> itemTag, float burnTimeIn) {
        for(Item item : itemTag.getAllElements()) {
            if (!func_235644_b_(item)) {
                map.put(item, burnTimeIn);
            }
        }

    }

    private static void addItemBurnTime(Map<Item, Integer> map, IItemProvider itemProvider, int burnTimeIn) {
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
