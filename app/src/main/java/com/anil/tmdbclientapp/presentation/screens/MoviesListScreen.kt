package com.anil.tmdbclientapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.anil.tmdbclientapp.R
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.anil.tmdbclientapp.data.model.movie.Movie
import com.anil.tmdbclientapp.presentation.movies.MoviesViewModel

const val TAG:String="Movies List Screen "
@Composable
fun MoviesListScreen(navController: NavController,moviesViewModel: MoviesViewModel){
    val movieslist by moviesViewModel.latestMovies().collectAsState(initial = emptyList())
    LazyColumn(modifier = Modifier.fillMaxHeight()){
        items(movieslist){
            MovieItem(it)
        }
    }
    Log.d(TAG, "MoviesListScreen: ${movieslist!!.size}")
}

@Composable
fun MovieItem(movie: Movie){
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(8.dp),
        elevation = 10.dp,
        backgroundColor = Color.LightGray
    ) {
        Row(verticalAlignment = Alignment.Top) {
            Image(
                painter = rememberImagePainter(
                    data = movie.posterPath,
                    builder = {
                        size(OriginalSize)
                        placeholder(R.drawable.poster_loading)
                        error(R.drawable.poster_error)
                    },
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.weight(1F)
            )
            Column(
                Modifier
                    .weight(1F)
                    .padding(16.dp),
                    Arrangement.Top,
                    Alignment.Start
            ) {
                Text(
                    "${movie.title}",
                    modifier = Modifier.padding(bottom = 12.dp),
                    style = MaterialTheme.typography.subtitle2
                )
                Box(){
                    Text(
                        text = "${movie.overview}",
                        modifier = Modifier.padding(12.dp),
                        style = MaterialTheme.typography.body2,
                        fontSize = 10.sp
                    )
                }

                Box(Modifier.padding(bottom = 16.dp)) {
                    ReleaseDateText(
                        movie.releaseDate,
                        MaterialTheme.colors.onSurface.copy(alpha = 0.6F)
                    )
                }
                Box(Modifier.padding(bottom = 8.dp)) {
                    ReleaseDateText(
                        movie.voteAverage.toString(),
                        MaterialTheme.colors.onSurface.copy(alpha = 0.6F)
                    )
                }
            }
        }
    }
}
@Composable
fun ReleaseDateText(releaseDate:String,tint:Color){
    Row(horizontalArrangement = Arrangement.Center){
        Icon(Icons.Filled.DateRange, contentDescription = releaseDate, tint = tint)
        Text(text = releaseDate,
            Modifier.padding(start = 6.dp),fontSize = 14.sp, color = tint)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DisplayPreview(){
    MovieItem(Movie(1,"BatMan","https://image.tmdb.org/t/p/w500/yw8NQyvbeNXoZO6v4SEXrgQ27Ll.jpg","","Batman",false,2.0,2))
}