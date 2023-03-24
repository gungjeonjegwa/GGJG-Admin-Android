package com.ggjg.presentation.ui.bread

import android.view.View
import androidx.navigation.fragment.findNavController
import com.ggjg.presentation.R
import com.ggjg.presentation.databinding.FragmentBreadBinding
import com.ggjg.presentation.ui.base.BaseFragment

class BreadFragment : BaseFragment<FragmentBreadBinding>(R.layout.fragment_bread) {
    override fun createView() {
        binding.breadFragment = this
    }

    fun onClick(view: View) {
        when (view) {
            binding.backBtn -> {
                findNavController().popBackStack()
            }
        }
    }
}