package com.anil.tmdbclientapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale

import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.anil.tmdbclientapp.R


@Composable
fun PosterDisplay(url:String){

    Image(painter = rememberImagePainter(data = url, builder = {
        size(OriginalSize).
        placeholder(R.drawable.poster_loading).
        error(R.drawable.poster_error)
        }),
        contentDescription =null,
        contentScale = ContentScale.Crop )

}