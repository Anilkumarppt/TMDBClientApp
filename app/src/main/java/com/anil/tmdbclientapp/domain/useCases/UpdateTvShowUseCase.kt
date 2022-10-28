package com.anil.tmdbclientapp.domain.useCases

import com.anil.tmdbclientapp.data.model.tvshow.TVShow
import com.anil.tmdbclientapp.domain.repository.TvShowsRepository
import javax.inject.Inject

class UpdateTvShowUseCase @Inject constructor(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute():List<TVShow>?=tvShowsRepository.updateTvShowsList()
}