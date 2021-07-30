package com.babcsany.minecraft.init.villager;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.registries.DeferredRegister;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.function.Supplier;

public class PointOfInterestTypeInit {

    public static final DeferredRegister<PointOfInterestType> POINT_OF_INTEREST_TYPE = DeferredRegister.create(ForgeRegistries.POI_TYPES, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<PointOfInterestType> DEFERRED = POINT_OF_INTEREST_TYPE.register("deferred", getAllStates(BlockItemInit.DEFERRED_BLOCK), 1, 1);

    public static Supplier<? extends Set<BlockState>> getAllStates(Supplier<? extends Block> blockIn) {
        return (Supplier<? extends Set<BlockState>>) ImmutableSet.copyOf(blockIn.get().getStateContainer().getValidStates());
    }

    public Set<Supplier<? extends BlockState>> blockState;
}
