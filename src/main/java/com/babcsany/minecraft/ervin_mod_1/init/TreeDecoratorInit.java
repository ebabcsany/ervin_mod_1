package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator.FirgTreeDecorator;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;

public class TreeDecoratorInit {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Ervin_mod_1.MOD_ID);

    /*public static final RegistryObject<TreeDecoratorType<FirgTreeDecorator>> FIRG = TREE_DECORATOR_TYPES.register("firg", FirgTreeDecorator.field_236874_c_);

    public static final RegistryObject<TreeDecoratorType<TrunkVineTreeDecorator>> TRUNK_VINE = TREE_DECORATOR_TYPES.register("trunk_vine", TrunkVineTreeDecorator.field_236878_a_);
    */
}
