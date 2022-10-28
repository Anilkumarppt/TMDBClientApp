package com.anil.tmdbclientapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anil.tmdbclientapp.data.model.aritist.Artist


@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artistList:List<Artist>)

    @Query("SELECT * FROM popular_artist")
    suspend fun getPopularArtistFromDB():List<Artist>

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtists()
}