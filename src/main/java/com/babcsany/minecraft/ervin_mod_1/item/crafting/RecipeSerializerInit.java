package com.babcsany.minecraft.ervin_mod_1.item.crafting;

import com.babcsany.minecraft.ervin_mod_1.item.crafting.book.BlackBookCloningRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;

public class RecipeSerializerInit<T extends IRecipe<?>> {

    public static SpecialRecipeSerializer<BlackBookCloningRecipe> CRAFTING_SPECIAL_BOOKCLONING = register("ervin_mod_1:crafting_special_black_book_cloning", new SpecialRecipeSerializer<>(BlackBookCloningRecipe::new));

    static <S extends IRecipeSerializer<T>, T extends IRecipe<?>> S register(String key, S recipeSerializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, key, recipeSerializer);
    }
}
