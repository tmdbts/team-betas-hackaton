package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.controllers.assembler.RecepiToDto;
import org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/recipe")
public class RecipesController {

    RecipeService recipeService;
    RecepiToDto recepiToDto;

    @Autowired
    public void setRecepiToDto(RecepiToDto recepiToDto) {
        this.recepiToDto = recepiToDto;
    }


    @Autowired
    public void setRecipesService(RecipeService recipesService) {
        this.recipeService = recipesService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String showOrder(@PathVariable Integer id, Model model){
        Recipe recipe = recipeService.get(id);
        RecipeDto recipeDto = recepiToDto.convert(recipe);
        model.addAttribute(recipeDto);
        return "recipe";
    }
}