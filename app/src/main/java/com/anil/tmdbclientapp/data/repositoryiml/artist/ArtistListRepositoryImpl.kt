package com.anil.tmdbclientapp.data.repositoryiml.artist

import android.util.Log
import com.anil.tmdbclientapp.data.model.aritist.Artist
import com.anil.tmdbclientapp.domain.repository.ArtistsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.HttpException

import javax.inject.Inject
import kotlin.Exception

class ArtistListRepositoryImpl @Inject constructor(
    private val remoteDataSource: ArtistRemoteDataSource,
    private val localDataSource: ArtistLocalDataSource,
    private val cacheDataSource: ArtistCacheDataSource
) : ArtistsRepository {
    override suspend fun getPopularArtists(): List<Artist>? {
        return getPopularArtisFromCache()
    }

    override suspend fun updateArtistList(): List<Artist>? {
        val artistsList=getPopularArtistsFromRemote()
        localDataSource.clearAllArtistsFrom()
        localDataSource.saveArtistsToDB(artistsList)
        cacheDataSource.saveArtistsToCache(artistsList)
        return artistsList
    }

    private suspend fun getPopularArtistsFromRemote(): List<Artist> {
        lateinit var artistsList: List<Artist>
        try {
            val result = remoteDataSource.getArtistFromAPI()
            result.let {
                if (it.isSuccessful)
                    artistsList = it.body()!!.results
                else
                    return emptyList()
            }
        } catch (httpException: HttpException) {
            Log.e("MyTag", "getPopularArtistsFromRemote: ${httpException.message!!}")
        } catch (exception: Exception) {
            Log.e("MyTag", "getPopularArtistsFromRemote: ${exception.message!!}")
        }
        return artistsList
    }

    private suspend fun getPopularArtistFromDB(): List<Artist> {
        lateinit var artistsList: List<Artist>
        CoroutineScope(IO).launch {
            val result = localDataSource.getArtistsFromDB()
            if (result.isEmpty()) {
                artistsList = result
            } else {
                artistsList = getPopularArtistsFromRemote()
                localDataSource.saveArtistsToDB(artistsList)
            }
        }
        return artistsList
    }
    private suspend fun getPopularArtisFromCache():List<Artist>{
        lateinit var artistsList: List<Artist>
        artistsList=cacheDataSource.getArtistsFromCache()

        if(artistsList.isEmpty() || artistsList.size<0){
           artistsList=getPopularArtistFromDB()
            cacheDataSource.saveArtistsToCache(artistsList)
        }
        return artistsList
    }
}