package com.example.FoodSearchBEnov11.Repository;

import com.example.FoodSearchBEnov11.Models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
