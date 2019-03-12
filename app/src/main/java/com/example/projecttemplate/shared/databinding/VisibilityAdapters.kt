package com.example.tomek.cardsgame.shared.databinding

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("android:visibility")
fun visibility(view: View, visibility: Boolean) {
    if (visibility)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}
