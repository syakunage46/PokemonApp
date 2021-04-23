package com.example.myapplication.interface_adapters.presenter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageURL")
fun ImageView.imageURL(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}