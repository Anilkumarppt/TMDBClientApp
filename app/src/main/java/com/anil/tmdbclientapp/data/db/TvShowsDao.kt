package com.anil.tmdbclientapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anil.tmdbclientapp.data.model.tvshow.TVShow


@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvshowsList:List<TVShow>)

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getPopularTvShowsFromDB():List<TVShow>

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShows()
}