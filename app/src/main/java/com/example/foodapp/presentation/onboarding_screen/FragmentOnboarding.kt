package com.example.foodapp.presentation.onboarding_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentOnboardingBinding

class FragmentOnboarding : Fragment() {

    private val binding: FragmentOnboardingBinding by lazy {
        FragmentOnboardingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getStartedButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentOnboarding_to_fragmentMain)
        }
    }

}
