package com.babcsany.minecraft.ervin_mod_1.item;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;

import java.util.Map;

public class ModDyeItem extends Item {
    private static final Map<ModDyeColor, ModDyeItem> COLOR_DYE_ITEM_MAP = Maps.newEnumMap(ModDyeColor.class);
    private final ModDyeColor dyeColor;

    public ModDyeItem(ModDyeColor dyeColorIn, Item.Properties builder) {
        super(builder);
        this.dyeColor = dyeColorIn;
        COLOR_DYE_ITEM_MAP.put(dyeColorIn, this);
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
//    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
//        if (target instanceof SheepEntity) {
//            SheepEntity sheepentity = (SheepEntity)target;
//            if (sheepentity.isAlive() && !sheepentity.getSheared() && sheepentity.getFleeceColor() != this.dyeColor) {
//                if (!playerIn.world.isRemote) {
//                    DataParameter<Byte> parameter = (DataParameter<Byte>) sheepentity.getDataManager().getAll().get(0).getKey();
//                    sheepentity.getDataManager().set(parameter, DyeColor.BLUE);
//                    stack.shrink(1);
//                }
//
//                return ActionResultType.func_233537_a_(playerIn.world.isRemote);
//            }
//        }
//
//        return ActionResultType.PASS;
//    }

    public ModDyeColor getDyeColor() {
        return this.dyeColor;
    }

    public static ModDyeItem getItem(ModDyeColor color) {
        return COLOR_DYE_ITEM_MAP.get(color);
    }
}
