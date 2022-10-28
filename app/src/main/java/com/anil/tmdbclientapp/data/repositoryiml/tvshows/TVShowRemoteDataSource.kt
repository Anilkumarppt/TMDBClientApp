package com.anil.tmdbclientapp.data.repositoryiml.tvshows

import com.anil.tmdbclientapp.data.model.tvshow.TVShowsList
import retrofit2.Response

interface TVShowRemoteDataSource {

    suspend fun getPopularTVShows():Response<TVShowsList>
}