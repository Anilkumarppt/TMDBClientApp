package com.anil.tmdbclientapp.domain.di.core




import com.anil.tmdbclientapp.BuildConfig
import com.anil.tmdbclientapp.data.api.TMDBService
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistRemoteDataSource
import com.anil.tmdbclientapp.data.repositoryiml.artist.ArtistRemoteDataSourceImpl
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieRemoteDataSource
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieRemoteDataSourceImpl
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowRemoteDataSource
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowRemoteDataSourceImpl
import com.anil.tmdbclientapp.utils.APIConstants
import com.anil.tmdbclientapp.utils.APIConstants.API_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }


}