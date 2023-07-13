package com.example.foodapp.domain.use_cases

import com.example.foodapp.domain.models.FoodCategory
import com.example.foodapp.domain.repositories.FoodRepository

class FetchAllFoodCategories(
    private val repository: FoodRepository
) {

    operator fun invoke(): List<FoodCategory> {
        return repository.fetchAllFoodCategories()
    }

}