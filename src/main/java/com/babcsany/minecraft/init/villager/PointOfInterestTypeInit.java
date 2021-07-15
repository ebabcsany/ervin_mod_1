package com.babcsany.minecraft.init.villager;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class PointOfInterestTypeInit {

    private static final Map<BlockState, PointOfInterestType> POIT_BY_BLOCKSTATE = Maps.newHashMap();
    public static final PointOfInterestType DEFERRED = register("ervin_mod_1:deferred", getAllStates(BlockItemInit.DEFERRED_BLOCK.get()), 1, 1);
    static Set<BlockState> blockStates;

    public static Set<BlockState> getAllStates(Block blockIn) {
        return ImmutableSet.copyOf(blockIn.getStateContainer().getValidStates());
    }

    private static PointOfInterestType register(String key, Set<BlockState> blockStates, int maxFreeTickets, int validRange) {
        return registerBlockStates(Registry.register(Registry.POINT_OF_INTEREST_TYPE, new ResourceLocation(key), new PointOfInterestType(key, blockStates, maxFreeTickets, validRange)));
    }

    private static PointOfInterestType register(String key, Set<BlockState> blockStates, int maxFreeTickets, Predicate<PointOfInterestType> predicate, int validRange) {
        return registerBlockStates(Registry.register(Registry.POINT_OF_INTEREST_TYPE, new ResourceLocation(key), new PointOfInterestType(key, blockStates, maxFreeTickets, predicate, validRange)));
    }

    private static PointOfInterestType registerBlockStates(PointOfInterestType poit) {
        blockStates.forEach((p_234169_1_) -> {
            PointOfInterestType pointofinteresttype = POIT_BY_BLOCKSTATE.put(p_234169_1_, poit);
            if (pointofinteresttype != null) {
                throw Util.pauseDevMode(new IllegalStateException(String.format("%s is defined in too many tags", p_234169_1_)));
            }
        });
        return poit;
    }
}
