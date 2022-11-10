package com.anil.tmdbclientapp.data.repositoryiml.movie

import android.util.Log
import com.anil.tmdbclientapp.data.model.movie.Movie
import com.anil.tmdbclientapp.domain.repository.MoviesListRepository
import java.lang.Exception
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
    private val cacheDataSource: MoviesCacheDataSource
) : MoviesListRepository {

    override suspend fun getPopularMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListFromAPI=getMoviesFromAPI()
        localDataSource.clearAllMovies()
        localDataSource.saveMoviesToLocalDB(newListFromAPI)
        cacheDataSource.saveMoviesToCache(newListFromAPI)
        return newListFromAPI
    }

    private suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var moviesList:List<Movie>
        try {
            val result=remoteDataSource.getPopularMovies()
            result.let {
                if(it.isSuccessful){
                    moviesList=it.body()!!.results
                    moviesList.map {
                        it.posterPath="https://image.tmdb.org/t/p/w500"+it.posterPath
                    }
                }
                else
                    return emptyList()
            }
        }
        catch (exception:Exception){
            Log.e("MoviesRepo", "getMoviesFromAPI: ${exception.message}" )
        }
        return moviesList
    }
    private suspend fun getMoviesFromDB():List<Movie>{
        lateinit var moviesList:List<Movie>
        try {
            moviesList=localDataSource.getMoviesFromLocalDB()
            if(moviesList.isEmpty()){
                moviesList=getMoviesFromAPI()
                localDataSource.saveMoviesToLocalDB(moviesList)
                return moviesList
            }
        }
        catch (exception:Exception){
            Log.e("MoviesRepo", "getMoviesFromDB: ${exception.message}" )
            moviesList=ArrayList<Movie>()
        }
        return moviesList
    }
    private suspend fun getMoviesFromCache():List<Movie>{
        lateinit var moviesList:List<Movie>
        try {
            moviesList=cacheDataSource.getMoviesFromCache()
            if(moviesList.isEmpty() ||moviesList.size<0){
                moviesList=getMoviesFromDB()
                cacheDataSource.saveMoviesToCache(moviesList)
            }
            return moviesList
        }
        catch (exception:Exception){
            Log.e("MoviesRepo", "getMoviesFromAPI: ${exception.message}" )
        }
        return moviesList
    }
}