package com.example.foodapp.domain.use_cases

import com.example.foodapp.domain.models.FoodCategory
import com.example.foodapp.domain.models.Recipe
import com.example.foodapp.domain.repositories.FoodRepository

class FetchAllRecipeUseCases (
    private val repository: FoodRepository
    ){
    operator fun invoke(): List<Recipe> {
        return repository.fetchAllRecipe()
    }
}