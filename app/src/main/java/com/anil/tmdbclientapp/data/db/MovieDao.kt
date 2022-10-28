package com.anil.tmdbclientapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anil.tmdbclientapp.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(moviesList:List<Movie>)

    @Query("SELECT * FROM popular_movie")
    suspend fun getPopularMoviesFromDB():List<Movie>

    @Query("DELETE FROM popular_movie")
    suspend fun deleteAllMovies()
}