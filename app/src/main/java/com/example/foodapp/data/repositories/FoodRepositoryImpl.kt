package com.example.foodapp.data.repositories

import com.example.foodapp.data.fake_data.FakeData
import com.example.foodapp.domain.models.FoodCategory
import com.example.foodapp.domain.models.Recipe
import com.example.foodapp.domain.models.RecommendationEvent
import com.example.foodapp.domain.repositories.FoodRepository

class FoodRepositoryImpl: FoodRepository {

    override fun fetchAllRecommendationEvents(): List<RecommendationEvent> {
        return FakeData.fakeRecommendationsEvents()
    }

    override fun fetchAllRecipe(): List<Recipe> {
        return FakeData.fakeRecipes()
    }

    override fun fetchAllFoodCategories(): List<FoodCategory> {
        return FakeData.fakeFoodCategory()
    }
}