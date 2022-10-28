package com.anil.tmdbclientapp.domain.repository

import com.anil.tmdbclientapp.data.model.aritist.Artist

interface ArtistsRepository {

    suspend fun getPopularArtists():List<Artist>?

    suspend fun updateArtistList():List<Artist>?
}