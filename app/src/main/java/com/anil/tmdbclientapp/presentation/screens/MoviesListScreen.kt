@file:OptIn(ExperimentalFoundationApi::class)

package com.anil.tmdbclientapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.anil.tmdbclientapp.presentation.TMDTopAppBar
import com.anil.tmdbclientapp.presentation.movies.MoviesViewModel
import com.anil.tmdbclientapp.presentation.ui.theme.Purple200
import com.anil.tmdbclientapp.presentation.ui.theme.md_theme_dark_surface
import com.anil.tmdbclientapp.presentation.ui.theme.md_theme_light_onBackground
import kotlinx.coroutines.CoroutineScope

const val TAG: String = "Movies List Screen "

@Composable
fun MoviesListScreen(navController: NavController, moviesViewModel: MoviesViewModel) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val snackBarScope: CoroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TMDTopAppBar(scaffoldState = scaffoldState, snackBarScope = snackBarScope)
        },
        backgroundColor = md_theme_light_onBackground
    ) {
        MoviesListScreenContent(
            modifier = Modifier.padding(it),
            scaffoldState = scaffoldState,
            snackbarScope = snackBarScope,
            moviesViewModel = moviesViewModel
        )
    }
}

@Composable
fun MoviesListScreenContent(
    modifier: Modifier,
    scaffoldState: ScaffoldState,
    snackbarScope: CoroutineScope,
    moviesViewModel: MoviesViewModel
) {
    val moviesList by moviesViewModel.latestMovies().collectAsState(initial = emptyList())
    //val savedListState = rememberLazyListState(scrollingListPosition)
    Column(
        modifier = modifier
            .background(md_theme_dark_surface)
            .fillMaxSize()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.
                        fillMaxWidth()) {
            Text(
                text = "POPULAR",
                style = MaterialTheme.typography.button,
                fontSize = 10.sp,
                color = Purple200,
                modifier=Modifier.padding(5.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "SEE ALL",
                style = MaterialTheme.typography.button,
                fontSize = 10.sp,
                color = Purple200,
                modifier=Modifier.padding(5.dp),
                textAlign = TextAlign.Center
            )
        }
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            content = {
                items(moviesList) {
                    MovieItem(scaffoldState = scaffoldState, scope = snackbarScope, movie = it)
                }
            })
    }

}


/*@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .size(200.dp, 250.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)),
        elevation = 0.dp
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            val posterPainter = rememberImagePainter(
                data = movie.posterPath,
                builder = {
                    crossfade(true)
                    scale(Scale.FILL)
                })
            Image(
                painter = posterPainter,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {
                    })
            )
            Column(
                modifier = Modifier.align(Alignment.Top)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(8.dp),
                    color = Color.Black
                )
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.body2,
                    maxLines = 5,
                    modifier = Modifier.padding(8.dp),
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black

                )
                ReleaseDateText(
                    releaseDate = movie.releaseDate,
                    tint = MaterialTheme.colors.onSurface.copy()
                )
                MovieRating(
                    rating = movie.voteAverage.toString(),
                    tint = MaterialTheme.colors.onSurface.copy()
                )
            }


        }
    }

}*/

@Composable
fun ReleaseDateText(releaseDate: String, tint: Color) {
    Row(horizontalArrangement = Arrangement.Center) {
        Icon(Icons.Filled.DateRange, contentDescription = releaseDate, tint = tint)
        Text(
            text = releaseDate,
            Modifier.padding(start = 6.dp),
            style = MaterialTheme.typography.body2,
            color = Color.Black
        )
    }
}

@Composable
fun MovieRating(rating: String, tint: Color) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Icon(imageVector = Icons.Filled.StarRate, contentDescription = "Rating", tint = tint)
        Text(
            text = rating,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DisplayPreview() {
    //MovieItem(Movie(1,"Batman ventures into Gotham City's underworld when a sadistic killer leaves behind a trail of cryptic clues. As the evidence begins to lead closer to home and the scale of the perpetrator's plans become clear, he must forge new relationships, unmask the culprit and bring justice to the abuse of power and corruption that has long plagued the metropolis.","https://image.tmdb.org/t/p/w500/yw8NQyvbeNXoZO6v4SEXrgQ27Ll.jpg","26-10-2022","Batman",false,2.0,2))
    TestScreen()
}