package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    SRIUNK("sriunk", 80, 56, 72, 88, 56, 1680, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.6F, 20.7F, isBurnableItemInit.SRIUNK),
    NIRK("nirk", 348, 174, 348, 522, 174, 1746048, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 19.2F, 90.7F, isBurnableItemInit.NIRK),
    TERAT("terat", 640,448, 576, 704, 448, 44813440,SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 38.2F, 347.2F, isBurnableSpecialToolItemInit.TERAT),
    FIRT("firt", 24, 16, 24, 32, 16, 161050, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.8F, 12.4F, ItemInit.FIRT),
    DURG("durg", 216, 144, 216, 288, 144, 1449450, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 111.6F, isBurnableFoodItemInit.DURG),
    BLACK_IRON("iron/black_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.BLACK_IRON_INGOT),
    BLUE_IRON("iron/blue_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.BLUE_IRON_INGOT),
    BROWN_IRON("iron/brown_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.BROWN_IRON_INGOT),
    CYAN_IRON("iron/cyan_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.CYAN_IRON_INGOT),
    GRAY_IRON("iron/gray_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.GRAY_IRON_INGOT),
    GREEN_IRON("iron/green_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.GREEN_IRON_INGOT),
    LIGHT_BLUE_IRON("iron/light_blue_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.LIGHT_BLUE_IRON_INGOT),
    LIGHT_BLUE1_IRON("iron/light_blue1_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.LIGHT_BLUE1_IRON_INGOT),
    LIGHT_GRAY_IRON("iron/light_gray_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.LIGHT_GRAY_IRON_INGOT),
    LIME_IRON("iron/lime_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.LIME_IRON_INGOT),
    MAGENTA_IRON("iron/magenta_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.MAGENTA_IRON_INGOT),
    ORANGE_IRON("iron/orange_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.ORANGE_IRON_INGOT),
    PINK_IRON("iron/pink_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.PINK_IRON_INGOT),
    PURPLE_IRON("iron/purple_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.PURPLE_IRON_INGOT),
    RED_IRON("iron/red_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.RED_IRON_INGOT),
    WHITE_IRON("iron/white_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.WHITE_IRON_INGOT),
    YELLOW_IRON("iron/yellow_iron", 15, 2, 5, 6, 2, 29, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemInit.YELLOW_IRON_INGOT),
    THUFR("thufr", thufr(653041679), thufr(174928614), thufr(284760951), thufr(297603158), thufr(1694351278), thufr(653051728 * 2), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 128739410576.316748259F, 380468715.018954213F, isBurnableSpecialToolItemInit.THUFR);

    public static int thufr(int maxUses) {
        return 2000000000 + (maxUses * 100);
    }

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 4000, 4000, 4000, 4000 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    ModArmorMaterial(String nameIn, int maxDamageFactorIn, int feetDamageReductionAmountIn, int chestDamageReductionAmountIn, int legsDamageReductionAmountIn, int headDamageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float knockbackResistanceIn, float toughnessIn, Item... repairMaterialsIn) {
        this(Ervin_mod_1.identifier(nameIn), maxDamageFactorIn, new int[]{feetDamageReductionAmountIn, chestDamageReductionAmountIn, legsDamageReductionAmountIn, headDamageReductionAmountIn}, enchantabilityIn, soundEventIn, knockbackResistanceIn, toughnessIn, () -> Ingredient.fromItems(repairMaterialsIn));
    }

    ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float knockbackResistanceIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
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
