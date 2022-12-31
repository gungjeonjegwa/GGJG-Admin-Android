package com.example.ggjg_admin.ui.main

import android.os.Handler
import android.view.View
import androidx.navigation.findNavController
import com.example.ggjg_admin.R
import com.example.ggjg_admin.databinding.FragmentMainBinding
import com.example.ggjg_andorid.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun createView() {
        initView()
    }

    private fun initView() = binding.apply {
        main = this@MainFragment
        Handler().postDelayed({
            val btnHeight = breadBtn.width
            val betweenHeight = betweenView.width
            listOf(orderBtn, clientBtn, breadBtn, qaAndReviewBtn, bannerBtn).forEach {
                it.layoutParams = it.layoutParams.apply {
                    height = btnHeight
                }
            }
            listOf(firstDivide, secondDivide).forEach {
                it.layoutParams = it.layoutParams.apply {
                    height = betweenHeight
                }
            }
        }, 1)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.orderBtn -> requireActivity().findNavController(R.id.mainContainer)
                .navigate(R.id.action_mainFragment_to_orderFragment)
            R.id.clientBtn -> requireActivity().findNavController(R.id.mainContainer)
                .navigate(R.id.action_mainFragment_to_clientFragment)
            R.id.breadBtn -> requireActivity().findNavController(R.id.mainContainer)
                .navigate(R.id.action_mainFragment_to_breadFragment)
            R.id.qaAndReviewBtn -> requireActivity().findNavController(R.id.mainContainer)
                .navigate(R.id.action_mainFragment_to_QAFragment)
            R.id.bannerBtn -> requireActivity().findNavController(R.id.mainContainer)
                .navigate(R.id.action_mainFragment_to_bannerFragment)
        }
    }
}