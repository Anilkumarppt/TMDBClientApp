package com.anil.tmdbclientapp.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anil.tmdbclientapp.data.model.movie.Movie
import com.anil.tmdbclientapp.domain.useCases.GetMoviesUseCase
import com.anil.tmdbclientapp.domain.useCases.UpdateMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) :ViewModel() {

    fun getMovies()=
        liveData {
        val movies=getMoviesUseCase.execute()
        emit(movies)
    }
    fun latestMovies()= flow<List<Movie>> {
        val movies=getMoviesUseCase.execute()
        emit(movies!!)
    }.flowOn(Dispatchers.IO)
    fun updateMovies()= liveData {
        emit(updateMovieUseCase.execute())
    }
}