package com.anil.tmdbclientapp.domain.di.core

import com.anil.tmdbclientapp.domain.repository.ArtistsRepository
import com.anil.tmdbclientapp.domain.repository.MoviesListRepository
import com.anil.tmdbclientapp.domain.repository.TvShowsRepository
import com.anil.tmdbclientapp.domain.useCases.*

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MoviesListRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MoviesListRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowsRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistsRepository): GetArtistsListUseCase {
        return GetArtistsListUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistsRepository): UpdateArtistsListUseCase {
        return UpdateArtistsListUseCase(artistRepository)
    }

}