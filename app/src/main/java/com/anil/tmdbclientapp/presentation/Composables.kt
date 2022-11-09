package com.anil.tmdbclientapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MovieCreation
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.anil.tmdbclientapp.R
import com.anil.tmdbclientapp.presentation.ui.theme.md_theme_light_background
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TMDTopAppBar(scaffoldState: ScaffoldState, snackBarScope: CoroutineScope) {

    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Menu"
                )

            }
        }, actions = {
            IconButton(onClick = {
                snackBarScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("TODO implement search")
                }
            }) {
                Icon(Icons.Filled.Search, contentDescription = "Search movies")
            }
        },
    )
}

@Composable
fun Poster(posterData:String,onPosterClick:()->Unit,title:String){
    val posterPainter = rememberImagePainter(
        data = posterData,
        builder = {
            crossfade(true)
            scale(Scale.FILL)})

    Image(
        painter = posterPainter,
        contentDescription = title,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                onPosterClick()
            })
    )
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
@Composable
fun LoadingIndicator() {
    Box( contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun LoadingPreview() {
    LoadingIndicator()
}

@Composable
fun EmptyListWarning(modifier: Modifier, message: String, actionText: String, onButtonClick:() -> Unit) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            message,
            Modifier
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.body1
        )
        Button(
            onClick = {
                onButtonClick()
            },
            Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(actionText)
        }
    }
}

@Preview
@Composable
fun EmptyListPreview() {
    val modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    EmptyListWarning(modifier, "Message to user", "Try again", onButtonClick = {})
}