package com.anil.tmdbclientapp.presentation.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MovieCreation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.anil.tmdbclientapp.R
import com.anil.tmdbclientapp.data.model.movie.Movie
import com.anil.tmdbclientapp.presentation.LoadingIndicator
import com.anil.tmdbclientapp.presentation.Poster
import com.anil.tmdbclientapp.presentation.ui.theme.Purple200
import com.anil.tmdbclientapp.presentation.ui.theme.md_theme_dark_onSurface
import com.anil.tmdbclientapp.presentation.ui.theme.md_theme_light_background
import kotlinx.coroutines.CoroutineScope


@ExperimentalCoilApi
@Composable
fun PosterImage(
    poster: String?,
    title: String?,
    movieId: Int,
    scrollId: Int,
    onPosterClick: (Int, Int) -> Unit
) {
    val posterPainter = rememberImagePainter(
        data = poster,
        builder = {
            crossfade(true)
            scale(Scale.FILL)
        })
    Box(
        modifier = Modifier
            .height(278.dp),
    ) {
        Image(
            painter = posterPainter,
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    onPosterClick(movieId, scrollId)
                })
        )
        /*Spacer(modifier = Modifier.height(16.dp))
            Text(
                title!!,
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.body1,
                color = Color.White
            )*/
    }
    val imageState = posterPainter.state
    if (imageState is ImagePainter.State.Loading) {
        Box(
            Modifier
                .height(278.dp)
                .width(185.dp),
            Alignment.Center
        ) {
            LoadingIndicator()
        }
    }
    if (imageState is ImagePainter.State.Error) {
        Box(
            Modifier
                .height(278.dp)
                .width(185.dp)
                .border(
                    1.dp, MaterialTheme.colors.secondary.copy(alpha = 0.1F)
                ),
            Alignment.Center
        ) {
            Icon(
                Icons.Default.MovieCreation,
                title,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.Center),
                tint = Color.Black.copy(alpha = 0.2F)
            )
            if (title != null) {
                Text(
                    title,
                    Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 8.dp, start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun DisplayPreviewMovieItem() {

}