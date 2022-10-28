package com.anil.tmdbclientapp.domain.useCases

import com.anil.tmdbclientapp.data.model.aritist.Artist
import com.anil.tmdbclientapp.domain.repository.ArtistsRepository
import javax.inject.Inject

class UpdateArtistsListUseCase @Inject constructor(private val artistsRepository: ArtistsRepository) {

    suspend fun execute():List<Artist>?= artistsRepository.updateArtistList()

}