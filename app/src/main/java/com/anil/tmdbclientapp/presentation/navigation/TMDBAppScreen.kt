package com.anil.tmdbclientapp.presentation.navigation

sealed class TMDBAppScreen(val route:String){
    object HomeScreen: TMDBAppScreen("home_screen")
    object MoviesListScreen: TMDBAppScreen("movies_list")
    object TVShowsListScreen: TMDBAppScreen("tvshows_list")
    object ArtistsListScreen: TMDBAppScreen("artist_list")

}