package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.NirtreProfession;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.PointOfInterestType1;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class VillagerProfessionInit {

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS,
            Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<VillagerProfession> NONE = VILLAGER_PROFESSIONS.register("none", () -> PointOfInterestType.UNEMPLOYED, (SoundEvent)null);

}
