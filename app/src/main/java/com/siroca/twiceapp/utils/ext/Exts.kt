package com.siroca.twiceapp.utils.ext

import android.view.View
import androidx.core.view.isVisible

fun View.visible() {
    this.isVisible = true
}

fun View.gone() {
    this.isVisible = false
}