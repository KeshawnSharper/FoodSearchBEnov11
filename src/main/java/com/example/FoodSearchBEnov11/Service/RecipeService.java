package com.example.FoodSearchBEnov11.Service;

import com.example.FoodSearchBEnov11.Models.Recipe;
import com.example.FoodSearchBEnov11.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipe) {
        recipe.setId(id);
        return recipeRepository.save(recipe);
    }
    public void deleteRecipe(Long id) {
        recipeRepository.findById(id).orElseThrow(()-> new RuntimeException());
        recipeRepository.deleteById(id);
    }

}
