package com.anil.tmdbclientapp.domain.di.core

import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistCacheDataSource
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistCacheDataSourceImpl
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieCacheSourceImpl
import com.anil.tmdbclientapp.data.repositoryiml.movie.MoviesCacheDataSource
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowCacheDataSource
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MoviesCacheDataSource {
        return MovieCacheSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}