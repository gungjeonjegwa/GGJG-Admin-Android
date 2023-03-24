package com.ggjg.presentation.ui.client

import android.view.View
import androidx.navigation.fragment.findNavController
import com.ggjg.presentation.R
import com.ggjg.presentation.databinding.FragmentClientBinding
import com.ggjg.presentation.ui.base.BaseFragment

class ClientFragment : BaseFragment<FragmentClientBinding>(R.layout.fragment_client) {
    override fun createView() {
        binding.clientFragment = this
    }

    fun onClick(view: View) {
        when (view) {
            binding.backBtn -> {
                findNavController().popBackStack()
            }
        }
    }
}