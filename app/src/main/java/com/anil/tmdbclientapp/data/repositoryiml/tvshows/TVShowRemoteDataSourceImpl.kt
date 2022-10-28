package com.anil.tmdbclientapp.data.repositoryiml.tvshows

import com.anil.tmdbclientapp.data.api.TMDBService
import com.anil.tmdbclientapp.data.model.tvshow.TVShowsList
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TVShowRemoteDataSourceImpl @Inject constructor(private val tmdbService: TMDBService, private val apiKey:String):
    TVShowRemoteDataSource {

    override suspend fun getPopularTVShows(): Response<TVShowsList> {
        return tmdbService.getPopularTVShows(apiKey)
    }

}