package com.babcsany.minecraft.ervin_mod_1.item.crafting;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.crafting.book.BlackBookCloningRecipe;
import com.babcsany.minecraft.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.BookCloningRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit<T extends IRecipe<?>> {

    public static RecipeSerializerInit<?> RECIPE_SERIALIZERS;

    public static SpecialRecipeSerializer<BlackBookCloningRecipe> CRAFTING_SPECIAL_BOOKCLONING = register("ervin_mod_1:crafting_special_black_book_cloning", new SpecialRecipeSerializer<>(BlackBookCloningRecipe::new));

    static <S extends IRecipeSerializer<T>, T extends IRecipe<?>> S register(String key, S recipeSerializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, key, recipeSerializer);
    }
}
