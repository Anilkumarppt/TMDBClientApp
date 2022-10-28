package com.anil.tmdbclientapp.data.repositoryiml.artist

import com.anil.tmdbclientapp.data.model.aritist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtistFromAPI():Response<ArtistList>

}