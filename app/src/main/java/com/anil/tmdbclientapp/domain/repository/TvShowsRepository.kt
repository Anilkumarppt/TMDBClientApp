package com.anil.tmdbclientapp.domain.repository

import com.anil.tmdbclientapp.data.model.tvshow.TVShow

interface TvShowsRepository {

    suspend fun getTvShowsList():List<TVShow>?

    suspend fun updateTvShowsList():List<TVShow>?

}