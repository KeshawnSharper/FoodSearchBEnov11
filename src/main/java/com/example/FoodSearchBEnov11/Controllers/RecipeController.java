package com.example.FoodSearchBEnov11.Controllers;

import com.example.FoodSearchBEnov11.Models.Recipe;
import com.example.FoodSearchBEnov11.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/recipes")


public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<String>("Recipe deleted Successfully.",HttpStatus.OK);
    }
    @GetMapping("/{user_email}")
    public List<Recipe> getRecipeByEmail(@PathVariable("user_email") String user_email) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        recipes = recipes.stream().filter(recipe -> recipe.user_email.equals(user_email)).toList();
        return recipes;
    }
}
