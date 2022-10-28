package com.anil.tmdbclientapp.data.repositoryiml.artist

import com.anil.tmdbclientapp.data.db.ArtistDao
import com.anil.tmdbclientapp.data.model.aritist.Artist
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistLocalDataSource
import javax.inject.Inject

class ArtistLocalDBSourceImpl @Inject constructor(private val artistDao: ArtistDao) :
    ArtistLocalDataSource {


    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        artistDao.saveArtists(artists)
    }

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getPopularArtistFromDB()
    }

    override suspend fun updateArtistsToDB(artists: List<Artist>) {

    }

    override suspend fun clearAllArtistsFrom() {
         artistDao.deleteAllArtists()
    }
}