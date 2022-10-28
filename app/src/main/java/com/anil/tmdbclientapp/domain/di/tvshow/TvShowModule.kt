package com.anil.tmdbclientapp.domain.di.tvshow


import com.anil.tmdbclientapp.domain.useCases.GetTvShowsUseCase

import com.anil.tmdbclientapp.domain.useCases.UpdateTvShowUseCase

import com.anil.tmdbclientapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class TvShowModule {
    @ActivityScoped
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}