package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.recipe.$.$ShapedRecipe;
import com.babcsany.minecraft.ervin_mod_1.recipe.$.$ShapelessRecipe;
import com.babcsany.minecraft.ervin_mod_1.recipe.$.I$Recipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {

	public static final IRecipeSerializer<$ShapedRecipe> $_SHAPED_RECIPE_SERIALIZER = new $ShapedRecipe.Serializer();
	public static final IRecipeSerializer<$ShapelessRecipe> $_SHAPELESS_RECIPE_SERIALIZER = new $ShapelessRecipe.Serializer();
	public static final IRecipeType<I$Recipe> $_RECIPE_TYPE = registerType(I$Recipe.RECIPE_TYPE_ID);

	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
			ForgeRegistries.RECIPE_SERIALIZERS, Ervin_mod_1.MOD_ID);

	public static final RegistryObject<IRecipeSerializer<?>> $_SHAPED_SERIALIZER = RECIPE_SERIALIZERS.register("$",
			() -> $_SHAPED_RECIPE_SERIALIZER);
	public static final RegistryObject<IRecipeSerializer<?>> $_SHAPELESS_SERIALIZER = RECIPE_SERIALIZERS.register("$",
			() -> $_SHAPELESS_RECIPE_SERIALIZER);

	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
		@Override
		public String toString() {
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
	
	private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}
}
