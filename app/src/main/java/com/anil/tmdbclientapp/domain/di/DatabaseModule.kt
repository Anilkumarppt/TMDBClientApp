package com.anil.tmdbclientapp.domain.di

import android.content.Context
import androidx.room.Room
import com.anil.tmdbclientapp.data.db.ArtistDao
import com.anil.tmdbclientapp.data.db.MovieDao
import com.anil.tmdbclientapp.data.db.TMDBDatabase
import com.anil.tmdbclientapp.data.db.TvShowsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule
{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java,"movie_database").build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }
    @Provides
    @Singleton
    fun provideTVShowDao(tmdbDatabase: TMDBDatabase): TvShowsDao {
        return tmdbDatabase.tvshowDao()
    }
    @Provides
    @Singleton
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artisDao()
    }

}