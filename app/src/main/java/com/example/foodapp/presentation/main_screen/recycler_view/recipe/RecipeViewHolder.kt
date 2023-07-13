package com.example.foodapp.presentation.main_screen.recycler_view.recipe

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.ItemRecipeBinding
import com.example.foodapp.domain.models.FoodCategory
import com.example.foodapp.domain.models.Recipe
import com.example.foodapp.presentation.main_screen.recycler_view.listeners.RecipeItemOnClickListeners

class RecipeViewHolder(
    private val binding: ItemRecipeBinding,
    private val listener: RecipeItemOnClickListeners
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: Recipe) = with(binding) {
        root.setOnClickListener { listener.onRecipeClick(recipe) }

        titleTextView.text = recipe.title
        ratingTextView.text = recipe.rating.toString()

        loadImageByUrl(imageUrl = recipe.imageUrl, imageView = backgroundIv)
        loadImageByUrl(imageUrl = recipe.cook.avatarUrl, imageView = cookImageView)
    }

    private fun loadImageByUrl(imageUrl: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}