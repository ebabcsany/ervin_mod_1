package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.Firg;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.FrimLeaves;
import com.babcsany.minecraft.ervin_mod_1.container.CraintBlockCraftingTableContainer;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ShertEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ZurEntity1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator.FirgTreeDecorator;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Random;
import java.util.stream.Stream;

public class DecoratorInit {

    public static final DeferredRegister<Placement<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Placement<?>> FIRG = DECORATORS.register("firg", () -> new FirgTreeDecorator(0.5f));
    //public static final RegistryObject<Placement<NoPlacementConfig>> FIRG = DECORATORS.register("firg", );
    //public static final RegistryObject<Placement<?>> FIRG = DECORATORS.register("sriunk", () -> new TreeDecoratorType<FirgTreeDecorator>(
      //      (new Decorator.Properties())));
    //public static final RegistryObject<Placement<?>> FIRG = DECORATORS.register("example_block", () -> new TreeDecorator()
    /*public static final RegistryObject<Placement<ChanceConfig>> FIRG = DECORATORS.register(
            "coloured_particle",
            () -> new TreeDecoratorType<FirgTreeDecorator>(false, new FirgTreeDecorator()));*/
   //public static final RegistryObject<Placement<FrequencyConfig>> NOPE = DECORATORS.register("nope", new AtSurface(FrequencyConfig::deserialize));
    //public static final RegistryObject<Placement<NoPlacementConfig>> EMERALD_ORE = DECORATORS.register("emerald_ore", new Height4To32(NoPlacementConfig::deserialize,));


}
