package com.anil.tmdbclientapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anil.tmdbclientapp.presentation.movies.MoviesViewModel
import com.anil.tmdbclientapp.presentation.screens.MainScreen
import com.anil.tmdbclientapp.presentation.screens.MoviesListScreen


@Composable
fun Navigation(){

    val navController= rememberNavController()
    val movieViewModel: MoviesViewModel = viewModel()



   /* val artistViewModel:ArtistViewModel= viewModel()
    val tvShowViewModel:TvShowViewModel= viewModel()*/

    NavHost(navController = navController, startDestination = TMDBAppScreen.HomeScreen.route ){
        composable(route = TMDBAppScreen.HomeScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = TMDBAppScreen.MoviesListScreen.route){
            MoviesListScreen(navController,movieViewModel)
        }
        /*composable(route = TMDBAppScreen.ArtistsListScreen.route){
            MainArtistListScreen(navController = navController, artistViewModel = artistViewModel)
       }
        composable(route = TMDBAppScreen.TVShowsListScreen.route){
            MainTVShowListScreen(navController = navController, tvShowViewModel =tvShowViewModel )
        }*/
    }
}