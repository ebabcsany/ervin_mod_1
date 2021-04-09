package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    SRIUNK(Ervin_mod_1.MOD_ID + ":sriunk", 40, new int[]{28, 36, 44, 28}, 1680, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 20.7F, 0.2F, () -> { return Ingredient.fromItems(isBurnableItemInit.SRIUNK.get()); }),
    TERAT(Ervin_mod_1.MOD_ID + ":terat", 640,new int[]{448, 576, 704, 448}, 13440,SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 347.2F, 4.8F, () -> { return Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableItemInit.TERAT.get()); }),
    FIRT(Ervin_mod_1.MOD_ID + ":firt", 24, new int[]{16, 24, 32, 16}, 1050, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 12.4F, 0.1F, () -> { return Ingredient.fromItems(ItemInit.FIRT.get()); }),
    DURG(Ervin_mod_1.MOD_ID + ":durg", 216, new int[]{144, 216, 288, 144}, 9450, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 111.6F, 1.0F, () -> { return Ingredient.fromItems(isBurnableItemInit.DURG.get()); }),
    BLACK_IRON(Ervin_mod_1.MOD_ID + ":iron/black_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.BLACK_IRON_INGOT.get()); }),
    BLUE_IRON(Ervin_mod_1.MOD_ID + ":iron/blue_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.BLUE_IRON_INGOT.get()); }),
    BROWN_IRON(Ervin_mod_1.MOD_ID + ":iron/brown_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.BROWN_IRON_INGOT.get()); }),
    CYAN_IRON(Ervin_mod_1.MOD_ID + ":iron/cyan_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.CYAN_IRON_INGOT.get()); }),
    GRAY_IRON(Ervin_mod_1.MOD_ID + ":iron/gray_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.GRAY_IRON_INGOT.get()); }),
    GREEN_IRON(Ervin_mod_1.MOD_ID + ":iron/green_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.GREEN_IRON_INGOT.get()); }),
    LIGHT_BLUE_IRON(Ervin_mod_1.MOD_ID + ":iron/light_blue_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.LIGHT_BLUE_IRON_INGOT.get()); }),
    LIGHT_BLUE1_IRON(Ervin_mod_1.MOD_ID + ":iron/light_blue1_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.LIGHT_BLUE1_IRON_INGOT.get()); }),
    LIGHT_GRAY_IRON(Ervin_mod_1.MOD_ID + ":iron/light_gray_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.LIGHT_GRAY_IRON_INGOT.get()); }),
    LIME_IRON(Ervin_mod_1.MOD_ID + ":iron/lime_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.LIME_IRON_INGOT.get()); }),
    MAGENTA_IRON(Ervin_mod_1.MOD_ID + ":iron/magenta_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.MAGENTA_IRON_INGOT.get()); }),
    ORANGE_IRON(Ervin_mod_1.MOD_ID + ":iron/orange_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.ORANGE_IRON_INGOT.get()); }),
    PINK_IRON(Ervin_mod_1.MOD_ID + ":iron/pink_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.PINK_IRON_INGOT.get()); }),
    PURPLE_IRON(Ervin_mod_1.MOD_ID + ":iron/purple_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.PURPLE_IRON_INGOT.get()); }),
    RED_IRON(Ervin_mod_1.MOD_ID + ":iron/red_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.RED_IRON_INGOT.get()); }),
    WHITE_IRON(Ervin_mod_1.MOD_ID + ":iron/white_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.WHITE_IRON_INGOT.get()); }),
    YELLOW_IRON(Ervin_mod_1.MOD_ID + ":iron/yellow_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.YELLOW_IRON_INGOT.get()); });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 4000, 4000, 4000, 4000 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;


    ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
                     int enchantabilityIn, SoundEvent soundEventIn, float knockbackResistanceIn, float toughnessIn,
                     Supplier<Ingredient> repairMaterialIn) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = soundEventIn;
        this.toughness = toughnessIn;
        this.knockbackResistance = knockbackResistanceIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }


    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }


    @Override
    public int getEnchantability() {
        return this.enchantability;
    }


    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }


    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
