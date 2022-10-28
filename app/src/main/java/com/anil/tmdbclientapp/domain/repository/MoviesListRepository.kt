package com.anil.tmdbclientapp.domain.repository

import com.anil.tmdbclientapp.data.model.movie.Movie

interface MoviesListRepository {
    suspend fun getPopularMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}