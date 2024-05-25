package com.babcsany.minecraft.ervin_mod_1.tags;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;

public final class ModFluidTags {
    public static final ITag.INamedTag<Fluid> JURK = tag("jurk");

    public static ITag.INamedTag<Fluid> tag(String id) {
        return FluidTags.createOptional(Ervin_mod_1.getKey(id));
    }
}
