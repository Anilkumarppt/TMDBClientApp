package com.anil.tmdbclientapp.data.repositoryiml.movie

import com.anil.tmdbclientapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromLocalDB():List<Movie>
    suspend fun saveMoviesToLocalDB(moviesList:List<Movie>)
    suspend fun clearAllMovies()
}