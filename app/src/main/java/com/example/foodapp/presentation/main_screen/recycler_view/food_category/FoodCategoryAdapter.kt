package com.example.foodapp.presentation.main_screen.recycler_view.food_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemFoodCategoryBinding
import com.example.foodapp.domain.models.FoodCategory

class FoodCategoryAdapter: RecyclerView.Adapter<FoodCategoryViewHolder>() {

    private val categories = mutableListOf<FoodCategory>()

    fun updateData(newList: List<FoodCategory>){
        categories.clear()
        categories.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoryViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_food_category, parent, false)

        val binding = ItemFoodCategoryBinding.bind(view)
        return FoodCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int =categories.size

    override fun onBindViewHolder(holder: FoodCategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }
}