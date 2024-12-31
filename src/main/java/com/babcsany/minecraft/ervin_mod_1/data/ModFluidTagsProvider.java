package com.babcsany.minecraft.ervin_mod_1.data;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.tags.ModFluidTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModFluidTagsProvider extends FluidTagsProvider {
    @Deprecated
    public ModFluidTagsProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    public ModFluidTagsProvider(DataGenerator generatorIn, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, modId, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        super.registerTags();
        this.getOrCreateBuilder(ModFluidTags.JURK).add(FluidInit.JURK.get(), FluidInit.FLOWING_JURK.get());
    }

    public static void register() {
        Ervin_mod_1.register(ModFluidTagsProvider.class);
    }
}
