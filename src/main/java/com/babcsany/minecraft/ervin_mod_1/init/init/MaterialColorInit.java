package com.babcsany.minecraft.ervin_mod_1.init.init;

import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MaterialColorInit extends MaterialColor {
    /** Holds all the 16 colors used on maps, very similar of a pallete system. */
    public static final MaterialColorInit[] COLORS = new MaterialColorInit[64];
    public static final MaterialColorInit AIR = new MaterialColorInit(0, 0);
    public static final MaterialColorInit CRASK = new MaterialColorInit(1, 10040115);
    public static final MaterialColorInit LIGHT_BLUE = new MaterialColorInit(2, 6724056);
    public static final MaterialColorInit RETRUG = new MaterialColorInit(3, 3355443);
    public static final MaterialColorInit TRURK = new MaterialColorInit(4, 264768);
    public static final MaterialColorInit WHITE = new MaterialColorInit(5, 16777215);
    public static final MaterialColorInit ORANGE = new MaterialColorInit(6, 14188339);
    public static final MaterialColorInit MAGENTA = new MaterialColorInit(7, 11685080);
    public static final MaterialColorInit YELLOW = new MaterialColorInit(8, 15066419);
    public static final MaterialColorInit LIME = new MaterialColorInit(9, 8375321);
    public static final MaterialColorInit PINK = new MaterialColorInit(10, 15892389);
    public static final MaterialColorInit GRAY = new MaterialColorInit(11, 5000268);
    public static final MaterialColorInit LIGHT_GRAY = new MaterialColorInit(12, 10066329);
    public static final MaterialColorInit CYAN = new MaterialColorInit(13, 5013401);
    public static final MaterialColorInit PURPLE = new MaterialColorInit(14, 8339378);
    public static final MaterialColorInit BLUE = new MaterialColorInit(15, 3361970);
    public static final MaterialColorInit BROWN = new MaterialColorInit(16, 6704179);
    public static final MaterialColorInit GREEN = new MaterialColorInit(17, 6717235);
    public static final MaterialColorInit RED = new MaterialColorInit(18, 10040115);
    public static final MaterialColorInit BLACK = new MaterialColorInit(19, 1644825);
    public static final MaterialColorInit STONE = new MaterialColorInit(20, 7368816);
    public static final MaterialColorInit WOOD = new MaterialColorInit(21, 9402184);
    public static final MaterialColorInit WOOL = new MaterialColorInit(22, 13092807);
    public static final MaterialColorInit SAND = new MaterialColorInit(23, 16247203);


    public final int colorValue;
    public final int colorIndex;

    private MaterialColorInit(int index, int color) {
        super(index, color);
        if (index >= 0 && index <= 63) {
            this.colorIndex = index;
            this.colorValue = color;
            COLORS[index] = this;
        } else {
            throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
        }
    }

    @OnlyIn(Dist.CLIENT)
    public int getMapColor(int index) {
        int i = 220;
        if (index == 3) {
            i = 135;
        }

        if (index == 2) {
            i = 255;
        }

        if (index == 1) {
            i = 220;
        }

        if (index == 0) {
            i = 180;
        }

        int j = (this.colorValue >> 16 & 255) * i / 255;
        int k = (this.colorValue >> 8 & 255) * i / 255;
        int l = (this.colorValue & 255) * i / 255;
        return -16777216 | l << 16 | k << 8 | j;
    }
}
