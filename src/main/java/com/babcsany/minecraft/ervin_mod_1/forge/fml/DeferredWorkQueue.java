package com.babcsany.minecraft.ervin_mod_1.forge.fml;

import net.minecraftforge.fml.ModLoadingStage;
import net.minecraftforge.fml.event.lifecycle.ParallelDispatchEvent;

public class DeferredWorkQueue extends net.minecraftforge.fml.DeferredWorkQueue {
    public DeferredWorkQueue(ModLoadingStage modLoadingStage, Class<? extends ParallelDispatchEvent> eventClass) {
        super(modLoadingStage, eventClass);
    }
}
