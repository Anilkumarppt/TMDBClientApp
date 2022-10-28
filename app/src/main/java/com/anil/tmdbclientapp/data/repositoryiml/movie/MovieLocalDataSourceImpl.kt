package com.anil.tmdbclientapp.data.repositoryiml.movie

import com.anil.tmdbclientapp.data.db.MovieDao
import com.anil.tmdbclientapp.data.model.movie.Movie
import com.anil.tmdbclientapp.data.repositoryiml.movie.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(private val movieDao: MovieDao) :
    MovieLocalDataSource {
    override suspend fun getMoviesFromLocalDB(): List<Movie> {
        return movieDao.getPopularMoviesFromDB()
    }

    override suspend fun saveMoviesToLocalDB(moviesList: List<Movie>) {
        CoroutineScope(IO).launch {
            movieDao.saveMovies(moviesList)
        }

    }

    override suspend fun clearAllMovies() {
        CoroutineScope(IO).launch {  movieDao.deleteAllMovies()}

    }
}