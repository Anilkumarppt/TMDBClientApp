package com.anil.tmdbclientapp.data.repositoryiml.artist

import com.anil.tmdbclientapp.data.model.aritist.Artist
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList=ArrayList<Artist>()

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList= ArrayList(artists)
    }

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }
}