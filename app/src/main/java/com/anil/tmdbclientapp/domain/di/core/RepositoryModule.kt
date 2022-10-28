package com.anil.tmdbclientapp.domain.di.core

import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistCacheDataSource
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistListRepositoryImpl
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistLocalDataSource
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistRemoteDataSource
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieLocalDataSource
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieRemoteDataSource
import com.anil.tmdbclientapp.data.repositoryiml.movie.MoviesCacheDataSource
import com.anil.tmdbclientapp.data.repositoryiml.movie.MoviesRepositoryImpl
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowCacheDataSource
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowLocalDataSource
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowRemoteDataSource
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowRepositoryImpl
import com.anil.tmdbclientapp.domain.repository.ArtistsRepository
import com.anil.tmdbclientapp.domain.repository.MoviesListRepository
import com.anil.tmdbclientapp.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MoviesCacheDataSource
    ): MoviesListRepository {

        return MoviesRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TvShowsRepository {

        return TVShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {

        return ArtistListRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }

}