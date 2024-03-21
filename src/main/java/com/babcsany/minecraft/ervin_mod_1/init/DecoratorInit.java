package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DecoratorInit {

    public static final DeferredRegister<Placement<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Placement<NoPlacementConfig>> NOPE = DECORATORS.register("nope", () -> new Passthrough(NoPlacementConfig.CODEC));

}
