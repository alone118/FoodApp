package com.example.foodapp.presentation.main_screen

import android.os.Bundle
import android.os.UserHandle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMainBinding
import com.example.foodapp.domain.models.Recipe
import com.example.foodapp.domain.models.User
import com.example.foodapp.presentation.main_screen.recycler_view.food_category.FoodCategoryAdapter
import com.example.foodapp.presentation.main_screen.recycler_view.listeners.RecipeItemOnClickListeners
import com.example.foodapp.presentation.main_screen.recycler_view.recipe.RecipeAdapter
import com.example.foodapp.presentation.main_screen.view_pager.ViewPagerAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FragmentMain : Fragment(), RecipeItemOnClickListeners {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val viewModel: FragmentMainViewModel = FragmentMainViewModel()

    private val viewPagerAdapter: ViewPagerAdapter by lazy {
        ViewPagerAdapter()
    }

    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter(this)
    }

    private val categoryAdapter: FoodCategoryAdapter by lazy {
        FoodCategoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupSearchView()
        observeData()
    }

    private fun setupSearchView() {
        binding.mainContent.searchView.setupSearchViewParams()
    }

    private fun initViews() = with(binding) {
        mainContent.viewPager.adapter = viewPagerAdapter
        mainContent.recyclerView.adapter = recipeAdapter
        mainContent.foodCategoryRecyclerView.adapter = categoryAdapter
    }

    private fun observeData() {
        viewModel.uiStateFlow.onEach { uiState ->
            viewPagerAdapter.updateData(uiState.recommendationEvents)
            recipeAdapter.updateData(uiState.recipes)
            categoryAdapter.updateData(uiState.foodCategory)
            showUserInfo(uiState.currentUser)
        }.launchIn(lifecycleScope)
    }

    private fun showUserInfo(user: User) {
        Glide.with(requireActivity())
            .load(user.avatarUrl)
            .into(binding.mainTopContent.avatarImageView)
    }

    override fun onRecipeClick(recipe: Recipe) {
        findNavController().navigate(FragmentMainDirections.actionFragmentMainToFragmentRecipeDetails(recipe))
    }
}

fun SearchView.setupSearchViewParams() {
    val searchText = this.findViewById<View>(
        this.context.resources.getIdentifier(
            "android:id/search_src_text",
            null,
            null
        )
    ) as AutoCompleteTextView
    searchText.setTextSize(
        TypedValue.COMPLEX_UNIT_PX,
        resources.getDimensionPixelSize(R.dimen.textSizeForSmallTexts).toFloat()
    )
    val typeface = ResourcesCompat.getFont(this.context, R.font.inter_light)
    searchText.typeface = typeface
}


