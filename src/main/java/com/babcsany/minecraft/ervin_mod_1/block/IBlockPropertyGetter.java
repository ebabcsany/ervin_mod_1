package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.BlockState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public interface IBlockPropertyGetter {
    float call(BlockState state, @Nullable ClientWorld world, @Nullable LivingEntity living);
}
