package com.anil.tmdbclientapp.data.repositoryiml.artist

import com.anil.tmdbclientapp.data.model.aritist.Artist

interface ArtistLocalDataSource {

    suspend fun saveArtistsToDB(artists:List<Artist>)

    suspend fun getArtistsFromDB():List<Artist>

    suspend fun updateArtistsToDB(artists: List<Artist>)

    suspend fun clearAllArtistsFrom()
}