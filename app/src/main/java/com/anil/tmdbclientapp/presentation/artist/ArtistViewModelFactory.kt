package com.anil.tmdbclientapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anil.tmdbclientapp.domain.useCases.GetArtistsListUseCase
import com.anil.tmdbclientapp.domain.useCases.UpdateArtistsListUseCase


class ArtistViewModelFactory(
    private val getArtistsUseCaseUseCase: GetArtistsListUseCase,
    private val updateArtistsUseCaseUseCase: UpdateArtistsListUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(
            getArtistsUseCaseUseCase,
            updateArtistsUseCaseUseCase
        ) as T
    }
}