package com.example.foodapp.presentation.main_screen.recycler_view.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemRecipeBinding
import com.example.foodapp.domain.models.FoodCategory
import com.example.foodapp.domain.models.Recipe
import com.example.foodapp.presentation.main_screen.recycler_view.listeners.RecipeItemOnClickListeners

class RecipeAdapter(
    private val listener: RecipeItemOnClickListeners
) : RecyclerView.Adapter<RecipeViewHolder>() {

    private val recipes = mutableListOf<Recipe>()

    fun updateData(newList: List<Recipe>) {
        recipes.clear()
        recipes.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)

        val binding = ItemRecipeBinding.bind(view)
        return RecipeViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }
}