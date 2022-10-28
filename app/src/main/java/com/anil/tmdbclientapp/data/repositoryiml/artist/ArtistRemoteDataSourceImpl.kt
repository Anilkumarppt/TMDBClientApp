package com.anil.tmdbclientapp.data.repositoryiml.artist

import com.anil.tmdbclientapp.data.api.TMDBService
import com.anil.tmdbclientapp.data.model.aritist.ArtistList
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class ArtistRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apikey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtistFromAPI(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apikey)
    }

}