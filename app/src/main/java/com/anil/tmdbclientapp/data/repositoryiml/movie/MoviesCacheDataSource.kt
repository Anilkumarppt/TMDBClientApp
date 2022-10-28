package com.anil.tmdbclientapp.data.repositoryiml.movie

import com.anil.tmdbclientapp.data.model.movie.Movie

interface MoviesCacheDataSource {

    suspend fun saveMoviesToCache(movies:List<Movie>)

    suspend fun getMoviesFromCache():List<Movie>
}