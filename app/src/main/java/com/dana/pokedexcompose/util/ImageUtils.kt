package com.dana.pokedexcompose.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.dana.pokedexcompose.R

const val DEFAULT_POKEMON_IMAGE = R.drawable.pokeball

@Composable
fun loadPicture(
    url: String,
    @DrawableRes defaultImage: Int
):MutableState<Bitmap?>{

    val bitmapState: MutableState<Bitmap?> = remember { mutableStateOf(null) }

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .dontAnimate()
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }

        })

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .dontAnimate()
        .skipMemoryCache(false)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })

    return bitmapState
}