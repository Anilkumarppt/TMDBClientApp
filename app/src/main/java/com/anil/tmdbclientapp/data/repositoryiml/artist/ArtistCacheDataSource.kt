package com.anil.tmdbclientapp.data.repositoryiml.artist

import com.anil.tmdbclientapp.data.model.aritist.Artist

interface ArtistCacheDataSource {

    suspend fun saveArtistsToCache(artists:List<Artist>)

    suspend fun getArtistsFromCache():List<Artist>
}