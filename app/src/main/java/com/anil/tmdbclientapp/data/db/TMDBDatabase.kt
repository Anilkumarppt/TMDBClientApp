package com.anil.tmdbclientapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anil.tmdbclientapp.data.model.aritist.Artist
import com.anil.tmdbclientapp.data.model.movie.Movie
import com.anil.tmdbclientapp.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class, TVShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase :RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvshowDao(): TvShowsDao
    abstract fun artisDao(): ArtistDao
}