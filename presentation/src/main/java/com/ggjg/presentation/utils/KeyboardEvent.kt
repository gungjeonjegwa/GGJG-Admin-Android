package com.ggjg.presentation.utils

import android.app.Activity
import android.os.Handler
import android.widget.EditText
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

fun keyboardHide(context: Activity, viewList: List<EditText>) {
    viewList.forEach { view ->
        view.clearFocus()
    }
    val window = context.window
    WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.ime())
}

fun keyboardShow(context: Activity, view: EditText) {
    view.requestFocus()
    Handler().postDelayed({
        val window = context.window
        WindowInsetsControllerCompat(window, window.decorView).show(WindowInsetsCompat.Type.ime())
    }, 100)
}