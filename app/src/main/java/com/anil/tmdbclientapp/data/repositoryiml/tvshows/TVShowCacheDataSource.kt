package com.anil.tmdbclientapp.data.repositoryiml.tvshows

import com.anil.tmdbclientapp.data.model.tvshow.TVShow

interface TVShowCacheDataSource {

    suspend fun saveTvShowsToCache(tvShows:List<TVShow>)

    suspend fun getTVShowsFromCache():List<TVShow>

}