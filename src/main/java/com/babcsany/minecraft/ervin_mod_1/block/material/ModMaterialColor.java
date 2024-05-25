package com.babcsany.minecraft.ervin_mod_1.block.material;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModMaterialColor {
    /** Holds all the 16 colors used on maps, very similar of a pallete system. */
    public static final ModMaterialColor[] COLORS = new ModMaterialColor[64];
    public static final ModMaterialColor LIGHT_BLUE1 = new ModMaterialColor(0, 9875161);
    public final int colorValue;
    public final int colorIndex;

    private ModMaterialColor(int index, int color) {
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
        int i = 0;
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
