package com.anil.tmdbclientapp.data.repositoryiml.tvshows

import com.anil.tmdbclientapp.data.model.tvshow.TVShow
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowCacheDataSource

class TVShowCacheDataSourceImpl : TVShowCacheDataSource {

    private var tvShowsList=ArrayList<TVShow>()
    override suspend fun saveTvShowsToCache(tvShows: List<TVShow>) {
        tvShowsList.clear()
        tvShowsList= ArrayList(tvShows)
    }

    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowsList
    }
}