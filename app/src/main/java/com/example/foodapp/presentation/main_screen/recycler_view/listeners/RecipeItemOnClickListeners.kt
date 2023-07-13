package com.example.foodapp.presentation.main_screen.recycler_view.listeners

import com.example.foodapp.domain.models.Recipe

interface RecipeItemOnClickListeners {

    fun onRecipeClick(recipe: Recipe)
}