package com.example.myapplication.interface_adapters.presenter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageURL")
fun ImageView.imageURL(url: String) {
    Glide.with(this)
        .load(url)
        .placeholder(ColorDrawable(Color.TRANSPARENT))
        .into(this)
}