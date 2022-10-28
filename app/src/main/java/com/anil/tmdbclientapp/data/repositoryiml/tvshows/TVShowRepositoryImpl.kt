package com.anil.tmdbclientapp.data.repositoryiml.tvshows

import android.util.Log
import com.anil.tmdbclientapp.data.model.tvshow.TVShow
import com.anil.tmdbclientapp.domain.repository.TvShowsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class TVShowRepositoryImpl @Inject constructor(
    private val remoteDataSource: TVShowRemoteDataSource,
    private val localDataSource: TVShowLocalDataSource,
    private val cacheDataSource: TVShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShowsList(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTvShowsList(): List<TVShow>? {
        val tvShowList=getTVShowsFromRemote()
        localDataSource.deleteTVShowsFromLocalDB()
        localDataSource.saveTVShowsToLocalDB(tvShowList)
        cacheDataSource.saveTvShowsToCache(tvShowList)
        return tvShowList
    }

    private suspend fun getTVShowsFromRemote(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            val result = remoteDataSource.getPopularTVShows()
            result.let {
                if (it.isSuccessful)
                    tvShows = it.body()!!.results
                else
                    return emptyList()
            }
        } catch (httpException: HttpException) {
            Log.e("MyTag", "getTVShowsFromRemote: ${httpException.message!!}")
        } catch (exception: Exception) {
            Log.e("MyTag", "getTVShowsFromRemote: ${exception.message!!}")
        }
        return tvShows
    }

    private suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShows: List<TVShow>

        CoroutineScope(IO).launch {
            var list = localDataSource.getPopularTVShowsFromLocalDB()
            if (list.isEmpty() || list.size < 0) {
                list = getTVShowsFromRemote()
                if (!list.isEmpty()) {
                    localDataSource.deleteTVShowsFromLocalDB()
                    localDataSource.saveTVShowsToLocalDB(list)
                }
                tvShows = list
            }

        }
        return tvShows
    }

    private suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        tvShows = cacheDataSource.getTVShowsFromCache()
        if (tvShows.isEmpty() || tvShows.size < 0) {
            tvShows = getTVShowsFromDB()
            cacheDataSource.saveTvShowsToCache(tvShows)
        }
        return tvShows
    }
}