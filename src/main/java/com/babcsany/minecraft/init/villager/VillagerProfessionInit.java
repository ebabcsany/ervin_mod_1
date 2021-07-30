package com.babcsany.minecraft.init.villager;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.registries.DeferredRegister;
import com.babcsany.minecraft.init.ParticleInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class VillagerProfessionInit {

    public static DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<VillagerProfession> DEFERRED = PROFESSIONS.register("deferred", PointOfInterestTypeInit.DEFERRED, null);

}
