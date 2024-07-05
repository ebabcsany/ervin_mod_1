package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator.FirgTreeDecorator;
import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.lang.reflect.InvocationTargetException;

public class ModTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Ervin_mod_1.MOD_ID);
    public static TreeDecoratorType<BeehiveTreeDecorator> FIRG = TreeDecoratorType.BEEHIVE;
//    public static RegistryObject<?> FIRG1 = TREE_DECORATOR_TYPES.register("firg", () -> {
//        try {
//            return TreeDecoratorType.class.getDeclaredConstructor(Codec.class).newInstance(FirgTreeDecorator.CODEC);
//        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    });
//
//    public static <T extends TreeDecorator> TreeDecoratorType<T> register(String name) {
//        return TREE_DECORATOR_TYPES.register(name, () -> {
//            try {
//                return TreeDecoratorType.class.getDeclaredConstructor(Codec.class).newInstance(FirgTreeDecorator.CODEC);
//            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }).get();
//    }

    public static void register() {
        Ervin_mod_1.register(ModTreeDecorators.class);
    }
}
