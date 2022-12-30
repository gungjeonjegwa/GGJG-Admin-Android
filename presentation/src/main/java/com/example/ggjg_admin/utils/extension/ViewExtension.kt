package com.example.ggjg_admin.utils.extension

import android.view.View

fun View.setVisible(visible: Boolean = true) {
    this.visibility = if (visible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}