package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.carver.ExampleCaveWorldCarver;
import com.babcsany.minecraft.ervin_mod_1.world.gen.carver.UnderlavaCaveWorldCarver;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.carver.UnderwaterCaveWorldCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldCarverInit {

    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS,
            Ervin_mod_1.MOD_ID);

    //protected static final BlockState AIR = BlockInit.AIR.get().getDefaultState();
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> CAVE = CARVERS.register("cave", () -> new CaveWorldCarver(ProbabilityConfig.field_236576_b_, 256));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> EXAMPLE_CAVE = CARVERS.register("example_cave", () -> new ExampleCaveWorldCarver(ProbabilityConfig.field_236576_b_, 362));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> UNDERWATER_CAVE = CARVERS.register("underwater_cave", () -> new UnderwaterCaveWorldCarver(ProbabilityConfig.field_236576_b_));
    //public static final RegistryObject<WorldCarver<ProbabilityConfig>> UNDERLAVA_CAVE = CARVERS.register("underlava_cave", () -> new UnderlavaCaveWorldCarver(ProbabilityConfig.field_236576_b_));
}
