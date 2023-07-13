package com.example.foodapp.domain.use_cases

import com.example.foodapp.domain.models.RecommendationEvent
import com.example.foodapp.domain.repositories.FoodRepository

class FetchAllRecommendationEventsUseCase (
    private val repositories: FoodRepository
        ) {

    operator fun invoke(): List<RecommendationEvent> {
        return repositories.fetchAllRecommendationEvents()
    }
}