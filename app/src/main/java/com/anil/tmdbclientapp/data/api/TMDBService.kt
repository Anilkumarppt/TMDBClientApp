package com.anil.tmdbclientapp.data.api


import com.anil.tmdbclientapp.data.model.aritist.ArtistList
import com.anil.tmdbclientapp.data.model.movie.MovieList
import com.anil.tmdbclientapp.data.model.tvshow.TVShowsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apikey:String
    ):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(
        @Query("api_key") apikey:String
    ):Response<TVShowsList>

    @GET("tv/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apikey:String
    ):Response<ArtistList>

}