package com.ggjg.presentation.ui.order

import android.view.View
import androidx.navigation.fragment.findNavController
import com.ggjg.presentation.R
import com.ggjg.presentation.databinding.FragmentOrderBinding
import com.ggjg.presentation.ui.base.BaseFragment

class OrderFragment : BaseFragment<FragmentOrderBinding>(R.layout.fragment_order) {
    override fun createView() {
        binding.orderFragment = this
    }

    fun onClick(view: View) {
        when (view) {
            binding.backBtn -> {
                findNavController().popBackStack()
            }
        }
    }
}