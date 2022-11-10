package com.anil.tmdbclientapp.data.repositoryiml.movie

import com.anil.tmdbclientapp.data.api.TMDBService
import com.anil.tmdbclientapp.data.model.movie.MovieList
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val tmdbService: TMDBService, private val apiKey:String) :
    MovieRemoteDataSource {

    override suspend fun getPopularMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}