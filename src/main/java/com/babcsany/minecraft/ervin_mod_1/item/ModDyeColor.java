package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.block.material.ModMaterialColor;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public enum ModDyeColor implements IStringSerializable {
    LIGHT_BLUE1(0, "light_blue1", 6195627, ModMaterialColor.LIGHT_BLUE1, 8234434, 6925541);

    private static final ModDyeColor[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(ModDyeColor::getId)).toArray(ModDyeColor[]::new);
    private static final Int2ObjectOpenHashMap<ModDyeColor> BY_FIREWORK_COLOR = new Int2ObjectOpenHashMap<>(Arrays.stream(values()).collect(Collectors.toMap((color) -> {
        return color.fireworkColor;
    }, (color) -> {
        return color;
    })));
    private final int id;
    private final String translationKey;
    private final ModMaterialColor mapColor;
    private final int colorValue;
    private final int swappedColorValue;
    private final float[] colorComponentValues;
    private final int fireworkColor;
    private final net.minecraftforge.common.Tags.IOptionalNamedTag<Item> tag;
    private final int textColor;

    private ModDyeColor(int idIn, String translationKeyIn, int colorValueIn, ModMaterialColor mapColorIn, int fireworkColorIn, int textColorIn) {
        this.id = idIn;
        this.translationKey = translationKeyIn;
        this.colorValue = colorValueIn;
        this.mapColor = mapColorIn;
        this.textColor = textColorIn;
        int i = (colorValueIn & 16711680) >> 16;
        int j = (colorValueIn & '\uff00') >> 8;
        int k = (colorValueIn & 255) >> 0;
        this.swappedColorValue = k << 16 | j << 8 | i << 0;
        this.tag = net.minecraft.tags.ItemTags.createOptional(new net.minecraft.util.ResourceLocation("forge", "dyes/" + translationKeyIn));
        this.colorComponentValues = new float[]{(float) i / 255.0F, (float) j / 255.0F, (float) k / 255.0F};
        this.fireworkColor = fireworkColorIn;
    }

    public int getId() {
        return this.id;
    }

    public String getTranslationKey() {
        return this.translationKey;
    }

    /**
     * Gets an array containing 3 floats ranging from 0.0 to 1.0: the red, green, and blue components of the
     * corresponding color.
     */
    public float[] getColorComponentValues() {
        return this.colorComponentValues;
    }

    public ModMaterialColor getMapColor() {
        return this.mapColor;
    }

    public int getFireworkColor() {
        return this.fireworkColor;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public static ModDyeColor byId(int colorId) {
        if (colorId < 0 || colorId >= VALUES.length) {
            colorId = 0;
        }

        return VALUES[colorId];
    }

    public static ModDyeColor byTranslationKey(String translationKeyIn, ModDyeColor fallback) {
        for (ModDyeColor dyecolor : values()) {
            if (dyecolor.translationKey.equals(translationKeyIn)) {
                return dyecolor;
            }
        }

        return fallback;
    }

    @Nullable
    public static ModDyeColor byFireworkColor(int fireworkColorIn) {
        return BY_FIREWORK_COLOR.get(fireworkColorIn);
    }

    public String toString() {
        return this.translationKey;
    }

    public String getString() {
        return this.translationKey;
    }

    public int getColorValue() {
        return colorValue;
    }

    public net.minecraftforge.common.Tags.IOptionalNamedTag<Item> getTag() {
        return tag;
    }

    @Nullable
    public static ModDyeColor getColor(ItemStack stack) {
        if (stack.getItem() instanceof ModDyeItem)
            return ((ModDyeItem) stack.getItem()).getDyeColor();

        for (ModDyeColor color : VALUES) {
            if (stack.getItem().isIn(color.getTag()))
                return color;
        }

        return null;
    }
}
