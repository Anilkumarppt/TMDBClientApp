package com.anil.tmdbclientapp.domain.di.artist

import com.anil.tmdbclientapp.domain.useCases.GetArtistsListUseCase
import com.anil.tmdbclientapp.domain.useCases.UpdateArtistsListUseCase

import com.anil.tmdbclientapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ArtistModule {
    @ActivityScoped
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCaseUseCase: GetArtistsListUseCase,
        updateArtistsUseCaseUseCase: UpdateArtistsListUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCaseUseCase,
            updateArtistsUseCaseUseCase
        )
    }

}