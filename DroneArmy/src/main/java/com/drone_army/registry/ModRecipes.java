package com.drone_army.registry;

import com.drone_army.DroneArmyMod;
import com.drone_army.recipe.EssenceRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<EssenceRecipe> ESSENCE_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER,
            Identifier.of(DroneArmyMod.MOD_ID, "essence_recipe"),
            new SpecialRecipeSerializer<>(EssenceRecipe::new));

    public static void registerRecipes() {
        DroneArmyMod.LOGGER.info("Registering Recipes for " + DroneArmyMod.MOD_ID);
    }
}
