package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ModBlockModelsProperties {
    private static final Map<Block, Map<ResourceLocation, IBlockPropertyGetter>> BLOCK_PROPERTY_MAP = Maps.newHashMap();

    public static void registerProperty(Block key, ResourceLocation location, IBlockPropertyGetter getter) {
        BLOCK_PROPERTY_MAP.computeIfAbsent(key, (block) -> Maps.newHashMap()).put(location, getter);
    }

    public static void registerProperty(Block key, String name, IBlockPropertyGetter getter) {
        registerProperty(key, new ResourceLocation(name), getter);
    }

    public static void init() {
        registerProperty(BlockInit.FIGHIV.get(), new ResourceLocation("time"), (state, world, living) -> {
            if (world == null) {
                return 0.0F;
            } else {
                return world.func_242415_f(1.0F);
            }
        });
    }
}
