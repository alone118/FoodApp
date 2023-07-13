package com.example.foodapp.presentation.main_screen

import android.arch.lifecycle.ViewModel
import com.example.foodapp.data.repositories.FoodRepositoryImpl
import com.example.foodapp.data.repositories.UsersRepositoryImpl
import com.example.foodapp.domain.models.FoodCategory
import com.example.foodapp.domain.models.Recipe
import com.example.foodapp.domain.models.RecommendationEvent
import com.example.foodapp.domain.models.User
import com.example.foodapp.domain.repositories.FoodRepository
import com.example.foodapp.domain.repositories.UsersRepository
import com.example.foodapp.domain.use_cases.FetchAllFoodCategories
import com.example.foodapp.domain.use_cases.FetchAllRecipeUseCases
import com.example.foodapp.domain.use_cases.FetchAllRecommendationEventsUseCase
import com.example.foodapp.domain.use_cases.FetchCurrentUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainFragmentUiState(
    val recommendationEvents: List<RecommendationEvent> = emptyList(),
    val recipes: List<Recipe> = emptyList(),
    val foodCategory: List<FoodCategory> = emptyList(),
    val currentUser: User = User.unknown()
)

class FragmentMainViewModel : ViewModel() {

    private val foodRepository: FoodRepository = FoodRepositoryImpl()
    private val usersRepository: UsersRepository = UsersRepositoryImpl()

    private val fetchAllRecommendationEventsUseCase = FetchAllRecommendationEventsUseCase(foodRepository)
    private val fetchAllRecipeUseCases = FetchAllRecipeUseCases(foodRepository)
    private val fetchAllFoodCategories = FetchAllFoodCategories(foodRepository)
    private val fetchCurrentUserUseCase = FetchCurrentUserUseCase(usersRepository)

    private val _uiStateFlow = MutableStateFlow(MainFragmentUiState())
    val uiStateFlow = _uiStateFlow.asStateFlow()

    init {
        val recommendationEvents = fetchAllRecommendationEventsUseCase.invoke()
        val recipes = fetchAllRecipeUseCases.invoke()
        val foodCategories = fetchAllFoodCategories.invoke()
        val currentUser = fetchCurrentUserUseCase.invoke()

        val iuState = MainFragmentUiState(
            recommendationEvents = recommendationEvents,
            recipes = recipes,
            foodCategory = foodCategories,
            currentUser = currentUser
        )
        _uiStateFlow.tryEmit(iuState)
    }
}