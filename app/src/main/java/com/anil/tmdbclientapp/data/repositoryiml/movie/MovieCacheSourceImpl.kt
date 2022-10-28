package com.anil.tmdbclientapp.data.repositoryiml.movie

import com.anil.tmdbclientapp.data.model.movie.Movie

class MovieCacheSourceImpl : MoviesCacheDataSource {

    private var moviesList = ArrayList<Movie>()
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }
}