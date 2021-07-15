package com.babcsany.minecraft.init.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;

import javax.annotation.Nullable;

public class VillagerProfessionInit {

    public static final VillagerProfession DEFERRED = register("ervin_mod_1:deferred", PointOfInterestTypeInit.DEFERRED, null);

    static VillagerProfession register(String nameIn, PointOfInterestType pointOfInterestIn, @Nullable SoundEvent soundIn) {
        return register(nameIn, pointOfInterestIn, ImmutableSet.of(), ImmutableSet.of(), soundIn);
    }

    static VillagerProfession register(String nameIn, PointOfInterestType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, @Nullable SoundEvent soundIn) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new ResourceLocation(nameIn), new VillagerProfession(nameIn, pointOfInterestIn, specificItemsIn, relatedWorldBlocksIn, soundIn));
    }
}
