package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.painting;

import net.minecraft.entity.item.PaintingType;

public class PaintingInit {

    public PaintingInit(PaintingType paintingType) {
        register(paintingType);
    }

    public void register(PaintingType paintingType) {
        com.babcsany.minecraft.ervin_mod_1.init.item.PaintingInit.PAINTING_TYPES = paintingType;
    }
}
