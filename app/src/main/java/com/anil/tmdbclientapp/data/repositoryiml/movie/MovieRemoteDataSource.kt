package com.anil.tmdbclientapp.data.repositoryiml.movie

import com.anil.tmdbclientapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource  {
    suspend fun getMovies():Response<MovieList>
}