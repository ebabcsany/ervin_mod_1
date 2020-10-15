package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.mojang.serialization.DynamicOps;

public interface IDynamicSerializable {
   <T> T serialize(DynamicOps<T> p_218175_1_);
}