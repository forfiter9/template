package com.example.tomek.cardsgame.shared.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

@BindingAdapter("android:src")
fun setImage(imageView: ImageView, url: String) {
    Picasso.get().load(url).transform(CropCircleTransformation()).into(imageView)
}
