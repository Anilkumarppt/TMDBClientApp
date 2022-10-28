package com.anil.tmdbclientapp.domain.di.movie

import com.anil.tmdbclientapp.domain.useCases.GetMoviesUseCase
import com.anil.tmdbclientapp.domain.useCases.UpdateMovieUseCase
import com.anil.tmdbclientapp.presentation.movies.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieModule {
    @ActivityScoped
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}