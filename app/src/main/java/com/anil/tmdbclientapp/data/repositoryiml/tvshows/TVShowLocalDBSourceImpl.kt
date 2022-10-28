package com.anil.tmdbclientapp.data.repositoryiml.tvshows

import com.anil.tmdbclientapp.data.db.TvShowsDao
import com.anil.tmdbclientapp.data.model.tvshow.TVShow
import com.anil.tmdbclientapp.data.repositoryiml.tvshows.TVShowLocalDataSource
import javax.inject.Inject

class TVShowLocalDBSourceImpl @Inject constructor(private val tvShowsDao: TvShowsDao):
    TVShowLocalDataSource {
    override suspend fun getPopularTVShowsFromLocalDB(): List<TVShow> {
        return tvShowsDao.getPopularTvShowsFromDB()
    }

    override suspend fun saveTVShowsToLocalDB(tvshows: List<TVShow>) {
        tvShowsDao.saveTvShows(tvshows)
    }

    override suspend fun deleteTVShowsFromLocalDB() {
        tvShowsDao.deleteAllTvShows()
    }

}