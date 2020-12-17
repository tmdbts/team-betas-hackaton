package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.persistance.model.recipe.RecipeType;

import java.util.List;

public interface RecipeService {

    //generates a list of recipes of the same type
    List<Recipe> generateRecipeList (String recipeType);

}