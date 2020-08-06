package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.Firg;
import com.babcsany.minecraft.ervin_mod_1.block.FrimLeaves;
import com.babcsany.minecraft.ervin_mod_1.container.CraintBlockCraftingTableContainer;
import com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator.FirgTreeDecorator;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
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

    public static final DeferredRegister<Placement<?>> DECORATORS = new DeferredRegister<>(ForgeRegistries.DECORATORS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Placement<?>> FIRG_TREE_DECORATOR_TREE_DECORATOR_TYPE = DECORATORS.register("firg", () -> new FirgTreeDecorator(0.5f));
    //public static final RegistryObject<Placement<NoPlacementConfig>> FIRG = DECORATORS.register("firg", );



}
