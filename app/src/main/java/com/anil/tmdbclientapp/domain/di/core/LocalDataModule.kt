package com.anil.tmdbclientapp.domain.di.core

import com.anil.tmdbclientapp.data.db.ArtistDao
import com.anil.tmdbclientapp.data.db.MovieDao
import com.anil.tmdbclientapp.data.db.TvShowsDao
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistLocalDBSourceImpl
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistLocalDataSource
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieLocalDataSource
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieLocalDataSourceImpl
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowLocalDBSourceImpl
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowsDao): TVShowLocalDataSource {
        return TVShowLocalDBSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDBSourceImpl(artistDao)
    }


}