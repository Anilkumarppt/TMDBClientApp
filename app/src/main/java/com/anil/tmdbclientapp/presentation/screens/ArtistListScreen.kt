package com.anil.tmdbclientapp.presentation.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anil.tmdbclientapp.data.model.aritist.Artist
import com.anil.tmdbclientapp.presentation.artist.ArtistViewModel

@Composable
fun MainArtistListScreen(navController: NavController,artistViewModel: ArtistViewModel){
    val artistlist=artistViewModel.getPopularArtists().collectAsState(initial = emptyList())
    LazyColumn(modifier = Modifier.fillMaxHeight()){
        item(artistlist) {

        }
    }
}

@Composable
fun ArtistCard(artist: Artist){
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(8.dp),
        elevation = 10.dp,
        backgroundColor = Color.LightGray
    ){

    }
}
