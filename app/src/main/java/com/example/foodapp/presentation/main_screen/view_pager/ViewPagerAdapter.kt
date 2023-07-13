package com.example.foodapp.presentation.main_screen.view_pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemRecommendationEventBinding
import com.example.foodapp.domain.models.RecommendationEvent

class ViewPagerAdapter: RecyclerView.Adapter<ViewPagerViewHolder>() {

    private val events = mutableListOf<RecommendationEvent>()

    fun updateData(newList: List<RecommendationEvent>){
        events.clear()
        events.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_recommendation_event, parent, false)
        val binding = ItemRecommendationEventBinding.bind(view)
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int =events.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(events[position])
    }
}