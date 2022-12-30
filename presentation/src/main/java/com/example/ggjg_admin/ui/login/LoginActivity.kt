package com.example.ggjg_admin.ui.login

import android.content.Intent
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.example.ggjg_admin.R
import com.example.ggjg_admin.databinding.ActivityLoginBinding
import com.example.ggjg_admin.utils.extension.changeActivatedWithEnabled
import com.example.ggjg_admin.utils.extension.setOnTextChanged
import com.example.ggjg_admin.utils.extension.setVisible
import com.example.ggjg_admin.utils.keyboardHide
import com.example.ggjg_admin.utils.keyboardShow
import com.example.ggjg_andorid.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun createView() {
        binding.login = this
        initView()
    }

    private fun initView() = binding.apply {
        editId.run {
            setOnTextChanged { p0, _, _, _ ->
                deleteIdBtn.setVisible(!p0.isNullOrBlank())
                loginBtn.changeActivatedWithEnabled(!p0.isNullOrBlank() && !binding.editPw.text.isNullOrBlank())
            }
            setOnFocusChangeListener { _, b ->
                writeId.isActivated = b
            }
        }
        editPw.run {
            setOnTextChanged { p0, _, _, _ ->
                visibleBtn.setVisible(!p0.isNullOrBlank())
                loginBtn.changeActivatedWithEnabled(!p0.isNullOrBlank() && !binding.editId.text.isNullOrBlank())
            }
            setOnFocusChangeListener { _, b ->
                writePw.isActivated = b
            }
        }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.backBtn -> {
                finish()
            }
            R.id.loginLayout -> {
                keyboardHide(this, listOf(binding.editId, binding.editPw))
            }
            R.id.visibleBtn -> {
                binding.editPw.apply {
                    if (transformationMethod == HideReturnsTransformationMethod.getInstance()) {
                        transformationMethod = PasswordTransformationMethod.getInstance()
                        view.setBackgroundResource(R.drawable.ic_pw_visible)
                    } else {
                        transformationMethod = HideReturnsTransformationMethod.getInstance()
                        view.setBackgroundResource(R.drawable.ic_pw_invisible)
                    }
                    setSelection(length())
                }
            }
            R.id.deleteIdBtn -> {
                keyboardShow(this, binding.editId)
                binding.editId.setText(null)
            }
            R.id.loginBtn -> {
            }
        }
    }
}