package com.example.foodapp.domain.repositories

import com.example.foodapp.domain.models.FoodCategory
import com.example.foodapp.domain.models.Recipe
import com.example.foodapp.domain.models.RecommendationEvent

interface FoodRepository {

    fun fetchAllRecommendationEvents(): List<RecommendationEvent>

    fun fetchAllRecipe(): List<Recipe>

    fun fetchAllFoodCategories(): List<FoodCategory>

}