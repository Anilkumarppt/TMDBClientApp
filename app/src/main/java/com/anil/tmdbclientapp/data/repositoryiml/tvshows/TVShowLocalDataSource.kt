package com.anil.tmdbclientapp.data.repositoryiml.tvshows

import com.anil.tmdbclientapp.data.model.tvshow.TVShow

interface TVShowLocalDataSource {

    suspend fun getPopularTVShowsFromLocalDB():List<TVShow>

    suspend fun saveTVShowsToLocalDB(tvshows:List<TVShow>)

    suspend fun deleteTVShowsFromLocalDB()
}